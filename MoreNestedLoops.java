package com.example.MoreNestedLoops;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class MoreNestedLoops {

    static Scanner scanner = new Scanner(System.in);

    public void loopingBox(int a){
        int j = 1;
        int b = a;
        for (int i = 1; i <= a; i++){
            for (j = i; j <= b; j++){
                System.out.print(j + " ");
            }
            for (j = 1; j <= i - 1; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public void triangle(int a){
        int b = 1;
        for (int i = 1; i <= a; i++){
            for (int j = 1; j <= b; j++){
                System.out.print("X");
            }
            System.out.println();
            b++;
        }
    }

    public void power(int a, int b){
        int c = 1;
        while(b != a){
            b = b /a;
            c++;
        }
        System.out.println(c);
    }

    public void diamond(int a){
        int j;
        int i;
        int start = a;
        int end = a;
        for (i = 1; i < a; i++){
            for (j = 1; j <= a; j++) {
                if(j >= start && j <= end){
                    System.out.print("* ");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
            start--;
            end++;
        }
        for (i = a; i <= a*2-1; i++){
            for (j = 1; j <= a; j++) {
                if(j >= start && j <= end){
                    System.out.print("* ");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
            start++;
            end--;
        }
    }

    public static void main(String[]args){
        MoreNestedLoops runner = new MoreNestedLoops();
        System.out.println("Input a integer");
        int a = scanner.nextInt();
        runner.loopingBox(a);
        System.out.println("Input a integer");
        int b = scanner.nextInt();
        runner.triangle(b);
        System.out.println("Input two integers");
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        runner.power(c, d);
        System.out.println("Input a integer");
        int e = scanner.nextInt();
        runner.diamond(e);
    }

}
