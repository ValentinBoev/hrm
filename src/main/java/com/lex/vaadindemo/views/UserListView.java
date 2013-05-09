/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lex.vaadindemo.views;

import com.lex.vaadindemo.MyVaadinUI;
import com.lex.vaadindemo.data.Department;
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
import javax.persistence.TypedQuery;

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
        userListTable.setVisibleColumns(new String[]{"id", "deptDesc","deptLocation", "deptName"});
        userListTable.setColumnHeaders(new String[]{"id", "dept_desc","dept_location", "dept_name"});
//        userListTable.addGeneratedColumn("id", new IdColumn());
    }
    
    private void prepareData() {
        
        EntityManager em = ((MyVaadinUI)getUI()).getEntityManager();
        TypedQuery<Employee> query = em.createNamedQuery("Employee.fullData", Employee.class);
        List<Employee> list = query.getResultList();
        data.removeAllItems();
        data.addAll(list);
    }



    class IdColumn implements Table.ColumnGenerator, Button.ClickListener {

        @Override
        public Object generateCell(Table source, Object itemId, Object columnId) {
            Department department = (Department) itemId;
            Button btn = new Button(String.valueOf(department.getId()));
            btn.setStyleName(Reindeer.BUTTON_LINK);
            btn.setData(department);
            btn.addClickListener(this);
            return btn;
        }

        @Override
        public void buttonClick(Button.ClickEvent event) {
            Department department = (Department) event.getButton().getData();
            EnterInfo enterInfo = new EnterInfo();
            Window window = new Window("Department: " + department.getId());
            window.setWidth("97%");
            window.setHeight("95%");
            window.setModal(true);
            window.setContent(enterInfo);
            getUI().addWindow(window);
            enterInfo.init(department);


            window.addCloseListener(new Window.CloseListener() {

                @Override
                public void windowClose(CloseEvent e) {
                    prepareData();
                }
            });
        }
    }
}
