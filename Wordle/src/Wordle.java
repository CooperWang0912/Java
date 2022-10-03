import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Wordle {

    public String check(String n, String m, HashMap<Character, Integer> l, HashMap<Character, Character> p){ //The function used to check if the guess is correct
        String ans = ""; //Initializing the variable for the result
        for (int i = 0 ; i <= 4; i++){ //Going through the answer and reducing the number of the letter if the letter in the guess is correct
            if (n.charAt(i) == m.charAt(i)){
                l.put(n.charAt(i), l.get(n.charAt(i)) - 1);
            }
        }
        for (int i = 0; i <= 4; i++){ //Going through the guess
            if (n.charAt(i) == m.charAt(i)){ //If the letter is in the right place
                ans += 'o'; //Adding o to the result
            }
            else if(l.get(n.charAt(i)) != null && l.get(n.charAt(i)) > 0){ //If the letter is correct but in the wrong place and the word still needs at least one of this letter
                ans += '/'; //Adding / to the result
                l.put(n.charAt(i), l.get(n.charAt(i)) - 1); //Reduce 1 from the letters in the answer
            }
            else{
                ans += 'x'; //Adding x to the result
                p.put(n.charAt(i), '#'); //Reduce 1 from the letters in the answer
            }
        }
        return ans; //return the result
    }

    public static void main(String[]args) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("word.txt")); //Read the file for the words in the dictionary

        BufferedReader test = new BufferedReader(new FileReader("answer.txt")); //Read the file for the list of hidden words to choose from

        BufferedReader word = new BufferedReader(new FileReader("answer.txt")); //Read the file for the list of hidden words to choose from

        HashMap<String, Boolean> wordMap = new HashMap<String, Boolean>(); //The map used to store the words in the dictionary

        HashMap<Character, Integer> number = new HashMap<Character, Integer>(); //The map used to store the number of each letter in the answer

        HashMap<Character, Character> alphabet = new HashMap<Character, Character>(); //The map used to store the remaining letters that can be used

        String guesses[] = new String[12]; //The array used to store the guesses and the results

        Scanner scanner = new Scanner(System.in); //The scanner used to take user inputs

        Wordle runner = new Wordle(); //The runner for the program

        String answer = ""; //The variable used to store the answer

        String input = ""; //The variable used to store the input

        String guess = ""; //The variable used to test the guess

        boolean won = false; //The boolean used to determine if the user has won the game

        for (String line = in.readLine(); line != null; line = in.readLine()) { //Go through the list of words in the dictionary
            wordMap.put(line, true); //Put true for every word
        }
        in.close(); //Quit the reader

        int num = 0; //The variable used to determine how many words are in the list

        for (String temp = test.readLine(); temp != null; temp = test.readLine()){ //Go through the list
            num++; //Add numbers to the variable
        }
        test.close();

        int ran = (int) (Math.random() * num); //The number used to randomly pick a word from the list

        for (int i = 0; i <= ran; i++){ //Go through the list and pick the word according to the random number
            answer = word.readLine();
        }

        for (int i = 0; i <= answer.length() - 1; i++){ //Go through the answer and Calculate what characters and how many of them are in the guess
            if(number.get(answer.charAt(i)) != null){
                number.put(answer.charAt(i), number.get(answer.charAt(i)) + 1); //Add 1 to the existing value if it has already appeared before
            }
            else{
                number.put(answer.charAt(i), 1); //Change the number to 1 if the letter has not been stored yet
            }
        }

        for (int i = 97; i <= 122; i++){ //Go through the alphabet for lowercase letters
            alphabet.put((char)i, (char)i); //Store them in the map
        }

        for (int i = 0; i <= 11; i++){ //Initialize the array used to store the guesses and the results
            guesses[i] = "_____";
        }

        System.out.println("Welcome to Wordle"); //Notify the user what game this is

        for(int i = 1 ; i <= 6; i++){ //The user has six tries
            System.out.println("Please input a five letter guess"); //Prompt the user to input a five letter guess
            System.out.println("o = correct, / = not in the right place, x = wrong"); //What does each symbol in the result mean
            System.out.println("Letters left: " + alphabet.values()); //Print out the letter bank
            for (int j = 0; j <= 11; j++){ //Print out the array
                System.out.println(guesses[j]);
            }
            System.out.println("What is your guess?"); //Prompt the user to input
            guess = "";
            input = scanner.nextLine(); //Takes in the input
            for (int j = 0; j <= 4; j++){ //Go through the input
                if (input.charAt(j) >= 65 && input.charAt(j) <= 90){ //If the character is capitalized
                    guess += (char)(input.charAt(j) + 32); //Add 32 to the ascii number to make it lowercase
                }
                else{
                    guess += input.charAt(j); //Add the character to the guess
                }
            }
            number.clear(); //Clean the map of the number of letters in the answer
            for (int j = 0; j <= answer.length() - 1; j++){ //Same process as above, the map needs to be recalculated after every guess
                if(number.get(answer.charAt(j)) != null){
                    number.put(answer.charAt(j), number.get(answer.charAt(j)) + 1);
                }
                else{
                    number.put(answer.charAt(j), 1);
                }
            }
            if (wordMap.get(guess) != null){ //If the guess is a word in the list of words in the dictionary
                guesses[(i-1) * 2] = guess; //Store the guess
                guesses[(i-1) * 2 + 1] = runner.check(guess, answer, number, alphabet); //Use the check function and store the result
                System.out.println(guesses[(i-1) * 2 + 1]); //Print out the result
                System.out.println(); //Next line
                if (guesses[(i-1) * 2 + 1].equals("ooooo")){ //If the answer is correct
                    won = true; //The user won
                    System.out.println("You Won!"); //Print out You Won
                    break; //Stop the program
                }
            }
            else{ //If the word is not a word in the list of words in the dictionary
                System.out.println("Not a valid guess, please try again"); //Prompt the user to try again
                System.out.println(); //Next line
                i--; //Reset the number of tries the user has
            }
        }

        if (won == false){ //If the user ran out of tries and did not win
            for (int i = 0; i <= 11; i++){ //Print out the array of guesses and results
                System.out.println(guesses[i]);
            }
            System.out.println("You Lost!"); //Print out You Lost
            System.out.println("The answer is " + answer); //Print out the answer
        }
    }
}
