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
@Table(name = "emp_course", catalog = "hrm", schema = "hrm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpCourse.findAll", query = "SELECT ec FROM EmpCourse ec"),
    @NamedQuery(name = "EmpCourse.findById", query = "SELECT ec FROM EmpCourse ec WHERE ec.id = :id"),
    @NamedQuery(name = "EmpCourse.findByEmpId", query = "SELECT ec FROM EmpCourse ec WHERE ec.empId = :empId"),
    @NamedQuery(name = "EmpCourse.findByCourseId", query = "SELECT ec FROM EmpCourse ec WHERE ec.courseId = :courseId")})
public class EmpCourse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "emp_id")
    private Integer empId;
    @Column(name = "course_id")
    private Integer courseId;   
    

    public EmpCourse() {
    }

    public EmpCourse(Integer id) {
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

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
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
        if (!(object instanceof EmpCourse)) {
            return false;
        }
        EmpCourse other = (EmpCourse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lex.vaadindemo.data.Employee[ id=" + id + " ]";
    }
    
}