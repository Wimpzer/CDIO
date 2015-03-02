package funktionalitet;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import data.IOperatoerDAO;
import data.IOperatoerDAO.DALException;
import data.IOperatoerDTO;

public class CreateOperatoer implements ICreateOperatoer {
	IOperatoerDAO dao;

	public CreateOperatoer(IOperatoerDAO dao) {
		this.dao = dao;
	}


	@Override
	public boolean checkPassword(int oprID, String password) {

		boolean valid = false;

		try {
			if(dao.getOperatoer(oprID).getPassword().equals(password)){

				valid = true;

			}

		} catch (DALException e) {
			e.printStackTrace();
		}

		return valid;
	}

	@Override
	public void createOperatoer(String oprNavn, String cpr) throws DALException {
		String password = generatePassword();
			dao.createOperatoer(oprNavn, cpr, password);
	}

	public String generatePassword(){

		final Random RANDOM = new SecureRandom();

		final int PASSWORD_LENGHT = 8;

		String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890.-_+!?=";

		String pw = "";

		for(int i = 0;i < PASSWORD_LENGHT; i++){
			int index = (int) (RANDOM.nextDouble()*letters.length());
			pw += letters.substring(index, index+1);
		}

		return pw;
	}

	@Override
	public void deleteOperatoer(int oprID) throws DALException {
		dao.removeOperatoer(oprID);
	}

	@Override
	public void editOperatorName(int oprID, String oprName) throws DALException {
		IOperatoerDTO opr = getOperator(oprID);
		opr.setOprNavn(oprName);
		dao.updateOperatoer(opr);
		
	}


	@Override
	public void editOperatorCPR(int oprID, String CPR) throws DALException {
		IOperatoerDTO opr = getOperator(oprID);
		opr.setOprNavn(CPR);
		dao.updateOperatoer(opr);
	}


	@Override
	public void editOperatorPassword(int oprID, String password) throws DALException {
		dao.getOperatoer(oprID).setPassword(password);
	}
	
	@Override
	public boolean isValid(String password){

		boolean isValid = false;
		String[] specielSigns = {".","-","_","+","!","?","="};

		if(password.length() <= 6){
			isValid = false;
		}else {
			for(int i = 0; i < password.length(); i++){
				if (Character.isLetterOrDigit(password.charAt(i)) || specielSigns.equals(password.charAt(i)) ){
					isValid = true;
				}else {
					isValid = false;
					i = password.length();
				}
			}
		}

		return isValid;
	}


	@Override
	public int tellNetto(int tara, int brutto) {
		return brutto-tara;
	}


	@Override
	public void createSysAdmin() throws DALException {
		String oprNavn = "SysAdmin";
		String cpr = null;
		String password = "02324it!";
		dao.createOperatoer(oprNavn, cpr, password);
	}


	@Override
	public IOperatoerDTO getOperator(int oprID) {
		try {
			return dao.getOperatoer(oprID);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<String> getOperatorList() throws DALException {
		List<IOperatoerDTO> list = dao.getOperatoerList();
		List<String> stringList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			String string = list.get(i).getOprId() + list.get(i).getOprNavn();
			stringList.add(string);
		}
		return stringList;
	}





}
