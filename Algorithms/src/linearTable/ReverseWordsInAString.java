/*
 * Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
 */
package linearTable;

import java.util.Stack;

public class ReverseWordsInAString {
	public String reverseWords(String s) {
        String result = "";
        Stack<String> wordStack = new Stack<String>();
		String[] words = s.split(" ");
		for(int i=0; i<words.length; ++i){
			if(words[i].length() >0)
				wordStack.push(words[i]);
		}
		while(!wordStack.empty()){
			result = result + wordStack.pop() + " ";
		}
		return result.trim();
    }
}
//Too long running time
