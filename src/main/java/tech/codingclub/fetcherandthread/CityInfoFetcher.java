package tech.codingclub.fetcherandthread;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.ArrayList;

public class CityInfoFetcher implements  Runnable {
    private String keyword;
    CityInfoFetcher()
    {
        //defualt construtor..
    }
    CityInfoFetcher(String keyword)
    {
        this.keyword=keyword;
    }

    @Override
    public void run() {
        //1.get clean keyword!
        //2.get the url for wikipedia
        //3.Make a GET request to Wikipedia!
        //4.parsing      the useful result using jsoup
        //5.showing result!
        if (this.keyword == null || this.keyword.length() == 0) {
            return;
        }
        //step-1
        this.keyword = this.keyword.trim().replaceAll("[ ]", "_");
        //step-2
        String wikiUrl = getWikipediaForQuery(this.keyword);
        String  imageurl = null;
        String responce = "";

        try {
            //step-3
            String wikipediaResponceHTML= HttpURLConnectionExample.sendGet(wikiUrl);
            //System.out.println(wikipediaResponceHTML);
            //step-4
            Document document= Jsoup.parse(wikipediaResponceHTML,"https://en.wikipedia.org/wiki/");
            Elements mainElement = document.body().select(".mw-parser-output > *");
            int step = 0;
            for(Element element : mainElement){
                if(step==0 ) {
                    if (element.tagName().equals("table")) {
                        step = 1;
                    }

                }else if(step == 1){
                    if(element.tagName().equals("p")){
                        step=2;
                        responce= element.text();
                        break;

                    }
                }
            }
            try{
                imageurl = document.body().select(".infobox img").get(0).attr("src");
            }catch (Exception e){
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        WikiResult wikiResult=new WikiResult(this.keyword,responce,imageurl);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(wikiResult);
        Jedis jedis=new Jedis("localhost");
        System.out.println("Connection Succesfully");
        jedis.set(this.keyword,json);
        System.out.println(jedis.get(this.keyword));
        System.out.println(".........................Output from Jedis...........................");
    }
    private String getWikipediaForQuery(String cleanKeyword){
        return "https://en.wikipedia.org/wiki/"+cleanKeyword;
    }
    public static void main(String[] args) throws IOException {
        CrawleAllCities crawleAllCities=new CrawleAllCities();
        TaskManager taskManager=new TaskManager(100);
        ArrayList<String> citylist=crawleAllCities.getcityname();
        for(String x:citylist) {
            CityInfoFetcher cityInfoFetcher = new CityInfoFetcher(x);
            //x is there key...
            taskManager.waitTillQueueIsFreeAndAddTask(cityInfoFetcher);
            //Manage threads....

        }
    }
}
