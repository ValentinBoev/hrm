/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lex.vaadindemo.views;

import com.lex.vaadindemo.MyVaadinUI;
import com.lex.vaadindemo.data.Course;
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
public class CourseDataEnterView extends VerticalLayout implements Button.ClickListener {
    
    private Button saveBtn;
    private TextField courseDesc;
    private BeanFieldGroup<Course> courseGroup = new BeanFieldGroup<Course>(Course.class);
    



    public void init(Course course) {
        prepareFields();
        prepareButtons();
        courseGroup.setItemDataSource(new BeanItem<Course>(course));
    }
    
    
    
    private void prepareFields() {
        courseDesc = new TextField("Course Title:");
        addComponent(courseDesc);
        
        courseGroup.bind(courseDesc, "courseDesc");
        
    }
    
    private void prepareButtons() {
        saveBtn = new Button("Save");
        saveBtn.addClickListener(this);
        addComponent(saveBtn);
        
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        try {
            courseGroup.commit();
            Course course = courseGroup.getItemDataSource().getBean();
            
            Notification.show("Button clicked" + course.getCourseDesc());
            ((MyVaadinUI)getUI()).getSessionBean().saveData(course);
            
        } catch (FieldGroup.CommitException ex) {
            Logger.getLogger(CourseDataEnterView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
