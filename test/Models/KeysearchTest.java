package Models;

import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static play.mvc.Http.Status.OK;

public class KeysearchTest {

    public static HashMap<String, ArrayList<Reddit>> cache = new HashMap<>();


    /**
     * @author Kary Sutariya
     * this method is testing all API call in HomeController using Mockito library.
     */
    @Test
    public void APIMOCK() throws IOException, InterruptedException, ParseException
    {
        Keysearch obj = mock(Keysearch.class);
        when(obj.getSearchResult("bhargav99", cache)).thenReturn(cache);
//        when(obj.setIndex("car")).thenReturn(response);
        var resPost = obj.getSearchResult("bhargav99",cache);

//        var resIndex = obj.setIndex("car");
        try{
            assertNotNull(resPost);
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }
        verify(obj).getSearchResult("bhargav99", cache);
    }
    @Test
    public void testgetSearchResult() throws InterruptedException, ParseException, IOException {
        Keysearch keysearch = new Keysearch();
        HashMap<String, ArrayList<Reddit>> s= keysearch.getSearchResult("bhargav",cache);
        assertNotNull(s);
    }
}
