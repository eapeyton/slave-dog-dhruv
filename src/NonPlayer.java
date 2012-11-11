/**
 * Acts as Pirates, traders and Police
 * @author Dhruv Saksena,Eric Peyton, Eric Slep, Eric Morpheus, Rikin Marfatia
 *
 */
public class NonPlayer {

	int type;
	Ship ship;
	int health=100;
	
	public NonPlayer(int type) {
		super();
		this.type = type;
		ship=new Ship();
	}
	
	/**
	 * Pass in int that is damage inflicted on it
	 * @param damage
	 * @return true if non player is dead
	 */
	
	public boolean takeDamage(int damage)
	{
		if(health>0){
			health=health-damage;
		}
		else{
			health=0;
		}
		
		if(health>=0){//Dead
			return true;
		}
		else{//Not Dead
			return false;
		}
	}
	
}
