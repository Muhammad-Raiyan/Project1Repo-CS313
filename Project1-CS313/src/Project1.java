import java.io.*;

public class Project1 {

	public static void main(String[] args) throws IOException {
		Polynomials pol1 = new Polynomials();
		Polynomials pol2 = new Polynomials();

		if (args.length == 0) // check for file name in command line argument
			System.out.println("No file specified");
		else {

			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String line;

			do {

				if ((line = br.readLine()) == null || line.isEmpty()) {
					System.out.println("First Polynomial: " + pol1.toString());
					System.out.println("Second Polynomial: " + pol2.toString());
					System.out.println("Sum: " + sum(pol1, pol2).toString());
					System.out.println("Product: " + product(pol1, pol2).toString());
					System.out.println();

					pol1.makeEmpty();
					pol2.makeEmpty();
				}

				else {

					// Store first string to a polynomials object
					pol1 = store(line);
					// read next line from txt and store to polynomial object
					line = br.readLine();
					pol2 = store(line);
				}
				/*
				 * System.out.println(pol1.toString());
				 * System.out.println(pol1.size());
				 * System.out.println(pol2.toString());
				 * System.out.println(pol1.size());
				 */

			} while (line != null);

			br.close(); // close BufferedReader
		} // End of IO
			// System.out.println(everything);

		/*
		 * System.out.println("Enter a string: "); System.out.flush();
		 * 
		 * while((c=System.in.read())!='\r') pol1.addLast(new Integer(c));
		 */
		/*
		 * System.out.println("Input string reversed"); while(!pol1.isEmpty()){
		 * System.out.println( (char)(((Integer)pol1.removeLast()).intValue())
		 * ); }
		 */
	}

	public static Polynomials store(String s) {
		Polynomials p = new Polynomials();

		String[] temp_pol = s.split(",");
		for (String elements : temp_pol) {
			p.addLast(Integer.parseInt(elements));
		}
		return p;
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

			// System.out.println("Multiplier: " + multiplier);

			if (pow == 0)
				temp_product = temp1.multiply(multiplier, pow);
			else {

				temp_product = sum(temp_product, temp1.multiply(multiplier, pow));
				// System.out.println(temp1.toString());
			}
			it = it.getNext();
			pow++;
			// System.out.println(temp1.toString());
		}

		return temp_product;
	}

}
