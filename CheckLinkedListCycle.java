// leetcode 141
import java.util.HashSet;


public class CheckLinkedListCycle {

	public static boolean hasCycle(ListNode head) {
		HashSet<ListNode> nodes=new HashSet<>();

		while(head!=null) {
			if(nodes.contains(head))
				return true;
			nodes.add(head);
			head=head.next;
		}
		return false;
	}

	public static boolean hasCycle_1(ListNode head) {
		if(head==null)
			return false;
		ListNode fast=head;
		ListNode slow=head;

		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			if(fast!=null && fast.equals(slow))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(10);
		head.next=new ListNode(20);
		head.next.next=new ListNode(30);
		//		head.next.next.next=head.next;
		System.out.println(hasCycle(head));

	}

}
