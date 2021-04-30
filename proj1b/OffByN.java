public class OffByN implements CharacterComparator {
    int gap;
    public OffByN(int n) {
        gap = n;
    }
    @Override
    public boolean equalChars(char x, char y) {
        int charNum1 = x;
        int charNum2 = y;
        int offset = Math.abs(charNum1 - charNum2);
        return offset == gap;
    }
}
