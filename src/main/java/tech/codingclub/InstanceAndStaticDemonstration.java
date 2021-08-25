package tech.codingclub;

public class InstanceAndStaticDemonstration {
    int a=10;  // instance variable
    static int b=20;// this is static variable..

    String InstanceExample() //instance method..
    {

        return "this is instance block";
    }

    public static String Example()//this is static blocked
    {
        return "this is static block";
    }
    public static void main(String[] args) {
        InstanceAndStaticDemonstration obj=new InstanceAndStaticDemonstration();
        System.out.println(obj.a); //access instance member method
        System.out.println(InstanceAndStaticDemonstration.b);//access static variable
        System.out.println(InstanceAndStaticDemonstration.Example());//access static method
        System.out.println(obj.InstanceExample());//access instance member variable

    }

}
