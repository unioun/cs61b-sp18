public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.

    static CharacterComparator offByOne = new OffByOne();

    public static void main(String[] args) {
        In in = new In("./library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();
        int wordLength = 4;
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= wordLength && palindrome.isPalindrome(word, offByOne)) {
                System.out.println(word);
            }
        }
    }
}
