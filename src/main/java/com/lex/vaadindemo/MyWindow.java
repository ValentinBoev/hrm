/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lex.vaadindemo;

import com.lex.vaadindemo.data.NewSessionBean;
import com.lex.vaadindemo.data.ServiceRequest;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import javax.ejb.EJB;
import javax.inject.Named;

/**
 *
 * @author mgubaidullin
 */
@Named("mywindow")
public class MyWindow extends Window implements Button.ClickListener {

    @EJB
    NewSessionBean bean;
    private FormLayout layout = new FormLayout();
    private Button save = new Button("Add Data", this);
    private BeanFieldGroup<ServiceRequest> fieldGroup = new BeanFieldGroup<ServiceRequest>(ServiceRequest.class);

    public MyWindow() {
        super("New data");
        TextArea firstName = new TextArea("First Name:");
        TextField lastName = new TextField("Last Name:");
        TextField title = new TextField("Title:");
        TextField name = new TextField("Name:");
        layout.addComponent(firstName);
        layout.addComponent(lastName);
        layout.addComponent(title);
        layout.addComponent(name);
        layout.setMargin(true);
        layout.setSpacing(true);
        layout.addComponent(save);
        setContent(layout);
        
        setModal(true);

        fieldGroup.bind(firstName, "firstName");
        fieldGroup.bind(lastName, "lastName");
        fieldGroup.bind(title, "title");
        fieldGroup.bind(name, "name");
    }

    public void initUI(ServiceRequest serviceRequest) {
        fieldGroup.setItemDataSource(new BeanItem<ServiceRequest>(serviceRequest));
    }

    @Override
    public void buttonClick(ClickEvent event) {
        try {
            fieldGroup.commit();
            ServiceRequest serviceRequest = fieldGroup.getItemDataSource().getBean();
            bean.saveData(serviceRequest);
            this.close();
        } catch (CommitException ex) {
            ex.printStackTrace();
        }

    }
}
