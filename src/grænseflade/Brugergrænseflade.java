package grænseflade;

import data.IOperatoerDAO.DALException;
import funktionalitet.ICreateOperatoer;

public class Brugergrænseflade implements IBrugergrænseflade {
	ICreateOperatoer co;

	public Brugergrænseflade(ICreateOperatoer co) {
		this.co = co;
	}

	public void showOutput(String string){
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
	
	public void getPasswordLastUser(){
		try {
			System.out.println("Auto-generated password: " + co.getOperator(co.getOperatorList().size()+9).getPassword());
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}
	
}