package ListBasic;

public class P1 {

	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		
		list.insertAtBegining(new ListNode(1));
		list.insertAtBegining(new ListNode(2));
		list.insertAtBegining(new ListNode(3));
		list.insertAtBegining(new ListNode(4));
		list.insertAtBegining(new ListNode(5));
		
		list.insertAtPosstion(121, 4);
		list.insertAtEnd(new ListNode(888));
		list.printLinkList();
		
		ListNode deletednode=list.deleteLastNode();
		System.out.println(deletednode.getData());
		list.printLinkList();
		
		
	}
	
	
	
}
