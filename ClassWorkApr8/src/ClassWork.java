import java.util.ArrayList;

public class ClassWork {

    ArrayList<String> an = new ArrayList<String>();

    public ArrayList<Integer> relativeMaximum(double n[]){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (n[0] > n[1]){
            ans.add(0);
        }
        for (int i = 1; i <= n.length - 2; i++){
            if (n[i] > n[i-1] && n[i] > n[i+1]){
                ans.add(i);
            }
        }
        if (n[n.length-1] > n[n.length-2]){
            ans.add(n.length-1);
        }
        return ans;
    }

    public ArrayList<String> jumble(String s, String ans){
        if (s.length() == 0) {
            an.add(ans);
        }
        for (int i = 0; i <= s.length() - 1; i++){
            char a = s.charAt(i);
            jumble(s.substring(0, i) + s.substring(i + 1), ans + a);
        }
        return an;
    }

    public static void main(String[]args){
        ClassWork runner = new ClassWork();
        double a[] = {3, 2, 1, 2, 1};
        System.out.println(runner.relativeMaximum(a));
        String b = "why";
        System.out.println(runner.jumble(b, ""));
    }

}
