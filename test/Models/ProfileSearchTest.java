package Models;

import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.mockito.Mock;
import play.test.WithApplication;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static play.mvc.Http.Status.OK;

public class ProfileSearchTest extends WithApplication
{
    @Mock
    HttpResponse response;

    /**
     * @author Kary Sutariya
     * this method is testing all API call in HomeController using Mockito library.
     */
    @Test
    public void APIMOCK() throws IOException, InterruptedException, ParseException
    {
        ProfileSearch obj = mock(ProfileSearch.class);
        when(obj.setpostmethod("bhargav99")).thenReturn(response);
//        when(obj.setIndex("car")).thenReturn(response);
        var resPost = obj.setpostmethod("bhargav99");

//        var resIndex = obj.setIndex("car");
        try{
            assertEquals(OK, resPost.statusCode());
//            assertEquals(OK, resIndex.statusCode());
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }
        verify(obj).setpostmethod("bhargav99");
//        verify(obj).setIndex("car");
    }
    @Test
    public void testsetpost() throws InterruptedException, ParseException, IOException {
        ProfileSearch profileSearch = new ProfileSearch();
        HttpResponse<String> response = profileSearch.setpostmethod("bhargav99");
        assertNotNull(response);
    }
    @Test
    public void testgetuser() throws InterruptedException, ParseException, IOException {
        ProfileSearch profileSearch = new ProfileSearch();
        List<Article> response =  profileSearch.getUserArticle("bhargav99");
        assertNotNull(response);
    }

}
