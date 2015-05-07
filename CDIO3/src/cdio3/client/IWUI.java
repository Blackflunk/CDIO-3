package cdio3.client;

public interface IWUI {

	//Pre login
	public void openCreateAccount();
	public void openLoginAccount();
	
	//Post login
	public void openLogoutAccount();
	//Account submenu
	public void openChangePassword();
	public void openChangeName();
	
	//Admin menu
	public void openOperatorList();
	//Admin submenu
	public void openCreateUser();
	public void openUpdateUser();
	public void openDeleteUser();
	public void setAccountname(String accountname);
	public String getAccountname();
	public String getPassword();
	public void setPassword(String password);
}
 