package number;
/*Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.*/

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        if(x < 0) return false;
        
        int radix = 1;
        while(x / radix != 0)
        	radix *= 10;
        
        int xidar = 10;
        while(x/radix == x%xidar && radix != xidar){
        	radix /= 10;
        	xidar *= 10;
        }
        if(radix != xidar)
        	return true;
        else
        	return false;
        
    }
}
