
public class MergeString {
	
	
	 static String mergeStrings(String a, String b) {
		 
		 
	        StringBuilder ans= new StringBuilder();
	        int x=a.length();
	        int y=b.length();
	        int i=0;
	        int j=0;
	        while(i<x && j<y){
	   
	                ans.append(a.charAt(i));
	                i++;
	                ans.append(b.charAt(j));
	                j++;
	            
	        }
	        
	        if(i==x && j!=y){
	            ans.append(b.substring(j));
	        }
	        if(j==y && i!=x){
	            ans.append(a.substring(i));
	        }
	        
	        return ans.toString();

	    }
	 
	public static void main(String[] args) {

		
		System.out.println(mergeStrings("abc","def"));

	}

}
