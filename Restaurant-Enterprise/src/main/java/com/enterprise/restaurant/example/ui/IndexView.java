package com.enterprise.restaurant.example.ui;


import com.vaadin.demo.dashboard.DashboardUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;

public class IndexView extends VerticalLayout {

	
	public IndexView()
	{
		setSizeFull();
		
//		VerticalLayout component=buidLayout();
		
		VerticalLayout component=buidCenterLayout();
		
		Panel componentPanel= new Panel();
		componentPanel.setStyleName(ValoTheme.PANEL_BORDERLESS);
		componentPanel.setSizeUndefined();
		//componentPanel.setHeight("100%");
//		componentPanel.setWidth("60%");

		componentPanel.setContent(component);
		
		VerticalLayout contentLayout =new VerticalLayout();
		contentLayout.setSizeFull();
		contentLayout.setSpacing(true);
		contentLayout.addComponent(component);
		contentLayout.setComponentAlignment(component, Alignment.MIDDLE_CENTER);
		
		
		addComponent(contentLayout);
	
	}
	public VerticalLayout buidCenterLayout()
	{
	
		
		
		Label icons=new Label();
		icons.setWidth("500px");
		icons.setIcon(new ThemeResource("images/restaurent.png"));
		icons.addStyleName("titleIndex");
		Label orderIcon=new Label();
		orderIcon.setIcon(new ThemeResource("images/order.jpg"));
		Label menuIcon=new Label();
		menuIcon.setIcon(new ThemeResource("images/menu.jpg"));
		Label billIcon=new Label();
		billIcon.setIcon(new ThemeResource("images/bill.jpg"));
		Label option=new Label();
		option.setWidth("250px");
		option.addStyleName("optionIndex");
		option.setValue("Choose The Options");
		
		Button order =new Button("Order");
		order.setStyleName(ValoTheme.BUTTON_ICON_ALIGN_RIGHT);
		order.setIcon(new ThemeResource("images/order.jpg"));
		order.setWidth("250px");
		
		order.addClickListener(new ClickListener() {
	            @Override
	            public void buttonClick(final ClickEvent event) {
	            	DashboardUI getMyUI= (DashboardUI) UI.getCurrent().getUI();
	            getMyUI.getLayout().removeAllComponents();
	            getMyUI.getLayout().addComponent(new HomeView());
	            }
	        });
		
		Button menu =new Button("Menu List");
		menu.setStyleName(ValoTheme.BUTTON_ICON_ALIGN_RIGHT);
		menu.setIcon(new ThemeResource("images/menu.jpg"));
		menu.setWidth("250px");
		Button bill =new Button("Bill");
		bill.setStyleName(ValoTheme.BUTTON_ICON_ALIGN_RIGHT);
		bill.setIcon(new ThemeResource("images/bill.jpg"));
		bill.setWidth("250px");
		Button logout =new Button("Logout");
		logout.setWidth("250px");
		logout.setIcon(new ThemeResource("images/logout.png"));
		logout.setStyleName(ValoTheme.BUTTON_ICON_ALIGN_RIGHT);
		logout.setStyleName(ValoTheme.BUTTON_BORDERLESS	);

		
		HorizontalLayout orderlayout =new HorizontalLayout();
		//orderlayout.setSizeFull();
		orderlayout.setSpacing(true);
		
		HorizontalLayout menulayout =new HorizontalLayout();
		///menulayout.setSizeFull();
		menulayout.setSpacing(true);
		
		HorizontalLayout billslayout =new HorizontalLayout();
		//billslayout.setSizeFull();
		billslayout.setSpacing(true);
		
		HorizontalLayout logoutlayout =new HorizontalLayout();
		//logoutlayout.setSizeFull();
		logoutlayout.setSpacing(true);
		
		//orderlayout.addComponent(orderIcon);
		orderlayout.addComponent(order);
		//menulayout.addComponent(menuIcon);
		menulayout.addComponent(menu);
		//billslayout.addComponent(billIcon);
		billslayout.addComponent(bill);
		
		logoutlayout.addComponent(logout);
		
		VerticalLayout mainlayout =new VerticalLayout();
		//mainlayout.setSizeFull();
		mainlayout.setSpacing(true);
		
		mainlayout.addComponent(icons);
		mainlayout.addComponent(option);
		mainlayout.addComponent(orderlayout);
		mainlayout.addComponent(menulayout);
		mainlayout.addComponent(billslayout);
		mainlayout.addComponent(logoutlayout);
	
		mainlayout.setComponentAlignment(icons, Alignment.MIDDLE_CENTER);
		mainlayout.setComponentAlignment(option, Alignment.MIDDLE_CENTER);
		mainlayout.setComponentAlignment(orderlayout, Alignment.MIDDLE_CENTER);
		mainlayout.setComponentAlignment(menulayout, Alignment.MIDDLE_CENTER);
		mainlayout.setComponentAlignment(billslayout, Alignment.MIDDLE_CENTER);
		mainlayout.setComponentAlignment(logoutlayout, Alignment.MIDDLE_CENTER);


		
		return mainlayout;
	}
	
	
	
}
