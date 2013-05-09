package com.mobilemaestria.saas.appcontainer.model;

import com.mobilemaestria.saas.appcontainer.model.aggregation.ImportSummary;

import javax.persistence.*;
import java.util.List;

/**
 * @author Dmitri Carpov
 */
@Entity
@Table(name = "PROVIDER")
@NamedQueries({
        @NamedQuery(name = "Provider.getByName",
        query = "SELECT _provider FROM Provider _provider WHERE _provider.name = :name")
})
public class Provider extends BaseModel {
    @Column(name = "NAME")
    private String name;
    @Column(name = "SERVICE_NAME")
    private String serviceName;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "provider")
    private List<Account> accounts;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "provider")
    private List<ImportSummary> importSummaries;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "provider")
    private List<ServicePlan> servicePlans;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<ImportSummary> getImportSummaries() {
        return importSummaries;
    }

    public void setImportSummaries(List<ImportSummary> importSummaries) {
        this.importSummaries = importSummaries;
    }

    public List<ServicePlan> getServicePlans() {
        return servicePlans;
    }

    public void setServicePlans(List<ServicePlan> servicePlans) {
        this.servicePlans = servicePlans;
    }
}
