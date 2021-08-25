package tech.codingclub;

class Singletonexample
{
    public static void main(String args[])
    {
        // instantiating Singleton class with variable x
        Singleton x = Singleton.getSingle_instanceInstance(8);

        // instantiating Singleton class with variable y
        Singleton y = Singleton.getSingle_instanceInstance(11);

        // instantiating Singleton class with variable z
        Singleton z = Singleton.getSingle_instanceInstance(13);

    x.s=8;  //x,y,z are there object call getinstance_function/method
    y.s=11;
    z.s=13;
        System.out.println(x.s + "##"+y.s+"##"+z.s);
        System.out.println("data from x is:" + x.s);
        System.out.println("data from y is:" + y.s);
        System.out.println("data from z :is" + z.s);


    }
}
