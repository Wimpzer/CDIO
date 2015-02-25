package gr�nseflade;

import funktionalitet.ICreateOperatoer;

public class Brugergr�nseflade implements IBrugergr�nseflade {
	ICreateOperatoer co;

	public Brugergr�nseflade(ICreateOperatoer co) {
		this.co = co;
	}

	public void visOutput(String string){
		System.out.println(string);
	}

	@Override
	public void inputMenu() {
		System.out.println("\tStart Menu\n");
		System.out.println("Press 1 to: SystemAdmin");
		System.out.println("Press 2 to: PassControle");
		System.out.println("Press 3 to: Test");
		System.out.println("Press 0 to: Exit");

	}

	public void systemAdminMenu(){
		System.out.println("\tSystemAdminMenu\n");
		System.out.println("Press 1 to: Create operator");
		System.out.println("Press 2 to: Edit operator");
		System.out.println("Press 3 to: Delete operator");
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
	public void typePassword() {
		System.out.println("Type your password: ");
	}
	
	public void wrongPassword(){
		System.out.println("Your password is wrong!!!!!  :( ");
	}
}