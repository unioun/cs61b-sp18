public class ArrayDeque<T> implements Deque<T> {
    private T[] array = (T[]) new Object[10];

    private int head = array.length / 2;
    private int tail = head - 1;
    private int smallest = 15;

    private boolean equalArray(T[] neo, int neoHead) {
        int j = neoHead;
        for (int i = head; i <= tail; i++) {
            if (neo[j] != array[i]) {
                System.out.println("expect:" + array[i] + "but was:" + neo[i]);
                return false;
            }
            j++;
        }
        return true;
    }

    private void enlarge(int factor) {
        int size = size();
        // when size reduced to 0,and then the array's length should remian 10.
        int neoLength = (size < 5) ? 5 : size;
        neoLength = neoLength * factor;
        T[] neoArray = (T[]) new Object[neoLength];
        int neoHead = neoArray.length - size;
        neoHead = neoHead / 2;
        System.arraycopy(array, head, neoArray, neoHead, size);
        // assertEquals(true, equalArray(neoArray, neoHead));
        head = neoHead;
        tail = head + size - 1;
        array = neoArray;
    }

    private void shrink(int factor) {
        if (size() == 0) {
            return;
        }
        int size = size();
        T[] neoArray = (T[]) new Object[size * factor];
        int neoHead = neoArray.length - size;
        neoHead = neoHead / 2;
        System.arraycopy(array, head, neoArray, neoHead, size);
        // assertEquals(true, equalArray(neoArray, neoHead));
        head = neoHead;
        tail = head + size - 1;
        array = neoArray;
    }

    @Override
    public void addFirst(T item) {
        if (head == 0) {
            enlarge(2);
        }
        array[--head] = item;
    }

    @Override
    public void addLast(T item) {
        if (tail == array.length - 1) {
            enlarge(2);
        }
        array[++tail] = item;
    }

    @Override
    public T removeFirst() {
        if (size() == 0) {
            return null;
        } else {
            T removeItem = array[head];
            array[head++] = null;
            if (size() * 3 < array.length && array.length > smallest
                    && size() > 0) {
                shrink(2);
            }
            return removeItem;
        }
    }

    @Override
    public T removeLast() {
        if (size() == 0) {
            return null;
        } else {
            T removeItem = array[tail];
            array[tail--] = null;
            if (size() * 3 < array.length && array.length > smallest
                    && size() > 0) {
                shrink(2);
            }
            return removeItem;
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public T get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        } else if (index > size() - 1) {
            // throw new IndexOutOfBoundsException();
            System.out.println("Index out of size,no such item!");
            return null;
        } else {
            return array[index + head];
        }
    }

    @Override
    public int size() {
        return tail - head + 1;
    }

    @Override
    public void printDeque() {
        if (size() == 0) {
            System.out.println("{}");
            return;
        }
        StringBuilder items = new StringBuilder("{");
        int size = size();
        int j = head;
        for (int i = 0; i < size; i++) {
            items.append(array[j++].toString());
            items.append(",");
        }
        int length = items.length() - 1;
        items.deleteCharAt(length);
        items.append("}");
        System.out.println(items.toString());
    }
}
