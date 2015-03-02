package grænseflade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import data.IOperatoerDAO.DALException;
import funktionalitet.ICreateOperatoer;

public class BGController {

	ICreateOperatoer co;
	IBrugergrænseflade bgf;

	Scanner scan = new Scanner(System.in);

	public void setRefs(ICreateOperatoer co,IBrugergrænseflade bgf){

		this.co = co;
		this.bgf = bgf;

	}

	public void run(){
		try {
			co.createSysAdmin();
		} catch (DALException e) {
			bgf.showOutput(e.getMessage());
		}

		int in = 0;
		do
		{
			mainMenu();
		}while (in!=0);
	}

	private void mainMenu(){

		bgf.inputMenu();
		int in = scan.nextInt();

		switch(in){

		case 0:	bgf.showOutput("You've closed the program");
		break;

		case 1: mainMenu1();				
		break;

		case 2: mainMenu2();
		break;

		case 3: mainMenu3();	
		break;

		default: bgf.showOutput("Wrong input");
		mainMenu();
		break;
		}

	}

	private void mainMenu1() {
		bgf.showOutput("Type your ID");
		int oprID = scan.nextInt(); 
		bgf.typePassword();
		String pass = scan.next();
		try {
			boolean valid = co.checkPassword(oprID, pass);
			if(valid == true && oprID == 10){
				systemAdmin();
			}else if(valid == false && oprID == 10){
				bgf.wrongPassword();
				mainMenu();
			}else if(oprID != 10){ 
				bgf.showOutput("Operator ID is not allowed in !!! >:D");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			bgf.showOutput("ID is not found in database");
		} finally{
			mainMenu();
		}

	}

	private void mainMenu2() {
		bgf.showOutput("Type your ID");
		int oprID = scan.nextInt(); 
		bgf.typePassword();
		String pass = scan.next();
		boolean valid = co.checkPassword(oprID, pass);
		if(valid == true){
			bgf.showOutput("Type new password");
			String newPassword = scan.next();
			bgf.showOutput("Type new password again");
			String newPassword2 = scan.next();
			if(newPassword.equals(newPassword2)){
				try {
					co.editOperatorPassword(oprID, newPassword);
				} catch (DALException e) {
					bgf.showOutput(e.getMessage());
				}
				mainMenu();
			}else{
				bgf.showOutput("Passwords did not match - Try again");
				mainMenu();
			}
		}else if(valid == false){
			bgf.showOutput("Password does not match ID");
			mainMenu();
		}
	}

	private void mainMenu3() {
		bgf.showOutput("Type your ID");
		int oprID = scan.nextInt(); 
		bgf.typePassword();
		String pass = scan.next();
		boolean valid = co.checkPassword(oprID, pass);
		if(valid == true){
			bgf.showOutput("Tara weight in kilo");
			int tara = scan.nextInt();
			bgf.showOutput("Brutto weight in kilo");
			int brutto = scan.nextInt();
			bgf.showOutput("Netto weight in kilo: " + co.tellNetto(tara, brutto));
			mainMenu();
		}else{
			bgf.wrongPassword();
			mainMenu();
		}
	}

	private void systemAdmin(){
		bgf.systemAdminMenu();

		int in = scan.nextInt();
		switch(in){

		case 0:	mainMenu();
		break;

		case 1: createOperatoer();
		systemAdmin();
		break;

		case 2: EditOperatoer();;
		break;

		case 3: deleteOperatoer();			
		break;

		default: bgf.showOutput("Wrong input");
		systemAdmin();
		break;
		}		
	}

	private void createOperatoer(){
		bgf.showOutput("Type name of new operatoer");
		String oprNavn = scan.next();
		bgf.showOutput("Type the CPR number");
		String cpr = scan.next();
		try {
			co.createOperatoer(oprNavn, cpr);
		} catch (DALException e) {
			bgf.showOutput(e.getMessage());
		}
		bgf.getPasswordLastUser();
	}

	private void deleteOperatoer(){
		bgf.showOutput("Choose which operatoer to delete");
		int oprID = scan.nextInt();
		try {
			co.deleteOperatoer(oprID);
		} catch (DALException e) {
			bgf.showOutput(e.getMessage());
		}
	}

	private void EditOperatoer(){
		getOperatorList();
		bgf.showOutput("Choose which user to edit");
		int oprID = scan.nextInt();
		bgf.showOutput(co.getOperator(oprID).getOprNavn() + " have been  chosen");
		editUserMenu(oprID);		
	}

	private void getOperatorList() {
		List<String> stringList = new ArrayList<String>();
		try {
			stringList = co.getOperatorList();
		} catch (DALException e) {
			bgf.showOutput(e.getMessage());
		}
		for (int i = 0; i < stringList.size(); i++) {
			bgf.showOutput(stringList.get(i));
		}
	}

	private void editUserMenu(int oprID){
		bgf.showOutput("Choose what to edit");
		bgf.showOutput("1. Name");
		bgf.showOutput("2. CPR number");
		bgf.showOutput("3. Password");
		bgf.showOutput("0. Exit");
		userMenuSwitchCase(oprID);
	}

	private void userMenuSwitchCase(int oprID){
		int input = scan.nextInt();

		switch (input) {
		case 1:
			changeName(oprID);
			systemAdmin();
			break;

		case 2:
			changeCPR(oprID);
			systemAdmin();
			break;

		case 3:
			changePassword(oprID);
			systemAdmin();
			break;

		case 0:
			systemAdmin();
			break;

		default:
			bgf.showOutput("Wrong input");
			break;
		}
	}

	private void changeName(int oprID){
		bgf.showOutput("New name: ");
		String oprName = scan.next();
		try {
			co.editOperatorName(oprID, oprName);
		} catch (DALException e) {
			bgf.showOutput(e.getMessage());
		}
	}

	private void changeCPR(int oprID){
		bgf.showOutput("New CPR: ");
		String CPR = scan.next();
		try {
			co.editOperatorCPR(oprID, CPR);
		} catch (DALException e) {
			bgf.showOutput(e.getMessage());
		}
	}

	private void changePassword(int oprID) {
		bgf.showOutput("New password: ");
		String password = scan.next();
		if(co.isValid(password)){
			try {
				co.editOperatorPassword(oprID, password);
			} catch (DALException e) {
				bgf.showOutput(e.getMessage());
			}
		}else{
			bgf.showOutput("Password does not match password criteria");
		}
	}
}
