package com.example.BankAccount;

public class GreatAccount extends BankAccount{

    private int withdraws = 0;

    private int month = 12;

    private int sum = 0;

    public GreatAccount(String name, int balance){
        super(name, balance);
    }

    public void withdraw(int n){
        if (withdraws < 3) {
            changeBalance(getBalance() - n);
            withdraws++;
            sum++;
        }
        else{
            System.out.println("Cannot withdraw, withdraws will be more than 3");
        }
    }

    public void nextMonth(){
        if (month == 12 && sum == 0){
            deposit(getBalance());
            month = 1;
        }
        if(month == 12){
            month = 1;
            sum = 0;
        }
        withdraws = 0;
    }

    public String toString(){
        return getName() + " " + getBalance();
    }

    public static void main(String[]args){
        BankAccount a = new BankAccount("Condy", 50);
        InterestAccount b = new InterestAccount("Joe", 100, 5);
        CreditCard c = new CreditCard("Cooper", 100, 20);
        GreatAccount d = new GreatAccount("Mr.Friedman", 200);
        a.deposit(5);
        a.withdraw(10);
        System.out.println(a);
        b.addInterest();
        System.out.println(b);
        c.addInterest();
        c.withdraw(20);
        System.out.println(c);
        d.withdraw(10);
        d.withdraw(10);
        d.withdraw(10);
        d.withdraw(10);
        d.nextMonth();
        System.out.println(d);
    }
}
