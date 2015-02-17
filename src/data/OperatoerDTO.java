package data;

public class OperatoerDTO implements IOperatoerDTO {

	int oprId;                     
	String oprNavn;                
	String ini;                 
	String cpr;                 
	String password;


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
