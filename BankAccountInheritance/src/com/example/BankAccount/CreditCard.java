package com.example.BankAccount;

public class CreditCard extends InterestAccount{

    public CreditCard(String name, int balance, double interest){
        super(name, balance, interest);
    }

    public void addInterest(){
        deposit((int)(getInterest() / 100 * getBalance()) - 10);
    }

    public void withdraw(int n){
        if (getBalance() - n < 100){
            System.out.println("Cannot withdraw, balance will be lower than 100");
        }
        else{
            changeBalance(getBalance() - n);
        }
    }

    public String toString(){
        return getName() + " " + getBalance() + " " + getInterest();
    }

}
