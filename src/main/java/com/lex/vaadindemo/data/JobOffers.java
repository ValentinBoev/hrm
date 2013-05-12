/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lex.vaadindemo.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author valentin boev
 */
@Entity
@Table(name = "job_offers", catalog = "hrm", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobOffers.findAll", query = "SELECT jo FROM JobOffers jo"),
    @NamedQuery(name = "JobOffers.findById", query = "SELECT jo FROM JobOffers jo WHERE jo.id = :id")})
public class JobOffers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "job_code")
    private Job job;
    @Column(name = "contact_id")
    private Integer contactId;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Size(max = 8)
    @Column(name = "open_status", length = 8)
    private String openStatus;
    @Column(name = "experience_req")
    private Integer experienceReq;  
    @Column(name = "vacancy_qty")
    private Integer vacancyQty;  
    @Size(max = 450)
    @Column(name = "job_desc", length = 450)
    private String jobDesc;    

        
    public JobOffers() {
    }

    public JobOffers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(String openStatus) {
        this.openStatus = openStatus;
    }

    public Integer getExperienceReq() {
        return experienceReq;
    }

    public void setExperienceReq(Integer experienceReq) {
        this.experienceReq = experienceReq;
    }

    public Integer getVacancyQty() {
        return vacancyQty;
    }

    public void setVacancyQty(Integer vacancyQty) {
        this.vacancyQty = vacancyQty;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
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
        if (!(object instanceof JobOffers)) {
            return false;
        }
        JobOffers other = (JobOffers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lex.vaadindemo.data.JobOffers[ id=" + id + " ]";
    }
    
}
