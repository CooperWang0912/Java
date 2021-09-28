package com.example.method;

public class Method {
    public static int age;
    public static char gender;
    public static int age2;
    public static char gender2;

    public static void setAge(int x){
        age = x;
    }

    public static void setGender(char x){
        gender = x;
    }

    public static void vote(){
        if(age >= 18){
            System.out.println("Can vote");
        }
        else{
            System.out.println("Cannot vote");
        }
    }

    public static void shot(){
        if(age % 4 == 0){
            System.out.println("Need tetanus shot");
        }
        else{
            System.out.println("Do not need tetanus shot");
        }
    }

    public static void toddler(){
        if(age < 4 && gender == 'b'){
            System.out.println("Toddler boy");
        }
        if(age < 4 && gender == 'g'){
            System.out.println("Toddler girl");
        }
        else{
            System.out.println("Not a toddler");
        }
    }

    public static void discount(){
        if(age < 12 || age > 65){
            System.out.println("Have discounts");
        }
        else{
            System.out.println("Do not have discounts");
        }
    }

    public static void teenager(){
        if(age > 12 && age < 18){
            System.out.println("Teenager");
        }
        else{
            System.out.println("Not a teenager");
        }
    }

    public static void setAge2(int x){
        age2 = x;
    }

    public static void setGender2(char x){
        gender2 = x;
    }

    public static void teammates(){
        if(Math.abs(age - age2) <= 2 && gender == gender2){
            System.out.println("Can be teammates");
        }
        else{
            System.out.println("Cannot be teammates");
        }
    }

    public static void main(String[]args){
        setAge(18);
        setGender('b');
        vote();
        shot();
        toddler();
        discount();
        teenager();
        setAge2(16);
        setGender2('b');
        teammates();
    }
}
