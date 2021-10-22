package com.example.NestedLoop;
import java.util.Scanner;

public class NestedLoop {
    static Scanner scanner = new Scanner(System.in);

    public void aToZ(){
        for (int i = 65; ;i++){
            System.out.print((char)(i) + " ");
            if((char)(i) == 'Z'){
                System.out.println();
                break;
            }
        }
    }

    public void multiplicationTable(){
        for(int i = 1; i <= 12; i++){
            for(int j = 1; j <= 12; j++){
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }

    public void primeToZ(int n){
        for (int i = 1; i <= n; i++){
            boolean prime = true;
            for (int j = 2; j <= (i / 2); j++){
                if (i % j == 0){
                    prime = false;
                }
            }
            if (prime == true){
                System.out.println(i);
            }
        }
    }

    public void starX(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                if(j == i || j == n - i + 1 ) {
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[]args){
        NestedLoop runner = new NestedLoop();
        runner.aToZ();
        runner.multiplicationTable();
        System.out.println("Input a integer");
        int a = scanner.nextInt();
        runner.primeToZ(a);
        System.out.println("Input a integer");
        int b = scanner.nextInt();
        runner.starX(b);
    }
}
