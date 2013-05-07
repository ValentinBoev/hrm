/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lex.vaadindemo.views;

import com.vaadin.cdi.VaadinView;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import javax.inject.Inject;

/**
 *
 * @author valik
 */
@VaadinView("demo")

public class MainView extends VerticalLayout implements Button.ClickListener {
    
    
    
    VerticalLayout mainMenu;
    Panel contentArea;
    Accordion accordion;
    private Button btn1;
    private Button btn2;
    
    @Inject
    EnterInfo enterInfo;
    
    public void initUI () {
        prepareElements();
        prepareLayout();
    }
    
    private void prepareLayout () {
        HorizontalLayout hl = new HorizontalLayout();
        hl.setSizeFull();
        hl.addComponent(mainMenu);
        
        hl.addComponent(contentArea);
        hl.setExpandRatio(contentArea, 1f);
        addComponent(hl);
    }
    
    private void prepareElements() {

        
        accordion = new Accordion();
        accordion.setHeight(100.0f, Unit.PERCENTAGE);
        accordion.addTab(createTab1(), "Tab " + 1);
        
        mainMenu = new VerticalLayout();
        mainMenu.setWidth(155, Unit.PIXELS);
        mainMenu.addComponent(new Button("Hello, i'm Layout"));
        mainMenu.addComponent(accordion);
        

                
        contentArea = new Panel();
        contentArea.setContent(new Button("Hello, i'm Panel"));
        contentArea.setSizeFull();
    }
    
    private VerticalLayout createTab1 () {
        VerticalLayout tabContent = new VerticalLayout();
        
        btn1 = new Button("Hello, i'm SubTab #1");
        btn1.addClickListener(this);
        tabContent.addComponent(btn1);
        
        btn2 = new Button("Hello, i'm SubTab #2");
        btn2.addClickListener(this);
        tabContent.addComponent(btn2);
        
        return tabContent;
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        if(event.getButton().equals(btn1)) {
            contentArea.setContent(new Label("This is my new content for this panel"));
        } else if(event.getButton().equals(btn2)) {
            enterInfo = new EnterInfo();
            contentArea.setContent(enterInfo);
            enterInfo.init();
        }
    }
    
    
    
}
