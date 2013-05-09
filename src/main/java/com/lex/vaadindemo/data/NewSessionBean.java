/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lex.vaadindemo.data;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mgubaidullin
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class NewSessionBean {

    @PersistenceContext(unitName = "demoPU")
    protected EntityManager entityManager;
    
    public EntityManager getEntityManager () {
        return entityManager;
    }

   
    public void saveData(Object data) {
//        entityManager.persist(data);
        entityManager.merge(data);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
