package funktionalitet;

import java.util.List;

import data.IOperatoerDTO;
import data.OperatoerDTO;

public interface IOperatoerDAO {

	IOperatoerDTO getOperatoer(int oprId) throws DALException;
	List<OperatoerDTO> getOperatoerList() throws DALException;
	void createOperatoer(IOperatoerDTO opr) throws DALException;
	void updateOperatoer(IOperatoerDTO opr) throws DALException;
	
	
	public class DALException extends Exception{
		
		private String er;
		
		public String toString(){
			er = "fejl";
			return er;
		}
		
	}
	
}
