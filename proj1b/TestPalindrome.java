import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        boolean expected_1 = true;
        boolean output_1 = palindrome.isPalindrome("anitalavalatina");
        assertEquals(expected_1, output_1);

        boolean expected_2 = false;
        boolean output_2 = palindrome.isPalindrome("anitalavalatia");
        assertEquals(expected_2, output_2);

        boolean expected_3 = false;
        boolean output_3 = palindrome.isPalindrome("");
        assertEquals(expected_3, output_3);

        assertTrue(palindrome.isPalindrome("oo"));
        assertFalse(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome("ooO"));

        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertFalse(palindrome.isPalindrome("flaka", offByOne));
        assertTrue(palindrome.isPalindrome("ana"));
        assertFalse(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("f", offByOne));;

    }

    @Test
    public void testOffByOne() {
        assertFalse(offByOne.equalChars('a','c'));
        assertTrue(offByOne.equalChars('a','b'));
        assertTrue(offByOne.equalChars('d','c'));
        assertTrue(offByOne.equalChars('%','&'));

    }
}   //Uncomment this class once you've created your Palindrome class.