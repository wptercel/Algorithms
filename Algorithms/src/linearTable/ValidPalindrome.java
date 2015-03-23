package linearTable;
/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.*/

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if(s.length() <= 1) return true;
		
		String temp = s.toLowerCase();
		int length = s.length();
		int lp = 0;
		int rp = length - 1;
		while(lp < rp){
			while(!Character.isLetterOrDigit(temp.charAt(lp)) && lp < rp)
				lp++;
			while(!Character.isLetterOrDigit(temp.charAt(rp)) && lp < rp)
				rp--;
			if(temp.charAt(lp++) != temp.charAt(rp--))
				return false;
		}
		return true;
    }
}
