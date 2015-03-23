package main;

import data.*;
import funktionalitet.*;
import grænseflade.BGController;
import grænseflade.Brugergrænseflade;
import grænseflade.IBrugergrænseflade;

public class Main {

	public static void main(String[] args) {
		IOperatoerDAO dao = new OperatoerDAO();
		ICreateOperatoer co = new CreateOperatoer(dao);
		IBrugergrænseflade bgf = new Brugergrænseflade(co);
		BGController bgc = new BGController();
		bgc.setRefs(co, bgf);
		bgc.run();
		
	}

}
