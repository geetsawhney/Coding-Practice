
public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {

		String out="";

		try {
			for(int i=0;i<strs[0].length();i++) {
				char c=strs[0].charAt(i);
				for(String s:strs) {
					if(s.charAt(i)!=c)
						return out;
				}
				out+=c;
			}
		}catch(Exception e) {
			return out;
		}
		return out;
	}

	public static String longestCommonPrefix_2(String[] strs) {

		if(strs.length==0) {
			return "";
		}

		String out=strs[0];

		for(String s:strs) {

			while(s.indexOf(out)!=0) {
				out=out.substring(0,out.length()-1);
			}
		}

		return out;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] input= {"leet","lee","leetcode","leeters"};
		System.out.println(longestCommonPrefix_2(input));

	}

}
