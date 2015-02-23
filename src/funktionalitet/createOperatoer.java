package funktionalitet;

import java.security.SecureRandom;
import java.util.Random;

public class createOperatoer {

	public static String generatePassword(){

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

	
}
