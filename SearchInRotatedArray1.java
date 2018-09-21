
public class SearchInRotatedArray1 {

	public static int search(int[] nums, int target) {

		if(nums.length==1) {
			if(nums[0]==target)
				return 0;
			return -1;
		}
		int first=0,last=nums.length-1;
		int mid;
		while(first<last) {
			mid=(first+last)/2;
			if(nums[mid]==target)
				return mid;
			if(nums[first]==target)
				return first;
			if(nums[last]==target)
				return last;

			if(nums[first]<nums[mid]) {
				if(target<=nums[mid] && target>=nums[first]) {
					return binarySearch(nums, target, first, mid);
				}else {
					first=mid+1;
				}
			}
			else {
				if(target>=nums[mid] && target<=nums[last]) {
					return binarySearch(nums, target, mid, last);
				}else {
					last=mid-1;
				}
			}
		}

		return -1;
	}


	public static int binarySearch(int[] nums, int target, int start, int end) {
		if(start==end && nums[start]!=nums[end]) {
			return -1;
		}
		int mid;


		while(start<=end) {
			mid=(start+end)/2;
			if(nums[mid]==target)
				return mid;
			if(start==end)
				return -1;
			if(nums[mid]<target) {
				start=mid+1;
			}
			else {
				end=mid-1;
			}

		}

		return -1;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int input[]= {3,1};
		System.out.println(search(input,1));



	}

}
