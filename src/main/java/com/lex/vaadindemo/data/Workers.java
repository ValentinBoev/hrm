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
 * @author valentin boev
 */
@Entity
@Table(name = "workers", catalog = "hrm", schema = "hrm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workers.findAll", query = "SELECT w FROM Workers w"),
    @NamedQuery(name = "Workers.findById", query = "SELECT w FROM Workers w WHERE w.id = :id"),
    @NamedQuery(name = "Workers.findByFirstName", query = "SELECT w FROM Workers w WHERE w.firstName = :firstName"),
    @NamedQuery(name = "Workers.findByLastName", query = "SELECT w FROM Workers w WHERE w.lastName = :lastName"),
    @NamedQuery(name = "Workers.findByPositionId", query = "SELECT w FROM Workers w WHERE w.positionId = :positionId"),
    @NamedQuery(name = "Workers.findByTitle", query = "SELECT w FROM Workers w WHERE w.title = :title"),
    @NamedQuery(name = "Workers.findByBaseSalary", query = "SELECT w FROM Workers w WHERE w.baseSalary = :baseSalary"),
    @NamedQuery(name = "Workers.findByBonus", query = "SELECT w FROM Workers w WHERE w.bonus = :bonus")})
public class Workers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 450)
    @Column(name = "title", length = 450)
    private String title;
    @Size(max = 450)
    @Column(name = "first_name", length = 450)
    private String firstName;
    @Size(max = 450)
    @Column(name = "last_name", length = 450)
    private String lastName;
    @Size(max = 450)
    @Column(name = "position_id", length = 450)
    private Integer positionId;
    @Size(max = 450)
    @Column(name = "base_salary", length = 450)
    private String baseSalary;
    @Size(max = 450)
    @Column(name = "bonus", length = 450)
    private String bonus;
    @Size(max = 450)
    @Column(name = "age", length = 450)
    private Integer age;

    
    

    public Workers() {
    }

    public Workers(Integer id) {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(String baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }
    
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
        if (!(object instanceof Workers)) {
            return false;
        }
        Workers other = (Workers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lex.vaadindemo.data.Workers[ id=" + id + " ]";
    }
    
}
