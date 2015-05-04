package cdio3.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

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
	
	public void loggedoutButtons(){
		Button login = new Button("Login");
		login.addClickHandler(new LoginClickHandler());
		this.hPanel.add(login);
		
		Button createaccount = new Button("Create account");
		createaccount.addClickHandler(new CreateAccountClickHandler());
		this.hPanel.add(createaccount);
		
		Button exitsite = new Button("Exit site");
		exitsite.addClickHandler(new ExitSiteClickHandler());
		this.hPanel.add(exitsite);
	}
	
	public void loggedinButtons(){
		Button accman = new Button("Account management");
		accman.addClickHandler(new AccountManagementClickHandler());
		this.hPanel.add(accman);
		
		Button logout = new Button("Logout");
		logout.addClickHandler(new LogoutClickHandler());
		this.hPanel.add(logout);
	}
	
	
	private class LoginClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			wui.openLoginAccount();
				
		}
	}
	
	private class LogoutClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			wui.openLogoutAccount();
				
		}
	}
	
	private class CreateAccountClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			wui.openCreateAccount();
				
		}
	}
	
	private class ExitSiteClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			wui.openExitSite();
				
		}
	}
	
	private class AccountManagementClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			wui.openAccountManagement();
				
		}
	}
}
