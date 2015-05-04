package cdio3.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class MenuLoggedout extends Composite {

	private static MenuLoggedoutUiBinder uiBinder = GWT
			.create(MenuLoggedoutUiBinder.class);
	@UiField Button login;
	@UiField Button createaccount;
	@UiField Button exit;

	interface MenuLoggedoutUiBinder extends UiBinder<Widget, MenuLoggedout> {
	}

	public MenuLoggedout() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("login")
	void onLoginClick(ClickEvent event) {
	}
	@UiHandler("createaccount")
	void onCreateaccountClick(ClickEvent event) {
	}
	@UiHandler("exit")
	void onExitClick(ClickEvent event) {
	}
}
