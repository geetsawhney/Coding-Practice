package matrix;

import java.util.ArrayList;
import java.util.HashSet;

public class ZeroMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] input={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
//		int[][] input={{1,2},{3,4}};
		
		zeroMatrix(input);
		for(int i=0;i<input.length;i++){
			for (int j = 0; j < input[i].length; j++) {
				System.out.print(input[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void zeroMatrix(int[][] input) {
		HashSet<Integer>rows=new HashSet<>();
		HashSet<Integer>col=new HashSet<>();
		
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input[0].length;j++){
				if(input[i][j]==0){
					rows.add(i);
					col.add(j);
				}		
			}
		}
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input[i].length;j++){
				if(rows.contains(i) || col.contains(j))
					input[i][j]=0;
			}
		}
	}

}
