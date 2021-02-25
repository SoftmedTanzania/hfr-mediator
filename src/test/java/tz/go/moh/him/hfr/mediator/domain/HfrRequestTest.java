package tz.go.moh.him.hfr.mediator.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Contains tests for the {@link HfrRequest} class.
 */
public class HfrRequestTest {

    /**
     * Tests the deserialization of an HFR request.
     */
    @Test
    public void testDeserializeHfrRequest() throws JsonProcessingException {
        InputStream stream = HfrRequestTest.class.getClassLoader().getResourceAsStream("request.json");

        Assert.assertNotNull(stream);

        String data;

        try {
            data = IOUtils.toString(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assert.assertNotNull(data);

        ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        HfrRequest hfrRequest = mapper.readValue(data, HfrRequest.class);

        Assert.assertEquals("105651-4", hfrRequest.getFacilityIdNumber());
        Assert.assertEquals("Muhimbili", hfrRequest.getName());
        Assert.assertEquals("Muhimbili", hfrRequest.getCommonFacilityName());
        Assert.assertEquals("Eastern Zone", hfrRequest.getZone());
        Assert.assertEquals("Mfaume", hfrRequest.getVillage());
        Assert.assertEquals("Upanga Magharibi", hfrRequest.getWard());
        Assert.assertEquals("Ilala MC", hfrRequest.getCouncil());
        Assert.assertEquals("-6.801501", hfrRequest.getLatitude());
        Assert.assertEquals("2017-10-27T05:54:48.000Z", hfrRequest.getUpdatedAt());
    }

    /**
     * Tests the serialization of an HFR request.
     */
    @Test
    public void testSerializeHfrRequest() throws JsonProcessingException {
        HfrRequest request = new HfrRequest();

        request.setClosedDate("2021-01-01");
        request.setCommonFacilityName("Test Facility");
        request.setCouncil("Test Council");
        request.setCouncilCode("Test Council Code");
        request.setCreatedAt("2017-10-27T05:54:48.000Z");
        request.setDistrict("Test District");
        request.setDistrictCode("Test District Code");
        request.setFacilityIdNumber("12345");
        request.setFacilityType("Test Facility Type");
        request.setFacilityTypeCode("Test Facility Type Code");
        request.setFacilityTypeGroup("Test Facility Type Group");
        request.setFacilityTypeGroupCode("Test Facility Type Group Code");
        request.setLatitude("-6.801501");
        request.setLongitude("39.274157");
        request.setName("Test Facility Name");
        request.setOpenedDate("1985-01-01");
        request.setOperatingStatus("Operating");
        request.setOperatingStatusChangeClosedToOperational("N");
        request.setOperatingStatusChangeOpenToClosed("N");
        request.setOwnership("Test Ownership");
        request.setOwnershipCode("Test Ownership Code");
        request.setOwnershipGroup("Test Ownership Group");
        request.setOwnershipGroupCode("Test Ownership Group Code");
        request.setPostOrUpdate(MessageOperation.Post);
        request.setRegion("Test Region");
        request.setRegionCode("Test Region Code");
        request.setRegistrationStatus("Registered");
        request.setUpdatedAt("2017-10-28T05:54:48.000Z");
        request.setVillage("Test Village Name");
        request.setWard("Test Ward");
        request.setVillage("Test Village");
        request.setZone("Test Zone");

        ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        String actual = mapper.writeValueAsString(request);

        System.out.println(actual);

        Assert.assertTrue(actual.contains(request.getClosedDate()));
        Assert.assertTrue(actual.contains(request.getCommonFacilityName()));
        Assert.assertTrue(actual.contains(request.getCouncil()));
        Assert.assertTrue(actual.contains(request.getCouncilCode()));
        Assert.assertTrue(actual.contains(request.getCreatedAt()));
        Assert.assertTrue(actual.contains(request.getDistrict()));
        Assert.assertTrue(actual.contains(request.getDistrictCode()));
        Assert.assertTrue(actual.contains(request.getFacilityIdNumber()));
        Assert.assertTrue(actual.contains(request.getFacilityType()));
        Assert.assertTrue(actual.contains(request.getFacilityTypeCode()));
        Assert.assertTrue(actual.contains(request.getFacilityTypeGroup()));
        Assert.assertTrue(actual.contains(request.getFacilityTypeGroupCode()));
        Assert.assertTrue(actual.contains(request.getLatitude()));
        Assert.assertTrue(actual.contains(request.getLongitude()));
        Assert.assertTrue(actual.contains(request.getName()));
        Assert.assertTrue(actual.contains(request.getOpenedDate()));
        Assert.assertTrue(actual.contains(request.getOperatingStatus()));
        Assert.assertTrue(actual.contains(request.getOperatingStatusChangeClosedToOperational()));
        Assert.assertTrue(actual.contains(request.getOperatingStatusChangeOpenToClosed()));
        Assert.assertTrue(actual.contains(request.getOperatingStatusChangeOpenToClosed()));
        Assert.assertTrue(actual.contains(request.getOwnership()));
        Assert.assertTrue(actual.contains(request.getOwnershipCode()));
        Assert.assertTrue(actual.contains(request.getOwnershipGroup()));
        Assert.assertTrue(actual.contains(request.getOwnershipGroupCode()));
        Assert.assertTrue(actual.contains(request.getPostOrUpdate().getOperation()));
        Assert.assertTrue(actual.contains(request.getRegion()));
        Assert.assertTrue(actual.contains(request.getRegionCode()));
        Assert.assertTrue(actual.contains(request.getRegistrationStatus()));
        Assert.assertTrue(actual.contains(request.getUpdatedAt()));
        Assert.assertTrue(actual.contains(request.getVillage()));
        Assert.assertTrue(actual.contains(request.getWard()));
        Assert.assertTrue(actual.contains(request.getZone()));
    }
}
