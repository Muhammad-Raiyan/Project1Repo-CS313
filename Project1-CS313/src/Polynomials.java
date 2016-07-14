
public class Polynomials {

	private Node head;
	private int size;
	
	public Polynomials(){
		head = null;
		size = 0;
	}
	public Polynomials(int x){
		head=new Node(x);
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void makeEmpty() {
		head = null;
		size = 0;
	}
	
	public void addLast(int x) {
		if(head==null){
			head=new Node(x);
			size++;
			return;
		}
		Node n = new Node(x);
		Node current=head;
		while(current.getNext()!=null){
			current=current.getNext();
		}
		current.setNext(n);
		size++;
	}

	public int removeLast() {
		int temp;
		temp = head.getElement();
		head = head.getNext();
		size--;
		return temp;
	}

	public int last() {		
		return head.getElement();
	}
	
	@Override
	public String toString(){
		StringBuilder out = new StringBuilder();
		Node current = head;
		while(current!=null){
			out.append(current.getElement());
			out.append(" ");
			current = current.getNext();
		}
		String everything = out.toString();
		return everything;
	}

}
