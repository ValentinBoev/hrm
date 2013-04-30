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
@Table(name = "perfomance_review", catalog = "hrm", schema = "hrm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfomanceReview.findAll", query = "SELECT pr FROM PerfomanceReview pr"),
    @NamedQuery(name = "PerfomanceReview.findById", query = "SELECT pr FROM PerfomanceReview pr WHERE pr.id = :id"),
    @NamedQuery(name = "PerfomanceReview.findByWorkerId", query = "SELECT pr FROM PerfomanceReview pr WHERE pr.workerId = :workerId"),
    @NamedQuery(name = "PerfomanceReview.findByReviewerId", query = "SELECT pr FROM PerfomanceReview pr WHERE pr.reviewerId = :reviewerId"),
    @NamedQuery(name = "PerfomanceReview.findByCreatorId", query = "SELECT pr FROM PerfomanceReview pr WHERE pr.creatorId = :creatorId"),
    @NamedQuery(name = "PerfomanceReview.findByCreationDate", query = "SELECT pr FROM PerfomanceReview pr WHERE pr.creationDate = :creationDate"),
    @NamedQuery(name = "PerfomanceReview.findByPeriodFrom", query = "SELECT pr FROM PerfomanceReview pr WHERE pr.periodFrom = :periodFrom"),
    @NamedQuery(name = "PerfomanceReview.findByPeriodTo", query = "SELECT pr FROM PerfomanceReview pr WHERE pr.periodTo = :periodTo"),
    @NamedQuery(name = "PerfomanceReview.findByReviewState", query = "SELECT pr FROM PerfomanceReview pr WHERE pr.reviewState = :reviewState")})
public class PerfomanceReview implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 11)
    @Column(name = "worker_id", length = 11)
    private Integer workerId;
    @Size(max = 11)
    @Column(name = "reviewer_id", length = 11)
    private Integer reviewerId;
    @Size(max = 11)
    @Column(name = "creator_id", length = 11)
    private Integer creatorId;
    @Size(max = 11)
    @Column(name = "job_title_code", length = 11)
    private Integer jobTitleCode;
    @Size(max = 450)
    @Column(name = "creation_date", length = 450)
    private String creationDate;
    @Size(max = 450)
    @Column(name = "period_from", length = 450)
    private String periodFrom;
    @Size(max = 450)
    @Column(name = "period_to", length = 450)
    private Integer periodTo;
    @Size(max = 450)
    @Column(name = "review_state", length = 450)
    private String reviewState;

    
    

    public PerfomanceReview() {
    }

    public PerfomanceReview(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public Integer getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Integer reviewerId) {
        this.reviewerId = reviewerId;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getJobTitleCode() {
        return jobTitleCode;
    }

    public void setJobTitleCode(Integer jobTitleCode) {
        this.jobTitleCode = jobTitleCode;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getPeriodFrom() {
        return periodFrom;
    }

    public void setPeriodFrom(String periodFrom) {
        this.periodFrom = periodFrom;
    }

    public Integer getPeriodTo() {
        return periodTo;
    }

    public void setPeriodTo(Integer periodTo) {
        this.periodTo = periodTo;
    }

    public String getReviewState() {
        return reviewState;
    }

    public void setReviewState(String reviewState) {
        this.reviewState = reviewState;
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
        if (!(object instanceof PerfomanceReview)) {
            return false;
        }
        PerfomanceReview other = (PerfomanceReview) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lex.vaadindemo.data.PerfomanceReview[ id=" + id + " ]";
    }
    
}
