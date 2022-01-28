package com.example.Garage;

public class Garage {

    private Car carArray[];

    public Garage(int n){
        carArray = new Car[n];
    }

    public void addNewCar(int i, String name, int year, int mileage) {
        Car n = new Car(name, year, mileage);
        carArray[i] = n;
    }

    public int totalWorth(){
        int sum = 0;
        for (int i = 0; i <= carArray.length-1; i++){
            if (carArray[i] != null) {
                sum += carArray[i].worth();
            }
            else{
                System.out.println("Wrong Index");
            }
        }
        System.out.println(sum);
        return sum;
    }

    public int averageMileage(){
        int sum = 0;
        for (int i = 0; i <= carArray.length-1; i++){
            if (carArray[i] != null) {
                sum += carArray[i].getMileage();
            }
            else{
                System.out.println("Wrong Index");
            }
        }
        sum /= carArray.length;
        System.out.println(sum);
        return sum;
    }

    public void drive(int i, int n){
        carArray[i].drive(n);
    }

    public static void main(String[]args){
        Garage g = new Garage(3);
        g.addNewCar(0, "Condy", 2, 100);
        g.addNewCar(1, "Cooper", 3, 50);
        g.addNewCar(2, "Joe", 4, 120);
        g.drive(2,30);
        g.addNewCar(2, "Joe", 4, 200);
        g.averageMileage();
        g.totalWorth();
    }
}
