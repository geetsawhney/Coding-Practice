import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.*;

public class MovieTitles {
	/*
	 * Complete the function below.
	 */

	static String[] getMovieTitles(String substr) {


		String url= "https://jsonmock.hackerrank.com/api/movies/search/?Title="+substr+"&page=1";
		URL obj = null;
		HttpURLConnection conn = null;
		BufferedReader in = null;

		int responseCode;
		try {
			obj = new URL(url);
			conn = (HttpURLConnection) obj.openConnection();
			conn.setRequestMethod("GET");
			responseCode=conn.getResponseCode();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




		String inLine="";
		StringBuffer response=new StringBuffer();


		try {
			while((inLine=in.readLine())!=null){
				response.append(inLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int totalPages=1;
//		System.out.println(response);
		JsonParser jsonParser=new JsonParser();
		JsonObject jo=(JsonObject)jsonParser.parse(response.toString());
		totalPages=jo.get("total_pages").getAsInt();
//		System.out.println(totalPages);

		int per_Page=jo.get("per_page").getAsInt();
		JsonArray ja=jo.getAsJsonArray("data");

		ArrayList<String> ans=new ArrayList<>();

		for(JsonElement je:ja) {
//			System.out.println(je);
			ans.add(((JsonObject)je).get("Title").toString());
		}

		for(int i=2;i<=totalPages;i++) {
			try {
				obj = new URL(url);
				conn = (HttpURLConnection) obj.openConnection();
				conn.setRequestMethod("GET");
				responseCode=conn.getResponseCode();
				in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			inLine="";
	        response=new StringBuffer();
	        
	        
	        try {
				while((inLine=in.readLine())!=null){
				    response.append(inLine);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
//	        System.out.println(response+"22222");
	        jsonParser=new JsonParser();
			jo=(JsonObject)jsonParser.parse(response.toString());
			ja=jo.getAsJsonArray("data");
			
			for(JsonElement je:ja) {
//				System.out.println(je);
				ans.add(((JsonObject)je).get("Title").toString());
			}
			
		}




		String[]sol = new String[ans.size()];

		return ans.toArray(sol);


	}

	public static void main(String args[]) {
		System.out.println(getMovieTitles("spiderman"));

	}
}

