package com.enterprise.restaurant.component;


import java.util.Arrays;
import java.util.List;




import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
public class PanelComponent extends VerticalLayout {


	private String itemName;
    public  PanelComponent(final String itemType, final String currencySymbol,
            final String perItem, final String price) {
        setSizeUndefined();
        addStyleName("spark");
        addStyleName(ValoTheme.LAYOUT_CARD);
        setDefaultComponentAlignment(Alignment.TOP_CENTER);

        

        Label current = new Label(currencySymbol + price + perItem);
        current.setSizeUndefined();
        current.addStyleName(ValoTheme.LABEL_HUGE);
        addComponent(current);

        Label title = new Label(itemType);
        title.setSizeUndefined();
        title.addStyleName(ValoTheme.LABEL_SMALL);
        title.addStyleName(ValoTheme.LABEL_H2);
        addComponent(title);


 
        Button addButton =new Button();
        addButton.setSizeUndefined();
        addButton.addStyleName("buttonView");
       addButton.setStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);

        addButton.setIcon(FontAwesome.PLUS);
   
        
       
        Button minusButton =new Button();
        minusButton.setSizeUndefined();

        minusButton.setStyleName("buttonView");
        minusButton.setStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);

//        minusButton.setStyleName(ValoTheme.BUTTON_TINY);
        minusButton.setIcon(FontAwesome.MINUS);

     
        
        Label count=new Label();
        count.setSizeUndefined();
        count.setValue("0");
        
        
        HorizontalLayout footer =new HorizontalLayout();
        footer.setSizeUndefined();
        footer.setSpacing(true);
        footer.addComponents(addButton,count, minusButton);
        
       
        addComponent(footer);
        setComponentAlignment(footer, Alignment.BOTTOM_CENTER);

    }

   
}
