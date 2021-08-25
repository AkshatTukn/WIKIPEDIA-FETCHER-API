package tech.codingclub;

public class Car {
    static int wheel=4;
    public static final int  maxspeed=300;
    private int currentspeeed=0 ;
    String numberplate;
    public Car(String numberplate){
        //this means current number plate
        this.numberplate=numberplate;
    }
    public Car(String numberplate,int currentspeeed){
        //this means current number plate
        this.numberplate=numberplate;
        this.currentspeeed=currentspeeed;
    }
    void accelarate()
    {
        System.out.println("speeding up !" + numberplate);
        currentspeeed+=10;
    }
    public Car()
    {

    }
    //static method can onmly access /modify static data variable only.
    //cannot accesss non static
    static void  printAboutwheel(){
        //not valid to write this
        //currentspeed+=10;
        //but
        //valid
        System.out.println("car has"+ wheel+ "wheels");
    }

    public static void main(String[] args) {

    }
    public void increasespeed(int i) {
        if (i < 0) return;
        {
            currentspeeed += i;
            if (currentspeeed >= maxspeed) {
                currentspeeed = maxspeed;
            }
        }
    }
        public int getcurrentspeed()
       {
           return currentspeeed;
        }

    }