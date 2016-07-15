
public class Polynomials {

	private Node top;
	private int size;
	
	public Polynomials(){
		top = null;
		size = 0;
	}
	public Polynomials(int x){
		top=new Node(x);
		size++;
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
	
	public void addLast(int x) {
		if(top==null){
			top=new Node(x);
			size++;
			return;
		}
		Node n = new Node(x);
		Node current=top;
		while(current.getNext()!=null){
			current=current.getNext();
		}
		current.setNext(n);
		size++;
	}

	public int removeLast() {
		int temp;
		temp = top.getElement();
		top = top.getNext();
		size--;
		return temp;
	}

	public int last() {		
		return top.getElement();
	}
	
	@Override
	public String toString(){
		StringBuilder out = new StringBuilder();
		Node current = top;
		while(current!=null){
			out.append(current.getElement());
			out.append(" ");
			current = current.getNext();
		}
		String everything = out.toString();
		return everything;
	}

}
