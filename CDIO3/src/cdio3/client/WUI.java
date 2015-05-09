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
	Label loginfailed = new Label("Brugernavn eller kodeord er forkert.");
	Label loginsucces = new Label("Du er nu logget ind.");
	Label chngpswdcomment = new Label("Hvad vil du ændre din adgangskode til?");
	Label chngnamecomment = new Label("Hvad vil du ændre dit navn til?");
	Label chngpswdsuccess = new Label("Du har nu ændret kodeord.");
	Label chngnamesuccess = new Label("Du har nu ændret navn.");
	Label oprdelsuccess = new Label ("Brugeren er nu slettet.");
	Label usernotfound = new Label ("Brugeren blev ikke fundet");
	Label createusercomment = new Label ("Opret bruger nedenfor:");
	Label createuserid = new Label ("Indtast brugerens ID: ");
	Label createuseracc = new Label ("Indtast brugerens navn: ");
	Label createuserpass = new Label ("Indtast brugerens kodeord: ");
	Label createuserini = new Label ("Indtast initialer: ");
	Label createusercpr = new Label ("Indtast brugerens cpr nummer: ");
	Label createusersuccess = new Label ("Brugeren er nu oprettet.");
	Label changeuseracc = new Label ("Indtast brugerens navn: ");
	Label changeuseraccnew = new Label ("Indtast brugerens nye navn: ");
	Label changeuserpassnew = new Label ("Indtast brugerens nye kodeord: ");
	
	//Input boxes
	TextBox textbox = new TextBox();
	TextBox acc = new TextBox();
	PasswordTextBox pass = new PasswordTextBox();
	PasswordTextBox passchng = new PasswordTextBox();
	TextBox namechng = new TextBox();
	TextBox delopr = new TextBox();
	TextBox createuseridio = new TextBox ();
	TextBox createuseraccio = new TextBox ();
	PasswordTextBox createuserpassio = new PasswordTextBox ();
	TextBox createuseriniio = new TextBox ();
	TextBox createusercprio = new TextBox ();
	TextBox updateuserAccOld = new TextBox();
	TextBox updateuserAccNew = new TextBox();
	PasswordTextBox updateuserPassNew = new PasswordTextBox();

	//Variables
	boolean loggedin = false;
	boolean operatoer = true;
	OperatoerDTO userlist;
	TransientLayer brugere = new TransientLayer();
	public int choice = 0;
	ArrayList<OperatoerDTO> oprList = new ArrayList<OperatoerDTO>();
	String accountname;
	String password;
	

	// Buttons
	Button loginbtn = new Button();
	Button chngpswdbtn = new Button();
	Button chngnamebtn = new Button();
	Button delbtn = new Button();
	Button createbtn = new Button();
	Button adminchnguserbtn = new Button();
	Button adminchngpassbtn = new Button();


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
		loginbtn.setText("Send");
		this.contentPanel.add(accdesc);
		this.contentPanel.add(acc);
		this.contentPanel.add(passdesc);
		this.contentPanel.add(pass);
		this.contentPanel.add(loginbtn);
	}

	
	@Override
	public void openAdminUpdateUserAcc() {
		this.contentPanel.clear();
		adminchnguserbtn.addClickHandler(new updateaccClickHandler());
		adminchnguserbtn.setText("Send");
		this.contentPanel.add(changeuseracc);
		this.contentPanel.add(updateuserAccOld);
		this.contentPanel.add(changeuseraccnew);
		this.contentPanel.add(updateuserAccNew);
		this.contentPanel.add(adminchnguserbtn);
	}

	@Override
	public void openAdminUpdateUserPass() {
		this.contentPanel.clear();
		adminchngpassbtn.addClickHandler(new updatepassClickHandler());
		adminchngpassbtn.setText("Send");
		this.contentPanel.add(changeuseracc);
		this.contentPanel.add(updateuserAccOld);
		this.contentPanel.add(changeuserpassnew);
		this.contentPanel.add(updateuserPassNew);
		this.contentPanel.add(adminchngpassbtn);
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
		chngpswdbtn.addClickHandler(new chngpswdbtnClickHandler());
		chngpswdbtn.setText("Send");
		contentPanel.add(chngpswdcomment);
		contentPanel.add(passchng);
		contentPanel.add(chngpswdbtn);
		
		
		
		

	}

	@Override
	public void openChangeName() {
		this.contentPanel.clear();
		chngnamebtn.addClickHandler(new chngnamebtnClickHandler());
		chngnamebtn.setText("Send");
		contentPanel.add(chngnamecomment);
		contentPanel.add(namechng);
		contentPanel.add(chngnamebtn);
 
	}

	@Override
	public void openOperatorList() {
		this.contentPanel.clear();
		Label namelistcomment = new Label("Operatør navne opstillet nedenfor: ");
		contentPanel.add(namelistcomment);
		for (OperatoerDTO name : oprList){
			Label oprnamelist = new Label(name.getOprNavn());	
			contentPanel.add(oprnamelist);
		}

	}

	@Override
	public void openCreateUser() {
		this.contentPanel.clear();
		contentPanel.add(createusercomment);
		contentPanel.add(createuseracc);
		contentPanel.add(createuseraccio);
		contentPanel.add(createuserpass);
		contentPanel.add(createuserpassio);
		contentPanel.add(createuserini);
		contentPanel.add(createuseriniio);
		contentPanel.add(createusercpr);
		contentPanel.add(createusercprio);
		contentPanel.add(createuserid);
		contentPanel.add(createuseridio);
		createbtn.addClickHandler(new createbtnClickHandler());
		createbtn.setText("Send");
		contentPanel.add(createbtn);
		
		
	}

	@Override
	public void openUpdateUser() {
		this.contentPanel.clear();

	}

	@Override
	public void openDeleteUser() {
		this.contentPanel.clear();
		Label namelistcomment = new Label("Indtast navnet på den person som skal slettes: ");
		contentPanel.add(namelistcomment);
		delbtn.addClickHandler(new delbtnClickHandler());
		delbtn.setText("Send");
		contentPanel.add(delopr);
		contentPanel.add(delbtn);
		

	}
	
	@Override
	public void setAccountname(String accountname) {
		this.accountname = accountname;
		
	}
	
	@Override
	public String getAccountname(){
		return accountname;
	}
	
	@Override
	public String getPassword(){
		return password;
	}
	
	@Override
	public void setPassword(String password){
		this.password = password;
	}
	
	private class updateaccClickHandler implements ClickHandler{
		public void onClick(ClickEvent event){
			if (loggedin && operatoer){
				int i = 0;
					while(!oprList.isEmpty()){
						if(oprList.get(i).getOprNavn().equals(updateuserAccOld.getValue())){
							oprList.get(i).setOprNavn(updateuserAccNew.getValue());
							contentPanel.add(chngnamesuccess);
							break;
						}
						i++;
					}
				
				}
			}
		}
	
	private class updatepassClickHandler implements ClickHandler{
		public void onClick(ClickEvent event){
			if (loggedin && operatoer){
				int i = 0;
					while(!oprList.isEmpty()){
						if(oprList.get(i).getOprNavn().equals(updateuserAccOld.getValue())){
							oprList.get(i).setPassword(updateuserPassNew.getValue());
							contentPanel.add(chngpswdsuccess);
							break;
						}
						i++;
					}
				}
			}
		}
	
	//Create user button handler
	private class createbtnClickHandler implements ClickHandler{
		public void onClick(ClickEvent event){
			if (loggedin && operatoer){
				OperatoerDTO newuser = new OperatoerDTO(Integer.parseInt(createuseridio.getValue()), createuseraccio.getValue(), createuseriniio.getValue(), createusercprio.getValue(), createuserpassio.getValue());
				oprList.add(newuser);
				contentPanel.add(createusersuccess);
			}
		}
	}
	
	//Delete user button handler
	private class delbtnClickHandler implements ClickHandler{
		public void onClick(ClickEvent event){
			if (loggedin && operatoer){
				int i = 0;
				while(!oprList.isEmpty()){
					if(oprList.get(i).getOprNavn().equals(delopr.getValue())){
						oprList.remove(i);
						contentPanel.add(oprdelsuccess);
						break;	
					}
					i++;
				}
				contentPanel.add(usernotfound);
			}
		}
	}

	//Change password button handler
	private class chngpswdbtnClickHandler implements ClickHandler{
		public void onClick(ClickEvent event){
			if (loggedin){
				int i=0;
				while(!oprList.isEmpty()){
					if(oprList.get(i).getOprNavn().equals(accountname)){
						oprList.get(i).setPassword(passchng.getValue());
						setPassword(passchng.getValue());
						contentPanel.add(chngpswdsuccess);	
						break;
					}
					i++;
				}
			}
		}
	}
	
	// Change name button handler
	private class chngnamebtnClickHandler implements ClickHandler{
		public void onClick(ClickEvent event){
			if (loggedin){
				int i=0;
				while(!oprList.isEmpty()){
					if(oprList.get(i).getOprNavn().equals(accountname)){
						oprList.get(i).setOprNavn(namechng.getValue());
						setAccountname(namechng.getValue());
						contentPanel.add(chngnamesuccess);	
						break;
					}
					i++;
				}
			}
		}
	}
	
	
	//Login button handler
	private class loginbtnClickHandler implements ClickHandler{
		public void onClick(ClickEvent event){
			String accountname = acc.getValue();
			String password = pass.getValue();
		
			int i = 0;

			while(!oprList.isEmpty()){
				if(oprList.get(i).getOprNavn().equals(accountname)){
					if(oprList.get(i).getPassword().equals(password)){
						loggedin = true;
						setAccountname(accountname);
						setPassword(password);
						menu.InitMenu(loggedin, operatoer);
						contentPanel.clear();
						contentPanel.add(loginsucces);
						break;
					}
					else{
						contentPanel.add(loginfailed);
					}
				}
				else{
					contentPanel.add(loginfailed);
				}
				i++;
			}

		}
	}
}
