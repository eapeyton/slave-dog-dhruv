import java.io.Serializable;

/**
 * Represents the actual Player
 * 
 * @author Dhruv Saksena, Rikin Marfatia
 * @version M7
 */
public class Player implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Field name.
	 */
	public String name;
	/**
	 * Field difficulty.
	 */
	public String difficulty;
	/**
	 * Field ship.
	 */
	public Ship ship;
	/**
	 * Field fuel.
	 */
	/**
	 * Field bays.
	 */
	/**
	 * Field enggp.
	 */
	/**
	 * Field traderp.
	 */
	/**
	 * Field fighterp.
	 */
	/**
	 * Field pilotp.
	 */
	/**
	 * Field money.
	 */
	public int money, pilotp, fighterp, traderp, enggp, bays, fuel;
	/**
	 * Field cargo.
	 */
	public int[] cargo;
	/**
	 * Field health.
	 */
	public int health=100;
	/**
	 * Field location.
	 */
	public StarSystem location;
	
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
		this.name = name;
		this.pilotp = pilotp;
		this.fighterp = fighterp;
		this.traderp = traderp;
		this.enggp = enggp;
		this.difficulty = difficulty;
		money = 1000;
		ship = new Ship();
		
		//bays = ship.getBays();
		fuel = 50;
		bays = 12;
		cargo = new int[7]; //six types of supplies, 0 excluded
	}
	
	/**
	 * Returns the amount of a certain type of Cargo that is held
	 * by the player.
	 * 
	 * @param cargoIndex The type of Cargo
	
	 * @return the amount of that type of cargo */
	public int getCargo(int cargoIndex)
	{
		return cargo[cargoIndex];
	}
	
	/**
	
	 * @return Amount of fuel the player currently has */
	public int getFuel() {
		return fuel;
	}
	
	/**
	 * Method is used when trading, subtracts/adds the change of quantity
	 * of an item to that type of item held by the player depending on if 
	 * it is bought or sold. 
	 * 
	 * @param cargoIndex The type of item
	 * @param change The amount being bought/sold
	 */
	public void setCargo(int cargoIndex, int change)
	{
		cargo[cargoIndex] += change;
		bays -= change;	
	}
	
	/**
	 * Method is used when travelling, subtracts the amount of fuel that is used to go from
	 * planet to planet
	
	 * @param fuelChange int
	 */
	public void setFuel(int fuelChange) {
		fuel += fuelChange;
	}
	
	/**
	 * Getter for the amount of money.
	 * 
	
	 * @return the amount of money held by Player. */
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
	
	 * @return the amount of bays. */
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
	
	 * @return the StarSystem the player is currently at. */
	public StarSystem getLocation()
	{
		return location;
	}
	
	/**
	 * Gets the player's ship
	
	 * @return the ship */
	public Ship getShip()
	{
		return ship;
	}
	
	/**
	 * Rewrote the toString method to return the player's attributes.
	 * @return String
	 */
	public String toString() {
		return "Player... \nName: " + name + "\nDifficulty: " + difficulty + "\nSkills...\nPilot: " + pilotp + "\nFighter: " + fighterp + "\nTrader: " + traderp + "\nEngineer: " + enggp;
	}
	
	
	/**
	 * Pass in damage player has to take
	 * @param damage
	
	 */
	public void takeDamage(int damage){
		if(health-damage<=0){//Dead
			health=0;
			return;
		}
		else{//Not Dead
			health=health-damage;
			return;
		}
	}
}
