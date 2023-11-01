package Actor;

import static org.junit.Assert.*;


import static org.junit.Assert.assertEquals;

import Models.Reddit;
import actor.SubredditActor;
import actor.TimeActor;
import actor.UserActor;
import akka.actor.Props;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;

import java.util.*;

public class SubredditActorTest {

    static ActorSystem system;
    ActorRef ref;
    public static List<Reddit> subArr;

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
        ActorRef statActor = system.actorOf(SubredditActor.props(victim,subArr), "Subreddit-actor");
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
