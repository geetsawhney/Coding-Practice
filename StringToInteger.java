
public class StringToInteger {

	public static int myAtoi(String str) {

		String numbers="0123456789";
		boolean isStarted=false;
		char c;
		boolean isNegative=false;
		int ans=0;
		long temp;
		for(int i=0;i<str.length();i++) {
			c=str.charAt(i);

			if(numbers.indexOf(c) == -1) {
				if(!isStarted) {
					if(c=='-' || c=='+') {
						isNegative= c=='-';
						isStarted=true;
					}
					else
						if(c!=' ')
							return isNegative?-ans:ans;
					continue;
				}
				else {
					break;
				}
			}
			else {
				isStarted=true;
				temp=(long)(ans)*10+(c-'0');
				if( temp > Integer.MAX_VALUE)
					return isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
				ans=ans*10+(c-'0');
			}
		}

		return isNegative?-ans:ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(myAtoi("-6147483648"));

	}

}
