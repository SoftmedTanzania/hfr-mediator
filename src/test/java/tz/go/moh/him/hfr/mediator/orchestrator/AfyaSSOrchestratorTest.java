package tz.go.moh.him.hfr.mediator.orchestrator;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.testkit.JavaTestKit;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openhim.mediator.engine.messages.FinishRequest;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import org.openhim.mediator.engine.testing.MockLauncher;
import org.openhim.mediator.engine.testing.TestingUtils;
import tz.go.moh.him.hfr.mediator.mock.MockAfyaSS;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Contains tests for the {@link AfyaSSOrchestrator} class.
 */
public class AfyaSSOrchestratorTest extends BaseOrchestratorTest {

    /**
     * Runs initialization before each test execution.
     */
    @Before
    public void before() {
        List<MockLauncher.ActorToLaunch> actorsToLaunch = new LinkedList<>();

        actorsToLaunch.add(new MockLauncher.ActorToLaunch("http-connector", MockAfyaSS.class));

        TestingUtils.launchActors(system, configuration.getName(), actorsToLaunch);
    }

    /**
     * Tests the mediator.
     *
     * @throws Exception if an exception occurs.
     */
    @Test
    public void testNewFacilityHfrRequest() throws Exception {
        Assert.assertNotNull(system);
        new JavaTestKit(system) {{
            final ActorRef orchestrator = system.actorOf(Props.create(AfyaSSOrchestrator.class, configuration));

            InputStream stream = AfyaSSOrchestratorTest.class.getClassLoader().getResourceAsStream("new_facility_request.json");

            Assert.assertNotNull(stream);

            MediatorHTTPRequest request = new MediatorHTTPRequest(
                    getRef(),
                    getRef(),
                    "unit-test",
                    "POST",
                    "http",
                    null,
                    null,
                    "/hfr",
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

            Assert.assertTrue(Arrays.stream(out).anyMatch(c -> c instanceof FinishRequest));
        }};
    }


    /**
     * Tests the mediator.
     *
     * @throws Exception if an exception occurs.
     */
    @Test
    public void testUpdateFacilityHfrRequest() throws Exception {
        Assert.assertNotNull(system);
        new JavaTestKit(system) {{
            final ActorRef orchestrator = system.actorOf(Props.create(AfyaSSOrchestrator.class, configuration));

            InputStream stream = AfyaSSOrchestratorTest.class.getClassLoader().getResourceAsStream("update_facility_request.json");

            Assert.assertNotNull(stream);

            MediatorHTTPRequest request = new MediatorHTTPRequest(
                    getRef(),
                    getRef(),
                    "unit-test",
                    "POST",
                    "http",
                    null,
                    null,
                    "/hfr",
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

            Assert.assertTrue(Arrays.stream(out).anyMatch(c -> c instanceof FinishRequest));
        }};
    }
}