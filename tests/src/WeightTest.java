import org.junit.Before;
import org.junit.Test;

/**
 * Created by Stephen on 11/17/2016.
 */
public class WeightTest {

    private Weight w;

    @Before
    public void setup() {
        w = new Weight();
    }

    @Test
    public void testRun() {
        int[] weights = {7, 4, 9, 5, 2};
        w.maximizePackage(10, weights);
    }
}
