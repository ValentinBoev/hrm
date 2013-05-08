/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lex.vaadindemo.views;

import com.lex.vaadindemo.MyVaadinUI;
import com.lex.vaadindemo.data.Department;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

/**
 *
 * @author valik
 */
@Named("entityManager")
@Stateless
@TransactionManagement
public class EnterInfo extends VerticalLayout implements Button.ClickListener {

    
    // BMT idiom
    @Resource 
    public UserTransaction utx;
    
    private Button saveBtn;
    private TextField deptName;
    private TextArea deptDesc;
    private TextField deptLocation;
    private BeanFieldGroup<Department> departmentGroup = new BeanFieldGroup<Department>(Department.class);
    
    
    public void init() {
//        bean = new NewSessionBean();
        
        prepareFields();
        prepareButtons();
        departmentGroup.setItemDataSource(new BeanItem<Department>(new Department()));
    }
    
    
    
    private void prepareFields() {
        deptName = new TextField("Department Name:");
        deptDesc = new TextArea("Department Description:");
        deptLocation = new TextField("Department Location:");
        addComponent(deptName);
        addComponent(deptDesc);
        addComponent(deptLocation);
        
        departmentGroup.bind(deptName, "deptName");
        departmentGroup.bind(deptDesc, "deptDesc");
        departmentGroup.bind(deptLocation, "deptLocation");
        
    }
    
    private void prepareButtons() {
        saveBtn = new Button("Save");
        saveBtn.addClickListener(this);
        addComponent(saveBtn);
        
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        try {
            departmentGroup.commit();
            Department department = departmentGroup.getItemDataSource().getBean();
            
            
            Notification.show("Button clicked" + department.getDeptDesc());
//            System.out.println(UI.getCurrent().getS);
//            EntityManager em = ((MyVaadinUI)getUI()).getEntityManager();
//            em.merge(department);
//            System.out.println(entityManager);
//            entityManager.persist(department);
            
//            try {
//                utx.begin();
//                entityManager.persist(department);
//                utx.commit();
//            } catch (Exception ex) {
//                Logger.getLogger(EnterInfo.class.getName()).log(Level.SEVERE, null, ex);
//            }
            // Non-managed environment idiom
            
            
            try {
                System.out.println(((MyVaadinUI)getUI()).getEntityManager());
                ((MyVaadinUI)getUI()).getEntityManager().merge(department);
                utx.commit();
            }
            catch (Exception e) {
                
            }
            finally {
                ((MyVaadinUI)getUI()).getEntityManager().close();
            }
            
            
        } catch (FieldGroup.CommitException ex) {
            Logger.getLogger(EnterInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
