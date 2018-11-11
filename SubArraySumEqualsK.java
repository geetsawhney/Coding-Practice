
//leetcode 560
public class SubArraySumEqualsK {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(subarraySum(new int[]{1,1,1,3}, 2));

	}

	public static int subarraySum(int[] nums, int k) {

		int sum[]=new int[nums.length+1];
		int count=0;

		for(int i=1;i<sum.length;i++) {
			sum[i]=sum[i-1]+nums[i-1];
		}

		for(int i=0;i<sum.length-1;i++) {
			for(int j=i+1;j<sum.length;j++) {
				if(sum[j]-sum[i]==k)
					count++;
			}
		}

		return count;
	}

}
