import java.io.*;
import java.util.*;

public class Project1 {

	public static void main(String[] args) throws IOException {
		Polynomials pol1 = new Polynomials();
		Polynomials pol2 = new Polynomials();
				
		
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		String line;
		
		do{
			line = br.readLine();
			if(line==null) break;
			
			if(!line.isEmpty()){
				
				pol1 = store(line);
				
				line = br.readLine();
				pol2 = store(line);				
			}
			else 
				System.out.println("Empty Line");
			
//			while(!pol1.isEmpty()){
//				System.out.println( pol1.removeLast() );
//			}
			System.out.println(pol1.toString());
			System.out.println(pol2.toString());
			
			pol1.makeEmpty();
			pol2.makeEmpty();
			
		}while(line!=null);
		
		//String everything = sb.toString();
		br.close();
		
		
		//System.out.println(everything);
		
		/*System.out.println("Enter a string: ");
		System.out.flush();
		
		while((c=System.in.read())!='\r') pol1.addLast(new Integer(c));
		*/
		/*System.out.println("Input string reversed");
		while(!pol1.isEmpty()){
			System.out.println( (char)(((Integer)pol1.removeLast()).intValue()) );
		}*/

	}
	
	public static Polynomials store(String s){
		Polynomials p = new Polynomials();
		
		String[] temp_pol = s.split(" ");
		for(String elements: temp_pol){
			p.addLast(Integer.parseInt(elements));
		}
		return p;
	}
	
	public static void sum(Polynomials p1, Polynomials p2){
		
		
	}

}
