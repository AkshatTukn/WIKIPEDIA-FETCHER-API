
package tech.codingclub.fetcherandthread;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Date;

public class WikipediaFetcher {

    private String query;

    public WikipediaFetcher(String query){
        this.query = query;
    }

    private String getWikipediaUrl(){
        String cleanKeyword = query.replaceAll("[ ]+","_");
        return "https://en.wikipedia.org/wiki/"+cleanKeyword;
    }

    private String fetchHTML(){
        String url = getWikipediaUrl();
        String html = null;
        try {
            html = HttpURLConnectionExample.sendGet( url );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return html;
    }


    public WikiResult getResult() {
        String html = fetchHTML();
        String result = "";
        String imageUrl = "";
        WikiResult wikiResult = null;

        if(html!=null&&html.length() > 0 ){
            //Parse using Jsoup
            Document document = Jsoup.parse(html,"https://en.wikipedia.org");
            Elements paragraphs = document.body().select(".mw-parser-output > *");

            int step = 0;
            for(Element element : paragraphs){
                if(step==0 ){
                    if(element.tagName().equals("table")){
                        step =1;
                    }
                }else if(step == 1){
                    if(element.tagName().equals("p")){
                        result = element.text();

                        try{
                            imageUrl = document.body().select(".infobox img").get(0).attr("src");
                        }catch (Exception e){
                        }
                        wikiResult = new WikiResult(query,result,imageUrl);

                        break;
                    }
                }
            }

            //System.out.println(html);
        }

        return wikiResult;
    }

    public static void main(String[] args) {

        System.out.println("This side is Shreyansh");
        System.out.println("wikipedia_fetecher Running AT"+ new Date().toString());
        WikipediaFetcher wikipediaFetcher = new WikipediaFetcher("india");
        WikiResult wikiResult = wikipediaFetcher.getResult();

        System.out.println(new Gson().toJson(wikiResult));
     System.out.println("###"+ "Answer in two way"+ "#####");
        System.out.println(wikiResult.getText_result());

    }

}