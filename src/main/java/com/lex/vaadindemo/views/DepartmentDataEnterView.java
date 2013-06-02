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

/**
 *
 * @author valik
 */
public class DepartmentDataEnterView extends VerticalLayout implements Button.ClickListener {
    
    private Button saveBtn;
    private TextField deptName;
    private TextArea deptDesc;
    private TextField deptLocation;
    private BeanFieldGroup<Department> departmentGroup = new BeanFieldGroup<Department>(Department.class);
    



    public void init(Department department) {
        prepareFields();
        prepareButtons();
        departmentGroup.setItemDataSource(new BeanItem<Department>(department));
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
            ((MyVaadinUI)getUI()).getSessionBean().saveData(department);
            
        } catch (FieldGroup.CommitException ex) {
            Logger.getLogger(DepartmentDataEnterView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
