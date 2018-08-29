
public class PalindromeNumber {

	public static boolean isPalindrome(int x) {

		if(x<=0)
			return x==0;

		String s=x+"";
		int end=s.length()-1, start=0;
		
		while(start<end) {
			if(s.charAt(start)!=s.charAt(end))
				return false;
			
			start++;
			end--;
		}
		return true;
	}

	public static boolean isPalindrome_1(int x) {

		if(x<0 || (x!=0 && x%10==0))
			return false;
		
		return false;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(-1211121));

	}

}

