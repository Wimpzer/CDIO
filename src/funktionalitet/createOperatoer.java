package funktionalitet;

import java.security.SecureRandom;
import java.util.Random;

import javax.swing.JOptionPane;

import data.IOperatoerDAO;
import data.IOperatoerDAO.DALException;
import data.IOperatoerDTO;

public class CreateOperatoer implements ICreateOperatoer {
	IOperatoerDAO dao;

	public CreateOperatoer(IOperatoerDAO dao) {
		this.dao = dao;
	}


	@Override
	public boolean checkPassword(int oprID, String password) {
		// TODO Auto-generated method stub

		boolean valid = false;

		try {
			if(dao.getOperatoer(oprID).getPassword().equals(password)){

				valid = true;

			}

		} catch (DALException e) {
			e.printStackTrace();
		}

		return valid;
	}

	@Override
	public void createOperatoer() { //TODO: Throw exception?
        String oprNavn = JOptionPane.showInputDialog("Skriv navnet paa brugeren du oensker, at oprette.");
        String cpr = JOptionPane.showInputDialog("indtast cpr nummer på brugeren.");
        String password = generatePassword();
        try {
			dao.createOperatoer(oprNavn, cpr, password);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String generatePassword(){

		final Random RANDOM = new SecureRandom();

		final int PASSWORD_LENGHT = 8;

		String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890.-_+!?=";

		String pw = "";

		for(int i = 0;i < PASSWORD_LENGHT; i++){
			int index = (int) (RANDOM.nextDouble()*letters.length());
			pw += letters.substring(index, index+1);
		}

		return pw;
	}

	@Override
	public void deleteOperatoer(int oprID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editOperatoer(int oprID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNewPassword(int oprID, String password) {
		// TODO Auto-generated method stub

		if(isValid(password)){
			try {
				dao.getOperatoer(oprID).setPassword(password);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
		//Kontrollerer om password er gyldigt IKKE FÆRDIGT
		public boolean isValid(String password){
			
			boolean isValid = false;
			int count = 1;
			String[] specielSigns = {".","-","_","+","!","?","="};
			
			if(password.length() <= 6){
				isValid = false;
			}else {
				for(int i = 0; i < password.length(); i++){
					if (Character.isLetterOrDigit(password.charAt(i)) & specielSigns.equals(password.charAt(i)) ){
							isValid = true;
						}else {
							isValid = false;
						}
					}
				}
			
			return isValid;
		}


	@Override
	public int tellNetto(int tara, int brutto) {
		return brutto-tara;
	}


	@Override
	public void createSysAdmin() { //TODO: Throw exception?
        String oprNavn = "SysAdmin";
        String cpr = null;
        String password = "02324it!";
        try {
			dao.createOperatoer(oprNavn, cpr, password);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public IOperatoerDTO getOperator(int oprID) {
		try {
			return dao.getOperatoer(oprID);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
