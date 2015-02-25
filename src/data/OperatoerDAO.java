package data;

import java.util.ArrayList;
import java.util.List;

public class OperatoerDAO implements IOperatoerDAO {
	List<IOperatoerDTO> operators = new ArrayList<IOperatoerDTO>();
	
	@Override
	public IOperatoerDTO getOperatoer(int oprId) throws DALException {
		return operators.get(oprId-10);
	}

	@Override
	public List<IOperatoerDTO> getOperatoerList() throws DALException {
		return operators;
	}

	@Override
	public void createOperatoer(String oprNavn, String cpr, String password) throws DALException {
		IOperatoerDTO opr = new OperatoerDTO(getOperatoerList().size()+10, oprNavn, cpr, password);
		operators.add(opr);
	}

	@Override
	public void updateOperatoer(IOperatoerDTO opr) throws DALException {
		operators.set(opr.getOprId(), opr);		
	}

}
