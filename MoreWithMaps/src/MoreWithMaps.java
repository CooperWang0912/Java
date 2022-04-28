import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MoreWithMaps {

    public int stocks(HashMap<String, Integer> a, String n){
        int num = 0;
        int sum = 0;
        int largest = 0;
        for (String name : a.keySet()){
            if (a.get(name) > largest) {
                largest = a.get(name);
            }
        }
        if (n.equals("average")){
            for (String name : a.keySet()){
                sum += a.get(name);
                num++;
            }
            return sum / num;
        }
        else if (a.get(n) == null){
            return largest;
        }
        else{
            return a.get(n);
        }
    }

    public void doubleONine(HashMap<String, String> a, String n){
        String target = a.get(n);
        System.out.println(n);
        while (!target.equals(n)){
            System.out.println(target);
            target = a.get(target);
        }
    }

    public String morseCode(String n){
        HashMap<Character, String> morse = new HashMap<Character, String>();
        String ans = "";
        morse.put('a', "._");
        morse.put('b', "_...");
        morse.put('c', "_._.");
        morse.put('d', "_..");
        morse.put('e', ".");
        morse.put('f', ".._.");
        morse.put('g', "__.");
        morse.put('h', "....");
        morse.put('i', "..");
        morse.put('j', ".___");
        morse.put('k', "_._");
        morse.put('l', "._..");
        morse.put('m', "__");
        morse.put('n', "_.");
        morse.put('o', "___");
        morse.put('p', ".__.");
        morse.put('q', "__._");
        morse.put('r', "._.");
        morse.put('s', "...");
        morse.put('t', "_");
        morse.put('u', ".._");
        morse.put('v', "..._");
        morse.put('w', ".__");
        morse.put('x', "_.._");
        morse.put('y', "_.__");
        morse.put('z', "__..");
        for (int i = 0; i <= n.length() - 1; i++){
            ans += morse.get(n.charAt(i)) + " ";
        }
        return ans;
    }

    public void fiveMostWords() throws IOException {
        HashMap<String, Integer> num = new HashMap<String, Integer>();
        BufferedReader in  = new BufferedReader(new FileReader("Test.txt"));
        String line = in.readLine();
        while (line != null){
            String words[] = line.split(" ");
            for (int i = 0; i <= words.length - 1; i++){
                if (num.get(words[i]) == null){
                    num.put(words[i], 1);
                }
                else{
                    num.put(words[i], num.get(words[i]) + 1);
                }
            }
            line = in.readLine();
        }
        String MostWord[] = new String[5];
        int MostWordNum[] = {0, 0, 0, 0, 0};
        int min;
        int index;
        for (String name : num.keySet()) {
            min = MostWordNum[0];
            index = 0;
            for (int i = 0; i <= MostWord.length - 1; i++){
                if (MostWordNum[i] < min){
                    min = MostWordNum[i];
                    index = i;
                }
            }
            if (num.get(name) != null && num.get(name) > min){
                MostWord[index] = name;
                MostWordNum[index] = num.get(name);
            }
        }
        for (int i = 0; i <= MostWord.length - 1; i++){
            System.out.println(MostWord[i]);
        }
    }

    public int fibonacci(int n){
        HashMap<Integer, Integer> num = new HashMap<Integer, Integer>();
        if (n <= 1){
            return 1;
        }
        if (num.get(n) != null){
            return num.get(n);
        }
        num.put(n, fibonacci(n - 1) + fibonacci(n - 2));
        return num.get(n);
    }

    public static void main(String[]args) throws IOException {
        HashMap<String, Integer> a = new HashMap<String, Integer>();
        HashMap<String, String> b = new HashMap<String, String>();
        a.put("apple", 700);
        a.put("ibm", 400);
        a.put("tesla", 1000);
        b.put("Ryan", "Yumna");
        b.put("Cooper", "Anika");
        b.put("Anika", "Ryan");
        b.put("Yumna", "Cooper");
        MoreWithMaps runner = new MoreWithMaps();
        System.out.println(runner.stocks(a, "average"));
        runner.doubleONine(b, "Cooper");
        System.out.println(runner.morseCode("hello"));
        runner.fiveMostWords();
        System.out.println(runner.fibonacci(30));
    }

}
