package com.example.ArrayTest;
import java.util.Scanner;

public class ArrayTest {

    Scanner scanner = new Scanner(System.in);

    public static int a[];
    public static int b[];

    public void displayArray(int n[]){
        for(int i = 0; i <= n.length-1; i++){
            System.out.print(n[i] + " ");
        }
        System.out.println();
    }

    public void oneToN(int n){
        a = new int [n];
        for (int i = 0; i <= n-1; i++){
            a[i] = i + 1;
        }
    }

    public void swap(int n[]){
        int m = n[0];
        n[0] = n[n.length-1];
        n[n.length-1] = m;
    }

    public void userArray(int n){
        b = new int[n];
        for(int i = 0; i <= n-1; i++){
            b[i] = scanner.nextInt();
        }
    }

    public void reverse(int n[]){
        for (int i = 0; i <= n.length/2 - 1; i++){
            int m = n[i];
            n[i] = n[n.length-1-i];
            n[n.length-1-i] = m;
        }
    }

    public static void main(String[]args){
        ArrayTest runner = new ArrayTest();
        int c[] = {1, 2, 3, 4, 5, 6, 7};
        int d[] = {1, 2, 3, 4, 5};
        runner.displayArray(c);
        runner.oneToN(20);
        runner.displayArray(a);
        runner.swap(c);
        runner.displayArray(c);
        System.out.println("Input n integers");
        runner.userArray(5);
        runner.displayArray(b);
        runner.reverse(d);
        runner.displayArray(d);
    }
}
