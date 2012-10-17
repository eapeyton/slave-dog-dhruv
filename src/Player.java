/**
 * Represents the actual Player
 * 
 * @author Dhruv Saksena
 *@version M5
 */
public class Player {

	String name;
	String difficulty;
	int pilotp;
	int fighterp;
	int traderp;
	int enggp;
	int location;//TODO How to figure out initial location
	
	public Player(String name, int pilotp, int fighterp, int traderp, int enggp, String difficulty) {
		super();
		this.name = name;
		this.pilotp = pilotp;
		this.fighterp = fighterp;
		this.traderp = traderp;
		this.enggp = enggp;
		this.difficulty = difficulty;
	}
	
	/**
	 * Rewrote the toString method to return the player's attributes.
	 */
	public String toString() {
		return "Player... \nName: " + name + "\nDifficulty: " + difficulty + "\nSkills...\nPilot: " + pilotp + "\nFighter: " + fighterp + "\nTrader: " + traderp + "\nEngineer: " + enggp;
	}
	
	public void relocate(){
		//TODO this method if player wants to warp to something
	}
	
	
}
