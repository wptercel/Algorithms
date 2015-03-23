/*
 * Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
 */
package number;

public class FactorialTrailingZeros {
	public int trailingZeroes(int n) {
        int reference = n;
        int result = 0;
        while((reference = reference / 5) != 0){
            result += reference;
        }
        return result;
    }
}
