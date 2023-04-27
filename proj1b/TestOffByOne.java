import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    public static CharacterComparator offByOne;

    @Test
    public void testOffByOne() throws Exception {
        OffByOne check = new OffByOne();
        assertTrue(check.equalChars('a', 'b'));
        assertTrue(check.equalChars('r', 'q'));
        assertTrue(check.equalChars('&', '%'));

        assertFalse(check.equalChars('a', 'e'));
        assertFalse(check.equalChars('z', 'a'));
        assertFalse(check.equalChars('a', 'a'));
    }

}
