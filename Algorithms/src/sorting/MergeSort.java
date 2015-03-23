package sorting;

public class MergeSort {
	public static int[] sort(int[] array){		
		int[] result = new int[array.length];
		mergeSort(array, result, 0, array.length-1);
		return result;
	}
	
	private static void mergeSort(int[] array, int[] result, int mergeStart, int mergeEnd){
		//if only 1 element, return directly
		if(mergeEnd-mergeStart == 0)
			return;
		int mid = (mergeStart + mergeEnd) / 2;
		mergeSort(array, result, mergeStart, mid);
		mergeSort(array, result, mid+1, mergeEnd);
		merge(array, result, mergeStart, mid+1, mergeEnd);
	}
	
	private static void merge(int[] array, int[] result, int startA, int startB, int mergeEnd){
		int index  = startA;
		int indexA = startA;
		int indexB = startB;
		while(indexA < startB && indexB <= mergeEnd){
			if(array[indexA] < array[indexB])
				result[index++] = array[indexA++];
			else
				result[index++] = array[indexB++];
		}
		while(indexA < startB)
			result[index++] = array[indexA++];
		while(indexB <= mergeEnd)
			result[index++] = array[indexB++];
		
		//copy result back to be used by the next loop
		for(int i=startA; i<=mergeEnd; i++)
			array[i] = result[i];
	}
}