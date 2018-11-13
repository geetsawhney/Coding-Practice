
//leetcode 724
public class FindPivotIndex {
	public static int pivotIndex(int[] nums) {

		int[] leftSum= new int[nums.length];
		int[] rightSum= new int[nums.length];

		for(int i=1;i<nums.length;i++){
			leftSum[i] = leftSum[i-1]+nums[i-1];
			rightSum[nums.length-i-1] = rightSum[nums.length-i]+ nums[nums.length-i];
		}

		for(int i=0;i<nums.length;i++){
			if(leftSum[i]==rightSum[i])
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pivotIndex(new int[] {3,1,1,1,3}));

	}
}
