package com.enterprise.restaurant.example.ui;

import java.util.Spliterator;
import java.util.function.Consumer;


import com.enterprise.restaurant.component.HeaderComponent;
import com.enterprise.restaurant.sideMenu.DashboardMenu;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;


public class HomeView  extends VerticalLayout {


	
	private static final long serialVersionUID=-624799446882799458L;
		
	public HorizontalLayout mainLayout=null;
	VerticalLayout contentLayout=null;
	public HorizontalLayout sideMenu=null;
	public HorizontalLayout getMainLayout() {
		return mainLayout;
	}

	public void setMainLayout(HorizontalLayout mainLayout) {
		this.mainLayout = mainLayout;
	}
	
	
    
    public HomeView() 
    {
    	setSizeFull();
    	 
       
    	
    	sideMenu=new HorizontalLayout();
		 sideMenu.setHeight(100, Unit.PERCENTAGE);
		 sideMenu.addComponent(new DashboardMenu());
		  mainLayout=new HorizontalLayout();
		  Responsive.makeResponsive(mainLayout);
	       
	        mainLayout.setSizeFull();
		        addStyleName("mainview");

		        mainLayout.addComponent(sideMenu);
		        contentLayout = new VerticalLayout();
		      
		        contentLayout.addStyleName("view-content");
		        contentLayout.setSizeFull();
		        HeaderComponent v1=new HeaderComponent();
		        MainView v2=  new MainView();
		        contentLayout.addComponent(v1);
		        contentLayout.addComponent(v2);
		    /*    contentLayout.setExpandRatio(v1, .1f);*/
		        contentLayout.setExpandRatio(v2, 1f);

		        mainLayout.addComponent(contentLayout);
		        mainLayout.setExpandRatio(contentLayout, 1.0f);
			
		    addComponent(mainLayout);
		    addStyleName(ValoTheme.UI_WITH_MENU);

			}

	public HorizontalLayout getSideMenu() {
		return sideMenu;
	}
	public void setSideMenu(HorizontalLayout sideMenu) {
		this.sideMenu = sideMenu;
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



}
