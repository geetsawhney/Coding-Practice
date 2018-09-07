import java.util.LinkedList;
import java.util.List;

public class MobileKeyPad {

	static String[] mapping= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

	public static List<String> letterCombinations(String digits) {
		List<String> output = new LinkedList<>();
		if(digits.length()==0)
		{
			output.add("");
			return output;
		}

		List<String> small=letterCombinations(digits.substring(0,digits.length()-1));
		String keys=mapping[digits.charAt(digits.length()-1)-'0'];

		for(String x:small) {
			for(int i=0;i<keys.length();i++) {
				output.add(x+keys.charAt(i));
			}
		}

		return output;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(letterCombinations("266"));

	}

}
