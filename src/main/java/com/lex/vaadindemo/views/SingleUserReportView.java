/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lex.vaadindemo.views;

import com.lex.vaadindemo.MyVaadinUI;
import com.lex.vaadindemo.data.Employee;
import com.lex.vaadindemo.data.EmployeeData;
import com.vaadin.cdi.VaadinView;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.themes.Reindeer;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author valik
 */
@VaadinView("demo")
@Named("singleUserReportView")
public class SingleUserReportView extends VerticalLayout {
    
    private BeanItemContainer<Employee> data = new BeanItemContainer(Employee.class);
    private BeanItemContainer<EmployeeData> employeeBean = new BeanItemContainer(EmployeeData.class);
    private Table userListTable;
    
    List<Employee> list;
    
    
    public void init () {
        prepareData();
        prepareList();
        prepareLayout();
    }
    
    private void prepareLayout () {
        setMargin(true);
        addComponent(userListTable);
        setExpandRatio(userListTable, 1f);

    }
    
    private void prepareList () {
        
        for (Object o :  list) {
            System.out.println(o.getClass());
        }
        
        userListTable = new Table();
        userListTable.setContainerDataSource(data);
        userListTable.setSizeFull();
        userListTable.setSelectable(true);
        userListTable.setMultiSelect(false);
        userListTable.setVisibleColumns(new Object[]{
            "id", "firstname", "lastName", "job", 
            "department", "supervisorId", "baseSalary", 
            "bonus", "city",
            "employeeData.address", "employeeData.city", "employeeData.zip", "employeeData.mobilePhone",
            "employeeData.homePhone", "employeeData.email", "employeeData.gender"
        });
        userListTable.setColumnHeaders(new String[]{
            "id", "First name", "Last name", "Job Title", 
            "Department Name", "Supervisor", "Base Salary", 
            "Bonus", "address",
            "employeeData.address", "employeeData.city", "employeeData.zip", "employeeData.mobilePhone",
            "employeeData.homePhone", "employeeData.email", "employeeData.gender"
        });
//        userListTable.addGeneratedColumn("id", new IdColumn());
//        userListTable.addGeneratedColumn("edit", new EditColumn());
    }
    
    private void prepareData() {
        
        EntityManager em = ((MyVaadinUI)getUI()).getEntityManager();
        Query query = em.createNamedQuery("Employee.fullData");
        list = query.getResultList();
        data.removeAllItems();
        data.addAll(list);
    }



    class IdColumn implements Table.ColumnGenerator, Button.ClickListener {

        @Override
        public Object generateCell(Table source, Object itemId, Object columnId) {
            Employee employee = (Employee) itemId;
            Button btn = new Button(String.valueOf(employee.getId()));
            btn.setStyleName(Reindeer.BUTTON_LINK);
            btn.setData(employee);
            btn.addClickListener(this);
            return btn;
        }

        @Override
        public void buttonClick(Button.ClickEvent event) {
            Employee employee = (Employee) event.getButton().getData();
            UserEnterView userEnterView = new UserEnterView();
            Window window = new Window("Employee: " + employee.getId());
            window.setWidth("97%");
            window.setHeight("95%");
            window.setModal(true);
            window.setContent(userEnterView);
            getUI().addWindow(window);
            userEnterView.init(employee);


            window.addCloseListener(new Window.CloseListener() {

                @Override
                public void windowClose(CloseEvent e) {
                    prepareData();
                }
            });
        }
    }
    
    class EditColumn implements Table.ColumnGenerator, Button.ClickListener {

        @Override
        public Object generateCell(Table source, Object itemId, Object columnId) {
            Employee employee = (Employee) itemId;
            Button btn = new Button("Edit");
            btn.setData(employee);
            btn.addClickListener(this);
            return btn;
        }

        @Override
        public void buttonClick(Button.ClickEvent event) {
            Employee employee = (Employee) event.getButton().getData();
            
            UserDataEnterView userDataEnterView = new UserDataEnterView();
            Window window = new Window("Employee: " + employee.getLastName() + " " + employee.getFirstname());
            window.setWidth("97%");
            window.setHeight("95%");
            window.setModal(true);
            window.setContent(userDataEnterView);
            getUI().addWindow(window);
            if (employee.getEmployeeData() == null) {
                userDataEnterView.init(new EmployeeData());
            } else {
                userDataEnterView.init(employee.getEmployeeData());
            }
            


//            window.addCloseListener(new Window.CloseListener() {
//
//                @Override
//                public void windowClose(CloseEvent e) {
//                    prepareData();
//                }
//            });
        }
    }
}
