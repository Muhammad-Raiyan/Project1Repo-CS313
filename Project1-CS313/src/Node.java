
public class Node {
	private int element;
	private Node next;
	
	Node() {
		this(0, null);
	}
	
	Node(int e, Node n){
		element = e;
		next = n;
	}
	
	int getElement(){
		return element;
	}
	
	Node getNext(){
		return next;
	}
}
