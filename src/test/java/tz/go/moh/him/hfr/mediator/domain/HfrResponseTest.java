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
 * Contains tests for the {@link HfrResponse} class.
 */
public class HfrResponseTest {
    /**
     * Tests the deserialization of an HFR response.
     */
    @Test
    public void testDeserializeHfrResponse() throws JsonProcessingException {
        InputStream stream = HrhisRequestTest.class.getClassLoader().getResourceAsStream("success_response.json");

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

        HfrResponse hfrResponse = mapper.readValue(data, HfrResponse.class);

        Assert.assertEquals("105651-4", hfrResponse.getFacilityCode());
        Assert.assertEquals(200, hfrResponse.getStatus());
        Assert.assertEquals("Success", hfrResponse.getMessage());
    }

    /**
     * Tests the serialization of an HFR response.
     */
    @Test
    public void testSerializeHfrResponse() throws JsonProcessingException {
        HfrResponse response = new HfrResponse();

        response.setFacilityCode("The facility Code");
        response.setMessage("Success");
        response.setStatus(200);

        ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        String actual = mapper.writeValueAsString(response);

        Assert.assertTrue(actual.contains(response.getFacilityCode()));
        Assert.assertTrue(actual.contains(String.valueOf(response.getStatus())));
        Assert.assertTrue(actual.contains(response.getMessage()));

    }
}