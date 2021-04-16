import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the AList class.
 *  @author Josh Hug
 */

public class AListTest {
    @Test
    public void testEmptySize() {
        AList L = new AList();
        assertEquals(0, L.size());
    }

    @Test
    public void testAddAndSize() {
        AList L = new AList();
        L.addLast(99);
        L.addLast(99);
        assertEquals(2, L.size());
    }

    
    @Test
    public void testAddAndGetLast() {
        AList L = new AList();
        L.addLast(99);
        assertEquals(99, L.getLast());        
        L.addLast(36);
        assertEquals(36, L.getLast());        
    }

    
    @Test
    public void testGet() {
        AList L = new AList();
        L.addLast(99);
        assertEquals(99, L.get(0));        
        L.addLast(36);
        assertEquals(99, L.get(0));        
        assertEquals(36, L.get(1));        
    }


    @Test
    public void testRemove() {
        AList L = new AList();
        L.addLast(99);
        assertEquals(99, L.get(0));        
        L.addLast(36);
        assertEquals(99, L.get(0));
        L.removeLast(); 
        assertEquals(99, L.getLast());
        L.addLast(100);
        assertEquals(100, L.getLast());
        assertEquals(2, L.size());
    }

    /** Tests insertion of a large number of items.*/
    @Test
    public void testMegaInsert() {
        AList L = new AList();
        int N = 1000000;
        for (int i = 0; i < N; i += 1) {
            L.addLast(i);
        }

        for (int i = 0; i < N; i += 1) {
            L.addLast(L.get(i));
        }

    }

    /** Test insertion in a given index */
    @Test
    public void testInsert() {
        int[] expected = {300,0,0,0,0,0,300,0,0,0,0,0,3000};
        AList L = new AList();
        for (int i = 0; i < 10; i += 1) {
            L.addLast(0);
        }
        L.insert(300, 5);
        L.insert(300, 1999);
        L.insert(300, 0);

        for (int i = 0; i < L.size(); i += 1) {
            System.out.print(L.items[i] + " ");
        }
        int[] output = new int[L.size()];
        System.arraycopy(L.items, 0, output, 0, L.size());

        assertArrayEquals(expected, output);
    }

    public static void main(String[] args) {
        /*jh61b.junit.TestRunner.runTests("all", AListTest.class);*/

    }
} 