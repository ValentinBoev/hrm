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
@Table(name = "skills", catalog = "hrm", schema = "hrm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Skills.findAll", query = "SELECT s FROM Skills s"),
    @NamedQuery(name = "Skills.findById", query = "SELECT s FROM Skills s WHERE s.id = :id"),
    @NamedQuery(name = "Skills.findBySkillDesc", query = "SELECT s FROM Skills s WHERE s.skillDesc = :skillDesc")})
public class Skills implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 450)
    @Column(name = "skill_desc", length = 450)
    private String skillDesc;    
    

    public Skills() {
    }

    public Skills(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkillDesc() {
        return skillDesc;
    }

    public void setSkillDesc(String skillDesc) {
        this.skillDesc = skillDesc;
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
        if (!(object instanceof Skills)) {
            return false;
        }
        Skills other = (Skills) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lex.vaadindemo.data.Skills[ id=" + id + " ]";
    }
    
}
