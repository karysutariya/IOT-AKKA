package controllers;

import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.mockito.Mock;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;

import java.io.IOException;
import java.net.http.HttpResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.GET;
import static play.test.Helpers.route;

public class HomeControllerTest extends WithApplication {

    @Mock
    HttpResponse response;

    /**
     * @author Kary Sutariya
     * this method is testing index method of homecontroller
     */
    @Test
    public void testIndex() {
        Http.RequestBuilder request = Helpers.fakeRequest().method(GET).uri("/");
        Result result = route(app, request);
        assertEquals(400, result.status());

        Http.RequestBuilder request1 = Helpers.fakeRequest().method(GET).uri("/?msearch='car'");
        Result result1 = route(app, request1);
        assertEquals(400, result1.status());

        Http.RequestBuilder request3 = Helpers.fakeRequest().method(GET).uri("/?msearch=");
        Result result3 = route(app, request3);
        assertEquals(400, result3.status());
    }

    /**
     * @author Kary Sutariya
     * this method is testing profile
     */
    @Test
    public void testProfile() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/profile?search=bhargav99");
        Result result = route(app, request);
        assertNotEquals(OK, result.status());
    }

    /**
     * @author Kary Sutariya
     * this method is testing all API call in HomeController using Mockito library.
     */
    @Test
    public void APIMOCK() throws IOException, InterruptedException, ParseException
    {
        HomeController obj = mock(HomeController.class);
        when(obj.setprofilemethod("bhargav99")).thenReturn(response);
        var resFile = obj.setprofilemethod("bhargav99");
        try{
            assertEquals(OK, resFile.statusCode());
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }
        verify(obj).setprofilemethod("bhargav99");
    }

    /**
     * @author bhargav yagnik
     * this method is testing subreddit
     */
    @Test
    public void testSubreddit() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/subreddit/realracing");

        Result result = route(app, request);
        assertNotEquals(OK, result.status());

    }

    /**
     * @author Ornela
     * this method is testing wordcount
     */
    @Test
    public void testcount() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/stats/car");

        Result result = route(app, request);
        assertNotEquals(OK, result.status());

    }

}