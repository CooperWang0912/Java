package com.example.More2D;

public class More2D {

    public int[][] matrix(int n, int m){
        int a[][] = new int[n][m];
        int num = 0;
        for (int i = 0; i <= n - 1; i++){
            for (int j = 0; j <= m -1; j++){
                a[i][j] = num;
                num++;
            }
        }
        for (int i = 0; i <= n - 1; i++){
            for (int j = 0; j <= m -1; j++){
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
        return a;
    }

    public double biggest(double n[][]){
        double max = n[0][0];
        for (int i = 0; i <= n.length-1; i++){
            for (int j = 0; j <= n[0].length-1; j++){
                if (n[i][j] > max){
                    max = n[i][j];
                }
            }
        }
        System.out.println(max);
        return max;
    }

    public int average(int n[][]){
        int sum = 0;
        for (int i = 0; i <= n.length-1; i++){
            for (int j = 0; j <= n[0].length-1; j++){
                sum += n[i][j];
            }
        }
        sum /= n.length * n[0].length;
        System.out.println(sum);
        return sum;
    }

    public int[] rowSum(int n[][]){
        int sum = 0;
        int pos = 0;
        int a[] = new int[n.length];
        for (int i = 0; i <= n.length-1; i++){
            sum = 0;
            for (int j = 0; j <= n[i].length-1; j++){
                sum += n[i][j];
            }
            a[pos] = sum;
            pos++;
        }
        for(int i = 0; i <= a.length-1; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        return a;
    }

    public boolean magic(int n[][]){
        boolean magicSqaure = true;
        if (n.length != n[0].length){
            magicSqaure = false;
        }
        else {
            int sum = 0;
            int pos = 0;
            int a[] = new int[n.length + 2];
            for (int i = 0; i <= n.length-1; i++){
                sum = 0;
                for (int j = 0; j <= n[i].length-1; j++){
                    sum += n[i][j];
                }
                a[pos] = sum;
                pos++;
            }
            sum = 0;
            for (int i = 0; i <= n.length-1; i++){
                sum += n[i][i];
            }
            a[pos] = sum;
            pos++;
            sum = 0;
            for (int i = 0; i <= n.length-1; i++){
                sum += n[i][n[0].length-1-i];
            }
            a[pos] = sum;
            for(int i = 0; i <= a.length-2; i++){
                for (int j = i + 1; j <= a.length-1; j++){
                    if (a[i] != a[j]){
                        magicSqaure = false;
                    }
                }
            }
        }
        System.out.println(magicSqaure);
        return magicSqaure;
    }

    public int nine(int n[][]){
        int sum = 0;
        int max = 0;
        int posX = 0;
        int posY = 0;
        for (int i = 0; i + 2 <= n.length-1; i++){
            for (int j = 0; j + 2 <= n[i].length-1; j++){
                if (j + 2 <= n[i].length-1 && j + 2 <= n[i+1].length-1 && j + 2 <= n[i+2].length-1) {
                    sum += n[i][j];
                    sum += n[i][j + 1];
                    sum += n[i][j + 2];
                    sum += n[i + 1][j];
                    sum += n[i + 1][j + 1];
                    sum += n[i + 1][j + 2];
                    sum += n[i + 2][j];
                    sum += n[i + 2][j + 1];
                    sum += n[i + 2][j + 2];
                }
                if (sum > max){
                    max = sum;
                    posY = i;
                    posX = j;
                }
            }
        }
        System.out.println(n[posY][posX]);
        return n[posY][posX];
    }

    public static void main(String[]args){
        More2D runner = new More2D();
        double a[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {12, 11, 11}};
        int b[][] = {{1, 2, 3}, {4, 5, 6}};
        int c[][] = {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};
        int d[][] = {{1, 2, }, {4, 5, 6}, {7, 8, 9}, {12, 11,11}};
        runner.matrix(5, 6);
        runner.biggest(a);
        runner.average(b);
        runner.rowSum(b);
        runner.magic(c);
        runner.nine(d);
    }
}
