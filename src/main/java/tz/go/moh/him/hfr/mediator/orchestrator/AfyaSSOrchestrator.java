package tz.go.moh.him.hfr.mediator.orchestrator;

import akka.actor.ActorRef;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.tuple.Pair;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import tz.go.moh.him.hfr.mediator.domain.HfrRequest;
import tz.go.moh.him.hfr.mediator.domain.MessageOperation;

import java.util.List;
import java.util.Map;

/**
 * Represents a facility orchestrator.
 */
public class AfyaSSOrchestrator extends FacilityOrchestrator {

    /**
     * Initializes a new instance of the {@link FacilityOrchestrator} class.
     *
     * @param config The mediator configuration.
     */
    public AfyaSSOrchestrator(MediatorConfig config) {
        super(config);
    }

    @Override
    public MediatorHTTPRequest generateRequest(ActorRef requestHandler, String host, Map<String, String> headers, List<Pair<String, String>> parameters, String body) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        HfrRequest hfrRequest = mapper.readValue(workingRequest.getBody(), HfrRequest.class);

        String method;

        if (hfrRequest.getPostOrUpdate() == MessageOperation.Post) {
            method = "POST";
        } else {
            method = "PUT";
        }
        return new MediatorHTTPRequest(requestHandler, getSelf(), host, method,
                host, body, headers, parameters, body);
    }
}
