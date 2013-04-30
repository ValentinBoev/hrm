package com.lex.vaadindemo;

import com.lex.vaadindemo.data.ServiceRequest;
import com.vaadin.cdi.Root;
import com.vaadin.cdi.VaadinUI;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Table;
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

    @Override
    protected void init(VaadinRequest request) {
        layout.setMargin(true);
        layout.addComponent(button);
        layout.addComponent(add);
        layout.addComponent(edit);

        table.setContainerDataSource(data);
        table.setSizeFull();
        table.setSelectable(true);
        table.setMultiSelect(false);
        table.setVisibleColumns(new String[]{"firstName", "lastName", "title"});
        table.setColumnHeaders(new String[]{"First name", "Last name", "Title"});

        layout.addComponent(table);
        layout.setExpandRatio(table, 1f);
        setContent(layout);
        
        refresh();
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
