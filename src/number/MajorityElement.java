/*
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
 */
package number;

import java.util.HashMap;

public class MajorityElement {
	public int majorityElement(int[] num) {
        int halfLength = num.length / 2;
        HashMap<Integer, Integer> counter = new HashMap<>();
        for(int i:num){
            if(counter.containsKey(i)){
                counter.put(i, counter.get(i)+1);
                if(counter.get(i) > halfLength)
                    return i;
            }
            else{
                counter.put(i, 1);
                if(counter.get(i) > halfLength)
                    return i;
            }
        }
        return Integer.MIN_VALUE;
    }
}
