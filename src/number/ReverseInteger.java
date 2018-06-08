/*
 * Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
 */
package number;

public class ReverseInteger {
	public int reverse(int x) {
        StringBuilder stringBuilder = new StringBuilder(Long.toString(Math.abs((long)x)));
        if(x < 0)
        	stringBuilder.append("-");
        String resultString = stringBuilder.reverse().toString();  
        Long resultLong = Long.valueOf(resultString);
        if(resultLong > Integer.MAX_VALUE || resultLong < Integer.MIN_VALUE){
            return 0;
        }
        return (int)(resultLong.longValue());
    }
}
