package com.example.Wrestler;

import java.lang.reflect.Array;

public class Wrestler {

    private String name;
    private double weight;
    private String outfitColor;
    private int numberOfWins;

    public Wrestler(String name, int weight, String outfitColor, int numberOfWins){
        this.name = name;
        this.weight = weight;
        this.outfitColor = outfitColor;
        this.numberOfWins = numberOfWins;

    }

    public void saysSomethingIntimidating(){
        System.out.println(name + " says get wrecked");
    }

    public String toString(){
        System.out.println(name + " " + weight + " " + outfitColor + " " + numberOfWins);
        return name + " " + weight + " " + outfitColor + " " + numberOfWins;
    }

    public double getWeight(){
        return weight;
    }

    public String getName(){
        return name;
    }

    public void fight(Wrestler n){
        boolean win = false;
        int index = 0;
        if (weight > n.getWeight()){
            numberOfWins++;
            System.out.println(name + " wins");
        }
        if (weight < n.getWeight()){
            n.numberOfWins++;
            System.out.println(n.getName() + " wins");
        }
        if (weight == n.getWeight()){
            while (win == false){
                if (name.charAt(index) < n.name.charAt(index)){
                    numberOfWins++;
                    System.out.println(name + " wins");
                    win = true;
                }
                if (name.charAt(index) > n.name.charAt(index)) {
                    n.numberOfWins++;
                    System.out.println(n.name + " wins");
                    win = true;
                }
                else{
                    index++;
                }
            }
        }
    }

    public void lift(double n){
        weight += n * 0.01;
    }

    public void tagTeam(Wrestler t1[], Wrestler t2[]){
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i <= t1.length - 1; i++){
            t1[i].outfitColor = outfitColor;
        }
        for (int i = 0; i <= t2.length - 1; i++){
            t2[i].outfitColor = t2[0].outfitColor;
        }
        sum1 += weight;
        for (int i = 0; i <= t1.length - 1; i++){
            sum1 += t1[i].weight;
        }
        for (int i = 0; i <= t2.length - 1; i++){
            sum2 += t2[i].weight;
        }
        if (sum1 >= sum2){
            for (int i = 0; i<= t1.length - 1; i++){
                t1[i].numberOfWins++;
            }
            numberOfWins++;
            System.out.println("We win");
        }
        if (sum1 < sum2){
            for (int i = 0; i<= t2.length - 1; i++){
                t2[i].numberOfWins++;
            }
            System.out.println("They win");
        }
    }

    public static void main(String[]args){
        Wrestler a = new Wrestler("Cooper", 170, "Blue", 5);
        Wrestler b = new Wrestler("Coory", 180, "Red", 3);
        Wrestler c = new Wrestler("Joe", 180, "Green", 1);
        Wrestler d = new Wrestler("Mr.Friedman", 180, "Yellow", 2);
        Wrestler e[] = {b};
        Wrestler f[] = {c, d};
        a.saysSomethingIntimidating();
        a.lift(1000);
        a.fight(b);
        a.tagTeam(e, f);
        a.toString();
        b.toString();
        c.toString();
        d.toString();
    }

}
