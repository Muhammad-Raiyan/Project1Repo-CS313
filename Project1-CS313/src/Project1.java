import java.io.*;

/**
 * @author Muhammad Islam
 * @version Project 1 CSCI 313
 */
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
					System.out.println("First Polynomial: \t" + pol1.toString());
					System.out.println("Second Polynomial: \t" + pol2.toString());
					System.out.println("Sum: \t\t\t" + Polynomials.sum(pol1, pol2).toString());
					System.out.println("Product: \t\t" + Polynomials.product(pol1, pol2).toString());
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

			} while (line != null);

			br.close(); // close BufferedReader
		} // End of IO

	}

	/**
	 * Takes a string, splits it and stores it to a polynomial object.
	 * @param s A string that holds the coefficients of the polynomial
	 * @return A polynomial object where each of the coefficients are stored as elements on the linked list
	 */
	public static Polynomials store(String s) {
		Polynomials p = new Polynomials();

		String[] temp_pol = s.split(",");
		for (String elements : temp_pol) {
			p.addLast(Integer.parseInt(elements));
		}
		return p;
	}
}
