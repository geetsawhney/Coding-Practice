import java.util.Arrays;

public class MinimumPathSum {

	//bottom up DP
	public static int minPathSum(int[][] grid) {
        int dp[][]=new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];

        for(int i=1;i<grid[0].length;i++) {
        	dp[0][i]=dp[0][i-1]+grid[0][i];
        }

        for(int i=1;i<grid.length;i++) {
        	dp[i][0]=dp[i-1][0]+grid[i][0];
        }

        for(int i=1;i<grid.length;i++) {
        	for(int j=1;j<grid[0].length;j++){
        		dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
        	}
        }

        return dp[grid.length-1][grid[0].length-1];

    }

	// top down
	// public static int minPathSum_1(int[][] grid) {
	// 	int dp[][]=new int[grid.length][grid[0].length];
	//
	// 	for(int[] aDP:dp) {
	// 		Arrays.fill(aDP, -1);
	// 	}
	// 	dp[0][0]=grid[0][0];
	// 	return minPathSum(grid,dp, grid.length-1,grid[0].length-1);
	// }
	//
	// private static int minPathSum(int[][] grid, int[][] dp, int i, int j) {
	//
	// 	if(i<0 || j < 0)
	// 		return Integer.MAX_VALUE;
	//
	// 	if(dp[i][j]!=-1)
	// 		return dp[i][j];
	//
	// 	dp[i][j]=Math.min(minPathSum(grid, dp, i-1, j), minPathSum(grid, dp, i, j-1))+grid[i][j];
	//
	// 	return dp[i][j];
	//
	// }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] grid=new int[][] {{1,3,1},{1,5,1},{4,2,1}};

		System.out.println(minPathSum_1(grid));


	}

}
