package application.ticTacToe;

public class Score {
	public static final int maxEntries = 3;
	protected int numEntries;
	protected GameEntry[] entries;
	
	public Score(){
		entries = new GameEntry[maxEntries];
		numEntries = 0;
	}
	
	public String toString(){
		String s="[";
		for(int i=0; i<numEntries; i++){
			if(i>0)
				s += ", ";
			s += entries[i];
		}
		return s + "]";
	}
	
	public void add(GameEntry e){
		int newScore = e.getScore();
		if(numEntries == maxEntries){
			if(newScore <= entries[numEntries - 1].getScore()){
				return;
			}
		}
		else
			numEntries++;
		int i = numEntries-1;
		for(; (i>=1)&&(newScore>entries[i-1].getScore()); i--)
			entries[i] = entries[i-1];
		entries[i] = e;
	}
	
	public GameEntry remove(int index) throws IndexOutOfBoundsException{
		if(index<0 || index > numEntries-1)
			throw new IndexOutOfBoundsException();
		GameEntry temp = entries[index];
		for(int i=index; i<numEntries-1; i++){
			entries[i] = entries[i+1];
		}
		entries[numEntries-1] = null;
		numEntries--;
		return temp;
	}
	
	public static void main(String[] args){
		GameEntry g1 = new GameEntry("one", 1);
		GameEntry g2 = new GameEntry("two", 2);
		GameEntry g3 = new GameEntry("thr", 3);
		GameEntry g4 = new GameEntry("fou", 4);
		Score testScore = new Score();
		testScore.add(g1);
		testScore.add(g2);
		testScore.add(g3);
		testScore.add(g4);
		System.out.println(testScore);
		System.out.println(testScore.numEntries);
		testScore.remove(4);
		System.out.println(testScore);
		System.out.println(testScore.numEntries);
	}
}
