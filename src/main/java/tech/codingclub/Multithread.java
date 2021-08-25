package tech.codingclub;

    // Java code for thread creation by extending
// the Thread class
    class MultithreadingDemo extends Thread
    {
        public void run()
        {
            try
            {
                // Displaying the thread that is running
                System.out.println ("Thread " +
                        Thread.currentThread().getId() +
                        " is running"+ " and name is  "+ Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getState()+"     "+Thread.getAllStackTraces());

            }
            catch (Exception e)
            {
                // Throwing an exception
                System.out.println ("Exception is caught");
            }
        }
    }

    // Main Class
    public class Multithread
    {
        public static void main(String[] args) throws InterruptedException {
            int n = 8; // Number of threads

            MultithreadingDemo obj = new MultithreadingDemo();
            obj.start();
            obj.setName("hello");

            for (int i=0; i<n; i++)
            {
                MultithreadingDemo object = new MultithreadingDemo();
                object.start();
                object.getState();
                object.wait();
            }

        }
    }


