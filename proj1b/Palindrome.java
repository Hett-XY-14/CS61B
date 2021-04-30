public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> charDeque = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i += 1) {
            charDeque.addLast(word.charAt(i));
        }
        return charDeque;
    }

    public boolean isPalindrome(String word) {
        if (word.length() == 0) { return false; }
        Deque<Character> charDeque = (ArrayDeque<Character>) wordToDeque(word);
        return isPalindrome(charDeque);
    }

    private boolean isPalindrome(Deque<Character> charDeque) {
        if (charDeque.size() <= 1) { return true; }
        if (charDeque.removeFirst() == charDeque.removeLast()) {
            return isPalindrome(charDeque);
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        if (word.length() == 0) { return false; }
        if (cc == null) { return isPalindrome(word); }
        Deque<Character> charDeque = (ArrayDeque<Character>) wordToDeque(word);
        return isPalindrome(charDeque, cc);
    }

    private boolean isPalindrome(Deque<Character> charDeque, CharacterComparator cc) {
        OffByOne offByOneLetter = new OffByOne();
        if (charDeque.size() <= 1) { return true; }
        if (offByOneLetter.equalChars(charDeque.removeFirst(), charDeque.removeLast())) {
            return isPalindrome(charDeque, cc);
        } else {
            return false;
        }
    }

}
