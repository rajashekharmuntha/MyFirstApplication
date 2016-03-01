package com.enterprise.restaurant.example.ui;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

import com.vaadin.data.validator.EmailValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;


public class LoginView extends CustomComponent implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextField userField;
	private PasswordField passwordField;
	private Button loginButton;
	private ComboBox branchCode;
	Label label;
	Label label1;
	public LoginView()
	{
		setSizeFull();
		Panel loginPanel = new Panel();
	//	loginPanel.setCaption("Enter Credentials");
		//loginPanel.addStyleName(ValoTheme.PANEL_BORDERLESS);
		
		loginPanel.setSizeUndefined();
		

		loginPanel.setContent(buildLayout());
		
		VerticalLayout contentLayout=new VerticalLayout();
		contentLayout.setSizeFull();
		contentLayout.setMargin(new MarginInfo(true,true,true,true));
		contentLayout.addComponent(loginPanel);
		contentLayout.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
		
		setCompositionRoot(contentLayout);

		
	}
	
	private VerticalLayout buildLayout() {
		userField=new TextField("Username : ");
		userField.setWidth("300px");
		userField.setRequired(true);
		userField.setInputPrompt("username");
		userField.setValue("Test");
		userField.setIcon(FontAwesome.USER);
		
		passwordField=new PasswordField("Password : ");
		passwordField.setWidth("300px");
		passwordField.setRequired(true);
		passwordField.setValue("Test");
		passwordField.setNullRepresentation("");
		passwordField.setIcon(FontAwesome.LOCK);
		
		
		ThemeResource resource = new ThemeResource("images/images.png");
		Image image = new Image("", resource);
		
		label=new Label();
		label.setValue("Enter Credentials ");
		label.addStyleName("loginLabel");

		label1=new Label();
		label1.setIcon(resource);
		
		
		
		HorizontalLayout taglayout=new HorizontalLayout();
		taglayout.setSizeFull();
		taglayout.setSpacing(true);
		taglayout.addComponent(label);
		taglayout.addComponent(image);

		taglayout.setComponentAlignment(label, Alignment.BOTTOM_LEFT);
		taglayout.setComponentAlignment(image, Alignment.BOTTOM_RIGHT);
		
		
		
		loginButton=new Button("Login");
		loginButton.setStyleName("primary");
		HorizontalLayout h_layout=new HorizontalLayout();
		h_layout.setSizeFull();
		h_layout.addComponent(loginButton);
		h_layout.setComponentAlignment(loginButton, Alignment.TOP_RIGHT);
		
		VerticalLayout fields=new VerticalLayout();
/*		fields.setCaption("Enter Credentials");
*/		fields.setSpacing(true);
		fields.setMargin(new MarginInfo(true,true,true,false));
		fields.setSizeFull();
		fields.addComponent(taglayout);
		fields.addComponent(userField);
		fields.addComponent(passwordField);
		
		fields.addComponent(h_layout);
		
		VerticalLayout viewLayout=new VerticalLayout(fields);
		viewLayout.setMargin(new MarginInfo(true,true,true,true));
		viewLayout.setSizeFull();
		viewLayout.setComponentAlignment(fields,Alignment.MIDDLE_CENTER);
		return viewLayout;
	}


	/**
	 * Creates the components and layout of the login page.
	 */
	private void LoginPage(VerticalLayout fields) {
		// creating user name field
		
		
		userField = new TextField("Username : ");
		userField.setWidth("300px");
		userField.setInputPrompt("username");
		userField.addValidator(new EmailValidator(
				"Username must be an email address"));
		fields.addComponent(userField);
		fields.setComponentAlignment(userField, Alignment.MIDDLE_CENTER);
		// creating password field
		passwordField = new PasswordField("Password : ");
		passwordField.setWidth("300px");
		passwordField.setValue("");
		passwordField.setNullRepresentation("");
		fields.addComponent(passwordField);
		fields.setComponentAlignment(passwordField, Alignment.MIDDLE_CENTER);
		// Create login button
		

	}
	public TextField getUserField() {
		return userField;
	}

	public PasswordField getPasswordField() {
		return passwordField;
	}

	public ComboBox getBranchCode() {
		return branchCode;
	}
	
	public void setBranchCode(ComboBox branchCode) {
		this.branchCode=branchCode;
	}

	@Override
	public void forEach(Consumer<? super Component> action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Spliterator<Component> spliterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}
