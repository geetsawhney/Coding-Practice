
public class ReverseString {

	public static String reverseString(String s) {
        StringBuilder out=new StringBuilder(s);
        int len=s.length();
        char c;
        for(int i=0;i<s.length()/2;i++){
        	c=s.charAt(i);
            out.setCharAt(i, out.charAt(len-i-1));
            out.setCharAt(len-i-1, c);
        }
        return out.toString();

    }

	public static String reverseString_1(String s) {
        String out="";
        System.out.println(s.length());
        for(int i=0;i<s.length();i++){
            out=s.charAt(i)+out;
        }
        return out;
    }

	public static String reverseString_2(String s) {
		char[] sArr=s.toCharArray();
		int start=0;
		int end=s.length()-1;
		char c;
		while(start<end) {
			c=sArr[start];
			sArr[start]=sArr[end];
			sArr[end]=c;
			start++;
			end--;
		}

		return new String(sArr);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(reverseString_2("Geet Sawhney"));
	}

}
