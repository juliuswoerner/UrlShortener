package main;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static String readUrl(){
        System.out.println("Please insert a URL");
        String url = System.console().readLine();
        return url;
    }
    public static boolean anotherUrl(){
        System.out.println("Do you want to enter another URL? If not, please type 'no'");
        String answer = System.console().readLine();
        if(answer.equals("no"))
        {
            return false;
        }
        else{
            return true;
        }
    }
    //returns -1 if String is not in List, otherwise the index of the String in the List
    public static int isInList(List<String> list, String str){
        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals(str)){
                return i;
            }
        }
        return -1;
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

    public static void main(String[] args){
        boolean continu = true; //should be continue
        String url;
        //List<UrlShortener> urlShorteners = new ArrayList<UrlShortener>();
        List<String> shortUrls = new ArrayList<String>();
        List<String> longUrls = new ArrayList<String>();
        int check = -2;

        while(continu){
            url = readUrl();
            if(url.contains(" store as ")){
                String[] urls = url.split(" store as ");
                check = isInList(shortUrls, urls[1]);
                //System.out.println(urls[1]);
                if(urls[1].contains("surl.ly")){
                    check = 0;
                }
                if(check==-1){
                    shortUrls.add(urls[1]);
                    longUrls.add(urls[0]);
                    System.out.println("stored your long URL as " + urls[1]);
                }
                else{
                    System.out.println("Your suggested short Url is already used, do you want to use this URL instead?");
                    int dim = shortUrls.size();
                    String surl2 = createShortUrl(url, dim);
                    System.out.println(surl2);
                    System.out.println("'yes' or 'no'?");
                    String answer2 = System.console().readLine();
                    if(answer2.equals("yes")){
                        shortUrls.add(surl2);
                        longUrls.add(urls[0]);
                    }
                    else{
                        System.out.println("Your URL was not stored, please proceed.");
                    }

                }
            }
            else {
                check = isInList(shortUrls, url);
                if (check > -1) {
                    System.out.println("Your long URL was:");
                    System.out.println(longUrls.get(check));
                } else {
                    int dim = shortUrls.size();
                    String surl = createShortUrl(url, dim);
                    shortUrls.add(surl);
                    longUrls.add(url);
                    System.out.println("stored your long URL as " + surl);
                }
            }
            continu = anotherUrl();
        }
    }
}
