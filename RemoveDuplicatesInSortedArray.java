//Leetcode 26
public class RemoveDuplicatesInSortedArray {


	public static int removeDuplicates(int[] nums) {
		int curr=0;
		int i=1;

		while(i<nums.length) {
			if(nums[i]!=nums[i-1]) {
				curr++;
				nums[curr]=nums[i];
			}
			i++;
		}
		return curr+1;

	}
	public static void main(String[] args) {

		System.out.println(removeDuplicates(new int[] {1,1,1,1,1,2}));
	}

}
