package tech.codingclub;

public class learnclass {

    public static void main(String[] args) {
        Car audi = new Car("audi007");
        audi.accelarate();
        audi.wheel = 8;
        Car bmw = new Car("bmw 008", 100);
        bmw.accelarate();
        bmw.increasespeed(1000);


        System.out.println("Current speed audi" + audi.getcurrentspeed());
        System.out.println("Current speed Bmw" + bmw.getcurrentspeed());
        System.out.println("AW: " + Car.wheel);
        System.out.println("BW: " + bmw.wheel);
        System.out.println("car has 8 wheel");
        Car.wheel = 4;
        System.out.println("AW: " + Car.wheel);
        System.out.println("BW: " + Car.wheel);
    }
}
