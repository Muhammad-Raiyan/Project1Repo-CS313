import java.io.*;

public class Project1 {

	public static void main(String[] args) throws IOException {
		Polynomials pol1 = new Polynomials();
		Polynomials pol2 = new Polynomials();
		int c;
		
		System.out.println("Enter a string: ");
		System.out.flush();
		
		while((c=System.in.read())!='\r') pol1.push(new Integer(c));
		
		System.out.println("Input string reversed");
		while(!pol1.isEmpty()){
			System.out.println( (char)(((Integer)pol1.pop()).intValue()) );
		}

	}
	
	public static void sum(Polynomials p1, Polynomials p2){
		
		
	}

}
