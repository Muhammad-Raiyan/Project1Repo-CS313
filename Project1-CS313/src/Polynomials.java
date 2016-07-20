
/**
 * Description of class Polynomials
 * 
 * This class stores polynomils in a linked list and is able to add and multiply
 * two polynomials
 * 
 * @author Muhammad Islam
 */

public class Polynomials {

	private Node head; // First node of the linked list
	private int size; // Size of the list, updates with insertion

	/**
	 * Creates an empty object 
	 */
	public Polynomials() {
		head = null;
		size = 0;
	}

	/**
	 * Creates a new Polynomials object and copies everything. Costly procedure
	 * @param p	Another Polynomial
	 */
	public Polynomials(Polynomials p) {
		Node it = p.head;
		while (it != null) {
			this.addLast(it.getElement());
			it = it.getNext();
		}
	}

	/**
	 * Creates a new Polynomials object with x as the first element
	 * @param x	The integer to initiate list
	 */
	public Polynomials(int x) {

		head = new Node(x);
		size++;

	}

	/**
	 * @return size of the list at any given time
	 */
	public int size() {
		return size;
	}

	/**
	 * @return true if the list is empty
	 * 		   false otherwise
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Makes the list empty
	 */
	public void makeEmpty() {
		head = null;
		size = 0;
	}

	/**
	 * Adds an integer to the beginning of the list, increments the size.
	 * If list is empty, initializes the list with the integer
	 * @param x	The integer to add
	 */
	public void addFirst(int x) {
		if (head == null) {
			head = new Node(x);
		} 
		else{
			Node temp = head;
			head = new Node(x);
			head.setNext(temp);
		}
		size++;
	}

	/**
	 * Adds an integer to the end of the list and increments the size.
	 * If list is empty, initializes a new list
	 * @param x The integer to be added
	 */
	public void addLast(int x) {
		if (head == null) {
			head = new Node(x);
		} 
		else {
			Node n = new Node(x);
			Node current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(n);
		}
		size++;
	}

	/**
	 * Creates two temporary polynomial object temp1, temp2, normalizes them by adding 0 to first or last,
	 * and calls sunmWith() method to add temp2 with temp1 updating temp1 in the process.
	 * Data in p1 and p2 remains unchanged.
	 * 
	 * @param p1, p2 Polynomials objects whose sum is requested
	 * @return A reference to a Polynomials object that contains the sum of p1 and p2
	 */
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

	/**
	 * Adds a Polynomials object to another, stores it on the object from which the call was made
	 * @param p The object to be added
	 * @return polynomials object after being summed
	 */
	public Polynomials sumWith(Polynomials p) {
		if (head == null)
			throw new RuntimeException("The LinkedList is Empty. Call from sumWith().");
		Node current = head;
		Node it = p.head;
		while (current != null) {
			current.setElement(current.getElement() + it.getElement());
			current = current.getNext();
			it = it.getNext();
		}
		return this;
	}
	
	
	/**
	 * Creates three polynomials object, finds product and stores on temp_product.
	 * Temp1 is updated when called with multiply.
	 * @param p1, p2 Two Polynomials object
	 * @return The result of the product
	 */
	public static Polynomials product(Polynomials p1, Polynomials p2) {
		Polynomials temp1 = new Polynomials(p1);
		Polynomials temp2 = new Polynomials(p2);
		Polynomials temp_product = new Polynomials();
		Node it = temp2.head;
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

	/**
	 * Multiplies a polynomial object with an integer and then returns the answer. 
	 * The object from which the call is made is updated to store the answer as well.
	 * @param x The integer to multiply the polynomials object
	 * @param pow The power of the variable associated with the coefficient
	 * @return polynomial object where the result of the multiplication is stored
	 */
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
				if (pos == 0) {
					out.append(val);
				} else {
					if (out.length() != 0)
						out.append(" +");
					out.append(val + "x");
					if (pos > 1)
						out.append("^" + pos);
				}
			} else if (val < 0) {
				if (out.length() != 0)
					out.append(" ");
				out.append(val);
				if (pos >= 1)
					out.append("x");
				if (pos > 1)
					out.append("^" + pos);
			}
			current = current.getNext();
			pos++;
		}
		if (out.length() == 0)
			out.append(0);
		String everything = out.toString();
		return everything;
	}

}
