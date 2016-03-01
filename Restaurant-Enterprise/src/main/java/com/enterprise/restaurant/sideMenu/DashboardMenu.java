package com.enterprise.restaurant.sideMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;






import com.enterprise.restaurant.example.ui.HomeView;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.demo.dashboard.DashboardUI;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinSession;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.AbstractSelect.AcceptItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.DragAndDropWrapper.DragStartMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;
import com.vaadin.ui.themes.ValoTheme;


/**
 * A responsive menu component providing user information and the controls for
 * primary navigation between the views.
 */
@SuppressWarnings({ "serial", "unchecked" })
public final class DashboardMenu extends CustomComponent implements View {

    public static final String ID = "dashboard-menu";
    public static final String REPORTS_BADGE_ID = "dashboard-menu-reports-badge";
    public static final String NOTIFICATIONS_BADGE_ID = "dashboard-menu-notifications-badge";
    private static final String STYLE_VISIBLE = "valo-menu-visible";
    private static final String STYLE_TREE="valo-teeDesign";
    private Label notificationsBadge;
    private Label reportsBadge;
    private MenuItem settingsItem;
    DashboardUI mainUI = null;
    public DashboardMenu() {
        addStyleName("valo-menu");
        setId(ID);
        setSizeUndefined();
      setCompositionRoot(buildContent());
    }

    private Component buildContent() {
        final CssLayout menuContent = new CssLayout();
        menuContent.addStyleName("sidebar");
		menuContent.addStyleName("menuscroll");
		menuContent.addStyleName("no-vertical-drag-hints");
		menuContent.addStyleName("no-horizontal-drag-hints");
		menuContent.setWidth(null);
		menuContent.setHeight("100%");

        menuContent.addComponent(buildTitle());
        menuContent.addComponent(buildUserMenu());

        menuContent.addComponent(buildToggleButton());

        menuContent.addComponent(buildMenuItems());

        return menuContent;
    }
    private static final String[] GROUP_ORDER = { "registration","tests", "result","rewards",
         "contact" };
private static final String[] GROUP_CAPTIONS = { "Registrations", "Tests","Results & Solutions","Rewards System",
         "Contact"};





List <String> Registrations = new ArrayList<String>(
		Arrays.asList( "Registration"));
List <String> Tests = new ArrayList<String>(
		Arrays.asList( "Computer", "Science","Mathematics","Gernal Awareness","Reasoning"));
List <String> Results = new ArrayList<String>(
		Arrays.asList( "Results","Solutions"));
List <String> Rewards = new ArrayList<String>(
		Arrays.asList(  "Rewards Procedure", "Rules","Terms & Condition"));
List <String> Contact = new ArrayList<String>(
		Arrays.asList("Contact-Us", "About-Us"));



static String splitCamelCase(String s) {
    String replaced = s.replaceAll(String.format("%s|%s|%s",
            "(?<=[A-Z])(?=[A-Z][a-z])", "(?<=[^A-Z])(?=[A-Z])",
            "(?<=[A-Za-z])(?=[^A-Za-z])"), " ");
    // Make things look nicer with some special case handling
    replaced = replaced.replaceAll("And", "and");
    replaced = replaced.replaceAll("With", "with");
    replaced = replaced.replaceAll("To", "to");
    replaced = replaced.replaceAll("Of", "of");
    replaced = replaced.replaceAll("Api", "API");
    replaced = replaced.replaceAll("3 D", "3D");
    return replaced.substring(0,1).toUpperCase() + replaced.substring(1);
}
    private HierarchicalContainer getContainer() {

        HierarchicalContainer hierarchicalContainer = new HierarchicalContainer();
        hierarchicalContainer.addContainerProperty("displayName", String.class,
                "");

        for (int i = 0; i < GROUP_CAPTIONS.length; i++) {
            String group = GROUP_ORDER[i];
            Item groupItem = hierarchicalContainer.addItem(group);
        	groupItem.getItemProperty("displayName").setValue(GROUP_CAPTIONS[i]);
        	System.out.println("value of group is "+group);
            
            if(group.equals("result"))
            {
            	
            	for (String class1 : Results) {
             /*   Item testItem = hierarchicalContainer.addItem(class1);
                testItem.getItemProperty("displayName").setValue(
                        class1);
                hierarchicalContainer.setParent(testItem, groupItem);
                hierarchicalContainer.setChildrenAllowed(testItem, false);*/
            	
            		System.out.println("value of class1 is "+class1);
            	
            		Item testItem = hierarchicalContainer.addItem(class1);
            		testItem.getItemProperty("displayName").setValue(
                          splitCamelCase(class1));
            		hierarchicalContainer.setParent(class1, group);
            		hierarchicalContainer.setChildrenAllowed(class1, false);
            	
            	}
            }

            else if(group.equals("registration"))
            {

            	for (String class1 : Registrations) {
             /*   Item testItem = hierarchicalContainer.addItem(class1);
                testItem.getItemProperty("displayName").setValue(
                        class1);
                hierarchicalContainer.setParent(testItem, groupItem);
                hierarchicalContainer.setChildrenAllowed(testItem, false);*/
            	
            		System.out.println("value of class1 is "+class1);
            	
            		Item testItem = hierarchicalContainer.addItem(class1);
            		testItem.getItemProperty("displayName").setValue(
                          splitCamelCase(class1));
            		hierarchicalContainer.setParent(class1, group);
            		hierarchicalContainer.setChildrenAllowed(class1, false);
            	
            	}
            }
            else if(group.equals("tests"))
            {

            	for (String class1 : Tests) {
             /*   Item testItem = hierarchicalContainer.addItem(class1);
                testItem.getItemProperty("displayName").setValue(
                        class1);
                hierarchicalContainer.setParent(testItem, groupItem);
                hierarchicalContainer.setChildrenAllowed(testItem, false);*/
            	
            		System.out.println("value of class1 is "+class1);
            	
            		Item testItem = hierarchicalContainer.addItem(class1);
            		testItem.getItemProperty("displayName").setValue(
                          splitCamelCase(class1));
            		hierarchicalContainer.setParent(class1, group);
            		hierarchicalContainer.setChildrenAllowed(class1, false);
            	
            	}
            }
            else if(group.equals("rewards"))
            {

            	for (String class1 : Rewards) {
             /*   Item testItem = hierarchicalContainer.addItem(class1);
                testItem.getItemProperty("displayName").setValue(
                        class1);
                hierarchicalContainer.setParent(testItem, groupItem);
                hierarchicalContainer.setChildrenAllowed(testItem, false);*/
            	
            		System.out.println("value of class1 is "+class1);
            	
            		Item testItem = hierarchicalContainer.addItem(class1);
            		testItem.getItemProperty("displayName").setValue(
                          splitCamelCase(class1));
            		hierarchicalContainer.setParent(class1, group);
            		hierarchicalContainer.setChildrenAllowed(class1, false);
            	
            	}
            }
            else
            {

            	for (String class1 : Contact) {
             /*   Item testItem = hierarchicalContainer.addItem(class1);
                testItem.getItemProperty("displayName").setValue(
                        class1);
                hierarchicalContainer.setParent(testItem, groupItem);
                hierarchicalContainer.setChildrenAllowed(testItem, false);*/
            	
            		System.out.println("value of class1 is "+class1);
            	
            		Item testItem = hierarchicalContainer.addItem(class1);
            		testItem.getItemProperty("displayName").setValue(
                          splitCamelCase(class1));
            		hierarchicalContainer.setParent(class1, group);
            		hierarchicalContainer.setChildrenAllowed(class1, false);
            	
            	}
            }
        }

        return hierarchicalContainer;
    }
   
       private Tree tree;
       /* 
   private Component buildContent() {
    
    	final CssLayout menuContent = new CssLayout();
        menuContent.addStyleName("sidebar");
        menuContent.addStyleName(ValoTheme.MENU_PART);
        menuContent.addStyleName("no-vertical-drag-hints");
        menuContent.addStyleName("no-horizontal-drag-hints");
        menuContent.setWidth(null);
        menuContent.setHeight("100%");
    	
    	
        menuContent.addComponent(buildTitle());
        menuContent.addComponent(buildUserMenu());
        menuContent.addComponent(buildToggleButton());
        menuContent.addComponent(buildMenuItems());
        
        return menuContent;
    }
    */
    
    HashSet<Object> expandedItemIds = new HashSet<Object>();
    private void expandForFiltering() {
        expandedItemIds.clear();
        for (Object itemId : tree.getVisibleItemIds()) {
            if (tree.isExpanded(itemId)) {
                expandedItemIds.add(itemId);
            }
            tree.expandItemsRecursively(itemId);
        }
    }

   
    private Component buildTitle() {
    	 Label logo = new Label("<strong>Retaurant-Enterprises</strong>",
                 ContentMode.HTML);
        logo.setSizeUndefined();
        HorizontalLayout logoWrapper = new HorizontalLayout(logo);
        logoWrapper.setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
        logoWrapper.addStyleName("valo-menu-title");
        return logoWrapper;
    }

    
    private Component buildUserMenu() {
        final MenuBar settings = new MenuBar();
        settings.addStyleName("user-menu");
        final User user = getCurrentUser();
        settingsItem = settings.addItem("", new ThemeResource(
                "images/profile-pic-300px.jpg"), null);
        settingsItem.setText("Kate" + " " + "Smith");
        settingsItem.addItem("My Account", new Command() {
            @Override
            public void menuSelected(final MenuItem selectedItem) {
              
            }
        });
        settingsItem.addSeparator();
        settingsItem.addItem("Sign Out",FontAwesome.SIGN_OUT, new Command() {
            @Override
            public void menuSelected(final MenuItem selectedItem) {
              
            }
        });
        return settings;
    }
    
    private Component buildToggleButton() {
        Button valoMenuToggleButton = new Button("Menu", new ClickListener() {
            @Override
            public void buttonClick(final ClickEvent event) {
                if ( getCompositionRoot().getStyleName().contains(STYLE_VISIBLE)) {
                    getCompositionRoot().removeStyleName(STYLE_VISIBLE);
                } else {
                    getCompositionRoot().addStyleName(STYLE_VISIBLE);
                }
            }
        });
        valoMenuToggleButton.setIcon(FontAwesome.LIST);
        valoMenuToggleButton.addStyleName("valo-menu-toggle");
        valoMenuToggleButton.addStyleName(ValoTheme.BUTTON_BORDERLESS);
        valoMenuToggleButton.addStyleName(ValoTheme.BUTTON_SMALL);
        return valoMenuToggleButton;
    }
    
    
    private User getCurrentUser() {
        return (User) VaadinSession.getCurrent().getAttribute(
                User.class.getName());
    }

 

 

    private Component buildMenuItems() {
        CssLayout menuItemsLayout = new CssLayout();
        menuItemsLayout.addStyleName("valo-menuitems");
        menuItemsLayout.setHeight(100.0f, Unit.PERCENTAGE);
        
    	VerticalLayout content = new VerticalLayout();
    	content.setSizeFull();
      

        //content.setSpacing(true);
        content.setMargin(new MarginInfo(false, false, true, false));
        
        
        Button veg=new Button("Veg");
        veg.setSizeFull();
        veg.setStyleName(ValoTheme.BUTTON_BORDERLESS);
        veg.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(final ClickEvent event) {
            	DashboardUI getMyUI= (DashboardUI) UI.getCurrent().getUI();
            getMyUI.getLayout().removeAllComponents();
            getMyUI.getLayout().addComponent(new HomeView());
            }
        });
        
        
        Button nonveg=new Button("Non-Veg");
        nonveg.setSizeFull();
        nonveg.setStyleName(ValoTheme.BUTTON_BORDERLESS);
        Button vegstarter=new Button("Veg Stater");
        vegstarter.setSizeFull();
        vegstarter.setStyleName(ValoTheme.BUTTON_BORDERLESS);
        Button nonvegStarter=new Button("Non-Veg Stater");
        nonvegStarter.setSizeFull();
        nonvegStarter.setStyleName(ValoTheme.BUTTON_BORDERLESS);
        Button soup=new Button("Soup");
        soup.setSizeFull();
        soup.setStyleName(ValoTheme.BUTTON_BORDERLESS);
        Button softdrink=new Button("Soft Drink");
        softdrink.setSizeFull();
        softdrink.setStyleName(ValoTheme.BUTTON_BORDERLESS);
        Button beer=new Button("Beer");
        beer.setSizeFull();
        beer.setStyleName(ValoTheme.BUTTON_BORDERLESS);
        Button tandoori=new Button("Tandoori");
        tandoori.setSizeFull();
        tandoori.setStyleName(ValoTheme.BUTTON_BORDERLESS);
        Button nontodoori=new Button("Non-Tandoori");
        nontodoori.setSizeFull();
        nontodoori.setStyleName(ValoTheme.BUTTON_BORDERLESS);
        Button vegcombo=new Button("Veg-Combo");
        vegcombo.setSizeFull();
        vegcombo.setStyleName(ValoTheme.BUTTON_BORDERLESS);
        Button nonvegcombo=new Button("NonVeg-Combo");
        nonvegcombo.setSizeFull();
        nonvegcombo.setStyleName(ValoTheme.BUTTON_BORDERLESS);
        Button dessert=new Button("Dessert");
        dessert.setSizeFull();
        dessert.setStyleName(ValoTheme.BUTTON_BORDERLESS);


/*
        final HierarchicalContainer container = getContainer();
        
        String name="Ravinder";
        String rank="10";
        Label user_name=new Label("<strong>UserName </strong><strong>"+name+"</strong>" ,
                ContentMode.HTML);
        user_name.setSizeUndefined();
        Label user_rank=new Label("<strong>Rank </strong><strong>"+rank+"</strong>" ,
                ContentMode.HTML);
        user_rank.setSizeUndefined();
        
        VerticalLayout layout=new VerticalLayout();
        layout.setSizeUndefined();
       // Component c=buildUserMenu();
        //layout.addComponent(c);
        layout.addComponent(user_name);
        layout.addComponent(user_rank);
        //layout.setComponentAlignment(c, Alignment.TOP_CENTER);
        layout.setComponentAlignment(user_name, Alignment.MIDDLE_LEFT);

        layout.setComponentAlignment(user_rank, Alignment.BOTTOM_LEFT);


       // layout.setSpacing(true);

        Panel detail=new Panel("Candidate-Info");
        detail.setSizeFull();
        detail.setContent(layout);
        detail.setIcon(FontAwesome.USER);
        
        TextField filterField = new TextField();
        filterField.setInputPrompt("Filter examples");
        filterField.setIcon(FontAwesome.SEARCH);
        filterField.addStyleName("filter");
        filterField.setWidth("100%");
        filterField.addTextChangeListener(new TextChangeListener() {

            @Override
            public void textChange(TextChangeEvent event) {
                container.removeAllContainerFilters();
                String text = event.getText();
                if (text != null && !text.isEmpty()) {
                    expandForFiltering();
                    container.addContainerFilter("displayName", text, true,
                            false);
                } else {
                    restoreExpandedStates();
                }
            }
        });
       
       tree = new Tree();
        tree.setImmediate(true);
      tree.setContainerDataSource(container);
        tree.setContainerDataSource(con);
        tree.setItemCaptionPropertyId("displayName");
        tree.setNullSelectionAllowed(false);
       tree.setWidth("100%");
       tree.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChange(ValueChangeEvent event) {
                String value2 = event.getProperty().getValue().toString();
                System.out.println("value is "+value2);
               
                 
                	navigateTo(value2);
               
            }
        });
        
       

        
       loginButton.addClickListener(kmraEventAttacher.attachBtnClickActionMethod("handleLoginBtn"));
      
        tree.addItemClickListener(new ItemClickListener(){
            
            public void itemClick(final ItemClickEvent event) {
            
            	 Collection<?> itemIds = tree.getItemIds();
                 for (Object object : itemIds) {
                      @SuppressWarnings("unchecked")
                        String t = (String) object;
                      System.out.println("value of t "+ t);
                         if (t.equals(event.getItemId().toString())) 
                         {
                        	 System.out.println("Matched");
                             Object parent2 = tree.getParent(t);
                            
                             
                             if(tree.isExpanded(parent2))
                             {
                            	 System.out.println("alreadyExpanded");
                            	tree.collapseItemsRecursively(parent2);
                             }
                             else
                             {
                            	 System.out.println("NotalreadyExpanded");
                            	 tree.expandItemsRecursively(parent2);
                            	 tree.expandItem(parent2); 
                             }
                            
                             tree.setValue(t);
                             return;
                         }
                     
                 }
                 tree.focus();
                }
    });
       
     
      */
       
        
        
      
        
        
        content.addComponents(veg,nonveg,vegcombo,nonvegcombo,vegstarter,nonvegStarter,soup,softdrink,beer,dessert);
        
   
       /* menuItemsLayout.addComponent(buildBadgeWrapper(content,c_label));*/
        menuItemsLayout.addComponent(content);
        return menuItemsLayout;

    }

    public void navigateTo(String navigateTo) {
	System.out.println("enter into");
	mainUI = (DashboardUI) UI.getCurrent().getUI();
	UI.getCurrent().getNavigator().navigateTo(navigateTo);
	mainUI.getCurrent().getPage().setUriFragment("",false);
		
	}
	
    private void restoreExpandedStates() {
        for (Object itemId : tree.getVisibleItemIds()) {
            if (!expandedItemIds.contains(itemId) && tree.isExpanded(itemId)) {
                tree.collapseItem(itemId);
            }
        }
    }
    
    
    
    

    /*private Component buildMenuItems() {
        CssLayout menuItemsLayout = new CssLayout();
        menuItemsLayout.addStyleName("valo-menuitems");
        menuItemsLayout.setHeight(100.0f, Unit.PERCENTAGE);

        for (final DashboardViewType view : DashboardViewType.values()) {
            Component menuItemComponent = new Tree();

            if (view == DashboardViewType.REPORTS) {
                
                menuItemComponent = reports;
            }

            if (view == DashboardViewType.DASHBOARD) {
                notificationsBadge = new Label();
                notificationsBadge.setId(NOTIFICATIONS_BADGE_ID);
                menuItemComponent = buildBadgeWrapper(menuItemComponent,
                        notificationsBadge);
            }
            if (view == DashboardViewType.REPORTS) {
                reportsBadge = new Label();
                reportsBadge.setId(REPORTS_BADGE_ID);
                menuItemComponent = buildBadgeWrapper(menuItemComponent,
                        reportsBadge);
            }

            menuItemsLayout.addComponent(menuItemComponent);
        }
        return menuItemsLayout;

    }
    */
    
    private Component buildBadgeWrapper(final Component menuItemButton,
            final Component badgeLabel) {
        CssLayout dashboardWrapper = new CssLayout(menuItemButton);
        dashboardWrapper.addStyleName("badgewrapper");
        dashboardWrapper.addStyleName(ValoTheme.MENU_ITEM);
        dashboardWrapper.setWidth(100.0f, Unit.PERCENTAGE);
        badgeLabel.addStyleName(ValoTheme.MENU_BADGE);
        badgeLabel.setWidthUndefined();
        badgeLabel.setVisible(false);
        dashboardWrapper.addComponent(badgeLabel);
        return dashboardWrapper;
    }

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

  
   

      
  
}
