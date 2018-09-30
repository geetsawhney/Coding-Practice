import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ThreeSumEqualZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));

	}

	public static List<List<Integer>> threeSum(int[] nums) {

		HashSet<List<Integer>> set=new HashSet<>();
		List<List<Integer>> ans= new LinkedList<>();
		if(nums.length<3) {
			return ans;
		}

		Arrays.sort(nums);
		int negStart=0;
		int next,end;


		while(negStart <= nums.length-3 && nums[negStart] < 0) {
			next=negStart+1;
			end=nums.length-1;

			while(next<end) {

				if(nums[negStart]+nums[next]+nums[end]==0) {
					set.add(new ArrayList<Integer>(Arrays.asList(nums[negStart],nums[next],nums[end])));
					next++;
				}
				else if(nums[negStart]+nums[next]+nums[end]<0) {
					next++;
				}else {
					end--;
				}
			}
			negStart++;
		}
		int zeroes=0;
		for(int i=negStart;nums[i]==0 && i < nums.length  ; i++) {
			zeroes++;
		}
		if(zeroes>2)
		{
			set.add(new ArrayList<Integer>(Arrays.asList(0,0,0)));
		}

		ans.addAll(set);

		return ans;

	}

}
