
public class Polynomials {

	private Node head;
	private int size;

	public Polynomials() {
		head = null;
		size = 0;
	}

	public Polynomials(Polynomials p) {
		Node it = p.getIterator();
		while (it != null) {
			this.addLast(it.getElement());
			it = it.getNext();
		}
	}

	public Polynomials(int x) {
		/*
		 * head = new Node(x); size++;
		 */
		this.addLast(x);
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

	public Node getIterator() {
		if (head == null)
			throw new RuntimeException("Head in getIterator is empty");
		Node current = head;
		return current;
	}

	public void addLast(int x) {
		if (head == null) {
			head = new Node(x);
			size++;
		} else {
			Node n = new Node(x);
			Node current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(n);
			size++;
		}
	}

	public int removeLast() {
		if (head == null)
			throw new RuntimeException("The LinkedList is Empty. Call from removeLast().");
		int temp;
		temp = head.getElement();
		head = head.getNext();
		size--;
		return temp;
	}

	public int last() {
		if (head == null)
			throw new RuntimeException("The LinkedList is Empty. Call from last().");
		Node current = head;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		return current.getElement();

	}

	public Polynomials sumWith(Polynomials p) {
		if (head == null)
			throw new RuntimeException("The LinkedList is Empty. Call from sumWith().");
		Node current = head;
		Node it = p.getIterator();
		while (current != null) {
			current.setElement(current.getElement() + it.getElement());
			current = current.getNext();
			it = it.getNext();
		}
		return this;
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		if (head == null)
			throw new RuntimeException("The LinkedList is Empty. Call from toString().");
		Node current = head;
		while (current != null) {
			out.append(current.getElement());
			out.append(" ");
			current = current.getNext();
		}
		String everything = out.toString();
		return everything;
	}

}
