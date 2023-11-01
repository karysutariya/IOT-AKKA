package controllers;

import Models.*;

import actor.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import play.libs.streams.ActorFlow;
import play.mvc.*;

import views.html.*;

import javax.inject.Inject;
import play.mvc.Http;
import akka.actor.*;
import akka.stream.*;

import java.io.IOException;
import java.util.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Pattern;

import static java.util.Comparator.reverseOrder;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingByConcurrent;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    private final ActorSystem actorSystem;
    private final Materializer materializer;
    public static String search;

    public static HashMap<String, ArrayList<Reddit>> cache = new HashMap<>();
    public static ArrayList<String> queryHistory = new ArrayList<>();

    public static String Pro_Search;
    public static List<Article> Main_Art = new ArrayList<>();
    public static List<Reddit> subArray = new ArrayList<>();
    public static Map<String, Integer> Top_Words = new LinkedHashMap<>();

    @Inject
    public HomeController(ActorSystem actorSystem, Materializer materializer) {
        this.materializer = materializer;
        actorSystem.actorOf(TimeActor.getProps(), "timeActor");
        this.actorSystem = actorSystem;
    }

    /**
     * @author Kary Sutariya
     * @param MSearch it is parameter which is being passed from user via url
     * @return list of reddit search has been returned
     * @throws IOException exception to handle null msearch (input)
     * @throws InterruptedException exception to handle interruption
     * @throws ParseException exception to handle json parsing related exception
     */
    public Result index(Http.Request req, String MSearch)throws IOException, InterruptedException, ParseException,NullPointerException {
        Keysearch keysearch  = new Keysearch();
        cache = keysearch.getSearchResult(MSearch,cache);
        queryHistory = new ArrayList<>(cache.keySet());
        return ok(index.render(req,MSearch,cache));
    }


    /**
     * @author Kary Sutariya
     * @param search it is parameter which is being passed from profile
     * @return it returns API Call
     * @throws IOException exception to handle null search (input)
     * @throws InterruptedException exception to handle interruption
     */
    public  HttpResponse<String> setprofilemethod(String search) throws IOException, InterruptedException {

        var url = "https://www.reddit.com/user/"+search+"/about.json";
        var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        var client = HttpClient.newBuilder().build();
        var response0= client.send(request, HttpResponse.BodyHandlers.ofString());

        return response0;
    }

    /**
     * @author Kary Sutariya
     * @param search it is parameter which is being passed from user via url
     * @return search, labels and art have been rendered to profile.scala.html
     * @throws IOException exception to handle null search (input)
     * @throws InterruptedException exception to handle interruption
     * @throws ParseException exception to handle json parsing related exception
     */
    public Result profile(Http.Request req,String search) throws  IOException, InterruptedException, ParseException {
        Pro_Search = search;
        List<User> labels = new ArrayList<>();
        HttpResponse<String> resultCall1 =setprofilemethod(search);
        Object obj = new JSONParser().parse(String.valueOf(resultCall1.body()));
        JSONObject test = (JSONObject) obj;
        var data = (JSONObject) test.get("data");
        var name =  data.get("name");
        var created_utc =  Double.parseDouble(data.get("created_utc").toString());
        long created_utc_date = (new Double(created_utc)).longValue();
        var date = new java.text.SimpleDateFormat("EEEEE dd MMMMM yyyy HH:mm:ss.SSSZ").format(new java.util.Date (created_utc_date*1000));

        var total_karma =  data.get("total_karma");
        var verified_user =  data.get("verified");

        var subreddit_auth =  (JSONObject) data.get("subreddit");
        var subscribers =  subreddit_auth.get("subscribers");
        var user_url = "https://www.reddit.com"+ subreddit_auth.get("url").toString();
        var display_name = subreddit_auth.get("display_name");

        labels.add(new User(name.toString(),display_name.toString(),verified_user.toString(),user_url,subscribers.toString(),date,total_karma.toString()));
        ProfileSearch profileSearch = new ProfileSearch();
        Main_Art = profileSearch.getUserArticle(search);
        return ok(profile.render(req, search, labels, Main_Art));
    }

    /**
     * @author Bhargav Yagnik
     * @param subredditId The reddit id of the post to be linked
     * @return search, labels and art have been rendered to subreddit.scala.html
     * @throws IOException exception to handle null search (input)
     * @throws InterruptedException exception to handle interruption
     * @throws ParseException exception to handle json parsing related exception
     */
    public Result searchsubreddit(Http.Request req,String subredditId)  throws IOException, InterruptedException, ParseException{
        SubredditSearch subredditSearch = new SubredditSearch();
        subArray  = subredditSearch.getSubredditSearch(subredditId);
        return ok(subreddit.render(req,subredditId,subArray));
    }
    /**
     * @author Ornela Bregu
     * @param msearch The search query keywords
     * @return Top words list and array of word count that have been rendered to stats.scala.html
     * @throws IOException exception to handle null search (input)
     * @throws InterruptedException exception to handle interruption
     * @throws ParseException exception to handle json parsing related exception
     */
    public Result wordStats(Http.Request req,String msearch)throws IOException, InterruptedException, ParseException {
//        String temp = msearch;
        Map<String, Integer> Words = new LinkedHashMap<>();
        Map<String, Long> wordCount = new HashMap<>();
        String[] stopwords = {"before", "_", "https", "reddit", "must", "would", "could", "around", "really", "haven't", "me", "need", "you", "that", "do", "s", "i", "how", "if", "with", "having", "not", "too", "being", "might", "she's", "don't", "about", "should", "does", "is", "but", "weren't", "was", "couldn't", "we", "isn't", "ain", "who", "to", "after", "until", "you'd", "our", "aren't", "those", "this", "its", "yourselves", "been", "they", "what", "the", "all", "hers", "yours", "m", "his", "it's", "hasn't", "himself", "it", "did", "during", "him", "her", "each", "myself", "be", "once", "y", "doesn't", "at", "such", "that'll", "then", "mightn", "itself", "ma", "of", "these", "shan", "few", "didn't", "doesn't", "whom", "very", "you'll", "should've", "shouldn't", "shan't", "has", "wouldn", "d", "are", "an", "am", "up", "own", "aren't", "some", "she", "their", "off", "were", "wouldn't", "into", "don't", "didn't", "down", "for", "ll", "a", "yourself", "only", "same", "there", "theirs", "he", "below", "most", "haven't", "isn't", "than", "them", "mustn't", "in", "hadn", "against", "by", "ourselves", "now", "wasn", "when", "themselves", "will", "ours", "had", "any", "ve", "above", "which", "why", "wasn't", "won", "o", "through", "on", "your", "herself", "re", "have", "and", "can", "doing", "you're", "so", "between", "no", "both", "from", "out", "more", "as", "weren't", "over", "here", "just", "or", "hadn't", "needn't'", "where", "you've", "shouldn't", "other", "again", "because", "further", "my", "hasn't", "nor", "t", "under", "couldn't", "won't", "while"};
        if (msearch == (null) || msearch.equals("")) {
            /*TODO*/
        } else {
            String msearch1 = msearch.replace(" ", "%20");
            var url = "https://api.pushshift.io/reddit/search/submission/?q="+msearch+"&sort=desc&size=200";
            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            var client = HttpClient.newBuilder().build();
            HttpResponse<String> resp = client.send(request, HttpResponse.BodyHandlers.ofString());

            Object obj = new JSONParser().parse(String.valueOf(resp.body()));
//            String url = "https://api.pushshift.io/reddit/search/submission/?q=" + msearch1 + "&sort=desc&size=100";
//            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
//            var client = HttpClient.newBuilder().build();
//            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            Object obj = new JSONParser().parse(String.valueOf(response.body()));
            JSONObject test = (JSONObject) obj;
            var data = (JSONArray) test.get("data");
            var length = data.size();
            System.out.println(data.size());
            String s = new String();
            for (int i = 0; i < length; i++) {
                var topic = (JSONObject) data.get(i);
                var selftext = topic.get("selftext");
                s = s + selftext.toString();
            }
            for (String word : stopwords) {
                s = s.replaceAll("\\b" + word + "\\b", " ");
                s = s.replaceAll("\\b\\w{1,4}\\b\\s?", "");
                s = s.replaceAll("\\b\\w{9,100}\\b\\s?", "");
            }




            /*s=s.replaceAll("[^A-Z]"," ");*/
            try {
                wordCount = Pattern.compile("\\W+").splitAsStream((String) s).parallel().map(String::toLowerCase).collect(groupingByConcurrent(identity(), counting()));
//                System.out.println("Words found" + wordCount);
//                Pattern.compile("\\W+").splitAsStream((String) s).parallel().map(String::toLowerCase).collect(collectingAndThen(groupingByConcurrent(identity(), counting()), map -> map.entrySet().stream().sorted(Map.Entry.comparingByValue(reverseOrder())).limit(20))).forEachOrdered(System.out::println);



                wordCount.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(reverseOrder())).limit(20)
                        .forEachOrdered(x -> Words.put(x.getKey(), Math.toIntExact(x.getValue())));
//                for (int j = 0; j < 10; j++) {
                System.out.println("*********" + Words.values());
                System.out.println("*********" + Words);

//            }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Top_Words=Words;
        return ok(stats.render(req,Words, wordCount));
    }

    public WebSocket ws() {
        return WebSocket.Json.accept((request) -> ActorFlow.actorRef(req -> UserActor.props(req, cache), actorSystem, materializer));
    }

    public WebSocket ws2() {
        return WebSocket.Json.accept((request) -> ActorFlow.actorRef(req -> ProfileActor.props(req,Main_Art), actorSystem, materializer));
    }
    public WebSocket ws3() {
        return WebSocket.Json.accept((request) -> ActorFlow.actorRef(req -> SubredditActor.props(req,subArray), actorSystem, materializer));
    }
    public WebSocket ws4() {
        return WebSocket.Json.accept((request) -> ActorFlow.actorRef(req -> StatsActor.props(req,Top_Words), actorSystem, materializer));
    }
}
