/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lex.vaadindemo.views;

import com.lex.vaadindemo.MyVaadinUI;
import com.lex.vaadindemo.data.Job;
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
@Named("jobListView")
public class JobListView extends VerticalLayout {
    
    private BeanItemContainer<Job> data = new BeanItemContainer(Job.class);
    private Table jobListTable;
    
    
    
    public void init () {
        prepareData();
        prepareList();
        prepareLayout();
    }
    
    private void prepareLayout () {
        setMargin(true);
        addComponent(jobListTable);
        setExpandRatio(jobListTable, 1f);

    }
    
    private void prepareList () {
        jobListTable = new Table();
        jobListTable.setContainerDataSource(data);
        jobListTable.setSizeFull();
        jobListTable.setSelectable(true);
        jobListTable.setMultiSelect(false);
        jobListTable.setVisibleColumns(new String[]{"jobTitle","employmentStatus"});
        jobListTable.setColumnHeaders(new String[]{"Job Title","Employment Status"});
        jobListTable.addGeneratedColumn("id", new IdColumn());
    }
    
    private void prepareData() {
        
        EntityManager em = ((MyVaadinUI)getUI()).getEntityManager();
        Query query = em.createNamedQuery("Job.findAll");
        List<Job> list = query.getResultList();
        data.removeAllItems();
        data.addAll(list);
        System.out.println(data);
    }



    class IdColumn implements Table.ColumnGenerator, Button.ClickListener {

        @Override
        public Object generateCell(Table source, Object itemId, Object columnId) {
            Job job = (Job) itemId;
            Button btn = new Button(String.valueOf(job.getId()));
            btn.setStyleName(Reindeer.BUTTON_LINK);
            btn.setData(job);
            btn.addClickListener(this);
            return btn;
        }

        @Override
        public void buttonClick(Button.ClickEvent event) {
            Job job = (Job) event.getButton().getData();
            JobDataEnterVIew jobsDataEnterVIew = new JobDataEnterVIew();
            Window window = new Window("Job: " + job.getId());
            window.setWidth("97%");
            window.setHeight("95%");
            window.setModal(true);
            window.setContent(jobsDataEnterVIew);
            getUI().addWindow(window);
            jobsDataEnterVIew.init(job);


            window.addCloseListener(new Window.CloseListener() {

                @Override
                public void windowClose(CloseEvent e) {
                    prepareData();
                }
            });
        }
    }
}
