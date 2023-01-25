package ctm.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Bill {

    private final Long id;
    private final String billingNumber;
    private final String billNumber;
    private final BigDecimal dueAmount;
    private final BigDecimal paidAmount;
    private final BigDecimal netAmount;
    private final Integer billStatusId;
    private final Integer billTypeId;
    private final String issueDate;
    private final String dueDate;
    private final String openDate;
    private final String closeDate;
    private final String expiryDate;
    private final String serviceType;
    private final Integer billerCode;
    private final Boolean allowPart;
    private final BigDecimal upperRangePmt;
    private final BigDecimal lowerRangePmt;
    private final String extras;
    private final boolean isInProfile;
    private final int feesType;
    private final BigDecimal madfoo3atFees;
    private final BigDecimal cBJFees;
    private final Integer corridorId;
    private final Integer billingId;
    private final BigDecimal totalFees;
    private final String billerEngName;
    private final String billerArcName;
    private final BigDecimal madfoo3atFeesPercent;
    private final BigDecimal cBJFeesPercent;
    private final String tableName;
    private final Long msgID;
    private final boolean isLocked;
    private final Integer errorCode;
    private final String errorDesc;
    private final Integer bankCode;
    private final BigDecimal dueAmountWithFees;
    private final Long billInquiryId;
    private final Integer participantTypeId;
    private final Integer participantCode;
    private final boolean isLockedNow;
    private final String inquiryCreatedDate;
    private final Integer billsCount;
    private final boolean enableAdditionalInfo;
    private final String custName;
    private final String freeText;
    private final Integer corridorFeesID;
    private final Integer currencyId;
    private final String currencyNameAr;
    private final String currencyNameEn;
    private final PayerInfo payerInfo;
    private final FeesDetails feesDetails;
    private final String customerName;

    @JsonCreator
    public Bill(@JsonProperty("Id") Long id, @JsonProperty("billingNumber") String billingNumber, @JsonProperty("billNumber") String billNumber,
            @JsonProperty("dueAmount") BigDecimal dueAmount, @JsonProperty("paidAmount") BigDecimal paidAmount,
            @JsonProperty("netAmount") BigDecimal netAmount, @JsonProperty("billStatusId") Integer billStatusId,
            @JsonProperty("billTypeId") Integer billTypeId, @JsonProperty("issueDate") String issueDate, @JsonProperty("dueDate") String dueDate,
            @JsonProperty("openDate") String openDate, @JsonProperty("closeDate") String closeDate, @JsonProperty("expiryDate") String expiryDate,
            @JsonProperty("serviceType") String serviceType, @JsonProperty("billerCode") Integer billerCode, @JsonProperty("allowPart") Boolean allowPart,
            @JsonProperty("upperRangePmt") BigDecimal upperRangePmt, @JsonProperty("lowerRangePmt") BigDecimal lowerRangePmt,
            @JsonProperty("extras") String extras, @JsonProperty("inProfile") boolean isInProfile, @JsonProperty("feesType") int feesType,
            @JsonProperty("madfoo3atFees") BigDecimal madfoo3atFees, @JsonProperty("cBJFees") BigDecimal cBJFees,
            @JsonProperty("corridorId") Integer corridorId, @JsonProperty("billingId") Integer billingId,
            @JsonProperty("totalFees") BigDecimal totalFees, @JsonProperty("billerEngName") String billerEngName,
            @JsonProperty("billerArcName") String billerArcName, @JsonProperty("madfoo3atFeesPercent") BigDecimal madfoo3atFeesPercent,
            @JsonProperty("cBJFeesPercent") BigDecimal cBJFeesPercent, @JsonProperty("tableName") String tableName, @JsonProperty("msgID") Long msgID,
            @JsonProperty("locked") boolean isLocked, @JsonProperty("errorCode") Integer errorCode, @JsonProperty("errorDesc") String errorDesc,
            @JsonProperty("bankCode") Integer bankCode, @JsonProperty("dueAmountWithFees") BigDecimal dueAmountWithFees,
            @JsonProperty("billInquiryId") Long billInquiryId, @JsonProperty("participantTypeId") Integer participantTypeId,
            @JsonProperty("participantCode") Integer participantCode, @JsonProperty("lockedNow") boolean isLockedNow,
            @JsonProperty("inquiryCreatedDate") String inquiryCreatedDate, @JsonProperty("billsCount") Integer billsCount,
            @JsonProperty("enableAdditionalInfo") boolean enableAdditionalInfo, @JsonProperty("custName") String custName,
            @JsonProperty("freeText") String freeText, @JsonProperty("corridorFeesID") Integer corridorFeesID,
            @JsonProperty("currencyId") Integer currencyId, @JsonProperty("currencyNameAr") String currencyNameAr,
            @JsonProperty("currencyNameEn") String currencyNameEn, @JsonProperty("payerInfo") PayerInfo payerInfo,
            @JsonProperty("feesDetails") FeesDetails feesDetails,
            @JsonProperty("customerName") String customerName) {
        this.id = id;
        this.billingNumber = billingNumber;
        this.billNumber = billNumber;
        this.dueAmount = dueAmount;
        this.paidAmount = paidAmount;
        this.netAmount = netAmount;
        this.billStatusId = billStatusId;
        this.billTypeId = billTypeId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.expiryDate = expiryDate;
        this.serviceType = serviceType;
        this.billerCode = billerCode;
        this.allowPart = allowPart;
        this.upperRangePmt = upperRangePmt;
        this.lowerRangePmt = lowerRangePmt;
        this.extras = extras;
        this.payerInfo = payerInfo;
        this.isInProfile = isInProfile;
        this.feesType = feesType;
        this.madfoo3atFees = madfoo3atFees;
        this.cBJFees = cBJFees;
        this.corridorId = corridorId;
        this.billingId = billingId;
        this.totalFees = totalFees;
        this.billerEngName = billerEngName;
        this.billerArcName = billerArcName;
        this.madfoo3atFeesPercent = madfoo3atFeesPercent;
        this.cBJFeesPercent = cBJFeesPercent;
        this.tableName = tableName;
        this.msgID = msgID;
        this.isLocked = isLocked;
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
        this.bankCode = bankCode;
        this.dueAmountWithFees = dueAmountWithFees;
        this.billInquiryId = billInquiryId;
        this.participantTypeId = participantTypeId;
        this.participantCode = participantCode;
        this.isLockedNow = isLockedNow;
        this.inquiryCreatedDate = inquiryCreatedDate;
        this.billsCount = billsCount;
        this.enableAdditionalInfo = enableAdditionalInfo;
        this.custName = custName;
        this.freeText = freeText;
        this.corridorFeesID = corridorFeesID;
        this.currencyId = currencyId;
        this.currencyNameAr = currencyNameAr;
        this.currencyNameEn = currencyNameEn;
        this.feesDetails = feesDetails;
        this.customerName = customerName;
    }

    public Long getId() {
        return id;
    }

    public String getBillingNumber() {
        return billingNumber;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public BigDecimal getDueAmount() {
        return dueAmount;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public Integer getBillStatusId() {
        return billStatusId;
    }

    public Integer getBillTypeId() {
        return billTypeId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getOpenDate() {
        return openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getServiceType() {
        return serviceType;
    }

    public Integer getBillerCode() {
        return billerCode;
    }

    public Boolean getAllowPart() {
        return allowPart;
    }

    public BigDecimal getUpperRangePmt() {
        return upperRangePmt;
    }

    public BigDecimal getLowerRangePmt() {
        return lowerRangePmt;
    }

    public String getExtras() {
        return extras;
    }

    public boolean isInProfile() {
        return isInProfile;
    }

    public int getFeesType() {
        return feesType;
    }

    public BigDecimal getMadfoo3atFees() {
        return madfoo3atFees;
    }

    public BigDecimal getcBJFees() {
        return cBJFees;
    }

    public Integer getCorridorId() {
        return corridorId;
    }

    public Integer getBillingId() {
        return billingId;
    }

    public BigDecimal getTotalFees() {
        return totalFees;
    }

    public String getBillerEngName() {
        return billerEngName;
    }

    public String getBillerArcName() {
        return billerArcName;
    }

    public BigDecimal getMadfoo3atFeesPercent() {
        return madfoo3atFeesPercent;
    }

    public BigDecimal getcBJFeesPercent() {
        return cBJFeesPercent;
    }

    public String getTableName() {
        return tableName;
    }

    public Long getMsgID() {
        return msgID;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public Integer getBankCode() {
        return bankCode;
    }

    public BigDecimal getDueAmountWithFees() {
        return dueAmountWithFees;
    }

    public Long getBillInquiryId() {
        return billInquiryId;
    }

    public Integer getParticipantTypeId() {
        return participantTypeId;
    }

    public Integer getParticipantCode() {
        return participantCode;
    }

    public boolean isLockedNow() {
        return isLockedNow;
    }

    public String getInquiryCreatedDate() {
        return inquiryCreatedDate;
    }

    public Integer getBillsCount() {
        return billsCount;
    }

    public boolean isEnableAdditionalInfo() {
        return enableAdditionalInfo;
    }

    public String getCustName() {
        return custName;
    }

    public String getFreeText() {
        return freeText;
    }

    public Integer getCorridorFeesID() {
        return corridorFeesID;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public String getCurrencyNameAr() {
        return currencyNameAr;
    }

    public String getCurrencyNameEn() {
        return currencyNameEn;
    }

    public PayerInfo getPayerInfo() {
        return payerInfo;
    }

    public FeesDetails getFeesDetails() {
        return feesDetails;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return "Bill{"
                + "id=" + id
                + ", billingNumber='" + billingNumber + '\''
                + ", billNumber='" + billNumber + '\''
                + ", dueAmount=" + dueAmount
                + ", paidAmount=" + paidAmount
                + ", netAmount=" + netAmount
                + ", billStatusId=" + billStatusId
                + ", billTypeId=" + billTypeId
                + ", issueDate='" + issueDate + '\''
                + ", dueDate='" + dueDate + '\''
                + ", openDate='" + openDate + '\''
                + ", closeDate='" + closeDate + '\''
                + ", expiryDate='" + expiryDate + '\''
                + ", serviceType='" + serviceType + '\''
                + ", billerCode=" + billerCode
                + ", allowPart=" + allowPart
                + ", upperRangePmt=" + upperRangePmt
                + ", lowerRangePmt=" + lowerRangePmt
                + ", extras='" + extras + '\''
                + ", isInProfile=" + isInProfile
                + ", feesType=" + feesType
                + ", madfoo3atFees=" + madfoo3atFees
                + ", cBJFees=" + cBJFees
                + ", corridorId=" + corridorId
                + ", billingId=" + billingId
                + ", totalFees=" + totalFees
                + ", billerEngName='" + billerEngName + '\''
                + ", billerArcName='" + billerArcName + '\''
                + ", madfoo3atFeesPercent=" + madfoo3atFeesPercent
                + ", cBJFeesPercent=" + cBJFeesPercent
                + ", tableName='" + tableName + '\''
                + ", msgID=" + msgID
                + ", isLocked=" + isLocked
                + ", errorCode=" + errorCode
                + ", errorDesc='" + errorDesc + '\''
                + ", bankCode=" + bankCode
                + ", dueAmountWithFees=" + dueAmountWithFees
                + ", billInquiryId=" + billInquiryId
                + ", participantTypeId=" + participantTypeId
                + ", participantCode=" + participantCode
                + ", isLockedNow=" + isLockedNow
                + ", inquiryCreatedDate='" + inquiryCreatedDate + '\''
                + ", billsCount=" + billsCount
                + ", enableAdditionalInfo=" + enableAdditionalInfo
                + ", custName='" + custName + '\''
                + ", freeText='" + freeText + '\''
                + ", corridorFeesID=" + corridorFeesID
                + ", currencyId=" + currencyId
                + ", currencyNameAr='" + currencyNameAr + '\''
                + ", currencyNameEn='" + currencyNameEn + '\''
                + ", payerInfo=" + payerInfo
                + ", feesDetails=" + feesDetails
                + ", customerName='" + customerName + '\''
                + '}';
    }
}
