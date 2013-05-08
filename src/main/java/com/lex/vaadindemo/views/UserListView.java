/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lex.vaadindemo.views;

import com.lex.vaadindemo.MyVaadinUI;
import com.lex.vaadindemo.data.Employee;
import com.vaadin.cdi.VaadinView;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author valik
 */
@VaadinView("demo")
@Named("userListView")
public class UserListView extends VerticalLayout {
    
    private BeanItemContainer<Employee> data = new BeanItemContainer(Employee.class);
    private VerticalLayout userLayout;
    private Table userList;
    
    
//    @PersistenceContext(unitName = "demoPU")
//    EntityManager entityMan;
    
    public void init () {
        prepareData();
        prepareList();
        prepareLayout();
    }
    
    private void prepareLayout () {
        userLayout = new VerticalLayout();
        userLayout.setMargin(true);
        userLayout.addComponent(userList);
        userLayout.setExpandRatio(userList, 1f);
    }
    
    private void prepareList () {
        userList = new Table();
        userList.setContainerDataSource(data);
        userList.setSizeFull();
        userList.setSelectable(true);
        userList.setMultiSelect(false);
        userList.setVisibleColumns(new String[]{"e.id", "ed.firstname ed.lastName", "j.jobTitle"});
        userList.setColumnHeaders(new String[]{"ID", "Name", "Job Title"});
    }
    
    private void prepareData() {
        
        EntityManager em = ((MyVaadinUI)getUI()).getSessionBean().getEntityManager();
        TypedQuery<Employee> query = em.createNamedQuery("Employee.fullData", Employee.class);
        List<Employee> list = query.getResultList();
        data.removeAllItems();
        data.addAll(list);
    }
    
}
