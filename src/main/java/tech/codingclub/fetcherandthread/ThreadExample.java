package tech.codingclub.fetcherandthread;

import java.util.Scanner;

public class ThreadExample extends Thread {

    private String threadName;
    public int counter;
    private int WaitTimeWhileloop;

    public ThreadExample(String threadName,int counter,int WaitTimeWhileloop){
        this.threadName=threadName;
        this.counter=counter;
        this.WaitTimeWhileloop=WaitTimeWhileloop;
    }
    //we are overrinding how run will gonna work!
    public void run(){
        while(counter<1000){
            counter++;
            //sleep!
            if(threadName.equals("THREAD_A")){
                try{
                    Thread.sleep(WaitTimeWhileloop);
                }catch(Exception e){
                    e.printStackTrace();
                }
                System.out.println(threadName+":"+counter);
            }
        }
    }

    public static void main(String[] args) {
        ThreadExample thread1=new ThreadExample("THREAD_A",0,500);
        ThreadExample thread2=new ThreadExample("THREAD_B",500,1000);
        ThreadExample thread3=new ThreadExample("THREAD_C",500,2000);

        thread1.start();
        thread2.start();
        thread3.start();
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
    }
}
