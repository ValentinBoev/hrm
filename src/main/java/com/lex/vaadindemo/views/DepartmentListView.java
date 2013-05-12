/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lex.vaadindemo.views;

import com.lex.vaadindemo.MyVaadinUI;
import com.lex.vaadindemo.data.Department;
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
@Named("departmentListView")
public class DepartmentListView extends VerticalLayout {
    
    private BeanItemContainer<Department> data = new BeanItemContainer(Department.class);
    
    private Table departmentListTable;
    
    
    
    public void init () {
        prepareData();
        prepareList();
        prepareLayout();
    }
    
    private void prepareLayout () {
        setMargin(true);
        addComponent(departmentListTable);
        setExpandRatio(departmentListTable, 1f);

    }
    
    private void prepareList () {
        departmentListTable = new Table();
        departmentListTable.setContainerDataSource(data);
        departmentListTable.setSizeFull();
        departmentListTable.setSelectable(true);
        departmentListTable.setMultiSelect(false);
        departmentListTable.setVisibleColumns(new String[]{"id", "deptName","deptLocation", "deptDesc"});
        departmentListTable.setColumnHeaders(new String[]{"id", "Department Name","Department Location", "Department Description"});
//        departmentListTable.addGeneratedColumn("id", new IdColumn());
    }
    
    private void prepareData() {
        
        EntityManager em = ((MyVaadinUI)getUI()).getEntityManager();
        Query query = em.createNamedQuery("Department.findAll");
        List<Department> list = query.getResultList();
        data.removeAllItems();
        data.addAll(list);
        System.out.println(data);
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
            DepartmentDataEnterVIew departmentDataEnterVIew = new DepartmentDataEnterVIew();
            Window window = new Window("Department: " + department.getId());
            window.setWidth("97%");
            window.setHeight("95%");
            window.setModal(true);
            window.setContent(departmentDataEnterVIew);
            getUI().addWindow(window);
            departmentDataEnterVIew.init(department);


            window.addCloseListener(new Window.CloseListener() {

                @Override
                public void windowClose(CloseEvent e) {
                    prepareData();
                }
            });
        }
    }
}
