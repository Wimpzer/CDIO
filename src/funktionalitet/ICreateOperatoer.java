package funktionalitet;

public interface ICreateOperatoer {

	boolean checkPassword(int oprID, String password);
	void createOperatoer();
	String generatePassword();
	void deleteOperatoer(int oprID);
	void editOperatoer(int oprID);
	void setNewPassword(int oprID, String password);
	void tellNetto();
	
	
}