package tech.codingclub.fetcherandthread;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;


public class CrawleAllCities{

    public String fetchHTML(){
        String url = "http://ontheworldmap.com/all/cities/";
        String html = null;
        try {
            html = HttpURLConnectionExample.sendGet( url );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return html;
    }
    public  ArrayList<String> getcityname() throws IOException {

        String html = fetchHTML();
        ArrayList<String> datarepresenter = new ArrayList<String>();

        if (html != null && html.length() > 0) {
            Document document = Jsoup.parse(html, "http://ontheworldmap.com/");
            Elements elements = document.body().select(".clr").select(".col-3").select(".ul-reset >*");
            for (Element e : elements) {
                if (e.tagName().equals("li")) {
                    String data = e.text();
                    datarepresenter.add(data);
                    if (data.equals("Zurich")) {
                        break;
                    }

                }

            }

        }

        return datarepresenter;
    }

    public static void main(String[] args) throws IOException {

        CrawleAllCities crawleAllCities = new CrawleAllCities();
        ArrayList<String> result = crawleAllCities.getcityname();
        for (String str : result) {
            System.out.println(str);
        }
    }
}



