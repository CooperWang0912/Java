import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Decompressor {

    public static void main(String[]args) throws IOException {

        BufferedReader in  = new BufferedReader(new FileReader("map")); //create new file reader

        HashMap<String, Character> codeMap = new HashMap<String, Character>(); //create new code map

        String map = ""; //the string that holds the code

        String symbol = ""; //the string that holds the character

        String val = ""; //the string that holds the leftover code

        while ((map = in.readLine()) != null){ //goes through the file
            symbol = in.readLine(); //set symbol to the next line
            if (map.equals("stop")){ //if reaches the end of the map
                val = symbol; //set the leftover code to next line
                break; //end loop
            }
            if (symbol.equals("")){ //if symbol is empty
                in.readLine(); //jump one line
                codeMap.put(map, '\n'); //set the code to equal '\n'
            }
            else {
                codeMap.put(map, symbol.charAt(0)); //put the code and the character into the map
            }
        }


//        Code Reader V1:
//
//        for (int i = 0; i <= map.length() - 1; i++){
//            if ((!Character.isDigit(map.charAt(i)) && map.charAt(i) != ' ') || (map.charAt(i) == ' ' && Character.isDigit(map.charAt(i - 1)))){
//                codeMap.put(map.substring(index, i), map.charAt(i));
//                index = i + 2;
//            }
//            if (i == map.length() - 1 && Character.isDigit(map.charAt(i))){
//                codeMap.put(map.substring(index), '\n');
//                index = 1;
//                for (int j = 1; j <= restMap.length() - 1; j++) {
//                    if ((!Character.isDigit(restMap.charAt(j)) && restMap.charAt(j) != ' ') || (restMap.charAt(j) == ' ' && Character.isDigit(restMap.charAt(j - 1)))) {
//                        codeMap.put(restMap.substring(index, j), restMap.charAt(j));
//                        index = j + 2;
//                    }
//                }
//            }
//        }

        StringBuilder bits = new StringBuilder(); //the string that holds the codes

        int a;

        while ((a = in.read()) != -1){ //goes through the file
            bits.append(String.format("%8s", Integer.toBinaryString((char)a).replace(' ', '0'))); //convert the character to binary code
        }

        String bit = bits.toString();

        bit = bit.replace(' ', '0'); //replace the space with 0

        bit += val; //add leftover code to the string

        String ans = ""; //the string that holds the decompressed text

        ByteReader input = new ByteReader(bit, codeMap); //create new byte reader

        ans = input.read(); //read the codes and convert them

        ByteWriter res = new ByteWriter("res"); //create new byte writer

        res.createFile(); //create new file

        res.writeToFile(ans); //write the result to the file

        res.close(); //close the file
    }
}
