/**
 * File Comment
 */
import java.io.Serializable;

/**
 * Represents the actual Player
 * 
 * @author Dhruv Saksena, Rikin Marfatia
 * @version M7
 */
public class Player implements Serializable {
	/**
	 * Field INITIAL_FUEL.
	 * (value is 50)
	 */
	/**
	 * Field INITIAL_MONEY.
	 * (value is 1000)
	 */
	/**
	 * Field INITIAL_HEALTH.
	 * (value is 100)
	 */
	private static final int INITIAL_HEALTH = 100,
			INITIAL_MONEY = 1000, INITIAL_FUEL = 50;
	/**
	 * Field INITIAL_BAYS.
	 * (value is 12)
	 */
	public static final int INITIAL_BAYS = 12;
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
	public int health;
	/**
	 * Field location.
	 */
	public StarSystem location;
	
	/**
	 * Field THREE.
	 * (value is 3)
	 */
	/**
	 * Field TWO.
	 * (value is 2)
	 */
	/**
	 * Field ONE.
	 * (value is 1)
	 */
	/**
	 * Field ZERO.
	 * (value is 0)
	 */
	public static final int ZERO=0, ONE=1, TWO=2, THREE=3;

	/**
	 * 
	 * @param name
	
	
	
	
	 * @param difficulty
	 * @param arr Integer[]
	 */
	public Player(String name, Integer [] arr, String difficulty) {
		this.name = name;
		this.health = INITIAL_HEALTH;
		this.pilotp = arr[ZERO];
		this.fighterp = arr[ONE];
		this.traderp = arr[TWO];
		this.enggp = arr[THREE];
		this.difficulty = difficulty;
		money = INITIAL_MONEY;
		ship = new Ship();

		// bays = ship.getBays();
		fuel = INITIAL_FUEL;
		bays = INITIAL_BAYS;
		cargo = new int[CargoPanel.NUM_ARRAY_SUPPLY]; // six types of supplies, 0 excluded
	}

	/**
	 * Returns the amount of a certain type of Cargo that is held by the player.
	 * 
	 * @param cargoIndex
	 *            The type of Cargo
	 * 
	
	 * @return the amount of that type of cargo */
	public int getCargo(int cargoIndex) {
		return cargo[cargoIndex];
	}

	/**
	 * 
	
	 * @return Amount of fuel the player currently has */
	public int getFuel() {
		return fuel;
	}

	/**
	 * Method is used when trading, subtracts/adds the change of quantity of an
	 * item to that type of item held by the player depending on if it is bought
	 * or sold.
	 * 
	 * @param cargoIndex
	 *            The type of item
	 * @param change
	 *            The amount being bought/sold
	 */
	public void setCargo(int cargoIndex, int change) {
		cargo[cargoIndex] += change;
		bays -= change;
	}

	/**
	 * Method is used when travelling, subtracts the amount of fuel that is used
	 * to go from planet to planet
	 * 
	 * @param fuelChange
	 *            int
	 */
	public void setFuel(int fuelChange) {
		fuel += fuelChange;
	}

	/**
	 * Getter for the amount of money.
	 * 
	 * 
	
	 * @return the amount of money held by Player. */
	public int getMoney() {
		return money;
	}

	/**
	 * Sets the amount of money.
	 * 
	 * @param money
	 *            the amount of money to be added.
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	/**
	 * Getter for the amount of bays.
	 * 
	 * 
	
	 * @return the amount of bays. */
	public int getBays() {
		return bays;
	}

	/**
	 * Sets the current location the player is at.
	 * 
	 * @param system
	 *            the StarSystem for the player.
	 */
	public void setLocation(StarSystem system) {

		location = system;
	}

	/**
	 * Getter for the current location of the player.
	 * 
	
	 * @return the StarSystem the player is currently at. */
	public StarSystem getLocation() {
		return location;
	}

	/**
	 * Gets the player's ship
	 * 
	
	 * @return the ship */
	public Ship getShip() {
		return ship;
	}

	/**
	 * Rewrote the toString method to return the player's attributes.
	 * 
	
	 * @return String */
	public String toString() {
		return "Player... \nName: " + name + "\nDifficulty: " + difficulty
				+ "\nSkills...\nPilot: " + pilotp + "\nFighter: " + fighterp
				+ "\nTrader: " + traderp + "\nEngineer: " + enggp;
	}

	/**
	 * Pass in damage player has to take
	 * 
	 * @param damage
	 */
	public void takeDamage(int damage) {
		if (health - damage <= 0) {// Dead
			health = 0;
			return;
		} else {// Not Dead
			health = health - damage;
			return;
		}
	}
}
