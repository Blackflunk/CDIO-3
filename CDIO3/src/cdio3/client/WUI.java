package cdio3.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class WUI extends Composite implements IWUI {
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	
	
	public WUI() {
		initWidget(this.vPanel);
		this.vPanel.setBorderWidth(1);
		
		Menu menu = new Menu(this);
		this.vPanel.add(menu);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
		
		Label textLabel = new Label("Tryk en knap for at se et landskab!");
		this.contentPanel.add(textLabel);
	}


	@Override
	// En mulighed før brugeren er logget ind.
	public void openCreateAccount() {
		this.contentPanel.clear();
		
	}


	@Override
	// En mulighed før brugeren er logget ind.
	public void openLoginAccount() {
		// TODO Auto-generated method stub
		
	}


	@Override
	// Altid en mulighed.
	public void ExitSite() {
		// TODO Auto-generated method stub
		
	}


	@Override
	// Åbnes når bruger er logget ind.
	public void openAccountManagement() {
		
		
	}


	@Override
	// En mulighed når brugeren er logget ind.
	public void logOut() {
		// TODO Auto-generated method stub
		
	}
	
	
}
