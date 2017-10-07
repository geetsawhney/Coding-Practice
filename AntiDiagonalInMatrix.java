package matrix;

public class AntiDiagonalInMatrix {

	public static void main(String[] args) {
		
		int [][] input={{1,2,3},{4,5,6},{7,8,9}};
		
		int[][] output= getAntiDiagonal(input);
		for(int i=0;i<output.length;i++){
			for (int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j]);
			}
			System.out.println();
		}
	}

	public static int[][] getAntiDiagonal(int[][] input) {
		
		int[][] output=new int[(2*input.length)-1][input.length];
		int outputRow=0;
		for(int i=0;i<input[0].length;i++){
			int row=0;
			int column=i;
			int outputColumn=0;
			while(row<input.length && column>=0){
				output[outputRow][outputColumn]=input[row][column];
				outputColumn++;
				row++;
				column--;
			}
			outputRow++;
		}
		
		for(int i=1;i<input.length;i++){
			
			int row=i;
			int column=input.length-1;
			int outputColumn=0;
			while(row<input.length && column>=0){
				output[outputRow][outputColumn]=input[row][column];
				outputColumn++;
				row++;
				column--;
			}
			outputRow++;		
		}
		return output;
	}
}