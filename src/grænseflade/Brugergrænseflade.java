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
		System.out.println("\tStart Menu\n");
		System.out.println("Press 1 to opAdmin");
		System.out.println("Press 2 to passControle");
		System.out.println("Press 3 to test");
		System.out.println("Press 0 to Exit");
		
		
		int input = scan.nextInt();
		
		return input;
	
	}
	
	
	
	
}
