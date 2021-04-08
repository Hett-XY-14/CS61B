public class testSort {
    public static void testSort() {
        String[] input = {"hola", "que", "hace", "mi", "pana"};
        String[] output = {"hace", "hola", "mi", "pana", "que"};
        Sort.ssort(input);

        org.junit.Assert.assertArrayEquals(output, input);
    }
    public static void testFndSmallest() {
        String[] input = {"hola", "que", "hace", "mi", "pana"};
        String expected = "hace";
        String actual = input[Sort.fndSmallest(input, 0)];

        String[] input2 = {"0", "1", "aaaaa", "zzz", "e", "p"};
        String expected2 = "0";
        String actual2 = input2[Sort.fndSmallest(input2, 0)];

        org.junit.Assert.assertEquals(expected, actual);
        org.junit.Assert.assertEquals(expected2, actual2);
    }
    public static void testSwap() {
        String[] input = {"albeit", "me", "goa", "jpg", "ahmleo"};
        int a = 0;
        int b = 4;
        String[] expected = {"ahmleo", "me", "goa", "jpg", "albeit"};
        Sort.swap(input, a, b);

        org.junit.Assert.assertArrayEquals(expected, input);
    }
    public static void main(String[] args) {
        testSort();
    }
}
