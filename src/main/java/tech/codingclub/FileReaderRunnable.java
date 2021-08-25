package tech.codingclub;

import tech.codingclub.fetcherandthread.TaskManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileReaderRunnable implements Runnable{
    String filePathWithName;


    public FileReaderRunnable(String filePathWithName) {
        this.filePathWithName = filePathWithName;
    }
    public ArrayList<String> readFile(){
        ArrayList<String> arrayList = new ArrayList<String>();
        File file = new File(filePathWithName);
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String s = scanner.nextLine();
                s.toLowerCase();
                arrayList.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return arrayList;
    }

    public void run() {
        //
        // System.out.println("run method");
        ArrayList<String> arrayList = readFile();

        Map<String, Integer> repeatedcount = new HashMap<String, Integer>();

        for (int i = 0; i < arrayList.size(); i++) {
            String[] arr = arrayList.get(i).toLowerCase().split(" ");

            for (String w : arr) {
                //System.out.print(arr[j] + " ");
                if (repeatedcount.get(w) == null) {
                    repeatedcount.put(w, 1);
                } else {
                    repeatedcount.put(w, repeatedcount.get(w) + 1);
                }
            }
        }
            System.out.println(repeatedcount);
            Iterator<String> itr = repeatedcount.keySet().iterator();
            while (itr.hasNext()) {
                String temp = itr.next();
                if (repeatedcount.get(temp) > 1) {


                }
            }
         System.out.println("####################SORTED OUtPUT#######################");
        ArrayList<Integer> values = new ArrayList<Integer>();
        values.addAll(repeatedcount.values());

        Collections.sort(values, Collections.reverseOrder());

        int last_i = -1;


        for (Integer i : values.subList(0, 9)) {
            if (last_i == i)
                // without duplicates
                continue;
            last_i = i;


            for (String s : repeatedcount.keySet()) {

                if (repeatedcount.get(s) == i)
                    // which have this value
                    System.out.println(s + " " + i);


            }
        }
    }

            public static void main (String[]args) {
                TaskManager taskManager = new TaskManager(100);

                String filePath = "C:\\Users\\HP\\IdeaProjects\\javamisssion\\data\\practice\\file\\IndianNaitionAnthem.txt";

                FileReaderRunnable fileReaderRunnable = new FileReaderRunnable(filePath);
                taskManager.waitTillQueueIsFreeAndAddTask(fileReaderRunnable);
            }
}