import java.awt.Point;
import java.util.HashSet;

/**
 * Holds information about a star system. Used by Galactic chart to add star systems 
 * to the universe.
 * @author Dhruv Saksena, Eric Morphis
 *
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
		usedLocations.add(location);
		techLevel=(int) (Math.random()*8);
		resources=(int) ((Math.random()*13)*(Math.floor(Math.random()*2)));
		govt=(int) (Math.random()*18);
		
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
