public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        int charNum1 = x;
        int charnum2 = y;
        int offset = Math.abs(charNum1 - charnum2);
        return offset == 1;
    }
}
