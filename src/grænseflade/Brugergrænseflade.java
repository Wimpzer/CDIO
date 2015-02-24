package grænseflade;
import java.util.Scanner;

import funktionalitet.ICreateOperatoer;

public class Brugergrænseflade {
	ICreateOperatoer co;

	public Brugergrænseflade(ICreateOperatoer co) {
		this.co = co;
	}

	Scanner scan = new Scanner(System.in);

	public int InputMenu() {
		System.out.println("\tStart Menu\n");
		System.out.println("Press 1 to: OpAdmin");
		System.out.println("Press 2 to: PassControle");
		System.out.println("Press 3 to: Test");
		System.out.println("Press 0 to: Exit");

		int input = scan.nextInt();

		return input;

	}




}
