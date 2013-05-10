/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lex.vaadindemo.views;

import com.lex.vaadindemo.MyVaadinUI;
import com.lex.vaadindemo.data.Department;
import com.lex.vaadindemo.data.Employee;
import com.lex.vaadindemo.data.Job;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import static com.vaadin.server.Sizeable.UNITS_EM;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
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
    private NativeSelect jobSelect;
    private BeanItemContainer<Job> jobData = new BeanItemContainer(Job.class);
    private ListSelect superVisorSelect;


    public void init(Employee employee) {
        prepareFields();
        prepareButtons();
        employeeGroup.setItemDataSource(new BeanItem<Employee>(employee));
    }
    
    
    
    private void prepareFields() {
        departmentSelect = new ListSelect("Select a department:");
        departmentSelect.setContainerDataSource(prepareDepartmentData());
        departmentSelect.setItemCaptionPropertyId("deptName");
        departmentSelect.setRows(1); // perfect length in out case
        departmentSelect.setWidth(10.0f, UNITS_EM);
        departmentSelect.setNullSelectionAllowed(false); // user can not 'unselect'
        departmentSelect.select(1); // select this by default
        
        jobSelect = new NativeSelect("Select a job:");
        jobSelect.setContainerDataSource(prepareJobData());
        jobSelect.setItemCaptionPropertyId("id");
        
//        ComboBox status = new ComboBox("ComboBox");
//        status.setImmediate(true);
//        status.setNullSelectionAllowed(false);
//
//        for(Status st : (Collection<Status>)item.getItemProperty("availableStatus").getValue()) {
//            status.addItem(st);
//            status.setItemCaption(st, st.getLabel());
//        }
//        status.setPropertyDataSource(item.getItemProperty("currentStatus"));
        
        superVisorSelect = new ListSelect("Select supervisor:");
        for (int i = 0; i < jobs.length; i++) {
            superVisorSelect.addItem(i);
            superVisorSelect.setItemCaption(i, jobs[i]);
        }
        superVisorSelect.setWidth(10.0f, UNITS_EM);
        superVisorSelect.setNullSelectionAllowed(false); // user can not 'unselect'
        superVisorSelect.select(1); // select this by default
        superVisorSelect.setRows(1);
        
        
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
            
            ((MyVaadinUI)getUI()).getSessionBean().saveData(employee);
            
        } catch (FieldGroup.CommitException ex) {
            Logger.getLogger(UserEnterView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private BeanItemContainer<Department> prepareDepartmentData() {
        
        EntityManager em = ((MyVaadinUI)getUI()).getEntityManager();
        Query query = em.createNamedQuery("Department.findAll");
        List<Department> list = query.getResultList();
        departmentData.removeAllItems();
        departmentData.addAll(list);
        return departmentData;
    }
    
    private BeanItemContainer<Job> prepareJobData() {
        
        EntityManager em = ((MyVaadinUI)getUI()).getEntityManager();
        Query query = em.createNamedQuery("Job.findAll");
        List<Job> list = query.getResultList();
        jobData.removeAllItems();
        jobData.addAll(list);
        return jobData;
    }
}
