
public class StarSystem {

	String name;
	int xMap;
	int yMap;
	int techLevel;
	int resources;
	int govt;
	final int screenWidth=150;
	final int screenHeight=100;
	
	public StarSystem(int resources) {
		super();
		this.resources = resources;
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
}
