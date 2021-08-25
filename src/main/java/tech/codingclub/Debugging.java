package tech.codingclub;
import java.io.*;
import java.util.Date;
class Debugging {
    public static void main(String[] args) throws IOException {
        int N = 10;       int sum = 0;
        for (int i = 0; i <= N; i++) {
               sum += i;   }
        Singleton singleton = Singleton.getSingle_instanceInstance(463);
        System.out.println("Sum till now:" + sum);
        System.out.println(new Date().toString());
        System.out.println(singleton.s + sum);
        int x = sum;  int y = 45; int z = (x + y);
        System.out.println(z + "must be 100");
        FileInputStream fstream = new FileInputStream("C:\\Users\\HP\\IdeaProjects\\javamisssion\\src\\main\\java\\ipl\\Debugging.java");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;      //Read File Line By Line
        while ((strLine = br.readLine()) != null)   { // Print the content on the console - do what you want to do
            System.out.println (strLine);  }
            fstream.close();//Close the input stream
        }
}

