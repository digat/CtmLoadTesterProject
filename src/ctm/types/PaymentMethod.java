package ctm.types;

public enum PaymentMethod {
	CASH("CASH", 1), CCARD("CCARD", 2), EFT("EFT", 3), ACTDEB("ACTDEB", 4);

	public final int code;
	public final String message;

	private PaymentMethod(String message, int code) {
		this.message = message;
		this.code = code;
	}

	public static PaymentMethod getPaymentMethodByCode(Integer code) {
		if(code != null) {
			for (PaymentMethod type : PaymentMethod.values()) {
				if (code == type.code)
					return type;
			}
		}
		return null;
	}
}
