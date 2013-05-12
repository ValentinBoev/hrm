/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lex.vaadindemo.views;

import com.lex.vaadindemo.MyVaadinUI;
import com.lex.vaadindemo.data.Department;
import com.lex.vaadindemo.data.Employee;
import com.lex.vaadindemo.data.EmployeeData;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import static com.vaadin.server.Sizeable.UNITS_EM;
import com.vaadin.ui.Button;
import com.vaadin.ui.NativeSelect;
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
public class UserDataEnterView extends VerticalLayout implements Button.ClickListener {
    
    private Button saveBtn;
    private BeanFieldGroup<EmployeeData> employeeDataGroup = new BeanFieldGroup<EmployeeData>(EmployeeData.class);
    
    private NativeSelect employeeSelect;
    private BeanItemContainer<Employee> employee = new BeanItemContainer(Employee.class);
    
    private TextField address;
    private TextField city;
    private TextField countryState;
    private TextField zip;
    private TextField mobilePhone;
    private TextField homePhone;
    private TextField email;
    private NativeSelect genderSelect;


    public void init(EmployeeData employeeData) {
        prepareFields();
        prepareButtons();
        employeeDataGroup.setItemDataSource(new BeanItem<EmployeeData>(employeeData));
    }
    
    
    
    private void prepareFields() {
        
        employeeSelect = new NativeSelect("Select an employee:");
        employeeSelect.setContainerDataSource(prepareEmployeeData());
        employeeSelect.setItemCaptionPropertyId("lastName");
//        employeeSelect.setItemCaption("id", "lastName");
        employeeSelect.setWidth(10.0f, UNITS_EM);
//        employeeSelect.addValueChangeListener(new ValueChangeListener() {
//            @Override
//            public void valueChange(final ValueChangeEvent event) {
//                final String valueString = String.valueOf(event.getProperty()
//                        .getValue());
//                Notification.show("Value changed:", valueString,
//                        Type.TRAY_NOTIFICATION);
//            }
//        });
        
        address = new TextField("Address:");
        city = new TextField("City:");
        countryState = new TextField("Country State:");
        zip = new TextField("ZIP:");
        mobilePhone = new TextField("Mobile phone:");
        homePhone = new TextField("Home phone:");
        email = new TextField("Email:");
        
        genderSelect = new NativeSelect("Select an employee:");
        genderSelect.addItem("Male");
        genderSelect.addItem("Female");
        genderSelect.setWidth(10.0f, UNITS_EM);
        
        
        addComponent(employeeSelect);
        addComponent(address);
        addComponent(city);
        addComponent(countryState);
        addComponent(zip);
        addComponent(mobilePhone);
        addComponent(homePhone);
        addComponent(email);
        addComponent(genderSelect);
        
        employeeDataGroup.bind(employeeSelect, "employee");
        employeeDataGroup.bind(address, "address");
        employeeDataGroup.bind(city, "city");
        employeeDataGroup.bind(zip, "zip");
        employeeDataGroup.bind(mobilePhone, "mobilePhone");
        employeeDataGroup.bind(countryState, "countryState");
        employeeDataGroup.bind(homePhone, "homePhone");
        employeeDataGroup.bind(email, "email");
        employeeDataGroup.bind(genderSelect, "gender");
        
    }
    
    private void prepareButtons() {
        saveBtn = new Button("Save");
        saveBtn.addClickListener(this);
        addComponent(saveBtn);
        
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        try {
            employeeDataGroup.commit();
            EmployeeData employeeData = employeeDataGroup.getItemDataSource().getBean();
            
            ((MyVaadinUI)getUI()).getSessionBean().saveData(employeeData);
            
        } catch (FieldGroup.CommitException ex) {
            Logger.getLogger(UserDataEnterView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private BeanItemContainer<Employee> prepareEmployeeData() {
        
        EntityManager em = ((MyVaadinUI)getUI()).getEntityManager();
        Query query = em.createNamedQuery("Employee.findAll");
        List<Employee> list = query.getResultList();
        employee.removeAllItems();
        employee.addAll(list);
        return employee;
    }
}
