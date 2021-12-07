package com.example.IntroString;

public class IntroString {

    public void secondHalf(String n){
        System.out.println(n.substring(n.length()/2));
    }

    public void concatenate(String n, String m){
        String a = n.substring(1);
        a += m.substring(1);
        System.out.println(a);
    }

    public void adverb(String n){
        boolean a = false;
        if (n.substring(n.length()-2).equals("ly")){
            a = true;
        }
        if (a == true){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }

    public void contain(String n, String m){
        boolean a = false;
        for (int i = 0; i <= n.length() - 2; i++){
            for (int j = i + 1; j <= n.length() - 1; j++){
                if (n.substring(i, j).equals(m)){
                    a = true;
                }
            }
        }
        if (a == true){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }

    public void backward(String n){
        for (int i = n.length() - 1; i >= 0; i--){
            System.out.print(n.charAt(i));
        }
        System.out.println();
    }

    public void jumble(String n){
        int start  = 0;
        for (int i = 1; i <= n.length(); i++){
            for (int j = start; j <= start + n.length() - 1; j++){
                System.out.print(n.charAt(j % n.length()));
            }
            System.out.println();
            start++;

        }
    }


    public static void main(String[]args){
        IntroString runner = new IntroString();
        String a = "hi there";
        String b = "hello";
        String c = "there";
        String d = "fast";
        String e = "hippo";
        String f = "hit";
        String g = "hello";
        runner.secondHalf(a);
        runner.concatenate(b, c);
        runner.adverb(d);
        runner.contain(e, f);
        runner.backward(g);
        runner.jumble(b);
    }
}
