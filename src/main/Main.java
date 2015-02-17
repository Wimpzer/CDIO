package main;

import data.*;
import funktionalitet.*;
import grænseflade.Brugergrænseflade;

public class Main {

	public static void main(String[] args) {
		IOperatoerDTO dto = new OperatoerDTO();
		IOperatoerDAO dao = new OperatoerDAO(dto);
		Brugergrænseflade bgf = new Brugergrænseflade(dao);
		bgf.run();		

	}

}
