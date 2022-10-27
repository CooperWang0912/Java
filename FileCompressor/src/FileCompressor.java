import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
public class FileCompressor {

    HashMap<Character, String> algorithm = new HashMap<Character, String>(); //Hashmap that contains the characters and their codes

    public void code(Branch n, String ans){ //Recursive function to generate the code
        if (n.getLeft() == null && n.getRight() == null){ //if there is not left branch and no right branch
            algorithm.put(n.getInfo(), ans); //puts the information into the map
        }
        else{
            if (n.getLeft() != null){ //if there is a left branch
                code(n.getLeft(), ans + "0"); //continue and add 0 to the code
            }
            if (n.getRight() != null){ //if there is a right branch
                code(n.getRight(), ans + "1"); //continue and add 1 to the code
            }
        }
    }

    public static void main(String[]args) throws IOException {

        FileCompressor runner = new FileCompressor(); //runner

        FileReader fr = new FileReader("test.txt"); //first file reader

        FileReader fr2 = new FileReader("test.txt"); //second file reader

        HashMap<Character, Integer> alphabet = new HashMap<Character, Integer>(); //the map that holds the characters and their frequencies

        PriorityQueue<Character> elements = new PriorityQueue<Character>(); //the priority queue that arranges the characters according to their frequencies

        PriorityQueue<Branch> tree = new PriorityQueue<Branch>(); //the tree that holds the nodes

        int i;

        while ((i = fr.read()) != -1){ //goes through the file character by character
            if (alphabet.get((char)i) == null){ //if the result from the map is null
                alphabet.put((char)i , 1); //put the character and 1
            }
            else{
                alphabet.put((char)i , alphabet.get((char)i) + 1); //put the character and add 1 to its frequency
            }
        }

        for (char j : alphabet.keySet()){ //goes through the map
            elements.put(j, alphabet.get(j)); //add elements to the priority queue
        }

        elements.createTree(tree); //use the elements to create a tree

        tree.build(tree); //build the tree

        runner.code(tree.get(0), ""); //create the codes

        int j;

        StringBuilder s = new StringBuilder(); //string used to carry the codes

        while ((j = fr2.read()) != -1){ //goes through the file again
            s.append(runner.algorithm.get((char)j)); //add the corresponding code of the character to the string
        }

        String left = s.substring((s.length() / 8) * 8); //gets the remaining code that is not enough to form a bit

        ByteWriter ans = new ByteWriter("map"); //create new byte writer

        ans.createFile(); //create file

        for (char a : runner.algorithm.keySet()){ //goes through the mao
            ans.writeToFile(runner.algorithm.get(a)); //writes the code
            ans.writeToFile("\n"); //next line
            ans.writeToFile(a + ""); //writes the character
            ans.writeToFile("\n"); //next line
        }

        ans.writeToFile("stop"); //writes stop

        ans.writeToFile("\n"); //next line

        ans.writeToFile(left); //writes the leftover code

        ans.writeToFile("\n"); //next line

        ans.put(s.toString()); //write the compressed file

        ans.close(); //close the file
    }

}
