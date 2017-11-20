/**
 * 
 */
package cracking.coding.interview.dpcoinchange;

/**
 * @author Tarl Hahn
 *
 */
public class DpCoinChange {
	
	/**
	 * Using dynamic programming, find the number of ways to sum an 
	 * any number of values that equal target. There are unlimited number
	 * of each value.
	 * @param target The target sum
	 * @param values The array of values
	 * @return The number of ways to sum values that equal target.
	 */
	public long waysToMakeChange(int target, int[] values) {
		
        long[] ways = new long[target + 1];
 
        // base case
        ways[0] = 1;
 
        // one by one update the table
        for (int i = 0; i < values.length; i++) {
            
        	// accumulate the solutions
        	for (int j = values[i]; j <= target; j++) {
                ways[j] += ways[j - values[i]];
            }
        }
        return ways[target];
	}
}
