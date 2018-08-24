import static org.junit.Assert.assertArrayEquals;

public class MergeSortedArray {

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		
		int i=m-1;
		int j=n-1;
		int end=m+n-1;
		while(i>=0 && j>=0) {
			if(nums1[i]>nums2[j]) {
				nums1[end]=nums1[i];
				end--;
				i--;
			}
			else {
				nums1[end]=nums2[j];
				end--;
				j--;
			}
		}
		
		while(j>=0) {
			nums1[end]=nums2[j];
			end--;
			j--;
		}
		while(i>=0) {
			nums1[end]=nums1[i];
			end--;
			i--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums1= {1,2,3,0,0,0};
		int[] nums2= {2,5,6};
		int m =3;
		int n =3;
		int[] expected={1,2,2,3,5,6};
		merge(nums1, m, nums2, n);
		assertArrayEquals(expected, nums1);
	}

}
