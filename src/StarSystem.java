
public class StarSystem {

	String name;
	int xMap;
	int yMap;
	int techLevel;
	int resources;
	int govt;
	final int screenWidth=150;
	final int screenHeight=100;
	
	public StarSystem(String name) {
		super();
		this.name=name;
		xMap=(int) (Math.random()*screenWidth);
		yMap=(int) (Math.random()*screenHeight);
		techLevel=(int) (Math.random()*8);
		resources=(int) (Math.random()*13);
		govt=(int) (Math.random()*18);
		
	}
	
	public void relocate(){//Incase 2 StarSystems overlap
		xMap=(int) (Math.random()*screenWidth);
		yMap=(int) (Math.random()*screenHeight);
	}
	
	/**
	 * Rewrite toString method to display name and attributes.
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
