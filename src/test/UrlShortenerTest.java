package test;

import main.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    @Test
    @DisplayName("addUrlWithSuggestion Test for new Short URL")
    void testAddUrlWithSuggestionNewShortUrl(){
        String insert = "https://mylongurl.de/long store as https://myshorturl.de/short";
        List<String> shortUrls = new ArrayList<>(List.of("https://surl.ly/1","https://surl.ly/2","https://surl.ly/3","https://surl.ly/4"));
        List<String> expectedShortUrls = new ArrayList<>(List.of("https://surl.ly/1","https://surl.ly/2","https://surl.ly/3","https://surl.ly/4","https://myshorturl.de/short" ));
        List<String> longUrls = new ArrayList<>(List.of("https://lurl.ly/1","https://lurl.ly/2","https://lurl.ly/3","https://lurl.ly/4"));
        List<String> expectedLongUrls = new ArrayList<>(List.of("https://lurl.ly/1","https://lurl.ly/2","https://lurl.ly/3","https://lurl.ly/4","https://mylongurl.de/long"));
        m.addUrlWithSuggestion(insert, shortUrls, longUrls);
        assertEquals(shortUrls,expectedShortUrls);
        assertEquals(longUrls,expectedLongUrls);
    }
    @Test
    @DisplayName("addUrl Test for new Long URL")
    void testAddUrlWithNewLongUrl(){
        String longUrl = "https://mylongurl.de/long";
        List<String> shortUrls = new ArrayList<>(List.of("https://surl.ly/1","https://surl.ly/2","https://surl.ly/3","https://surl.ly/4"));
        List<String> expectedShortUrls = new ArrayList<>(List.of("https://surl.ly/1","https://surl.ly/2","https://surl.ly/3","https://surl.ly/4","https://surl.ly/5" ));
        List<String> longUrls = new ArrayList<>(List.of("https://lurl.ly/1","https://lurl.ly/2","https://lurl.ly/3","https://lurl.ly/4"));
        List<String> expectedLongUrls = new ArrayList<>(List.of("https://lurl.ly/1","https://lurl.ly/2","https://lurl.ly/3","https://lurl.ly/4","https://mylongurl.de/long"));
        m.addUrl(longUrl, shortUrls, longUrls);
        assertEquals(shortUrls,expectedShortUrls);
        assertEquals(longUrls,expectedLongUrls);
    }
    @Test
    @DisplayName("addUrl Test for already used Short URL")
    void testAddUrlWithSuggestionAlreadyUsedShortUrl(){
        String longUrl = "https://surl.ly/3";
        List<String> shortUrls = new ArrayList<>(List.of("https://surl.ly/1","https://surl.ly/2","https://surl.ly/3","https://surl.ly/4"));
        List<String> expectedShortUrls = new ArrayList<>(List.of("https://surl.ly/1","https://surl.ly/2","https://surl.ly/3","https://surl.ly/4"));
        List<String> longUrls = new ArrayList<>(List.of("https://lurl.ly/1","https://lurl.ly/2","https://lurl.ly/3","https://lurl.ly/4"));
        List<String> expectedLongUrls = new ArrayList<>(List.of("https://lurl.ly/1","https://lurl.ly/2","https://lurl.ly/3","https://lurl.ly/4"));
        m.addUrl(longUrl, shortUrls, longUrls);
        assertEquals(shortUrls,expectedShortUrls);
        assertEquals(longUrls,expectedLongUrls);
    }


}
