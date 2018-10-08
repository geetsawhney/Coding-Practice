//Leetcode 76
public class MinimumWindowSubstring {

	public static String minWindow(String s, String t) {

		int remaining=t.length();
		int start=0;
		int end=0;
		int minStart=0;
		int minEnd=0;
		int minLength=Integer.MAX_VALUE;

		if(remaining==0 || s.length()<t.length())
			return "";

		if(t.length()==1) {
			int pos= s.indexOf(t);
			if(pos==-1)
				return "";
			return t;
		}

		int[] required=new int[256];
		int[] found=new int[256];

		for(int i=0;i<t.length();i++) {
			required[t.charAt(i)]++;
		}


		char c;
		while(end<s.length() || remaining==0) {


			if(remaining==0) {
				c=s.charAt(start);
				start++;

				if(found[c]!=0) {
					found[c]--;
					if(found[c]<required[c])
						remaining++;
				}

			}
			else {
				c=s.charAt(end);
				if(required[c]!=0) {
					found[c]++;
					if(found[c]<=required[c]) {
						remaining--;
					}
				}
				end++;
			}

			if(remaining==0 && minLength>(end-start)) {
				minLength=end-start;
				minStart=start;
				minEnd=end;
			}

		}

		return minLength==Integer.MAX_VALUE?"":s.substring(minStart,minEnd);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(minWindow("ADOBECODEBANC", "ABC"));

	}

}
