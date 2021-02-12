package tz.go.moh.him.hfr.mediator.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents an HRHIS message.
 */
public class HrhisMessage {

    /**
     * The name.
     */
    @JsonProperty("name")
    private String name;

    /**
     * The code.
     */
    @JsonProperty("code")
    private String code;

    /**
     * The short name.
     */
    @JsonProperty("shortName")
    private String shortName;

    /**
     * The facility Opening date.
     */
    @JsonProperty("openingDate")
    private String openingDate;

    /**
     * The facility Closed Date.
     */
    @JsonProperty("closingDate")
    private String closingDate;

    /**
     * The coordinates.
     */
    @JsonProperty("coordinates")
    private String coordinates;

    /**
     * If the facility is active.
     */
    @JsonProperty("active")
    private boolean active;

    /**
     * The parent.
     */
    @JsonProperty("parent")
    private Map<String, Object> parent;

    /**
     * The organizational unit groups.
     */
    @JsonProperty("organisationUnitGroups")
    private List<Map<String, Object>> organisationUnitGroups;

    /**
     * Initializes a new instance of the {@link HrhisMessage} class.
     */
    public HrhisMessage() {
        this.setParent(new HashMap<>());
        this.setOrganisationUnitGroups(new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Map<String, Object> getParent() {
        return parent;
    }

    public void setParent(Map<String, Object> parent) {
        this.parent = parent;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    public List<Map<String, Object>> getOrganisationUnitGroups() {
        return organisationUnitGroups;
    }

    public void setOrganisationUnitGroups(List<Map<String, Object>> organisationUnitGroups) {
        this.organisationUnitGroups = organisationUnitGroups;
    }
}
