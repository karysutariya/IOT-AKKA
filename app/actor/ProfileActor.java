package actor;

import Models.Article;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import play.libs.Json;

import java.io.IOException;
import java.util.List;

public class ProfileActor extends AbstractActor {
    private final ActorRef ws;
    public static List<Article> Main_Art;

    /**
     * @author Kary Sutariya
     * @param wsOut is actrofRef
     * @param Main_Art is list of articles of one author
     */
    public ProfileActor(final ActorRef wsOut, final List<Article> Main_Art) {
        ws =  wsOut;
        this.Main_Art = Main_Art;
    }

    /**
     * @author Kary Sutariya
     * @param wsOut is actrofRef
     * @param Main_Art is list of articles of one author
     * @return ProfileActor
     */
    static public Props props(final ActorRef wsOut,  final List<Article> Main_Art) {
        return Props.create(ProfileActor.class, wsOut, Main_Art);
    }

    /**
     * @author Kary Sutariya
     * @param msg is instance of TimeMessage class
     * @throws IOException
     * @throws InterruptedException
     * @throws ParseException
     * @throws NullPointerException
     */
    private void sendTime(TimeMessage msg) {
        final ObjectNode response = Json.newObject();
        JSONObject parameterList = new JSONObject();
        int i = 0;
        for(Article key : msg.message)
        {
            JSONObject parameter = new JSONObject();
            String title = key.get_title();
            String get_subreddit = key.get_subreddit();
            String get_selftext = key.get_selftext();
            String get_post_date = key.get_post_date();
            if (title == null)
            {
                title = "";
            }
            if (get_subreddit == null)
            {
                get_subreddit = "";
            }
            if (get_selftext == null)
            {
                get_selftext = "";
            }
            if (get_post_date == null)
            {
                get_post_date = "";
            }

            parameter.put("date",get_post_date);
            parameter.put("self_text",get_selftext);
            parameter.put("subreddit",get_subreddit);
            parameter.put("title",title);

            parameterList.put(i,parameter);
            i = i +1;

        }

        response.put("time", String.valueOf(parameterList));
        System.out.println("Index"+response);
        ws.tell(response, self());
    }

    static public class TimeMessage {
        public final List<Article> message;

        /**
         * @author Kary Sutariya
         * this is a constructor of the class
         */
        public TimeMessage() {
            message = Main_Art;
        }
    }

    @Override
    public void preStart() {
        context().actorSelection("/user/timeActor/")
                .tell(new TimeActor.RegisterMsg_pro(), self());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(TimeMessage.class, this::sendTime)
                .build();
    }
}
