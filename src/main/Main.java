package main;

import data.*;
import funktionalitet.*;
import gr�nseflade.BGController;
import gr�nseflade.Brugergr�nseflade;

public class Main {

	public static void main(String[] args) {
		IOperatoerDAO dao = new OperatoerDAO();
		ICreateOperatoer co = new CreateOperatoer(dao);
		IBrugergr�nseflade bgf = new Brugergr�nseflade(co);
		bgf.run(co, bgf);
		
		
		BGController bgf = new BGController();
		bgf.run();		


	}

}
