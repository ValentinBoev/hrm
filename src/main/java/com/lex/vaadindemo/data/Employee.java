/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lex.vaadindemo.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author valentin boev
 */
@Entity
@Table(name = "employee", catalog = "hrm", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id"),
//    @NamedQuery(name = "Employee.fullData", query = "SELECT e FROM Employee e   " +
//                                                    "LEFT JOIN JobOffers jo ON jo.id = e.jobCode " +
//                                                    "LEFT JOIN EmployeeData ed ON ed.empId = e.id"),
//    @NamedQuery(name = "Employee.fullData", query = "SELECT ed, j, e FROM Employee e, " +
//                                                    "Job j, EmployeeData ed  " +
//                                                    "WHERE j.id = e.jobCode AND ed.empId = e.id"),
    @NamedQuery(name = "Employee.fullData", query = "SELECT e FROM Employee e, " +
                                                    "Job j, EmployeeData ed  "),
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
    @Column(name = "supervisor_id", nullable = true)
    private Integer supervisorId;
    @Column(name = "base_salary", nullable = true)
    private double baseSalary;
    @Column(name = "bonus", nullable = true)
    private double bonus;
    @ManyToOne
    @JoinColumn(name="job_code")
    private Job job;
    @ManyToOne
    @JoinColumn(name="dept_code")
    private Department department;
    @OneToOne(mappedBy = "employee", fetch = FetchType.EAGER)
    private EmployeeData employeeData;
    
    

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

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EmployeeData getEmployeeData() {
        return employeeData;
    }

    public void setEmployeeData(EmployeeData employeeData) {
        this.employeeData = employeeData;
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
