package Models;

import org.junit.Test;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;


public class UsersTest extends WithApplication {

    @Test
    public void test1(){
        User test = new User("name","profile","true","https://www.reddit.com/","512","5 june 2021","500");
        assertEquals("name",test.Name);
        assertEquals("profile",test.Profile);
        assertEquals("true",test.Verified);
        assertEquals("https://www.reddit.com/",test.Reddit_profile);
        assertEquals("512",test.Subscribers);
        assertEquals("5 june 2021",test.Reddit_user);
        assertEquals("500",test.Total_Karma);
    }

}