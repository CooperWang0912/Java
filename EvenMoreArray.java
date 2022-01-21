package com.example.Array;

public class EvenMoreArray {

    public void together(char n[][]){
        String res = "";
        for (int i = 0; i <= n.length-1; i++){
            for (int j = 0; j <= n[i].length-1; j++){
                res += n[i][j];
            }
        }
        System.out.println(res);
    }

    public void matrix(int n){
        int max[][] = new int [n][n];
        int num = 0;
        for (int i = 0; i <= max.length - 1; i++){
            max[i][num] = n;
            num++;
        }
        num = n - 1;
        for (int i = 0; i <= max.length - 1; i++){
            max[i][num] = n;
            num--;
        }
        for (int i = 0; i <= max.length-1; i++){
            for (int j = 0; j <= max[i].length-1; j++){
                System.out.print(max[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void triangle(int n){
        int num[][] = new int[n][];
        int a = 1;
        for (int i = 0; i <= num.length-1; i++){
            num[i] = new int [i+1];
        }
        for (int i = 0; i <= num.length-1; i++){
            for (int j = 0; j <= num[i].length-1; j++){
                num[i][j] = a;
                a++;
            }
        }
        for (int i = 0; i <= num.length-1; i++){
            for (int j = 0; j <= num[i].length-1; j++) {
                System.out.print(num[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void zero(int n[][]){
        int num[][] = new int[n.length][];
        int a = 0;
        for (int i = 0; i <= n.length-1; i++){
            num[i] = new int[n[i].length*2];
        }
        for (int i = 0; i <= n.length-1; i++){
            a = 0;
            for (int j = 0; j+2 <= num[i].length; j+=2){
                num[i][j] = n[i][j-a];
                num[i][j+1] = 0;
                a++;
            }
        }
        for (int i = 0; i <= num.length-1; i++){
            for (int j = 0; j <= num[i].length-1; j++) {
                System.out.print(num[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void reverse(double n[][]){
        double temp;
        for (int i = 0; i <= n.length-1; i++){
            for (int j = 0; j <= (n[i].length - 1) / 2; j++){
                temp = n[i][j];
                n[i][j] = n[i][n[i].length-j-1];
                n[i][n[i].length-j-1] = temp;
            }
        }
        for (int i = 0; i <= n.length-1; i++){
            for (int j = 0; j <= n[i].length-1; j++) {
                System.out.print(n[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void sumOfColumn(double n[][]){
        int a[] = new int[n[0].length];
        int pos = 0;
        for (int j = 0; j <= n[0].length - 1; j++) {
            for (int i = 0; i <= n.length - 1; i++) {
                a[pos] += n[i][j];
            }
            pos++;
        }
        for (int i = 0; i <= a.length-1; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void sortArray(int n[][]){
        int temp = 0;
        for (int i = 0; i <= n.length - 1; i++){
            for (int j = 0; j <= n[i].length-2; j++){
                for (int k = j + 1; k <= n[i].length-1; k++){
                    if (n[i][j] > n[i][k]){
                        temp = n[i][k];
                        n[i][k] = n[i][j];
                        n[i][j] = temp;
                    }
                }
            }
        }
        for (int i = 0; i <= n.length - 1; i++) {
            for (int j = 0; j <= n[i].length - 1; j++) {
                System.out.print(n[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[]args){
        EvenMoreArray runner = new EvenMoreArray();
        char a[][] =  {{'h', 'e', 'l'}, {'l', 'o'}};
        int b[][] = {{1, 2, 3}, {4, 5}};
        double c[][] = {{1, 2, 3, 4}, {4, 5}};
        double d[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int e[][] = {{1, 3, 9, 7}, {6, 4, 3, 1}, {7, 2, 5, 6}, {5, 2, 3, 1}};
        runner.together(a);
        runner.matrix(5);
        runner.triangle(5);
        runner.zero(b);
        runner.reverse(c);
        runner.sumOfColumn(d);
        runner.sortArray(e);
    }
}
