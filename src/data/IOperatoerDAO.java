package data;

import java.util.List;

public interface IOperatoerDAO {

	IOperatoerDTO getOperatoer(int oprId) throws DALException;
	List<IOperatoerDTO> getOperatoerList() throws DALException;
	void createOperatoer(String oprNavn, String cpr, String password) throws DALException;
	void updateOperatoer(IOperatoerDTO opr) throws DALException;
	
	
	public class DALException extends Exception{
		
		private String er;
		
		public String toString(){
			er = "fejl";
			return er;
		}
		
	}
	
}
