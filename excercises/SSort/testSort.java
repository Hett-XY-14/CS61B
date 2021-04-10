import org.junit.Test;
import static org.junit.Assert.*;
public class testSort {

    @Test
    public void testSort() {
        String[] input = {"hola", "que", "hace", "mi", "pana"};
        String[] output = {"hace", "hola", "mi", "pana", "que"};
        Sort.ssort(input);

        assertArrayEquals(output, input);
    }
    @Test
    public void testFndSmallest() {
        String[] input = {"hola", "que", "hace", "mi", "pana"};
        String expected = "hace";
        String actual = input[Sort.fndSmallest(input, 0)];

        String[] input2 = {"0", "1", "aaaaa", "zzz", "e", "p"};
        String expected2 = "0";
        String actual2 = input2[Sort.fndSmallest(input2, 0)];

        assertEquals(expected, actual);
        assertEquals(expected2, actual2);
    }
    @Test
    public void testSwap() {
        String[] input = {"albeit", "me", "goa", "jpg", "ahmleo"};
        int a = 0;
        int b = 4;
        String[] expected = {"ahmleo", "me", "goa", "jpg", "albeit"};
        Sort.swap(input, a, b);

        assertArrayEquals(expected, input);
    }
}
