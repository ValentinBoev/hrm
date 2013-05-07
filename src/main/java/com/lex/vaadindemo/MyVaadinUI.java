package com.lex.vaadindemo;

import com.lex.vaadindemo.data.Department;
import com.lex.vaadindemo.views.EnterInfo;
import com.lex.vaadindemo.views.MainView;
import com.vaadin.annotations.Theme;
import com.vaadin.cdi.Root;
import com.vaadin.cdi.VaadinUI;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.CloseListener;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
@VaadinUI("demo")
@Root
@Theme("runo")
public class MyVaadinUI extends UI implements ClickListener, CloseListener {

    
    
    @Inject
    MainView mainView;
    @PersistenceContext(unitName = "demoPU")
    EntityManager entityManager;
    private VerticalLayout layout = new VerticalLayout();
    private Button button = new Button("Refresh Data", this);
    private Button add = new Button("Add Data", this);
    private Button edit = new Button("Edit Data", this);
    private Table table = new Table();
    private BeanItemContainer<Department> data = new BeanItemContainer(Department.class);

    
    @Override
    protected void init(VaadinRequest request) {
        mainView = new MainView();
        setContent(mainView);
        setSizeFull();
        mainView.initUI();
        
        mainView.setSizeFull();
    }

    @Override
    public void buttonClick(ClickEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClose(CloseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
