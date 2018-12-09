/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class RandomListNodeCopy {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode newHead=null;
        RandomListNode newTail=null;
        RandomListNode temp=head;

        HashMap<RandomListNode,RandomListNode> newToOld = new HashMap<>();
        HashMap<RandomListNode,RandomListNode> oldToNew = new HashMap<>();

        RandomListNode newNode;
        while(temp!=null){
            newNode=new RandomListNode(temp.label);

            if(newHead==null){
                newHead = newNode;
                newTail = newNode;
            }else{
                newTail.next = newNode;
                newTail = newNode;
            }
            newToOld.put(newNode,temp);
            oldToNew.put(temp,newNode);

            temp=temp.next;
        }

        temp=newHead;

        while(temp!=null){
            if(newToOld.get(temp).random!=null){
                temp.random=oldToNew.get(newToOld.get(temp).random);
            }else{
                temp.random=null;
            }
            temp=temp.next;
        }
        return newHead;
    }

    public RandomListNode copyRandomList_2(RandomListNode head) {
        return copyRandomList(head,new HashMap<RandomListNode,RandomListNode>());
    }

    public RandomListNode copyRandomList(RandomListNode head, HashMap<RandomListNode,RandomListNode> map){

        if(head == null)
            return null;

        if(map.containsKey(head))
            return map.get(head);

        RandomListNode node = new RandomListNode(head.label);
        map.put(head,node);

        node.next=copyRandomList(head.next,map);
        node.random=copyRandomList(head.random,map);

        return node;
    }
}
