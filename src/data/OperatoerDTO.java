package data;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import data.IOperatoerDAO.DALException;

public class OperatoerDTO implements IOperatoerDTO {

	int oprId;                     
	String oprNavn;                
	String ini;                 
	String cpr;                 
	String password;
	String newpassword1;

	
	public OperatoerDTO(int oprID, String oprNavn, String cpr, String password){
		this.oprId = oprID;
		this.oprNavn = oprNavn;
		this.cpr = cpr;
		this.password = password;
	}

	private ArrayList<OperatoerDTO> Operatoer;
	public OperatoerDTO(){
	    
			Operatoer = new ArrayList<OperatoerDTO>();
			// vi tilføjer personer
			Operatoer.add(new OperatoerDTO(1,"Omar","280293-1234","omarjuve12"));
            Operatoer.add(new OperatoerDTO(2,"Bjarje","123456-1234","1234aB!"));
            Operatoer.add(new OperatoerDTO(3,"Frederik","123456-1234","1234ab!"));
            Operatoer.add(new OperatoerDTO(4,"Andreas","123456-1234","1234ab"));
            Operatoer.add(new OperatoerDTO(5,"Aleksander","123456-1234","1234ab"));
            Operatoer.add(new OperatoerDTO(6,"joakim","123456-1234","1234ab"));
			
	}
	public void createOperatoer(OperatoerDTO opr) throws DALException {
        int i = 0;
        int l = 10;
        int oprOprId = opr.oprId;
        Object newPassword1;
		while(!opr.password.equals(newPassword1)&&i<5){
        newPassword1 = JOptionPane.showInputDialog("Indtast dit password.");
        
            try{
                if(opr.oprId==10&&opr.password.equals(newPassword1)){
                 oprNavn = JOptionPane.showInputDialog("Skriv navnet paa brugeren du oensker, at oprette.");
               cpr = JOptionPane.showInputDialog("indtast cpr nummer på brugeren.");
                Operatoer.add(new OperatoerDTO(Operatoer.size()+l,oprNavn,cpr,password)); 
               System.out.println("kodeordet for denne bruger er: " + password + "og den har idÂ´et " + Operatoer.size()+l);
                }}
            if(!opr.password.equals(newPassword1)){
                JOptionPane e;
				System.err.println("fejl"+e.getMessage());
                System.out.println("Forkert kodeord.");
            }
        }
    i++;}
  
	/* (non-Javadoc)
	 * @see data.IOperatoerDTO#getOprId()
	 */
	@Override
	public int getOprId() {
		return oprId;
	}
	/* (non-Javadoc)
	 * @see data.IOperatoerDTO#setOprId(int)
	 */
	@Override
	public void setOprId(int oprId) {
		this.oprId = oprId;
	}
	/* (non-Javadoc)
	 * @see data.IOperatoerDTO#getOprNavn()
	 */
	@Override
	public String getOprNavn() {
		return oprNavn;
	}
	/* (non-Javadoc)
	 * @see data.IOperatoerDTO#setOprNavn(java.lang.String)
	 */
	@Override
	public void setOprNavn(String oprNavn) {
		this.oprNavn = oprNavn;
	}
	/* (non-Javadoc)
	 * @see data.IOperatoerDTO#getIni()
	 */
	@Override
	public String getIni() {
		return ini;
	}
	/* (non-Javadoc)
	 * @see data.IOperatoerDTO#setIni(java.lang.String)
	 */
	@Override
	public void setIni(String ini) {
		this.ini = ini;
	}
	/* (non-Javadoc)
	 * @see data.IOperatoerDTO#getCpr()
	 */
	@Override
	public String getCpr() {
		return cpr;
	}
	/* (non-Javadoc)
	 * @see data.IOperatoerDTO#setCpr(java.lang.String)
	 */
	@Override
	public void setCpr(String cpr) {
		this.cpr = cpr;
	}
	/* (non-Javadoc)
	 * @see data.IOperatoerDTO#getPassword()
	 */
	@Override
	public String getPassword() {
		return password;
	}
	/* (non-Javadoc)
	 * @see data.IOperatoerDTO#setPassword(java.lang.String)
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}

}
