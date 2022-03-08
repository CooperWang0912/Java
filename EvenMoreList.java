import java.util.ArrayList;

public class EvenMoreList {

    public ArrayList<Double> random(int n, int x){
        ArrayList<Double> ans = new ArrayList<Double>();
        double ran;
        for (int i = 1; i <= n; i++){
            ran = Math.random();
            if (ran <= 0.5){
                ans.add(Math.random() * x * -1);
            }
            else{
                ans.add(Math.random() * x);
            }
        }
        return ans;
    }

    public void posNeg(ArrayList<Integer> n){
        ArrayList<Integer> pos = new ArrayList<Integer>();
        ArrayList<Integer> neg = new ArrayList<Integer>();
        for (int i = 0; i <= n.size() - 1; i++){
            if (n.get(i) < 0){
                neg.add(n.get(i));
            }
            if (n.get(i) >= 0){
                pos.add(n.get(i));
            }
        }
        System.out.println(pos);
        System.out.println(neg);
    }

    public void reverse(ArrayList<Double> n){
        double temp = 0;
        for (int i = 0; i <= (n.size() - 1) / 2; i++){
            temp = n.get(i);
            n.set(i, n.get(n.size() - i - 1));
            n.set(n.size() - i - 1, temp);
        }
    }

    public static void main(String[]args){
        EvenMoreList runner = new EvenMoreList();
        System.out.println(runner.random(5, 10));
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(-9);
        a.add(3);
        a.add(42);
        a.add(-17);
        a.add(-19);
        runner.posNeg(a);
        ArrayList<Double> b = new ArrayList<Double>();
        b.add(1.0);
        b.add(2.0);
        b.add(3.0);
        b.add(4.0);
        b.add(5.0);
        runner.reverse(b);
        System.out.println(b);
    }

}
