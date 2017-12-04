package matrix;

public class RotateBy90Degree {

	public static void main(String[] args) {

		int[][] input={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
//		int[][] input={{1,2},{3,4}};
		int[][] output=rotateMatrixBy90(input);
		rotateMatrixBy90InPlace(input);
		
		for(int i=0;i<output.length;i++){
			for (int j = 0; j < output[i].length; j++) {
				System.out.print(input[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void rotateMatrixBy90InPlace(int[][] input){
		
		int temp=0;
		for(int l=0;l<input.length/2;l++){
			int last=input.length-1-l;
			
			for(int i=l;i<last;i++){
				
				temp=input[l][i];
				input[l][i]=input[last-i+l][l];
				input[last-i+l][l]=input[last][last-i+l];
				input[last][last-i+l]=input[i][last];
				input[i][last]=temp;
			
			}
			
		}
		
	}
	private static int[][] rotateMatrixBy90(int[][] input) {
		int[][]output=new int[input.length][input.length];
		
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input[0].length;j++){
				output[j][input.length-i-1]=input[i][j];
			}
		}
		return output;
	}

}
