package data;

public interface IOperatoerDAO {

	OperatoerDTO getOperatoer(int oprId) throws DALException;
	List<OperatoerDTO> getOperatoerList() throws DALException;
	void createOperatoer(OperatoerDTO opr) throws DALException;
	void updateOperatoer(OperatoerDTO opr) throws DALException;
	
	
	public class DALException extends Exception{
		
		private String er;
		
		public String toString(){
			return er;
		}
		
	}
	
}
