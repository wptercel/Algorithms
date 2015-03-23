package application.ticTacToe;

public class GameEntry {
	protected String name;
	protected int score;
	
	public GameEntry(String name, int score){
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public String toString(){
		return "("+name+": "+score+")";
	}
}
