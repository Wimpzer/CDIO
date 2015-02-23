package data;

import java.util.ArrayList;
import java.util.List;

public class OperatoerDAO implements IOperatoerDAO {
	List<IOperatoerDTO> operators = new ArrayList<IOperatoerDTO>();
	
	@Override
	public IOperatoerDTO getOperatoer(int oprId) throws DALException {
		return operators.get(oprId);
	}

	@Override
	public List<IOperatoerDTO> getOperatoerList() throws DALException {
		return operators;
	}

	@Override
	public void createOperatoer(IOperatoerDTO opr) throws DALException {
		operators.add(opr);		
	}

	@Override
	public void updateOperatoer(IOperatoerDTO opr) throws DALException {
		operators.set(opr.getOprId(), opr);		
	}

}
