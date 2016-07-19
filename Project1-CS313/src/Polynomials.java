
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

		head = new Node(x);
		size++;

		// this.addLast(x);
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
		// Node current = head;
		return head;
	}

	public void addFirst(int x) {
		Node temp = head;
		head = new Node(x);
		head.setNext(temp);
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

	public static Polynomials sum(Polynomials p1, Polynomials p2) {

		Polynomials temp1 = new Polynomials(p1);
		Polynomials temp2 = new Polynomials(p2);

		int diff = temp1.size() - temp2.size();

		if (diff > 0) {
			for (int i = 0; i < diff; i++)
				temp2.addLast(0);
		}
		if (diff < 0) {
			for (int i = 0; i < Math.abs(diff); i++)
				temp1.addLast(0);
		}
		return temp1.sumWith(temp2);
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

	public static Polynomials product(Polynomials p1, Polynomials p2) {
		Polynomials temp1 = new Polynomials(p1);
		Polynomials temp2 = new Polynomials(p2);
		Polynomials temp_product = new Polynomials();
		Node it = temp2.getIterator();
		int pow = 0;
		int multiplier;
		while (it != null) {
			temp1 = new Polynomials(p1);
			multiplier = it.getElement();

			if (pow == 0)
				temp_product = temp1.multiply(multiplier, pow);
			else {

				temp_product = sum(temp_product, temp1.multiply(multiplier, pow));
			}
			it = it.getNext();
			pow++;
		}

		return temp_product;
	}

	public Polynomials multiply(int x, int pow) {
		while (pow != 0) {
			this.addFirst(0);
			pow--;
		}
		Node current = head;
		while (current != null) {
			current.setElement(x * current.getElement());
			current = current.getNext();
		}

		return this;
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		if (head == null)
			throw new RuntimeException("The LinkedList is Empty. Call from toString().");
		Node current = head;
		int pos = 0;
		while (current != null) {
			int val = current.getElement();

			if (val > 0) {
				if(out.length()!=0)out.append(" + ");
				out.append(current.getElement());
				if (pos != 0){
					if(pos>1) out.append("x^" + pos);
					else out.append("x");
				}
			}
			current = current.getNext();
			pos++;
		}
		String everything = out.toString();
		return everything;
	}

}
