public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> charDeque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            charDeque.addLast(word.charAt(i));
        }
        return charDeque;
    }

    public boolean isPalindrome(String word) {
        if (word == null) {
            throw new IllegalArgumentException();
        }
        int length = word.length() / 2;
        int j = word.length() - 1;
        for (int i = 0; i < length; i++) {
            if (word.charAt(i) != word.charAt(j - i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null || cc == null) {
            throw new IllegalArgumentException();
        }
        int length = word.length() / 2;
        int j = word.length() - 1;
        for (int i = 0; i < length; i++) {
            if (!cc.equalChars(word.charAt(i), word.charAt(j - i))) {
                return false;
            }
        }
        return true;
    }

    private static void testWords(String[] args) {
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();
        OffByOne offByOne = new OffByOne();
        int wordLength = 4;
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= wordLength && palindrome.isPalindrome(word, offByOne)) {
                System.out.println(word);
            }
        }
    }
}
