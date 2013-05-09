package com.mobilemaestria.saas.appcontainer.model;

import com.mobilemaestria.saas.appcontainer.model.aggregation.ImportSummary;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author Dmitri Carpov
 */
@Entity
@Table(name = "CLIENT", uniqueConstraints = {
    @UniqueConstraint(columnNames = { "organizationId" })
})
@NamedQueries({
    @NamedQuery(name = "Client.getByClientId",
        query = "SELECT _client FROM Client _client WHERE _client.organizationId = :organizationId")
})
public class Client extends BaseModel {
    private String name;
    private Long organizationId;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Set<ImportSummary> importSummaries;

    /**
     * Get client summaries sorted by date. Last import summary goes first.
     * */
    public List<ImportSummary> summaries() {
        final List<ImportSummary> summaries = new ArrayList<ImportSummary>();
        if (importSummaries != null) {
            summaries.addAll(importSummaries);
            Collections.sort(summaries, new ImportSummary.EndDateDescComparator());
        }
        return summaries;
    }

    // --- Generated Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Set<ImportSummary> getImportSummaries() {
        return importSummaries;
    }

    public void setImportSummaries(Set<ImportSummary> importSummaries) {
        this.importSummaries = importSummaries;
    }
}
