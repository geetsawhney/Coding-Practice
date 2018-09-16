//Leetcode 189
public class RotateArrayByK {

	public static void rotate(int[] nums, int k) {

		int arr[]=new int[nums.length];

		k=k%nums.length;
		int i=0;
		for(int j=nums.length-k;j<nums.length;j++) {
			arr[i++]=nums[j];
		}
		for(int j=0;j<nums.length-k;j++) {
			arr[i++]=nums[j];
		}

		for(i=0;i<nums.length;i++)
		{
			nums[i]=arr[i];
		}
	}
	
	public static void rotate_1(int[] nums, int k) {
		k=k%nums.length;
		reverse(nums, 0, nums.length-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length-1);
	}

	private static void reverse (int[]nums, int start, int end) {

		int temp;
		while(start<end) {
			temp=nums[start];
			nums[start]=nums[end];
			nums[end]=temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] input= {1,2,3,4,5,6,7};
		rotate_1(input, 3);
		for(int n: input) {
			System.out.println(n);
		}

	}

}
