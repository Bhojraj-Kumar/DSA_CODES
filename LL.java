import java.util.*;
public class LL {
	Node head;
	int size;
	public LL() {
		// TODO Auto-generated constructor stub
		size=0;
	}
	class Node{
		String data;
		Node next;
		Node(String data){
			this.data=data;
			this.next= null;
			size++;
		}
	}
		//add -first
		public void addFirst(String data) {
			Node newNode=new Node(data);
//			size++;
			if(head==null) {
				head=newNode;
				return;
			}
			newNode.next=head;
			head=newNode;
		}
		//add - last
		public void addLast(String data) {
			Node newNode=new Node(data);
//			size++;
			if(head==null) {
				head=newNode;
				return;
			}
			Node currNode=head;
			while(currNode.next!=null) {
				currNode=currNode.next;
			}
			currNode.next=newNode;
		}
		//print
		public void printList() {
			if(head==null) {
				System.out.println("List is empty");
				return;
			}
			Node currNode=head;
			while(currNode!=null) {
				System.out.print(currNode.data+" --> ");
				currNode=currNode.next;
			}
			System.out.println("NULL");
		}
		//delete first
		public void deleteFirst() {
			if(head==null) {
				System.out.println("List is empty");
				return;
			}
			size--;
			head=head.next;
		}
		//delete last
		public void deleteLast() {
			if(head==null) {
				System.out.println("List is empty");
				return;
			}
			size--;
			if(head.next==null) {
				head=null;
				return;
			}
			Node secondLastNode=head;
			Node lastNode=head.next;
			while(lastNode.next!=null) {
				lastNode=lastNode.next;
				secondLastNode=secondLastNode.next;
			}
			secondLastNode.next=null;	           
		}
		public int getSize() {
			return size;
		}
		
		//reverse a list
		public void reverseIterate() {
			if(head==null||head.next==null) {
				//System.out.println("List is empty");
				return;
			}
			Node prevNode=head;
			Node currNode=head.next;
			while(currNode!=null) {
				Node nextNode=currNode.next;
				currNode.next=prevNode;
				
				//update
				prevNode=currNode;
				currNode=nextNode;
			}
			head.next=null;
			head=prevNode;
		}
		public Node reverseRecursive(Node head) {
			if(head==null || head.next==null)return head;
			Node newHead=reverseRecursive(head.next);
			head.next.next =head; //IMPORTANT 3-->2
			head.next=null; //2-x->3 XX
			return newHead; //4
			/* 1 -> 2 -> 3 -> 4 -> NULL
			 * |head =1
			 * |1 x= null
			 * |pass 2 --------> |head = 2
			 * 					 |2 X= null
			 * 	|newHead=4		 |pass 3 -------->|head =3
			 * 	|2->1							  |3 X= null
			 * 	|1->null(1X->2)  |newHead=4		  |pass 4 -------->|head = 4
			 * 	|return 4		 |3->2							   |4.next==null
			 * 					 |2->null(2X->3)  |newHead=4       |return 4
			 * 					 |return 4		  |4->3			   
			 * 									  |3->null(3 X ->4)
			 * 									  |return 4
			 * 4 -> 3 -> 2 -> 1 -> NULL
			*/	
		}
	public static void main(String args[]) {
		LL list=new LL();
		list.addFirst("Om");
		list.addFirst("Is");
		list.addLast("a");
		list.addLast("good");
		list.addLast("boy");
		list.addLast("?");
		list.deleteFirst();
		list.deleteLast();
		list.printList();
		list.reverseIterate();
		list.printList();
		list.head=list.reverseRecursive(list.head);
		list.printList();
		System.out.print(list.getSize());
	}
}