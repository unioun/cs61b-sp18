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
        // length is half length of the word,it represent times this function check
        // palindrome.
        int length = word.length() / 2;
        // value j is a cursor form other hand of the word and i is a cursor from one
        // hand.
        int j = word.length() - 1;
        for (int i = 0; i < length; i++) {
            if (word.charAt(i) != word.charAt(j - i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null) {
            throw new IllegalArgumentException();
        }
        // length is half length of the word,it represent times this function check
        // palindrome.
        int length = word.length() / 2;
        // value j is a cursor form other hand of the word and i is a cursor from one
        // hand.
        int j = word.length() - 1;
        for (int i = 0; i < length; i++) {
            if (!cc.equalChars(word.charAt(i), word.charAt(j - i))) {
                return false;
            }
        }
        return true;
    }
}
