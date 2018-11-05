//leetcode 300

public class LongestIncreasingSubsequence {

	public static int lengthOfLIS(int[] nums) {

        int dp[]=new int[nums.length];
        int ans=1;
        dp[0]=1;
        int j;
        for(int i=1;i<nums.length;i++) {
        	j=i-1;

        	while(j>=0) {
        		if(nums[i]>nums[j])
        			dp[i]=Math.max(dp[i], dp[j]);
        		j--;
        	}

        	dp[i]++;
        	if(dp[i] > ans)
        		ans=dp[i];
        }
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));

	}

}
