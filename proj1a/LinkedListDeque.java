public class LinkedListDeque<T> {
    private int size;
    // head and tail is two sentinal alyways there to hold whole deque;
    private Node head = new Node();
    private Node tail = new Node();

    private class Node {
        T item;
        Node previous;
        Node next;

        Node(T item) {
            this.item = item;
        }

        public Node() {
        }
    }

    public LinkedListDeque() {
        head.next = tail;
        tail.previous = head;
    }

    // scenario1: list is empty;
    // scenario2: list has one item;
    // scenario3: list has many items;
    public void addFirst(T item) {
        Node n = new Node(item);
        // set new node connect to anteFirst's previous;
        Node anteFirst = head.next;
        anteFirst.previous = n;
        n.next = anteFirst;
        // set new node connect to head node;
        head.next = n;
        n.previous = head;
        size++;
    }

    public void addLast(T item) {
        Node n = new Node(item);
        // set new node connect to anteLast's next positon;
        Node anteLast = tail.previous;
        anteLast.next = n;
        n.previous = anteLast;
        // set new node connect ot tail's previous positon;
        n.next = tail;
        tail.previous = n;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // scenario1 empty list;
    // scenario2 has items;
    // removed item should be collected by garbage collection mechanism;
    public T removeFirst() {
        if (size == 0) {
            System.out.println("This deque is empty!");
            return null;
        }
        T returnItem = head.next.item;
        // set node connections
        Node first = head.next.next;
        head.next = first;
        first.previous = head;
        size--;
        return returnItem;
    }

    // scenario1 empty list;
    // scenario2 has items;
    // removed item should be collected by garbage collection mechanism;
    public T removeLast() {
        if (size == 0) {
            System.out.println("This deque is empty!");
            return null;
        }
        T returnItem = tail.previous.item;
        Node last = tail.previous.previous;
        last.next = tail;
        tail.previous = last;
        size--;
        return returnItem;
    }

    // get must use iteration, not recursion
    public T get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        } else if (index >= size) {
            System.out.println("Deque's size is smaller than given index,no this item!!");
            return null;
        } else {
            Node n = head.next;
            while (index > 0) {
                n = n.next;
                index--;
            }
            return n.item;
        }

    }

    // Same as get,but uses recursion.
    public T getRecursive(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        } else if (index >= size) {
            System.out.println("Deque's size is smaller than given index,no this item!!");
            return null;
        } else {
            return getItem(head.next, index);
        }

    }

    private T getItem(Node n, int index) {
        if (index == 0) {
            return n.item;
        } else {
            index = index - 1;
            return getItem(n.next, index);
        }
    }

    public void printDeque() {
        if (size == 0) {
            System.out.println("{}");
            return;
        }
        StringBuilder deque = new StringBuilder("{");
        Node n = head;
        while (n.next != tail) {
            n = n.next;
            deque.append(n.item);
            deque.append(",");
        }
        int length = deque.length() - 1;
        deque.deleteCharAt(length);
        deque.append("}");
        System.out.println(deque.toString());
    }
}
