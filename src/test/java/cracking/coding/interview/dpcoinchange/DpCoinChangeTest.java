/**
 * 
 */
package cracking.coding.interview.dpcoinchange;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cracking.coding.interview.dpcoinchange.DpCoinChange;

/**
 * @author Tarl Hahn
 *
 */
public class DpCoinChangeTest {

	public DpCoinChange solution;
	
	public final TestCase[] cases = {
		new TestCase(4, 4, 1, 2, 3),
		new TestCase(5, 10, 2, 5, 3, 6),
		new TestCase(3542323427L, 250, 8, 47, 13, 24, 25, 31, 32, 35, 3, 19, 40, 48, 1, 4, 17, 38, 22, 30, 33, 15, 44, 46, 36, 9, 20, 49)
	};


	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		solution = new DpCoinChange();
	}

	/**
	 * Test method for {@link cracking.coding.interview.dpcoinchange.DpCoinChange#waysToMakeChange(int, int[])}.
	 */
	@Test
	public void testWaysToMakeChange() {
		for(int i = 0; i < cases.length; ++i) {
			assertThat("Cases[" + i + "]: " + cases[i].toString(), solution.waysToMakeChange(cases[i].n, cases[i].values), is(cases[i].expected));
		}
	}
	
	public class TestCase {
		
		public final long expected;
		
		public final int n;
		
		public final int[] values;
		
		/**
		 * A test case container for this test suite
		 * @param expect The expected number of ways
		 * @param n The target sum
		 * @param values The values to sum.
		 */
		public TestCase(long expected, int n, int... values) {
			this.expected = expected;
			this.n = n;
			this.values = values;
		}
		
		@Override
		public String toString() {
			// build the expected, target, and first value in the array (fence post problem).
			StringBuilder sb = new StringBuilder("Expected: '" + expected + "', Target: '" + n + "', Values: {" + values[0]);
			
			// build the rest of the test case array
			for (int i = 1; i < values.length; ++i) { sb.append(", " + values[i]); }
			sb.append(" }");
			
			return sb.toString();
		}
	}
}
