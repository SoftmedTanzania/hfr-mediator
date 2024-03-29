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
public class HrhisRequestTest {

    /**
     * Tests the deserialization of an HFR request.
     */
    @Test
    public void testDeserializeHfrRequest() throws JsonProcessingException {
        InputStream stream = HrhisRequestTest.class.getClassLoader().getResourceAsStream("new_facility_request.json");

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

        HrhisHfrRequest hfrRequest = mapper.readValue(data, HrhisHfrRequest.class);

        Assert.assertEquals("TZ.ET.DS.IL.2.2", hfrRequest.getVillageCode());
    }

    /**
     * Tests the serialization of an HFR request.
     */
    @Test
    public void testSerializeHfrRequest() throws JsonProcessingException {
        HrhisHfrRequest request = new HrhisHfrRequest();

        request.setVillageCode("Test Village Code");

        ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        String actual = mapper.writeValueAsString(request);

        Assert.assertTrue(actual.contains(request.getVillageCode()));
    }
}
