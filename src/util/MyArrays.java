package util;

public class MyArrays {
	private MyArrays(){}
	
	public static int[] getShuffledArray(int numberOfElements){
		int[] result = new int[numberOfElements];
		for(int k=1; k<=numberOfElements; k++){
			int position = (int) (Math.random()*numberOfElements);
			while(result[position] != 0){
				position++;
				if(position >= numberOfElements)
					position = 0;
			}
			result[position] = k;
		}
		return result;
	}
	
	public static int[] getShuffledArray(int numElements, double duplicationProb, int startFrom){
		Integer[] IntegerArray = new Integer[numElements];
		int[] resultArray = new int[numElements];
		int k=startFrom;
		for(int i=0; i<numElements; i++){
			int position = (int)(Math.random()*numElements);
			while(IntegerArray[position] != null){
				position++;
				if(position >= numElements)
					position = 0;
			}
			IntegerArray[position] = k;
			
			//create next k
			double increationProbability = Math.random();
			if(increationProbability < 1-duplicationProb){
				k++;
			}
		}
		
		//conver Integer[] to int[]
		for(int i=0; i<numElements; i++){
			resultArray[i] = IntegerArray[i];
		}
		return resultArray;
	}
}
