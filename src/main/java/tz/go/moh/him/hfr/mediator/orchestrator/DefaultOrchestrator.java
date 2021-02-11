package tz.go.moh.him.hfr.mediator.orchestrator;

import akka.actor.UntypedActor;
import com.google.gson.Gson;
import org.apache.http.HttpStatus;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.FinishRequest;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import tz.go.moh.him.hfr.mediator.domain.HfrRequest;

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

                finishRequest = new FinishRequest("Success", "text/plain", HttpStatus.SC_OK);
                Gson gson = new Gson();

                // attempt to deserialize the message
                // if this fails, we know the message is in a bad format
                gson.fromJson(((MediatorHTTPRequest) msg).getBody(), HfrRequest.class);
            } catch (Exception e) {
                finishRequest = new FinishRequest("Bad Request", "text/plain", HttpStatus.SC_BAD_REQUEST);
            } finally {
                ((MediatorHTTPRequest) msg).getRequestHandler().tell(finishRequest, getSelf());
            }
        } else {
            unhandled(msg);
        }
    }
}