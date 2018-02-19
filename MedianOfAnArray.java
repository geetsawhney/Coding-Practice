
public class MedianOfAnArray {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int i=0,j=0;
		int common[]=new int[nums1.length+nums2.length];
		int k=0;
		while(i<nums1.length &&j<nums2.length){
			if(nums1[i]<nums2[j]){
				common[k]=nums1[i];
				k++;
				i++;
			}
			else{
				common[k]=nums2[j];
				j++;
				k++;
			}
		}

		while(i<nums1.length){
			common[k]=nums1[i];
			k++;
			i++;
		}
		while(j<nums2.length){
			common[k]=nums2[j];
			j++;
			k++;
		}
		int output=0;
		if(common.length%2==0){
			output=common[common.length/2]+common[(common.length/2)-1];
			return output/2;
		}
		return common[common.length/2];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums1={1,2};
		int nums2[]={3,4};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

}
