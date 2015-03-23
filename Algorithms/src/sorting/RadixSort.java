package sorting;

import java.util.*;

public class RadixSort {
	//Use queue(LinkedList) as bucket
	public static void sort1(int[] array, int d){
		//initiate the buckets
		Queue<Integer>[] buckets = new LinkedList[10];
		for(int i=0; i<10; i++)
			buckets[i] = new LinkedList<Integer>();
		
		//n = 1, 10, 100 ...
		int n = 1;
		
		while(n<d){ //n=d is not necessary
			//load number into buckets
			for(int i:array)
				buckets[(i/n)%10].add(i);
			
			int j = 0;
			for(int i=0; i<10; i++)
				while(!buckets[i].isEmpty())
					array[j++] = buckets[i].remove();
			
			n *= 10; 
			//restore buckets
			for(int i=0; i<10; i++)
				buckets[i] = new LinkedList<Integer>();
		}
	}
	
	
	//Use stack as bucket
	public static void sort2(int[] array, int d){
		Stack<Integer>[] buckets = new Stack[10];
		for(int i=0; i<10; i++){
			buckets[i] = new Stack<Integer>();
		}
		int n = 1;
		
		while(n < d){
			for(int e:array){
				buckets[(e/n)%10].push(e);
			}
			int j=array.length-1;
			for(int i=9; i>=0; i--){
				while(!buckets[i].isEmpty()){
					array[j--] = buckets[i].pop();
				}
			}
			
			//restore the buckets
			for (int i = 0; i < buckets.length; i++) {
				buckets[i] = new Stack<Integer>();
			}
			n *= 10;
		}
	}
}
