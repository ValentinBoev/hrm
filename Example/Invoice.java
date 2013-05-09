package com.mobilemaestria.saas.appcontainer.model;

import com.mobilemaestria.saas.appcontainer.model.aggregation.ImportSummary;
import org.apache.commons.lang.StringUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Dmitri Carpov
 */
@Entity
@Table(name = "INVOICE")
@NamedQueries({
        @NamedQuery(name = "Invoice.getBySummary",
                query = "SELECT _invoice from Invoice _invoice WHERE _invoice.summary = :summary ORDER BY _invoice.invoiceDate, _invoice.invoiceNumber")
})
public class Invoice extends BaseModel {

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    @Column(name = "INVOICE_NUMBER")
    private String invoiceNumber;
    @Column(name = "INVOICE_DATE")
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "AIRTIME_CHARGE")
    private Double airtimeCharge;
    @Column(name = "SP_AVAILABLE_MINUTES")
    private Integer airtimeIncludedInMinutes;
    @Column(name = "AIRTIME_TOTAL_SECOND")
    private Integer airtimeTotalSecond;
    @Column(name = "AIR_CHARGE_ADJ_REINV")
    private Double airChargeAdjReinv;
    @Column(name = "ADJUSTMENT_POOL_CONSUMPTION")
    private Double adjutmentPoolConsumption;
    @Column(name = "LD_CHARGE")
    private Double ldCharge;
    @Column(name = "ROAMING_CHARGE")
    private Double roamingCharge;
    @Column(name = "DATA_CHARGE")
    private Double dataCharge;
    @Column(name = "DATA_ROAMING_CHARGE")
    private Double dataRoamingCharge;
    @Column(name = "FEATURE_CHARGE")
    private Double featureCharge;
    @Column(name = "SERVICE_PLAN_CHARGE")
    private Double servicePlanCharge;
    @Column(name = "TOTAL_TAXES")
    private Double totalTaxes;
    @Column(name = "TOTAL_CHARGE")
    private Double totalCharge;
    @Column(name = "LNK_INVOICE")
    private String lnkInvoice;
    @Column(name = "LNK_CLIENT")
    private String lnkClient;
    @Column(name = "LNK_PROVIDER")
    private String lnkProvider;
    @Column(name = "LNK_ACCOUNT")
    private String lnkAccount;
    @Column(name = "LNK_SERVICE_PLAN")
    private String lnkServicePlan;
    @Column(name = "LNK_INVENTORY")
    private String lnkInventory;
    @Column(name = "LNK_INVENTORY_OWNER")
    private String lnkInventoryOwner;
    @Column(name = "LNK_STATUS")
    private String lnkStatus;
    @Column(name = "LNK_INVENTORY_TYPE")
    private String lnkInventoryType;
    @Column(name = "LNK_MANAGER")
    private String lnkManager;
    @Column(name = "LNK_COST_CENTER")
    private String lnkCostCenter;
    @Column(name = "LNK_DIVISION")
    private String lnkDivision;
    @Column(name = "LNK_DEPARTMENT")
    private String lnkDepartment;
    @Column(name = "EMPLOYEE_NUMBER")
    private String employeeNumber;
    @Column(name = "ABREV_STATUS")
    private String abrevStatus;
    @Column(name = "GL_CODE")
    private String glCode;
    @Column(name = "DIV_NAME")
    private String divName;
    @Column(name = "DEP_NAME")
    private String depName;
    @Column(name = "CC_NAME")
    private String ccName;
    @Column(name = "MANAGER_NAME")
    private String managerName;
    @Column(name = "SP_CODE")
    private String spCode;
    @Column(name = "SP_DESCRIPTION")
    private String spDescription;
    @Column(name = "SP_AVAILABLE_MINUTE")
    private String spAvailableMinute;
    @Column(name = "SP_AVAILABLE_INC_MINUTE")
    private String spAvailableIncMinute;
    @Column(name = "SP_START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date spStartDate;
    @Column(name = "MODEL_NAME")
    private String modelName;
    @Column(name = "MODEL_DESC")
    private String modelDesc;
    @Column(name = "IMEI")
    private String imei;
    @Column(name = "MIA")
    private String mia;
    @Column(name = "PROVIDER_NAME")
    private String providerName;
    @Column(name = "POOL_NAME")
    private String poolName;
    @Column(name = "INVOICE_BILLING_NAME")
    private String invoiceBillingName;
    @Column(name = "INVOICE_DESC")
    private String invoiceDesc;
    @Column(name = "SMS_FEATURE_CHGS")
    private Double smsFeatureChgs;
    @Column(name = "VOICEMAIL_FEATURE_CHARGES")
    private Double voicemailFeatureCharges;
    @Column(name = "CALLERID_FEATURE_CHARGE")
    private Double calleridFeatureCharge;
    @Column(name = "PREMIUM_SERVICE_CHARGE")
    private Double premiumServiceCharge;
    @Column(name = "OTHER_FEATURE_CHARGE")
    private Double otherFeatureCharge;
    @Column(name = "DATA_FEATURE_CHARGE")
    private Double dataFeatureCharge;
    @Column(name = "TOTAL_MONTHLY_CHARGE")
    private Double totalMonthlyCharge;
    @Column(name = "LD_CAN_CHARGE")
    private Double ldCanCharge;
    @Column(name = "LD_US_CHARGE")
    private Double ldUsCharge;
    @Column(name = "LD_INTL_CHARGE")
    private Double ldIntlCharge;
    @Column(name = "TOTAL_LD_CHARGE")
    private Double totalLdCharge;
    @Column(name = "ROAMING_US_CHARGE")
    private Double roamingUsCharge;
    @Column(name = "ROAMING_INTL_CHARGE")
    private Double roamingIntlCharge;
    @Column(name = "ROAMING_LD_CHARGE")
    private Double roamingLdCharge;
    @Column(name = "ROAMING_SURCHARGE")
    private Double roamingSurcharge;
    @Column(name = "TOTAL_ROAMING_CHARGE")
    private Double totalRoamingCharge;
    @Column(name = "DATA_LOCAL_CHARGE")
    private Double dataLocalCharge;
    @Column(name = "DATA_US_ROAMING_CHARGE")
    private Double dataUsRoamingCharge;
    @Column(name = "DATA_OS_ROAMING_CHARGE")
    private Double dataOsRoamingCharge;
    @Column(name = "TOTAL_DATA_CHARGE")
    private Double totalDataCharge;
    @Column(name = "TOTAL_USAGE_CHARGE")
    private Double totalUsageCharge;
    @Column(name = "EQUIPMENT_CHARGE")
    private Double equipmentCharge;
    @Column(name = "EQUIPMENT_DISCOUNT")
    private Double equipmentDiscount;
    @Column(name = "NETWORK_AND_ACCESS_FEE")
    private Double networkAndAccessFee;
    @Column(name = "FEE_911")
    private Double fee911;
    @Column(name = "OTHER_CHARGE_AND_CREDIT")
    private Double otherChargeAndCredit;
    @Column(name = "CREDIT")
    private Double credit;
    @Column(name = "ACTIVATION_FEE")
    private Double activationFee;
    @Column(name = "EARLY_CANCELLATION_FEE")
    private Double earlyCancelationFee;
    @Column(name = "ADJUSTMENT")
    private String adjustement;
    @Column(name = "TOTAL_DISCOUNT")
    private Double totalDiscount;
    @Column(name = "CREDIT_MANUEL_REFACT")
    private String cerditManuelRefact;
    @Column(name = "TAX1_NAME")
    private String tax1Name;
    @Column(name = "TAX1_CODE")
    private String tax1Code;
    @Column(name = "TAX1_RECUP")
    private Double tax1Recup;
    @Column(name = "TAX1_TOTAL")
    private Double tax1Total;
    @Column(name = "TAX2_NAME")
    private String tax2Name;
    @Column(name = "TAX2_CODE")
    private String tax2Code;
    @Column(name = "TAX2_RECUP")
    private Double tax2Recup;
    @Column(name = "TAX2_TOTAL")
    private Double tax2Total;
    @Column(name = "TAX3_NAME")
    private String tax3Name;
    @Column(name = "TAX3_CODE")
    private String tax3Code;
    @Column(name = "TAX3_RECUP")
    private Double tax3Recup;
    @Column(name = "TAX3_TOTAL")
    private Double tax3Total;
    @Column(name = "TAX4_NAME")
    private String tax4Name;
    @Column(name = "TAX4_CODE")
    private String tax4Code;
    @Column(name = "TAX4_RECUP")
    private Double tax4Recup;
    @Column(name = "TAX4_TOTAL")
    private Double tax4Total;
    @Column(name = "TAX5_NAME")
    private String tax5Name;
    @Column(name = "TAX5_CODE")
    private String tax5Code;
    @Column(name = "TAX5_RECUP")
    private Double tax5Recup;
    @Column(name = "TAX5_TOTAL")
    private Double tax5Total;
    @Column(name = "TAX6_NAME")
    private String tax6Name;
    @Column(name = "TAX6_CODE")
    private String tax6Code;
    @Column(name = "TAX6_RECUP")
    private Double tax6Recup;
    @Column(name = "TAX6_TOTAL")
    private Double tax6Total;
    @Column(name = "TAX7_NAME")
    private String tax7Name;
    @Column(name = "TAX7_CODE")
    private String tax7Code;
    @Column(name = "TAX7_RECUP")
    private Double tax7Recup;
    @Column(name = "TAX7_TOTAL")
    private Double tax7Total;
    @Column(name = "TAX8_NAME")
    private String tax8Name;
    @Column(name = "TAX8_CODE")
    private String tax8Code;
    @Column(name = "TAX8_RECUP")
    private Double tax8Recup;
    @Column(name = "TAX8_TOTAL")
    private Double tax8Total;
    @Column(name = "TAX9_NAME")
    private String tax9Name;
    @Column(name = "TAX9_CODE")
    private String tax9Code;
    @Column(name = "TAX9_RECUP")
    private Double tax9Recup;
    @Column(name = "TAX9_TOTAL")
    private Double tax9Total;
    @Column(name = "TAX10_NAME")
    private String tax10Name;
    @Column(name = "TAX10_CODE")
    private String tax10Code;
    @Column(name = "TAX10_RECUP")
    private Double tax10Recup;
    @Column(name = "TAX10_TOTAL")
    private Double tax10Total;
    @Column(name = "OTHER_TAX_CODE")
    private String otherTaxCode;
    @Column(name = "OTHER_TAX_RECUP")
    private Double otherTaxRecup;
    @Column(name = "OTHER_TAX_TOTAL")
    private Double otherTaxTotal;
    @Column(name = "TOTAL_BEFORE_TAXES")
    private String totalBeforeTaxes;
    @Column(name = "MANAGEMENT_FEE")
    private Double managementFee;
    @Column(name = "TOTAL_CHARGE_PLUS_FEE")
    private Double totalChargePlusFee;
    @Column(name = "WIFI_USAGE")
    private String wifiUsage;
    @Column(name = "WIFI_CHARGE")
    private Double wifiCharge;
    @Column(name = "DIR_ASSIST_CHARGE")
    private Double dirAssistCharge;
    @Column(name = "DIR_ASSIST_COUNT")
    private String dirAssistCount;
    @Column(name = "SMS_LOCAL_IN_COUNT")
    private Integer smsLocalInCount;
    @Column(name = "SMS_LOCAL_IN_CHARGE")
    private Double smsLocalInCharge;
    @Column(name = "SMS_LOCAL_SENT_COUNT")
    private Integer smsLocalSentCount;
    @Column(name = "SMS_LOCAL_SENT_CHARGE")
    private Double smsLocalSentCharge;
    @Column(name = "SMS_LOCAL_TOTAL_COUNT")
    private Integer smsLocalTotalCount;
    @Column(name = "SMS_LOCAL_CHARGE")
    private Double smsLocalCharge;
    @Column(name = "SMS_ROAMING_IN_COUNT")
    private Integer smsRoamingInCount;
    @Column(name = "SMS_ROAMING_IN_CHARGE")
    private Double smsRoamingInCharge;
    @Column(name = "SMS_ROAMING_SENT_COUNT")
    private Integer smsRoamingSentCount;
    @Column(name = "SMS_ROAMING_TOTAL_COUNT")
    private Integer smsRoamingTotalCount;
    @Column(name = "SMS_ROAMING_SENT_CHARGE")
    private Double smsRoamingSentCharge;
    @Column(name = "SMS_ROAMING_CHARGE")
    private Double smsRoaminCharge;
    @Column(name = "SMS_TOTAL_COUNT")
    private Integer smsTotalCount;
    @Column(name = "SMS_TOTAL_CHARGE")
    private Double smsTotalCharge;
    @Column(name = "EVENT_COUNT")
    private Integer eventCount;
    @Column(name = "EVENT_CHARGE")
    private Double eventCharge;
    @Column(name = "BROWSING_SECOND")
    private String browsingSecong;
    @Column(name = "BROWSING_CHARGE")
    private Double browsingCharge;
    @Column(name = "WIFI_COUNT")
    private String wifiCount;
    @Column(name = "DATA_MB_LOCAL")
    private String dataMbLocal;
    @Column(name = "DATA_MB_US_ROAMING")
    private String dataqMbUsRoaming;
    @Column(name = "DATA_MB_OS_ROAMING")
    private String dataMbOsRoaming;
    @Column(name = "DATA_MB_ROAMING")
    private String dataMbRoaming;
    @Column(name = "TOTAL_DATA_MB")
    private Double totalDataMb;
    @Column(name = "OVER_CONSUMPTION_MB")
    private String overConsumptionMb;
    @Column(name = "OVER_CONSUMPTION_MINUTE")
    private String overConsumptionMinute;
    @Column(name = "SERVICE_PLAN_CHARGE_REINV")
    private String servicePlanChargeReinv;
    @Column(name = "DATA_CHARGE_ADJ_REINV")
    private String dataChargeAdjReinv;
    @Column(name = "TOTAL_CHARGE_ADJ_REINV")
    private String totalChargeAdjReinv;
    @Column(name = "AIRTIME_CHARGED_TOTAL_SECOND")
    private Integer airtimeChargedTotalSecond;
    @Column(name = "AIRTIME_INCOMING_DAY_SECOND")
    private Integer airtimeIncomingDaySecond;
    @Column(name = "AIRTIME_INCOMING_EV_SECOND")
    private Integer airtimeIncomingEvSecond;
    @Column(name = "AIRTIME_INCOMING_WE_SECOND")
    private Integer airtimeIncomingWeSecond;
    @Column(name = "AIRTIME_INCOMING_TOTAL_SECOND")
    private Integer airtimeIncomingTotalSecond;
    @Column(name = "AIRTIME_DAY_SECOND")
    private Integer airtimeDaySecond;
    @Column(name = "AIRTIME_EVENING_SECOND")
    private Integer airtimeEveningSecond;
    @Column(name = "AIRTIME_WEEKEND_SECOND")
    private Integer airtimeWeekendSecond;
    @Column(name = "AIRTIME_CIE_CALL_DAY_SECOND")
    private Integer airtimeCieCallDaySecond;
    @Column(name = "AIRTIME_CIE_CALL_EV_SECOND")
    private Integer airtimeCieCallEcSecond;
    @Column(name = "AIRTIME_CIE_CALL_WE_SECOND")
    private Integer airtimeCieCallWeSecond;
    @Column(name = "AIRTIME_CIE_CALL_TOTAL_SECOND")
    private Integer airtimeCieCallTotalSecond;
    @Column(name = "AIRTIME_M2M_DAY_SECOND")
    private Integer airtimeM2mDaySecond;
    @Column(name = "AIRTIME_M2M_EV_SECOND")
    private Integer airtimeM2mEvSecond;
    @Column(name = "AIRTIME_M2M_WE_SECOND")
    private Integer airtimeM2mWeSecond;
    @Column(name = "AIRTIME_M2M_TOTAL_SECOND")
    private Integer airtimeM2mTotalSecond;
    @Column(name = "AIRTIME_US_ROAMING_SECOND")
    private Integer airtimeUsRoamingSecond;
    @Column(name = "AIRTIME_OS_ROAMING_SECOND")
    private Integer airtimeOsRoamingSecond;
    @Column(name = "AIRTIME_ROAMING_SECOND")
    private Integer airtimeRoamingSecond;
    @Column(name = "AIRTIME_ROAMING_LD_SECOND")
    private Integer airtimeRoamingLdSecond;
    @Column(name = "AIRTIME_LD_CAN_SECOND")
    private Integer airtimeLdCanSecond;
    @Column(name = "AIRTIME_LD_US_SECOND")
    private Integer airtimeLdUsSecond;
    @Column(name = "AIRTIME_LD_OS_SECOND")
    private Integer airtimeLdOsSecond;
    @Column(name = "AIRTIME_LD_PEAK_SECOND")
    private Integer airtimeLdPeakSecond;
    @Column(name = "AIRTIME_LD_OFFPEAK_SECOND")
    private Integer airtimeLdOffpeakSecond;
    @Column(name = "AIRTIME_PTT_PRIVATE")
    private String airtimePttPrivate;
    @Column(name = "PTT_PRIVATE_CHARGE")
    private String pttPrivateCharge;
    @Column(name = "AIRTIME_PTT_GROUP")
    private String airtimePttGroup;
    @Column(name = "PTT_GROUP_CHARGE")
    private String pttGroupCharge;
    @Column(name = "AIRTIME_PTT_ROAMING")
    private String airtimePttRoaming;
    @Column(name = "PTT_ROAMING_CHARGE")
    private String pttRoamingCharge;
    @Column(name = "TRANSACTION_NUMBER")
    private String transactionNumber;
    @Column(name = "IS_MANUEL_ENTRY")
    private String isManuelEntry;
    @Column(name = "LAST_ACTIVITY_DATE")
    private String lastActivityDate;
    @Column(name = "IS_LAST_INVOICE")
    private String isLastInvoice;
    @Column(name = "IS_TAX_MANUEL_REFACT")
    private String isTaxManuelRefact;
    @Column(name = "US_EXCHANGE_RATE")
    private String usExchangeRate;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "MODIFIED_LAST_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedLastDate;
    @Column(name = "ID_LOAD")
    private String idLoad;

    @ManyToOne
    @JoinColumn(name = "SUMMARY_ID")
    private ImportSummary summary;
    @ManyToOne
    @JoinColumn(name = "PROVIDER_ID")
    private Provider provider;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<CallDetail> voiceDetails;

    public String getFullName() {
        StringBuilder fullName = new StringBuilder();
        if (StringUtils.isNotBlank(getFirstName())) {
            fullName.append(getFirstName());
        }

        if (StringUtils.isNotBlank(getLastName())) {
            if (StringUtils.isNotBlank(fullName.toString())) {
                fullName.append(" ");
            }

            fullName.append(getLastName());
        }

        return fullName.toString();
    }

    // Generated Getters and Setters

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getAirtimeCharge() {
        return airtimeCharge;
    }

    public void setAirtimeCharge(Double airtimeCharge) {
        this.airtimeCharge = airtimeCharge;
    }

    public Integer getAirtimeIncludedInMinutes() {
        return airtimeIncludedInMinutes;
    }

    public void setAirtimeIncludedInMinutes(Integer airtimeIncludedInMinutes) {
        this.airtimeIncludedInMinutes = airtimeIncludedInMinutes;
    }

    public Integer getAirtimeTotalSecond() {
        return airtimeTotalSecond;
    }

    public void setAirtimeTotalSecond(Integer airtimeTotalSecond) {
        this.airtimeTotalSecond = airtimeTotalSecond;
    }

    public Double getAirtimeAdjustment() {
        return airChargeAdjReinv;
    }

    public void setAirtimeAdjustment(Double airtimeAdjustment) {
        this.airChargeAdjReinv = airtimeAdjustment;
    }

    public Double getAdjutmentPoolConsumption() {
        return adjutmentPoolConsumption;
    }

    public void setAdjutmentPoolConsumption(Double adjutmentPool) {
        this.adjutmentPoolConsumption = adjutmentPool;
    }

    public Double getLdCharge() {
        return ldCharge;
    }

    public void setLdCharge(Double ldCharge) {
        this.ldCharge = ldCharge;
    }

    public Double getRoamingCharge() {
        return roamingCharge;
    }

    public void setRoamingCharge(Double roamingCharge) {
        this.roamingCharge = roamingCharge;
    }

    public Double getDataCharge() {
        return dataCharge;
    }

    public void setDataCharge(Double dataCharge) {
        this.dataCharge = dataCharge;
    }

    public Double getDataRoamingCharge() {
        return dataRoamingCharge;
    }

    public void setDataRoamingCharge(Double dataRoamingCharge) {
        this.dataRoamingCharge = dataRoamingCharge;
    }

    public Double getServicePlanCharge() {
        return servicePlanCharge;
    }

    public void setServicePlanCharge(Double servicePlanCharge) {
        this.servicePlanCharge = servicePlanCharge;
    }

    public Double getTotalTaxes() {
        return totalTaxes;
    }

    public void setTotalTaxes(Double totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    public Double getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(Double totalCharge) {
        this.totalCharge = totalCharge;
    }

    public ImportSummary getSummary() {
        return summary;
    }

    public void setSummary(ImportSummary summary) {
        this.summary = summary;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<CallDetail> getVoiceDetails() {
        return voiceDetails;
    }

    public void setVoiceDetails(List<CallDetail> voiceDetails) {
        this.voiceDetails = voiceDetails;
    }










    public String getLnkInvoice() {
        return lnkInvoice;
    }

    public void setLnkInvoice(String lnkInvoice) {
        this.lnkInvoice = lnkInvoice;
    }

    public String getLnkClient() {
        return lnkClient;
    }

    public void setLnkClient(String lnkClient) {
        this.lnkClient = lnkClient;
    }

    public String getLnkProvider() {
        return lnkProvider;
    }

    public void setLnkProvider(String lnkProvider) {
        this.lnkProvider = lnkProvider;
    }

    public String getLnkAccount() {
        return lnkAccount;
    }

    public void setLnkAccount(String lnkAccount) {
        this.lnkAccount = lnkAccount;
    }

    public String getLnkServicePlan() {
        return lnkServicePlan;
    }

    public void setLnkServicePlan(String lnkServicePlan) {
        this.lnkServicePlan = lnkServicePlan;
    }

    public String getLnkInventory() {
        return lnkInventory;
    }

    public void setLnkInventory(String lnkInventory) {
        this.lnkInventory = lnkInventory;
    }

    public String getLnkInventoryOwner() {
        return lnkInventoryOwner;
    }

    public void setLnkInventoryOwner(String lnkInventoryOwner) {
        this.lnkInventoryOwner = lnkInventoryOwner;
    }

    public String getLnkStatus() {
        return lnkStatus;
    }

    public void setLnkStatus(String lnkStatus) {
        this.lnkStatus = lnkStatus;
    }

    public String getLnkInventoryType() {
        return lnkInventoryType;
    }

    public void setLnkInventoryType(String lnkInventoryType) {
        this.lnkInventoryType = lnkInventoryType;
    }

    public String getLnkManager() {
        return lnkManager;
    }

    public void setLnkManager(String lnkManager) {
        this.lnkManager = lnkManager;
    }

    public String getLnkCostCenter() {
        return lnkCostCenter;
    }

    public void setLnkCostCenter(String lnkCostCenter) {
        this.lnkCostCenter = lnkCostCenter;
    }

    public String getLnkDivision() {
        return lnkDivision;
    }

    public void setLnkDivision(String lnkDivision) {
        this.lnkDivision = lnkDivision;
    }

    public String getLnkDepartment() {
        return lnkDepartment;
    }

    public void setLnkDepartment(String lnkDepartment) {
        this.lnkDepartment = lnkDepartment;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getAbrevStatus() {
        return abrevStatus;
    }

    public void setAbrevStatus(String abrevStatus) {
        this.abrevStatus = abrevStatus;
    }

    public String getGlCode() {
        return glCode;
    }

    public void setGlCode(String glCode) {
        this.glCode = glCode;
    }

    public String getDivName() {
        return divName;
    }

    public void setDivName(String divName) {
        this.divName = divName;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getCcName() {
        return ccName;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getSpCode() {
        return spCode;
    }

    public void setSpCode(String spCode) {
        this.spCode = spCode;
    }

    public String getSpDescription() {
        return spDescription;
    }

    public void setSpDescription(String spDescription) {
        this.spDescription = spDescription;
    }

    public String getSpAvailableMinute() {
        return spAvailableMinute;
    }

    public void setSpAvailableMinute(String spAvailableMinute) {
        this.spAvailableMinute = spAvailableMinute;
    }

    public String getSpAvailableIncMinute() {
        return spAvailableIncMinute;
    }

    public void setSpAvailableIncMinute(String spAvailableIncMinute) {
        this.spAvailableIncMinute = spAvailableIncMinute;
    }

    public Date getSpStartDate() {
        return spStartDate;
    }

    public void setSpStartDate(Date spStartDate) {
        this.spStartDate = spStartDate;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelDesc() {
        return modelDesc;
    }

    public void setModelDesc(String modelDesc) {
        this.modelDesc = modelDesc;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMia() {
        return mia;
    }

    public void setMia(String mia) {
        this.mia = mia;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public String getInvoiceBillingName() {
        return invoiceBillingName;
    }

    public void setInvoiceBillingName(String invoiceBillingName) {
        this.invoiceBillingName = invoiceBillingName;
    }

    public String getInvoiceDesc() {
        return invoiceDesc;
    }

    public void setInvoiceDesc(String invoiceDesc) {
        this.invoiceDesc = invoiceDesc;
    }

    public Double getSmsFeatureChgs() {
        return smsFeatureChgs;
    }

    public void setSmsFeatureChgs(Double smsFeatureChgs) {
        this.smsFeatureChgs = smsFeatureChgs;
    }

    public Double getVoicemailFeatureCharges() {
        return voicemailFeatureCharges;
    }

    public void setVoicemailFeatureCharges(Double voicemailFeatureCharges) {
        this.voicemailFeatureCharges = voicemailFeatureCharges;
    }

    public Double getCalleridFeatureCharge() {
        return calleridFeatureCharge;
    }

    public void setCalleridFeatureCharge(Double calleridFeatureCharge) {
        this.calleridFeatureCharge = calleridFeatureCharge;
    }

    public Double getPremiumServiceCharge() {
        return premiumServiceCharge;
    }

    public void setPremiumServiceCharge(Double premiumServiceCharge) {
        this.premiumServiceCharge = premiumServiceCharge;
    }

    public Double getOtherFeatureCharge() {
        return otherFeatureCharge;
    }

    public void setOtherFeatureCharge(Double otherFeatureCharge) {
        this.otherFeatureCharge = otherFeatureCharge;
    }

    public Double getDataFeatureCharge() {
        return dataFeatureCharge;
    }

    public void setDataFeatureCharge(Double dataFeatureCharge) {
        this.dataFeatureCharge = dataFeatureCharge;
    }

    public Double getFeatureCharge() {
        return featureCharge;
    }

    public void setFeatureCharge(Double featureCharge) {
        this.featureCharge = featureCharge;
    }

    public Double getTotalMonthlyCharge() {
        return totalMonthlyCharge;
    }

    public void setTotalMonthlyCharge(Double totalMonthlyCharge) {
        this.totalMonthlyCharge = totalMonthlyCharge;
    }

    public Double getLdCanCharge() {
        return ldCanCharge;
    }

    public void setLdCanCharge(Double ldCanCharge) {
        this.ldCanCharge = ldCanCharge;
    }

    public Double getLdUsCharge() {
        return ldUsCharge;
    }

    public void setLdUsCharge(Double ldUsCharge) {
        this.ldUsCharge = ldUsCharge;
    }

    public Double getLdIntlCharge() {
        return ldIntlCharge;
    }

    public void setLdIntlCharge(Double ldIntlCharge) {
        this.ldIntlCharge = ldIntlCharge;
    }

    public Double getTotalLdCharge() {
        return totalLdCharge;
    }

    public void setTotalLdCharge(Double totalLdCharge) {
        this.totalLdCharge = totalLdCharge;
    }

    public Double getRoamingUsCharge() {
        return roamingUsCharge;
    }

    public void setRoamingUsCharge(Double roamingUsCharge) {
        this.roamingUsCharge = roamingUsCharge;
    }

    public Double getRoamingIntlCharge() {
        return roamingIntlCharge;
    }

    public void setRoamingIntlCharge(Double roamingIntlCharge) {
        this.roamingIntlCharge = roamingIntlCharge;
    }

    public Double getRoamingLdCharge() {
        return roamingLdCharge;
    }

    public void setRoamingLdCharge(Double roamingLdCharge) {
        this.roamingLdCharge = roamingLdCharge;
    }

    public Double getRoamingSurcharge() {
        return roamingSurcharge;
    }

    public void setRoamingSurcharge(Double roamingSurcharge) {
        this.roamingSurcharge = roamingSurcharge;
    }

    public Double getTotalRoamingCharge() {
        return totalRoamingCharge;
    }

    public void setTotalRoamingCharge(Double totalRoamingCharge) {
        this.totalRoamingCharge = totalRoamingCharge;
    }

    public Double getDataLocalCharge() {
        return dataLocalCharge;
    }

    public void setDataLocalCharge(Double dataLocalCharge) {
        this.dataLocalCharge = dataLocalCharge;
    }

    public Double getDataUsRoamingCharge() {
        return dataUsRoamingCharge;
    }

    public void setDataUsRoamingCharge(Double dataUsRoamingCharge) {
        this.dataUsRoamingCharge = dataUsRoamingCharge;
    }

    public Double getDataOsRoamingCharge() {
        return dataOsRoamingCharge;
    }

    public void setDataOsRoamingCharge(Double dataOsRoamingCharge) {
        this.dataOsRoamingCharge = dataOsRoamingCharge;
    }

    public Double getTotalDataCharge() {
        return totalDataCharge;
    }

    public void setTotalDataCharge(Double totalDataCharge) {
        this.totalDataCharge = totalDataCharge;
    }

    public Double getTotalUsageCharge() {
        return totalUsageCharge;
    }

    public void setTotalUsageCharge(Double totalUsageCharge) {
        this.totalUsageCharge = totalUsageCharge;
    }

    public Double getEquipmentCharge() {
        return equipmentCharge;
    }

    public void setEquipmentCharge(Double equipmentCharge) {
        this.equipmentCharge = equipmentCharge;
    }

    public Double getEquipmentDiscount() {
        return equipmentDiscount;
    }

    public void setEquipmentDiscount(Double equipmentDiscount) {
        this.equipmentDiscount = equipmentDiscount;
    }

    public Double getNetworkAndAccessFee() {
        return networkAndAccessFee;
    }

    public void setNetworkAndAccessFee(Double networkAndAccessFee) {
        this.networkAndAccessFee = networkAndAccessFee;
    }

    public Double getFee911() {
        return fee911;
    }

    public void setFee911(Double fee911) {
        this.fee911 = fee911;
    }

    public Double getOtherChargeAndCredit() {
        return otherChargeAndCredit;
    }

    public void setOtherChargeAndCredit(Double otherChargeAndCredit) {
        this.otherChargeAndCredit = otherChargeAndCredit;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getActivationFee() {
        return activationFee;
    }

    public void setActivationFee(Double activationFee) {
        this.activationFee = activationFee;
    }

    public Double getEarlyCancelationFee() {
        return earlyCancelationFee;
    }

    public void setEarlyCancelationFee(Double earlyCancelationFee) {
        this.earlyCancelationFee = earlyCancelationFee;
    }

    public String getAdjustement() {
        return adjustement;
    }

    public void setAdjustement(String adjustement) {
        this.adjustement = adjustement;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public String getCerditManuelRefact() {
        return cerditManuelRefact;
    }

    public void setCerditManuelRefact(String cerditManuelRefact) {
        this.cerditManuelRefact = cerditManuelRefact;
    }

    public String getTax1Name() {
        return tax1Name;
    }

    public void setTax1Name(String tax1Name) {
        this.tax1Name = tax1Name;
    }

    public String getTax1Code() {
        return tax1Code;
    }

    public void setTax1Code(String tax1Code) {
        this.tax1Code = tax1Code;
    }

    public Double getTax1Recup() {
        return tax1Recup;
    }

    public void setTax1Recup(Double tax1Recup) {
        this.tax1Recup = tax1Recup;
    }

    public Double getTax1Total() {
        return tax1Total;
    }

    public void setTax1Total(Double tax1Total) {
        this.tax1Total = tax1Total;
    }

    public String getTax2Name() {
        return tax2Name;
    }

    public void setTax2Name(String tax2Name) {
        this.tax2Name = tax2Name;
    }

    public String getTax2Code() {
        return tax2Code;
    }

    public void setTax2Code(String tax2Code) {
        this.tax2Code = tax2Code;
    }

    public Double getTax2Recup() {
        return tax2Recup;
    }

    public void setTax2Recup(Double tax2Recup) {
        this.tax2Recup = tax2Recup;
    }

    public Double getTax2Total() {
        return tax2Total;
    }

    public void setTax2Total(Double tax2Total) {
        this.tax2Total = tax2Total;
    }

    public String getTax3Name() {
        return tax3Name;
    }

    public void setTax3Name(String tax3Name) {
        this.tax3Name = tax3Name;
    }

    public String getTax3Code() {
        return tax3Code;
    }

    public void setTax3Code(String tax3Code) {
        this.tax3Code = tax3Code;
    }

    public Double getTax3Recup() {
        return tax3Recup;
    }

    public void setTax3Recup(Double tax3Recup) {
        this.tax3Recup = tax3Recup;
    }

    public Double getTax3Total() {
        return tax3Total;
    }

    public void setTax3Total(Double tax3Total) {
        this.tax3Total = tax3Total;
    }

    public String getTax4Name() {
        return tax4Name;
    }

    public void setTax4Name(String tax4Name) {
        this.tax4Name = tax4Name;
    }

    public String getTax4Code() {
        return tax4Code;
    }

    public void setTax4Code(String tax4Code) {
        this.tax4Code = tax4Code;
    }

    public Double getTax4Recup() {
        return tax4Recup;
    }

    public void setTax4Recup(Double tax4Recup) {
        this.tax4Recup = tax4Recup;
    }

    public Double getTax4Total() {
        return tax4Total;
    }

    public void setTax4Total(Double tax4Total) {
        this.tax4Total = tax4Total;
    }

    public String getTax5Name() {
        return tax5Name;
    }

    public void setTax5Name(String tax5Name) {
        this.tax5Name = tax5Name;
    }

    public String getTax5Code() {
        return tax5Code;
    }

    public void setTax5Code(String tax5Code) {
        this.tax5Code = tax5Code;
    }

    public Double getTax5Recup() {
        return tax5Recup;
    }

    public void setTax5Recup(Double tax5Recup) {
        this.tax5Recup = tax5Recup;
    }

    public Double getTax5Total() {
        return tax5Total;
    }

    public void setTax5Total(Double tax5Total) {
        this.tax5Total = tax5Total;
    }

    public String getTax6Name() {
        return tax6Name;
    }

    public void setTax6Name(String tax6Name) {
        this.tax6Name = tax6Name;
    }

    public String getTax6Code() {
        return tax6Code;
    }

    public void setTax6Code(String tax6Code) {
        this.tax6Code = tax6Code;
    }

    public Double getTax6Recup() {
        return tax6Recup;
    }

    public void setTax6Recup(Double tax6Recup) {
        this.tax6Recup = tax6Recup;
    }

    public Double getTax6Total() {
        return tax6Total;
    }

    public void setTax6Total(Double tax6Total) {
        this.tax6Total = tax6Total;
    }

    public String getTax7Name() {
        return tax7Name;
    }

    public void setTax7Name(String tax7Name) {
        this.tax7Name = tax7Name;
    }

    public String getTax7Code() {
        return tax7Code;
    }

    public void setTax7Code(String tax7Code) {
        this.tax7Code = tax7Code;
    }

    public Double getTax7Recup() {
        return tax7Recup;
    }

    public void setTax7Recup(Double tax7Recup) {
        this.tax7Recup = tax7Recup;
    }

    public Double getTax7Total() {
        return tax7Total;
    }

    public void setTax7Total(Double tax7Total) {
        this.tax7Total = tax7Total;
    }

    public String getTax8Name() {
        return tax8Name;
    }

    public void setTax8Name(String tax8Name) {
        this.tax8Name = tax8Name;
    }

    public String getTax8Code() {
        return tax8Code;
    }

    public void setTax8Code(String tax8Code) {
        this.tax8Code = tax8Code;
    }

    public Double getTax8Recup() {
        return tax8Recup;
    }

    public void setTax8Recup(Double tax8Recup) {
        this.tax8Recup = tax8Recup;
    }

    public Double getTax8Total() {
        return tax8Total;
    }

    public void setTax8Total(Double tax8Total) {
        this.tax8Total = tax8Total;
    }

    public String getTax9Name() {
        return tax9Name;
    }

    public void setTax9Name(String tax9Name) {
        this.tax9Name = tax9Name;
    }

    public String getTax9Code() {
        return tax9Code;
    }

    public void setTax9Code(String tax9Code) {
        this.tax9Code = tax9Code;
    }

    public Double getTax9Recup() {
        return tax9Recup;
    }

    public void setTax9Recup(Double tax9Recup) {
        this.tax9Recup = tax9Recup;
    }

    public Double getTax9Total() {
        return tax9Total;
    }

    public void setTax9Total(Double tax9Total) {
        this.tax9Total = tax9Total;
    }

    public String getTax10Name() {
        return tax10Name;
    }

    public void setTax10Name(String tax10Name) {
        this.tax10Name = tax10Name;
    }

    public String getTax10Code() {
        return tax10Code;
    }

    public void setTax10Code(String tax10Code) {
        this.tax10Code = tax10Code;
    }

    public Double getTax10Recup() {
        return tax10Recup;
    }

    public void setTax10Recup(Double tax10Recup) {
        this.tax10Recup = tax10Recup;
    }

    public Double getTax10Total() {
        return tax10Total;
    }

    public void setTax10Total(Double tax10Total) {
        this.tax10Total = tax10Total;
    }

    public String getOtherTaxCode() {
        return otherTaxCode;
    }

    public void setOtherTaxCode(String otherTaxCode) {
        this.otherTaxCode = otherTaxCode;
    }

    public Double getOtherTaxRecup() {
        return otherTaxRecup;
    }

    public void setOtherTaxRecup(Double otherTaxRecup) {
        this.otherTaxRecup = otherTaxRecup;
    }

    public Double getOtherTaxTotal() {
        return otherTaxTotal;
    }

    public void setOtherTaxTotal(Double otherTaxTotal) {
        this.otherTaxTotal = otherTaxTotal;
    }

    public String getTotalBeforeTaxes() {
        return totalBeforeTaxes;
    }

    public void setTotalBeforeTaxes(String totalBeforeTaxes) {
        this.totalBeforeTaxes = totalBeforeTaxes;
    }

    public Double getManagementFee() {
        return managementFee;
    }

    public void setManagementFee(Double managementFee) {
        this.managementFee = managementFee;
    }

    public Double getTotalChargePlusFee() {
        return totalChargePlusFee;
    }

    public void setTotalChargePlusFee(Double totalChargePlusFee) {
        this.totalChargePlusFee = totalChargePlusFee;
    }

    public String getWifiUsage() {
        return wifiUsage;
    }

    public void setWifiUsage(String wifiUsage) {
        this.wifiUsage = wifiUsage;
    }

    public Double getWifiCharge() {
        return wifiCharge;
    }

    public void setWifiCharge(Double wifiCharge) {
        this.wifiCharge = wifiCharge;
    }

    public Double getDirAssistCharge() {
        return dirAssistCharge;
    }

    public void setDirAssistCharge(Double dirAssistCharge) {
        this.dirAssistCharge = dirAssistCharge;
    }

    public String getDirAssistCount() {
        return dirAssistCount;
    }

    public void setDirAssistCount(String dirAssistCount) {
        this.dirAssistCount = dirAssistCount;
    }

    public Integer getSmsLocalInCount() {
        return smsLocalInCount;
    }

    public void setSmsLocalInCount(Integer smsLocalInCount) {
        this.smsLocalInCount = smsLocalInCount;
    }

    public Double getSmsLocalInCharge() {
        return smsLocalInCharge;
    }

    public void setSmsLocalInCharge(Double smsLocalInCharge) {
        this.smsLocalInCharge = smsLocalInCharge;
    }

    public Integer getSmsLocalSentCount() {
        return smsLocalSentCount;
    }

    public void setSmsLocalSentCount(Integer smsLocalSentCount) {
        this.smsLocalSentCount = smsLocalSentCount;
    }

    public Double getSmsLocalSentCharge() {
        return smsLocalSentCharge;
    }

    public void setSmsLocalSentCharge(Double smsLocalSentCharge) {
        this.smsLocalSentCharge = smsLocalSentCharge;
    }

    public Integer getSmsLocalTotalCount() {
        return smsLocalTotalCount;
    }

    public void setSmsLocalTotalCount(Integer smsLocalTotalCount) {
        this.smsLocalTotalCount = smsLocalTotalCount;
    }

    public Double getSmsLocalCharge() {
        return smsLocalCharge;
    }

    public void setSmsLocalCharge(Double smsLocalCharge) {
        this.smsLocalCharge = smsLocalCharge;
    }

    public Integer getSmsRoamingInCount() {
        return smsRoamingInCount;
    }

    public void setSmsRoamingInCount(Integer smsRoamingInCount) {
        this.smsRoamingInCount = smsRoamingInCount;
    }

    public Double getSmsRoamingInCharge() {
        return smsRoamingInCharge;
    }

    public void setSmsRoamingInCharge(Double smsRoamingInCharge) {
        this.smsRoamingInCharge = smsRoamingInCharge;
    }

    public Integer getSmsRoamingSentCount() {
        return smsRoamingSentCount;
    }

    public void setSmsRoamingSentCount(Integer smsRoamingSentCount) {
        this.smsRoamingSentCount = smsRoamingSentCount;
    }

    public Integer getSmsRoamingTotalCount() {
        return smsRoamingTotalCount;
    }

    public void setSmsRoamingTotalCount(Integer smsRoamingTotalCount) {
        this.smsRoamingTotalCount = smsRoamingTotalCount;
    }

    public Double getSmsRoamingSentCharge() {
        return smsRoamingSentCharge;
    }

    public void setSmsRoamingSentCharge(Double smsRoamingSentCharge) {
        this.smsRoamingSentCharge = smsRoamingSentCharge;
    }

    public Double getSmsRoaminCharge() {
        return smsRoaminCharge;
    }

    public void setSmsRoaminCharge(Double smsRoaminCharge) {
        this.smsRoaminCharge = smsRoaminCharge;
    }

    public Integer getSmsTotalCount() {
        return smsTotalCount;
    }

    public void setSmsTotalCount(Integer smsTotalCount) {
        this.smsTotalCount = smsTotalCount;
    }

    public Double getSmsTotalCharge() {
        return smsTotalCharge;
    }

    public void setSmsTotalCharge(Double smsTotalCharge) {
        this.smsTotalCharge = smsTotalCharge;
    }

    public Integer getEventCount() {
        return eventCount;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

    public Double getEventCharge() {
        return eventCharge;
    }

    public void setEventCharge(Double eventCharge) {
        this.eventCharge = eventCharge;
    }

    public String getBrowsingSecong() {
        return browsingSecong;
    }

    public void setBrowsingSecong(String browsingSecong) {
        this.browsingSecong = browsingSecong;
    }

    public Double getBrowsingCharge() {
        return browsingCharge;
    }

    public void setBrowsingCharge(Double browsingCharge) {
        this.browsingCharge = browsingCharge;
    }

    public String getWifiCount() {
        return wifiCount;
    }

    public void setWifiCount(String wifiCount) {
        this.wifiCount = wifiCount;
    }

    public String getDataMbLocal() {
        return dataMbLocal;
    }

    public void setDataMbLocal(String dataMbLocal) {
        this.dataMbLocal = dataMbLocal;
    }

    public String getDataqMbUsRoaming() {
        return dataqMbUsRoaming;
    }

    public void setDataqMbUsRoaming(String dataqMbUsRoaming) {
        this.dataqMbUsRoaming = dataqMbUsRoaming;
    }

    public String getDataMbOsRoaming() {
        return dataMbOsRoaming;
    }

    public void setDataMbOsRoaming(String dataMbOsRoaming) {
        this.dataMbOsRoaming = dataMbOsRoaming;
    }

    public String getDataMbRoaming() {
        return dataMbRoaming;
    }

    public void setDataMbRoaming(String dataMbRoaming) {
        this.dataMbRoaming = dataMbRoaming;
    }

    public Double getTotalDataMb() {
        return totalDataMb;
    }

    public void setTotalDataMb(Double totalDataMb) {
        this.totalDataMb = totalDataMb;
    }

    public String getOverConsumptionMb() {
        return overConsumptionMb;
    }

    public void setOverConsumptionMb(String overConsumptionMb) {
        this.overConsumptionMb = overConsumptionMb;
    }

    public String getOverConsumptionMinute() {
        return overConsumptionMinute;
    }

    public void setOverConsumptionMinute(String overConsumptionMinute) {
        this.overConsumptionMinute = overConsumptionMinute;
    }

    public String getServicePlanChargeReinv() {
        return servicePlanChargeReinv;
    }

    public void setServicePlanChargeReinv(String servicePlanChargeReinv) {
        this.servicePlanChargeReinv = servicePlanChargeReinv;
    }

    public String getDataChargeAdjReinv() {
        return dataChargeAdjReinv;
    }

    public void setDataChargeAdjReinv(String dataChargeAdjReinv) {
        this.dataChargeAdjReinv = dataChargeAdjReinv;
    }

    public String getTotalChargeAdjReinv() {
        return totalChargeAdjReinv;
    }

    public void setTotalChargeAdjReinv(String totalChargeAdjReinv) {
        this.totalChargeAdjReinv = totalChargeAdjReinv;
    }

    public Integer getAirtimeChargedTotalSecond() {
        return airtimeChargedTotalSecond;
    }

    public void setAirtimeChargedTotalSecond(Integer airtimeChargedTotalSecond) {
        this.airtimeChargedTotalSecond = airtimeChargedTotalSecond;
    }

    public Integer getAirtimeIncomingDaySecond() {
        return airtimeIncomingDaySecond;
    }

    public void setAirtimeIncomingDaySecond(Integer airtimeIncomingDaySecond) {
        this.airtimeIncomingDaySecond = airtimeIncomingDaySecond;
    }

    public Integer getAirtimeIncomingEvSecond() {
        return airtimeIncomingEvSecond;
    }

    public void setAirtimeIncomingEvSecond(Integer airtimeIncomingEvSecond) {
        this.airtimeIncomingEvSecond = airtimeIncomingEvSecond;
    }

    public Integer getAirtimeIncomingWeSecond() {
        return airtimeIncomingWeSecond;
    }

    public void setAirtimeIncomingWeSecond(Integer airtimeIncomingWeSecond) {
        this.airtimeIncomingWeSecond = airtimeIncomingWeSecond;
    }

    public Integer getAirtimeIncomingTotalSecond() {
        return airtimeIncomingTotalSecond;
    }

    public void setAirtimeIncomingTotalSecond(Integer airtimeIncomingTotalSecond) {
        this.airtimeIncomingTotalSecond = airtimeIncomingTotalSecond;
    }

    public Integer getAirtimeDaySecond() {
        return airtimeDaySecond;
    }

    public void setAirtimeDaySecond(Integer airtimeDaySecond) {
        this.airtimeDaySecond = airtimeDaySecond;
    }

    public Integer getAirtimeEveningSecond() {
        return airtimeEveningSecond;
    }

    public void setAirtimeEveningSecond(Integer airtimeEveningSecond) {
        this.airtimeEveningSecond = airtimeEveningSecond;
    }

    public Integer getAirtimeWeekendSecond() {
        return airtimeWeekendSecond;
    }

    public void setAirtimeWeekendSecond(Integer airtimeWeekendSecond) {
        this.airtimeWeekendSecond = airtimeWeekendSecond;
    }

    public Integer getAirtimeCieCallDaySecond() {
        return airtimeCieCallDaySecond;
    }

    public void setAirtimeCieCallDaySecond(Integer airtimeCieCallDaySecond) {
        this.airtimeCieCallDaySecond = airtimeCieCallDaySecond;
    }

    public Integer getAirtimeCieCallEcSecond() {
        return airtimeCieCallEcSecond;
    }

    public void setAirtimeCieCallEcSecond(Integer airtimeCieCallEcSecond) {
        this.airtimeCieCallEcSecond = airtimeCieCallEcSecond;
    }

    public Integer getAirtimeCieCallWeSecond() {
        return airtimeCieCallWeSecond;
    }

    public void setAirtimeCieCallWeSecond(Integer airtimeCieCallWeSecond) {
        this.airtimeCieCallWeSecond = airtimeCieCallWeSecond;
    }

    public Integer getAirtimeCieCallTotalSecond() {
        return airtimeCieCallTotalSecond;
    }

    public void setAirtimeCieCallTotalSecond(Integer airtimeCieCallTotalSecond) {
        this.airtimeCieCallTotalSecond = airtimeCieCallTotalSecond;
    }

    public Integer getAirtimeM2mDaySecond() {
        return airtimeM2mDaySecond;
    }

    public void setAirtimeM2mDaySecond(Integer airtimeM2mDaySecond) {
        this.airtimeM2mDaySecond = airtimeM2mDaySecond;
    }

    public Integer getAirtimeM2mEvSecond() {
        return airtimeM2mEvSecond;
    }

    public void setAirtimeM2mEvSecond(Integer airtimeM2mEvSecond) {
        this.airtimeM2mEvSecond = airtimeM2mEvSecond;
    }

    public Integer getAirtimeM2mWeSecond() {
        return airtimeM2mWeSecond;
    }

    public void setAirtimeM2mWeSecond(Integer airtimeM2mWeSecond) {
        this.airtimeM2mWeSecond = airtimeM2mWeSecond;
    }

    public Integer getAirtimeM2mTotalSecond() {
        return airtimeM2mTotalSecond;
    }

    public void setAirtimeM2mTotalSecond(Integer airtimeM2mTotalSecond) {
        this.airtimeM2mTotalSecond = airtimeM2mTotalSecond;
    }

    public Integer getAirtimeUsRoamingSecond() {
        return airtimeUsRoamingSecond;
    }

    public void setAirtimeUsRoamingSecond(Integer airtimeUsRoamingSecond) {
        this.airtimeUsRoamingSecond = airtimeUsRoamingSecond;
    }

    public Integer getAirtimeOsRoamingSecond() {
        return airtimeOsRoamingSecond;
    }

    public void setAirtimeOsRoamingSecond(Integer airtimeOsRoamingSecond) {
        this.airtimeOsRoamingSecond = airtimeOsRoamingSecond;
    }

    public Integer getAirtimeRoamingSecond() {
        return airtimeRoamingSecond;
    }

    public void setAirtimeRoamingSecond(Integer airtimeRoamingSecond) {
        this.airtimeRoamingSecond = airtimeRoamingSecond;
    }

    public Integer getAirtimeRoamingLdSecond() {
        return airtimeRoamingLdSecond;
    }

    public void setAirtimeRoamingLdSecond(Integer airtimeRoamingLdSecond) {
        this.airtimeRoamingLdSecond = airtimeRoamingLdSecond;
    }

    public Integer getAirtimeLdCanSecond() {
        return airtimeLdCanSecond;
    }

    public void setAirtimeLdCanSecond(Integer airtimeLdCanSecond) {
        this.airtimeLdCanSecond = airtimeLdCanSecond;
    }

    public Integer getAirtimeLdUsSecond() {
        return airtimeLdUsSecond;
    }

    public void setAirtimeLdUsSecond(Integer airtimeLdUsSecond) {
        this.airtimeLdUsSecond = airtimeLdUsSecond;
    }

    public Integer getAirtimeLdOsSecond() {
        return airtimeLdOsSecond;
    }

    public void setAirtimeLdOsSecond(Integer airtimeLdOsSecond) {
        this.airtimeLdOsSecond = airtimeLdOsSecond;
    }

    public Integer getAirtimeLdPeakSecond() {
        return airtimeLdPeakSecond;
    }

    public void setAirtimeLdPeakSecond(Integer airtimeLdPeakSecond) {
        this.airtimeLdPeakSecond = airtimeLdPeakSecond;
    }

    public Integer getAirtimeLdOffpeakSecond() {
        return airtimeLdOffpeakSecond;
    }

    public void setAirtimeLdOffpeakSecond(Integer airtimeLdOffpeakSecond) {
        this.airtimeLdOffpeakSecond = airtimeLdOffpeakSecond;
    }

    public String getAirtimePttPrivate() {
        return airtimePttPrivate;
    }

    public void setAirtimePttPrivate(String airtimePttPrivate) {
        this.airtimePttPrivate = airtimePttPrivate;
    }

    public String getPttPrivateCharge() {
        return pttPrivateCharge;
    }

    public void setPttPrivateCharge(String pttPrivateCharge) {
        this.pttPrivateCharge = pttPrivateCharge;
    }

    public String getAirtimePttGroup() {
        return airtimePttGroup;
    }

    public void setAirtimePttGroup(String airtimePttGroup) {
        this.airtimePttGroup = airtimePttGroup;
    }

    public String getPttGroupCharge() {
        return pttGroupCharge;
    }

    public void setPttGroupCharge(String pttGroupCharge) {
        this.pttGroupCharge = pttGroupCharge;
    }

    public String getAirtimePttRoaming() {
        return airtimePttRoaming;
    }

    public void setAirtimePttRoaming(String airtimePttRoaming) {
        this.airtimePttRoaming = airtimePttRoaming;
    }

    public String getPttRoamingCharge() {
        return pttRoamingCharge;
    }

    public void setPttRoamingCharge(String pttRoamingCharge) {
        this.pttRoamingCharge = pttRoamingCharge;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getIsManuelEntry() {
        return isManuelEntry;
    }

    public void setIsManuelEntry(String isManuelEntry) {
        this.isManuelEntry = isManuelEntry;
    }

    public String getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(String lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public String getIsLastInvoice() {
        return isLastInvoice;
    }

    public void setIsLastInvoice(String isLastInvoice) {
        this.isLastInvoice = isLastInvoice;
    }

    public String getIsTaxManuelRefact() {
        return isTaxManuelRefact;
    }

    public void setIsTaxManuelRefact(String isTaxManuelRefact) {
        this.isTaxManuelRefact = isTaxManuelRefact;
    }

    public String getUsExchangeRate() {
        return usExchangeRate;
    }

    public void setUsExchangeRate(String usExchangeRate) {
        this.usExchangeRate = usExchangeRate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedLastDate() {
        return modifiedLastDate;
    }

    public void setModifiedLastDate(Date modifiedLastDate) {
        this.modifiedLastDate = modifiedLastDate;
    }

    public String getIdLoad() {
        return idLoad;
    }

    public void setIdLoad(String idLoad) {
        this.idLoad = idLoad;
    }




}
