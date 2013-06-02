/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lex.vaadindemo.views;

import com.lex.vaadindemo.MyVaadinUI;
import com.lex.vaadindemo.data.Skill;
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
@Named("skillListView")
public class SkillListView extends VerticalLayout {
    
    private BeanItemContainer<Skill> data = new BeanItemContainer(Skill.class);
    private Table skillListTable;
    
    
    
    public void init () {
        prepareData();
        prepareList();
        prepareLayout();
    }
    
    private void prepareLayout () {
        setMargin(true);
        addComponent(skillListTable);
        setExpandRatio(skillListTable, 1f);

    }
    
    private void prepareList () {
        skillListTable = new Table();
        skillListTable.setContainerDataSource(data);
        skillListTable.setSizeFull();
        skillListTable.setSelectable(true);
        skillListTable.setMultiSelect(false);
        skillListTable.setVisibleColumns(new String[]{"skillDesc"});
        skillListTable.setColumnHeaders(new String[]{"Skill Title"});
        skillListTable.addGeneratedColumn("id", new IdColumn());
    }
    
    private void prepareData() {
        
        EntityManager em = ((MyVaadinUI)getUI()).getEntityManager();
        Query query = em.createNamedQuery("Skill.findAll");
        List<Skill> list = query.getResultList();
        data.removeAllItems();
        data.addAll(list);
        System.out.println(data);
    }



    class IdColumn implements Table.ColumnGenerator, Button.ClickListener {

        @Override
        public Object generateCell(Table source, Object itemId, Object columnId) {
            Skill skill = (Skill) itemId;
            Button btn = new Button(String.valueOf(skill.getId()));
            btn.setStyleName(Reindeer.BUTTON_LINK);
            btn.setData(skill);
            btn.addClickListener(this);
            return btn;
        }

        @Override
        public void buttonClick(Button.ClickEvent event) {
            Skill skill = (Skill) event.getButton().getData();
            SkillDataEnterView skillsDataEnterView = new SkillDataEnterView();
            Window window = new Window("Skill: " + skill.getId());
            window.setWidth("97%");
            window.setHeight("95%");
            window.setModal(true);
            window.setContent(skillsDataEnterView);
            getUI().addWindow(window);
            skillsDataEnterView.init(skill);


            window.addCloseListener(new Window.CloseListener() {

                @Override
                public void windowClose(CloseEvent e) {
                    prepareData();
                }
            });
        }
    }
}
