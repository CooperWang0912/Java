package com.example.Final;

public class Final {

    public void indexWeightedSum(double n[]){
        double sum = 0;
        for (int i = 0; i <= n.length - 1; i++){
            sum += n[i] * i;
        }
        System.out.println(sum);
    }

    public void charsToString(char n[]){
        String a = "";
        for (int i = 0; i <= n.length - 1; i++){
            if (n[i] >= 97 && n[i] <= 122){
                a += n[i];
            }
        }
        System.out.println(a);
    }

    public void ifSum(int n[], int m){
        boolean a = false;
        for (int i = 0; i <= n.length - 2; i++){
            if (n[i] + n[i + 1] == m){
                a = true;
            }
        }
        if (a == true){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }

    public void mostChar(char n[]){
        int alpha[] = new int[26];
        int max;
        int pos = 0;
        for (int i = 0; i <= n.length - 1; i++){
            alpha[n[i] - 97]++;
        }
        max = alpha[0];
        for (int i = 0; i <= alpha.length - 1; i++){
            if (alpha[i] > max){
                max = alpha[i];
                pos = i;
            }
        }
        System.out.println((char)(pos + 97));
    }

    public static void main(String[]args){
        Final runner = new Final();
        double a[] = {5.8, 3.1, 2.5};
        char b[] = {'h', 'i', '!', 'H', 'e', 'l', 'L', 'o', '?'};
        int c[] = {1,5,2,7,3};
        char d[] = {'h', 'k', 'h', 'u', 'b', 'e', 'k', 'u', 'u'};
        int e = 9;
        runner.indexWeightedSum(a);
        runner.charsToString(b);
        runner.ifSum(c, e);
        runner.mostChar(d);
    }

}
