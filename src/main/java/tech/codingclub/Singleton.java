package tech.codingclub;

// Java program implementing Singleton class
// with getInstance() method
class Singleton
{
    // variable of type String
    public int s;
    // static variable single_instance of type Singleton
    private static Singleton single_instance;



    // private constructor restricted to this class itself
    private Singleton(int s)
    {
        this.s=s;
        System.out.println("constructor call data was: "+ s);
    }

    // static method to create instance of Singleton class
    public static Singleton getSingle_instanceInstance(int s)
    {
        if (single_instance == null) {
            single_instance = new Singleton(s);




        }

        return single_instance;


    }
}