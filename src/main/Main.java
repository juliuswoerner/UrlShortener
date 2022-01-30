package main;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args){
        boolean continu = true; //actually is continue
        String url;
        List<String> shortUrls = new ArrayList<>();
        List<String> longUrls = new ArrayList<>();

        while(continu){
            url = readUrl();
            if(url.contains(" store as ")){
                addUrlWithSuggestion(url, shortUrls, longUrls);
            }
            else {
                addUrl(url, shortUrls, longUrls);
            }
            continu = anotherUrl();
        }
    }

    public static String readUrl(){
        System.out.println("Please insert a URL");
        return System.console().readLine();
    }
    
    public static boolean anotherUrl(){
        System.out.println("Do you want to enter another URL? If not, please type 'no'");
        String answer = System.console().readLine();
        return !answer.equals("no");
    }

    public static String createShortUrl(String longUrl, int dim){
        dim = dim + 1;
        if(longUrl.contains("https")){
            return "https://" + "surl.ly/" + String.valueOf(dim);
        }
        else{
            return "http://" + "surl.ly/" + String.valueOf(dim);
        }
    }

    private static void addUrlWithSuggestion(String url, List<String> shortUrls, List<String> longUrls) {
        String[] urls = url.split(" store as ");
        String longUrl = urls[0];
        String suggestedShortUrl = urls[1];
        if(suggestionIsInvalid(suggestedShortUrl) || shortUrls.contains(suggestedShortUrl)){
            System.out.println("Your suggested short Url is already used, do you want to use this URL instead?");
            String createdShortUrl = createShortUrl(url, shortUrls.size());
            System.out.println(createdShortUrl);
            System.out.println("'yes' or 'no'?");
            if(createdUrlIsAccepted()){
                shortUrls.add(createdShortUrl);
                longUrls.add(longUrl);
            }
            else{
                System.out.println("Your URL was not stored, please proceed.");
            }
        }
        else{
            shortUrls.add(suggestedShortUrl);
            longUrls.add(longUrl);
            System.out.println("stored your long URL as " + suggestedShortUrl);
        }
    }

    private static void addUrl(String url, List<String> shortUrls, List<String> longUrls) {
        if (shortUrls.contains(url)) {
            System.out.println("Your long URL was:");
            System.out.println(longUrls.get(shortUrls.indexOf(url)));
        } else {
            String surl = createShortUrl(url, shortUrls.size());
            shortUrls.add(surl);
            longUrls.add(url);
            System.out.println("stored your long URL as " + surl);
        }
    }

    private static boolean createdUrlIsAccepted() {
        String answer = System.console().readLine();
        return answer.equals("yes");
    }

    private static boolean suggestionIsInvalid(String url) {
        return url.contains("surl.ly");
    }

}
