import java.util.ArrayList;
import java.util.List;

public class KnowList {

    public ArrayList<Character> remove(ArrayList<Character> n){
        for (int i = 0; i <= n.size() - 1; i++) {
            n.remove(i);
        }
        return n;
    }

    public ArrayList<String> reverse(ArrayList<String> n){
        ArrayList<String> newList = new ArrayList<String>();
        int pos = n.size()-1;
        for (int i = 0; i <= n.size() - 1; i++) {
            newList.add(n.get(pos));
            pos--;
        }
        return newList;
    }

    public ArrayList<Double> doubleSum(ArrayList<Double> n){
        for (int i = 0; i <= n.size() - 1; i++) {
            n.set(i, n.get(i) * 2);
        }
        return n;
    }

    public ArrayList<Character> alphabet(int n){
        int pos = 97;
        ArrayList<Character> ans = new ArrayList<Character>();
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0){
                ans.add((char)(pos));
            }
            else{
                ans.add(0, (char)(pos));
            }
            pos++;
        }
        return ans;
    }

    public static void main(String[]args){
        KnowList runner = new KnowList();
        ArrayList<Character> a = new ArrayList<Character>();
        ArrayList<String> b = new ArrayList<String>();
        ArrayList<Double> c = new ArrayList<Double>();
        a.add('d');
        a.add('k');
        a.add('e');
        a.add('p');
        a.add('w');
        a.add('s');
        a.add('f');
        b.add("lists");
        b.add("are");
        b.add("great");
        c.add(1.0);
        c.add(2.0);
        c.add(4.0);
        System.out.println(runner.remove(a));
        System.out.println(runner.reverse(b));
        System.out.println(runner.doubleSum(c));
        System.out.println(runner.alphabet(5));
    }


}
