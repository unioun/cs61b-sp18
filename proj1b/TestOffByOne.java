import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.

    @Test
    public void testOffByOne() throws Exception {
        OffByOne offset = new OffByOne();
        assertTrue(offset.equalChars('a', 'b'));
        assertTrue(offset.equalChars('r', 'q'));
        assertTrue(offset.equalChars('&', '%'));

        assertFalse(offset.equalChars('a', 'e'));
        assertFalse(offset.equalChars('z', 'a'));
        assertFalse(offset.equalChars('a', 'a'));
    }

}
