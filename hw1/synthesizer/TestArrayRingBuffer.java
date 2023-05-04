package synthesizer;

import static org.junit.Assert.assertEquals;
import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Tests the ArrayRingBuffer class.
 *
 * @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        int time = 100000;
        Deque<Integer> correct = new ArrayDeque<Integer>(time);
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<Integer>(time);
        for (int i = 0; i < time; i++) {
            arb.enqueue(i);
            correct.addLast(i);
        }
        assertEquals("isEmpty() ", true, arb.isFull());
        assertEquals("isEmpty() ", correct.isEmpty(), arb.isEmpty());
        assertEquals("Peek() ", correct.peek(), arb.peek());
        assertEquals("fillCount() ", correct.size(), arb.fillCount());
        for (Integer integer : correct) {
            assertEquals("deque()", correct.removeFirst(), arb.dequeue());
        }
        for (int i = 0; i < time; i++) {
            double r = StdRandom.uniform();
            if (r < 0.5) {
                assertEquals("Peek() ", correct.peek(), arb.peek());
                assertEquals("isEmpty() ", correct.isEmpty(), arb.isEmpty());
                assertEquals("fillCount() ", correct.size(), arb.fillCount());
                arb.enqueue(i);
                correct.addLast(i);
            } else {
                assertEquals("Peek() ", correct.peek(), arb.peek());
                assertEquals("isEmpty() ", correct.isEmpty(), arb.isEmpty());
                assertEquals("fillCount() ", correct.size(), arb.fillCount());
                if (correct.size() != 0) {
                    assertEquals("deque()", correct.removeFirst(), arb.dequeue());
                }
            }
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
}
