// Leetcode 62

public class UniquePaths {
	public static long uniquePaths(int m, int n) {
		int totalMoves=m+n-2;
		long ans=1;
		int max=Math.max(m-1,n-1);
		int min=Math.min(m-1,n-1);
		int i=1;
		for(;totalMoves-max>=1;totalMoves--){
			ans*=totalMoves;

			if(i<=min){
				ans/=i;
				i++;
			}
			System.out.println(totalMoves + " " + i);

		}
		System.out.println(ans);


		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(uniquePaths(58, 9));

	}

}
