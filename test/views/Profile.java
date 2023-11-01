package views;

import Models.Article;
import Models.User;
import org.junit.Test;
import play.api.http.MediaRange;
import play.api.mvc.Request;
import play.i18n.Lang;
import play.libs.typedmap.TypedKey;
import play.libs.typedmap.TypedMap;
import play.mvc.Http;
import play.twirl.api.Content;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class Profile {

    /**
     * @author kary sutariya
     * test for profile view page
     */
    @Test
    public void renderTemplate() {
        Http.Request req = new Http.Request() {
            @Override
            public Http.RequestBody body() {
                return null;
            }

            @Override
            public Http.Request withBody(Http.RequestBody body) {
                return null;
            }

            @Override
            public Http.Request withAttrs(TypedMap newAttrs) {
                return null;
            }

            @Override
            public <A> Http.Request addAttr(TypedKey<A> key, A value) {
                return null;
            }

            @Override
            public Http.Request removeAttr(TypedKey<?> key) {
                return null;
            }

            @Override
            public Request<Http.RequestBody> asScala() {
                return null;
            }

            @Override
            public String uri() {
                return "/profile?search=bhargav99";
            }

            @Override
            public String method() {
                return null;
            }

            @Override
            public String version() {
                return null;
            }

            @Override
            public String remoteAddress() {
                return null;
            }

            @Override
            public boolean secure() {
                return false;
            }

            @Override
            public TypedMap attrs() {
                return null;
            }

            @Override
            public String host() {
                return null;
            }

            @Override
            public String path() {
                return null;
            }

            @Override
            public List<Lang> acceptLanguages() {
                return null;
            }

            @Override
            public List<MediaRange> acceptedTypes() {
                return null;
            }

            @Override
            public boolean accepts(String mimeType) {
                return false;
            }

            @Override
            public Map<String, String[]> queryString() {
                return null;
            }

            @Override
            public String getQueryString(String key) {
                return null;
            }

            @Override
            public Optional<String> queryString(String key) {
                return Optional.empty();
            }

            @Override
            public Http.Cookies cookies() {
                return null;
            }

            @Override
            public Http.Cookie cookie(String name) {
                return null;
            }

            @Override
            public Optional<Http.Cookie> getCookie(String name) {
                return Optional.empty();
            }

            @Override
            public Http.Headers getHeaders() {
                return null;
            }

            @Override
            public boolean hasBody() {
                return false;
            }

            @Override
            public Optional<String> contentType() {
                return Optional.empty();
            }

            @Override
            public Optional<String> charset() {
                return Optional.empty();
            }

            @Override
            public Optional<List<X509Certificate>> clientCertificateChain() {
                return Optional.empty();
            }
        };
        List<User> labels = new ArrayList<>();
        labels.add(new User("name","profile","true","https://www.reddit.com/","512","5 june 2021","500"));

        List<Article> Art = new ArrayList<>();
        Art.add(new Article("test tittle","test para", "subreddit","5 june 2021"));
        Content html = views.html.profile.render(req,"bhargav99",labels,Art);
        assertEquals("text/html", html.contentType());
    }
}