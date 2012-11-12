import java.awt.Point;
import java.io.Serializable;
import java.util.HashMap;

/**
 * Holds information about a star system. Used by Galactic chart to add star systems 
 * to the universe.
 * @author Dhruv Saksena, Eric Morphis, Rikin Marfatia
 * @version M7
 */
public class StarSystem implements Serializable
{
	
	private String name;	//name of the star system
	private Point location;	//location of star system
	private int techLevel,resources,govt;	//planet attributes
	private static HashMap<Point, StarSystem> usedLocations = new HashMap<Point, StarSystem>();
	private final int screenWidth=450;
	private final int screenHeight=200;
	private int[] cargo;
	// more cargo can be added
	
	/**
	 * Creates a new star system with a unique location
	 * @param name The name of the star system
	 */
	public StarSystem(String name) {
		super();
		this.name=name;
		while (location == null || usedLocations.containsKey(location)) {
			setRandLocation();
		}
		/**
		 * Initialize tech, resources, government, and empty cargo.
		 */
		usedLocations.put(location, this);
		techLevel=(int) (Math.random()*8);
		resources=(int) ((Math.random()*13)*(Math.floor(Math.random()*2)));
		govt=(int) (Math.random()*18);
		cargo = new int[7]; //0 excluded, six supply items
		
		//generate the cargo
		generateCargo();
		
	}
	
	/**
	 * Randomly selects a location for the star system
	 */
	public void setRandLocation(){//Incase 2 StarSystems overlap
		location = new Point((int) (Math.random()*screenWidth),(int) (Math.random()*screenHeight));
	}
	
	/**
	 * Getter for the name of the StarSystem
	 * @return
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Getter for the tech level of the StarSystem
	 * @return
	 */
	public int getTechLevel()
	{
		return techLevel;
	}
	
	/**
	 * Generates the cargo based on tech level and randomization.
	 */
	public void generateCargo()
	{
		//water
		if(techLevel >= 0)
		{
			cargo[1] = (int)(Math.random() * 31);
		}
		
		//food
		if(techLevel >= 1)
		{
			cargo[2] = (int)(Math.random() * 31);
		}
		
		//drugs
		if(techLevel >= 3)
		{
			cargo[3]  = (int)(Math.random() * 26);
		}
		
		//medicine
		if(techLevel >= 4)
		{
			cargo[4] = (int)(Math.random() * 21);
		}
		
		//weapons
		if(techLevel >= 4)
		{
			cargo[5] = (int)(Math.random() * 16);
		}
		
		//robots
		if(techLevel >= 6)
		{
			cargo[6] = (int)(Math.random() * 11);
		}
	}
	
	/**
	 * Returns the amount of a certain type of Cargo that is held
	 * by the StarSystem.
	 * 
	 * @param cargoIndex The type of supply
	 * @return the amount of that type of cargo
	 */
	public int getCargo(int cargoIndex)
	{
		return cargo[cargoIndex];
	}
	
	/**
	 * Method is used when trading, subtracts/adds the change of quantity
	 * of an item to that type of item held by the StarSystem depending on if 
	 * it is bought or sold. 
	 * 
	 * @param cargoIndex The type of supply to change
	 * @param change The amount being bought/sold
	 */
	public void setCargo(int cargoIndex, int change)
	{
		cargo[cargoIndex] += change;
	}
	
	/**
	 * Determines which points on the map point to valid planet destinations
	 * @param mapPlanetSize The size of the planets on the map
	 * @param range The distance the player is capable of flying
	 * @return A hashmap mapping points on the map to star systems
	 */
	public HashMap<Point, StarSystem> getClickMap(int mapPlanetSize, int range) {
		HashMap<Point, StarSystem> clickMap = new HashMap<Point, StarSystem>();
		for (StarSystem ss : usedLocations.values()) {
			if (ss != this && distanceToStarSystem(ss) <= range) {
				for (int i = -mapPlanetSize/2; i <= mapPlanetSize/2; i++) {
					for (int j = -mapPlanetSize/2; j<= mapPlanetSize/2; j++) {
						clickMap.put(new Point((int)ss.getLocation().getX() + i, (int)ss.getLocation().getY() + j), ss);
					}
				}
			}
		}
		return clickMap;
	}
	
	/**
	 * @return the distance between this star system and another
	 */
	public int distanceToStarSystem(StarSystem ss) {
		return (int)Math.sqrt(
				Math.pow(ss.getLocation().getX()-location.getX(), 2) + Math.pow(ss.getLocation().getY()-location.getY(), 2)
				);
	}
	
	
	/**
	 * @return The star system's name and attributes as a string
	 */
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
	 * @return the location
	 */
	public Point getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Point location) {
		this.location = location;
	}
}
