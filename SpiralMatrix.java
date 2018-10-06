//leetcode 54

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> ans=new ArrayList<Integer>();
		if(matrix.length == 0 || matrix[0].length==0) {
			return ans;
		}
		spiralOrder(matrix,ans,0,matrix.length-1,0,matrix[0].length-1);
		return ans;

	}

	public static void spiralOrder(int[][] matrix, List<Integer> ans, int top, int bottom, int left, int right ) {

		System.out.println();
		System.out.println(top+" "+bottom+" "+left+" "+right);

		if(top>bottom || left>right)
			return;

		for(int i= left; i<=right; i++) {
			ans.add(matrix[top][i]);
		}
		top++;

		for(int i=top;i<=bottom;i++) {
			ans.add(matrix[i][right]);
		}
		right--;

		for(int i=right;i>=left && top<=bottom;i--) {
			ans.add(matrix[bottom][i]);
		}
		bottom--;

		for(int i=bottom;i>=top && left<=right;i--) {
			ans.add(matrix[i][left]);
		}
		left++;
		spiralOrder(matrix, ans, top, bottom, left, right);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//		int[][] array={{1,2,3,4,5},{14,15,16,17,6},{13,20,19,18,7},{12,11,10,9,8}};
		int[][] array={{1},{2},{3},{4}};

		System.out.println(spiralOrder(array));
	}

}
