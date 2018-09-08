// Leetcode 807

public class IncreaseInSkyline {

	public static int maxIncreaseKeepingSkyline(int[][] grid) {
		int[] top=new int[grid.length];
		int[] left=new int[grid[0].length];


		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid.length;j++)
			{
				left[i]=Math.max(left[i], grid[i][j]);
				top[j]=Math.max(top[j], grid[i][j]);
			}
		}

		int ans=0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid.length;j++)
			{

				ans+=Math.min(left[i], top[j])-grid[i][j];
			}

		}

		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input={
				{3,0,8,4},
				{2,4,5,7},
				{9,2,6,3},
				{0,3,1,0}
		};

		System.out.println(maxIncreaseKeepingSkyline(input));
	}

}
