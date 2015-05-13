import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;


public class FourCubeSolutionTest {

    @Test
    public void test() {
	for (int i = 0; i < 1001; i++) {
	    if (i % 9 == 4 || i % 9 == 5) {
		assertEquals(true, true);
	    }
	    else {
		FourCubeSolution test = new FourCubeSolution(i);
		assertEquals(i, test.sum().intValue());
	    }
	}
    }

}
