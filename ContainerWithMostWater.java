
//Leetcode 11
public class ContainerWithMostWater {

	public static int maxArea(int[] height) {
		int start=0;
		int end=height.length-1;
		int maxVal=Integer.MIN_VALUE;
		while(start<end) {
			maxVal=Math.max(maxVal, (Math.min(height[start], height[end]))*(end-start));
			if(height[start] < height[end]) {
				start ++;
			}else {
				end--;
			}
		}
		return maxVal;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));

	}

}
