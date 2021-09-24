package com.example.If;


public class If {

    public static void pos(int a){
        if(a > 0){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }

    public static void even(int a){
        if(a % 2 == 0){
            System.out.println("Even");
        }
        else{
            System.out.println("No");
        }
    }

    public static void character(char a){
        if(a >= 65 && a <= 90){
            System.out.println("Uppercase");
        }
        if(a >= 97 && a <= 122){
            System.out.println("Lowercase");
        }
        else{
            System.out.println("N/A");
        }
    }

    public static void ten(int a){
        if (a % 10 == 0){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }

    public static void maximum(double a, double b, double c){
        if (a >= b){
            if (a >= c){
                System.out.println(a);
            }
            if (a < c){
                System.out.println(c);
            }
        }
        if (b > a){
            if (b >= c){
                System.out.println(b);
            }
            if (b < c){
                System.out.println(c);
            }
        }
    }

    public static void main(String[]args){
        pos(1);
        even(1);
        character('a');
        ten(100);
        maximum(5.0,6.0,7.0);
    }
}
