package tech.codingclub.utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileUtility {
    public static boolean createFile(String fileNameWithpath) {
        File file = new File(fileNameWithpath);
        boolean Filecreate = false;


        try {
            Filecreate = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Filecreate;
    }

     public static ArrayList<String> readPrintFileAsList(String fileName) {
        Scanner scanner = null;
        ArrayList string = new ArrayList();
        try {
            File file = new File(fileName);
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                string.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return string;
    }

    public static boolean writeToFile(String filenamewithpath, String content) {
       /*we can also use this code also
        try{FileWriter fileWriter =new FileWriter(fileNameWithPath);
        fileWriter.append(content);
        fileWriter.close();
        }catch(Exception e){
        }
        return true;
        }
        */
        BufferedWriter bw = null;
        try {
            File file = new File(filenamewithpath);
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            bw.write(content);

        } catch (Exception e) {
            return false;
        } finally {

            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static boolean appendToFile(String fileName, String content)
    {
        try
        {
            FileWriter fileWriter=new FileWriter(fileName,true);
            fileWriter.append(content);
            fileWriter.append("\n");
            fileWriter.close();


        }catch(Exception e)
        {
            return false;
         }
        return true;
}
    public static void main(String[] args) {
        System.out.println("This side is shreyansh jain");
        System.out.println("Running FileUtility At :" + new Date().toString());
        String newfilename = "C:\\Users\\HP\\IdeaProjects\\javamisssion\\data\\practice\\file\\" + "IndianNaitionAnthem.txt";
        boolean create = createFile(newfilename);
        System.out.println("file created status:  " + create);
        ArrayList<String> StringArraylist = readPrintFileAsList(newfilename);
        for(String x:StringArraylist){
            System.out.println("line:" + x  );
        }
        System.out.println("no of line:" + StringArraylist.size() );
        String newfilewrite = "C:\\Users\\HP\\IdeaProjects\\javamisssion\\data\\practice\\file\\" + "write-file.txt";
        boolean wrotetofile=writeToFile(newfilewrite,"this file gentrated by shreyansh's in system.java");
        System.out.println(wrotetofile);
         for(int i=1;i<=100;i++)
         {
             String data=i+ "";//string.size().size()
             appendToFile(newfilewrite,data);
         }
         System.out.println("Append File length: " + readPrintFileAsList(newfilewrite).size());
    }
}