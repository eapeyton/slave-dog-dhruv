import java.io.Serializable;

/**
 * This class represents the general ship class, which holds the base information about the ship.
 * 
 * @author Rikin Marfatia
 *
 */
public class Ship implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	int bays;
	int health;
	int sheild;
	String type;
	
	// Add specificities for each type of ship, type will be chosen dependent on the number entered into the constructor
	/**
	 * Default Constructor, for now
	 * Sets up the base stats of the ship.
	 */
	public Ship (/*int type*/)
	{
		bays = 12;
		health = 100;
		sheild = 0;
		type = "Gnat";
	}
	
	public void setBays(int bays)
	{
		this.bays = bays;
	}
	
	public int getBays()
	{
		return bays;
	}
	
}
