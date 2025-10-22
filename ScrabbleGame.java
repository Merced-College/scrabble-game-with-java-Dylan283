/*
 * Improvement: Added a scoring system where the user can type in a word,
 * and the program will check if it exists in the dictionary. If it does,
 * the user earns points based on the length of the word:
 *   - 1–2 letters = 1 point
 *   - 3 letters   = 3 points
 *   - 4 letters   = 5 points
 *   - 5 letters   = 8 points
 *   - 6+ letters  = 12 points
 *
 * This makes the game more interactive and rewarding, encouraging the user
 * to form longer words for higher scores.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScrabbleGame {

    //a data structure to hold the dictionary of words
    private static List<word> dictionary = new ArrayList<word>();

    public static void main(String[] args) {

        Scanner in = null;
        try {
            in = new Scanner(new File("wordsWithDefs.txt"));
            while(in.hasNextLine()) {
                String word = in.next();
                String def = in.nextLine().trim();
                dictionary.add(new word(word, def));
            }

            //close the scanner after we use it to avoid resource leaks
            in.close();
        } catch (FileNotFoundException e) {
            System.err.println("Dictionary file not found.");
        }

        //print out the dictionary
        for(word w : dictionary) { 
            System.out.println(w);
        }

        // ------------------- NEW FEATURE START -------------------
        // Ask the user to enter a word and score it
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word to check and score: ");
        String userWord = input.nextLine().toLowerCase();

        // Check if the word exists in the dictionary
        int index = binarySearch(dictionary, userWord);
        if(index != -1) {
            // Word found, calculate score
            int score = calculateScore(userWord);
            System.out.println("Great! '" + userWord + "' is in the dictionary.");
            System.out.println("You earned " + score + " points!");
        } else {
            // Word not found
            System.out.println("Sorry, '" + userWord + "' is not in the dictionary. No points awarded.");
        }
        // ------------------- NEW FEATURE END -------------------

    }//end main

    //binary search for a word in the dictionary
    public static int binarySearch(List<word> list, String target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = list.get(mid).getWord().compareTo(target);

            if (cmp == 0) {
                return mid; // target found
            } else if (cmp < 0) {
                left = mid + 1; // search right half
            } else {
                right = mid - 1; // search left half
            }
        }
        return -1; // target not found
    }

    // ------------------- HELPER METHOD FOR NEW FEATURE -------------------
    // Calculate score based on word length
    public static int calculateScore(String word) {
        int len = word.length();
        if(len <= 2) {
            return 1; // very short words
        } else if(len == 3) {
            return 3;
        } else if(len == 4) {
            return 5;
        } else if(len == 5) {
            return 8;
        } else {
            return 12; // long words are rewarded more
        }
    }
}
