package tech.codingclub.database;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import tech.codingclub.fetcherandthread.HttpURLConnectionExample;
import tech.codingclub.fetcherandthread.TaskManager;
import tech.codingclub.utility.FileUtility;

import java.util.ArrayList;

public class MusicFetcher implements Runnable {

    private String letterLink;

    public MusicFetcher() {
    }

    public MusicFetcher(String letterLink) {
        this.letterLink = letterLink;
    }


    public void run() {

        String songLink="";
        String songname="";
        if(letterLink== null || letterLink.length()==0 )
            return;

        try {
            String letterURL = HttpURLConnectionExample.sendGet(letterLink);
            Document document = Jsoup.parse(letterURL,"https://songspk.mobi");
            Elements element = document.body().select(".thumb-image > *");
            for(Element childElement : element)
            {
                //System.out.println(childElement);
                if(childElement.tagName().equals("a"))
                {   songname=childElement.toString();
                    songLink= childElement.attr("href");
                    //     System.out.println("https://songspk.mobi"+songLink);
                    SongPageDetailsFetcher.main(letterLink,songLink,songname);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //  System.out.println("Finished running this one's run");
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager(10);
        ArrayList<String> lettersSearch = FileUtility.readPrintFileAsList("C:\\Users\\HP\\IdeaProjects\\javamisssion\\data\\practice\\file\\crawlsonglinks.txt");
        for(String letterSearch : lettersSearch)
        {
            // System.out.println(letterSearch);
            MusicFetcher musicFetcher = new MusicFetcher(letterSearch);
            taskManager.waitTillQueueIsFreeAndAddTask(musicFetcher);
        }

    }
}