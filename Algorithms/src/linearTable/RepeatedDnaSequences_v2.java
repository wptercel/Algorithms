package linearTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDnaSequences_v2 {
	//save memory. Since there are only 4 letters
	//10*2 bits < int.bitSize
	private final int A = 0x00_00_00_01;
	private final int C = 0x00_00_00_02;
	private final int G = 0x00_00_00_03;
	private final int T = 0x00_00_00_04;

	public List<String> findRepeatedDnaSequences(String s) {
		return findRepeatedDnaSequences(s, 10);
	}

	public List<String> findRepeatedDnaSequences(String s, int subLength) {
		List<String> result = new ArrayList<String>();
		Set<Integer> processor = new HashSet<Integer>();
		int length = s.length();

		if(length <= subLength)
			return result;

		for(int i=0; i<=length - subLength; i++){
			String subString = s.substring(i, i + subLength);
			int tempResult = 0;
			for(int j=0; j<subLength; j++){
				int letter = 0;
				switch(s.charAt(i+j)){
				case 'A':
					letter = A;
					break;
				case 'C':
					letter = C;
					break;
				case 'G':
					letter = G;
					break;
				case 'T':
					letter = T;
				}
				tempResult = tempResult << 2;
				tempResult |= letter;
			}
			if(processor.contains(tempResult))
				result.add(subString);
			else
				processor.add(tempResult);
		}
		processor.clear();
		return result;
	}

	public static void main(String args[]){
		RepeatedDnaSequences_v2 test = new RepeatedDnaSequences_v2();
		System.out.println(test.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		System.out.println(new Byte((byte)2).hashCode());
		Byte b1 = (byte)1;
		Byte b2 = (byte)1;
		System.out.println(b1 == b2);
	}
}
