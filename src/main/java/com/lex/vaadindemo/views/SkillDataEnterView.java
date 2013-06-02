/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lex.vaadindemo.views;

import com.lex.vaadindemo.MyVaadinUI;
import com.lex.vaadindemo.data.Skill;
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
public class SkillDataEnterView extends VerticalLayout implements Button.ClickListener {
    
    private Button saveBtn;
    private TextField skillDesc;
    private BeanFieldGroup<Skill> skillGroup = new BeanFieldGroup<Skill>(Skill.class);
    



    public void init(Skill skill) {
        prepareFields();
        prepareButtons();
        skillGroup.setItemDataSource(new BeanItem<Skill>(skill));
    }
    
    
    
    private void prepareFields() {
        skillDesc = new TextField("Skill Title:");
        addComponent(skillDesc);
        
        skillGroup.bind(skillDesc, "skillDesc");
        
    }
    
    private void prepareButtons() {
        saveBtn = new Button("Save");
        saveBtn.addClickListener(this);
        addComponent(saveBtn);
        
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        try {
            skillGroup.commit();
            Skill skill = skillGroup.getItemDataSource().getBean();
            
            Notification.show("Button clicked" + skill.getSkillDesc());
            ((MyVaadinUI)getUI()).getSessionBean().saveData(skill);
            
        } catch (FieldGroup.CommitException ex) {
            Logger.getLogger(SkillDataEnterView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
