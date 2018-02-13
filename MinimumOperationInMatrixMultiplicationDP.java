

public class MinimumOperationInMatrixMultiplicationDP {
	
	
	// calculating using dynamic programming using recursion(memoization)
	private static int minOperations_2(int a[],int startIndex,int endIndex,int output[][])
	{
		if(startIndex>=endIndex-1)
			return 0;
		
		if(output[startIndex][endIndex]>0)
		{
			return output[startIndex][endIndex];
		}

		int min=Integer.MAX_VALUE;
		
		for(int i=startIndex+1;i<endIndex;i++)
		{
			int option=(minOperations_2(a, startIndex,i,output)+minOperations_2(a, i, endIndex,output))+a[startIndex]*a[i]*a[endIndex];
			
			if(option<min)
				min=option;
		}
		output[startIndex][endIndex]=min;
		return output[startIndex][endIndex];
	}

	public static int minOperations_2(int[] a)
	{
		return minOperations_2(a, 0, a.length-1,new int[a.length][a.length] );
	}
	
	// iteratively calculating operations in  minimum chain multiplication(bottom up)
	public static int minOperations_3(int [] a)    
	{
		int [][] dp=new int[a.length][a.length];
		
		for(int startCol=2;startCol< a.length;startCol++)
		{
			for(int p=0;startCol+p<a.length;p++)
			{
				int i=p;
				int j=startCol+p;
				int bestOption=Integer.MAX_VALUE;
				for(int k=i+1;k<j;k++)
				{
					int option=dp[i][k]+dp[k][j]+a[i]*a[j]*a[k];
					if (option < bestOption)
						bestOption = option;
				}

				dp[i][j] = bestOption;
			}
		}
		return dp[0][a.length-1];
	}

	public static void main(String[] args) {

		int a[]={20,10,5,60,2,44,12,45,45,34,7,8,9,9,9,8,34,80,8,4};

		System.out.println(minOperations_3(a));
		System.out.println(minOperations_2(a));

	}
}