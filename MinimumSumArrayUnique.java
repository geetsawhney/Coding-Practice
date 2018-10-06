package assessment;

import java.util.*;

public class MinimumSumArrayUnique {

	public static int getMinimumUniqueSum(int[] arr) {
		if(arr.length==0) {
			return 0;
		}
		int ans=0;
		Set<Integer> values=new HashSet<>();
		int num;
		for(int i=0;i<arr.length;i++) {
			num=arr[i];
			ans+=num;
			if(values.contains(num)) {
				while(values.contains(num)) {
					ans++;
					num++;
				}
				values.add(num);
			}else {
				values.add(num);
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,2};
		System.out.println(getMinimumUniqueSum(arr));
	}

}
