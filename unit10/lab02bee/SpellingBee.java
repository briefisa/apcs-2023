import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SpellingBee {

    private char[] letters;
    private char mustUse;

    public SpellingBee(char[] letters, char mustUse) {
        this.letters = letters;
        this.mustUse = mustUse;
    }

    public boolean checkWord(String word) {
        boolean mustMatch = false;
        boolean matches = true;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            boolean match = false;
            for (char a : letters) {
                if (letter == a) {
                    match = true;
                }
            }
            if (!match) {
                matches = false;
            }
            if (letter == mustUse) {
                mustMatch = true;
            }
        }
        return (mustMatch && matches); 
    }

    /**
     * Loads the contents of file "filename" as a String.
     * 
     * @param filename the file to load
     * @return the contents of file "filename"
     */
    public static String loadFile(String filename) {
        String contents = "";
        Path path = Paths.get(filename);
        try {
            path = Path.of(ClassLoader.getSystemResource(filename).toURI());
            contents = Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return contents;
    }

    public static String[] mergeSort(String[] words) {
        if (words.length == 1) {
            return words;
        } else {
            int len = words.length;
            String[] first = new String[len/2];
            String[] second = new String[(len + 1)/2];
            int i = 0;
            while (i < first.length) {
                first[i] = words[i];
                i++;
            }
            while (i < (first.length + second.length)) {
                second[i - first.length] = words[i];
                i++;
            }
            first = mergeSort(first);
            second = mergeSort(second);
            String[] output = new String[len];
            int a = 0, b = 0;

            while ((a < first.length) && (b < second.length)) {
                if (first[a].compareTo(second[b]) <= 0) {
                    output[a + b] = first[a];
                    a++;
                } else if(first[a].compareTo(second[b]) > 0) {
                    output[a + b] = second[b];
                    b++;
                }
            }
            while (a < first.length) {
                output[a + b] = first[a];
                a++;
            }
            while (b < second.length) {
                output[a + b] = second[b];
                b++;
            }
            return output;
        }
    }

    public static void main(String[] args) {
        String[] words = mergeSort(loadFile("words_dropped.txt").split("\n"));
        System.out.println("Loaded " + words.length + " words");
        for (String word : words) {
            System.out.println(word);
        }

        SpellingBee bee = new SpellingBee("ranglty".toCharArray(), 'y');

        int matches = 0;
        for (int i = 0; i < words.length; i++) {
            if (bee.checkWord(words[i])) {
                System.out.println("Word #" + (i + 1) + " matches!");
                matches++;
            }
        }
        System.out.println("Total matches = " + matches);
    }
}
