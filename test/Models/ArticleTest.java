package Models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArticleTest {
    @Test
    public void test1(){
        Article test = new Article("test tittle","test para", "subreddit","5 june 2021");
        assertEquals("test tittle",test.get_title());
        assertEquals("test para",test.get_selftext());
        assertEquals("subreddit",test.get_subreddit());
        assertEquals("5 june 2021",test.get_post_date());
    }
}
