// leetcode 21
public class MergeSortedLists {

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head=l1;

		if(l1==null)
			return l2;
		if(l2==null)
			return l1;

		ListNode temp;
		if(l1.val>l2.val)
		{
			temp=l1;
			l1=l2;
			l2=temp;
		}
		ListNode head_1=l1, prev=null;

		while(l1!=null && l2!=null) {
			if(l1.val<=l2.val) {
				prev=l1;
				l1=l1.next;
			}
			else {
				prev.next=l2;
				l2=l2.next;
				prev.next.next=l1;
				prev=prev.next;
			}
		}
		if(l2!=null) {
			prev.next=l2;
		}
		return head_1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next=new ListNode(4);
		l1.next.next=new ListNode(7);

		ListNode l2=new ListNode(2);
		l2.next=new ListNode(5);
		l2.next.next=new ListNode(8);

		ListNode head,output=mergeTwoLists(l1, l2);
		head=output;
		while(head!=null) {
			System.out.println(head.val);
			head=head.next;
		}
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
