package grænseflade;
import java.util.Scanner;

import funktionalitet.IOperatoerDAO;

public class Brugergrænseflade {
	IOperatoerDAO dao;
	
	public Brugergrænseflade() {
		this.dao = dao;
	}
	
	Scanner scan = new Scanner(System.in);

	public int InputMenu() {
		System.out.println("\tStart Menu\t");
		System.out.println("Press 1 to XXXXXX");
		System.out.println("Press 2 to XXXXXX");
		System.out.println("Press 3 to XXXXXX");
		System.out.println("Press 4 to XXXXXX");
		System.out.println("Press 5 to XXXXXX");
		
		
		int input = scan.nextInt();
		
		return input;
	
	}
	
	
	
	
}
