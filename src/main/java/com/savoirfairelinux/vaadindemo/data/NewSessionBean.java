/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.savoirfairelinux.vaadindemo.data;

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
    EntityManager entityManager;

    public void saveData(ServiceRequest data) {
        entityManager.merge(data);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
