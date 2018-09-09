public class CheckSubsequence {

	public static boolean isSubsequence(String word, String check) {

		if(check.length()==0)
			return true;
		if(word.length()==0)
			return false;
		if(word.charAt(0)==check.charAt(0))
			return isSubsequence(word.substring(1), check.substring(1));
		else
			return isSubsequence(word.substring(1), check);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isSubsequence("abcdef","aed"));

	}

}
