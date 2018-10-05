//Leetcode 78
import java.util.*;

public class Subsets {

	public static List<List<Integer>> subsets(int[] nums) {
		if(nums.length==0) {
			return new ArrayList<List<Integer>>();
		}
		return subsetsHelper(nums,0);
	}
	private static List<List<Integer>> subsetsHelper(int[] nums, int start) {
		// TODO Auto-generated method stub
		if(start==nums.length) {
			ArrayList<List<Integer>> out=new ArrayList<>();
			out.add(new ArrayList<>());
			return out;
		}

		List<List<Integer>> child=subsetsHelper(nums, start+1);
		List<List<Integer>> ans=new ArrayList<List<Integer>>(child);
		ArrayList<Integer> row;
		for(int i=0;i<child.size();i++) {
			row=new ArrayList<>();
			for(int j=0;j<child.get(i).size();j++) {
				row.add(child.get(i).get(j));
			}
			row.add(nums[start]);
			ans.add(row);
		}


		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] input= {1,2,3};

		System.out.println(subsets(input));

	}

}
