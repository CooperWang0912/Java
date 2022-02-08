package com.example.Candy;

public class Chocolate extends Candy{

    private int sourness;

    public Chocolate(String name, int size, int sweetness, int hardness, int sourness){
        super(name, size, sweetness, hardness);
        this.sourness = sourness;
    }

    public int getSourness() {
        return sourness;
    }

    public void addSize(int n){
        setSize(getSize() + n);
    }
    
    public void eat(int n){
        setSize(getSize() - n);
    }

    public String toString(){
        return getName() + " " + getSize() + " " + getSweetness() + " " + getHardness() + " " + getSourness();
    }

}
