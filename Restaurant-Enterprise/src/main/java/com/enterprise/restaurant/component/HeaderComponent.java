package com.enterprise.restaurant.component;

import java.util.Collection;
import java.util.Spliterator;
import java.util.function.Consumer;

import com.vaadin.demo.dashboard.domain.DashboardNotification;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;

public class HeaderComponent extends VerticalLayout {
	 Label titleLabel=null;
	    public static final String TITLE_ID = "dashboard-title";
	    private NotificationsButton notificationsButton;
	    private Window notificationsWindow;
	    private ComboBox comboTable; 
	public HeaderComponent() {
		  setSizeUndefined();
		   addStyleName("viewheader");
		   setSpacing(true);
		  setMargin(new MarginInfo(true, true, false, true));
		   HorizontalLayout header = new HorizontalLayout();
		   header.setSizeUndefined();
		header.addStyleName("viewheader");
		 //  header.setSpacing(true);
		 //  header.setMargin(true);
		   
		   HorizontalLayout header3 = new HorizontalLayout();
		   header3.setSizeUndefined();
		   header3.addStyleName(ValoTheme.LABEL_H1);

		   header3.addStyleName(ValoTheme.LABEL_NO_MARGIN);
		   
		   TextField searchfield=new TextField();
		     searchfield.setIcon(FontAwesome.SEARCH);
		     searchfield.setStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
		   searchfield.setSizeUndefined();
		    // searchfield.setWidth("80px");
		     searchfield.setInputPrompt("Veg-Recipes");
		     searchfield.addStyleName("toolbar");
		     searchfield.addStyleName(ValoTheme.LABEL_H1);

		     searchfield.addStyleName(ValoTheme.LABEL_NO_MARGIN);
		   
		   
	        titleLabel = new Label("Veg-Recipes");
	        titleLabel.setId(TITLE_ID);
	        titleLabel.setSizeUndefined();
	        titleLabel.addStyleName(ValoTheme.LABEL_H1);
	        titleLabel.addStyleName(ValoTheme.LABEL_NO_MARGIN);

	        
	        header3.addComponents(titleLabel,searchfield);
	        
	        header.addComponent(searchfield);

	        notificationsButton = buildNotificationsButton();

	        HorizontalLayout tools = new HorizontalLayout(notificationsButton);
	        tools.setSpacing(true);
	        tools.addStyleName("toolbar");
	        header.addComponent(tools);
	        
	        HorizontalLayout header2 = new HorizontalLayout();
			   header2.setSizeUndefined();
			   header2.addStyleName("viewheader");
			  // header2.setSpacing(true);
			  // header2.setMargin(true);
		       
			  
			   
			   
			   comboTable=new ComboBox();
			   comboTable.setInputPrompt("Select Table");
//			   comboTable.setSizeUndefined();
			   comboTable.setWidth("130px");
			   comboTable.addStyleName(ValoTheme.LABEL_H1);
			   comboTable.addStyleName(ValoTheme.LABEL_NO_MARGIN);
			     header2.addComponent(comboTable);

			     
			     
			 
			   
			/*     TextField searchfield=new TextField();
			     searchfield.setIcon(FontAwesome.SEARCH);
			     searchfield.setStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
			    // searchfield.setSizeUndefined();
			     searchfield.setWidth("130px");
			     searchfield.setInputPrompt("Search the item");
			     searchfield.addStyleName("toolbar");
			     
			    

			  
		        header2.addComponent(searchfield);*/
	        addComponent(header);
	       // addComponent(header2);

	       
	    }
	 private NotificationsButton buildNotificationsButton() {
	        NotificationsButton result = new NotificationsButton();
	        result.addClickListener(new ClickListener() {
	            @Override
	            public void buttonClick(final ClickEvent event) {
	                openNotificationsPopup(event);
	            }
	        });
	        return result;
	    }
	  private void openNotificationsPopup(final ClickEvent event) {
	        VerticalLayout notificationsLayout = new VerticalLayout();
	        notificationsLayout.setMargin(true);
	        notificationsLayout.setSpacing(true);

	        Label title = new Label("Notifications");
	        title.addStyleName(ValoTheme.LABEL_H3);
	        title.addStyleName(ValoTheme.LABEL_NO_MARGIN);
	        notificationsLayout.addComponent(title);

	        Collection<DashboardNotification> notifications = null;
	               


	        for (DashboardNotification notification : notifications) {
	            VerticalLayout notificationLayout = new VerticalLayout();
	            notificationLayout.addStyleName("notification-item");

	            Label titleLabel = new Label(notification.getFirstName() + " "
	                    + notification.getLastName() + " "
	                    + notification.getAction());
	            titleLabel.addStyleName("notification-title");

	            Label timeLabel = new Label(notification.getPrettyTime());
	            timeLabel.addStyleName("notification-time");

	            Label contentLabel = new Label(notification.getContent());
	            contentLabel.addStyleName("notification-content");

	            notificationLayout.addComponents(titleLabel, timeLabel,
	                    contentLabel);
	            notificationsLayout.addComponent(notificationLayout);
	        }

	        HorizontalLayout footer = new HorizontalLayout();
	        footer.addStyleName(ValoTheme.WINDOW_BOTTOM_TOOLBAR);
	        footer.setWidth("100%");
	        Button showAll = new Button("View All Notifications",
	                new ClickListener() {
	                    @Override
	                    public void buttonClick(final ClickEvent event) {
	                        Notification.show("Not implemented in this demo");
	                    }
	                });
	        showAll.addStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
	        showAll.addStyleName(ValoTheme.BUTTON_SMALL);
	        footer.addComponent(showAll);
	        footer.setComponentAlignment(showAll, Alignment.TOP_CENTER);
	        notificationsLayout.addComponent(footer);

	        if (notificationsWindow == null) {
	            notificationsWindow = new Window();
	            notificationsWindow.setWidth(300.0f, Unit.PIXELS);
	            notificationsWindow.addStyleName("notifications");
	            notificationsWindow.setClosable(false);
	            notificationsWindow.setResizable(false);
	            notificationsWindow.setDraggable(false);
	            notificationsWindow.setCloseShortcut(KeyCode.ESCAPE, null);
	            notificationsWindow.setContent(notificationsLayout);
	        }

	        if (!notificationsWindow.isAttached()) {
	            notificationsWindow.setPositionY(event.getClientY()
	                    - event.getRelativeY() + 40);
	            getUI().addWindow(notificationsWindow);
	            notificationsWindow.focus();
	        } else {
	            notificationsWindow.close();
	        }
	    }
	    public static final class NotificationsButton extends Button {
	        private static final String STYLE_UNREAD = "unread";
	        public static final String ID = "dashboard-notifications";

	        public NotificationsButton() {
	            setIcon(FontAwesome.BELL);
	            setId(ID);
	            addStyleName("notifications");
	            addStyleName(ValoTheme.BUTTON_ICON_ONLY);
	          
	        }

	       

	        public void setUnreadCount(final int count) {
	            setCaption(String.valueOf(count));

	            String description = "Notifications";
	            if (count > 0) {
	                addStyleName(STYLE_UNREAD);
	                description += " (" + count + " unread)";
	            } else {
	                removeStyleName(STYLE_UNREAD);
	            }
	            setDescription(description);
	        }
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
