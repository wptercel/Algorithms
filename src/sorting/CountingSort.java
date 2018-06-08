package sorting;

import java.util.Arrays;

public class CountingSort {
	
	public static void sort(int[] array, int k){
		int[] helperArray = new int[k+1];
		for(int e:array){
			helperArray[e]++;
		}
		
		/*test*/System.out.println(Arrays.toString(helperArray));
		
		for(int i=1; i<=k; i++){
			helperArray[i] += helperArray[i-1];
		}
		
		/*test*/System.out.println(Arrays.toString(helperArray));
		
		int[] resultArray = new int[array.length];
		for(int i=0; i<array.length; i++){
			resultArray[helperArray[array[i]]-1] = array[i];
			helperArray[array[i]]--;
		}
		
		//copy back to array
		for(int i=0; i<array.length; i++){
			array[i] = resultArray[i];
		}
	}
}
