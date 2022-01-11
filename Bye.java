package com.example.Bye;

public class Bye {

    public void pigLatin(String n){
        String a = "";
        for (int i = 1; i <= n.length()-1; i++){
            a += n.charAt(i);
        }
        a += n.charAt(0);
        a += "ay";
        System.out.println(a);
    }

    public void replace(String n, char m){
        for (int i = 0; i <= n.length()-1; i++){
            if (n.charAt(i) == m){
                System.out.println("$");
            }
            else{
                System.out.println(n.charAt(i));
            }
        }
    }

    public void longest(String n[]){
        int max = n[0].length();
        int pos = 0;
        for (int i = 0; i <= n.length-1; i++){
            if (n[i].length() > max){
                pos = i;
                max = n[i].length();
            }
        }
        System.out.println(n[pos]);
    }

    public static void main(String[]args){
        Bye runner = new Bye();
        String a = "pig";
        String b[] = {"hi", "hello", "bye"};
        runner.pigLatin(a);
        runner.replace("hello",'l');
        runner.longest(b);
    }

}
