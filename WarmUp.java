package com.example.WarmUp;
import java.util.Scanner;

public class WarmUp {
    Scanner scanner = new Scanner(System.in);

    public void words(String n[]){
        for (int i = 0; i <= n.length-1; i++){
            System.out.print(n[i] + " ");
        }
        System.out.println();
    }

    public void list(int n){
        int a[] = new int[n];
        for(int i = 0; i <= n-1; i++){
            a[i] = i + 1;
        }
        for(int i = 0; i <= n-1; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void sum(int n[]){
        int a = 0;
        for (int i = 0; i <= n.length-1; i++){
            a += n[i];
        }
        a = a / n.length;
        System.out.println(a);
    }

    public void doubleNum(int n[]){
        for (int i = 0; i <= n.length-1; i++){
            n[i] = n[i] * 2;
        }
        for (int i = 0; i <= n.length-1; i++){
            System.out.print(n[i] + " ");
        }
        System.out.println();
    }

    public void trim(int n[]){
        int a[] = new int[n.length - 2];
        int max = n[0];
        int min = n[0];
        int j = 0;
        for (int i = 0; i <= n.length-1; i++){
            if (n[i] >= max){
                max = n[i];
            }
            if (n[i] <= min){
                min = n[i];
            }
        }
        for (int i = 0; i <= a.length-1; i++){
            if (n[j] != max && n[j] != min){
                a[i] = n[j];
                j++;
            }
            else{
                i--;
                j++;
            }
        }
        for (int i = 0; i <= a.length-1; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void Fibonacci(int n){
        int a[] = new int[n];
        a[0] = a[1] = 1;
        for (int i = 2; i <= a.length-1; i++){
            a[i] = a[i-1] + a[i-2];
        }
        for (int i = 0; i <= a.length-1; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void divisibility(int n[]){
        boolean a[] = new boolean[n.length-1];
        for (int i = 1; i <= n.length-1; i++){
            if (n[i] % n[i-1] == 0){
                a[i-1] = true;
            }
            else{
                a[i-1] = false;
            }
        }
        for (int i = 0; i <= a.length-1; i++){
            if (a[i] == true){
                System.out.print("yes ");
            }
            if (a[i] == false){
                System.out.print("no ");
            }
        }
        System.out.println();
    }

    public void risingAverage(double n[]){
        double a[] = new double[n.length];
        int b = 0;
        for (int i = 1; i <= n.length; i++){
            for (int j = 0; j <= i - 1; j++){
                a[b] += n[j];
            }
            a[b] = a[b] / i;
            b++;
        }
        for (int i = 0; i <= n.length-1; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void shift(String n[], int m){
        String a[] = new String[n.length];
        for (int i = 0; i <= n.length-1; i++){
            a[i] = n[i];
        }
        for (int i = m; i <= n.length - 1; i++){
            n[i] = a[i-m];
        }
        for (int i = 0; i <= m-1; i++){
            n[i] = a[n.length-m+i];
        }
        for (int i = 0; i <= n.length - 1; i++){
            System.out.print(n[i] + " ");
        }
        System.out.println();
    }

    public void dotProduct(int n[], int m[]){
        int sum = 0;
        for (int i = 0; i <= n.length-1; i++){
            sum += n[i] * m[i];
        }
        System.out.println(sum);
    }


    public static void main(String[]arg){
        int a[] = {1, 2, 3, 4, 5};
        int b[] = {1, 2, 3, 4, 5};
        double c[] = {4, 6, 2, 12};
        String d[] = {"hi", "hello"};
        int e[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int f[] = {8, 3, 12, 5, 15, 45};
        int g[] = {5, 3, 1};
        int h[] = {8, 4, 7};
        String k[] = {"I", "Love", "CS", "So", "Much"};
        WarmUp runner = new WarmUp();
        runner.words(d);
        runner.list(5);
        runner.sum(a);
        runner.doubleNum(b);
        runner.trim(e);
        runner.Fibonacci(10);
        runner.risingAverage(c);
        runner.divisibility(f);
        runner.dotProduct(g, h);
        runner.shift(k, 1);
    }
}
