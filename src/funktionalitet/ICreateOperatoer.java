package funktionalitet;

import java.util.List;

import data.IOperatoerDAO.DALException;
import data.IOperatoerDTO;

public interface ICreateOperatoer {

	boolean checkPassword(int oprID, String password);
	void createOperatoer(String oprNavn, String cpr) throws DALException;
	String generatePassword();
	void deleteOperatoer(int oprID) throws DALException;
	void editOperatorName(int oprID, String oprName) throws DALException;
	void editOperatorCPR(int oprID, String CPR) throws DALException;
	void editOperatorPassword(int oprID, String password) throws DALException;
	IOperatoerDTO getOperator(int oprID);
	List<String> getOperatorList() throws DALException;
	boolean isValid(String password);
	int tellNetto(int tara, int brutto);
	void createSysAdmin() throws DALException;
	
	
	
}