package com.mobilemaestria.saas.appcontainer.model.aggregation;

import com.mobilemaestria.saas.appcontainer.model.BaseModel;
import com.mobilemaestria.saas.appcontainer.model.Client;
import com.mobilemaestria.saas.appcontainer.model.Invoice;
import com.mobilemaestria.saas.appcontainer.model.Provider;

import javax.persistence.*;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author Dmitri Carpov
 */
@Entity
@Table(name = "AGR_IMPORT_SUMMARY")
@NamedQueries({
        @NamedQuery(name = "ImportSummary.getByClientAndProviderAndPeriod", query = "" +
            "SELECT summary FROM ImportSummary summary " +
            "WHERE summary.client = :client AND summary.periodStart = :periodStart AND summary.periodEnd = :periodEnd " +
            "                               AND summary.provider = :provider " +
            "ORDER BY summary.createDate DESC")
})
public class ImportSummary extends BaseModel {    
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.DATE)
    private Date createDate;    
    @Column(name = "PERIOD_START")
    @Temporal(TemporalType.DATE)
    private Date periodStart;
    @Column(name = "PERIOD_END")
    @Temporal(TemporalType.DATE)
    private Date periodEnd;
    @Column(name = "AIRTIME_TOTAL_SECONDS")
    private Integer airtimeTotalUse;
    @Column(name = "AIRTIME_LD_CAN_SECONDS")
    private Integer airtimeLongDistanceCanadaUse;
    @Column(name = "AIRTIME_LD_US_SECONDS")
    private Integer airtimeLongDistanceUSUse;
    @Column(name = "AIRTIME_LD_OS_SECONDS")
    private Integer airtimeLongDistanceOthersUse;
    @Column(name = "AIRTIME_US_ROAMING_SECONDS")
    private Integer airtimeUSRoamingUse;
    @Column(name = "AIRTIME_OS_ROAMING_SECONDS")
    private Integer airtimeOthersRoamingUse;
    @Column(name = "AIRTIME_ROAMING_SECONDS")
    private Integer airtimeRoamingUse;
    @Column(name = "AIRTIME_US_ROAMING_CHARGE")
    private double airtimeUSRoamingCharge;
    @Column(name = "AIRTIME_OS_ROAMING_CHARGE")
    private double airtimeOthersRoamingCharge;
    @Column(name = "AIRTIME_ROAMING_CHARGE")
    private double airtimeRoamingCharge;
    @Column(name = "AIRTIME_TOTAL_CHARGE")
    private double airtimeTotalCharge;
    @Column(name = "AIRTIME_ADJUSTMENT_CHARGE")
    private double airtimeAdjustmentCharge;        
    @Column(name = "BUDGET")
    private double budget; 
    @Column(name = "DATA_US_ROAMING_USE_MB")
    private double dataUSRoamingUse;
    @Column(name = "DATA_OS_ROAMING_USE_MB")
    private double dataOthersRoamingUse;
    @Column(name = "DATA_ROAMING_USE_MB")
    private double dataRoamingUse;
    @Column(name = "DATA_TOTAL_USE_MB")
    private double dataTotalUse;
    @Column(name = "DATA_US_ROAMING_CHARGE")
    private double dataUSRoamingCharge;
    @Column(name = "DATA_OS_ROAMING_CHARGE")
    private double dataOthersRoamingCharge;
    @Column(name = "DATA_ROAMING_CHARGE")
    private double dataRoamingCharge;
    @Column(name = "DATA_TOTAL_CHARGE")
    private double dataTotalCharge;    
    @Column(name = "SMS_LOCAL_COUNT")
    private int smsLocalCount;
    @Column(name = "SMS_LOCAL_CHARGE")
    private double smsLocalCharge;
    @Column(name = "SMS_TOTAL_CHARGE")
    private double smsTotalCharge;        
    @Column(name = "TOTAL_CHARGE")
    private double totalCharge;
    @Column(name = "TOTAL_CHARGE_PLUS_FEE")
    private double totalChargePlusFee;
    @Column(name = "PHONE_NUMBERS_COUNT")
    private Integer phoneNumbersCount;  
    @Column(name = "SERVICE_PLAN_TOTAL_CHARGE")
    private double servicePlanTotalCharge;
    @Column(name = "MANAGEMENT_FEE")
    private double managementFee;
    @Column(name = "TOTAL_TAXES")
    private double totalTaxes;
    @Column(name = "EBS_PROCESS_LOG_UUID")
    private String ebsProcessLogUuid;
    
    // ---- Relations       
    
    @ManyToOne
    @JoinColumn(name="CLIENT_ID")
    private Client client;
    @ManyToOne
    @JoinColumn(name="PROVIDER_ID")
    private Provider provider;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "summary", cascade = CascadeType.ALL)
    private List<Invoice> invoices;

    @OneToMany(fetch=FetchType.EAGER, mappedBy = "summary", cascade = CascadeType.ALL)
    private List<AverageByDevice> averageByDevices;

    // ---- Comparators        
    public static class EndDateComparator implements Comparator<ImportSummary> {
        @Override
        public int compare(ImportSummary importSummary, ImportSummary importSummary1) {
            if (importSummary == null || importSummary1 == null) {
                return 0;
            }
            Date periodEnd = importSummary.periodEnd;
            Date periodEnd1 = importSummary1.periodEnd;

            if (periodEnd == null || periodEnd1 == null) {
                return 0;
            }

            return periodEnd.compareTo(periodEnd1);
        }
    }
    
    public static class EndDateDescComparator implements Comparator<ImportSummary> {
        @Override
        public int compare(ImportSummary importSummary, ImportSummary importSummary1) {
            if (importSummary == null || importSummary1 == null) {
                return 0;
            }
            Date periodEnd = importSummary.periodEnd;
            Date periodEnd1 = importSummary1.periodEnd;

            if (periodEnd == null || periodEnd1 == null) {
                return 0;
            }

            return periodEnd1.compareTo(periodEnd);
        }
    }

    // Generated Getters and Setters
    
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    public Date getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
    }

    public Integer getAirtimeTotalUse() {
        return airtimeTotalUse;
    }

    public void setAirtimeTotalUse(Integer airtimeTotalUse) {
        this.airtimeTotalUse = airtimeTotalUse;
    }

    public Integer getAirtimeLongDistanceCanadaUse() {
        return airtimeLongDistanceCanadaUse;
    }

    public void setAirtimeLongDistanceCanadaUse(Integer airtimeLongDistanceCanadaUse) {
        this.airtimeLongDistanceCanadaUse = airtimeLongDistanceCanadaUse;
    }

    public Integer getAirtimeLongDistanceUSUse() {
        return airtimeLongDistanceUSUse;
    }

    public void setAirtimeLongDistanceUSUse(Integer airtimeLongDistanceUSUse) {
        this.airtimeLongDistanceUSUse = airtimeLongDistanceUSUse;
    }

    public Integer getAirtimeLongDistanceOthersUse() {
        return airtimeLongDistanceOthersUse;
    }

    public void setAirtimeLongDistanceOthersUse(Integer airtimeLongDistanceOthersUse) {
        this.airtimeLongDistanceOthersUse = airtimeLongDistanceOthersUse;
    }

    public Integer getAirtimeUSRoamingUse() {
        return airtimeUSRoamingUse;
    }

    public void setAirtimeUSRoamingUse(Integer airtimeUSRoamingUse) {
        this.airtimeUSRoamingUse = airtimeUSRoamingUse;
    }

    public Integer getAirtimeOthersRoamingUse() {
        return airtimeOthersRoamingUse;
    }

    public void setAirtimeOthersRoamingUse(Integer airtimeOthersRoamingUse) {
        this.airtimeOthersRoamingUse = airtimeOthersRoamingUse;
    }

    public Integer getAirtimeRoamingUse() {
        return airtimeRoamingUse;
    }

    public void setAirtimeRoamingUse(Integer airtimeRoamingUse) {
        this.airtimeRoamingUse = airtimeRoamingUse;
    }

    public double getAirtimeUSRoamingCharge() {
        return airtimeUSRoamingCharge;
    }

    public void setAirtimeUSRoamingCharge(double airtimeUSRoamingCharge) {
        this.airtimeUSRoamingCharge = airtimeUSRoamingCharge;
    }

    public double getAirtimeOthersRoamingCharge() {
        return airtimeOthersRoamingCharge;
    }

    public void setAirtimeOthersRoamingCharge(double airtimeOthersRoamingCharge) {
        this.airtimeOthersRoamingCharge = airtimeOthersRoamingCharge;
    }

    public double getAirtimeRoamingCharge() {
        return airtimeRoamingCharge;
    }

    public void setAirtimeRoamingCharge(double airtimeRoamingCharge) {
        this.airtimeRoamingCharge = airtimeRoamingCharge;
    }

    public double getAirtimeTotalCharge() {
        return airtimeTotalCharge;
    }

    public void setAirtimeTotalCharge(double airtimeTotalCharge) {
        this.airtimeTotalCharge = airtimeTotalCharge;
    }

    public double getAirtimeAdjustmentCharge() {
        return airtimeAdjustmentCharge;
    }

    public void setAirtimeAdjustmentCharge(double airtimeAdjustmentCharge) {
        this.airtimeAdjustmentCharge = airtimeAdjustmentCharge;
    }

    public double getDataUSRoamingUse() {
        return dataUSRoamingUse;
    }

    public void setDataUSRoamingUse(double dataUSRoamingUse) {
        this.dataUSRoamingUse = dataUSRoamingUse;
    }

    public double getDataOthersRoamingUse() {
        return dataOthersRoamingUse;
    }

    public void setDataOthersRoamingUse(double dataOthersRoamingUse) {
        this.dataOthersRoamingUse = dataOthersRoamingUse;
    }

    public double getDataRoamingUse() {
        return dataRoamingUse;
    }

    public void setDataRoamingUse(double dataRoamingUse) {
        this.dataRoamingUse = dataRoamingUse;
    }

    public double getDataTotalUse() {
        return dataTotalUse;
    }

    public void setDataTotalUse(double dataTotalUse) {
        this.dataTotalUse = dataTotalUse;
    }

    public double getDataUSRoamingCharge() {
        return dataUSRoamingCharge;
    }

    public void setDataUSRoamingCharge(double dataUSRoamingCharge) {
        this.dataUSRoamingCharge = dataUSRoamingCharge;
    }

    public double getDataOthersRoamingCharge() {
        return dataOthersRoamingCharge;
    }

    public void setDataOthersRoamingCharge(double dataOthersRoamingCharge) {
        this.dataOthersRoamingCharge = dataOthersRoamingCharge;
    }

    public double getDataRoamingCharge() {
        return dataRoamingCharge;
    }

    public void setDataRoamingCharge(double dataRoamingCharge) {
        this.dataRoamingCharge = dataRoamingCharge;
    }

    public double getDataTotalCharge() {
        return dataTotalCharge;
    }

    public void setDataTotalCharge(double dataTotalCharge) {
        this.dataTotalCharge = dataTotalCharge;
    }

    public int getSmsLocalCount() {
        return smsLocalCount;
    }

    public void setSmsLocalCount(int smsLocalCount) {
        this.smsLocalCount = smsLocalCount;
    }

    public double getSmsLocalCharge() {
        return smsLocalCharge;
    }

    public void setSmsLocalCharge(double smsLocalCharge) {
        this.smsLocalCharge = smsLocalCharge;
    }

    public double getSmsTotalCharge() {
        return smsTotalCharge;
    }

    public void setSmsTotalCharge(double smsTotalCharge) {
        this.smsTotalCharge = smsTotalCharge;
    }

    public double getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(double totalCharge) {
        this.totalCharge = totalCharge;
    }

    public double getServicePlanTotalCharge() {
        return servicePlanTotalCharge;
    }

    public void setServicePlanTotalCharge(double servicePlanTotalCharge) {
        this.servicePlanTotalCharge = servicePlanTotalCharge;
    }

    public double getManagementFee() {
        return managementFee;
    }

    public void setManagementFee(double managementFee) {
        this.managementFee = managementFee;
    }

    public double getTotalTaxes() {
        return totalTaxes;
    }

    public void setTotalTaxes(double totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public double getTotalChargePlusFee() {
        return totalChargePlusFee;
    }

    public void setTotalChargePlusFee(double totalChargePlusFee) {
        this.totalChargePlusFee = totalChargePlusFee;
    }

    public Integer getPhoneNumbersCount() {
        return phoneNumbersCount;
    }

    public void setPhoneNumbersCount(Integer phoneNumbersCount) {
        this.phoneNumbersCount = phoneNumbersCount;
    }

    public List<AverageByDevice> getAverageByDevices() {
        return averageByDevices;
    }

    public void setAverageByDevices(List<AverageByDevice> averageByDevices) {
        this.averageByDevices = averageByDevices;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getEbsProcessLogUuid() {
        return ebsProcessLogUuid;
    }

    public void setEbsProcessLogUuid(String ebsProcessLogUuid) {
        this.ebsProcessLogUuid = ebsProcessLogUuid;
    }
    
}
