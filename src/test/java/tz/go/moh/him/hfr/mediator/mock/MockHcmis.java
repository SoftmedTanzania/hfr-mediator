package tz.go.moh.him.hfr.mediator.mock;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import org.openhim.mediator.engine.testing.MockHTTPConnector;
import tz.go.moh.him.hfr.mediator.domain.HcmisHfrRequest;
import tz.go.moh.him.hfr.mediator.orchestrator.HcmisOrchestrator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/**
 * Represents a mock destination.
 */
public class MockHcmis extends MockHTTPConnector {

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

        InputStream stream = HcmisOrchestrator.class.getClassLoader().getResourceAsStream("new_facility_request.json");

        Assert.assertNotNull(stream);

        ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        HcmisHfrRequest expected;

        try {
            expected = mapper.readValue(IOUtils.toString(stream), HcmisHfrRequest.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        HcmisHfrRequest actual;
        try {
            actual = new Gson().fromJson(msg.getBody(),HcmisHfrRequest.class);// mapper.readValue(msg.getBody(), HcmisHfrRequest.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assert.assertNotNull(actual);
        Assert.assertNotNull(expected);

        Assert.assertEquals(expected.getVote(), actual.getVote());
        Assert.assertEquals(expected.getIsDesignated(), actual.getIsDesignated());
    }
}
