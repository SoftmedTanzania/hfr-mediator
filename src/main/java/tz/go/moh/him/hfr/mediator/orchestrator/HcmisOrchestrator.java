package tz.go.moh.him.hfr.mediator.orchestrator;

import akka.actor.ActorRef;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.lang3.tuple.Pair;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import tz.go.moh.him.hfr.mediator.domain.HcmisHfrRequest;

import java.util.List;
import java.util.Map;

/**
 * Represents a facility orchestrator.
 */
public class HcmisOrchestrator extends FacilityOrchestrator {

    /**
     * Initializes a new instance of the {@link FacilityOrchestrator} class.
     *
     * @param config The mediator configuration.
     */
    public HcmisOrchestrator(MediatorConfig config) {
        super(config);
    }

    @Override
    public MediatorHTTPRequest generateRequest(ActorRef requestHandler, String host, Map<String, String> headers, List<Pair<String, String>> parameters, String body) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        HcmisHfrRequest hcmisHfrRequest = mapper.readValue(workingRequest.getBody(), HcmisHfrRequest.class);

        return new MediatorHTTPRequest(requestHandler, getSelf(), host, "POST",
                host, new Gson().toJson(hcmisHfrRequest), headers, parameters);
    }
}