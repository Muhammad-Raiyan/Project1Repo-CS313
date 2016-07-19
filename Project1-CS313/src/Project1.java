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
					System.out.println("Sum: " + Polynomials.sum(pol1, pol2).toString());
					System.out.println("Product: " + Polynomials.product(pol1, pol2).toString());
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

	public static Polynomials store(String s) {
		Polynomials p = new Polynomials();

		String[] temp_pol = s.split(",");
		for (String elements : temp_pol) {
			p.addLast(Integer.parseInt(elements));
		}
		return p;
	}
}
