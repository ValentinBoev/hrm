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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author valentin boev
 */
@Entity
@Table(name = "emp_skills", catalog = "hrm", schema = "hrm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpSkills.findAll", query = "SELECT es FROM EmpSkills es"),
    @NamedQuery(name = "EmpSkills.findById", query = "SELECT es FROM EmpSkills es WHERE es.id = :id"),
    @NamedQuery(name = "EmpSkills.findByEmpId", query = "SELECT es FROM EmpSkills es WHERE es.empId = :empId"),
    @NamedQuery(name = "EmpSkills.findBySkillId", query = "SELECT es FROM EmpSkills es WHERE es.skillId = :skillId")})
public class EmpSkills implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "emp_id")
    private Integer empId;
    @Column(name = "skill_id")
    private Integer skillId;   
    

    public EmpSkills() {
    }

    public EmpSkills(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
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
        if (!(object instanceof EmpSkills)) {
            return false;
        }
        EmpSkills other = (EmpSkills) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lex.vaadindemo.data.EmpSkills[ id=" + id + " ]";
    }
    
}
