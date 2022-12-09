import java.io.*;
import java.util.*;
public class queue_test {

    static Scanner in=new Scanner(System.in);

    public static void starbucks() {
        Queue<String> q=new LinkedList<>();
        System.out.println("input  in + item name to add item in line   or   out to see next item:");
        boolean endOfDay=false;
        while(!endOfDay) {
            String str=in.nextLine();
            if(str.equals("6pm")){
                endOfDay = true;
            }
            else if(str.equals("in")){
                System.out.println("input the drink/food you want");
                q.add(in.nextLine());
            }
            else if(str.equals("out")){
                if (q.isEmpty()){
                    System.out.println("The line is empty");
                }
                else{
                    System.out.println("The next item is: " + q.poll());
                }
            }
        }
        System.out.println("see you tmr");
    }


    public static void generateBinaryNumber(int n) {
        System.out.println("When n is "+ n);
        Queue<String> q = new LinkedList<>();//a queue
        //your code here
        q.add("1");
        for (int i = 1; i <= n; i++){
            String curr = q.poll();
            System.out.println(curr);
            q.add(curr + "0");
            q.add(curr + "1");
        }
//        for (int i = 1; i <= n; i++){
//            q.add(Integer.toBinaryString(i));
//            System.out.println(q.poll());
//        }
    }


    public static void zerosAndNines(int n) {
        System.out.println("When n is "+ n);
        Queue<Integer> q=new LinkedList<>();//a queue
        boolean unfound = true;
        q.add(9);
        while (unfound){
            int curr = q.poll();
            if (curr % n == 0){
                System.out.println(curr);
                unfound = false;
            }
            else{
                q.add(curr * 10);
                q.add(curr * 10 + 9);
            }
        }
        //your code here
    }

    public static void main(String[] args) {
//		starbucks();
//		generateBinaryNumber(in.nextInt());
		zerosAndNines(in.nextInt());
        in.close();
    }
}
