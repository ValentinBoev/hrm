package com.lex.vaadindemo;

import com.lex.vaadindemo.data.ServiceRequest;
import com.vaadin.cdi.Root;
import com.vaadin.cdi.VaadinUI;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.CloseListener;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
@VaadinUI("demo")
@Root
public class MyVaadinUI extends UI implements ClickListener, CloseListener {

    @Inject
    MyWindow myWindow;
    @PersistenceContext(unitName = "demoPU")
    EntityManager entityManager;
    private VerticalLayout layout = new VerticalLayout();
    private Button button = new Button("Refresh Data", this);
    private Button add = new Button("Add Data", this);
    private Button edit = new Button("Edit Data", this);
    private Table table = new Table();
    private BeanItemContainer<ServiceRequest> data = new BeanItemContainer(ServiceRequest.class);
    
    /* User interface components are stored in session. */
    private Table contactList = new Table();
    private TextField searchField = new TextField();
    private Button addNewContactButton = new Button("New");
    private Button removeContactButton = new Button("Remove this contact");
    private FormLayout editorLayout = new FormLayout();
    private FieldGroup editorFields = new FieldGroup();

    @Override
    protected void init(VaadinRequest request) {
        initLayout();
    }
    
    /*
    * In this example layouts are programmed in Java. You may choose use a
    * visual editor, CSS or HTML templates for layout instead.
    */
    private void initLayout() {

        /* Root of the user interface component tree is set */
        HorizontalSplitPanel splitPanel = new HorizontalSplitPanel();
        setContent(splitPanel);

        /* Build the component tree */
        VerticalLayout leftLayout = new VerticalLayout();
        splitPanel.addComponent(leftLayout);
        splitPanel.addComponent(editorLayout);
        leftLayout.addComponent(contactList);
        HorizontalLayout bottomLeftLayout = new HorizontalLayout();
        leftLayout.addComponent(bottomLeftLayout);
        bottomLeftLayout.addComponent(searchField);
        bottomLeftLayout.addComponent(addNewContactButton);

        /* Set the contents in the left of the split panel to use all the space */
        leftLayout.setSizeFull();

        /*
         * On the left side, expand the size of the contactList so that it uses
         * all the space left after from bottomLeftLayout
         */
        leftLayout.setExpandRatio(contactList, 1);
        contactList.setSizeFull();

        /*
         * In the bottomLeftLayout, searchField takes all the width there is
         * after adding addNewContactButton. The height of the layout is defined
         * by the tallest component.
         */
        bottomLeftLayout.setWidth("100%");
        searchField.setWidth("100%");
        bottomLeftLayout.setExpandRatio(searchField, 1);

        /* Put a little margin around the fields in the right side editor */
        editorLayout.setMargin(true);
        editorLayout.setVisible(false);
    }
	

    @Override
    public void buttonClick(ClickEvent event) {
        if (event.getButton().equals(button)) {
            refresh();
        } else if (event.getButton().equals(add)) {
            myWindow.initUI(new ServiceRequest());
            myWindow.addCloseListener(this);
            addWindow(myWindow);
        } else if (event.getButton().equals(edit)) {
            myWindow.initUI((ServiceRequest) table.getValue());
            myWindow.addCloseListener(this);
            addWindow(myWindow);
        }
    }

    private void refresh() {
        TypedQuery<ServiceRequest> query = entityManager.createNamedQuery("ServiceRequest.findAll", ServiceRequest.class);
        List<ServiceRequest> list = query.getResultList();
        data.removeAllItems();
        data.addAll(list);
    }

    @Override
    public void windowClose(CloseEvent e) {
        refresh();
    }
}
