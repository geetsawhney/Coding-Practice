import java.util.HashSet;

public class FindPairWithSum {

	public static boolean isPairWithSumPresentSorted(int[] input, int sum){
		int i=0;
		int j=input.length-1;
		
		while(i<j){
			if(input[i]+input[j]==sum)
				return true;
			if(input[i]+input[j]>sum)
				j--;
			else
				i++;
		}
		return false;
	}


	private static boolean isPairWithSumPresent(int[] input, int sum) {
		HashSet<Integer> hashSet=new HashSet<>();
		for(int i=0;i<input.length;i++)
		{
			if(hashSet.contains(sum-input[i]))
				return true;
			hashSet.add(input[i]);
		}
		return false;
	}

	public static void main(String[] args) {

		int input[]={1,6,10,14,15};

		System.out.println(isPairWithSumPresent(input, 10));
		System.out.println(isPairWithSumPresentSorted(input, 10));
	}

}
