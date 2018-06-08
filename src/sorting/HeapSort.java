package sorting;

public class HeapSort {
	private int[] heap;
	private final int DEFAULT_LENGTH = 100;
	private int usedNum;
	
	public HeapSort(){
		heap = new int[DEFAULT_LENGTH];
		usedNum = 0;
	}
	
	public HeapSort(int length){
		if(length > 0 && length <= DEFAULT_LENGTH){
			heap = new int[length];
			usedNum = 0;
		}
	}
	
	private void maxheapify(int index){
		int leftIndex = index * 2;
		int rightIndex = leftIndex + 1;
		int largest = 0;
		if(index < heap.length){
			if(leftIndex < heap.length){
				largest = leftIndex;
				if(rightIndex < heap.length && heap[rightIndex] > heap[leftIndex])
					largest = rightIndex;
			}
			if(heap[index] < heap[largest]){
				swap(index, largest);
				maxheapify(largest);
			}
			else
				largest = index;
		}
	}
	
	private void swap(int locationA, int locationB){
		int temp = heap[locationA];
		heap[locationA] = heap[locationB];
		heap[locationB] = temp;
	}
	
	public void add(int value){
		usedNum++;
		if(usedNum <= heap.length)
			heap[usedNum-1] = value;
		for(int i=(usedNum-1)/2; i>=0; i=i/2)
			maxheapify(i);
	}
	
	public int pop(){
		int result = 0;
		usedNum--;
		if(usedNum == 0)
			result = heap[0];
		if(usedNum > 0){
			result = heap[0];
			heap[0] = heap[usedNum];
			maxheapify(0);
		}
		return result;
	}
	
	public int[] toSortedArray(){
		int[] resultArray = new int[heap.length];
		for(int i=0; i<resultArray.length; i++){
			resultArray[i] = pop();
		}
		return resultArray;
	}
}
