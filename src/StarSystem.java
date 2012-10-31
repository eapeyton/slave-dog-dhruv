import java.awt.Point;
import java.util.HashSet;
import java.util.HashMap;

/**
 * Holds information about a star system. Used by Galactic chart to add star systems 
 * to the universe.
 * @author Dhruv Saksena, Eric Morphis, Rikin Marfatia
 * @version M7
 */
public class StarSystem {

	String name;
	int xMap;
	int yMap;
	Point location;
	int techLevel;
	int resources;
	int govt;
	static HashMap<Point, StarSystem> usedLocations = new HashMap<Point, StarSystem>();
	final int screenWidth=450;
	final int screenHeight=200;
	int water = 0;
	int food = 0;
	int drugs = 0;
	int medicine = 0;
	int weapons = 0;
	int robots = 0;
	int[] cargoItems = new int[6];
	// more cargo can be added
	
	/**
	 * Creates a new star system with a unique location
	 * @param name The name of the star system
	 */
	public StarSystem(String name) {
		super();
		this.name=name;
		while (location == null || usedLocations.containsKey(location)) {
			setLocation();
		}
		usedLocations.put(location, this);
		techLevel=(int) (Math.random()*8);
		resources=(int) ((Math.random()*13)*(Math.floor(Math.random()*2)));
		govt=(int) (Math.random()*18);
		generateCargo();
		
	}
	
	/**
	 * Randomly selects a location for the star system
	 */
	public void setLocation(){//Incase 2 StarSystems overlap
		xMap=(int) (Math.random()*screenWidth);
		yMap=(int) (Math.random()*screenHeight);
		location = new Point(xMap, yMap);
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
		if(techLevel >= 0)
		{
			water = (int)(Math.random() * 31);
		}
		
		if(techLevel >= 1)
		{
			food = (int)(Math.random() * 31);
		}
		
		if(techLevel >= 3)
		{
			drugs = (int)(Math.random() * 26);
		}
		
		if(techLevel >= 4)
		{
			medicine = (int)(Math.random() * 21);
		}
		
		if(techLevel >= 4)
		{
			weapons = (int)(Math.random() * 16);
		}
		
		if(techLevel >= 6)
		{
			robots = (int)(Math.random() * 11);
		}
	}
	
	/**
	 * Returns the amount of a certain type of Cargo that is held
	 * by the StarSystem.
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
	 * of an item to that type of item held by the StarSystem depending on if 
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
		}
		
		else if(type.equalsIgnoreCase("food"))
		{
			food += change;
		}
		
		else if(type.equalsIgnoreCase("drugs"))
		{
			drugs += change;
		}
		
		else if(type.equalsIgnoreCase("medicine"))
		{
			medicine += change;
		}
		
		else if(type.equalsIgnoreCase("weapons"))
		{
			weapons += change;
		}
		
		else if(type.equalsIgnoreCase("robots"))
		{
			robots += change;
		}
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
						clickMap.put(new Point(ss.xMap + i, ss.yMap + j), ss);
					}
				}
			}
		}
		return clickMap;
	}
	
	/**
	 * @return the distance between this star system an another
	 */
	public int distanceToStarSystem(StarSystem ss) {
		return (int)Math.sqrt((ss.xMap-xMap)*(ss.xMap-xMap)+(ss.yMap-yMap)*(ss.yMap-yMap));
	}
	
	
	/**
	 * @return The star system's name and attributes as a string
	 */
	public String toString() {
		
		String str = "";
		str += "\nPlanet......." + name;
		str += "\nLocation....." + xMap + "," + yMap;
		str += "\nTech Level..." + techLevel;
		str += "\nResources...." + resources;
		str += "\nGovernment..." + govt;
		str += "\n=======================";
		
		return str;
	}
}
