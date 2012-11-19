/**
 * File Comment
 */

import java.io.Serializable;

/**
 * This class represents the general ship class, which holds the base
 * information about the ship.
 * 
 * @author Rikin Marfatia
 * 
 * @version $Revision: 1.0 $
 */
public class Ship implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	/**
	 * Field bays.
	 */
	private int bays;
	/**
	 * Field health.
	 */
	private final int health;
	/**
	 * Field sheild.
	 */
	private final int sheild;
	/**
	 * Field type.
	 */
	private final String type;

	// Add specificities for each type of ship, type will be chosen dependent on
	// the number entered into the constructor
	/**
	 * Default Constructor, for now Sets up the base stats of the ship.
	 */
	public Ship(/* int type */) {
		bays = 12;
		health = 100;
		sheild = 0;
		type = "Gnat";
	}

	/**
	 * Method setBays.
	 * 
	 * @param bays
	 *            int
	 */
	public void setBays(int bays) {
		this.bays = bays;
	}

	/**
	 * Method getBays.
	 * 
	 * @return int
	 */
	public int getBays() {
		return bays;
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	public String toString() {
		return "" + type;
	}

}
