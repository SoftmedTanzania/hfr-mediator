package tz.go.moh.him.hfr.mediator.utils;

import org.codehaus.plexus.util.StringUtils;
import tz.go.moh.him.hfr.mediator.domain.HfrRequest;
import tz.go.moh.him.hfr.mediator.domain.HrhisMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contains methods to convert HFR messages to alternate formats.
 */
public class HfrMessageConversionUtils {

    /**
     * Converts an {@link HfrRequest} instance to an {@link HrhisMessage} instance.
     *
     * @param hfrRequest The HFR request.
     * @return Returns the converted message.
     */
    public static HrhisMessage convertToHRHISPayload(HfrRequest hfrRequest) {
        HrhisMessage hrhisMessage = new HrhisMessage();
        hrhisMessage.setName(hfrRequest.getName() + " " + hfrRequest.getFacilityType());
        hrhisMessage.setCode(hfrRequest.getFacilityIdNumber());
        hrhisMessage.setShortName(hfrRequest.getName());

        hrhisMessage.setCoordinates("[" + hfrRequest.getLatitude() + "," + hfrRequest.getLongitude() + "]");

        // check for operating using a case insensitive match
        if (hfrRequest.getOperatingStatus() != null && !"".equals(hfrRequest.getOperatingStatus())) {
            hrhisMessage.setActive(hfrRequest.getOperatingStatus().equalsIgnoreCase("Operating"));
        }

        // Adding parent to the payload
        Map<String, Object> parent = new HashMap<String, Object>() {{
            put("code", hfrRequest.getCouncilCode());
        }};

        hrhisMessage.setParent(parent);

        // Adding organisation unit codes
        List<Map<String, Object>> organisationUnitGroups = new ArrayList<Map<String, Object>>();

        // Adding hfr facility type group code
        Map<String, Object> facilityTypeGroupCode = new HashMap<String, Object>() {{
            put("code", hfrRequest.getFacilityTypeGroupCode());
        }};

        organisationUnitGroups.add(facilityTypeGroupCode);

        // Adding hfr facility type code
        Map<String, Object> facilityTypeCode = new HashMap<String, Object>() {{
            put("code", hfrRequest.getFacilityTypeCode());
        }};

        organisationUnitGroups.add(facilityTypeCode);

        // Adding hfr ownership code
        Map<String, Object> ownershipCode = new HashMap<String, Object>() {{
            put("code", hfrRequest.getOwnershipCode());
        }};

        organisationUnitGroups.add(ownershipCode);

        // Adding hfr ownership group code
        Map<String, Object> ownershipGroupCode = new HashMap<String, Object>() {{
            put("code", hfrRequest.getOwnershipGroupCode());
        }};

        //Adding opening date
        if(!StringUtils.isBlank(hfrRequest.getOpenedDate()))
            hrhisMessage.setOpeningDate(hfrRequest.getOpenedDate());

        //Adding closing date
        if(!StringUtils.isBlank(hfrRequest.getClosedDate()))
            hrhisMessage.setClosingDate(hfrRequest.getClosedDate());

        organisationUnitGroups.add(ownershipGroupCode);

        hrhisMessage.setOrganisationUnitGroups(organisationUnitGroups);

        return hrhisMessage;
    }
}
