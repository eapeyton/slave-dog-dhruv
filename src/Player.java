/**
 * Represents the actual Player
 * 
 * @author Dhruv Saksena
 *@version M5
 */
public class Player {

	String name;
	String difficulty;
	Ship ship;
	int money;
	int pilotp;
	int fighterp;
	int traderp;
	int enggp;
	int bays;
	StarSystem location;//TODO How to figure out initial location
	
	public Player(String name, int pilotp, int fighterp, int traderp, int enggp, String difficulty) {
		super();
		this.name = name;
		this.pilotp = pilotp;
		this.fighterp = fighterp;
		this.traderp = traderp;
		this.enggp = enggp;
		this.difficulty = difficulty;
		money = 1000;
		ship = new Ship();
	}
	
	public void setLocation(StarSystem system)
	{
		location = system;
	}
	
	public StarSystem getLocation()
	{
		return location;
	}
	
	public Ship getShip()
	{
		return ship;
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
