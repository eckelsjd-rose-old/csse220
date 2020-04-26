public class SinglyLinkedList {
	private class Node {
		public Integer data;
		public Node next;

		public Node(Integer data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node head;

	// Do not change constructor
	public SinglyLinkedList() {
		head = null;
	}

	// Do not change addAtHead
	public void addAtHead(int x) {
		Node p = new Node(x, this.head);
		this.head = p;
	}

	// Do not change toStringHelper
	private String toStringHelper(Node p) {
		if (p == null) {
			return "";
		} else {
			return p.data + ((p.next != null) ? "->" : "") + toStringHelper(p.next);
		} // end if
	}

	// Do not change toString
	@Override
	public String toString() {
		return "[" + toStringHelper(head) + "]";
	}

	/*
	 * DONE 
	 * 
	 * findAnIntAndSwapItToFront finds the value in the list then swaps it with the
	 * value at the front of the list
	 * 
	 * If the value is not present in the list, then the operation has no effect on
	 * the list
	 * 
	 * For example, given the list: [10->20->30->40->50] and the value 40 the result
	 * would be: [40->20->30->10->50] That is, values 10 and 40 are swapped
	 * 
	 * See SinglyLinkedListTest.java for more examples
	 * 
	 */
	public void findAnIntAndSwapItToFront(int value) {
		Node current = this.head;
		while (current!= null) {
			if (current.data == value) {
				current.data = this.head.data;
				this.head.data = value;
			}
			current = current.next;
		}

	}

	/*
	 * DONE
	 * 
	 * returnValueInMiddleOfList() returns the value found in the exact middle of a
	 * list with an odd length
	 * 
	 * An even length list has no exact middle, in that case
	 * returnValueInMiddleOfList returns -1
	 * 
	 * For example, given the list: [10->20->30->40->50] 30 would be returned
	 * 
	 * See SinglyLinkedListTest.java for more examples
	 */
	public int returnValueInMiddleOfList() {
		Node current = this.head;
		int count = 0;
		while (current != null) {
			count++;
			current = current.next;
		}
		if (count % 2 == 0) {
			return -1;
		}
		current = this.head;
		for (int i = 0; i < count / 2 + 1; i++) {
			if (i == (count / 2)) {
				return current.data;
			}
			current = current.next;
		}
		return -1;
	}

	/* TODO
	 * operation cutOutNodesFrom55To65 
	 * Removes nodes from the linked list as seen 
	 * in the following example: 
	 * 
	 * list before call: [91->55->57->59->61->63->65->44]
	 *                            ^^  ^^  ^^  ^^
	 *                            nodes to remove
	 *                         
	 * list after call: [91->55->65->44]
	 * 
	 * Let startNode be a Node where startNode.data = 55
	 * Let endNode be a Node where endNode.data = 65
	 * 
	 * All nodes between startNode and endNode must be removed,
	 * but startNode and endNode are not removed
	 * 
	 * Additional facts:
	 * 1) There might be multiple startNode, endNode pairs in the list
	 *    All nodes between each startNode, endNode pair must be removed
	 *    
	 * 2) The endNode might be missing, in which case all nodes
	 *    after startNode must be removed and the list left in a
	 *    consistent state
	 * 
	 * See SinglyLinkedListTest.java for more examples
	 */

	public void cutOutNodesFrom55To65() {
		Node current = this.head;
		Node prev = null;
		boolean foundEnd = false;
		boolean foundStart = false;
		while (current != null) {

			if (current.data == 65) {
				foundEnd = true;
				foundStart = false;
				prev = current;
				current = current.next;
			}
			else if (foundStart && !foundEnd) {
				prev.next = current.next;
				current = current.next;
			}
			else if (current.data == 55) {
				foundStart = true;
				prev = current;
				current = current.next;
			} else {
				prev = current;
				current = current.next;
				foundEnd = false;
			}
		}

	}
}
