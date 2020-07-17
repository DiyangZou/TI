package Medium;

public class FlattenaMultilevelDoublyLinkedList {
	public Node flatten(Node head) {

		Node p = head;
		while (p != null) {
			
			if(p.child == null) {
				p = p.next;
				continue;
			}
			
			Node c = p.child;
			while(c.next != null) {
				c = c.next;
			}
			
			c.next = p.next;
			if(p.next != null) p.next.prev = c;
			p.next = p.child;
			p.child.prev = p;
			p.child = null;
			
		}
		return head;
	}
	
}

//Definition for a Node.
class Node {
	public int val;
	public Node prev;
	public Node next;
	public Node child;
};
