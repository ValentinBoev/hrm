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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "employee_data", catalog = "hrm", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeData.findAll", query = "SELECT ed FROM EmployeeData ed"),
    @NamedQuery(name = "EmployeeData.findById", query = "SELECT ed FROM EmployeeData ed WHERE ed.id = :id")})
public class EmployeeData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 100)
    @Column(name = "middle_name", length = 100)
    private String middleName;
    @Size(max = 450)
    @Column(name = "address", length = 450)
    private String address;
    @Size(max = 100)
    @Column(name = "city", length = 100)
    private String city;
    @Size(max = 32)
    @Column(name = "country_state", length = 32)
    private String countryState;
    @Size(max = 16)
    @Column(name = "zip", length = 16)
    private String zip;
    @Size(max = 32)
    @Column(name = "mobile_phone", length = 32)
    private String mobilePhone;
    @Size(max = 32)
    @Column(name = "home_phone", length = 32)
    private String homePhone;
    @Size(max = 64)
    @Column(name = "email", length = 64)
    private String email;
    @Size(max = 16)
    @Column(name = "gender", length = 16)
    private String gender;
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Size(max = 16)
    @Column(name = "martial_state", length = 16)
    private String martialState;
    @Size(max = 255)
    @Column(name = "degree", length = 255)
    private String degree;
    @Column(name = "attained")
    @Temporal(TemporalType.DATE)
    private Date attained;
    @Size(max = 450)
    @Column(name = "experience", length = 450)
    private String experience;
    @Column(name = "resume_id")
    private Integer resumeId;
    @Size(max = 128)
    @Column(name = "image_path", length = 128)
    private String imagePath;
    @OneToOne
    @JoinColumn(name="emp_id")
    private Employee employee;

    

    public EmployeeData() {
    }

    public EmployeeData(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryState() {
        return countryState;
    }

    public void setCountryState(String countryState) {
        this.countryState = countryState;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getMartialState() {
        return martialState;
    }

    public void setMartialState(String martialState) {
        this.martialState = martialState;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Date getAttained() {
        return attained;
    }

    public void setAttained(Date attained) {
        this.attained = attained;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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
        if (!(object instanceof EmployeeData)) {
            return false;
        }
        EmployeeData other = (EmployeeData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lex.vaadindemo.data.EmployeeData[ id=" + id + " ]";
    }
    
}
