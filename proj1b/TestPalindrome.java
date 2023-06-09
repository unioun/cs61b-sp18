import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque<Character> d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        Map<String, Boolean> words = new HashMap<>() {
            {
                put("abc", false);
                put("abccba", true);
                put("AbccBa", false);
                put("", true);
                put("a", true);
                put("acaca", true);
            }
        };
        for (Map.Entry<String, Boolean> entry : words.entrySet()) {
            assertEquals(palindrome.isPalindrome(entry.getKey()), entry.getValue());
        }
    }

    @Test
    public void testPalindromeOffByOne() {
        CharacterComparator cc = new OffByOne();
        Map<String, Boolean> words = new HashMap<>() {
            {
                put("abc", false);
                put("abccba", false);
                put("AbccBa", false);
                put("", true);
                put("a", true);
                put("acaca", false);
                put("acadb", true);
                put("fcedg", true);
                put("hjcjklibkg", true);
                put("defgsdsctfgdc", true);
            }
        };
        for (Map.Entry<String, Boolean> entry : words.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println(palindrome.isPalindrome(entry.getKey(), cc));
            System.out.println("-----------------------");
            assertEquals(palindrome.isPalindrome(entry.getKey(), cc), entry.getValue());
        }
    }
}
