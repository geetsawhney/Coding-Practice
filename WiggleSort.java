import java.util.Arrays;

public class WiggleSort {

	public static void wiggleSort(int nums[]) {
		if(nums.length<3)
		{
			Arrays.sort(nums);
			return;
		}

		for(int i=0;i<nums.length-1;i+=2) {

			if(i-1>=0 && nums[i]>nums[i-1]) {
				swap(nums,i,i-1);
			}
			if(i+1<nums.length && nums[i]>nums[i+1]) {
				swap(nums,i,i+1);
			}
		}
		for(int x:nums) {
			System.out.println(x);
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		wiggleSort(new int[] {3,2,1,6,9,4,5});
	}
}
