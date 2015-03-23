/*
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
 */

package linearTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDnaSequences {
	public List<String> findRepeatedDnaSequences(String s) {
		return findRepeatedDnaSequences(s, 10);
	}
	
	public List<String> findRepeatedDnaSequences(String s, int subLength) {
        List<String> result = new ArrayList<String>();
        Set<String> processor = new HashSet<String>();
        int length = s.length();
        if(length <= subLength)
        	return result;
        for(int i=0; i<=length - subLength; i++){
        	String subString = s.substring(i, i + subLength);
        	if(processor.contains(subString)){
        		result.add(subString);
        		processor.remove(subString);
        	}
        	else
        		processor.add(subString);
        }
        processor.clear();
        return result;
    }
}
