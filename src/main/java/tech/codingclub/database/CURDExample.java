package tech.codingclub.database;

import tech.codingclub.entity.Music;

import java.util.Date;
import java.util.List;


    public class CURDExample {
        public static void main(String[] args) {
            System.out.println("this side is Shreyansh Jain");
            System.out.println("Reading Rows at New Time" + new Date().toString());
            //one row only
            Music coder=new GenericDB<Music>().getRow(tech.codingclub.tables.Music.MUSIC,Music.class,null);

            List<Music> rows = (List<Music>) GenericDB.getRows(tech.codingclub.tables.Music.MUSIC,Music.class,null,null );
            //itterator
            for(Music row :rows)
            {
                System.out.println(row.getAlbum()+" ::: "+ row.getSingers()+":::"+row.getLyricist());
            }
        }
    }


