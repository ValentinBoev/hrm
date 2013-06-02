/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lex.vaadindemo.views;

import com.lex.vaadindemo.data.Course;
import com.lex.vaadindemo.data.Department;
import com.lex.vaadindemo.data.Employee;
import com.lex.vaadindemo.data.EmployeeData;
import com.lex.vaadindemo.data.Job;
import com.lex.vaadindemo.data.Skill;
import com.vaadin.cdi.VaadinView;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import javax.inject.Named;

/**
 *
 * @author valik
 */
@VaadinView("demo")
@Named("mainView")
public class MainView extends VerticalLayout implements Button.ClickListener {
    
    VerticalLayout mainMenu;
    Panel contentArea;
    Accordion accordion;
    
    private Button userBtn1;
    private Button userBtn2;
    
    private Button userDataBtn1;
    private Button userDataBtn2;
    
    private Button departmentBtn1;
    private Button departmentBtn2;
    
    private Button vacancyBtn1;
    private Button vacancyBtn2;
    
    private Button reportBtn1;
    private Button reportBtn2;
    
    private Button basicBtn1;
    private Button basicBtn2;
    
    private JobDataEnterView jobsDataEnterView;
    private EnterInfo enterInfo;
    private UserListView userListView;
    private JobListView jobListView;
    private DepartmentListView departmentListView;
    private DepartmentDataEnterView departmentDataEnterView;
    private UserEnterView userEnterView;
    private UserDataListView userDataListView;
    private UserDataEnterView userDataEnterView;
    private SingleUserReportView singleUserReportView;
    private Button skillBtn2;
    private Button skillBtn1;
    private Button courseBtn1;
    private Button courseBtn2;
    private SkillListView skillListView;
    private SkillDataEnterView skillDataEnterView;
    private CourseListView courseListView;
    private CourseDataEnterView courseDataEnterView;
    
    
    
    public void initUI () {
        prepareElements();
        prepareLayout();
    }
    
    private void prepareLayout () {
        HorizontalLayout hl = new HorizontalLayout();
        hl.setSizeFull();
        hl.addComponent(mainMenu);
        
        hl.addComponent(contentArea);
        hl.setExpandRatio(contentArea, 1f);
        addComponent(hl);
    }
    
    private void prepareElements() {

        
        accordion = new Accordion();
        accordion.setHeight(100.0f, Unit.PERCENTAGE);
        accordion.addTab(userTab(), "Users");
        accordion.addTab(vacancyTab(), "Vacancy");
        accordion.addTab(reportTab(), "Reports");
        accordion.addTab(basicTab(), "Basic");
        
        mainMenu = new VerticalLayout();
        mainMenu.setWidth(250, Unit.PIXELS);
        mainMenu.addComponent(accordion);
                
        contentArea = new Panel();
//        userListView = new UserListView();
//        contentArea.setContent(userListView);
//        userListView.init();
        contentArea.setSizeFull();
    }
    
    private VerticalLayout userTab () {
        VerticalLayout tabContent = new VerticalLayout();
        
        userBtn1 = new Button("List Users");
        userBtn1.addClickListener(this);
        tabContent.addComponent(userBtn1);
        
        userBtn2 = new Button("Add Users");
        userBtn2.addClickListener(this);
        tabContent.addComponent(userBtn2);
        
        userDataBtn1 = new Button("List User Data");
        userDataBtn1.addClickListener(this);
        tabContent.addComponent(userDataBtn1);
        
        userDataBtn2 = new Button("Add User Data");
        userDataBtn2.addClickListener(this);
        tabContent.addComponent(userDataBtn2);
        
        return tabContent;
    }
    
    private VerticalLayout vacancyTab () {
        VerticalLayout tabContent = new VerticalLayout();
        
        
        
        return tabContent;
    }
    
    private VerticalLayout reportTab () {
        VerticalLayout tabContent = new VerticalLayout();
        
        reportBtn1 = new Button("List User Data");
        reportBtn1.addClickListener(this);
        tabContent.addComponent(reportBtn1);
        
        reportBtn2 = new Button("Hello, i'm Report reportBtn #2");
        reportBtn2.addClickListener(this);
        tabContent.addComponent(reportBtn2);
        
        return tabContent;
    }
    
    private VerticalLayout basicTab () {
        VerticalLayout tabContent = new VerticalLayout();
        
        vacancyBtn1 = new Button("List Jobs");
        vacancyBtn1.addClickListener(this);
        tabContent.addComponent(vacancyBtn1);
        
        vacancyBtn2 = new Button("Add Jobs");
        vacancyBtn2.addClickListener(this);
        tabContent.addComponent(vacancyBtn2);
        
        departmentBtn1 = new Button("List Departments");
        departmentBtn1.addClickListener(this);
        tabContent.addComponent(departmentBtn1);
        
        departmentBtn2 = new Button("Add Department");
        departmentBtn2.addClickListener(this);
        tabContent.addComponent(departmentBtn2);
        
        skillBtn1 = new Button("List Skills");
        skillBtn1.addClickListener(this);
        tabContent.addComponent(skillBtn1);
        
        skillBtn2 = new Button("Add Skill");
        skillBtn2.addClickListener(this);
        tabContent.addComponent(skillBtn2);
        
        courseBtn1 = new Button("List Course");
        courseBtn1.addClickListener(this);
        tabContent.addComponent(courseBtn1);
        
        courseBtn2 = new Button("Add Course");
        courseBtn2.addClickListener(this);
        tabContent.addComponent(courseBtn2);
        
        return tabContent;
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        if(event.getButton().equals(userBtn1)) {
            userListView = new UserListView();
            contentArea.setContent(userListView);
            userListView.init();
        } else if(event.getButton().equals(userBtn2)) {
            userEnterView = new UserEnterView();
            contentArea.setContent(userEnterView);
            userEnterView.init(new Employee());
        } else if(event.getButton().equals(userDataBtn1)) {
            userDataListView = new UserDataListView();
            contentArea.setContent(userDataListView);
            userDataListView.init();
        } else if(event.getButton().equals(userDataBtn2)) {
            userDataEnterView = new UserDataEnterView();
            contentArea.setContent(userDataEnterView);
            userDataEnterView.init(new EmployeeData());
        } else if(event.getButton().equals(departmentBtn1)) {
            departmentListView = new DepartmentListView();
            contentArea.setContent(departmentListView);
            departmentListView.init();
        } else if(event.getButton().equals(departmentBtn2)) {
            departmentDataEnterView = new DepartmentDataEnterView();
            contentArea.setContent(departmentDataEnterView);
            departmentDataEnterView.init(new Department());
        } else if(event.getButton().equals(vacancyBtn1)) {
            jobListView = new JobListView();
            contentArea.setContent(jobListView);
            jobListView.init();
        } else if(event.getButton().equals(vacancyBtn2)) {
            jobsDataEnterView = new JobDataEnterView();
            contentArea.setContent(jobsDataEnterView);
            jobsDataEnterView.init(new Job());
        } else if(event.getButton().equals(reportBtn1)) {
            singleUserReportView = new SingleUserReportView();
            contentArea.setContent(singleUserReportView);
            singleUserReportView.init();
        } else if(event.getButton().equals(reportBtn2)) {
            enterInfo = new EnterInfo();
            contentArea.setContent(enterInfo);
            enterInfo.init(new Department());
        } else if(event.getButton().equals(basicBtn1)) {
            contentArea.setContent(new Label("This is my new Basic content"));
        } else if(event.getButton().equals(basicBtn2)) {
            enterInfo = new EnterInfo();
            contentArea.setContent(enterInfo);
            enterInfo.init(new Department());
        } else if(event.getButton().equals(skillBtn1)) {
            skillListView = new SkillListView();
            contentArea.setContent(skillListView);
            skillListView.init();
        } else if(event.getButton().equals(skillBtn2)) {
            skillDataEnterView = new SkillDataEnterView();
            contentArea.setContent(skillDataEnterView);
            skillDataEnterView.init(new Skill());
        } else if(event.getButton().equals(courseBtn1)) {
            courseListView = new CourseListView();
            contentArea.setContent(courseListView);
            courseListView.init();
        } else if(event.getButton().equals(courseBtn2)) {
            courseDataEnterView = new CourseDataEnterView();
            contentArea.setContent(courseDataEnterView);
            courseDataEnterView.init(new Course());
        } 
    }
    
    
    
}
