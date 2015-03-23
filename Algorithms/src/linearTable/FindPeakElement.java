package linearTable;
/*A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ¡Ù num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -¡Ş.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Note:
Your solution should be in logarithmic complexity.*/

public class FindPeakElement {
	public int findPeakElement(int[] num) {
		int boundaryCheck = checkBoundary(num);
		if(boundaryCheck != -1)
			return boundaryCheck;
        return find(num, 1, num.length-2);
    }
	
	private static int checkBoundary(int[] array){
		if(array.length == 1)
			return 0;
		if(array[0] > array[1]) return 0;
		if(array[array.length-1] > array[array.length-2]) return array.length-1;
		return -1;
	}
	
	private static int find(int[] array, int start, int end){
		if(start == end)
			return start;
		
		int mid = (start + end) / 2;
		
		if(array[mid] > array[mid-1] && array[mid] > array[mid+1])
			return mid;
		if(array[mid] < array[mid+1])
			return find(array, mid+1, end);
		if(array[mid] < array[mid-1])
			return find(array, start, mid);
		
		return -1;
	}
}