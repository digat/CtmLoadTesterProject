package ctm.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;



public class CustomerProfile {
	private final Long jOEBPPSNo;
	private final String officialID;
	private final Integer officialTypeId;
	private final Integer profileStatusId;
	private final Integer nationalityID;
	private final String name;
	private final String phone;
	private final String address;
	private final String creationDate;
	private final String email;
	private final int participantType;
	private final String participant;
	private final Integer updatedBy;
	private final String updatedOn;
	private final String gUID;
	private final String updatedByName;
	private final long id;
	private final String firstName;
	private final String secondName;
	private final String thirdName;
	private final String familyName;
	private final String nameAr;
	private final String secondNameAr;
	private final String thirdNameAr;
	private final String familyNameAr;
	private final String civilNo;
	private final Integer gender;
	private final Integer maritalStatusId;
	private final Integer lifeStatusId;
	private final String dateOfBirth;
	private final String passportNo;
	private final Integer cSPDVerificationStatus;
	private final String createdName;
	private final int createdBy;
	
	
	public CustomerProfile(CustomerProfile customerProfile,Integer cSPDVerificationStatus) {
		this(customerProfile.jOEBPPSNo,customerProfile.officialID,customerProfile.officialTypeId,customerProfile.profileStatusId,customerProfile.nationalityID,customerProfile.name,customerProfile.phone,customerProfile.address,
			customerProfile.creationDate,customerProfile.email,customerProfile.participantType,customerProfile.participant,
				customerProfile.updatedBy,customerProfile.updatedOn,customerProfile.gUID,customerProfile.updatedByName,customerProfile.id,customerProfile.firstName,customerProfile.secondName,
				customerProfile.thirdName,customerProfile.familyName,
				customerProfile.nameAr,customerProfile.secondNameAr,customerProfile.thirdNameAr,
				customerProfile.familyNameAr,customerProfile.civilNo,
				customerProfile.gender,customerProfile.maritalStatusId,
				customerProfile.lifeStatusId,customerProfile.dateOfBirth,
				customerProfile.passportNo,cSPDVerificationStatus,customerProfile.createdName,customerProfile.createdBy);
	}
	
	public CustomerProfile(long id, String officialID) {
		this(null,officialID,null,null,null,null,null,null,null,null,0,null,
				null,null,null,null,id,null,null,
				null,null,
				null,null,null,
				null,null,
				null,null,
				null,null,
				null,null,null,0);
	}

	@JsonCreator public CustomerProfile(@JsonProperty("JOEBPPSNo") Long jOEBPPSNo, @JsonProperty("OfficialID") String officialID, @JsonProperty("OfficialTypeId") Integer officialTypeId, 
		@JsonProperty("ProfileStatusId") Integer profileStatusId,
		@JsonProperty("NationalityID") Integer nationalityID, @JsonProperty("Name") String name,
		@JsonProperty("Phone") String phone, @JsonProperty("Address") String address,
		@JsonProperty("CreationDate") String creationDate, @JsonProperty("Email") String email,
		@JsonProperty("ParticipantType") int participantType, @JsonProperty("Participant") String participant, 
		@JsonProperty("UpdatedBy") Integer updatedBy, @JsonProperty("UpdatedOn") String updatedOn,
		@JsonProperty("GUID") String gUID, @JsonProperty("UpdatedByName") String updatedByName,
		@JsonProperty("Id") long id, @JsonProperty("FirstName") String firstName, @JsonProperty("SecondName") String secondName,
		@JsonProperty("ThirdName") String thirdName, @JsonProperty("FamilyName") String familyName, @JsonProperty("NameAr") String nameAr,
		@JsonProperty("SecondNameAr") String secondNameAr, @JsonProperty("ThirdNameAr") String thirdNameAr, @JsonProperty("FamilyNameAr") String familyNameAr,
		@JsonProperty("CivilNo") String civilNo, @JsonProperty("Gender") Integer gender, @JsonProperty("MaritalStatusId") Integer maritalStatusId,
		@JsonProperty("LifeStatusId") Integer lifeStatusId, @JsonProperty("DateOfBirth") String dateOfBirth, @JsonProperty("PassportNo") String passportNo,
		@JsonProperty("CSPDVerificationStatus") Integer cSPDVerificationStatus, @JsonProperty("CreatedName") String createdName, @JsonProperty("CreatedBy") int createdBy) {
		this.jOEBPPSNo = jOEBPPSNo;
		this.officialID = officialID;
		this.officialTypeId = officialTypeId;
		this.profileStatusId = profileStatusId;
		this.nationalityID = nationalityID;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.creationDate = creationDate;
		this.email = email;
		this.participantType = participantType;
		this.participant = participant;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
		this.gUID = gUID;
		this.updatedByName = updatedByName;
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.thirdName = thirdName;
		this.familyName = familyName;
		this.nameAr = nameAr;
		this.secondNameAr = secondNameAr;
		this.thirdNameAr = thirdNameAr;
		this.familyNameAr = familyNameAr;
		this.civilNo = civilNo;
		this.gender = gender;
		this.maritalStatusId = maritalStatusId;
		this.lifeStatusId = lifeStatusId;
		this.dateOfBirth = dateOfBirth;
		this.passportNo = passportNo;
		this.cSPDVerificationStatus = cSPDVerificationStatus;
		this.createdName = createdName;
		this.createdBy = createdBy;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public Long getjOEBPPSNo() {
		return jOEBPPSNo;
	}

	public String getOfficialID() {
		return officialID;
	}

	public Integer getOfficialTypeId() {
		return officialTypeId;
	}

	public Integer getProfileStatusId() {
		return profileStatusId;
	}

	public Integer getNationalityID() {
		return nationalityID;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public String getEmail() {
		return email;
	}

	public int getParticipantType() {
		return participantType;
	}

	public String getParticipant() {
		return participant;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public String getgUID() {
		return gUID;
	}

	public String getUpdatedByName() {
		return updatedByName;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public String getThirdName() {
		return thirdName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public String getNameAr() {
		return nameAr;
	}

	public String getSecondNameAr() {
		return secondNameAr;
	}

	public String getThirdNameAr() {
		return thirdNameAr;
	}

	public String getFamilyNameAr() {
		return familyNameAr;
	}

	public String getCivilNo() {
		return civilNo;
	}

	public Integer getGender() {
		return gender;
	}

	public Integer getMaritalStatusId() {
		return maritalStatusId;
	}

	public Integer getLifeStatusId() {
		return lifeStatusId;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public Integer getcSPDVerificationStatus() {
		return cSPDVerificationStatus;
	}

	public String getCreatedName() {
		return createdName;
	}

	@Override public String toString() {
		return "CustomerProfile{" + "jOEBPPSNo=" + jOEBPPSNo + ", officialID='" + officialID + '\'' + ", officialTypeId=" + officialTypeId + ", profileStatusId=" + profileStatusId + ", nationalityID=" + nationalityID + ", name='" + name + '\'' + ", phone='" + phone + '\'' + ", address='" + address + '\'' + ", creationDate=" + creationDate +  ", email='" + email + '\'' + ", participantType=" + participantType + ", participant='" + participant + '\'' + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + ", gUID='" + gUID + '\'' + ", updatedByName='" + updatedByName + '\'' + ", id=" + id + ", firstName='" + firstName + '\'' + ", secondName='" + secondName + '\'' + ", thirdName='" + thirdName + '\'' + ", familyName='" + familyName + '\'' + ", nameAr='" + nameAr + '\'' + ", secondNameAr='" + secondNameAr + '\'' + ", thirdNameAr='" + thirdNameAr + '\'' + ", familyNameAr='" + familyNameAr + '\'' + ", civilNo='" + civilNo + '\'' + ", gender=" + gender + ", maritalStatusId=" + maritalStatusId + ", lifeStatusId=" + lifeStatusId + ", dateOfBirth=" + dateOfBirth + ", passportNo='" + passportNo + '\'' + ", cSPDVerificationStatus=" + cSPDVerificationStatus + ", createdName='" + createdName + '\'' + '}';
	}
}
