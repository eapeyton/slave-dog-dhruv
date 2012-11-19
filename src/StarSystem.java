/**
 * File Comment
 */
import java.awt.Point;
import java.io.Serializable;
import java.util.HashMap;

/**
 * Holds information about a star system. Used by Galactic chart to add star
 * systems to the universe.
 * 
 * @author Dhruv Saksena, Eric Morphis, Rikin Marfatia
 * @version M7
 */
public class StarSystem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	/**
	 * Field name.
	 */
	private String name; // name of the star system
	/**
	 * Field location.
	 */
	private MapPoint location; // location of star system
	/**
	 * Field govt.
	 */
	/**
	 * Field resources.
	 */
	/**
	 * Field techLevel.
	 */
	private final int techLevel, resources, govt; // planet attributes
	/**
	 * Field usedLocations.
	 */
	private static HashMap<MapPoint, StarSystem> UsedLocations =
			new HashMap<MapPoint, StarSystem>();
	/**
	 * Field screenWidth. (value is 450)
	 */
	/**
	 * Field screenHeight. (value is 200)
	 */
	private static final int SCREEN_WIDTH = 450, SCREEN_HEIGHT = 200;
	
	/**
	 * Field TWO.
	 * (value is 2)
	 */
	/**
	 * Field GOVT_RANDOM.
	 * (value is 18)
	 */
	/**
	 * Field RESOURCE_RANDOM.
	 * (value is 13)
	 */
	/**
	 * Field TECH_RANDOM.
	 * (value is 8)
	 */
	private static final int TECH_RANDOM = 8, 
			RESOURCE_RANDOM = 13, GOVT_RANDOM = 18, TWO = 2;
	
	/**
	 * Field ROBOT_GENER.
	 * (value is 11)
	 */
	/**
	 * Field WEPS_GENER.
	 * (value is 16)
	 */
	/**
	 * Field MEDS_GENER.
	 * (value is 21)
	 */
	/**
	 * Field DRUGS_GENER.
	 * (value is 26)
	 */
	/**
	 * Field WATER_GENER.
	 * (value is 31)
	 */
	private static final int WATER_GENER = 31, DRUGS_GENER = 26,
			MEDS_GENER = 21, WEPS_GENER = 16, ROBOT_GENER = 11;
	
	/**
	 * Field TECH_LEVEL_6.
	 * (value is 6)
	 */
	/**
	 * Field TECH_LEVEL_4.
	 * (value is 4)
	 */
	/**
	 * Field TECH_LEVEL_3.
	 * (value is 3)
	 */
	private static final int TECH_LEVEL_3 = 3, TECH_LEVEL_4 = 4, TECH_LEVEL_6 = 6;
	/**
	 * Field cargo.
	 */
	private final int[] cargo;

	// more cargo can be added

	/**
	 * Creates a new star system with a unique location
	 * 
	 * @param name
	 *            The name of the star system
	 */
	public StarSystem(String name) {
		this.name = name;
		while (location == null || UsedLocations.containsKey(location)) {
			setRandLocation();
		}
		/**
		 * Initialize tech, resources, government, and empty cargo.
		 */
		UsedLocations.put(location, this);
		techLevel = (int) (Math.random() * TECH_RANDOM);
		resources = (int) ((Math.random() * RESOURCE_RANDOM) * (Math
				.floor(Math.random() * TWO)));
		govt = (int) (Math.random() * GOVT_RANDOM);
		cargo = new int[CargoPanel.NUM_ARRAY_SUPPLY]; // 0 excluded, six supply items

		// generate the cargo
		generateCargo();

	}

	/**
	 * Randomly selects a location for the star system
	 */
	public void setRandLocation() {// Incase 2 StarSystems overlap
		location = new MapPoint((int) (Math.random() * SCREEN_WIDTH),
				(int) (Math.random() * SCREEN_HEIGHT));
	}

	/**
	 * Getter for the name of the StarSystem
	 * 
	
	 * @return String */
	public String getName() {
		return name;
	}

	/**
	 * Getter for the tech level of the StarSystem
	 * 
	
	 * @return int */
	public int getTechLevel() {
		return techLevel;
	}

	/**
	 * Generates the cargo based on tech level and randomization.
	 */
	public void generateCargo() {
		// water
		if (techLevel >= 0) {
			cargo[CargoPanel.WATER] = (int) (Math.random() * WATER_GENER);
		}

		// food
		if (techLevel >= 1) {
			cargo[CargoPanel.FOOD] = (int) (Math.random() * WATER_GENER);
		}

		// drugs
		if (techLevel >= TECH_LEVEL_3) {
			cargo[CargoPanel.DRUGS] = (int) (Math.random() * DRUGS_GENER);
		}

		// medicine
		if (techLevel >= TECH_LEVEL_4) {
			cargo[CargoPanel.MEDS] = (int) (Math.random() * MEDS_GENER);
		}

		// weapons
		if (techLevel >= TECH_LEVEL_4) {
			cargo[CargoPanel.WEAPONS] = (int) (Math.random() * WEPS_GENER);
		}

		// robots
		if (techLevel >= TECH_LEVEL_6) {
			cargo[CargoPanel.ROBOTS] = (int) (Math.random() * ROBOT_GENER);
		}
	}

	/**
	 * Returns the amount of a certain type of Cargo that is held by the
	 * StarSystem.
	 * 
	 * @param cargoIndex
	 *            The type of supply
	 * 
	
	 * @return the amount of that type of cargo */
	public int getCargo(int cargoIndex) {
		return cargo[cargoIndex];
	}

	/**
	 * Method is used when trading, subtracts/adds the change of quantity of an
	 * item to that type of item held by the StarSystem depending on if it is
	 * bought or sold.
	 * 
	 * @param cargoIndex
	 *            The type of supply to change
	 * @param change
	 *            The amount being bought/sold
	 */
	public void setCargo(int cargoIndex, int change) {
		cargo[cargoIndex] += change;
	}

	/**
	 * Determines which points on the map point to valid planet destinations
	 * 
	 * @param mapPlanetSize
	 *            The size of the planets on the map
	 * @param range
	 *            The distance the player is capable of flying
	 * 
	
	 * @return A hashmap mapping points on the map to star systems */
	public HashMap<MapPoint, StarSystem> getClickMap(int mapPlanetSize, int range) {
		final HashMap<MapPoint, StarSystem> clickMap =
				new HashMap<MapPoint, StarSystem>();
		for (StarSystem ss : UsedLocations.values()) {
			if (!ss.equals(this) && distanceToStarSystem(ss) <= range) {
				for (int i = -(mapPlanetSize >> 1); i <= (mapPlanetSize >> 1); i++) {
					for (int j = -(mapPlanetSize >> 1); j <= (mapPlanetSize >> 1); j++) {
						clickMap.put(new MapPoint((int) ss.getLocation().getX()
								+ i, (int) ss.getLocation().getY() + j), ss);
					}
				}
			}
		}
		return clickMap;
	}

	/**
	 * 
	 * @param ss
	 *            StarSystem
	
	 * @return the distance between this star system and another */
	public int distanceToStarSystem(StarSystem ss) {
		return (int) Math.sqrt(Math.pow(
				ss.getLocation().getX() - location.getX(), TWO)
				+ Math.pow(ss.getLocation().getY() - location.getY(), TWO));
	}

	/**
	 * 
	
	 * @return The star system's name and attributes as a string */
	public String toString() {

		String str = "";
		str += "\nPlanet......." + name;
		str += "\nLocation....." + location.getX() + "," + location.getY();
		str += "\nTech Level..." + techLevel;
		str += "\nResources...." + resources;
		str += "\nGovernment..." + govt;
		str += "\n=======================";

		return str;
	}

	/**
	 * 
	
	 * @return the location */
	public MapPoint getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(MapPoint location) {
		this.location = location;
	}

	/**
	 * 
	
	 * @return The locations already occupied by StarSystems */
	public static HashMap<MapPoint, StarSystem> getUsedLocations() {
		return UsedLocations;
	}

	/**
	 * @param uL
	 *            The locations already occupied by StarSystems; used when
	 *            loading game from file
	 */
	public static void setUsedLocations(HashMap<MapPoint, StarSystem> uL) {
		UsedLocations = uL;
	}
	
	
}
