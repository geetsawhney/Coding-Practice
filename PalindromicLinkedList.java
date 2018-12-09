package assessment;

public class PalindromicLinkedList {

	public static boolean isPalindrome(ListNode head) {
		if(head==null || head.next==null)
			return true;

		ListNode mid=head,fast=head;

		while(fast.next!=null && fast.next.next!=null){
			mid=mid.next;
			fast=fast.next.next;
		}

		ListNode rev = reverse(mid.next),tail=rev, curr=head;

		boolean ans=true;
		while(curr!=null && tail!=null){
			if(curr.val!=tail.val){
				ans=false;
				break;
			}
			curr=curr.next;
			tail=tail.next;
		}
		mid.next=reverse(rev);

		return ans;
	}

	public static ListNode reverse(ListNode head){

		if(head==null)
			return null;
		ListNode child= reverse(head.next);
		if(child == null)
		{
			return head;
		}
		head.next.next=head;
		head.next=null;
		return child;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next=new ListNode(2);
		System.out.println(isPalindrome(head));
	}

}
