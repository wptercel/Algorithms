package sorting;

public class InsertionSort {
	public static void sort(int[] array){
		if(array.length <= 1)
			return;
		
		for(int i=1; i<array.length; i++){
			int j = i - 1;
			int temp = array[i];
			while(j >= 0 && temp < array[j]){
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = temp;
		}
	}
}
