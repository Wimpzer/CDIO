package grænseflade;

public interface IBrugergrænseflade {

	public void showOutput(String string);
	
	public abstract void inputMenu();

	public abstract void exit();

	public abstract void systemAdmin();

	public abstract void typePassword();

	public abstract void systemAdminMenu();

	public abstract void wrongPassword();
	
	public abstract void getPasswordLastUser();

}