package Models;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class SubredditSearchTest {

    @Test
    public void getSubredditSearch() throws InterruptedException, ParseException, IOException {
        SubredditSearch subredditSearch = new SubredditSearch();
        List<Reddit> response =  subredditSearch.getSubredditSearch("askreddit");
        assertNotNull(response);
    }
}