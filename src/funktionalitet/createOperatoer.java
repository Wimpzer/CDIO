package funktionalitet;

import java.security.SecureRandom;
import java.util.Random;

public class CreateOperatoer implements ICreateOperatoer {

	@Override
	public boolean checkPassword(int oprID, String password) {
		// TODO Auto-generated method stub
		return false;
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
			int index = (int)(RANDOM.nextDouble()*letters.length());
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
		
	}

	@Override
	public void tellNetto() {
		// TODO Auto-generated method stub
		
	}

	
}
