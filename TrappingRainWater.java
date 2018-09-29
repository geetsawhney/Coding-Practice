// Leetcode 46
public class TrappingRainWater {

	public static int trap(int[] height) {
		int ans=0;

		int len=height.length-1;
		int[] left=new int[len+1];
		int[] right=new int[len+1];

		left[0]=height[0];
		right[len]=height[len];

		for(int i=1; i<=len;i++) {
			left[i]=Math.max(left[i-1], height[i]);
			right[len-i]=Math.max(right[len-i+1], height[len-i]);
		}

		for(int i=0;i<=len;i++) {
			ans+=Math.min(left[i], right[i]) - height[i];
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] height= {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));


	}

}
