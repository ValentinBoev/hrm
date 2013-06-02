/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lex.vaadindemo.views;

import com.lex.vaadindemo.MyVaadinUI;
import com.lex.vaadindemo.data.Course;
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
@Named("courseListView")
public class CourseListView extends VerticalLayout {
    
    private BeanItemContainer<Course> data = new BeanItemContainer(Course.class);
    private Table courseListTable;
    
    
    
    public void init () {
        prepareData();
        prepareList();
        prepareLayout();
    }
    
    private void prepareLayout () {
        setMargin(true);
        addComponent(courseListTable);
        setExpandRatio(courseListTable, 1f);

    }
    
    private void prepareList () {
        courseListTable = new Table();
        courseListTable.setContainerDataSource(data);
        courseListTable.setSizeFull();
        courseListTable.setSelectable(true);
        courseListTable.setMultiSelect(false);
        courseListTable.setVisibleColumns(new String[]{"courseDesc"});
        courseListTable.setColumnHeaders(new String[]{"Course Title"});
        courseListTable.addGeneratedColumn("id", new IdColumn());
    }
    
    private void prepareData() {
        
        EntityManager em = ((MyVaadinUI)getUI()).getEntityManager();
        Query query = em.createNamedQuery("Course.findAll");
        List<Course> list = query.getResultList();
        data.removeAllItems();
        data.addAll(list);
    }



    class IdColumn implements Table.ColumnGenerator, Button.ClickListener {

        @Override
        public Object generateCell(Table source, Object itemId, Object columnId) {
            Course course = (Course) itemId;
            Button btn = new Button(String.valueOf(course.getId()));
            btn.setStyleName(Reindeer.BUTTON_LINK);
            btn.setData(course);
            btn.addClickListener(this);
            return btn;
        }

        @Override
        public void buttonClick(Button.ClickEvent event) {
            Course course = (Course) event.getButton().getData();
            CourseDataEnterView coursesDataEnterView = new CourseDataEnterView();
            Window window = new Window("Course: " + course.getId());
            window.setWidth("97%");
            window.setHeight("95%");
            window.setModal(true);
            window.setContent(coursesDataEnterView);
            getUI().addWindow(window);
            coursesDataEnterView.init(course);


            window.addCloseListener(new Window.CloseListener() {

                @Override
                public void windowClose(CloseEvent e) {
                    prepareData();
                }
            });
        }
    }
}
