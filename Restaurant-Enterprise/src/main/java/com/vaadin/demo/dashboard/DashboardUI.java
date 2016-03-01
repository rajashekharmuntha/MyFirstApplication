package com.vaadin.demo.dashboard;

import java.util.Locale;

import com.enterprise.restaurant.example.ui.LoginViewdashBoard;
import com.google.common.eventbus.Subscribe;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;

import com.vaadin.demo.dashboard.domain.User;
import com.vaadin.demo.dashboard.event.DashboardEvent.BrowserResizeEvent;
import com.vaadin.demo.dashboard.event.DashboardEvent.CloseOpenWindowsEvent;
import com.vaadin.demo.dashboard.event.DashboardEvent.UserLoggedOutEvent;
import com.vaadin.demo.dashboard.event.DashboardEvent.UserLoginRequestedEvent;
import com.vaadin.demo.dashboard.event.DashboardEventBus;

import com.vaadin.server.Page;
import com.vaadin.server.Page.BrowserWindowResizeEvent;
import com.vaadin.server.Page.BrowserWindowResizeListener;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

@Theme("dashboard")
@Widgetset("com.vaadin.demo.dashboard.DashboardWidgetSet")
@Title("Restaurant-Enterprise")
@SuppressWarnings("serial")
public final class DashboardUI extends UI {

  
    
    @Override
    protected void init(final VaadinRequest request) {
        setLocale(Locale.US);
        layout = new VerticalLayout();
        layout.setSizeFull();
        setContent(layout);
        addStyleName(ValoTheme.UI_WITH_MENU);
        
        /*Page.getCurrent().addBrowserWindowResizeListener(
                new BrowserWindowResizeListener() {
                    @Override
                    public void browserWindowResized(
                            final BrowserWindowResizeEvent event) {
                        DashboardEventBus.post(new BrowserResizeEvent());
                    }
                });*/
        
        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
               // layout.addComponent(new Label("Thank you for clicking"));
/*            navigator.navigateTo("login");
*/            }
        });
//        layout.addComponent(new LoginView());
        layout.addComponent(new LoginViewdashBoard());


    }
    
	  public VerticalLayout getLayout() {
		return layout;
	}

	public void setLayout(VerticalLayout layout) {
		this.layout = layout;
	}
	
	public DashboardUI(){
Responsive.makeResponsive(this);
		
	}

	VerticalLayout layout = null;
	  
    
    
 

   
}
