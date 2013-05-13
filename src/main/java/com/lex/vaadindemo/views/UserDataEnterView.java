/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lex.vaadindemo.views;

import com.lex.vaadindemo.MyVaadinUI;
import com.lex.vaadindemo.data.Employee;
import com.lex.vaadindemo.data.EmployeeData;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FileResource;
import static com.vaadin.server.Sizeable.UNITS_EM;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;
import com.vaadin.ui.VerticalLayout;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author valik
 */
public class UserDataEnterView extends VerticalLayout implements Button.ClickListener {
    
    private Button saveBtn;
    private BeanFieldGroup<EmployeeData> employeeDataGroup = new BeanFieldGroup<EmployeeData>(EmployeeData.class);
    
    private NativeSelect employeeSelect;
    private BeanItemContainer<Employee> employee = new BeanItemContainer(Employee.class);
    
    private TextField address;
    private TextField city;
    private TextField countryState;
    private TextField zip;
    private TextField mobilePhone;
    private TextField homePhone;
    private TextField email;
    private NativeSelect genderSelect;
    
    private String fileName = "";
    
    private File file;


    public void init(EmployeeData employeeData) {
        fileName = employeeData.getImagePath();
        prepareFields();
        prepareButtons();
        
        employeeDataGroup.setItemDataSource(new BeanItem<EmployeeData>(employeeData));
    }
    
    
    
    private void prepareFields() {
        
        employeeSelect = new NativeSelect("Select an employee:");
        employeeSelect.setContainerDataSource(prepareEmployeeData());
        employeeSelect.setItemCaptionPropertyId("lastName");
        employeeSelect.setWidth(10.0f, UNITS_EM);
//        employeeSelect.addValueChangeListener(new ValueChangeListener() {
//            @Override
//            public void valueChange(final ValueChangeEvent event) {
//                final String valueString = String.valueOf(event.getProperty()
//                        .getValue());
//                Notification.show("Value changed:", valueString,
//                        Type.TRAY_NOTIFICATION);
//            }
//        });
        
        
        // Create the upload with a caption and set receiver later
        Upload upload = new Upload("Upload Image Here", null);
        upload.setButtonCaption("Start Upload");
        addComponent(upload);
        
        // Find the application directory
        final String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath() + "/WEB-INF/";
        System.out.println(basepath);
        System.out.println(fileName);
        
        // Show uploaded file in this placeholder
        final Image image = new Image("userPic");
        if (fileName == null) {
            System.out.println("tipa pusto");
            image.setVisible(false);
        } else {
            System.out.println(fileName);
            // Image as a file resource
            FileResource resource = new FileResource(new File(basepath + fileName));
            image.setVisible(true);
            image.setSource(resource);
            
        }
        addComponent(image);
        image.setWidth(250, Unit.PIXELS);
        image.setHeight(250, Unit.PIXELS);

        // Implement both receiver that saves upload in a file and
        // listener for successful upload
        class ImageUploader implements Receiver, SucceededListener {
            

            @Override
            public OutputStream receiveUpload(String filename,
                                              String mimeType) {
                // Create upload stream
                FileOutputStream fos = null; // Stream to write to
                try {
                    // Open the file for writing.
                    file = new File(basepath + filename);
                    fos = new FileOutputStream(file);
                    
                    fileName = filename;
                } catch (final java.io.FileNotFoundException e) {
                    Notification.show(
                            "Could not open file<br/>", e.getMessage(),
                            Notification.TYPE_ERROR_MESSAGE);
                    return null;
                } catch (IOException ex) {
                    Logger.getLogger(UserDataEnterView.class.getName()).log(Level.SEVERE, null, ex);
                }
                return fos; // Return the output stream to write to
            }

            @Override
            public void uploadSucceeded(SucceededEvent event) {
                // Show the uploaded file in the image viewer
                image.setVisible(true);
                image.setSource(new FileResource(file));
            }
        };
        final ImageUploader uploader = new ImageUploader(); 
        upload.setReceiver(uploader);
        upload.addListener(uploader);
        
        System.out.println(fileName);
        
        address = new TextField("Address:");
        city = new TextField("City:");
        countryState = new TextField("Country State:");
        zip = new TextField("ZIP:");
        mobilePhone = new TextField("Mobile phone:");
        homePhone = new TextField("Home phone:");
        email = new TextField("Email:");
        
        genderSelect = new NativeSelect("Select a gender:");
        genderSelect.addItem("Male");
        genderSelect.addItem("Female");
        genderSelect.setWidth(10.0f, UNITS_EM);
        
        addComponent(employeeSelect);
        addComponent(address);
        addComponent(city);
        addComponent(countryState);
        addComponent(zip);
        addComponent(mobilePhone);
        addComponent(homePhone);
        addComponent(email);
        addComponent(genderSelect);
        
        employeeDataGroup.bind(employeeSelect, "employee");
        employeeDataGroup.bind(address, "address");
        employeeDataGroup.bind(city, "city");
        employeeDataGroup.bind(zip, "zip");
        employeeDataGroup.bind(mobilePhone, "mobilePhone");
        employeeDataGroup.bind(countryState, "countryState");
        employeeDataGroup.bind(homePhone, "homePhone");
        employeeDataGroup.bind(email, "email");
        employeeDataGroup.bind(genderSelect, "gender");
    }
    
    private void prepareButtons() {
        saveBtn = new Button("Save");
        saveBtn.addClickListener(this);
        addComponent(saveBtn);
        
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        try {
            employeeDataGroup.commit();
            EmployeeData employeeData = employeeDataGroup.getItemDataSource().getBean();
            employeeData.setImagePath(fileName);
            ((MyVaadinUI)getUI()).getSessionBean().saveData(employeeData);
            
        } catch (FieldGroup.CommitException ex) {
            Logger.getLogger(UserDataEnterView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private BeanItemContainer<Employee> prepareEmployeeData() {
        
        EntityManager em = ((MyVaadinUI)getUI()).getEntityManager();
        Query query = em.createNamedQuery("Employee.findAll");
        List<Employee> list = query.getResultList();
        employee.removeAllItems();
        employee.addAll(list);
        return employee;
    }
    
    
}
