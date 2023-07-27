package tz.go.moh.him.hfr.mediator.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a Health Facility Registry request message.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HrhisHfrRequest extends HfrRequest {
    @JsonProperty("Village_Code")
    private String villageCode;

    public String getVillageCode() {
        return villageCode;
    }

    public void setVillageCode(String villageCode) {
        this.villageCode = villageCode;
    }
}
