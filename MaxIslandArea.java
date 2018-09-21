//Leetcode 395
public class MaxIslandArea {

	public static int maxAreaOfIsland(int[][] grid) {
		if(grid.length==0 || grid[0].length==0)
			return 0;
		boolean[][] visited=new boolean[grid.length][grid[0].length];
		int area=0;

		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {

				if(visited[i][j] || grid[i][j]==0)
					continue;
				area=Math.max(area, maxArea(grid, visited, i, j));
			}
		}

		return area;
	}

	private static int maxArea(int[][]grid, boolean[][]visited, int i, int j) {

		visited[i][j]=true;

		int up=0;
		int down=0;
		int left=0;
		int right=0;

		if(i-1>=0 && grid[i-1][j]!=0 && !visited[i-1][j]) {
			up=maxArea(grid, visited, i-1, j);
		}
		if(i+1<grid.length && grid[i+1][j]!=0 && !visited[i+1][j]) {
			down=maxArea(grid, visited, i+1, j);
		}
		if(j-1>=0 && grid[i][j-1]!=0 && !visited[i][j-1]) {
			left=maxArea(grid, visited, i, j-1);
		}
		if(j+1<grid[0].length && grid[i][j+1]!=0 && !visited[i][j+1]) {
			right=maxArea(grid, visited, i, j+1);
		}
		return 1+up+down+left+right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] input= {
				{0,0,1,0,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,1,1,0,1,0,0,0,1,0,0,0,0},
				{0,1,0,0,1,1,0,0,1,0,1,0,0},
				{0,1,0,0,1,1,0,0,1,1,1,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,1,1,0,0,0,0}
		};

		System.out.println(maxAreaOfIsland(input));

	}

}
