import org.junit.Test;
import java.lang.Math;
import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Random;

public class dequeTest {
    private int capacity = 23000;
    static String[] testList1 = { "", "acde", "abc", "icte", "unioun" };
    static int[] testList2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    static char[] testList3 = { 's', 'd', 'e', 'x' };

    @Test
    public void testRandomOperation() {
        Random randomTest = new Random();
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        LinkedListDeque<Interge> lld = new LinkedListDeque<>();
        int k;
        for (int j = 0; j < capacity; j++) {
            int i = randomTest.nextInt(5);
            switch (i) {
                case 0:
                    k = randomTest.nextInt();
                    ad.addFirst(k);
                    lld.addFirst(k);
                case 1:
                    k = randomTest.nextInt();
                    ad.addLast(k);
                    lld.addLast(k);
                case 2:
                    assertEquals(ad.removeFirst(), lld.removeLast());
                    assertEquals(ad.isEmpty(), lld.isEmpty());
                case 3:
                    assertEquals(ad.removeFirst(), lld.removeLast());
                    assertEquals(ad.isEmpty(), lld.isEmpty());

                case 4:
                    int size = ad.size();
                    assertEquals(size, lld.size());
                    k = randomTest.nextInt(size);
                    assertEquals(ad.get(k), lld.get(k));
                    assertEquals(ad.isEmpty(), lld.isEmpty());
            }

        }
    }

    public static void main(String[] args) {
    }
}
