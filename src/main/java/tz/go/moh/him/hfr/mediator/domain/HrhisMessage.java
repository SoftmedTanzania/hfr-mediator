package tz.go.moh.him.hfr.mediator.domain;

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
    private String name;

    /**
     * The code.
     */
    private String code;

    /**
     * The short name.
     */
    private String shortName;

    /**
     * The coordinates.
     */
    private String coordinates;

    /**
     * If the facility is active.
     */
    private boolean active;

    /**
     * The parent.
     */
    private Map<String, Object> parent;

    /**
     * The organizational unit groups.
     */
    private List<Map<String, Object>> organisationUnitGroups;

    /**
     * Initializes a new instance of the {@link HrhisMessage} class.
     */
    public HrhisMessage() {
        this.setParent(new HashMap<>());
        this.setOrganisationUnitGroups(new ArrayList<>());
    }

    /**
     * Initializes a new instance of the {@link HrhisMessage} class.
     *
     * @param name        The name.
     * @param code        The code.
     * @param shortName   The short name.
     * @param coordinates The coordinates.
     * @param active      If the facility is active.
     */
    public HrhisMessage(String name, String code, String shortName, String coordinates, boolean active) {
        this();
        this.setName(name);
        this.setCode(code);
        this.setShortName(shortName);
        this.setCoordinates(coordinates);
        this.setActive(active);
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

    public List<Map<String, Object>> getOrganisationUnitGroups() {
        return organisationUnitGroups;
    }

    public void setOrganisationUnitGroups(List<Map<String, Object>> organisationUnitGroups) {
        this.organisationUnitGroups = organisationUnitGroups;
    }
}
