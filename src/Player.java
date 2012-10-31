/**
 * Represents the actual Player
 * 
 * @author Dhruv Saksena, Rikin Marfatia
 * @version M7
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
	int fuel;
	int water, food, drugs, medicine, weapons, robots;
	StarSystem location;//TODO How to figure out initial location
	
	/**
	 * 
	 * @param name
	 * @param pilotp
	 * @param fighterp
	 * @param traderp
	 * @param enggp
	 * @param difficulty
	 */
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
		//bays = ship.getBays();
		fuel = 100;
		bays = 12;
		water = 0;
		food = 0;
		drugs = 0;
		medicine = 0;
		weapons = 0;
		robots = 0;
	}
	
	/**
	 * Returns the amount of a certain type of Cargo that is held
	 * by the player.
	 * 
	 * @param type The type of Cargo
	 * @return the amount of that type of cargo
	 */
	public int getCargo(String type)
	{
		if(type.equalsIgnoreCase("water"))
		{
			return water;
		}
		
		else if(type.equalsIgnoreCase("food"))
		{
			return food;
		}
		
		else if(type.equalsIgnoreCase("drugs"))
		{
			return drugs;
		}
		
		else if(type.equalsIgnoreCase("medicine"))
		{
			return medicine;
		}
		
		else if(type.equalsIgnoreCase("weapons"))
		{
			return weapons;
		}
		
		else if(type.equalsIgnoreCase("robots"))
		{
			return robots;
		}
		
		return 0;
	}
	
	/**
	 * Method is used when trading, subtracts/adds the change of quantity
	 * of an item to that type of item held by the player depending on if 
	 * it is bought or sold. 
	 * 
	 * @param type The type of item
	 * @param change The amount being bought/sold
	 */
	public void setCargo(String type, int change)
	{
		
		if(type.equalsIgnoreCase("water"))
		{
			water += change;
			bays -= change;
		}
		
		else if(type.equalsIgnoreCase("food"))
		{
			food += change;
			bays -= change;
		}
		
		else if(type.equalsIgnoreCase("drugs"))
		{
			drugs += change;
			bays -= change;
		}
		
		else if(type.equalsIgnoreCase("medicine"))
		{
			medicine += change;
			bays -= change;
		}
		
		else if(type.equalsIgnoreCase("weapons"))
		{
			weapons += change;
			bays -= change;
		}
		
		else if(type.equalsIgnoreCase("robots"))
		{
			robots += change;
			bays -= change;
		}
	
	}
	
	/**
	 * Getter for the amount of money.
	 * 
	 * @return the amount of money held by Player.
	 */
	public int getMoney()
	{
		return money;
	}
	
	/**
	 * Sets the amount of money.
	 * 
	 * @param money the amount of money to be added.
	 */
	public void setMoney(int money)
	{
		this.money = money;
	}
	
	/**
	 * Getter for the amount of bays.
	 * 
	 * @return the amount of bays.
	 */
	public int getBays()
	{
		return bays;
	}
	
	/**
	 * Sets the current location the player is at.
	 * @param system the StarSystem for the player.
	 */
	public void setLocation(StarSystem system)
	{
		location = system;
	}
	
	/**
	 * Getter for the current location of the player.
	 * @return the StarSystem the player is currently at.
	 */
	public StarSystem getLocation()
	{
		return location;
	}
	
	/**
	 * Gets the player's ship
	 * @return the ship
	 */
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
	
	public void relocate()
	{
		//TODO this method if player wants to warp to something
	}
	
	
}
