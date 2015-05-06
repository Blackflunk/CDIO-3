package cdio3.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Button;

public class MenuBar extends Composite {
	

	private static MenuBarUiBinder uiBinder = GWT.create(MenuBarUiBinder.class);
	private WUI wui;
	@UiField MenuItem login;
	@UiField MenuItem createaccount;
	@UiField com.google.gwt.user.client.ui.MenuBar menubar;
	@UiField MenuItem logout;
	@UiField MenuItem adminmenu;
	@UiField MenuItem createuser;
	@UiField MenuItem oplist;
	@UiField MenuItem updateuser;
	@UiField MenuItem deluser;
	@UiField MenuItem accountmanagement;
	@UiField MenuItem changename;
	@UiField MenuItem changepassword;

	interface MenuBarUiBinder extends UiBinder<Widget, MenuBar> {
	}

	public MenuBar(WUI wui) {
		initWidget(uiBinder.createAndBindUi(this));
		this.wui=wui;
		
		login.setScheduledCommand(cmd_login);
		createaccount.setScheduledCommand(cmd_createaccount);
		logout.setScheduledCommand(cmd_logout);
		createuser.setScheduledCommand(cmd_createuser);
		oplist.setScheduledCommand(cmd_oplist);
		updateuser.setScheduledCommand(cmd_updateuser);
		deluser.setScheduledCommand(cmd_deluser);
		changename.setScheduledCommand(cmd_changename);
		changepassword.setScheduledCommand(cmd_changepassword);
		
	}
	
	//Initialiserer menuen
	public void InitMenu(boolean loggedin, boolean operatoer){
			if(loggedin){
				loggedinMenu(operatoer);
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
	
	Command cmd_logout= new Command(){ 
		@Override
		public void execute() {
			wui.openLogoutAccount();
		}
	};
	
	Command cmd_createuser= new Command(){ 
		@Override
		public void execute() {
			wui.openCreateUser();
		}
	};
	
	Command cmd_oplist= new Command(){ 
		@Override
		public void execute() {
			wui.openOperatorList();
		}
	};
	
	Command cmd_updateuser= new Command(){ 
		@Override
		public void execute() {
			wui.openUpdateUser();
		}
	};
	
	Command cmd_deluser= new Command(){ 
		@Override
		public void execute() {
			wui.openDeleteUser();
		}
	};
	
	Command cmd_changepassword= new Command(){ 
		@Override
		public void execute() {
			wui.openChangePassword();
		}
	};
	
	Command cmd_changename= new Command(){ 
		@Override
		public void execute() {
			wui.openChangeName();
		}
	};

	public void loggedoutMenu(){
		menubar.clearItems();
		menubar.setVisible(true);
		menubar.insertItem(login, 0);
		menubar.insertItem(createaccount, 1);
	}
	
	public void loggedinMenu(boolean operatoer){
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
