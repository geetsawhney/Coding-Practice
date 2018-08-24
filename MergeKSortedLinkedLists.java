import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedList {

	public static ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length+1, new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				if(o1.val<o2.val)
					return -1;
				if(o1.val>o2.val)
					return 1;
				return 0;
			}
		});
		
		for(ListNode l: lists) {
			pq.add(l);
		}
		
		ListNode head = null,tail=null, temp= null;
		
		while(!pq.isEmpty()) {
			
			temp=pq.poll();
			
			if(head == null) {
				head = temp;
				tail = head;
			}
			else {
				tail.next = temp;
				tail = temp;
			}
			if(temp.next!=null) {
				pq.add(temp.next);
			}
		}
		tail.next=null;
		
		return head;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next=new ListNode(4);
		l1.next.next=new ListNode(7);
		
		ListNode l2=new ListNode(2);
		l2.next=new ListNode(5);
		l2.next.next=new ListNode(8);
		
		ListNode l3=new ListNode(3);
		l3.next=new ListNode(6);
		l3.next.next=new ListNode(9);
		
		ListNode[] list= {l1,l2,l3};
		
		ListNode head,output=mergeKLists(list);
		head=output;
		while(head!=null) {
			System.out.println(head.val);
			head=head.next;
		}
//		System.out.println(mergeKLists(list).next.next.next.next.next.next.val);

	}

}
/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

