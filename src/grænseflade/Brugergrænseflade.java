package grænseflade;

import funktionalitet.ICreateOperatoer;

public class Brugergrænseflade implements IBrugergrænseflade {
	ICreateOperatoer co;

	public Brugergrænseflade(ICreateOperatoer co) {
		this.co = co;
	}

	
	@Override
	public void InputMenu() {
		System.out.println("\tStart Menu\n");
		System.out.println("Press 1 to: SystemAdmin");
		System.out.println("Press 2 to: PassControle");
		System.out.println("Press 3 to: Test");
		System.out.println("Press 0 to: Exit");

		
	}

	public void test() {
		System.out.println("Test");

	}

	public void passControle() {
		System.out.println("PassControle");

	}

	public void systemAdmin() {
		System.out.println("SystemAdmin");

	}

	public void exit() {
		System.out.println("Exit");

	}

}
