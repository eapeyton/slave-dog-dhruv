import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel Class for encounters with non Players
 * @author dhruv
 *
 * @version $Revision: 1.0 $
 */

public class RandomEvent extends JPanel{

	/**
	 * Field nptype.
	 */
	public int nptype;
	/**
	 * Field message.
	 */
	public JLabel message=new JLabel();
	/**
	 * Field func1.
	 */
	public JButton func1=new JButton();
	/**
	 * Field attack.
	 */
	public JButton attack=new JButton("Attack");
	/**
	 * Field flee.
	 */
	public JButton flee=new JButton("Flee");
	/**
	 * Field np.
	 */
	public NonPlayer np;
	/**
	 * Field fleeState.
	 */
	public Boolean fleeState=false;	//True if you were able to flee
	/**
	 * Field exist.
	 */
	public Boolean exist=true;			//Set to false when random event is over and we return to game panel
	/**
	 * Field player.
	 */
	public Player player;
	
	/**
	 * Constructor for RandomEvent.
	 * @param nonPlayerType int
	 * @param player Player
	 * @param listener ActionListener
	 */
	public RandomEvent(int nonPlayerType, Player player, ActionListener listener){
		setLayout(new BorderLayout(0, 0));
		nptype=nonPlayerType;
		this.player=player;
		func1.addActionListener(new FuncListener());
		func1.addActionListener(listener);
		attack.addActionListener(new FuncListener());
		flee.addActionListener(new FuncListener());
		if(nptype==0)//Pirate
		{
			message.setText("You have been attacked by a Pirate Ship! What do you want to do?");
			func1.setText("Threaten");
			np=new NonPlayer(0);
		}
		
		if(nptype==1)//Police
		{
			message.setText("A Police Ship wants to inspect your ship. What do you want to do?");
			func1.setText("Submit for Inspection");
			np=new NonPlayer(1);
			
		}
		
		if(nptype==2)//Trader
		{
			message.setText("A friendly Trader Wishes to Trade. What do you want to do?");
			func1.setText("Trade");
			np=new NonPlayer(2);
		}
		final ImageIcon pirateIcon = new ImageIcon("../img/pirate.jpg", "A Space Pirate!");
		add(new JLabel(pirateIcon), BorderLayout.CENTER);
		message.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(message, BorderLayout.NORTH);
		
		final JPanel buttonSouth = new JPanel();
		buttonSouth.add(func1);
		buttonSouth.add(attack);
		buttonSouth.add(flee);
		add(buttonSouth, BorderLayout.SOUTH);
	}
	
	/**
	 * Get the function 1 button
	
	 * @return the func1 button */
	public JButton getFunc1Button() {
	        return func1;
	}
	
	/**
	 * Action Listener for all the buttons
	 * @author dhruv
	 *
	 */
	private class FuncListener implements ActionListener{

		/**
		 * Method toString.
		 * @return String
		 */
		@Override
		public String toString(){
			return "actionListener";
		}
		/**
		 * Method actionPerformed.
		 * @param e ActionEvent
		
		 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent) */
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if(e.getSource().equals(flee)){
				if(nptype==2){//Fleeing from a Tdaer, always successful
					fleeState=true;
				}
				else{
					if(Math.random()*100>50){//Police or Pirate 50 % chance of Escaping
						fleeState=true;
					}
				}
				
			}
			
			if(e.getSource().equals(attack)){
				if(np.canNpTakeDamage((int) Math.random()*10)){
					message.setText("You succeeded");
					exist=false;	//NP is dead get out of Random Event
				}
				else{
					
					if(nptype==2){//Trader Flees on Attack
						message.setText("The Trader Flees");
						exist=false;
					}
					
					if(nptype==1||nptype==0){//Police or Pirate Attack back
						final int attack = (int) Math.random()*10;
						message.setText("You have been attacked back. What do you want to do?");
						player.takeDamage(attack);
					}
				}
				
			}
			
			/* If threaten button is pressed */
			if(e.getSource().equals(func1)) {
			        if(Math.random() < .5) {
			                message.setText("You scared him off!");
			                exist=false;
			        }
			        else {
			                message.setText("You have been attacked back, What do you want to do?");
				        player.takeDamage((int) Math.random()*10);
			        }
			}
			
			/* Check to see if the player has fleed or the enemy has died */
			if(fleeState || !exist) {
			        if(fleeState) {
			                /* If the flee is successful */
			                message.setText("You successfully fleed!");
			                func1.setText("Continue");
			        }
			        else if(!exist) {
			                message.setText("The other ship has been destroyed!");
			                func1.setText("Continue");
			        }
			        attack.setVisible(false);
			        flee.setVisible(false);
			}
			
		}
		
	}
	
	
}
