/**
 * Acts as Pirates, traders and Police
 * @author Dhruv Saksena,Eric Peyton, Eric Slep, Eric Morpheus, Rikin Marfatia
 *
 * @version $Revision: 1.0 $
 */
public class NonPlayer {

	/**
	 * Field type.
	 */
	public int type;
	/**
	 * Field ship.
	 */
	public Ship ship;
	/**
	 * Field health.
	 */
	public int health=100;
	
	/**
	 * Constructor for NonPlayer.
	 * @param type int
	 */
	public NonPlayer(int type) {
		this.type = type;
		ship=new Ship();
	}
	
	/**
	 * Pass in int that is damage inflicted on it
	 * @param damage
	
	 * @return true if non player is dead */
	
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
