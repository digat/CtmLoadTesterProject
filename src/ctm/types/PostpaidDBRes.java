package ctm.types;

public class PostpaidDBRes {
	private final String jOEBPPSTrx;
	private final Long paymentID;
	private final Integer errorCode;
	private final Long msgId;

	public PostpaidDBRes(String jOEBPPSTrx, Long paymentID, Integer errorCode,Long msgId) {
		this.jOEBPPSTrx = jOEBPPSTrx;
		this.paymentID = paymentID;
		this.errorCode = errorCode;
		this.msgId = msgId;
	}

	public String getjOEBPPSTrx() {
		return jOEBPPSTrx;
	}

	public Long getPaymentID() {
		return paymentID;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public Long getMsgId() {
		return msgId;
	}

	@Override
	public String toString() {
		return "PostpaidDBRes{" +
				"jOEBPPSTrx='" + jOEBPPSTrx + '\'' +
				", paymentID=" + paymentID +
				", errorCode=" + errorCode +
				", msgId=" + msgId +
				'}';
	}
}
