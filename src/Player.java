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
	
	public Player(String name, int pilotp, int fighterp, int traderp, int enggp, String difficulty) {
		super();
		this.name = name;
		this.pilotp = pilotp;
		this.fighterp = fighterp;
		this.traderp = traderp;
		this.enggp = enggp;
		this.difficulty = difficulty;
	}
	
	
	
}
