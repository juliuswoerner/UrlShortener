package urlshortener;

public class UrlShortener {

    int id;
    String shortUrl;
    String longUrl;

    public UrlShortener(int id, String shortUrl, String longUrl){
        this.id = id;
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
    }

    public int getId(){
        return id;
    }

    public String getShortUrl(){
        return shortUrl;
    }

    public String getLongUrl(){
        return longUrl;
    }

    public boolean compare(UrlShortener url2){
        return (id == url2.id || (shortUrl.equals(url2.shortUrl) && longUrl.equals(url2.longUrl)));
    }


    public static void main(String[] args){
        UrlShortener Shorty = new UrlShortener(1, "surl.ly", "lurl.ly");
    }

}
