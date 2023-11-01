package Actor;

import static org.junit.Assert.*;


import static org.junit.Assert.assertEquals;

import Models.Reddit;
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

public class UserActorTest {

    static ActorSystem system;
    ActorRef ref;
    HashMap<String, ArrayList<Reddit>> r = new HashMap<>();
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
        mainArray.add(new Reddit("Author","Title","Post"));
        r.put("one",mainArray);
        ActorRef userActor = system.actorOf(UserActor.props(victim,r), "User-actor");
        ActorRef timerActor = system.actorOf(TimeActor.getProps(), "timeActor");
        // final ObjectNode root = mapper.createObjectNode();

        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode root = factory.objectNode();
        root.put("query", "apple");
        userActor.tell(root, ActorRef.noSender());

        // RegisterMsg greeting = testProbe.expectMsgClass(RegisterMsg.class);
        assertEquals("\"apple\"", root.get("query").toString());
    }

}
