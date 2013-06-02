/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lex.vaadindemo.views;

import com.lex.vaadindemo.MyVaadinUI;
import com.lex.vaadindemo.data.Job;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author valik
 */
public class JobDataEnterView extends VerticalLayout implements Button.ClickListener {
    
    private Button saveBtn;
    private TextField jobTitle;
    private TextField employmentStatus;
    private BeanFieldGroup<Job> jobGroup = new BeanFieldGroup<Job>(Job.class);
    



    public void init(Job job) {
        prepareFields();
        prepareButtons();
        jobGroup.setItemDataSource(new BeanItem<Job>(job));
    }
    
    
    
    private void prepareFields() {
        jobTitle = new TextField("Job Title:");
        employmentStatus = new TextField("Employment Status:");
        addComponent(jobTitle);
        addComponent(employmentStatus);
        
        jobGroup.bind(jobTitle, "jobTitle");
        jobGroup.bind(employmentStatus, "employmentStatus");
        
    }
    
    private void prepareButtons() {
        saveBtn = new Button("Save");
        saveBtn.addClickListener(this);
        addComponent(saveBtn);
        
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        try {
            jobGroup.commit();
            Job job = jobGroup.getItemDataSource().getBean();
            
            Notification.show("Button clicked" + job.getJobTitle());
            ((MyVaadinUI)getUI()).getSessionBean().saveData(job);
            
        } catch (FieldGroup.CommitException ex) {
            Logger.getLogger(JobDataEnterView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
