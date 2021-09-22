package tz.go.moh.him.hfr.mediator.mock;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import org.openhim.mediator.engine.testing.MockHTTPConnector;
import tz.go.moh.him.hfr.mediator.domain.HfrRequest;
import tz.go.moh.him.hfr.mediator.domain.MessageOperation;
import tz.go.moh.him.hfr.mediator.orchestrator.FacilityOrchestratorTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/**
 * Represents a mock destination.
 */
public class MockAfyaSS extends MockHTTPConnector {

    /**
     * Gets the response.
     *
     * @return Returns the response.
     */
    @Override
    public String getResponse() {
        return null;
    }

    /**
     * Gets the status code.
     *
     * @return Returns the status code.
     */
    @Override
    public Integer getStatus() {
        return 200;
    }

    /**
     * Gets the HTTP headers.
     *
     * @return Returns the HTTP headers.
     */
    @Override
    public Map<String, String> getHeaders() {
        return Collections.emptyMap();
    }

    /**
     * Handles the message.
     *
     * @param msg The message.
     */
    @Override
    public void executeOnReceive(MediatorHTTPRequest msg) {

        InputStream stream = FacilityOrchestratorTest.class.getClassLoader().getResourceAsStream("new_facility_request.json");

        Assert.assertNotNull(stream);

        ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        HfrRequest actual = null;
        try {
            actual = mapper.readValue(msg.getBody(), HfrRequest.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        HfrRequest expected = null;
        try {
            expected = mapper.readValue(IOUtils.toString(stream), HfrRequest.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (actual.getPostOrUpdate() == MessageOperation.Post) {
            Assert.assertEquals("POST", msg.getMethod());
        } else {
            Assert.assertEquals("PUT", msg.getMethod());
        }


        Assert.assertNotNull(expected);
        Assert.assertNotNull(actual);

        Assert.assertEquals(expected.getCommonFacilityName(), actual.getCommonFacilityName());
        Assert.assertEquals(expected.getFacilityIdNumber(), actual.getFacilityIdNumber());
        Assert.assertEquals(expected.getCouncil(), actual.getCouncil());
        Assert.assertEquals(expected.getCouncilCode(), actual.getCouncilCode());
        Assert.assertEquals(expected.getDistrict(), actual.getDistrict());
        Assert.assertEquals(expected.getFacilityType(), actual.getFacilityType());
        Assert.assertEquals(expected.getCreatedAt(), actual.getCreatedAt());
    }
}
