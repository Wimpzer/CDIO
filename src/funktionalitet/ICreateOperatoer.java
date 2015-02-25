package funktionalitet;

import data.IOperatoerDTO;

public interface ICreateOperatoer {

	boolean checkPassword(int oprID, String password);
	void createOperatoer();
	String generatePassword();
	void deleteOperatoer(int oprID);
	void editOperatoer(int oprID);
	IOperatoerDTO getOperator(int oprID);
	void setNewPassword(int oprID, String password);
	int tellNetto(int tara, int brutto);
	void createSysAdmin();
	
	
	
}