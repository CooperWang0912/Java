package com.example.Garage;

public class Car {

    private String name;
    private int year;
    private int mileage;

    public Car(String name, int year, int mileage){
        this.name = name;
        this.year = year;
        this.mileage = mileage;
    }

    public void drive(int distance){
        mileage += distance;
    }

    public int worth(){
        int sum = 0;
        sum += mileage * year;
        return sum;
    }

    public int getMileage(){
        return mileage;
    }
}
