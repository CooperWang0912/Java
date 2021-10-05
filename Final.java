package com.example.Final;
import java.util.Scanner;

public class Final {
    public static String str1;
    public static String str2;
    public String replace;
    static Scanner scanner = new Scanner(System.in);

    public void base10(int a, int b, int c, int d, int e){
        System.out.println(a*16 + b*8 + c*4 + d*2 + e);
    }

    public void strSwitch(String a, String b){
        replace = a;
        a = b;
        b = replace;
        System.out.println(a);
        System.out.println(b);
    }

    public void divide(int a){
        System.out.println((a/1000) % (a%10));
        System.out.println((a/1000) % ((a%100)/10));
        System.out.println((a/1000) % ((a%1000)/100));
    }

    public void letter(int a, int b){
        if ((a+b >= 65 && a+b <= 90) || (a+b >= 97 && a+b <= 122)){
            System.out.println((char)(a+b));
        }
        else if(a+b < 65){
            System.out.println('A');
        }
        else if(a+b > 90 && a+b <= 93){
            System.out.println('Z');
        }
        else if(a+b > 93 && a+b < 97){
            System.out.println('a');
        }
        else if(a+b > 122){
            System.out.println('z');
        }
    }

    public static void main(String[]args){
        Final runner = new Final();
        str1 = scanner.next();
        str2 = scanner.next();
        runner.base10(1,0,1,1,1);
        runner.strSwitch(str1,str2);
        runner.divide(34924);
        runner.letter(90, 3);
    }
}
