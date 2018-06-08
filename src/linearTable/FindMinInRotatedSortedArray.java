/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
 */
package linearTable;

public class FindMinInRotatedSortedArray {
	public int findMin(int[] num) {
        return getMin(num, 0, num.length - 1);
    }
    
    private int getMin(int[] num, int start, int end){
        if(end == start || num[start] < num[end])
            return num[start];
        else{
            int min = (start + end) / 2;
            return Math.min(getMin(num, start, min), getMin(num, min + 1, end));
        }
    }
}
