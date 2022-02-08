package com.example.BankAccount;

public class BankAccount {

    private String name;
    private int balance;

    public BankAccount(String name, int money){
        this.name = name;
        this.balance = money;
    }

    public void deposit(int n){
        balance += n;
    }

    public void withdraw(int n){
        balance -= n;
    }

    public String getName(){
        return name;
    }

    public int getBalance(){
        return balance;
    }

    public void changeBalance(int n){
        balance = n;
    }

    public String toString(){
        return name + " " + balance;
    }

}