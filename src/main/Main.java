package main;

import data.*;
import funktionalitet.*;
import grænseflade.BGController;
import grænseflade.Brugergrænseflade;

public class Main {

	public static void main(String[] args) {
		IOperatoerDTO dto = new OperatoerDTO();
		IOperatoerDAO dao = new OperatoerDAO(dto);
		BGController bgf = new BGController();
		bgf.run();		

	}

}
