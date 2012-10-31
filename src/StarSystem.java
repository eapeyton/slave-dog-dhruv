import java.awt.Point;
import java.util.HashSet;

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
	static HashSet<Point> usedLocations = new HashSet<Point>();
	final int screenWidth=150;
	final int screenHeight=100;
	int water,food,drugs,medicine,weapons,robots = 0;
	int[] cargo;
	// more cargo can be added
	
	/**
	 * Creates a new star system with a unique location
	 * @param name The name of the star system
	 */
	public StarSystem(String name) {
		super();
		this.name=name;
		while (location == null || usedLocations.contains(location)) {
			setLocation();
		}
		/**
		 * Initialize tech, resources, government, and empty cargo.
		 */
		usedLocations.add(location);
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
