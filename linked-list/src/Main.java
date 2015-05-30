
public class Main {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.reverse();
		list.print();
	}
}

class Node {
	int num;
	Node next;
}

class LinkedList {
	Node head;
	Node tail;
	
	void add(int n) {
		Node node = new Node();
		node.num = n;
		if (head == null) {
			head = node;
			tail = head;
		} else {
			tail.next = node;
			tail = node;
		}
	}
	
	void reverse() {
		if (head == null || head.next == null) {
			return;
		}
		
		
		Node prev = head;
		Node curr = head.next;
		Node next = head.next.next;
		
		
		
		while (curr.next != null) {
			curr.next = prev;
			
			prev = curr;
			curr = next;
			next = next.next;
		}
		
		
		 
		
		
	}
	
	void print() {
		Node curr = head;
		while (curr != null) {
			System.out.println(curr.num);
			curr = curr.next;
		}
	}
}