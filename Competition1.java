package com.example.Competition1;
import java.util.Scanner;

public class Competition1 {
    static Scanner scanner = new Scanner(System.in);

    public void nPowers(double x, int n){
        for (int i = 1; i <= n; i++){
            System.out.println(Math.pow(x, i));
        }
    }

    public void sum(int n){
        int sum = 0;
        for (int i = 1; i <= n; i++){
            sum += i;
        }
        System.out.println(sum);
    }

    public void reverseInt(int num){
        int reverse = 0;
        while (num != 0){
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num = num / 10;
        }
        System.out.println(reverse);
    }

    public void inputUntil1(){
        double a = scanner.nextDouble();
        double b = 0;
        double c = 0;
        while(a != -1){
            b += a;
            a = scanner.nextInt();
            c++;
        }
        System.out.println(b / c);
    }

    public void decoder(int a){
        int b = 0;
        for (int i = 1; i <= a; i = i * 10){
            b++;
        }
        for (int i = b / 2; i >= 1; i--){
            System.out.println((char)((a % (int)(Math.pow(100, i)) / (int)(Math.pow(100, i - 1)))));
        }
    }

    public static void main(String[]args){
        Competition1 runner = new Competition1();
        System.out.println("Input one double and one integer");
        double a = scanner.nextDouble();
        int b = scanner.nextInt();
        runner.nPowers(a, b);
        System.out.println("Input one integer");
        int c = scanner.nextInt();
        runner.sum(c);
        System.out.println("Input one integer");
        runner.inputUntil1();
        int d = scanner.nextInt();
        runner.reverseInt(d);
        System.out.println("Input one integer");
        int e = scanner.nextInt();
        runner.decoder(e);
    }
}
