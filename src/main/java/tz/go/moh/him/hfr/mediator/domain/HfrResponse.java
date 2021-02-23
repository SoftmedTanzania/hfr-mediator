package tz.go.moh.him.hfr.mediator.domain;

import com.google.gson.annotations.SerializedName;

public class HfrResponse {

    /**
     * The Status Code.
     */
    @SerializedName("Status")
    private int status;

    /**
     * The HFR Facility Code.
     */
    @SerializedName("FacilityCode")
    private String facilityCode;


    /**
     * The Response Message.
     */
    @SerializedName("Message")
    private String message;

    public HfrResponse() {
    }

    public HfrResponse(int status, String facilityCode, String message) {
        this.status = status;
        this.facilityCode = facilityCode;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityCode(String facilityCode) {
        this.facilityCode = facilityCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
