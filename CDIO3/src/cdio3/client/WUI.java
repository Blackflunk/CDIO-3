package cdio3.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class WUI extends Composite implements IWUI {
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	MenuBar menu;
	
	
	public WUI() {
		initWidget(this.vPanel);
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
		Label textLabel = new Label("Her kan du oprette bruger.");
		TextBox textbox = new TextBox();
		this.contentPanel.add(textLabel);
		this.contentPanel.add(textbox);
	}


	@Override
	// En mulighed før brugeren er logget ind.
	public void openLoginAccount() {
		this.contentPanel.clear();
		Label textLabel = new Label("Her kan du logge ind.");
		this.contentPanel.add(textLabel);
		
	}


	@Override
	// Altid en mulighed.
	public void openExitSite() {
		this.contentPanel.clear();
		Label textLabel = new Label("Du har logget ud og lukket.");
		this.contentPanel.add(textLabel);
		
	}


	@Override
	// Åbnes når bruger er logget ind.
	public void openAccountManagement() {
		this.contentPanel.clear();
		Label textLabel = new Label("Her er dine bruger indstillinger.");
		this.contentPanel.add(textLabel);
		
	}


	@Override
	// En mulighed når brugeren er logget ind.
	public void openLogoutAccount() {
		this.contentPanel.clear();
		Label textLabel = new Label("Du er logget ud.");
		this.contentPanel.add(textLabel);
	}
	
	
}
