package tz.go.moh.him.hfr.mediator.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a Health Facility Registry request message.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HfrRequest {

    /**
     * The facility id number.
     */
    @JsonProperty("Fac_IDNumber")
    private String facilityIdNumber;
    /**
     * The facility name.
     */
    @JsonProperty("Name")
    private String name;
    /**
     * The common facility name.
     */
    @JsonProperty("Comm_FacName")
    private String commonFacilityName;
    /**
     * The zone.
     */
    @JsonProperty("Zone")
    private String zone;
    /**
     * The region.
     */
    @JsonProperty("Region")
    private String region;
    /**
     * The region code.
     */
    @JsonProperty("Region_Code")
    private String regionCode;
    /**
     * The district.
     */
    @JsonProperty("District")
    private String district;
    /**
     * The district code.
     */
    @JsonProperty("District_Code")
    private String districtCode;
    /**
     * The council.
     */
    @JsonProperty("Council")
    private String council;
    /**
     * The council code.
     */
    @JsonProperty("Council_Code")
    private String councilCode;
    /**
     * The ward.
     */
    @JsonProperty("Ward")
    private String ward;
    /**
     * The village street.
     */
    @JsonProperty("Village")
    private String village;
    /**
     * The facility type group.
     */
    @JsonProperty("FacilityTypeGroup")
    private String facilityTypeGroup;
    /**
     * The facility type group code.
     */
    @JsonProperty("FacilityTypeGroupCode")
    private String facilityTypeGroupCode;
    /**
     * The facility type.
     */
    @JsonProperty("FacilityType")
    private String facilityType;
    /**
     * The facility type code.
     */
    @JsonProperty("FacilityTypeCode")
    private String facilityTypeCode;
    /**
     * The ownership group.
     */
    @JsonProperty("OwnershipGroup")
    private String ownershipGroup;
    /**
     * The ownership group code.
     */
    @JsonProperty("OwnershipGroupCode")
    private String ownershipGroupCode;
    /**
     * The ownership.
     */
    @JsonProperty("Ownership")
    private String ownership;
    /**
     * The ownership code.
     */
    @JsonProperty("OwnershipCode")
    private String ownershipCode;
    /**
     * The operating status.
     */
    @JsonProperty("OperatingStatus")
    private String operatingStatus;
    /**
     * The latitude.
     */
    @JsonProperty("Latitude")
    private String latitude;
    /**
     * The longitude.
     */
    @JsonProperty("Longitude")
    private String longitude;
    /**
     * The registration status.
     */
    @JsonProperty("RegistrationStatus")
    private String registrationStatus;
    /**
     * The date time at which the record was created.
     */
    @JsonProperty("CreatedAt")
    private String createdAt;
    /**
     * The date time at which the record was updated.
     */
    @JsonProperty("UpdatedAt")
    private String updatedAt;

    /**
     * The date time at which the facility was opened.
     */
    @JsonProperty("OpenedDate")
    private String openedDate;
    /**
     * The date time at which the facility was closed.
     */
    @JsonProperty("ClosedDate")
    private String closedDate;

    /**
     * The indicator as to whether the operating status changed from open to closed.
     */
    @JsonProperty("OSchangeOpenedtoClose")
    private String operatingStatusChangeOpenToClosed;
    /**
     * The indicator as to whether the operating status changed from closed to operational.
     */
    @JsonProperty("OSchangeClosedtoOperational")
    private String operatingStatusChangeClosedToOperational;
    /**
     * The indicator as to whether this message is a create or update.
     */
    @JsonProperty("PostorUpdate")
    private MessageOperation postOrUpdate;

    /**
     * Initializes a new instance of the {@link HfrRequest} class.
     */
    public HfrRequest() {
    }

    public String getFacilityIdNumber() {
        return facilityIdNumber;
    }

    public void setFacilityIdNumber(String facilityIdNumber) {
        this.facilityIdNumber = facilityIdNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommonFacilityName() {
        return commonFacilityName;
    }

    public void setCommonFacilityName(String commonFacilityName) {
        this.commonFacilityName = commonFacilityName;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getCouncil() {
        return council;
    }

    public void setCouncil(String council) {
        this.council = council;
    }

    public String getCouncilCode() {
        return councilCode;
    }

    public void setCouncilCode(String councilCode) {
        this.councilCode = councilCode;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getFacilityTypeGroup() {
        return facilityTypeGroup;
    }

    public void setFacilityTypeGroup(String facilityTypeGroup) {
        this.facilityTypeGroup = facilityTypeGroup;
    }

    public String getFacilityTypeGroupCode() {
        return facilityTypeGroupCode;
    }

    public void setFacilityTypeGroupCode(String facilityTypeGroupCode) {
        this.facilityTypeGroupCode = facilityTypeGroupCode;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public String getFacilityTypeCode() {
        return facilityTypeCode;
    }

    public void setFacilityTypeCode(String facilityTypeCode) {
        this.facilityTypeCode = facilityTypeCode;
    }

    public String getOwnershipGroup() {
        return ownershipGroup;
    }

    public void setOwnershipGroup(String ownershipGroup) {
        this.ownershipGroup = ownershipGroup;
    }

    public String getOwnershipGroupCode() {
        return ownershipGroupCode;
    }

    public void setOwnershipGroupCode(String ownershipGroupCode) {
        this.ownershipGroupCode = ownershipGroupCode;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getOwnershipCode() {
        return ownershipCode;
    }

    public void setOwnershipCode(String ownershipCode) {
        this.ownershipCode = ownershipCode;
    }

    public String getOperatingStatus() {
        return operatingStatus;
    }

    public void setOperatingStatus(String operatingStatus) {
        this.operatingStatus = operatingStatus;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getOperatingStatusChangeOpenToClosed() {
        return operatingStatusChangeOpenToClosed;
    }

    public void setOperatingStatusChangeOpenToClosed(String operatingStatusChangeOpenToClosed) {
        this.operatingStatusChangeOpenToClosed = operatingStatusChangeOpenToClosed;
    }

    public String getOperatingStatusChangeClosedToOperational() {
        return operatingStatusChangeClosedToOperational;
    }

    public void setOperatingStatusChangeClosedToOperational(String operatingStatusChangeClosedToOperational) {
        this.operatingStatusChangeClosedToOperational = operatingStatusChangeClosedToOperational;
    }

    public MessageOperation getPostOrUpdate() {
        return postOrUpdate;
    }

    public void setPostOrUpdate(MessageOperation postOrUpdate) {
        this.postOrUpdate = postOrUpdate;
    }

    public String getOpenedDate() {
        return openedDate;
    }

    public void setOpenedDate(String openedDate) {
        this.openedDate = openedDate;
    }

    public String getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
    }
}
