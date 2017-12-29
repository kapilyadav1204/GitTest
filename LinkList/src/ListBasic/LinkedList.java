package ListBasic;

public class LinkedList {
	ListNode head;
	private int length;

	public LinkedList() {
		length = 0;
	}

	public synchronized ListNode getHead() {
		return head;
	}

	public synchronized void insertAtBegining(ListNode node) {
		node.setNext(head);
		head = node;
		length++;
	}

	public synchronized void insertAtEnd(ListNode node) {
		length++;
		if (head == null) {
			head = node;
		} else {
			ListNode p, q = null;

			for (p = head; p.getNext() != null; p = p.getNext())
				;
			p.setNext(node);
		}

	}

	public synchronized void insertAtPosstion(int data, int possition) {

		if (possition < 0) {
			possition = 0;
		}

		if (possition > length) {
			possition = length;
		}

		length++;
		if (head == null) {
			head = new ListNode(data);
		} else if (possition == 0) {
			ListNode temp = new ListNode(data);
			temp.setNext(head);
			head = temp;
		}

		else {
			ListNode temp = new ListNode(data);
			ListNode p = head;
			ListNode q;
			for (int i = 1; i < possition; i++) {
				p = p.getNext();
			}
			temp.setNext(p.getNext());

			p.setNext(temp);

		}
	}

	public synchronized int removeAtBegining() {
		ListNode node = head;

		if (node != null) {
			head = node.getNext();
			node.setNext(null);
		}
		return node.getData();
	}

	public synchronized void printLinkList() {
		ListNode node = head;
		System.out.print("[");
		while (node != null) {
			System.out.print(" " + node.getData());
			node = node.getNext();
		}

		System.out.println(" ]");

	}

	public synchronized ListNode deleteFristNode() {

		ListNode node = head;
		if (head == null) {
			return null;
		} else {

			head = node.getNext();
			node.setNext(null);

		}
		return node;
	}

	public synchronized ListNode deleteLastNode() {

		if (head == null || head.getNext() == null) {
			return head = null;
		}

		ListNode p = null, next = head.getNext();
		while (next.getNext() != null) {
			p = next;
			next = next.getNext();
		}
		p.setNext(null);
		return next;
	}

}
