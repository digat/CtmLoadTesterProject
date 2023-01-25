package ctm.types;
public class PostpaidPaymentData {
	private final PostpaidProcessingData postpaidProcessingData;
	private final PostpaidDBRes postpaidDBRes;

	public PostpaidPaymentData(PostpaidProcessingData postpaidProcessingData, PostpaidDBRes postpaidDBRes) {
		this.postpaidProcessingData = postpaidProcessingData;
		this.postpaidDBRes = postpaidDBRes;
	}

	public PostpaidProcessingData getPostpaidProcessingData() {
		return postpaidProcessingData;
	}

	public PostpaidDBRes getPostpaidDBRes() {
		return postpaidDBRes;
	}

	@Override
	public String toString() {
		return "PostpaidPaymentData{" +
				"postpaidProcessingData=" + postpaidProcessingData +
				", postpaidDBRes=" + postpaidDBRes +
				'}';
	}
}
