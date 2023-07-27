package tz.go.moh.him.hfr.mediator.orchestrator;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.testkit.JavaTestKit;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openhim.mediator.engine.messages.FinishRequest;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;

import java.io.InputStream;
import java.util.Collections;

/**
 * Contains tests for the {@link DefaultOrchestrator} class.
 */
public class DefaultOrchestratorTest extends BaseOrchestratorTest {

    private final ActorRef orchestrator = system.actorOf(Props.create(DefaultOrchestrator.class, configuration));

    /**
     * Tests the mediator.
     *
     * @throws Exception if an exception occurs
     */
    @Test
    public void testHfrRequest() throws Exception {
        new JavaTestKit(system) {{

            InputStream stream = DefaultOrchestratorTest.class.getClassLoader().getResourceAsStream("new_facility_request.json");

            Assert.assertNotNull(stream);

            MediatorHTTPRequest request = new MediatorHTTPRequest(
                    getRef(),
                    getRef(),
                    "unit-test",
                    "POST",
                    "http",
                    null,
                    null,
                    "/hfr-inbound",
                    IOUtils.toString(stream),
                    Collections.singletonMap("Content-Type", "application/json"),
                    Collections.emptyList()
            );

            orchestrator.tell(request, getRef());

            final Object[] out = new ReceiveWhile<Object>(Object.class, duration("3 seconds")) {
                @Override
                protected Object match(Object msg) {
                    return msg;
                }
            }.get();

            InputStream responseStream = DefaultOrchestratorTest.class.getClassLoader().getResourceAsStream("success_response.json");
            String expectedResponse = IOUtils.toString(responseStream);

            JsonParser parser = new JsonParser();


            Object object = out[1];
            Assert.assertTrue((object instanceof FinishRequest) && parser.parse(expectedResponse).equals(parser.parse(((FinishRequest) object).getResponse())));
        }};
    }
}