/**
 * 
 */
package cracking.coding.interview;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Tarl Hahn
 *
 */
public class DpCoinChangeTest {

	public DpCoinChange solution;
	
	public final TestCase[] cases = {
		new TestCase(4, 4, 1, 2, 3),
		new TestCase(5, 10, 2, 5, 3, 6)
	};


	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		solution = new DpCoinChange();
	}

	/**
	 * Test method for {@link cracking.coding.interview.DpCoinChange#waysToMakeChange(int, int[])}.
	 */
	@Test
	public void testWaysToMakeChange() {
		for(int i = 0; i < cases.length; ++i) {
			assertThat("Cases[" + i + "]: " + cases[i].toString(), cases[i].expected, is(solution.waysToMakeChange(cases[i].n, cases[i].values)));
		}
	}
	
	public class TestCase {
		
		public final int expected;
		
		public final int n;
		
		public final int[] values;
		
		/**
		 * A test case container for this test suite
		 * @param expect The expected number of ways
		 * @param n The target sum
		 * @param values The values to sum.
		 */
		public TestCase(int expect, int n, int... values) {
			this.expected = expect;
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
