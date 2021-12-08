package com.example.MoreString;

import java.lang.reflect.Array;

public class MoreString {

    public void startEnd(String n){
        System.out.println(n.substring(0, 2).equals(n.substring(n.length()-2)));
    }

    public void contain(String n, String m){
        for (int i = 0; i <= m.length()-1; i++){
            boolean a = false;
            System.out.print(m.charAt(i) + " ");
            for (int j = 0; j <= n.length()-1; j++){
                if (m.charAt(i) == n.charAt(j)){
                    a = true;
                }
            }
            if (a == true){
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }
    }

    public void words(String n){
        int num = 1;
        for (int i = 0; i <= n.length()-1; i++){
            if (n.charAt(i) == ' '){
                num++;
            }
        }
        System.out.println(num);
    }

    public void addArray(String n){
        int num = 1;
        int pos  = 0;
        int start = 0;
        int end  = 0;
        int count = 0;
        for (int i = 0; i <= n.length()-1; i++){
            if (n.charAt(i) == ' '){
                num++;
            }
        }
        String a[] = new String[num];
        for (int i = 0; i <= n.length()-1; i++){
            if (n.charAt(i) == ' '){
                end = i;
                a[pos] = n.substring(start, end);
                start = i + 1;
                pos++;
                count++;
            }
            if (count == num - 1){
                a[pos] = n.substring(start);
            }
        }
        for (int i = 0; i <= num - 1; i++){
            System.out.print(a[i] + " ");
        }
    }

    public void takeEOut(String n){
        String a = "";
        for (int i = 0; i <= n.length()-1; i++){
            if (n.charAt(i) != 'e'){
                a += n.charAt(i);
            }
        }
        System.out.println(a);
    }

    public void palindrome(String n){
        boolean a = true;
        for (int i = 0; i <= n.length()/2-1; i++){
            if (n.charAt(i) != n.charAt(n.length()-1-i)){
                a = false;
            }
        }
        System.out.println(a);
    }

    public void longestBlock(String n){
        char a = n.charAt(0);
        int num = 1;
        int tempNum = 1;
        for (int i = 1; i <= n.length()-1; i++){
            if (a == n.charAt(i)){
                tempNum++;
            }
            if (a != n.charAt(i)){
                a = n.charAt(i);
                if (tempNum > num){
                    num = tempNum;
                }
                tempNum = 1;
            }
        }
        System.out.println(num);
    }

    public static void main(String[]args){
        MoreString runner = new MoreString();
        String a = "edit";
        String b = "Hello World";
        String c = "leg";
        String d = "I love me";
        String e = "let's eat there";
        String f = "madam";
        String g = "ipioocd";
        String h = "AP CS is for nerds";
        runner.startEnd(a);
        runner.contain(b, c);
        runner.words(d);
        runner.takeEOut(e);
        runner.palindrome(f);
        runner.longestBlock(g);
        runner.addArray(h);
    }
}
