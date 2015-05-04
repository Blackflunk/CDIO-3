package cdio3.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

import edu.example.client.MenuView.LS1ClickHandler;
import edu.example.client.MenuView.LS2ClickHandler;

public class Menu extends Composite {
	private HorizontalPanel hPanel = new HorizontalPanel();
	private WUI wui;
	boolean loggedin = false;
	

	public Menu (WUI wui){
		initWidget(this.hPanel);
		this.wui = wui;
		
		if (loggedin)
			loggedinButtons();
		else
			loggedoutButtons();
			
	
	}
	
	public void loggedinButtons(){
		Button login = new Button("Login");
		login.addClickHandler(new LS1ClickHandler());
		this.hPanel.add(login);
		
		Button createaccount = new Button("Create account");
		createaccount.addClickHandler(new LS2ClickHandler());
		this.hPanel.add(createaccount);
		
		Button exitsite = new Button("Exit site");
		exitsite.addClickHandler(new LS1ClickHandler());
		this.hPanel.add(exitsite);
	}
	
	public void loggedoutButtons(){
		Button accman = new Button("Account management");
		accman.addClickHandler(new LS1ClickHandler());
		this.hPanel.add(accman);
		
		Button logout = new Button("Logout");
		logout.addClickHandler(new LS2ClickHandler());
		this.hPanel.add(logout);
	}
}
