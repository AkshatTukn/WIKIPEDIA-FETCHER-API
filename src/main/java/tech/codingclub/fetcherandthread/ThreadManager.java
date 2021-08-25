package tech.codingclub.fetcherandthread;
import tech.codingclub.RunnableExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadManager {
    private int poolsize;
    private  ExecutorService executorService;
    public ThreadManager(int poolsize) {
         this.poolsize=poolsize;
         executorService=Executors.newFixedThreadPool(poolsize);
    }
     public void execute(Runnable runnable) {

        executorService.submit(runnable);
     }
     public static void main(String[] args) {
        ThreadManager threadManager=new ThreadManager(1000);
        for(int i=0;i<100000;i++) {

            RunnableExample temp = new RunnableExample("THREAD-NO" + i, 0, 500 + i);
            threadManager.execute(temp);

        }
    }
}
