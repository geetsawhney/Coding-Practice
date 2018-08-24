import java.util.PriorityQueue;

public class FindKLargestElement {

	public static int findKthLargest(int[] nums, int k) {


		PriorityQueue<Integer> pq=new PriorityQueue<>();
		int i=0;
		for (;i<k;i++) {
			pq.add(nums[i]);
		}
		
		for(;i<nums.length;i++) {
			pq.add(nums[i]);
			pq.poll();
		}
		return pq.peek();

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[]= {5,6,10,1,8,9};

		System.out.println(findKthLargest(input,5));

	}

}
