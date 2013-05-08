/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lex.vaadindemo.data;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mgubaidullin
 */
@Stateless
@LocalBean
public class NewSessionBean {

    @PersistenceContext(unitName = "demoPU")
    protected EntityManager entityManager;
    
    public EntityManager getEntityManager () {
        return entityManager;
    }

    public void saveData(Department data) {
//        entityManager.persist(data);
        System.out.println(entityManager);
        entityManager.merge(data);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
