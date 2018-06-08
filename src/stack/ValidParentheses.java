/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	Stack<Character> parenthesesStack = new Stack<>();
    Map<Character, Character> parenthesesMap = new HashMap<>();
    {
        parenthesesMap.put(')', '(');
        parenthesesMap.put(']', '[');
        parenthesesMap.put('}', '{');
    }
    
    public boolean isValid(String s) {
        for(int i=0; i<s.length(); i++){
            if(parenthesesMap.containsValue(s.charAt(i))){
                parenthesesStack.push(s.charAt(i));
            }
            if(parenthesesMap.containsKey(s.charAt(i))){
                if(parenthesesStack.isEmpty())
            	    return false;
                if(!parenthesesMap.get(s.charAt(i)).equals(parenthesesStack.pop()))
            		return false;
            }
        }
        if(parenthesesStack.isEmpty())
            return true;
        else
            return false;
    }
}
