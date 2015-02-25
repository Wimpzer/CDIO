package grænseflade;

import java.util.Scanner;

import funktionalitet.ICreateOperatoer;

public class BGController {

	ICreateOperatoer co;
	IBrugergrænseflade bgf;

	Scanner scan = new Scanner(System.in);

	public void run(){

		int in = 0;
		do
		{
			bgf.InputMenu();
			in = scan.nextInt();
			InputHandler(in);
		}while (in!=0);
	}

	private void InputHandler(int in){

		switch(in){

		case 0:	bgf.exit();
		break;
		
		case 1: bgf.systemAdmin();					
		break;

		case 2: bgf.passControle();
		break;

		case 3: bgf.test();
		break;
		}


	}



	public void setRefs(ICreateOperatoer co,IBrugergrænseflade bgf){

		this.co = co;
		this.bgf = bgf;

	}



}
