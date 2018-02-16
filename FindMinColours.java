import java.util.LinkedList;
import java.util.Queue;

public class FindMinColours {

	public static int solution(int input[][]){
		
		boolean visited[][]=new boolean[input.length][input[0].length];
		
		Queue<Integer> queue=new LinkedList<>();
		int count=0;
		
		for(int i=0; i<input.length;i++){
			
			for(int j=0;j<input[0].length;j++){
				
				if(visited[i][j])
					continue;
				
				queue.add(i);
				queue.add(j);
				
				count++;
				
				while(!queue.isEmpty()){
					
					int row=queue.poll();
					int col=queue.poll();
					
					visited[row][col]=true;
					
					if((row-1>=0) && !visited[row-1][col] && (input[row-1][col]==input[row][col])){
						queue.add(row-1);
						queue.add(col);
					}
					
					if((row+1)<input.length && !visited[row+1][col] && (input[row+1][col]==input[row][col])){
						queue.add(row+1);
						queue.add(col);
					}
					
					if((col-1)>=0 && !visited[row][col-1] && (input[row][col-1]==input[row][col])){
						queue.add(row);
						queue.add(col-1);
					}
					
					if(col+1<input[0].length && !visited[row][col+1] && (input[row][col+1]==input[row][col])){
						queue.add(row);
						queue.add(col+1);
					}
					
				}
			}
			
		}
		
		return count;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int input[][]={{5,4,4},{4,3,4},{3,2,4},{2,2,2},{3,3,4},{1,4,4},{4,1,1}};
		System.out.println(solution(input));
		
		
		

	}

}
