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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author valik
 */
@VaadinView("demo")

public class MainView extends VerticalLayout implements Button.ClickListener {
    
    VerticalLayout mainMenu;
    Panel contentArea;
    Accordion accordion;
    private Button userBtn1;
    private Button userBtn2;
    private Button vacancyBtn1;
    private Button vacancyBtn2;
    private Button reportBtn1;
    private Button reportBtn2;
    private Button basicBtn1;
    private Button basicBtn2;
    
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
        accordion.addTab(userTab(), "Users");
        accordion.addTab(vacancyTab(), "Vacancy");
        accordion.addTab(reportTab(), "Reports");
        accordion.addTab(basicTab(), "Basic");
        
        mainMenu = new VerticalLayout();
        mainMenu.setWidth(250, Unit.PIXELS);
        mainMenu.addComponent(accordion);
                
        contentArea = new Panel();
        contentArea.setContent(new Button("Hello, i'm Panel"));
        contentArea.setSizeFull();
    }
    
    private VerticalLayout userTab () {
        VerticalLayout tabContent = new VerticalLayout();
        
        userBtn1 = new Button("Hello, i'm Users userBtn #1");
        userBtn1.addClickListener(this);
        tabContent.addComponent(userBtn1);
        
        userBtn2 = new Button("Hello, i'm Users userBtn #2");
        userBtn2.addClickListener(this);
        tabContent.addComponent(userBtn2);
        
        return tabContent;
    }
    
    private VerticalLayout vacancyTab () {
        VerticalLayout tabContent = new VerticalLayout();
        
        vacancyBtn1 = new Button("Hello, i'm Vacancy vacancyBtn #1");
        vacancyBtn1.addClickListener(this);
        tabContent.addComponent(vacancyBtn1);
        
        vacancyBtn2 = new Button("Hello, i'm Vacancy vacancyBtn #2");
        vacancyBtn2.addClickListener(this);
        tabContent.addComponent(vacancyBtn2);
        
        return tabContent;
    }
    
    private VerticalLayout reportTab () {
        VerticalLayout tabContent = new VerticalLayout();
        
        reportBtn1 = new Button("Hello, i'm Report reportBtn #1");
        reportBtn1.addClickListener(this);
        tabContent.addComponent(reportBtn1);
        
        reportBtn2 = new Button("Hello, i'm Report reportBtn #2");
        reportBtn2.addClickListener(this);
        tabContent.addComponent(reportBtn2);
        
        return tabContent;
    }
    
    private VerticalLayout basicTab () {
        VerticalLayout tabContent = new VerticalLayout();
        
        basicBtn1 = new Button("Hello, i'm Basic basicBtn #1");
        basicBtn1.addClickListener(this);
        tabContent.addComponent(basicBtn1);
        
        basicBtn2 = new Button("Hello, i'm Basic basicBtn #2");
        basicBtn2.addClickListener(this);
        tabContent.addComponent(basicBtn2);
        
        return tabContent;
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        if(event.getButton().equals(userBtn1)) {
            contentArea.setContent(new Label("This is my new User content"));
        } else if(event.getButton().equals(userBtn2)) {
            enterInfo = new EnterInfo();
            contentArea.setContent(enterInfo);
            enterInfo.init();
        } else if(event.getButton().equals(vacancyBtn1)) {
            contentArea.setContent(new Label("This is my new Vacancy content"));
        } else if(event.getButton().equals(vacancyBtn2)) {
            enterInfo = new EnterInfo();
            contentArea.setContent(enterInfo);
            enterInfo.init();
        } else if(event.getButton().equals(reportBtn1)) {
            contentArea.setContent(new Label("This is my new Report content"));
        } else if(event.getButton().equals(reportBtn2)) {
            enterInfo = new EnterInfo();
            contentArea.setContent(enterInfo);
            enterInfo.init();
        } else if(event.getButton().equals(basicBtn1)) {
            contentArea.setContent(new Label("This is my new Basic content"));
        } else if(event.getButton().equals(basicBtn2)) {
            enterInfo = new EnterInfo();
            contentArea.setContent(enterInfo);
            enterInfo.init();
        } 
    }
    
    
    
}
