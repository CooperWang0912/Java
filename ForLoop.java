package com.example.ForLoop;
import java.util.Scanner;

public class ForLoop {
    static Scanner scanner = new Scanner(System.in);

    public void magicNumber(){
        System.out.println("Guess the number");
        for (int i = 365; i != scanner.nextInt();){
            System.out.println("Wrong");
        }
        System.out.println("Correct");
    }

    public void outHi(int a){
        for (int i = 1; i <= a; i++){
            System.out.println("Hi");
        }
    }

    public void outInt(int a){
        for (int i = -a; i <= a; i++){
            System.out.println(i);
        }
    }

    public void factorial(int a){
        int sum = 1;
        for (int i = 1; i <= a; i++){
            sum = sum * i;
        }
        System.out.println(sum);
    }

    public void game(){
        System.out.println("Do you want to keep playing");
        String b;
        String a = scanner.next();
        for (b = "yes"; b.equals(a);){
            if (a.equals("no")){
                break;
            }
            System.out.println("Do you want to keep playing");
            a = scanner.next();
        }
        System.out.println("game over");
    }

    public void smallDivisor(int a){
        for (int i = 1; i < a; i++){
            if (a % i == 0){
                System.out.println(i);
            }
        }
    }

    public void GCD(int a, int b){
        int c = Math.min(a, b);
        int d = 1;
        for (int i = 1; i <= c; i++){
            if (a % i == 0 && b % i == 0){
                d = i;
            }
        }
        System.out.println(d);
    }

    public void LCM(int a, int b){
        int c = Math.min(a, b);
        int sum = 1;
        for (int i = 2; i <= c; i++){
            if (a % i == 0 && b % i == 0){
                sum = sum * i;
                a = a / i;
                b = b / i;
                i--;
            }
        }
        System.out.println(sum * a * b);
    }

    public void prime(int a){
        boolean b = true;
        for (int i = 2; i <= a / 2; i++){
            if (a % i == 0){
                b = false;
                break;
            }
        }
        if (a == 1){
            b = false;
        }
        System.out.println(b);
    }

    public static void main(String[]args){
        ForLoop runner = new ForLoop();
        runner.magicNumber();
        System.out.println("Input one integer");
        int a = scanner.nextInt();
        runner.outHi(a);
        System.out.println("Input one integer");
        int b = scanner.nextInt();
        runner.outInt(b);
        System.out.println("Input one integer");
        int c = scanner.nextInt();
        runner.factorial(c);
        runner.game();
        System.out.println("Input one integer");
        int d = scanner.nextInt();
        runner.smallDivisor(d);
        System.out.println("Input two integer");
        int e = scanner.nextInt();
        int f = scanner.nextInt();
        runner.GCD(e, f);
        System.out.println("Input two integer");
        int g = scanner.nextInt();
        int h = scanner.nextInt();
        runner.LCM(g, h);
        System.out.println("Input one integer");
        int j = scanner.nextInt();
        runner.prime(j);
    }
}
