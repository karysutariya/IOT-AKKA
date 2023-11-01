package actor;

import Models.Reddit;
import Models.SubredditSearch;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import play.libs.Json;

import java.io.IOException;
import java.util.List;

public class SubredditActor extends AbstractActor {
    private final ActorRef ws;
    public static List<Reddit> subArr;

    /**
     * @author bhargav
     * @param ws is actrofRef
     * @param subArr is information of particular subbreddit
     */
    public SubredditActor(final ActorRef ws, final List<Reddit> subArr) {
        this.ws = ws;
        this.subArr = subArr;
    }

    /**
     * @author bhargav
     * @param ws is actrofRef
     * @param subArr is information of particular subbreddit
     * @return SubredditActor
     */
    static public Props props(final ActorRef ws, final List<Reddit> subArr) {
        return  Props.create(SubredditActor.class, ws, subArr);
    }

    /**
     * @author bhargav
     * @param msg is instance of TimeMessage class
     * @throws IOException
     * @throws InterruptedException
     * @throws ParseException
     * @throws NullPointerException
     */
    private void sendTime(TimeMessage msg) throws IOException, InterruptedException, ParseException,NullPointerException{
        System.out.println("Actor called");
        final ObjectNode response = Json.newObject();
        SubredditSearch subredditSearch = new SubredditSearch();
        subArr = subredditSearch.getSubredditSearch(msg.message.get(0).getReddit());

        JSONObject parameterList = new JSONObject();
        int count = 0;
        for (Reddit j : subArr )
        {
            JSONObject parameter = new JSONObject();
            parameter.put("author", j.author);
            parameter.put("title", j.title);
            parameter.put("reddit", j.reddit);

            parameterList.put(count,parameter);
            count++;
        }
        response.put("subreddit",String.valueOf(parameterList));
        System.out.println("Subreddit"+response);
        ws.tell(response, self());
    }
    static public class TimeMessage {
        public final List<Reddit> message;
        /**
         * @author bhargav
         * this is a constructor of the class
         */
        public TimeMessage() {
            message = subArr;
        }
    }

    @Override
    public void preStart() {
        context().actorSelection("/user/timeActor/")
                .tell(new TimeActor.RegisterMsg_sub(), self());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(TimeMessage.class, this::sendTime)
                .build();
    }
}
