import java.util.Comparator;
import java.util.PriorityQueue;

public class GetKClosestElementToTheNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[]= {5,6,10,1,8,9};
		int output[]=getKClosest(input,2,7);
		
		for(int number : output)
			System.out.println(number);

	}

	private static int[] getKClosest(int[] input, int k, int num) {
		// TODO Auto-generated method stub
		
		PriorityQueue<Element> maxHeap=new PriorityQueue<>(k,new Comparator<Element>() {

			@Override
			public int compare(Element o1, Element o2) {
				// TODO Auto-generated method stub
				return o2.distance-o1.distance;
			}
			
		});
		
		int i=0;
		for(;i<k;i++) {
			maxHeap.add(new Element(input[i], Math.abs(input[i]-num)));
		}
		
		for(;i<input.length;i++) {
			if(Math.abs(input[i]-num)<Math.abs(maxHeap.peek().distance)) {
				maxHeap.poll();
				maxHeap.add(new Element(input[i], Math.abs(input[i]-num)));
			}
		}
		int output[]=new int[k];
		
		for(int j=0;j<k;j++) {
			output[j]=maxHeap.poll().element;
		}
		return output;
	}

}

class Element{
	int element;
	int distance;
	
	public Element(int e,int d) {
		element=e;
		distance=d;
	}
	
}
