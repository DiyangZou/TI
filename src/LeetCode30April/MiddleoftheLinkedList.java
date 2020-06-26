package LeetCode30April;

public class MiddleoftheLinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode middleNode(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode slow = head, fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
