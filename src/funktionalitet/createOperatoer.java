package funktionalitet;

import java.security.SecureRandom;
import java.util.Random;
import java.lang.*;

import data.IOperatoerDAO;
import data.IOperatoerDAO.DALException;

public class createOperatoer implements ICreateOperatoer {
	IOperatoerDAO dao;

	public createOperatoer(IOperatoerDAO dao) {
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
	public void createOperatoer() {
		// TODO Auto-generated method stub

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
	public void tellNetto() {
		// TODO Auto-generated method stub

	}


}
