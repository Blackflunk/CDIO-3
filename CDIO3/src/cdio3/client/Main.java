package cdio3.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Main implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		WUI wui = new WUI();
		RootPanel.get().add(wui);
		wui.menu.InitMenu();
			
	}
}
