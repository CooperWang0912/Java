package com.example.HW2;
import java.util.Scanner;
public class HW2 {
    public static Scanner scanner = new Scanner(System.in);
    static int a = scanner.nextInt();
    static int b = scanner.nextInt();
    static double c = scanner.nextInt();
    static double d = scanner.nextInt();
    public static void numTochar(int x){
        System.out.println((char)x);
    }
    public static void numDigit(int y){
        System.out.println(y % 10);
    }
    public static void numAverage(double z1, double z2){
        System.out.println((z1 + z2) / 2);
    }
    public static void main(String[] args){
        numTochar(a);
        numDigit(b);
        numAverage(c, d);
    }
}
