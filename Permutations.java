import java.util.LinkedList;
import java.util.List;

//Leetcode 46
public class Permutations {

	public static List<List<Integer>> permute(int[] nums) {

		return permute(nums, 0);
	}

	public static List<List<Integer>> permute(int[] nums, int start){

		List<List<Integer>> output=new LinkedList<>();
		List<Integer> row;

		if(start>=nums.length){
			return output;
		}

		List<List<Integer>> child = permute(nums, start+1);
//		System.out.println("child" + child.size());

		int index;
		for(int i=0;i<child.size();i++) {
			index=0;
			for(int j=0;j<child.get(i).size()+1;j++) {
				row=new LinkedList<>();
				for(int k=0;k<child.get(i).size();k++) {
					row.add(child.get(i).get(k));
				}
				if(index>=row.size()) {
					row.add(nums[start]);
				}
				else
					row.add(index, nums[start]);
				index++;
				output.add(row);
			}
		}

		if( child.size()==0 ) {
			output.add(new LinkedList<>());
			output.get(0).add(nums[start]);
		}

		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(permute(new int[] {5,4,6,1}).size());

	}

}
