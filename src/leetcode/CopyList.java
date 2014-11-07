//keep reference map, be cautions about the null input
// and the if-else is doing the first time initialize both the headRef and headResult, then move headRef forward

package leetcode;

import java.util.HashMap;

public class CopyList {
	public RandomListNode copyRandomList(RandomListNode head) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		RandomListNode headRef = null;
		RandomListNode headResult = null;
		RandomListNode head1 = head;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		map.put(head, headRef);
		while (head!= null) {
			if(headResult == null){
			headRef = headResult = new RandomListNode(head.label);
			map.put(head, headRef);
			head = head.next;			
			}
			else{
			headRef.next = new RandomListNode(head.label);
			map.put(head, headRef.next);
			head = head.next;
			headRef = headRef.next;
			}
		}
		headRef = headResult;
		while(head1!= null){
			headRef.random = map.get(head1.random);
			headRef = headRef.next;
			head1 = head1.next;			
		}
		
		return headResult;
	}

	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	}
}