/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lex.vaadindemo.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mgubaidullin
 */
@Entity
@Table(name = "service_request", catalog = "hrm", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceRequest.findAll", query = "SELECT s FROM ServiceRequest s"),
    @NamedQuery(name = "ServiceRequest.findById", query = "SELECT s FROM ServiceRequest s WHERE s.id = :id"),
    @NamedQuery(name = "ServiceRequest.findByFirstName", query = "SELECT s FROM ServiceRequest s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "ServiceRequest.findByLastName", query = "SELECT s FROM ServiceRequest s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "ServiceRequest.findByName", query = "SELECT s FROM ServiceRequest s WHERE s.name = :name"),
    @NamedQuery(name = "ServiceRequest.findByTitle", query = "SELECT s FROM ServiceRequest s WHERE s.title = :title")})
public class ServiceRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 450)
    @Column(name = "first_name", length = 450)
    private String firstName;
    @Size(max = 450)
    @Column(name = "last_name", length = 450)
    private String lastName;
    @Size(max = 450)
    @Column(name = "name", length = 450)
    private String name;
    @Size(max = 450)
    @Column(name = "title", length = 450)
    private String title;
    @Size(max = 450)
    @Column(name = "description", length = 450)
    private String description;
    

    public ServiceRequest() {
    }

    public ServiceRequest(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceRequest)) {
            return false;
        }
        ServiceRequest other = (ServiceRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lex.vaadindemo.data.ServiceRequest[ id=" + id + " ]";
    }
    
}
