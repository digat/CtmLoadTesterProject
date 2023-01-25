package ctm.types;

public enum PaymentType {
	Postpaid("Postpaid", 1), Prepaid("Prepaid", 2);

	public final int code;
	public final String message;

	private PaymentType(String message, int code) {
		this.message = message;
		this.code = code;
	}

	public static PaymentType getPaymentTypeByCode(int code) {
		for (PaymentType type : PaymentType.values()) {
			if (code == type.code)
				return type;
		}
		return null;
	}
}
