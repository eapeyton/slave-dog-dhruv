import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Panel Class for encounters with non Players
 * @author dhruv
 *
 */

public class RandomEvent extends JPanel{

	int nptype;
	JLabel message=new JLabel();
	JButton func1=new JButton();
	JButton attack=new JButton("Attack");
	JButton flee=new JButton("Flee");
	NonPlayer np;
	Boolean fleeState=false;	//True if you were able to flee
	Boolean exist=true;			//Set to false when random event is over and we return to game panel
	Player player;
	
	public RandomEvent(int nonPlayerType,Player player){
		nptype=nonPlayerType;
		this.player=player;
		func1.addActionListener(new FuncListener());
		attack.addActionListener(new FuncListener());
		flee.addActionListener(new FuncListener());
		if(nptype==0)//Pirate
		{
			message.setText("You have been attacked by a Pirate Ship. What do you want to do?");
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
		
		add(message);
		add(func1);
		add(attack);
		add(flee);
	}
	
	/**
	 * Action Listener for all the buttons
	 * @author dhruv
	 *
	 */
	private class FuncListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==flee){
				if(nptype==2){//Fleeing from a Tdaer, always successful
					fleeState=true;
				}
				else{
					if(Math.random()*100>50){//Police or Pirate 50 % chance of Escaping
						fleeState=true;
					}
				}
				
			}
			
			if(e.getSource()==attack){
				if(np.takeDamage((int)Math.random()*10)){
					message.setText("You succeeded");
					exist=false;	//NP is dead get out of Random Event
				}
				else{
					
					if(nptype==2){//Trader Flees on Attack
						message.setText("The Trader Flees");
						exist=false;
					}
					
					if(nptype==1||nptype==0){//Police or Pirate Attack back
						message.setText("You have been attacked back, What do you want to do?");
						player.takeDamage((int)Math.random()*10);
					}
				}
				
			}
			
		}
		
	}
	
	
}
