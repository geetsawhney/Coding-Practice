import java.util.HashSet;

public class JewelsAndStones {

	public static int numJewelsInStones(String J, String S) {
		HashSet<Character> set=new HashSet<>();
		for(int i=0;i<J.length();i++) {
			set.add(J.charAt(i));
		}
		int ans=0;

		for(int i=0;i<S.length();i++) {
			if(set.contains(S.charAt(i))){
				ans++;
			}
		}
		return ans;
	}

	// public static int numJewelsInStones_1(String J, String S) {
	//
	// 	boolean check[]=new boolean[128];
	// 	int ans=0;
	// 	for(int i=0;i<J.length();i++) {
	// 		check[J.charAt(i)]=true;
	// 	}
	//
	// 	for(int i=0;i<S.length();i++) {
	// 		if(check[S.charAt(i)])
	// 			ans++;
	// 	}
	// 	return ans;
	// }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numJewelsInStones_1("aA", "aAAbbbb"));
	}

}
