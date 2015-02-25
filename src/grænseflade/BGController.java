package grænseflade;

import java.util.Scanner;

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
		co.createSysAdmin();

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

		case 0:	bgf.visOutput("Exit");
		break;

		case 1: mainMenu1();				
		break;

		case 2: bgf.passControle();
		break;

		case 3: mainMenu3();	
		break;

		default: bgf.visOutput("Wrong input");
		break;
		}

	}

	private void mainMenu1() {
		bgf.visOutput("Type your ID");
		int oprID = scan.nextInt(); 
		bgf.typePassword();
		String pass = scan.next();
		boolean valid = co.checkPassword(oprID, pass);
		if(valid == true && oprID == 10){
			systemAdmin();
		}else if(valid == false && oprID == 10){
			bgf.wrongPassword();
			mainMenu();
		}else if(oprID != 10){ 
			bgf.visOutput("Operator ID is not allowed in !!! >:D");
			mainMenu();
		}
	}

	private void mainMenu3() {
		bgf.visOutput("Type your ID");
		int oprID = scan.nextInt(); 
		bgf.typePassword();
		String pass = scan.next();
		boolean valid = co.checkPassword(oprID, pass);
		if(valid == true){
			bgf.visOutput("Tara weight in kilo");
			int tara = scan.nextInt();
			bgf.visOutput("Brutto weight in kilo");
			int brutto = scan.nextInt();
			bgf.visOutput("Netto weight in kilo: " + co.tellNetto(tara, brutto));		
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

		case 1: co.createOperatoer();
		systemAdmin();
		break;

		case 2: bgf.passControle();
		break;

		case 3: bgf.visOutput("Delete");			
		break;

		default: bgf.visOutput("Wrong input");
		break;
		}

	}








}
