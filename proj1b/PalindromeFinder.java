/**
 * This class outputs all palindromes in the words file in the current
 * directory.
 */
public class PalindromeFinder {

    public static void main(String[] args) {
        // System.out.println(System.getProperty("user.dir"));
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();

        while (!in.isEmpty()) {
            OffByN offset = new OffByN(3);
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, offset)) {
                System.out.print(word + "\n");
            }
        }
    }
}