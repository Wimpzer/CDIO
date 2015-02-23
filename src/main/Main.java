package main;

import data.*;
import funktionalitet.*;
import grænseflade.BGController;
import grænseflade.Brugergrænseflade;

public class Main {

	public static void main(String[] args) {
		IOperatoerDAO dao = new OperatoerDAO();
		ICreateOperatoer co = new CreateOperatoer(dao);
		IBrugergrænseflade bgf = new Brugergrænseflade(co);
		bgf.run(co, bgf);
		
		
		BGController bgf = new BGController();
		bgf.run();		


	}

}
