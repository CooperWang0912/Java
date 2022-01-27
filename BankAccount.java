package com.example.Bank;

public class BankAccount {

    private String name;
    private int money;
    private double interest;

    public BankAccount(String name, int money, double interest){
        this.name = name;
        this.money = money;
        this.interest = interest;
    }

    public BankAccount(String name, double interest){
        this.name = name;
        this.interest = interest;
    }

    public void deposit(int n){
        money += n;
    }

    public void withdraw(int n){
        money -= n;
    }

    public void addInterest(){
        money += money / 100 * interest;
    }

    public String toString(){
        System.out.println(money);
        return money;
    }

    public static void main(String[]args){
        BankAccount a = new BankAccount("Cooper", 200, 5);
        BankAccount b = new BankAccount("Condy", -5);
        a.deposit(200);
        a.withdraw(100);
        b.deposit(500);
        b.withdraw(100);
        b.addInterest();
        a.toString();
        b.toString();
    }

}
