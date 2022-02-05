package com.example.Candy;

public class Candy {

    private String name;
    private int size;
    private int sweetness;
    private int hardness;

    public Candy(String name, int size, int sweetness, int hardness){
        this.name = name;
        this.size = size;
        this.sweetness = sweetness;
        this.hardness = hardness;
    }

    public String toString(){
        return name + " " + size + " " + sweetness + " " + hardness;
    }

    public void addSugar(){
        sweetness++;
    }

    public String getName(){
        return name;
    }

    public int getSize(){
        return size;
    }

    public int getSweetness(){
        return sweetness;
    }

    public int getHardness(){
        return hardness;
    }

    public void addSize(int n){
        size += n / 5;
    }

    public void setSize(int n){
        size = n;
    }

    public void addHardness(int n){
        hardness += n;
    }

    public void setHardness(int n){
        hardness = n;
    }

}
