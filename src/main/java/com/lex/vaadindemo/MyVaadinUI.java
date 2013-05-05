package com.lex.vaadindemo;

import com.lex.vaadindemo.data.ServiceRequest;
import com.vaadin.cdi.Root;
import com.vaadin.cdi.VaadinUI;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
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
    private VerticalLayout vl = new VerticalLayout();
    
    Accordion sample;
    Accordion sample1;
    
    @Override
    protected void init(VaadinRequest request) {
        initLayout();
    }
    
    /*
    * In this example layouts are programmed in Java. You may choose use a
    * visual editor, CSS or HTML templates for layout instead.
    */
    private void initLayout() {
        VerticalLayout hl = new VerticalLayout();
        setContent(hl);
        
        Link link;
        sample1 = new Accordion();
        sample1.setHeight("80%");
        sample1.setWidth("200px");

        for (int i = 1; i < 8; i++) {
            sample1.addTab(menu1(), "Tab " + i);
        }
        hl.addComponent(sample1);
        hl.addComponent(vl);
        hl.addStyleName("outlined");
        
        link = new Link("Google search", new ExternalResource("http://www.google.com"));
        link.setDescription("Visit google.com");
        link.setStyleName("button");
        
        NativeButton nb;
        
        nb = new NativeButton("Click");
        nb.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(final ClickEvent event) {
                Notification.show("The button was clicked",
                        Type.TRAY_NOTIFICATION);
            }
        });
        hl.addComponent(nb);
        hl.addComponent(link);
        hl.addComponent(menu1());
        
        GeneratedColumnExample columnExample = new GeneratedColumnExample();
        columnExample.init(getLorem());
        
        hl.addComponent(columnExample);
        
    }
    
    private VerticalLayout menu1 () {
        // Normal buttons (more themable)
        VerticalLayout buttons = new VerticalLayout();
        buttons.setSpacing(true);
        MarginInfo marginInfo = new MarginInfo(false, true, false, false);
        buttons.setMargin(marginInfo);

        buttons.addComponent(new Label("<h3>Normal buttons</h3>",
                Label.CONTENT_XHTML));

        // Button w/ text and tooltip
        Button b = new Button("Caption");
        b.setDescription("Some Desc");
        buttons.addComponent(b);

        // Button w/ HTML text
        b = new Button("HTML Caption");
        b.setHtmlContentAllowed(true);
        b.setDescription("Some Desc");
        b.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                table.setContainerDataSource(data);
                table.setSizeFull();
                table.setSelectable(true);
                table.setMultiSelect(false);
                table.setVisibleColumns(new String[]{"firstName", "lastName", "title"});
                table.setColumnHeaders(new String[]{"First name", "Last name", "Title"});

                vl.addComponent(table);
            }
        });
        buttons.addComponent(b);

        // Button w/ text, icon and tooltip
        b = new Button("Yet Caption");
        b.setDescription("Some Desc");
        buttons.addComponent(b);

        // Button w/ icon and tooltip
        b = new Button("Yet Another Caption");
        b.setDescription("Some Desc");
        buttons.addComponent(b);
        
        return buttons;

    }
    
    public String getLorem () {
        String lorem = new String();
        
        lorem = "Ctum id, lacinia sit amet, elementum posuere, ipsum. "
                + "Integer luctus dictum libero. Pellentesque sed pede "
                + "sed nisl bibendum porttitor. Phasellus tempor "
                + "interdum nisi. Mauris nec magna. Phasellus massa "
                + "pede, vehicula sed, ornare at, ullamcorper ut, nisl. "
                + "Sed turpis nisl, hendrerit sit amet, consequat id, "
                + "auctor nec, arcu. Quisque fringilla tincidunt massa. "
                + "In eleifend, nulla sed mollis vestibulum, mauris orci "
                + "facilisis ante, id pharetra dolor ipsum vitae sem. Integer dictum. ";
        return lorem;
        
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
