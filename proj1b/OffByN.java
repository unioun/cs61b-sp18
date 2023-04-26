
public class OffByN implements CharacterComparator {

    private int offset = 0;

    public OffByN(int offset) {
        this.offset = offset;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int z = x - y;
        return z == offset || z == -offset;
    }
}
