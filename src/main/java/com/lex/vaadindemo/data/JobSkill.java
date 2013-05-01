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
@Table(name = "job_skill", catalog = "hrm", schema = "hrm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobSkill.findAll", query = "SELECT js FROM JobSkill js"),
    @NamedQuery(name = "JobSkill.findById", query = "SELECT js FROM JobSkill js WHERE js.id = :id"),
    @NamedQuery(name = "JobSkill.findByJobId", query = "SELECT js FROM JobSkill js WHERE js.jobId = :jobId"),
    @NamedQuery(name = "JobSkill.findBySkillId", query = "SELECT js FROM JobSkill js WHERE js.skillId = :skillId")})
public class JobSkill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "job_id")
    private Integer jobId;
    @Column(name = "skill_id")
    private Integer skillId;   
    

    public JobSkill() {
    }

    public JobSkill(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
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
        if (!(object instanceof JobSkill)) {
            return false;
        }
        JobSkill other = (JobSkill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lex.vaadindemo.data.JobSkill[ id=" + id + " ]";
    }
    
}
