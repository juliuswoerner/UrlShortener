package test;

import main.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

public class UrlShortenerTest {
    Main m = new Main();
    @Test
    @DisplayName("createShortUrl Test for https")
    void testCreateShortUrl(){
        String url = m.createShortUrl("https://l.de", 3);
        assertEquals(url, "https://surl.ly/4");
    }
    @Test
    @DisplayName("createShortUrl Test for http")
    void testCreateShortUrlHttp(){
        String url = m.createShortUrl("http://l.de", 1);
        assertEquals(url, "http://surl.ly/2");
    }
}
