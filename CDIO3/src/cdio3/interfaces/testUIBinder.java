package cdio3.interfaces;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.ListBox;

public class testUIBinder extends Composite {
	OperatoerDTO userlist;
	TransientLayer brugere = new TransientLayer();;
	public int choice = 0;
	ArrayList<OperatoerDTO> oprList = new ArrayList<OperatoerDTO>();
	private static testUIBinderUiBinder uiBinder = GWT
			.create(testUIBinderUiBinder.class);
	@UiField FlexTable UItable;
	@UiField MenuItem sletListe;
	@UiField MenuItem operatoerListe;
	@UiField MenuItem logud;
	@UiField PasswordTextBox pwd;
	@UiField TextBox usrname;
	@UiField Button loginbtn;
	@UiField MenuBar menubar;
	@UiField MenuItem adminmenu;
	@UiField MenuItem createUser;
	@UiField MenuItem deleteUser;
	@UiField MenuItem updateUser;
	@UiField ListBox userList;
	@UiField Button delbtn;


	interface testUIBinderUiBinder extends UiBinder<Widget, testUIBinder> {
	}

	public testUIBinder() {
		initWidget(uiBinder.createAndBindUi(this));
		oprList = brugere.getTransientDB();
		menubar.setVisible(false);
		sletListe.setScheduledCommand(cmd_menuItem2);
		operatoerListe.setScheduledCommand(cmd_menuItem1);
		logud.setScheduledCommand(cmd_LogUd);
		createUser.setScheduledCommand(cmd_createUser);
		deleteUser.setScheduledCommand(cmd_deleteUser);
		updateUser.setScheduledCommand(cmd_updateUser);
		logud.setScheduledCommand(cmd_LogUd);
		userList.setVisible(false);
		delbtn.setVisible(false);
	}
	@UiHandler("userList")
	void ClickUserListEvent(ClickEvent event){
		choice = userList.getSelectedIndex();
		int i = 0;
		while(!oprList.isEmpty()){
			if(oprList.get(i).getOprNavn().equals(userList.getValue(choice))){
				choice = i;
				break;
			}
			i++;
		}
	}
	@UiHandler("delbtn")
	void ClickDelButtonEvent(ClickEvent event){
		oprList.remove(choice);
		userList.setVisible(false);
		delbtn.setVisible(false);
	}
	@UiHandler("loginbtn")
	void ClickLoginEvent(ClickEvent event){
		String username = usrname.getValue();
		String password = pwd.getValue();
		int i = 0;

		while(!oprList.isEmpty()){
			if(oprList.get(i).getOprNavn().equals(username)){
				if(oprList.get(i).getPassword().equals(password)){
					loginbtn.setText("Login");
					menubar.clearItems();
					menubar.setVisible(true);
					menubar.insertItem(adminmenu, 0);
					menubar.insertItem(operatoerListe, 1);
					menubar.insertItem(logud, 2);
					pwd.setVisible(false);;
					usrname.setVisible(false);
					loginbtn.setVisible(false);
				}else{
					loginbtn.setText("Wrong Password");
				}
			}
			i++;
		}
	}
	Command cmd_createUser= new Command(){ 
		@Override
		public void execute() {

		}
	};
	Command cmd_deleteUser= new Command(){ 
		@Override
		public void execute() {
			userList.clear();
			userList.setVisible(true);
			delbtn.setVisible(true);
			int i = 0;
			while(!oprList.isEmpty()){
				userList.addItem(oprList.get(i).getOprNavn());
				i++;
			}
		}
	};
	Command cmd_updateUser= new Command(){ 
		@Override
		public void execute() {

		}
	};
	Command cmd_LogUd= new Command(){ 
		@Override
		public void execute() {
			menubar.clearItems();
			menubar.setVisible(false);
			pwd.setVisible(true);
			pwd.setValue("Indtast Kodeord");
			usrname.setVisible(true);
			usrname.setValue("Indtast Brugernavn");
			loginbtn.setVisible(true);
			loginbtn.setText("Login");
		}
	};
	Command cmd_LoggedIn= new Command(){ 
		@Override
		public void execute() { 

		}
	};
	Command cmd_menuItem1= new Command(){ 
		@Override
		public void execute() { 
			brugere = new TransientLayer();
			oprList = brugere.getTransientDB();
			int j = 0;
			menubar.clearItems();
			menubar.addItem(adminmenu);
			menubar.addItem(sletListe);
			menubar.addItem(logud);
			while(!oprList.isEmpty()){
				UItable.setText(j, 0, oprList.get(j).getOprId() + " ,");
				UItable.setText(j, 1, oprList.get(j).getOprNavn() + " ,");
				UItable.setText(j, 2, oprList.get(j).getIni() + " ,");
				UItable.setText(j, 3, oprList.get(j).getCpr() + " ,");
				UItable.setText(j, 4, oprList.get(j).getPassword());
				j = j +1;
			}
		}
	};
	Command cmd_menuItem2= new Command(){ 
		@Override
		public void execute() { 
			UItable.removeAllRows();
			menubar.clearItems();
			menubar.addItem(adminmenu);
			menubar.addItem(operatoerListe);
			menubar.addItem(logud);
		}
	};
}
