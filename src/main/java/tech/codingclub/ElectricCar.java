package tech.codingclub;
public  class ElectricCar extends Car{
    private double bettryleft=100;
    public ElectricCar()
    {
        super();//calling of car class
}
public ElectricCar(String numberplate){
        super(numberplate);
}
 public ElectricCar(String numberplate,int currentspeeed){
        super(numberplate,currentspeeed);

 }
 public double batteryleft()//new feature of chiled class
 {
  return bettryleft;
 }
 public  void accelarate(){
        super.accelarate();
        bettryleft=bettryleft-0.5;
        System.out.println("betteryleft: " + bettryleft);
 }

    public static void main(String[] args) {
        ElectricCar tesla=new ElectricCar("TESLA 111");
        ElectricCar tesla2=new ElectricCar("TESLA2 998",500);

        tesla.printAboutwheel();
        System.out.println("TESLA SPEED:" + tesla.getcurrentspeed()  + " ##Bettery:" +tesla.batteryleft() );
        tesla.accelarate();
    }

}
