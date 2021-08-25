package tech.codingclub.entity;
public class Music {

    private String album;
    private String Child_link;
    private String  duration;
    private String lyricist;
    private String music_director;
    private String parent_link;
    private String singers;
    private String download_128;
    private String download_256;
    private String songname;
    public Music() {
    }

    public Music(String songname,String album, String Child_link, String duration, String lyricist, String music_director, String parent_link, String singers,String download_128,String download_256) {
        this.download_128=download_128;
        this.download_256=download_256;
        this.album = album;
        this.Child_link = Child_link;
        this.duration = duration;
        this.lyricist = lyricist;
        this.music_director = music_director;
        this.parent_link = parent_link;
        this.singers = singers;
        this.songname=songname;

    }

    public String getAlbum() {
        return album;
    }

    public String getChild_link() {
        return Child_link;
    }

    public String getDuration() {
        return duration;
    }

    public String getLyricist() {
        return lyricist;
    }

    public String getMusic_director() {
        return music_director;
    }

    public String getParent_link() {
        return parent_link;
    }

    public String getSingers() {
        return singers;
    }

    public static void main(String[] args) {

    }
}
