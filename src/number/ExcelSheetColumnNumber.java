/*
 * Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 */
package number;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
	    int result = 0;
	    int aPrev = (int)('A')-1;
	    int len = s.length();
	    char[] letters = s.toCharArray();
	    for(int i=0; i<len; i++){
	        result += ((int)letters[i]-aPrev) * ((int)Math.pow(26d, (double)(len-i-1)));
	    }
	    return result;
	}
}
