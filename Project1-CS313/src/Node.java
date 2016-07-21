

public class Node {
	private int element;
	private Node next;
	
	
	Node() {
		this(0, null);
	}
	
	Node(int x){
		element=x;
	}
	
	Node(int e, Node n){
		element = e;
		next = n;
	}
	
	
	public void setElement(int element) {
		this.element = element;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	int getElement(){
		return element;
	}
	
	Node getNext(){
		return next;
	}
	
	@Override
	public String toString(){
		return Integer.toString(element);
	}
}
