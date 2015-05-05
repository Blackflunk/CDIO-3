package cdio3.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.MenuItem;

public class MenuBar extends Composite {
	

	private static MenuBarUiBinder uiBinder = GWT.create(MenuBarUiBinder.class);
	private WUI wui;
	boolean loggedin = true;
	boolean operatoer = true;
	boolean running = true;
	@UiField MenuItem login;
	@UiField MenuItem createaccount;
	@UiField MenuItem exit;
	@UiField com.google.gwt.user.client.ui.MenuBar menubar;
	@UiField MenuItem accountmanagement;
	@UiField MenuItem logout;
	@UiField MenuItem adminmenu;
	@UiField MenuItem createuser;
	@UiField MenuItem oplist;
	@UiField MenuItem updateuser;
	@UiField MenuItem deluser;

	interface MenuBarUiBinder extends UiBinder<Widget, MenuBar> {
	}

	public MenuBar(WUI wui) {
		initWidget(uiBinder.createAndBindUi(this));
		this.wui=wui;
		
		login.setScheduledCommand(cmd_login);
		createaccount.setScheduledCommand(cmd_createaccount);
		exit.setScheduledCommand(cmd_exit);	
		accountmanagement.setScheduledCommand(cmd_accountmanagement);
		logout.setScheduledCommand(cmd_logout);
		
	}
	
	public void InitMenu(){
			if(loggedin){
				loggedinMenu();
			}
			else{
				loggedoutMenu();
			}
	}
		
	
	Command cmd_login= new Command(){ 
		@Override
		public void execute() {
			wui.openLoginAccount();
		}
	};
	
	Command cmd_createaccount= new Command(){ 
		@Override
		public void execute() {
			wui.openCreateAccount();

		}
	};
	
	Command cmd_exit= new Command(){ 
		@Override
		public void execute() {
			wui.openExitSite();
		}
	};
	
	Command cmd_logout= new Command(){ 
		@Override
		public void execute() {
			wui.openLogoutAccount();
		}
	};
	
	Command cmd_accountmanagement= new Command(){ 
		@Override
		public void execute() {
			wui.openAccountManagement();
		}
	};

	public boolean isLoggedin() {
		return loggedin;
	}

	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}
	
	public void loggedoutMenu(){
		menubar.clearItems();
		menubar.setVisible(true);
		menubar.insertItem(login, 0);
		menubar.insertItem(createaccount, 1);
		menubar.insertItem(exit, 2);
	}
	
	public void loggedinMenu(){
		menubar.clearItems();
		menubar.setVisible(true);
		menubar.insertItem(logout, 0);
		menubar.insertItem(accountmanagement, 1);
		
		if(operatoer){
			menubar.insertSeparator(2);
			menubar.insertItem(adminmenu, 3);
			menubar.insertItem(oplist, 4);
		}
	}

}
