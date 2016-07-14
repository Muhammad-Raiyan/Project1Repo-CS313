
public class Polynomials {

	private Node top;
	private int size;
	
	public Polynomials(){
		top = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void makeEmpty() {
		top = null;
		size = 0;
	}
	
	public void push(int x) {
		Node n = new Node(x, top);
		top = n;
		size++;
	}

	public Object pop() {
		Object temp;
		//if(isEmpty()) throw new StackException("Stack is Empty");
		temp = top.getElement();
		top = top.getNext();
		size--;
		return temp;
	}

	public Object top() {
		//if(isEmpty()) throw new StackException("Stack is empty");
		return top.getElement();
	}
	
	public String toString(){
		String out = "";
		Node current = top;
		while(!this.isEmpty()){
			out += (current.getElement() + "\n");
			current = current.getNext();
		}
		
		return out;
	}

}
