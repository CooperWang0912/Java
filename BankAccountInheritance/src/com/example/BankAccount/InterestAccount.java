package com.example.BankAccount;

public class InterestAccount extends BankAccount{

    private double interest;

    public InterestAccount(String name, int balance, double interest){
        super(name, balance);
        this.interest = interest;
    }

    public void addInterest(){
        deposit((int)(interest / 100 * getBalance()));
    }

    public double getInterest(){
        return interest;
    }

    public String toString(){
        return getName() + " " + getBalance() + " " + getInterest();
    }
}
