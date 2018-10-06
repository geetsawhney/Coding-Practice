//leetcode 120

import java.util.*;

public class Triangles {

	public static int minimumTotal(List<List<Integer>> triangle) {

		if(triangle.size()==0)
			return 0;
		if(triangle.size()==1)
			return triangle.get(0).get(0);

		int[][] dp=new int[triangle.size()][triangle.size()];

		for(int i=0;i<triangle.size();i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}

		return minimumTotalHelper(triangle,0,0,dp);
	}


	// exponential solution
	private static int minimumTotalHelper(List<List<Integer>> triangle, int row,int col) {
		if(row==triangle.size() || col > row)
			return 0;
		int min=Integer.MAX_VALUE;
		min=Math.min(min, triangle.get(row).get(col)+Math.min(minimumTotalHelper(triangle, row+1, col), minimumTotalHelper(triangle, row+1, col+1)));
		return min;
	}

	private static int minimumTotalHelper(List<List<Integer>> triangle, int row,int col,int[][]dp) {
		if(row==triangle.size())
			return 0;
		if(dp[row][col]!=Integer.MAX_VALUE)
			return dp[row][col];

		dp[row][col]=Math.min(dp[row][col], triangle.get(row).get(col)+Math.min(minimumTotalHelper(triangle, row+1, col,dp), minimumTotalHelper(triangle, row+1, col+1,dp)));
		return dp[row][col];
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> triangle= new ArrayList<List<Integer>>();

		triangle.add(new ArrayList<>(Arrays.asList(2)));
		triangle.add(new ArrayList<>(Arrays.asList(3,4)));
		triangle.add(new ArrayList<>(Arrays.asList(6,5,7)));
		triangle.add(new ArrayList<>(Arrays.asList(4,1,8,3)));

		System.out.println(minimumTotal(triangle));
	}

}
