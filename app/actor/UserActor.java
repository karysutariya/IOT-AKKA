package actor;

import Models.Keysearch;
import Models.Reddit;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import com.fasterxml.jackson.databind.node.ObjectNode;
import controllers.HomeController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import play.libs.Json;

import javax.naming.ldap.Control;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;

public class UserActor extends AbstractActor {
    private final ActorRef ws;
    public static HashMap<String, ArrayList<Reddit>> cache;

    /**
     * @author Kary Sutariya
     * @param wsOut is actrofRef
     * @param cache is list of reddit from same category
     */
    public UserActor(final ActorRef wsOut, final HashMap<String, ArrayList<Reddit>> cache) {
        this.ws =  wsOut;
        this.cache = cache;
    }

    /**
     * @author Kary Sutariya
     * @param wsOut is actrofRef
     * @param cache is list of reddit from same category
     * @return UserActor
     */
    static public Props props(final ActorRef wsOut, final HashMap<String, ArrayList<Reddit>> cache) {
        return Props.create(UserActor.class, wsOut, cache);
    }

    /**
     * @author Kary Sutariya
     * @param msg is instance of TimeMessage class
     * @throws IOException
     * @throws InterruptedException
     * @throws ParseException
     * @throws NullPointerException
     */
    private void sendTime(TimeMessage msg) throws IOException, InterruptedException, ParseException,NullPointerException{
        final ObjectNode response = Json.newObject();
        for(String key : cache.keySet())
        {
            Keysearch keysearch  = new Keysearch();
            cache = keysearch.getSearchResult(key,cache);

            JSONObject parameterList = new JSONObject();
            int count = 0;
            for (Reddit j : cache.get(key))
            {
                JSONObject parameter = new JSONObject();
                parameter.put("author", j.author);
                parameter.put("title", j.title);
                parameter.put("reddit", j.reddit);

                parameterList.put(count,parameter);

                count++;
            }
            response.put(key, String.valueOf(parameterList));
        }
        System.out.println("User"+response);
        ws.tell(response, self());
    }


    static public class TimeMessage {
        public final HashMap<String, ArrayList<Reddit>> message;

        /**
         * @author Kary Sutariya
         * this is a constructor of the class
         */
        public TimeMessage() {
            this.message = cache;
        }
    }

    @Override
    public void preStart() {
        context().actorSelection("/user/timeActor/")
                .tell(new TimeActor.RegisterMsg(), self());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(TimeMessage.class, this::sendTime)
                .build();
    }
}
