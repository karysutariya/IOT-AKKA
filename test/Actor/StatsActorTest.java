package Actor;

import static org.junit.Assert.*;


import static org.junit.Assert.assertEquals;

import Models.Reddit;
import actor.StatsActor;
import actor.TimeActor;
import actor.UserActor;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StatsActorTest {

    static ActorSystem system;
    ActorRef ref;
    public static Map<String, Integer> Top_Words = new LinkedHashMap<>();
    ArrayList<Reddit> mainArray = new ArrayList<>();


    @BeforeClass
    public static void setup() {
        system = ActorSystem.create();
    }

    @AfterClass
    public static void teardown() {
        TestKit.shutdownActorSystem(system);
        system = null;
    }

    @Test
    public void test() {
        final TestKit testProbe = new TestKit(system);
        ActorRef victim = null;
        ActorRef statActor = system.actorOf(StatsActor.props(victim,Top_Words), "Stats-actor");
        ActorRef timerActor = system.actorOf(TimeActor.getProps(), "timeActor");
        // final ObjectNode root = mapper.createObjectNode();

        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode root = factory.objectNode();
        root.put("query", "apple");
        statActor.tell(root, ActorRef.noSender());

        // RegisterMsg greeting = testProbe.expectMsgClass(RegisterMsg.class);
        assertEquals("\"apple\"", root.get("query").toString());
    }

}
