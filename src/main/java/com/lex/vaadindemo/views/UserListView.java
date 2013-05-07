/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lex.vaadindemo.views;

import com.lex.vaadindemo.data.Employee;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author valik
 */
public class UserListView extends VerticalLayout {
    
    private BeanItemContainer<Employee> data = new BeanItemContainer(Employee.class);
    private GridLayout userList;
    private VerticalLayout userLayout;
    private Table userData;
    
    
    
    public void init () {
        prepareLayout();
    }
    
    private void prepareLayout () {
        
    }
    
    private void prepareData () {
        // Create a grid layout
        userList = new GridLayout();
        userList.addStyleName("outlined");
        userList.setSizeFull();

        generateMatrixGrid(3, 3);
    }
    
    private void generateMatrixGrid(final int rows, final int columns) {
        userList.removeAllComponents();
        userList.setRows(rows);
        userList.setColumns(columns);

        for (int row = 0; row < userList.getRows(); row++) {
            for (int col = 0; col < userList.getColumns(); col++) {
                final LayoutChildComponent child = new LayoutChildComponent(
                        userList, false);
                userList.addComponent(child);
                userList.setRowExpandRatio(row, 0.0f);
                userList.setColumnExpandRatio(col, 0.0f);
            }
        }
    }
    
    private void prepareUsers () {
        
        userLayout = new VerticalLayout();
        userLayout.setMargin(true);
        
        FormLayout formLayout = new FormLayout();
        formLayout.s
        
        userData = new Table();
        userData.setContainerDataSource(data);
        userData.setSizeFull();
        userData.setSelectable(true);
        userData.setMultiSelect(false);
        userData.setVisibleColumns(new String[]{"firstName", "lastName", "title"});
        userData.setColumnHeaders(new String[]{"First name", "Last name", "Title"});

        userLayout.addComponent(userData);
        
        
    }

    private void generateBorderLayout() {
        userList.removeAllComponents();
        userList.setRows(3);
        userList.setColumns(3);

        final Component north = new LayoutChildComponent(userList, true);
        userList.addComponent(north, 0, 0, 2, 0);

        final Component west = new LayoutChildComponent(userList, true);
        userList.addComponent(west, 0, 1);

        final Component center = new LayoutChildComponent(userList, true);
        userList.addComponent(center, 1, 1);

        final Component east = new LayoutChildComponent(userList, true);
        userList.addComponent(east, 2, 1);

        final Component south = new LayoutChildComponent(userList, true);
        userList.addComponent(south, 0, 2, 2, 2);

        userList.setRowExpandRatio(0, 1.0f);
        userList.setRowExpandRatio(1, 5.0f);
        userList.setRowExpandRatio(2, 1.0f);

        userList.setColumnExpandRatio(0, 1.0f);
        userList.setColumnExpandRatio(1, 4.0f);
        userList.setColumnExpandRatio(2, 1.0f);
    }
    
    
}
