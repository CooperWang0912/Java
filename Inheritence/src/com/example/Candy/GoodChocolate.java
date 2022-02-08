package com.example.Candy;

public class GoodChocolate extends Chocolate{

    private int meltValue;

    public GoodChocolate(String name, int size, int sweetness, int hardness, int sourness, int meltValue) {
        super(name, size, sweetness, hardness, sourness);
        this.meltValue = meltValue;
    }

    public void addHardness(int n){
        setHardness(getHardness() + n * 5);
    }

    public String toString(){
        return getName() + " " + getSize() + " " + getSweetness() + " " + getHardness() + " " + getSourness() + " " + meltValue;
    }
    
    public void heat(int n){
        meltValue -= n;
    }

    public static void main(String[]args){
        Candy a = new Candy("Twizzler", 5, 5, 5);
        Chocolate b = new Chocolate("Normal Chocolate", 3, 3, 3, 2);
        GoodChocolate c = new GoodChocolate("Swiss Chocolate", 2, 5, 0, 0, 5);
        a.addSugar();
        b.addSugar();
        c.addSugar();
        a.addSize(10);
        b.addSize(10);
        c.addSize(10);
        a.addHardness(10);
        b.addHardness(10);
        c.addHardness(10);
        b.eat(5);
        c.heat(5);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
