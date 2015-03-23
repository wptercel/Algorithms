package application;

public class CaesarCryptography {
	private static final int ALPHASIZE = 26;
	public static final char[] alpha = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	
	protected char[] encrypt = new char[ALPHASIZE];
	protected char[] decrypt = new char[ALPHASIZE];
	
	public CaesarCryptography(int shift){
		for(int i=0; i<ALPHASIZE; i++){
			encrypt[i] = alpha[(i+shift) % ALPHASIZE];
			decrypt[encrypt[i] - 'A'] = alpha[i];
		}
	}
	
	public String encrypt(String plainText){
		char[] plainTextCharArray = plainText.toCharArray();
		for(int i=0; i<plainTextCharArray.length; i++){
			if(Character.isLetter(plainTextCharArray[i]))
				plainTextCharArray[i] = Character.toUpperCase(plainTextCharArray[i]);
		}
		for(int i=0; i<plainText.length(); i++){
			if(Character.isLetter(plainTextCharArray[i]))
				plainTextCharArray[i] = encrypt[plainTextCharArray[i] - 'A']; 
		}
		return new String(plainTextCharArray);
	}
	
	public String decrypt(String cypherText){
		char[] cypherTextCharArray = cypherText.toCharArray();
		for(int i=0; i<cypherTextCharArray.length; i++){
			if(Character.isLetter(cypherTextCharArray[i])){
				cypherTextCharArray[i] = Character.toUpperCase(cypherTextCharArray[i]);
			}
		}
		for(int i=0; i<cypherTextCharArray.length; i++){
			if(Character.isLetter(cypherTextCharArray[i]))
				cypherTextCharArray[i] = decrypt[cypherTextCharArray[i] - 'A']; 
		}
		return new String(cypherTextCharArray);
	}
	
	public static void main(String[] args) {
		CaesarCryptography test = new CaesarCryptography(25);
		System.out.println(test.encrypt("abc, this is my computer"));
		System.out.println(test.decrypt("EFG, XLMW MW QC GSQTYXIV"));
	}

}
