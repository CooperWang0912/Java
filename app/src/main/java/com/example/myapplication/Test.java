package com.example.myapplication;
import java.util.Scanner;
public class Test {
    static int cal(int a){
        return a*10;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int a = scanner.nextInt();
        System.out.println(cal(a));
    }
}
