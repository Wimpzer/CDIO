package funktionalitet;

import java.util.List;

import data.IOperatoerDTO;
import data.OperatoerDTO;

public class OperatoerDAO implements IOperatoerDAO {
	IOperatoerDTO dto;
	
	public OperatoerDAO(IOperatoerDTO dto) {
		this.dto = dto;
	}

	@Override
	public IOperatoerDTO getOperatoer(int oprId) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OperatoerDTO> getOperatoerList() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createOperatoer(IOperatoerDTO opr) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOperatoer(IOperatoerDTO opr) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
