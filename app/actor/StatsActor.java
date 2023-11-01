package actor;

import Models.Article;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import play.libs.Json;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StatsActor extends AbstractActor {
    private final ActorRef ws;
    public static Map<String, Integer> Top_Words;

    /**
     * @author ornela
     * @param wsOut is actrofRef
     * @param Top_Words is map of top word
     */
    public StatsActor(final ActorRef wsOut, final Map<String, Integer> Top_Words) {
        this.ws =  wsOut;
        this.Top_Words = Top_Words;
    }

    /**
     * @author ornela
     * @param wsOut is actrofRef
     * @param Top_Words is map of top word
     * @return StatsActor
     */
    public static Props props(final ActorRef wsOut,  final Map<String, Integer> Top_Words) {
        return Props.create(StatsActor.class, wsOut, Top_Words);
    }

    /**
     * @author ornela
     * @param msg is instance of TimeMessage class
     */
    private void sendTime(TimeMessage msg) {
        final ObjectNode response = Json.newObject();
        System.out.println("Stats Actor called");
        response.put("time", String.valueOf(Top_Words));
        ws.tell(response, self());
    }

    public static class TimeMessage {
        public final Map<String, Integer> message;
        public TimeMessage() {
            message = Top_Words;
        }
    }

    @Override
    public void preStart() {
        context().actorSelection("/user/timeActor/")
                .tell(new TimeActor.RegisterMsg_stats(), self());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(TimeMessage.class, this::sendTime)
                .build();
    }
}
