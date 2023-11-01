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
import java.util.HashMap;

public class Keysearch {
    /**
     * @author Kary Sutariya
     * @param key is string
     * @param cache contains results
     * @return result in from redditpushshift api
     * @throws IOException exception to handle null search (input)
     * @throws InterruptedException exception to handle interruption
     * @throws ParseException exception to handle json parsing related exception
     */
    public HashMap<String, ArrayList<Reddit>> getSearchResult(String key,HashMap<String, ArrayList<Reddit>> cache) throws IOException, InterruptedException, ParseException {
        //getting the updated text from the columns
        String search = key;
        ArrayList<Reddit> mainArray = new ArrayList<>();
        String temp = search;
        if(temp == (null) || temp.equals(""))
        {
            mainArray.add(new Reddit(null,null, null));
        }
        else
        {
            String msearch1 = temp.replace(" ","%20");
            var url = "https://api.pushshift.io/reddit/search/submission/?q="+temp+"&sort=desc&size=10";
            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            var client = HttpClient.newBuilder().build();
            HttpResponse<String> indexcall1 = client.send(request, HttpResponse.BodyHandlers.ofString());
            Object obj = new JSONParser().parse(String.valueOf(indexcall1.body()));
            JSONObject test = (JSONObject) obj;
            var data = (JSONArray)test.get("data");
            for(int i =0; i<10; i++){
                var inner_post_data = (JSONObject) data.get(i);
                var author = inner_post_data.get("author");
                var title = inner_post_data.get("title");
                var reddit = inner_post_data.get("subreddit");
                mainArray.add(new Reddit(author.toString(),title.toString(), reddit.toString()));
            }
            cache.put(temp,mainArray);
        }
        return cache;
    }
}
