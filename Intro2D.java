package com.example.Intro2D;

public class Intro2D {

    /*
    A. 0
    B. 1
    C. Out of bound
    D. 3
    E. k
    F. Out of bound
    G. 105
    H. o
    I. 7, 6
    */

    public void matrix(int n){
        int a[][] = new int[n][n];
        int num = 0;
        for (int i = 0; i <= n - 1; i++){
            for (int j = 0; j <= n -1; j++){
                a[i][j] = num;
                num++;
            }
        }
        for (int i = 0; i <= n - 1; i++){
            for (int j = 0; j <= n -1; j++){
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }

    public void whatNum(int n[][]){
        int column = n[0].length;
        System.out.println(column);
        int row = n.length;
        System.out.println(row);
    }

    public void six(int n, int m, int k, int x, int y, int z){
        int a[][] = new int[3][];
        a[0] = new int[3];
        a[1] = new int[2];
        a[2] = new int[1];
        a[0][0] = n;
        a[0][1] = m;
        a[0][2] = k;
        a[1][0] = x;
        a[1][1] = y;
        a[2][0] = z;
        System.out.print(a[0][0] + " ");
        System.out.print(a[0][1] + " ");
        System.out.print(a[0][2] + " ");
        System.out.println();
        System.out.print(a[1][0] + " ");
        System.out.print(a[1][1] + " ");
        System.out.println();
        System.out.print(a[2][0] + " ");
    }

    public static void main(String[]args){
        Intro2D runner = new Intro2D();
        int a[][] = {{1, 2, 3, 4}, {4, 5, 6, 9}, {7, 8, 9, 10}, {7, 8, 9, 10}};
        runner.matrix(6);
        runner.whatNum(a);
        runner.six(1, 2, 3, 4, 5, 6);
    }
}
