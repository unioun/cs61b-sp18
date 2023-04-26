public class OffByN implements CharacterComparator {

    private int offset;

    public OffByN(int offset) {
        this.offset = offset;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int z = x - y;
        return z == offset || z == -offset;
    }

    // public static void main(String[] args) {
    // // this main function is just for test.
    // OffByN offBy5 = new OffByN(5);
    // System.out.println(offBy5.equalChars('a', 'f')); // true
    // System.out.println(offBy5.equalChars('f', 'a')); // true
    // System.out.println(offBy5.equalChars('f', 'h')); // false
    // }
}
