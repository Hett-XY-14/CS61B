import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Colections {
    /** Returns a lower case version of the string with
     *  All the characters except letters removed.
     */
    public static String cleanString(String s) {
        return s.toLowerCase().replaceAll("[^a-z]", "");
    }

    /**Gets a list of all words in the file. */
    public static List<String> getWords(String inputFilename) {
        List<String> words = new ArrayList<String>();
        In in = new In(inputFilename);
        while (!in.isEmpty()) {
            String nextWord = cleanString(in.readString());
            words.add(nextWord);
            System.out.println(nextWord);
        }
        return words;
    }
    /** Returns the count of the number of unique words in words. */
    public static int countUniqueWords(List<String> words) {
        Set<String> uniqueWords = new HashSet<String>();
        for (String word: words) {
            uniqueWords.add(word);
        }
        return uniqueWords.size();
    }

    /** Returns a map (a.k.a dictionary) that tracks the count of all special
     *  target words in words */
    public static Map<String, Integer> collectWordCount(List<String>  targets, List<String>  words) {
        Map<String, Integer> wordCount = new HashMap<String, Integer>();
            for (String target : targets) {
                wordCount.put(target, 0);
            }
            for (String word : words) {
                if (wordCount.containsKey(word)) {
                    int previousCount = wordCount.get(word);
                    wordCount.put(word, previousCount + 1);
                }
            }
        return wordCount;
    }

    public static void main(String[] args) {
        List<String> w = getWords("The library of Babel.txt");
        System.out.println(w);
        int numberOfWords = countUniqueWords(w);
        System.out.println(numberOfWords);
    }

}
