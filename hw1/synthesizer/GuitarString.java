package synthesizer;

import edu.princeton.cs.algs4.StdRandom;
import java.lang.Math;
import java.util.*;

public class GuitarString {
    /**
     * Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday.
     */
    private static final int SR = 44100; // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency. */
    public GuitarString(double frequency) {
        // TODO: Create a buffer with capacity =SR/frequency. You'll need to
        // cast the result of this divsion operation into an int. For better
        // accuracy, use the Math.round() function before casting.
        // Your buffer should be initially filled with zeros.
        int capacity = (int) Math.round(SR / frequency);
        buffer = new ArrayRingBuffer<Double>(capacity);
        for (int i = 0; i < capacity; i++) {
            buffer.enqueue(.0);
        }
    }

    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        // TODO: Dequeue everything in the buffer, and replace it with random numbers
        // between -0.5 and 0.5. You can get such a number by using:
        // double r = Math.random() - 0.5;
        // Make sure that your random numbers are different from each other.
        HashSet<Double> set = new HashSet<Double>();
        while (set.size() < buffer.capacity()) {
            set.add(StdRandom.uniform(-0.5, 0.5));
        }
        double[] data = new double[set.size()];
        int i = 0;
        for (double d : set) {
            data[i] = d;
            i++;
            buffer.dequeue();
        }
        Collections.shuffle(Arrays.asList(data));
        for (int j = 0; j < data.length; j++) {
            buffer.enqueue(data[j]);
        }
    }

    /*
     * Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        // TODO: Dequeue the front sample and enqueue a new sample that is
        // the average of the two multiplied by the DECAY factor.
        // Do not call StdAudio.play().
        buffer.enqueue(((buffer.dequeue() + buffer.peek()) / 2) * DECAY);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        // TODO: Return the correct thing.
        return buffer.peek();
    }
}