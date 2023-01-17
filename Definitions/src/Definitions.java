import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Definitions {



    public static void main(String[]args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        BufferedReader reader = new BufferedReader(new FileReader("wordDictionary.txt"));

        HashMap<String, String> words = new HashMap<String, String>();

        String line;

        for(line = reader.readLine(); reader.readLine() != null; line = reader.readLine()){
            for (int i = 0; i <= line.length() - 1; i++){
                if (line.charAt(i) == '|'){
                    words.put(line.substring(0, i), line.substring(i));
                    break;
                }
            }
        }

        reader.close();

        for (int i = 0; i <= line.length() - 1; i++){
            if (line.charAt(i) == '|'){
                words.put(line.substring(0, i), line.substring(i));
                break;
            }
        }

        String input = scanner.nextLine();

        while(!input.equals("close")){
            if (words.get(input) != null){
                System.out.println(words.get(input));
                input = scanner.nextLine();
            }
            else{
                System.out.println("The word does not exist, please try again");
                input = scanner.nextLine();
            }
        }
    }
}
