package cdio3.client;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class WUI extends Composite implements IWUI {
	//Panels
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	MenuBar menu;

	//Text
	Label accdesc = new Label("Skriv brugernavn:");
	Label passdesc = new Label("Skriv adgangskode: ");
	Label loginfailed = new Label("Der er opstået en fejl i login.");
	Label loginsucces = new Label("Du er nu logget ind.");

	//Input boxes
	TextBox textbox = new TextBox();
	TextBox acc = new TextBox();
	PasswordTextBox pass = new PasswordTextBox();

	//Variables
	boolean loggedin = false;
	boolean operatoer = true;
	OperatoerDTO userlist;
	TransientLayer brugere = new TransientLayer();
	public int choice = 0;
	ArrayList<OperatoerDTO> oprList = new ArrayList<OperatoerDTO>();
	

	// Buttons
	Button loginbtn = new Button();


	public WUI() {
		initWidget(this.vPanel);

		oprList = brugere.getTransientDB();
		
		this.vPanel.setBorderWidth(1);
		this.vPanel.setWidth("600px");

		menu = new MenuBar(this);
		this.vPanel.add(menu);

		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);

	}

	@Override
	// En mulighed før brugeren er logget ind.
	public void openCreateAccount() {
		this.contentPanel.clear();
		this.contentPanel.add(textbox);
	}


	@Override
	// En mulighed før brugeren er logget ind.
	public void openLoginAccount() {
		this.contentPanel.clear();
		loginbtn.addClickHandler(new loginbtnClickHandler());
		menu.InitMenu(loggedin, operatoer);
		this.contentPanel.add(accdesc);
		this.contentPanel.add(acc);
		this.contentPanel.add(passdesc);
		this.contentPanel.add(pass);
		this.contentPanel.add(loginbtn);
	}




	@Override
	// En mulighed når brugeren er logget ind.
	public void openLogoutAccount() {
		loggedin = false;
		this.contentPanel.clear();

		menu.InitMenu(loggedin, operatoer);
		Label textLabel = new Label("Du er logget ud.");
		this.contentPanel.add(textLabel);
	}

	@Override
	public void openChangePassword() {
		this.contentPanel.clear();

	}

	@Override
	public void openChangeName() {
		this.contentPanel.clear();

	}

	@Override
	public void openOperatorList() {
		this.contentPanel.clear();

	}

	@Override
	public void openCreateUser() {
		this.contentPanel.clear();

	}

	@Override
	public void openUpdateUser() {
		this.contentPanel.clear();

	}

	@Override
	public void openDeleteUser() {
		this.contentPanel.clear();

	}


	private class loginbtnClickHandler implements ClickHandler{
		public void onClick(ClickEvent event){
			String accountname = acc.getValue();
			String password = pass.getValue();
			int i = 0;

			while(!oprList.isEmpty()){
				if(oprList.get(i).getOprNavn().equals(accountname)){
					if(oprList.get(i).getPassword().equals(password)){
						loggedin = true;
						menu.InitMenu(loggedin, operatoer);
						contentPanel.clear();
						contentPanel.add(loginsucces);
						break;
					}
					else{
						loginbtn.setText("Forkert kodeord");
					}
				}
				else{
					loginbtn.setText("Forkert brugernavn");
				}
				i++;
			}

		}
	}
}
