import java.util.HashMap;

public class ByteReader {

    String n; //takes in the string of code

    HashMap<String, Character> m = new HashMap<String, Character>(); //takes in the code map

    public ByteReader (String n, HashMap<String, Character> m){ //constructor
        this.n = n;
        this.m = m;
    }

    public String read(){
        String ans = ""; //declare an empty string
        int index = 0; //set index to 0
        for (int i = 0; i <= n.length(); i++){ //goes through the string
            if (m.get(n.substring(index, i)) != null){ //if the result from the map is not null
                ans += m.get(n.substring(index, i)); //add the result to the empty string
                index = i; //set index to i
            }
        }
        return ans; //return answer
    }

}
