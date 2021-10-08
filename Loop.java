package com.example.Loop;
import java.util.Scanner;

public class Loop {
    public static Scanner scanner = new Scanner(System.in);

    //Definite Finite
    public void loopNumber(int x, int y){
        if (x - y > 0){
            while(x >= y){
                System.out.println(x);
                x--;
            }
        }
        else if (x - y < 0){
            while(x <= y){
                System.out.println(x);
                x++;
            }
        }
        else if (x == y){
            System.out.println(x);
        }
    }

    //Definite Finite
    public void exponentialSequence(double x, double y){
        for(int z = 0; z <= 5; z++){
            System.out.println(Math.pow(x, z) * y);
        }
    }

    //Definite Finite
    public void perfectSquare(int x){
        int a = 0;
        boolean b = false;
        while (a*a < x){
            a++;
            if(x == a*a){
                b = true;
                break;
            }
            else{
                continue;
            }
        }
        if(b == true){
            System.out.println(a);
        }
        else if(b == false){
            System.out.println("Does not have a root");
        }
    }

    //Definite Finite
    public void greatestNumber(int x){
        int a = 1;
        int b = 0;
        int c;
        while (a <= x){
            a++;
            c = scanner.nextInt();
            if (c >= b){
                b = c;
            }
        }
        System.out.println(b);
    }


    public static void main(String[]args){
        System.out.println("Input two integers");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("Input two doubles");
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();
        System.out.println("Input one integer");
        int e = scanner.nextInt();
        System.out.println("Input one integer");
        int f = scanner.nextInt();
        Loop runner = new Loop();
        runner.loopNumber(a, b);
        runner.exponentialSequence(c, d);
        runner.perfectSquare(e);
        runner.greatestNumber(f);
    }
}
