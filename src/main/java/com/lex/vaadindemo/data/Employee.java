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
@Table(name = "employee", catalog = "hrm", schema = "hrm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id"),
//    @NamedQuery(name = "Employee.fullData", query = "SELECT e FROM Employee e   " +
//                                                    "LEFT JOIN JobOffers jo ON jo.id = e.jobCode " +
//                                                    "LEFT JOIN EmployeeData ed ON ed.empId = e.id"),
    @NamedQuery(name = "Employee.fullData", query = "SELECT ed, j, e FROM Employee e, " +
                                                    "Jobs j, EmployeeData ed  " +
                                                    "WHERE j.id = e.jobCode AND ed.empId = e.id"),
    @NamedQuery(name = "Employee.findByJobCode", query = "SELECT e FROM Employee e WHERE e.jobCode = :jobCode"),
    @NamedQuery(name = "Employee.findByDeptCode", query = "SELECT e FROM Employee e WHERE e.deptCode = :deptCode"),
    @NamedQuery(name = "Employee.findBySupervisorId", query = "SELECT e FROM Employee e WHERE e.supervisorId = :supervisorId"),
    @NamedQuery(name = "Employee.findByBaseSalary", query = "SELECT e FROM Employee e WHERE e.baseSalary = :baseSalary"),
    @NamedQuery(name = "Employee.findByBonus", query = "SELECT e FROM Employee e WHERE e.bonus = :bonus")})
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "job_code")
    private Integer jobCode;
    @Column(name = "dept_code")
    private Integer deptCode;
    @Column(name = "supervisor_id")
    private Integer supervisorId;
    @Column(name = "base_salary")
    private double baseSalary;
    @Column(name = "bonus")
    private double bonus;

    
    

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJobCode() {
        return jobCode;
    }

    public void setJobCode(Integer jobCode) {
        this.jobCode = jobCode;
    }

    public Integer getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(Integer deptCode) {
        this.deptCode = deptCode;
    }

    public Integer getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Integer supervisorId) {
        this.supervisorId = supervisorId;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
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
