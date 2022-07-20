package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.enqueue(5);

        System.out.println(arb.dequeue());
        System.out.println(arb.dequeue());
        System.out.println(arb.dequeue());
        System.out.println(arb.dequeue());
        System.out.println(arb.dequeue());

        System.out.println(arb.fillCount());

    }
}

