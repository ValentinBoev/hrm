/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lex.vaadindemo.views;

import com.lex.vaadindemo.MyVaadinUI;
import com.lex.vaadindemo.data.Department;
import com.lex.vaadindemo.data.Employee;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import static com.vaadin.server.Sizeable.UNITS_EM;
import com.vaadin.ui.Button;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author valik
 */
public class UserEnterView extends VerticalLayout implements Button.ClickListener {
    
    private Button saveBtn;
    private TextField baseSalary;
    private TextField bonus;
    private BeanFieldGroup<Employee> employeeGroup = new BeanFieldGroup<Employee>(Employee.class);
    private ListSelect departmentSelect;
    
    private BeanItemContainer<Department> departmentData = new BeanItemContainer(Department.class);
    
    final String[] departments = new String[] {
            "Mercury", "Venus", "Earth", "Mars",
            "Jupiter", "Saturn", "Uranus", "Neptune"};
    final String[] jobs = new String[] {
            "Director", "CEO", "Vice", "Engineer",
            "Operator", "Developer", "Manager", "Advisor"};
    private ListSelect jobSelect;
    private ListSelect superVisorSelect;


    public void init(Employee employee) {
        prepareFields();
        prepareButtons();
        employeeGroup.setItemDataSource(new BeanItem<Employee>(employee));
    }
    
    
    
    private void prepareFields() {
        prepareDepartmentData();
        departmentSelect = new ListSelect("Select a department:");
//        departmentSelect.setContainerDataSource(departmentData);
        for (int i = 0; i < departments.length; i++) {
            departmentSelect.addItem(i);
            departmentSelect.setItemCaption(i, departments[i]);
        }
        departmentSelect.setRows(1); // perfect length in out case
        departmentSelect.setWidth(10.0f, UNITS_EM);
        departmentSelect.setNullSelectionAllowed(false); // user can not 'unselect'
        departmentSelect.select(1); // select this by default
        
        jobSelect = new ListSelect("Select a job:");
        for (int i = 0; i < jobs.length; i++) {
            jobSelect.addItem(i);
            jobSelect.setItemCaption(i, jobs[i]);
        }
        jobSelect.setWidth(10.0f, UNITS_EM);
        jobSelect.setNullSelectionAllowed(false); // user can not 'unselect'
        jobSelect.select(1); // select this by default
        
        superVisorSelect = new ListSelect("Select supervisor:");
        for (int i = 0; i < jobs.length; i++) {
            superVisorSelect.addItem(i);
            superVisorSelect.setItemCaption(i, jobs[i]);
        }
        superVisorSelect.setWidth(10.0f, UNITS_EM);
        superVisorSelect.setNullSelectionAllowed(false); // user can not 'unselect'
        superVisorSelect.select(1); // select this by default
        
        
        baseSalary = new TextField("Base Salary:");
        bonus = new TextField("Bonus:");
        
        addComponent(baseSalary);
        addComponent(bonus);
        addComponent(departmentSelect);
        addComponent(jobSelect);
        addComponent(superVisorSelect);
        
        employeeGroup.bind(baseSalary, "baseSalary");
        employeeGroup.bind(bonus, "bonus");
        employeeGroup.bind(departmentSelect, "department");
        employeeGroup.bind(jobSelect, "job");
        employeeGroup.bind(superVisorSelect, "supervisorId");
        
    }
    
    private void prepareButtons() {
        saveBtn = new Button("Save");
        saveBtn.addClickListener(this);
        addComponent(saveBtn);
        
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        try {
            employeeGroup.commit();
            Employee employee = employeeGroup.getItemDataSource().getBean();
            
            Notification.show("Button clicked" + employee.getJob());
            ((MyVaadinUI)getUI()).getSessionBean().saveData(employee);
            
        } catch (FieldGroup.CommitException ex) {
            Logger.getLogger(UserEnterView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void prepareDepartmentData() {
        
        EntityManager em = ((MyVaadinUI)getUI()).getEntityManager();
        Query query = em.createNamedQuery("Department.findAllDeptName");
        List<Department> list = query.getResultList();
        departmentData.removeAllItems();
        departmentData.addAll(list);
    }
}
