package ctm.types;

public enum PaymentStatus {
	PmtNew("PmtNew", 1), PmtUpdated("PmtUpdated", 2), PmtTransf("PmtTransf", 3), PmtReversal("PmtReversal", 5), PmtRecon("PmtRecon", 6), PmtMisMatch("PmtMisMatch", 7), PmtNotInBank("PmtNotInBank", 8), PmtNotInMFEP("PmtNotInMFEP", 9), PmtNotAdviced("PmtNotAdviced", 10), PmtAlreadyRecon("PmtAlreadyRecon", 11), PmtDuplicate("PmtDuplicate", 12), PmtBillerMistmatch("PmtBillerMistmatch", 13), PmtComplt("PmtComplt", 14), PmtSent("PmtSent", 17);

	public final int code;
	public final String message;

	private PaymentStatus(String message, int code) {
		this.message = message;
		this.code = code;
	}

	public static PaymentStatus getPaymentStatusByCode(Integer code) {
		if(code != null) {
			for (PaymentStatus paymentStatus : PaymentStatus.values()) {
				if (code == paymentStatus.code)
					return paymentStatus;
			}
		}
		return null;
	}
}
