import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
public class FileCompressor {

    HashMap<Character, String> algorithm = new HashMap<Character, String>();

    public void code(Branch n, String ans){
        if (n.getLeft() == null && n.getRight() == null){
            algorithm.put(n.getInfo(), ans);
        }
        else{
            if (n.getLeft() != null){
                code(n.getLeft(), ans + "0");
                System.out.println(1);
            }
            if (n.getRight() != null){
                code(n.getRight(), ans + "1");
                System.out.println(2);
            }
        }
    }

    public static void main(String[]args) throws IOException {

        FileCompressor runner = new FileCompressor();

        FileReader fr = new FileReader("test.txt");

        HashMap<Character, Integer> alphabet = new HashMap<Character, Integer>();

        PriorityQueue<Character> elements = new PriorityQueue<Character>();

        PriorityQueue<Branch> tree = new PriorityQueue<Branch>();

        int i;

        while ((i = fr.read()) != -1){
            if (alphabet.get((char)i) == null){
                alphabet.put((char)i , 1);
            }
            else{
                alphabet.put((char)i , alphabet.get((char)i) + 1);
            }
        }

        for (char j : alphabet.keySet()){
            elements.put(j, alphabet.get(j));
        }

        elements.createTree(tree);

        System.out.println(tree);

        tree.build(tree);


        System.out.println(tree);

        runner.code(tree.get(0), "");

        System.out.println(runner.algorithm);


    }

}
