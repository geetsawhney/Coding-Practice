
public class OneEditApart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isOneEditApart("abcd","abbd"));

	}

	private static boolean isOneEditApart(String s1, String s2) {
		if(s1.equals(s2))
			return false;
		return isOneEditApart(s1,s2,0);
	}

	private static boolean isOneEditApart(String s1, String s2, int edits) {

		if(s1.length()==0) {
			if(s2.length()==1 && edits==0)
				return true;
			if(s2.length()==0 && edits==1)
				return true;
			return false;
		}
		if(s2.length()==0) {
			if(s1.length()==1 && edits==0)
				return true;
			return false;
		}

		if(s1.charAt(0)==s2.charAt(0))
			return isOneEditApart(s1.substring(1), s2.substring(1), edits);

		if(s1.length()==s2.length())
			return isOneEditApart(s1.substring(1), s2.substring(1), edits+1);

		return s1.length()>s2.length() ?
				isOneEditApart(s1.substring(1), s2, edits+1) :
					isOneEditApart(s1, s2.substring(1), edits+1);
	}

}
