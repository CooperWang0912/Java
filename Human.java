package com.example.Human;

public class Human {

    String name;
    private int age;
    private int height;
    private int weight;
    private int width;
    private boolean hair;

    public Human(String name, int age, int height,int weight, int width, boolean hair){
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.width = width;
        this.hair = hair;
    }

    public String getName(){
         return name;
    }

    public int getAge(){
        return age;
    }

    public int getHeight(){
        return height;
    }

    public int getWeight(){
        return weight;
    }

    public int getWidth(){
        return width;
    }

    public boolean getHair(){
        return hair;
    }

    public void changeName(String newName){
        name = newName;
    }

    public void setAge(int newAge){
        age = newAge;
    }

    public void setHeight(int newHeight){
        height = newHeight;
    }

    public void setWeight(int newWeight){
        weight = newWeight;
    }

    public void setWidth(int newWidth){
        width = newWidth;
    }

    public void setHair(boolean newHair){
        hair = newHair;
    }

    public void eat(int food){
        height += food / 100;
    }

    public void useHairGrowerSpray(){
        hair = true;
    }

    public void getOlder(){
        age += 1;
    }

    public void canVote(int year){
        if (year % 4 == 0 && age >= 18){
            System.out.println("Can vote");
        }
        else{
            System.out.println("Cannot vote");
        }
    }

    public String toString(){
        System.out.println(name + " " + age + " " + height + " " + weight + " " + width + " " + hair);
        return name + " " + age + " " + height + " " + weight + " " + width + " " + hair;
    }

    public static void main(String[]args){
        Human g = new Human("Condy", 17, 5, 150, 60, false);
        g.eat(1000);
        g.useHairGrowerSpray();
        g.getOlder();
        g.canVote(2020);
        g.changeName("Cooper");
        g.toString();
    }

}
