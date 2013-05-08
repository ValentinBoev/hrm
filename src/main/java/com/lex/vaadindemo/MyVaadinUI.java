package com.lex.vaadindemo;

import com.lex.vaadindemo.data.NewSessionBean;
import com.lex.vaadindemo.views.MainView;
import com.vaadin.annotations.Theme;
import com.vaadin.cdi.Root;
import com.vaadin.cdi.VaadinUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.CloseListener;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
@VaadinUI("demo")
@Root
@Theme("runo")
public class MyVaadinUI extends UI implements ClickListener, CloseListener {


    @EJB
    NewSessionBean bean;
    
    @PersistenceContext(unitName = "demoPU")
    @Inject
    EntityManager entityManager;
//    EntityManagerFactory entityManagerFactory;

    MainView mainView;
//    @Inject
//    UserListView userListView;
    
    @Override
    protected void init(VaadinRequest request) {
        mainView = new MainView();
        setContent(mainView);
        setSizeFull();
        mainView.initUI();
        System.out.println(bean);
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

    public NewSessionBean getSessionBean() {
        return bean;
    }
    
    public EntityManager getEntityManager () {
        return entityManager;
    }
    
    
    
    
}
