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
 * Contains tests for the {@link HcmisHfrRequest} class.
 */
public class HcmisHfrRequestTest {

    /**
     * Tests the deserialization of an HFR request.
     */
    @Test
    public void testDeserializeHfrRequest() throws JsonProcessingException {
        InputStream stream = HcmisHfrRequestTest.class.getClassLoader().getResourceAsStream("new_facility_request.json");

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

        HcmisHfrRequest hcmisHfrRequest = mapper.readValue(data, HcmisHfrRequest.class);

        Assert.assertEquals("TZ.ET.DS.IL.2", hcmisHfrRequest.getVote());
        Assert.assertEquals(0, hcmisHfrRequest.getIsDesignated());
    }

    /**
     * Tests the serialization of an HFR request.
     */
    @Test
    public void testSerializeHfrRequest() throws JsonProcessingException {
        HcmisHfrRequest request = new HcmisHfrRequest();

        request.setVote("2021-01-01");
        request.setIsDesignated(7);

        ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        String actual = mapper.writeValueAsString(request);

        System.out.println(actual);

        Assert.assertTrue(actual.contains(request.getVote()));
        Assert.assertTrue(actual.contains(String.valueOf(request.getIsDesignated())));

    }
}
