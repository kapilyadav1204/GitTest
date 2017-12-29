package ListBasic;

public class ListNode {

	private int data;
	private ListNode next;

	public ListNode(int data) {
System.out.println(data);
		this.data = data;
	}

	public void setData(int data) {

		this.data = data;
	}

	public int getData() {

		return this.data;
	}

	public void setNext(ListNode next) {

		this.next = next;
	}

	public ListNode getNext() {

		return this.next;
	}

}
