import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ByteWriter {

    static String n; //takes in the string of codes

    static FileWriter Writer; //declare a new writer


    public ByteWriter(String n) throws IOException { //constructor
        this.n = n;
        Writer = new FileWriter(n);
    }

    public void createFile(){ //create new file
        File compressed = new File(n);
    }

    public void put(String a) throws IOException { //takes a string
        for (int i = 0; i < a.length() / 8; i++) { //divide the string into substring of length 8
            int ans = Integer.parseInt(a.substring(8*i,(i+1)*8),2); //convert the substring to ascii
            writeToFile((char)ans + ""); //convert the ascii into character and write it to the file
        }
    }

    public void writeToFile(String m) throws IOException {
        Writer.write(m); //write to the file
    }

    public void close() throws IOException {
        Writer.close(); //close the file
    }

}
