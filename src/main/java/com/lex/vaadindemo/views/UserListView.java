/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lex.vaadindemo.views;

import com.lex.vaadindemo.MyVaadinUI;
import com.lex.vaadindemo.data.Employee;
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
@Named("userListView")
public class UserListView extends VerticalLayout {
    
    private BeanItemContainer<Employee> data = new BeanItemContainer(Employee.class);
    private Table userListTable;
    
    
//    @PersistenceContext(unitName = "demoPU")
//    EntityManager entityMan;
    
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
        userListTable = new Table();
        userListTable.setContainerDataSource(data);
        userListTable.setSizeFull();
        userListTable.setSelectable(true);
        userListTable.setMultiSelect(false);
        userListTable.setVisibleColumns(new String[]{"job","department", "supervisorId", "baseSalary", "bonus"});
        userListTable.setColumnHeaders(new String[]{"Job Title","Department Name", "Supervisor", "Base Salary", "Bonus"});
        userListTable.addGeneratedColumn("id", new IdColumn());
    }
    
    private void prepareData() {
        
        EntityManager em = ((MyVaadinUI)getUI()).getEntityManager();
        Query query = em.createNamedQuery("Employee.findAll");
        List<Employee> list = query.getResultList();
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
}
