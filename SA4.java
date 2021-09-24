package com.example.fhw;

public class SA4 {

    // create your methods here
    public void distance(double x1, double y1, double x2, double y2){
        System.out.println(Math.sqrt(Math.pow(Math.abs(x2-x1), 2)+ (Math.pow(Math.abs(y2-y1), 2))));
    }

    public void quadratic(int a, int b, int c){
        System.out.println((-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a));
        System.out.println((-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a));
    }

    public void charAverage(char a, char b){
        System.out.println((char)(int)((a + b)/2));
    }

    public static void main(String[] args) {

        SA4 tester = new SA4();

        // prints out the distance between two points
        // output should be 6.83
        tester.distance(1, -2.5, 3.1, 4);

        // prints out a solution to y = ax^2 + bx + c, where the
        // three parameters are a, b, and c. Use the quadratic equation
        // output should be 2 or -2 (challenge: give both solutions)
        tester.quadratic(1, 0, -4);

        // prints out the 'average' of two characters
        // output should be 'W'
        tester.charAverage('m', 'A');
    }

}
