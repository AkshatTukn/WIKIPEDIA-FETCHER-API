package tech.codingclub.database;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import tech.codingclub.entity.Music;
import tech.codingclub.fetcherandthread.HttpURLConnectionExample;
import tech.codingclub.fetcherandthread.TaskManager;

public class SongPageDetailsFetcher implements Runnable {

    private String album="";
    private String child_link="";
    private String duration="";
    private String lyricist="";
    private String music_director="";
    private String parent_link;
    private String singers="";
    private String child;
    private String download_128="";
    private String download_256="";
    private String songname;

    public SongPageDetailsFetcher(String parent_link, String child_link_partial,String songname) {
        this.songname=songname;
        this.parent_link = parent_link;
        child=child_link_partial;
        this.child_link = "https://songspk.mobi"+child;
    }


    public void run() {

        int state=0;
        System.out.println("Entered Song run");
        if(child_link== null || child_link.length()==0 )
            return;
        String songURL = null;
        try {
            songURL = HttpURLConnectionExample.sendGet(child_link);
            Document document = Jsoup.parse(songURL,"https://songspk.mobi");
            Elements element1 = document.body().select(".list-group-item > *");
            Elements element2 = document.body().select(".col-sm-6 > *");


            for(Element childElement : element1)
            {
                if(childElement.text().equals("Album"))
                {
                    album = childElement.nextElementSibling().text();
                    //  System.out.println("Album "+album);
                }
                else if(childElement.text().equals("Duration"))
                {
                    duration = childElement.nextElementSibling().text();
                    //  System.out.println("Duration "+duration);
                }
                else if(childElement.text().equals("Singers"))
                {
                    singers = childElement.nextElementSibling().text();
                    //  System.out.println("Singers "+singers);
                }
                else if(childElement.text().equals("Lyricist"))
                {
                    lyricist = childElement.nextElementSibling().text();
                    //  System.out.println("Lyricist "+lyricist);
                }
                else if(childElement.text().equals("Music Director"))
                {
                    music_director = childElement.nextElementSibling().text();
                    // System.out.println("Music Director "+music_director);
                }
                else
                    child_link = ("https://songspk.mobi"+child);
            }


            for(Element childElement : element2)
            {
                if(childElement.text().equals("Download - 128Kbps - MP3"))
                {
                    download_128 = childElement.attr("href");
                    download_128 = download_128.replaceAll("[ ]","%20");
                    // System.out.println("Download 128 link :"+download_128);
                }
                else if(childElement.text().equals("Download - 320Kbps - MP3"))
                {
                    download_256 = childElement.attr("href");
                    download_256 = download_256.replaceAll("[ ]","%20");
                    //  System.out.println("Download 256 link :"+download_256);
                }
            }

            Music eachSong = new Music(songname,album,child_link,duration,lyricist,music_director,parent_link,singers,download_128,download_256);
            new GenericDB<Music>().addRow(tech.codingclub.tables.Music.MUSIC,eachSong);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args1, String args2,String args3) {
        TaskManager taskManager = new TaskManager(10);
        //System.out.println("Entered Song Page Fetcher ");
        SongPageDetailsFetcher songPageDetailsFetcher = new SongPageDetailsFetcher(args1,args2,args3);
        taskManager.waitTillQueueIsFreeAndAddTask(songPageDetailsFetcher);
    }


}