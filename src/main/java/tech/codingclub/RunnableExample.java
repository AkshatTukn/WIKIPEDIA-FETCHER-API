package tech.codingclub;

import java.util.Scanner;

public class RunnableExample implements Runnable {

    private String threadName;
    public int counter;
    private int WaitTimeWhileloop;

    public RunnableExample(String threadName, int counter, int WaitTimeWhileloop){
        this.threadName=threadName;
        this.counter=counter;
        this.WaitTimeWhileloop=WaitTimeWhileloop;
    }
    public void run(){
        while(counter<1000){
            counter++;
            //sleep!
            {
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
        RunnableExample runnable1=new RunnableExample("THREAD_A",0,500);
        RunnableExample runnable2=new RunnableExample("THREAD_B",500,1000);
        RunnableExample runnable3=new RunnableExample("THREAD_C",500,2000);

       Thread thread1=new Thread(runnable1);
        Thread thread2=new Thread(runnable2);
        Thread thread3=new Thread(runnable3);
        thread1.start();
        thread2.start();
        thread3.start();
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
    }
}
