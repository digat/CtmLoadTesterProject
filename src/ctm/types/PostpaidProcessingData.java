package ctm.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class PostpaidProcessingData {
  private final String cachedInquiryKey;
  private final String bankTrxID;
  private final Integer billerCode;
  private final String billingNo;
  private final String billNo;
  private final BigDecimal dueAmt;
  private final BigDecimal paidAmt;
  private final String processDate;
  private final String sTMTDate;
  private final int errorCode;
  private final Integer accessChannelId;
  private final PaymentMethod paymentMethod;
  private final PaymentStatus paymentStatus;
  private final PaymentType paymentType;
  private final Long billerServiceTypesId;
  private final String billerServiceType;
  private final Integer prepaidCategoriesId;
  private final Long inqRefNo;
  private final Integer cSPDVerificationTypeId;
  private final boolean lockedNow;
  private final BigDecimal paidAmountWithoutFees;
  private final Integer billerServiceTypesFeesTypeID;
  private final int refNo;
  private final BigDecimal paidAmountInPayingPartCurrency;
  private final BigDecimal paidAmountInBillerCurrency;
  private final Integer currencyId;
  private final String accessChannelName;
  private final String currencyName;
  private final String errorDesc;
  private final CustomerProfile customerProfile;
  private final PayerInfo payerInfo;
  private final FeesDetails feesDetails;
  private final Bill bill;

  private final String customerName;

  @JsonCreator
  public PostpaidProcessingData(
      @JsonProperty("bankTrxID") String bankTrxID,
      @JsonProperty("billerCode") Integer billerCode,
      @JsonProperty("billingNo") String billingNo,
      @JsonProperty("billNo") String billNo,
      @JsonProperty("dueAmt") BigDecimal dueAmt,
      @JsonProperty("paidAmt") BigDecimal paidAmt,
      @JsonProperty("processDate") String processDate,
      @JsonProperty("sTMTDate") String sTMTDate,
      @JsonProperty("errorCode") int errorCode,
      @JsonProperty("accessChannelId") Integer accessChannelId,
      @JsonProperty("paymentMethod") PaymentMethod paymentMethod,
      @JsonProperty("paymentStatus") PaymentStatus paymentStatus,
      @JsonProperty("paymentType") PaymentType paymentType,
      @JsonProperty("billerServiceTypesId") Long billerServiceTypesId,
      @JsonProperty("prepaidCategoriesId") Integer prepaidCategoriesId,
      @JsonProperty("inqRefNo") Long inqRefNo,
      @JsonProperty("cSPDVerificationTypeId") Integer cSPDVerificationTypeId,
      @JsonProperty("lockedNow") boolean lockedNow,
      @JsonProperty("paidAmountWithoutFees") BigDecimal paidAmountWithoutFees,
      @JsonProperty("billerServiceTypesFeesTypeID") Integer billerServiceTypesFeesTypeID,
      @JsonProperty("refNo") int refNo,
      @JsonProperty("paidAmountInPayingPartCurrency") BigDecimal paidAmountInPayingPartCurrency,
      @JsonProperty("paidAmountInBillerCurrency") BigDecimal paidAmountInBillerCurrency,
      @JsonProperty("currencyId") Integer currencyId,
      @JsonProperty("billerServiceType") String billerServiceType,
      @JsonProperty("accessChannelName") String accessChannelName,
      @JsonProperty("currencyName") String currencyName,
      @JsonProperty("errorDesc") String errorDesc,
      @JsonProperty("customerProfile") CustomerProfile customerProfile,
      @JsonProperty("payerInfo") PayerInfo payerInfo,
      @JsonProperty("feesDetails") FeesDetails feesDetails,
      @JsonProperty("bill") Bill bill,
      @JsonProperty("cachedInquiryKey") String cachedInquiryKey,
      @JsonProperty("customerName") String customerName) {
    this.bankTrxID = bankTrxID;
    this.billerCode = billerCode;
    this.billingNo = billingNo;
    this.billNo = billNo;
    this.dueAmt = dueAmt;
    this.paidAmt = paidAmt;
    this.processDate = processDate;
    this.sTMTDate = sTMTDate;
    this.errorCode = errorCode;
    this.accessChannelId = accessChannelId;
    this.paymentMethod = paymentMethod;
    this.paymentStatus = paymentStatus;
    this.paymentType = paymentType;
    this.billerServiceTypesId = billerServiceTypesId;
    this.billerServiceType = billerServiceType;
    this.prepaidCategoriesId = prepaidCategoriesId;
    this.inqRefNo = inqRefNo;
    this.cSPDVerificationTypeId = cSPDVerificationTypeId;
    this.lockedNow = lockedNow;
    this.paidAmountWithoutFees = paidAmountWithoutFees;
    this.billerServiceTypesFeesTypeID = billerServiceTypesFeesTypeID;
    this.refNo = refNo;
    this.paidAmountInPayingPartCurrency = paidAmountInPayingPartCurrency;
    this.paidAmountInBillerCurrency = paidAmountInBillerCurrency;
    this.currencyId = currencyId;
    this.accessChannelName = accessChannelName;
    this.currencyName = currencyName;
    this.errorDesc = errorDesc;
    this.customerProfile = customerProfile;
    this.payerInfo = payerInfo;
    this.feesDetails = feesDetails;
    this.bill = bill;
    this.cachedInquiryKey = cachedInquiryKey;
    this.customerName = customerName;
  }

  public String getBankTrxID() {
    return bankTrxID;
  }

  public Integer getBillerCode() {
    return billerCode;
  }

  public String getBillingNo() {
    return billingNo;
  }

  public String getBillNo() {
    return billNo;
  }

  public BigDecimal getDueAmt() {
    return dueAmt;
  }

  public BigDecimal getPaidAmt() {
    return paidAmt;
  }

  public String getProcessDate() {
    return processDate;
  }

  public String getsTMTDate() {
    return sTMTDate;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public Integer getAccessChannelId() {
    return accessChannelId;
  }

  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }

  public PaymentStatus getPaymentStatus() {
    return paymentStatus;
  }

  public PaymentType getPaymentType() {
    return paymentType;
  }

  public Long getBillerServiceTypesId() {
    return billerServiceTypesId;
  }

  public String getBillerServiceType() {
    return billerServiceType;
  }

  public Integer getPrepaidCategoriesId() {
    return prepaidCategoriesId;
  }

  public Long getInqRefNo() {
    return inqRefNo;
  }

  public Integer getcSPDVerificationTypeId() {
    return cSPDVerificationTypeId;
  }

  public boolean isLockedNow() {
    return lockedNow;
  }

  public BigDecimal getPaidAmountWithoutFees() {
    return paidAmountWithoutFees;
  }

  public Integer getBillerServiceTypesFeesTypeID() {
    return billerServiceTypesFeesTypeID;
  }

  public int getRefNo() {
    return refNo;
  }

  public BigDecimal getPaidAmountInPayingPartCurrency() {
    return paidAmountInPayingPartCurrency;
  }

  public BigDecimal getPaidAmountInBillerCurrency() {
    return paidAmountInBillerCurrency;
  }

  public Integer getCurrencyId() {
    return currencyId;
  }

  public String getAccessChannelName() {
    return accessChannelName;
  }

  public String getCurrencyName() {
    return currencyName;
  }

  public String getErrorDesc() {
    return errorDesc;
  }

  public CustomerProfile getCustomerProfile() {
    return customerProfile;
  }

  public PayerInfo getPayerInfo() {
    return payerInfo;
  }

  public FeesDetails getFeesDetails() {
    return feesDetails;
  }

  public Bill getBill() {
    return bill;
  }

  public String getCachedInquiryKey() {
    return cachedInquiryKey;
  }

  public String getCustomerName() {
    return customerName;
  }

  @Override
  public String toString() {
    return "PostpaidProcessingData{" +
            "cachedInquiryKey='" + cachedInquiryKey + '\'' +
            ", bankTrxID='" + bankTrxID + '\'' +
            ", billerCode=" + billerCode +
            ", billingNo='" + billingNo + '\'' +
            ", billNo='" + billNo + '\'' +
            ", dueAmt=" + dueAmt +
            ", paidAmt=" + paidAmt +
            ", processDate='" + processDate + '\'' +
            ", sTMTDate='" + sTMTDate + '\'' +
            ", errorCode=" + errorCode +
            ", accessChannelId=" + accessChannelId +
            ", paymentMethod=" + paymentMethod +
            ", paymentStatus=" + paymentStatus +
            ", paymentType=" + paymentType +
            ", billerServiceTypesId=" + billerServiceTypesId +
            ", billerServiceType='" + billerServiceType + '\'' +
            ", prepaidCategoriesId=" + prepaidCategoriesId +
            ", inqRefNo=" + inqRefNo +
            ", cSPDVerificationTypeId=" + cSPDVerificationTypeId +
            ", lockedNow=" + lockedNow +
            ", paidAmountWithoutFees=" + paidAmountWithoutFees +
            ", billerServiceTypesFeesTypeID=" + billerServiceTypesFeesTypeID +
            ", refNo=" + refNo +
            ", paidAmountInPayingPartCurrency=" + paidAmountInPayingPartCurrency +
            ", paidAmountInBillerCurrency=" + paidAmountInBillerCurrency +
            ", currencyId=" + currencyId +
            ", accessChannelName='" + accessChannelName + '\'' +
            ", currencyName='" + currencyName + '\'' +
            ", errorDesc='" + errorDesc + '\'' +
            ", customerProfile=" + customerProfile +
            ", payerInfo=" + payerInfo +
            ", feesDetails=" + feesDetails +
            ", bill=" + bill +
            ", customerName='" + customerName + '\'' +
            '}';
  }
}
