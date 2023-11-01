package Models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RedditTest {
    @Test
    public void test1(){
        Reddit test = new Reddit("author","text", "reddit");
        assertEquals("author",test.author);
        assertEquals("text",test.title);
        assertEquals("reddit",test.reddit);
        assertEquals("reddit",test.getReddit());
    }
}
