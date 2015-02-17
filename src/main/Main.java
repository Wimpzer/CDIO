package main;

import data.*;
import funktionalitet.*;
import gr�nseflade.BGController;
import gr�nseflade.Brugergr�nseflade;

public class Main {

	public static void main(String[] args) {
		IOperatoerDTO dto = new OperatoerDTO();
		IOperatoerDAO dao = new OperatoerDAO(dto);
		BGController bgf = new BGController();
		bgf.run();		

	}

}
