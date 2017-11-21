/**
 * 
 */
package cracking.coding.interview.triescontacts;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Tarl Hahn
 *
 */
public class TriesContactsTest {

	public enum Function_Type { ADD, FIND }
	
	private TriesContacts tc;
	private TestData[] sequence1 = {
		new TestData(Function_Type.ADD, "hack"),
		new TestData(Function_Type.ADD, "hackerrank"),
		new TestData(Function_Type.FIND, "hac", 2),
		new TestData(Function_Type.FIND, "hak", 0)
	};
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setup() {
		tc = new TriesContacts();
	}
	
	/**
	 * Test method for {@link cracking.coding.interview.triescontacts.TriesContacts#add(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testSequence1() throws Exception {
		for (TestData td : sequence1) {
			assertThat(td.toString(), td.expected, is(execute(td)));
		}
	}
	
	private int execute(TestData td) {
		int result = 0;
		switch(td.type) {
		case ADD:
			tc.add(td.input);
			break;
		case FIND:
			result = tc.countStringsFromPartial(td.input);
			break;
		}
		return result;
	}

	public class TestData {
		public Function_Type type;
		
		public String input;
		
		public int expected;
		
		public TestData(Function_Type type, String input) {
			this(type, input, 0);
		}
		
		public TestData(Function_Type type, String input, int expected) {
			this.type = type;
			this.input = input;
			this.expected = expected;
		}
		
		@Override
		public String toString() {
			String s = type.toString() + " " + input;
			if (type.equals(Function_Type.FIND)) {
				s += " with " + expected + " partials";
			}
			return s;
		}
	}
}
