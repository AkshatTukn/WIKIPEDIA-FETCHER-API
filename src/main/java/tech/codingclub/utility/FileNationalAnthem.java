package tech.codingclub.utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileNationalAnthem {public static boolean createFile(String fileNameWithpath) {
    File file = new File(fileNameWithpath);
    boolean Filecreate = false;


    try {
        Filecreate = file.createNewFile();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return Filecreate;
}


    public static void main(String[] args) {

        String newfilename = "C:\\Users\\HP\\IdeaProjects\\javamisssion\\data\\practice\\file\\" + "crawlsonglinks.txt";
        boolean create = createFile(newfilename);
        System.out.println("file created status:  " + create);
    }
}
