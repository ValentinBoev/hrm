/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lex.vaadindemo.views;

import com.lex.vaadindemo.MyVaadinUI;
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
@Named("userDataListView")
public class UserDataListView extends VerticalLayout {
    
    private BeanItemContainer<EmployeeData> data = new BeanItemContainer(EmployeeData.class);
    private Table userDataListTable;
    
    
    public void init () {
        prepareData();
        prepareList();
        prepareLayout();
    }
    
    private void prepareLayout () {
        setMargin(true);
        addComponent(userDataListTable);
        setExpandRatio(userDataListTable, 1f);

    }
    
    private void prepareList () {
        userDataListTable = new Table();
        userDataListTable.setContainerDataSource(data);
        userDataListTable.setSizeFull();
        userDataListTable.setSelectable(true);
        userDataListTable.setMultiSelect(false);
        userDataListTable.setVisibleColumns(new String[]{
            "id", "address", "city",
            "zip", "countryState", "mobilePhone", "homePhone",
            "email", "gender", "birthDate", "martialState", "degree",
            "attained"
        });
        userDataListTable.setColumnHeaders(new String[]{
            "id", "address", "city",
            "zip", "countryState", "mobilePhone", "homePhone",
            "email", "gender", "birthDate", "martialState", "degree",
            "attained"
        });
//        userDataListTable.addGeneratedColumn("id", new IdColumn());
//        userDataListTable.addGeneratedColumn("edit", new IdColumn());
    }
    
    private void prepareData() {
        
        EntityManager em = ((MyVaadinUI)getUI()).getEntityManager();
        Query query = em.createNamedQuery("EmployeeData.findAll");
        List<EmployeeData> list = query.getResultList();
        data.removeAllItems();
        data.addAll(list);
    }



    class IdColumn implements Table.ColumnGenerator, Button.ClickListener {

        @Override
        public Object generateCell(Table source, Object itemId, Object columnId) {
            EmployeeData employeeData = (EmployeeData) itemId;
            Button btn = new Button(String.valueOf(employeeData.getId()));
            btn.setStyleName(Reindeer.BUTTON_LINK);
            btn.setData(employeeData);
            btn.addClickListener(this);
            return btn;
        }

        @Override
        public void buttonClick(Button.ClickEvent event) {
            EmployeeData employeeData = (EmployeeData) event.getButton().getData();
            UserDataEnterView userDataEnterView = new UserDataEnterView();
            Window window = new Window("EmployeeData: " + employeeData.getId());
            window.setWidth("97%");
            window.setHeight("95%");
            window.setModal(true);
            window.setContent(userDataEnterView);
            getUI().addWindow(window);
            userDataEnterView.init(employeeData);


            window.addCloseListener(new Window.CloseListener() {

                @Override
                public void windowClose(CloseEvent e) {
                    prepareData();
                }
            });
        }
    }
}
