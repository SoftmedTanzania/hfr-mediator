package tz.go.moh.him.hfr.mediator.orchestrator;

import akka.actor.UntypedActor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.http.HttpStatus;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.FinishRequest;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import tz.go.moh.him.hfr.mediator.domain.HfrRequest;
import tz.go.moh.him.hfr.mediator.domain.HfrResponse;

/**
 * Represents a default orchestrator.
 */
public class DefaultOrchestrator extends UntypedActor {

    /**
     * Initializes a new instance of the {@link DefaultOrchestrator} class.
     *
     * @param config The configuration.
     */
    public DefaultOrchestrator(@SuppressWarnings("unused") MediatorConfig config) {
    }

    /**
     * Handles the received message.
     *
     * @param msg The received message.
     */
    @Override
    public void onReceive(Object msg) {
        if (msg instanceof MediatorHTTPRequest) {
            FinishRequest finishRequest = null;
            try {
                ObjectMapper mapper = new ObjectMapper();

                HfrRequest hfrRequest = mapper.readValue(((MediatorHTTPRequest) msg).getBody(), HfrRequest.class);

                HfrResponse hfrResponse = new HfrResponse(HttpStatus.SC_OK, hfrRequest.getFacilityIdNumber(), "Success");

                finishRequest = new FinishRequest(new Gson().toJson(hfrResponse), "text/json", HttpStatus.SC_OK);
            } catch (Exception e) {
                HfrResponse hfrResponse = new HfrResponse(HttpStatus.SC_BAD_REQUEST, null, "Failed");
                finishRequest = new FinishRequest(new Gson().toJson(hfrResponse), "text/json", HttpStatus.SC_BAD_REQUEST);
            } finally {
                ((MediatorHTTPRequest) msg).getRequestHandler().tell(finishRequest, getSelf());
            }
        } else {
            unhandled(msg);
        }
    }
}