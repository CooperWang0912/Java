import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DictionarySorter {

    public String mode = "hi";
    public String fileName = "wordsShuffled.txt";

    public void selectionSort(List<String> words) {
        String min;
        String temp;
        int index = 0;
        for (int i = 0; i <= words.size() - 1; i++){
            min = words.get(i);
            for (int j = i; j <= words.size() - 1; j++) {
                if (words.get(j).compareTo(min) < 0) {
                    min = words.get(j);
                    index = j;
                }
            }
            temp = words.get(i);
            words.set(i, min);
            words.set(index, temp);
        }
    }

    public void insertionSort(List<String> words) {
        int j = 0;
        String temp;
        for (int i = 1; i <= words.size() - 1; i++){
            j = i;
            while (j > 0 && words.get(j).compareTo(words.get(j - 1)) < 0){
                temp = words.get(j - 1);
                words.set(j - 1, words.get(j));
                words.set(j, temp);
                j--;
            }
        }
    }

    public void mergeSort(List<String> words) {	// starter for your recursion
        mergeSort(words, 0, words.size()-1);
    }

    public void mergeSort(List<String> words, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(words, start, mid);
            mergeSort(words, mid + 1, end);
            merge(words, start, mid, end);
        }
    }

    public void merge(List<String> words, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        ArrayList<String> sorted = new ArrayList<String>();
        while (i <= mid && j <= end){
            if (words.get(i).compareTo(words.get(j)) < 0){
                sorted.add(words.get(i));
                i++;
            }
            else{
                sorted.add(words.get(j));
                j++;
            }
        }
        while (i <= mid){
            sorted.add(words.get(i));
            i++;
        }
        while (j <= end){
            sorted.add(words.get(j));
            j++;
        }
        int k = start;
        for (String s : sorted){
            words.set(k, s);
            k++;
        }
    }

    public static void main(String[] args) throws IOException {
        new DictionarySorter();
    }
    public DictionarySorter() throws IOException{
        // generates the word list from the dictionary file
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        List<String> words = new ArrayList<String>();
        for (String line = in.readLine(); line != null; line = in.readLine()) {
            words.add(line.trim());
        }
        in.close();
        long startTime = System.currentTimeMillis();
        if (mode.equals("selection"))
            selectionSort(words);
        else if (mode.equals("insertion"))
            insertionSort(words);
        else
            mergeSort(words);
        System.out.println("runtime: " + (System.currentTimeMillis() - startTime));

        BufferedWriter out = new BufferedWriter(new FileWriter("wordsSorted.txt"));
        for (String s : words)
            out.write(s + "\n");
        out.close();
    }
}
