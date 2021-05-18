import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by hug.
 */
public class TestRedBlackFloorSet {
    @Test
    public void randomizedTest() {
        RedBlackFloorSet randomRBFS = new RedBlackFloorSet();
        AListFloorSet randomALFS = new AListFloorSet();
        for (int i = 0; i < 1000000; i += 1) {
           double randomNumber = StdRandom.uniform(-5000, 5000);
           randomRBFS.add(randomNumber);
           randomALFS.add(randomNumber);
       }
        for (int i = 0; i < 100000; i += 1) {
            double randomFloor = StdRandom.uniform(-5000, 5000);
            double expected = randomALFS.floor(randomFloor);
            double output = randomRBFS.floor(randomFloor);
            //System.out.println("Expected: " + expected + ", Output: " + output);
            if (expected != output) {
                System.out.println("Expected: " + expected + ", Output: " + output);
            }
        }
    }
}
