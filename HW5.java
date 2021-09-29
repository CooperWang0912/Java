package com.example.homework;
import java.util.Scanner;

public class HW5{
    public static Scanner scanner = new Scanner(System.in);
    public static int num1;
    public static int num2;
    public static int num3;
    public static int num4;
    public static String a;
    public static int num5;
    public static int num6;
    public static int num7;
    public static int num8;
    public static int num9;
    public static int num10;

    public void number(int a, int b, int c, int d){
        System.out.println(d*1000 + c*100 + b*10 + a);
    }

    public void condition(String a, int b, int c){
        if (a.equals("+")){
            System.out.println(b + c);
        }
        else if(a.equals("-")){
            System.out.println(b - c);
        }
        else if (a.equals("*")){
            System.out.println(b * c);
        }
        else if (a.equals("/")){
            System.out.println(b / c);
        }
        else if (a.equals("%")){
            System.out.println(b % c);
        }
        else{
            System.out.println(a + (char)b + (char)c);
        }
    }

    public void football(int a, int b, int c){
        boolean d = false;
        for (int i = 1; i <= a; i++){
            for (int j = 1; j <= b; j++){
                if(i * 7 + j * 2 == c){
                    d = true;
                }
            }
        }
        if(d == true){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }

    public void greatest(int a){
        if (a <= 9){
            System.out.println(a);
        }
        else if (a <= 99){
            if (a % 10 >= a / 10){
                System.out.println(a % 10);
            }
            else{
                System.out.println(a / 10);
            }
        }
        else if (a <= 999){
            if (a / 100 >= (a % 100) / 10){
                if (a/100 >= a % 10){
                    System.out.println(a/100);
                }
                else{
                    System.out.println(a % 10);
                }
            }
            if (a / 100 < (a % 100) / 10){
                if ((a%100) / 10 >= a%10){
                    System.out.println((a%100) / 10);
                }
                else{
                    System.out.println(a % 10);
                }
            }
        }
    }

    public static void main(String[]args){
        HW5 runner = new HW5();
        System.out.println("Input the four numbers of a four digt number backwards");
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        num3 = scanner.nextInt();
        num4 = scanner.nextInt();
        System.out.println("Input the operator and the two numbers");
        a = scanner.next();
        num5 = scanner.nextInt();
        num6 = scanner.nextInt();
        System.out.println("Input the number of touchdowns, field goals and total score");
        num7 = scanner.nextInt();
        num8 = scanner.nextInt();
        num9 = scanner.nextInt();
        System.out.println("Input a number under 1000");
        num10 = scanner.nextInt();
        runner.number(num1, num2, num3, num4);
        runner.condition(a, num5, num6);
        runner.football(num7, num8, num9);
        runner.greatest(num10);
    }
}
