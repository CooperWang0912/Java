package com.example.Homework3;
import java.util.Scanner;

public class Homework3 {
    public static Scanner scanner = new Scanner(System.in);

    public void smallest(int x, int y, int z){
        if (x <= y){
            if (x <= z){
                System.out.println(x);
            }
            else if (x > z){
                System.out.println(z);
            }
        }
        if (x > y){
            if (y <= z){
                System.out.println(y);
            }
            else if (y > z){
                System.out.println(z);
            }
        }
    }

    public void letter(char x, char y){
        if (Math.abs(((int)x) - ((int)y)) <= 2 || Math.abs(Math.abs(((int)x) - ((int)y)) - 32) <= 2){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }

    public static void main(String[]args){
        Homework3 runner = new Homework3();
        System.out.println("Input 3 integers");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println("Input 2 chars");
        char d = scanner.next().charAt(0);
        char e = scanner.next().charAt(0);
        runner.smallest(a, b, c);
        runner.letter(d, e);
    }
}
