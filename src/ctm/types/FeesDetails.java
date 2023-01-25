package ctm.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeesDetails {
	private final Integer corridorID;
	private final Integer corridorFeesID;
	private final BigDecimal mFEPCustomerFixedFees;
	private final BigDecimal mFEPCustomerPercentageFees;
	private final BigDecimal mFEPBillerFixedFees;
	private final BigDecimal mFEPBillerPercentageFees;
	private final BigDecimal cBCustomerFixedFees;
	private final BigDecimal cBCustomerPercentageFees;
	private final BigDecimal cBBillerFixedFees;
	private final BigDecimal cBBillerPercentageFees;
	private final BigDecimal totalFees;
	private final BigDecimal partCustomerFees;
	private final BigDecimal partBillerFees;
	private final BigDecimal partCustomerFees_Percentag;
	private final BigDecimal partCustomerFees_Fix;
	private final BigDecimal partBillerFees_Percentag;
	private final BigDecimal partBillerFees_Fix;
	private final BigDecimal lAPMExtraFeesBiller;
	private final BigDecimal lAPMExtraFeesCustomer;
	private final BigDecimal dueAmountWithFees;
	private final BigDecimal feesAmount;
	private final BigDecimal  cbjFees;
	private final BigDecimal mfepFees;
	private final BigDecimal cbCustomerFees;
	private final BigDecimal cbBillerFees;
	private final Boolean feesAdded;
	

	@JsonCreator public FeesDetails(
			@JsonProperty("corridorID") Integer corridorID,
			@JsonProperty("corridorFeesID") Integer corridorFeesID,
			@JsonProperty("mFEPCustomerFixedFees") BigDecimal mFEPCustomerFixedFees,
			@JsonProperty("mFEPCustomerPercentageFees") BigDecimal mFEPCustomerPercentageFees,
			@JsonProperty("mFEPBillerFixedFees") BigDecimal mFEPBillerFixedFees,
			@JsonProperty("mFEPBillerPercentageFees") BigDecimal mFEPBillerPercentageFees,
			@JsonProperty("cBCustomerFixedFees") BigDecimal cBCustomerFixedFees,
			@JsonProperty("cBCustomerPercentageFees") BigDecimal cBCustomerPercentageFees,
			@JsonProperty("cBBillerFixedFees") BigDecimal cBBillerFixedFees,
			@JsonProperty("cBBillerPercentageFees") BigDecimal cBBillerPercentageFees,
			@JsonProperty("totalFees") BigDecimal totalFees,
			@JsonProperty("partCustomerFees") BigDecimal partCustomerFees,
			@JsonProperty("partBillerFees") BigDecimal partBillerFees,
			@JsonProperty("partCustomerFees_Percentag") BigDecimal partCustomerFees_Percentag,
			@JsonProperty("partCustomerFees_Fix") BigDecimal partCustomerFees_Fix,
			@JsonProperty("partBillerFees_Percentag") BigDecimal partBillerFees_Percentag,
			@JsonProperty("partBillerFees_Fix") BigDecimal partBillerFees_Fix,
			@JsonProperty("lAPMExtraFeesBiller")BigDecimal lAPMExtraFeesBiller,
			@JsonProperty("lAPMExtraFeesCustomer") BigDecimal lAPMExtraFeesCustomer , 
			@JsonProperty("dueAmountWithFees") BigDecimal dueAmountWithFees , 
			@JsonProperty("feesAmount") BigDecimal feesAmount,
			@JsonProperty("cbjFees") BigDecimal cbjFees ,
			@JsonProperty("mfepFees") BigDecimal mfepFees, 
			@JsonProperty("cbCustomerFees") BigDecimal cbCustomerFees,
			@JsonProperty("cbBillerFees") BigDecimal cbBillerFees,
			@JsonProperty("isFeesAdded") Boolean feesAdded
			) {
		this.corridorID = corridorID;
		this.corridorFeesID = corridorFeesID;
		this.mFEPCustomerFixedFees = mFEPCustomerFixedFees;
		this.mFEPCustomerPercentageFees = mFEPCustomerPercentageFees;
		this.mFEPBillerFixedFees = mFEPBillerFixedFees;
		this.mFEPBillerPercentageFees = mFEPBillerPercentageFees;
		this.cBCustomerFixedFees = cBCustomerFixedFees;
		this.cBCustomerPercentageFees = cBCustomerPercentageFees;
		this.cBBillerFixedFees = cBBillerFixedFees;
		this.cBBillerPercentageFees = cBBillerPercentageFees;
		this.totalFees = totalFees;
		this.partCustomerFees = partCustomerFees;
		this.partBillerFees = partBillerFees;
		this.partCustomerFees_Percentag = partCustomerFees_Percentag;
		this.partCustomerFees_Fix = partCustomerFees_Fix;
		this.partBillerFees_Percentag = partBillerFees_Percentag;
		this.partBillerFees_Fix = partBillerFees_Fix;
		this.lAPMExtraFeesBiller = lAPMExtraFeesBiller;
		this.lAPMExtraFeesCustomer = lAPMExtraFeesCustomer;
		this.dueAmountWithFees = dueAmountWithFees;
		this.feesAmount = feesAmount;
		this.cbjFees = cbjFees;
		this.mfepFees = mfepFees;
		this.cbCustomerFees = cbCustomerFees;
		this.cbBillerFees = cbBillerFees;
		this.feesAdded = feesAdded;
		
	}

	public Integer getCorridorID() {
		return corridorID;
	}

	public Integer getCorridorFeesID() {
		return corridorFeesID;
	}

	public BigDecimal getmFEPCustomerFixedFees() {
		return mFEPCustomerFixedFees;
	}

	public BigDecimal getmFEPCustomerPercentageFees() {
		return mFEPCustomerPercentageFees;
	}

	public BigDecimal getmFEPBillerFixedFees() {
		return mFEPBillerFixedFees;
	}

	public BigDecimal getmFEPBillerPercentageFees() {
		return mFEPBillerPercentageFees;
	}

	public BigDecimal getcBCustomerFixedFees() {
		return cBCustomerFixedFees;
	}

	public BigDecimal getcBCustomerPercentageFees() {
		return cBCustomerPercentageFees;
	}

	public BigDecimal getcBBillerFixedFees() {
		return cBBillerFixedFees;
	}

	public BigDecimal getcBBillerPercentageFees() {
		return cBBillerPercentageFees;
	}

	public BigDecimal getTotalFees() {
		return totalFees;
	}

	public BigDecimal getPartCustomerFees() {
		return partCustomerFees;
	}

	public BigDecimal getPartBillerFees() {
		return partBillerFees;
	}

	public BigDecimal getPartCustomerFees_Percentag() {
		return partCustomerFees_Percentag;
	}

	public BigDecimal getPartCustomerFees_Fix() {
		return partCustomerFees_Fix;
	}

	public BigDecimal getPartBillerFees_Percentag() {
		return partBillerFees_Percentag;
	}

	public BigDecimal getPartBillerFees_Fix() {
		return partBillerFees_Fix;
	}

	public BigDecimal getlAPMExtraFeesBiller() {
		return lAPMExtraFeesBiller;
	}

	public BigDecimal getlAPMExtraFeesCustomer() {
		return lAPMExtraFeesCustomer;
	}

	public BigDecimal getDueAmountWithFees() {
		return dueAmountWithFees;
	}

	public BigDecimal getFeesAmount() {
		return feesAmount;
	}

	public BigDecimal getCbjFees() {
		return cbjFees;
	}

	public BigDecimal getMfepFees() {
		return mfepFees;
	}

	public Boolean isFeesAdded() {
		return feesAdded;
	}

	public BigDecimal getCbCustomerFees() {
		return cbCustomerFees;
	}

	public BigDecimal getCbBillerFees() {
		return cbBillerFees;
	}

	public Boolean getFeesAdded() {
		return feesAdded;
	}

	@Override public String toString() {
		return "FeesDetails{" + "corridorID=" + corridorID + ", corridorFeesID=" + corridorFeesID + ", mFEPCustomerFixedFees=" + mFEPCustomerFixedFees + ", mFEPCustomerPercentageFees=" + mFEPCustomerPercentageFees + ", mFEPBillerFixedFees=" + mFEPBillerFixedFees + ", mFEPBillerPercentageFees=" + mFEPBillerPercentageFees + ", cBCustomerFixedFees=" + cBCustomerFixedFees + ", cBCustomerPercentageFees=" + cBCustomerPercentageFees + ", cBBillerFixedFees=" + cBBillerFixedFees + ", cBBillerPercentageFees=" + cBBillerPercentageFees + ", totalFees=" + totalFees + ", partCustomerFees=" + partCustomerFees + ", partBillerFees=" + partBillerFees + ", partCustomerFees_Percentag=" + partCustomerFees_Percentag + ", partCustomerFees_Fix=" + partCustomerFees_Fix + ", partBillerFees_Percentag=" + partBillerFees_Percentag + ", partBillerFees_Fix=" + partBillerFees_Fix + ", lAPMExtraFeesBiller=" + lAPMExtraFeesBiller + ", lAPMExtraFeesCustomer=" + lAPMExtraFeesCustomer + ", dueAmountWithFees=" + dueAmountWithFees + ", feesAmount=" + feesAmount + ", cbjFees=" + cbjFees + ", mfepFees=" + mfepFees + ", cbCustomerFees=" + cbCustomerFees + ", cbBillerFees=" + cbBillerFees + ", feesAdded=" + feesAdded + '}';
	}
}
