package com.enterprise.restaurant.example.ui;

import java.util.Collection;
import java.util.Spliterator;
import java.util.function.Consumer;


import com.enterprise.restaurant.component.PanelComponent;
import com.google.gwt.thirdparty.guava.common.eventbus.Subscribe;
import com.vaadin.demo.dashboard.domain.DashboardNotification;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

public class MainView extends Panel{
	 public static final String EDIT_ID = "dashboard-edit";
	    public static final String TITLE_ID = "dashboard-title";

	    private Label titleLabel;
	    private CssLayout dashboardPanels;
	    private final VerticalLayout root;
	    private Window notificationsWindow;

	    public MainView() {
	        addStyleName(ValoTheme.PANEL_BORDERLESS);
	        setSizeFull();
	       

	        root = new VerticalLayout();
	        root.setSizeFull();
	     
	        root.addStyleName("dashboard-view");
	        setContent(root);
	        Responsive.makeResponsive(root);


	        Component c=buildSparklines();
	        
	        root.addComponent(c);
	     
	      

	        root.addLayoutClickListener(new LayoutClickListener() {
	            @Override
	            public void layoutClick(final LayoutClickEvent event) {
	              
	            }
	        });
	    }

	    private Component buildSparklines() {
	        CssLayout sparks = new CssLayout();
	        sparks.addStyleName("sparks");
	        sparks.setWidth("100%");
	        Responsive.makeResponsive(sparks);
	/*
	 * adding logic over there
	 * 
	 */
	        PanelComponent s = new PanelComponent("Kadai Panner","$","/Unit","25");
	        sparks.addComponent(s);
	        PanelComponent s1 = new PanelComponent("Mashroom","$","/Unit","20");
	        sparks.addComponent(s1);
	        PanelComponent s2 = new PanelComponent("Prantha","$","/Unit","19");
	        sparks.addComponent(s2);
	        PanelComponent s3 = new PanelComponent("Rajma-Rice","$","/Unit","15");
	        sparks.addComponent(s3);
	        PanelComponent s4 = new PanelComponent("Mix-Veg","$","/Unit","50");
	        sparks.addComponent(s4);
	        PanelComponent s5 = new PanelComponent("Dal","$","/Unit","80");
	        sparks.addComponent(s5);
	        PanelComponent s6 = new PanelComponent("Naan","$","/Unit","65");
	        sparks.addComponent(s6);
	        PanelComponent s7 = new PanelComponent("ButterNaan","$","/Unit","5");
	        sparks.addComponent(s7);
	        PanelComponent s8 = new PanelComponent("Tandoori-Roti","$","/Unit","2");
	        sparks.addComponent(s8);
	        PanelComponent s9 = new PanelComponent("Roti","$","/Unit","1");
	        sparks.addComponent(s9);
	        PanelComponent s10 = new PanelComponent("Ice-cream","$","/Unit","2");
	        sparks.addComponent(s10);
	        
	     
	        
	        
	        return sparks;
	    }

	  
	
	    
}
