package com.example.Algorithm;

public class Algorithm {


    public void reverse(String n[]){
        for (int i = 0; i <= n.length/2 - 1; i++){
            String temp = n[i];
            n[i] = n[n.length-1-i];
            n[n.length-1-i] = temp;
        }
    }

    public void average(int n[]){
        int m = 0;
        for (int i = 0; i <= n.length - 1; i++){
            m += n[i];
        }
        m = m / n.length;
        System.out.println(m);
    }
    
    public void displayStringArray(String n[]){
        for(int i = 0; i <= n.length-1; i++){
            System.out.print(n[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[]args){
        Algorithm runner = new Algorithm();
        int a[] = {1,2, 3, 4, 5};
        String b[] = {"1", "2", "3"};
        runner.reverse(b);
        runner.displayStringArray(b);
        runner.average(a);
    }
}
