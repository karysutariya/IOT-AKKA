package Models;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ProfileSearch {

    /**
     * @author Kary Sutariya
     * @param search it is parameter which is being passed from profile
     * @return it returns response of API call
     * @throws IOException exception to handle null search (input)
     * @throws InterruptedException exception to handle interruption
     * @throws ParseException exception to handle json parsing related exception
     */
    public HttpResponse<String> setpostmethod(String search) throws IOException, InterruptedException, ParseException {

        var url1 = "https://www.reddit.com/user/"+search+"/submitted/about.json";
        var request1 = HttpRequest.newBuilder().GET().uri(URI.create(url1)).build();
        var client1 = HttpClient.newBuilder().build();
        var response1= client1.send(request1, HttpResponse.BodyHandlers.ofString());
        return response1;
    }

    /**
     * @author Kary Sutariya
     * @param search it is parameter which is being passed from profile
     * @return it returns articles
     * @throws IOException exception to handle null search (input)
     * @throws InterruptedException exception to handle interruption
     * @throws ParseException exception to handle json parsing related exception
     */
    public List<Article> getUserArticle(String search) throws InterruptedException, ParseException, IOException {

        HttpResponse<String> resultCall2 = setpostmethod(search);
        List<Article> Art = new ArrayList<>();
        Object obj1 = new JSONParser().parse(String.valueOf(resultCall2.body()));
        JSONObject test1 = (JSONObject) obj1;
        var post_data = (JSONObject) test1.get("data");
        var children = (JSONArray) post_data.get("children");
        int limit= children.size()-1;
        if(limit>=10)
        {
            limit=10;
        }
        for(int i =0; i<limit; i++){
            var inner_post_data = (JSONObject) children.get(i);
            var real_data = (JSONObject) inner_post_data.get("data");
            var title = real_data.get("title").toString();
            var selftext = real_data.get("selftext").toString();
            var subreddit = real_data.get("subreddit").toString();
            var post_created = Double.parseDouble(real_data.get("created_utc").toString());
            long post_created_date = (new Double(post_created)).longValue();
            var post_date = new java.text.SimpleDateFormat("EEEEE dd MMMMM yyyy HH:mm:ss.SSSZ").format(new java.util.Date (post_created_date*1000));
            Art.add(new Article(title,selftext,subreddit,post_date));
        }
        return Art;
    }

}
