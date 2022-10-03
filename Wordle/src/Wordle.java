import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Wordle {

    public String check(String n, String m, HashMap<Character, Integer> l, HashMap<Character, Character> p){
        String ans = "";
        for (int i = 0 ; i <= 4; i++){
            if (n.charAt(i) == m.charAt(i)){
                l.put(n.charAt(i), l.get(n.charAt(i)) - 1);
            }
        }
        for (int i = 0; i <= 4; i++){
            if (n.charAt(i) == m.charAt(i)){
                ans += 'o';
                l.put(n.charAt(i), l.get(n.charAt(i)) - 1);
            }
            else if(l.get(n.charAt(i)) != null && l.get(n.charAt(i)) > 0){
                ans += '/';
                l.put(n.charAt(i), l.get(n.charAt(i)) - 1);
            }
            else{
                ans += 'x';
                p.put(n.charAt(i), '#');
            }
        }
        return ans;
    }

    public static void main(String[]args) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("word.txt"));

        BufferedReader test = new BufferedReader(new FileReader("answer.txt"));

        BufferedReader word = new BufferedReader(new FileReader("answer.txt"));

        HashMap<String, Boolean> wordMap = new HashMap<String, Boolean>();

        HashMap<Character, Integer> number = new HashMap<Character, Integer>();

        HashMap<Character, Character> alphabet = new HashMap<Character, Character>();

        String guesses[] = new String[12];

        Scanner scanner = new Scanner(System.in);

        Wordle runner = new Wordle();

        String answer = "";

        String input = "";

        String guess = "";

        boolean won = false;

        char res = 0;

        for (String line = in.readLine(); line != null; line = in.readLine()) {
            wordMap.put(line, true);
        }
        in.close();

        int num = 0;

        for (String temp = test.readLine(); temp != null; temp = test.readLine()){
            num++;
        }
        test.close();

        int ran = (int) (Math.random() * num);

        for (int i = 0; i <= ran; i++){
            answer = word.readLine();
        }

        System.out.println(answer);

        for (int i = 0; i <= answer.length() - 1; i++){
            if(number.get(answer.charAt(i)) != null){
                number.put(answer.charAt(i), number.get(answer.charAt(i)) + 1);
            }
            else{
                number.put(answer.charAt(i), 1);
            }
        }

        for (int i = 97; i <= 122; i++){
            alphabet.put((char)i, (char)i);
        }

        for (int i = 0; i <= 11; i++){
            guesses[i] = "_____";
        }

        for(int i = 1 ; i <= 6; i++){
            System.out.println("Please input a five letter guess");
            System.out.println("o = correct, / = not in the right place, x = wrong");
            System.out.println("Letters left: " + alphabet.values());
            for (int j = 0; j <= 11; j++){
                System.out.println(guesses[j]);
            }
            System.out.println("What is your guess?");
            guess = "";
            input = scanner.nextLine();
            for (int j = 0; j <= 4; j++){
                if (input.charAt(j) >= 65 && input.charAt(j) <= 90){
                    guess += (char)(input.charAt(j) + 32);
                }
                else{
                    guess += input.charAt(j);
                }
            }
            number.clear();
            for (int j = 0; j <= answer.length() - 1; j++){
                if(number.get(answer.charAt(j)) != null){
                    number.put(answer.charAt(j), number.get(answer.charAt(j)) + 1);
                }
                else{
                    number.put(answer.charAt(j), 1);
                }
            }
            if (wordMap.get(guess) != null){
                guesses[(i-1) * 2] = guess;
                guesses[(i-1) * 2 + 1] = runner.check(guess, answer, number, alphabet);
                System.out.println(guesses[(i-1) * 2 + 1]);
                System.out.println();
                if (runner.check(guess, answer, number, alphabet).equals("ooooo")){
                    won = true;
                    System.out.println("You Won!");
                    break;
                }
            }
            else{
                System.out.println("Not a valid guess, please try again");
                System.out.println();
                i--;
            }
        }

        if (won == false){
            for (int i = 0; i <= 11; i++){
                System.out.println(guesses[i]);
            }
            System.out.println("You Lost!");
            System.out.println("The answer is " + answer);
        }
    }
}
