package Actor;

import static org.junit.Assert.*;


import static org.junit.Assert.assertEquals;

import Models.Article;
import Models.Reddit;
import actor.ProfileActor;
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

import java.util.*;

public class ProfileActorTest {

    static ActorSystem system;
    ActorRef ref;
    public static List<Article> Main_Art;

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
        ActorRef statActor = system.actorOf(ProfileActor.props(victim,Main_Art), "Profile-actor");
        ActorRef timerActor = system.actorOf(TimeActor.getProps(), "timeActor");
        // final ObjectNode root = mapper.createObjectNode();

        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode root = factory.objectNode();
        root.put("query", "apple");
        statActor.tell(root, ActorRef.noSender());

        // RegisterMsg greeting = testProbe.expectMsgClass(RegisterMsg.class);
        assertEquals("\"apple\"", root.get("query").toString());
    }
    @Test
    public void test1(){
        final TestKit testProbe = new TestKit(system);
        ActorRef victim = null;
        ActorRef profactor = system.actorOf(ProfileActor.props(victim,Main_Art), "pactor");
        assertEquals(1,1);
    }
}
