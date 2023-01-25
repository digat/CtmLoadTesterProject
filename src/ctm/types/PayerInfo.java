package ctm.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = false)
public class PayerInfo {

	private final String id;
	private final String  idType;
	private final String  nation;
	private final String name;
	private final String phone;
	private final String address;
	private final String email;
	private final String jOEBPPSNo;

	@JsonCreator public PayerInfo(
			@JsonProperty("IdType") String idType,
			@JsonProperty("Id") String id,
			@JsonProperty("Nation") String nation,
			@JsonProperty("Name") String name,
			@JsonProperty("Phone") String phone,
			@JsonProperty("Address") String address,
			@JsonProperty("Email") String email,
			@JsonProperty("JOEBPPSNo") String jOEBPPSNo) {
		this.id = id;
		this.idType = idType;
		this.nation = nation;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.jOEBPPSNo = jOEBPPSNo;
	}

	@JsonProperty("Id") public String getId() {
		return id;
	}

	@JsonProperty("IdType") public String getIdType() {
		return idType;
	}

	@JsonProperty("Nation") public String getNation() {
		return nation;
	}

	@JsonProperty("Name") public String getName() {
		return name;
	}

	@JsonProperty("Phone") public String getPhone() {
		return phone;
	}

	@JsonProperty("Address") public String getAddress() {
		return address;
	}

	@JsonProperty("Email") public String getEmail() {
		return email;
	}

	@JsonProperty("JOEBPPSNo") public String getjOEBPPSNo() {
		return jOEBPPSNo;
	}
}
