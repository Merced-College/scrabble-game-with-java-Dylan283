import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScrabbleGame {

    //a data structure to hold the dictionary of words
    private List<Word> dictionary = new ArrayList<Word>();

    public static void main(String[] args) {

        Scanner in = null;
        try {
            in = new Scanner(new File("wordsWithDefs.txt"));
            while(in.hasNextLine()) {
                String word = in.next();
                String def = in.nextLine().trim();
                dictionary.add(new Word(word, def));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Dictionary file not found.");
        } 

        //print out the dictionary
        for(Word w : dictionary) { 
            System.out.println(w);
        }

    }
}