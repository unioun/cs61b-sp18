import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    // @Test
    // public void regularTestFF1000() {
    // ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<>();
    // StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
    // // add first ,remove last
    // int time = 10000;
    // String message = "";
    // for (int i = 0; i < time; i++) {
    // sol.addFirst(i);
    // stu.addFirst(i);
    // int randomIndex = StdRandom.uniform(sol.size());
    // message = " addFirst() " + i + " times\n";
    // assertEquals(message + "get() " + randomIndex
    // + "\n", sol.get(randomIndex), stu.get(randomIndex));
    // }
    // for (int i = 0; i < time; i++) {
    // message = " addFirst() " + time + " times\n";
    // assertEquals(message + " size()\n", sol.size(), stu.size());
    // message = message + " removeFirst() " + i + " times\n";
    // assertEquals(message, sol.removeFirst(), stu.removeFirst());
    // if (sol.size() == 0) {
    // return;
    // }
    // int randomIndex = StdRandom.uniform(sol.size());
    // assertEquals(message + " get() " + randomIndex + "\n", sol.get(randomIndex),
    // stu.get(randomIndex));
    // }
    // }

    // @Test
    // public void regularTestFL1000() {
    // ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<>();
    // StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
    // // add first ,remove last
    // int time = 10000;
    // String message = "";
    // for (int i = 0; i < time; i++) {
    // sol.addFirst(i);
    // stu.addFirst(i);
    // int randomIndex = StdRandom.uniform(sol.size());
    // message = " addFirst() " + i + " times\n";
    // assertEquals(message + "get() " + randomIndex
    // + "\n", sol.get(randomIndex), stu.get(randomIndex));
    // }
    // for (int i = 0; i < time; i++) {
    // message = " addFirst() " + time + " times\n";
    // assertEquals(message + " size()\n", sol.size(), stu.size());
    // message = message + " removeLast() " + i + " times\n";
    // assertEquals(message, sol.removeLast(), stu.removeLast());
    // if (sol.size() == 0) {
    // return;
    // }
    // int randomIndex = StdRandom.uniform(sol.size());
    // assertEquals(message + " get() " + randomIndex + "\n", sol.get(randomIndex),
    // stu.get(randomIndex));
    // }
    // }

    // @Test
    // public void regularTestLL1000() {
    // ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<>();
    // StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
    // // add first ,remove last
    // int time = 10000;
    // String message = "";
    // for (int i = 0; i < time; i++) {
    // sol.addLast(i);
    // stu.addLast(i);
    // int randomIndex = StdRandom.uniform(sol.size());
    // message = " addLast() " + i + " times\n";
    // assertEquals(message + "get() " + randomIndex
    // + "\n", sol.get(randomIndex), stu.get(randomIndex));
    // }
    // for (int i = 0; i < time; i++) {
    // message = " addLast() " + time + " times\n";
    // assertEquals(message + " size()\n", sol.size(), stu.size());
    // message = message + " removeLast() " + i + " times\n";
    // assertEquals(message, sol.removeLast(), stu.removeLast());
    // if (sol.size() == 0) {
    // return;
    // }
    // int randomIndex = StdRandom.uniform(sol.size());
    // assertEquals(message + " get() " + randomIndex + "\n", sol.get(randomIndex),
    // stu.get(randomIndex));
    // }
    // }

    // @Test
    // public void regularTestLF1000() {
    // ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<>();
    // StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
    // // add first ,remove last
    // int time = 10000;
    // String message = "";
    // for (int i = 0; i < time; i++) {
    // sol.addLast(i);
    // stu.addLast(i);
    // int randomIndex = StdRandom.uniform(sol.size());
    // message = " addLast() " + i + " times\n";
    // assertEquals(message + "get() " + randomIndex
    // + "\n", sol.get(randomIndex), stu.get(randomIndex));
    // }
    // for (int i = 0; i < time; i++) {
    // message = " addFirst() " + time + " times\n";
    // assertEquals(message + " size()\n", sol.size(), stu.size());
    // message = message + " removeFirst() " + i + " times\n";
    // assertEquals(message, sol.removeFirst(), stu.removeFirst());
    // if (sol.size() == 0) {
    // return;
    // }
    // int randomIndex = StdRandom.uniform(sol.size());
    // assertEquals(message + " get() " + randomIndex + "\n", sol.get(randomIndex),
    // stu.get(randomIndex));
    // }
    // }

    @Test
    public void randomTest() {
        ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        int time = 100000;
        String message = "";
        for (int i = 0; i < time; i++) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.25) {
                sol.addFirst(i);
                stu.addFirst(i);
                message = message + "addFirst(" + i + ")\n";
            } else if (numberBetweenZeroAndOne >= 0.25 && numberBetweenZeroAndOne < 0.5) {
                sol.addLast(i);
                stu.addLast(i);
                message = message + "addLast(" + i + ")\n";
            } else if (numberBetweenZeroAndOne >= 0.5 && numberBetweenZeroAndOne < 0.75) {
                if (sol.size() > 0 && stu.size() > 0) {
                    message = message + "removeFirst()\n";
                    assertEquals(message, sol.removeFirst(), stu.removeFirst());
                }
            } else {
                if (sol.size() > 0 && stu.size() > 0) {
                    message = message + "removeLast()\n";
                    assertEquals(message, sol.removeLast(), stu.removeFirst());
                }
            }
        }
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(TestArrayDequeGold.class);
    }
}
