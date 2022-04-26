import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
public class Translator {

    public static void main(String[]args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Translator runner = new Translator();

        HashMap<String, String> dictionary = new HashMap<String, String>();
        BufferedReader in  = new BufferedReader(new FileReader("EnglishToArabicDictionary.txt"));

        String FirstLine = in.readLine();

        String SecondLine = in.readLine();

        dictionary.put(FirstLine.substring(1), SecondLine);

        for (String line = in.readLine(); line != null; line = in.readLine()){
            dictionary.put(line, in.readLine());
        }

        in.close();

        while (true) {
            String a = scanner.nextLine();
            System.out.println(dictionary.get(a));
        }
    }
}
