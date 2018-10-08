//Leetcode 76
public class MinimumWindowSubstring {

	public static String minWindow(String s, String t) {


		int remaining=t.length();	// remaining elements required to tell if a substring matches or not
		int start=0;	// current start index of substringh being checked
		int end=0;	// current end index
		int minStart=0;	// start index of substring that fulfills the requirements
		int minEnd=0;	// end index of a substring that matches
		int minLength=Integer.MAX_VALUE;	//to keep track of minLength answer

		// if t is of size 0 or length of s is less than t
		if(remaining==0 || s.length()<t.length())
			return "";

		// if only one element in t, then return "" if found else return t
		if(t.length()==1) {
			int pos= s.indexOf(t);
			if(pos==-1)
				return "";
			return t;
		}


		int[] required=new int[256]; //keep track of characters required to fulfill
		int[] found=new int[256];  //keep track of elements currently being examined

		// adding all elements frequency to required
		for(int i=0;i<t.length();i++) {
			required[t.charAt(i)]++;
		}


		char c;
		// run loop till end of string or remaining elements equal to zero
		// we expand to right and when find our required characters, we shring from
		// left to minimize the substring length that matches the requirements
		while(end<s.length() || remaining==0) {

			// if remaining is 0, then we shrink from left, by incrementing start
			if(remaining==0) {
				c=s.charAt(start);
				start++;

				if(found[c]!=0) {
					found[c]--;
					if(found[c]<required[c])
						remaining++;
				}

			}
			// else we expand to right, by incrementing end
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

			// when requirements match and length of current substring is less than last matching substring
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
