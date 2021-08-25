package tech.codingclub.fetcherandthread;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WikipediaDownloader implements Runnable {
    private String keyword;

    public WikipediaDownloader(){

    }
    public WikipediaDownloader(String keyword){
        this.keyword=keyword;
    }
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
        System.out.println(json);
    }

    private String getWikipediaForQuery(String cleanKeyword){
        return "https://en.wikipedia.org/wiki/"+cleanKeyword;
    }


    public static void main(String[] args) {
        TaskManager taskManager=new TaskManager(20);
        String arr[]={"India","china","india"};
        for(String keyword:arr   )
        {
            WikipediaDownloader wikipediaDownloader = new WikipediaDownloader(keyword);
            taskManager.waitTillQueueIsFreeAndAddTask(wikipediaDownloader);

        }
    }
}
