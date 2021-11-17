package com.example.MoreArray;

public class MoreArray {

    public String[] posNeg(int n[]){
        String a[] = new String[n.length];
        for (int i = 0; i <= n.length-1; i++){
            if (n[i] > 0){
                a[i] = "pos";
            }
            else if (n[i] < 0){
                a[i] = "neg";
            }
            else{
                a[i] = "zero";
            }
        }
        for (int i = 0; i <= n.length-1; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        return a;
    }

    public boolean contain(char n, char m[]){
        boolean a = false;
        for (int i = 0; i <= m.length-1; i++){
            if (m[i] == n){
                a = true;
            }
        }
        System.out.println(a);
        return a;
    }

    public int containStr(String n, String m[]){
        int a = -1;
        for (int i = 0; i <= m.length-1; i++){
            if (m[i].equals(n)){
                a = i;
            }
        }
        System.out.println(a);
        return a;
    }

    public double minimum(double n[]){
        double a = n[0];
        for (int i = 0; i <= n.length-1; i++){
            if (n[i] < a){
                a = n[i];
            }
        }
        System.out.println(a);
        return a;
    }

    public int[] sum(int n[], int m[]){
        int a[] = new int[n.length];
        for (int i = 0; i <= n.length-1; i++){
            a[i] = n[i] + m[i];
        }
        for (int i = 0; i <= n.length-1; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        return a;
    }

    public void common(int n[], int m[]){
        for (int i = 0; i <= n.length-1; i++){
            for (int j = 0; j <= m.length-1; j++){
                if (n[i] == m[j]){
                    System.out.print(n[i] + " ");
                }
            }
        }
        System.out.println();
    }

    public void unique(int n[]){
        for (int i = 0; i <= n.length-1; i++){
            boolean uni = true;
            for (int j = i + 1; j <= n.length-1; j++){
                if (n[i] == n[j]){
                    uni = false;
                }
            }
            if (uni == true){
                System.out.print(n[i] + " ");
            }
        }
        System.out.println();
    }

    public int[] digits(int n){
        int a = n;
        int m = 0;
        while (a >= 1){
            a = a /10;
            m++;
        }
        int b[] = new int[m];
        for (int i = m-1; i >= 0; i--){
            b[i] = n % 10;
            n = n / 10;
        }
        for (int i = 0; i <= m-1; i++){
            System.out.print(b[i] + " ");
        }
        System.out.println();
        return b;
    }

    public int[] noDuplicates(int n[]){
        int num = 0;
        int seq = 0;
        for (int i = 0; i <= n.length-1; i++){
            boolean uni = true;
            for (int j = i + 1; j <= n.length-1; j++){
                if (n[i] == n[j]){
                    uni = false;
                }
            }
            if (uni == true){
                num++;
            }
        }
        int clean[] = new int[num];
        for (int i = 0; i <= n.length-1; i++){
            boolean uni = true;
            for (int j = i + 1; j <= n.length-1; j++){
                if (n[i] == n[j]){
                    uni = false;
                }
            }
            if (uni == true){
                clean[seq] = n[i];
                seq++;
            }
        }
        for (int i = 0; i <= clean.length-1; i++){
            System.out.print(clean[i] + " ");
        }
        return clean;
    }



    public static void main(String[]args){
        MoreArray runner = new MoreArray();
        int a[] = {-4,6,2,-1,-6,9};
        char b[] = {'i','g','o','d'};
        String c[] = {"man", "CS", "rocks"};
        double d[] = {2, 3, 1, 4, 5};
        int e[] = {5, 3, 7};
        int f[] = {3, 8, 9};
        int g[] = {4,1,7,3,4};
        int h[] = {8,2,3,4};
        int k[] = {6, 6, 3, 9, 4, 3, 2};
        int l[] = {5, 3, 5, 7, 2, 3};
        runner.posNeg(a);
        runner.contain('c', b);
        runner.containStr("CS", c);
        runner.minimum(d);
        runner.sum(e, f);
        runner.common(g, h);
        runner.unique(k);
        runner.digits(56723);
        runner.noDuplicates(l);
    }

}
