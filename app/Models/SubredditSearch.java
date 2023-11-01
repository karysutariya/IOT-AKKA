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

public class SubredditSearch {
    /**
     * @author Kary Sutariya
     * @param subredditId is string of reddit
     * @return list of reddit array which contains info author, body and subreddit
     * @throws IOException
     * @throws InterruptedException
     * @throws ParseException
     */
    public List<Reddit> getSubredditSearch(String subredditId) throws IOException, InterruptedException, ParseException {
        List<Reddit> subArray = new ArrayList<>();
        if(subredditId == "")
            subredditId = null;
        if(subredditId == null)
        {
            subArray.add(new Reddit(null,null,null));
        }
        else
        {
            String url = "https://api.pushshift.io/reddit/search/comment/?subreddit="+subredditId+"&sort=desc&size=10";
            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            var client = HttpClient.newBuilder().build();
            var response= client.send(request, HttpResponse.BodyHandlers.ofString());
            Object obj = new JSONParser().parse(String.valueOf(response.body()));
            JSONObject test = (JSONObject) obj;
            var data = (JSONArray)test.get("data");
            try {
                for (int j = 0; j < 10; j++) {
                    var inner_post_data = (JSONObject) data.get(j);
                    var author = inner_post_data.get("author");
                    var title = inner_post_data.get("body");
                    var subreddit = inner_post_data.get("subreddit");
                    subArray.add(new Reddit(author.toString(), title.toString(), subreddit.toString()));
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return subArray;
    }
}
