
public class BalancedSum {

	public static void main(String[] args) {
			
		int arr[]={1,2,3,3,6};
		System.out.println(getBalancedSum(arr));
		
		
	}

	private static int getBalancedSum(int[] arr) {
		// TODO Auto-generated method stub
		
		int sumBefore=arr[0];
		int sumAfter=0;
		
		for(int i=2;i<arr.length;i++){
			sumAfter+=arr[i];
		}
		
		for(int i=1;i<arr.length-1;i++){
			if(sumAfter==sumBefore)
				return i;
			
			sumAfter-=arr[i+1];
			sumBefore+=arr[i];
			
		}
		
		return 0;
	}
	
	

}
