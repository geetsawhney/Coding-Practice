//leetcode 203
public class RemoveNodeGreaterThanX {

	public static ListNode removeNodes(ListNode listHead, int x) {

		if(listHead == null) {
			return null;
		}
		ListNode child=removeNodes(listHead.next, x);

		if(listHead.val > x)
			return child;
		listHead.next=child;
		return listHead;
	}

	public ListNode removeElements(ListNode head, int val) {

        ListNode dummy=new ListNode(val-1);
        dummy.next=head;
        ListNode curr=dummy;
        while(head!=null){
            if(head.val==val){
                curr.next=head.next;
            }
            else{
                curr=curr.next;
            }
						head=head.next;
        }
        return dummy.next;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode l=new ListNode(10);
		l.next=new ListNode(5);
		l.next.next=new ListNode(4);

		ListNode ans=removeNodes(l, 8);

		while(ans!=null) {
			System.out.println(ans.val);
			ans=ans.next;
		}


	}

}
