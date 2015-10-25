import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by atomic on 10/24/15.
 */
public class myMathTest extends TestCase {

    @Test
    public void testSum() throws Exception {
        assertEquals(myMath.sum(1, 1), 2, 0.1);
    }

    @Test
    public void testDiff() throws Exception {
        assertEquals(myMath.diff(2,0), 2);
    }
}