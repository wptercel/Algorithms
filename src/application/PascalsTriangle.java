/*
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		if(numRows <= 0){
			return triangle;
		}
		else{
			List<Integer> firstLine = new ArrayList<Integer>();
			firstLine.add(1);
			triangle.add(firstLine);
			
			int i = 0;
			while(i < numRows - 1){
				triangle.add(generateNextLine(triangle.get(i++)));
			}
		}
		return triangle;
    }
	
	private List<Integer> generateNextLine(List<Integer> line){
		int upperLineSize = line.size();
		int endPoint = upperLineSize / 2;
		List<Integer> newLine = Arrays.asList(new Integer[upperLineSize + 1]);
		newLine.set(0, 1);
		newLine.set(upperLineSize, 1);
		for(int i=1, j=upperLineSize - 1; i<=endPoint; i++, j--){
			newLine.set(i, line.get(i-1) + line.get(i));
			newLine.set(j, line.get(i-1) + line.get(i));
		}
		return newLine;
	}
}
