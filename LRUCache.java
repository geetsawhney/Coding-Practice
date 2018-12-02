package assessment;

// 146. LRU Cache

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	Map<Integer, DoublyLinkedList> cacheMap;
	DoublyLinkedList head = new DoublyLinkedList();
	DoublyLinkedList tail = new DoublyLinkedList();
	int capacity;

	public LRUCache(int capacity) {
		this.capacity=capacity;
		cacheMap = new HashMap<>(capacity);
		head = new DoublyLinkedList();
		tail = new DoublyLinkedList();
		head.next=tail;
		tail.prev=head;
	}

	public int get(int key) {
		if(!cacheMap.containsKey(key))
			return -1;

		DoublyLinkedList cacheValue=cacheMap.get(key);
		remove(cacheValue);
		makeHead(cacheValue);

		return cacheValue.value;
	}

	public void put(int key, int value) {

		if(cacheMap.containsKey(key)) {
			cacheMap.get(key).value=value;
			remove(cacheMap.get(key));
			makeHead(cacheMap.get(key));
		}else {
			DoublyLinkedList cacheValue = new DoublyLinkedList(key, value);
			if(!(cacheMap.size()<capacity)) {
				cacheMap.remove(tail.prev.key);
				remove(tail.prev);
			}
				cacheMap.put(key, cacheValue);
				makeHead(cacheValue);
		}
	}

	private void makeHead(DoublyLinkedList node) {
		node.next=head.next;
		node.next.prev=node;
		node.prev=head;
		head.next=node;
	}

	private void remove(DoublyLinkedList node) {

		node.next.prev=node.prev;
		node.prev.next=node.next;
		node.next=null;
		node.prev=null;
	}

	public static void main(String[] args) {

		LRUCache cache = new LRUCache( 2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);       // returns 1
		cache.put(3, 3);    // evicts key 2
		cache.get(2);       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		cache.get(1);       // returns -1 (not found)
		cache.get(3);       // returns 3
		cache.get(4);       // returns 4


	}

}

class DoublyLinkedList{

	DoublyLinkedList next,prev;
	int key,value;

	public DoublyLinkedList() {}

	public DoublyLinkedList(int key, int value) {
		this.key=key;
		this.value=value;
	}

}
