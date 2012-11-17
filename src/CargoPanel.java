/* Cargo panel*/
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.GridLayout;



/**
 * Handles all of the trading
 * transactions between the Player
 * and the current planet he/she 
 * is residing on.
 * 
 * @author Rikin Marfatia, Eric Peyton
 * @version M7
 *
 */
public class CargoPanel extends JPanel implements ActionListener, ChangeListener{
	/**
	 * Field NUM_SUPPLY_TYPE.
	 * (value is 6)
	 */
	private final static int NUM_SUPPLY_TYPE = 6;

	/**
	 * Field plyrRobots.
	 */
	/**
	 * Field plyrWeps.
	 */
	/**
	 * Field plyrMeds.
	 */
	/**
	 * Field plyrDrugs.
	 */
	/**
	 * Field plyrFood.
	 */
	/**
	 * Field plyrWater.
	 */
	private JLabel plyrWater, plyrFood, plyrDrugs, plyrMeds, plyrWeps, plyrRobots; 

	/**
	 * Field cBays.
	 */
	/**
	 * Field cMoney.
	 */
	/**
	 * Field plRobots.
	 */
	/**
	 * Field plWeps.
	 */
	/**
	 * Field plMeds.
	 */
	/**
	 * Field plDrugs.
	 */
	/**
	 * Field plFood.
	 */
	/**
	 * Field plWater.
	 */
	private JLabel plWater, plFood, plDrugs, plMeds, plWeps, plRobots, cMoney, cBays;

	/**
	 * Field spinners.
	 */
	private JSpinner[] spinners;

	/**
	 * Field backBtn.
	 */
	/**
	 * Field sellBtn.
	 */
	/**
	 * Field buyBtn.
	 */
	private JButton buyBtn, sellBtn, backBtn;

	/**
	 * Field robotCost.
	 */
	/**
	 * Field weaponCost.
	 */
	/**
	 * Field medCost.
	 */
	/**
	 * Field drugCost.
	 */
	/**
	 * Field foodCost.
	 */
	/**
	 * Field waterCost.
	 */
	private int waterCost, foodCost, drugCost, medCost, weaponCost, robotCost;

	/**
	 * Field player.
	 */
	private Player player;

	/**
	 * Field curr.
	 */
	private StarSystem curr;

	/**
	 * Create the panel, using WindowBuilder. Sets the default values.
	 * @param player Player
	 * @param listener ActionListener
	 */
	public CargoPanel(Player player, ActionListener listener) {
		
		this.player = player;
		curr = player.getLocation();
		setLayout(new BorderLayout(0, 0));
		
		/**
		 * Initialize supply costs
		 */
		waterCost = 30;
		foodCost = 50;
		drugCost = 70;
		medCost = 100;
		weaponCost = 200;
		robotCost = 500;

		/**
		 * NORTH Section:
		 * 	a new JPanel that contains:
		 * 		money label, money count, bays label, bays count
		 */
		
		//create components
		JLabel lblMoney = new JLabel("Money: ");
		cMoney = new JLabel("" + player.getMoney());
		JLabel lblBays = new JLabel("Bays: ");
		cBays = new JLabel("" + player.getBays());
		
		//add components to northPanel
		JPanel northPanel = new JPanel();
		northPanel.add(lblMoney);
		northPanel.add(cMoney);
		northPanel.add(lblBays);
		northPanel.add(cBays);
		
		//add north panel to main panel
		add(northPanel, BorderLayout.NORTH);
		
		/**
		 * CENTER Section:
		 * 	contains gridPanel, a new JPanel with a GridLayout which contains 
		 * 	the supply labels of the player and planet
		 */
		
		//create panel
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(7, 6, 0, 0));
		
		////////////
		// LABELS //
		////////////
		
		//create labels that show various player supply counts
		plyrWater = new JLabel("" + player.getCargo(1));
		plyrFood = new JLabel("" + player.getCargo(2));
		plyrDrugs = new JLabel("" + player.getCargo(3));
		plyrMeds = new JLabel("" + player.getCargo(4));
		plyrWeps = new JLabel("" + player.getCargo(5));
		plyrRobots = new JLabel("" + player.getCargo(6));
		
		//create labels for planet supply counts
		plWater = new JLabel("" + curr.getCargo(1));
		plFood = new JLabel("" + curr.getCargo(2));
		plDrugs = new JLabel("" + curr.getCargo(3));
		plMeds = new JLabel("" + curr.getCargo(4));
		plWeps = new JLabel("" + curr.getCargo(5));
		plRobots = new JLabel("" + curr.getCargo(6));
		
		//////////////
		// SPINNERS //
		//////////////
		
		//create array of spinners and add new spinners to it, with minimum value of 0 and no max
		spinners = new JSpinner[7];
		for(int i=1; i <= NUM_SUPPLY_TYPE; i++) {
			spinners[i] = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
			spinners[i].addChangeListener(this);
		}
		/**
		waterSpin = new JSpinner();
		foodSpin = new JSpinner();
		drugsSpin = new JSpinner();
		medSpin = new JSpinner();
		weapSpin = new JSpinner();
		robotSpin = new JSpinner();
		*/
		
		///////////
		// ROWS //
		//////////
		
		//column labels
		gridPanel.add(new JLabel("Supply"));
		gridPanel.add(new JLabel("Player"));
		gridPanel.add(new JLabel("Price"));
		gridPanel.add(new JLabel("Planet"));
		gridPanel.add(new JLabel("Price"));
		gridPanel.add(new JLabel("Amount"));
		
		//water
		gridPanel.add(new JLabel("Water: "));
		gridPanel.add(plyrWater);
		gridPanel.add(new JLabel(""+waterCost/2));
		gridPanel.add(plWater);
		gridPanel.add(new JLabel(""+waterCost));
		gridPanel.add(spinners[1]);

		//food
		gridPanel.add(new JLabel("Food: "));
		gridPanel.add(plyrFood);
		gridPanel.add(new JLabel(""+foodCost/2));
		gridPanel.add(plFood);
		gridPanel.add(new JLabel(""+foodCost));
		gridPanel.add(spinners[2]);

		//drugs
		gridPanel.add(new JLabel("Drugs: "));
		gridPanel.add(plyrDrugs);
		gridPanel.add(new JLabel(""+drugCost/2));
		gridPanel.add(plDrugs);
		gridPanel.add(new JLabel(""+drugCost));
		gridPanel.add(spinners[3]);
		
		//medicine
		gridPanel.add(new JLabel("Medicine: "));
		gridPanel.add(plyrMeds);
		gridPanel.add(new JLabel(""+medCost/2));
		gridPanel.add(plMeds);
		gridPanel.add(new JLabel(""+medCost));
		gridPanel.add(spinners[4]);
		
		//weapons
		gridPanel.add(new JLabel("Weapons: "));
		gridPanel.add(plyrWeps);
		gridPanel.add(new JLabel(""+weaponCost/2));
		gridPanel.add(plWeps);
		gridPanel.add(new JLabel(""+weaponCost));
		gridPanel.add(spinners[5]);
		
		//robots
		gridPanel.add(new JLabel("Robots: "));
		gridPanel.add(plyrRobots);
		gridPanel.add(new JLabel(""+robotCost/2));
		gridPanel.add(plRobots);
		gridPanel.add(new JLabel(""+robotCost));
		gridPanel.add(spinners[6]);
		
		//add the gridPanel to the main panel
		add(gridPanel, BorderLayout.CENTER);
		
		/**
		 * SOUTH Section:
		 * 	contains a JPanel with the buy, sell, and back buttons
		 */
		
		//create panel
		JPanel southPanel = new JPanel();
		
		//create and add buy button
		buyBtn = new JButton("Buy");
		buyBtn.addActionListener(this);
		southPanel.add(buyBtn);
		
		//create and add sell button
		sellBtn = new JButton("Sell");
		sellBtn.addActionListener(this);
		southPanel.add(sellBtn);
		
		//create and add back button
		backBtn = new JButton("Back");
		backBtn.addActionListener(listener);
		southPanel.add(backBtn);
		
		//add southPanel to main panel
		add(southPanel, BorderLayout.SOUTH);
	}

	/**
	 * Method actionPerformed.
	 * @param e ActionEvent
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	@Override
	/**
	 * Handles the events. Performs the transactions based on which button is pressed and the values
	 * that are currently set.
	 */
	public void actionPerformed(ActionEvent e) {
		int quant;
		int bays;
		int totalQuantity;
		int totalCost;
		
		////////////////
		// BUY BUTTON //
		////////////////
		
		if(e.getSource().equals(buyBtn)){
			//retrieve amount from all the spinners
			totalQuantity = 0;
			for(int i = 1; i <= NUM_SUPPLY_TYPE; i++) {
				totalQuantity += (Integer) spinners[i].getValue();
			}
			
			//retrieve bays left
			bays = player.getBays();

			//check if bays are OK, if they are OK then check spinner
			if(bays == 0){
				JOptionPane.showMessageDialog(null, "You are out of bays!");
			}
			else if(totalQuantity > bays){
				JOptionPane.showMessageDialog(null, "Not enough bays!");
			}
			else{
				//check water spinner
				quant = (Integer) spinners[1].getValue();
				if(quant > curr.getCargo(1)){
					JOptionPane.showMessageDialog(null, "Not enough water!");
				}
				else{
					totalCost = waterCost * quant;
					if(totalCost > player.getMoney()){
						JOptionPane.showMessageDialog(null, "Not enough money!");
					}
					else{
						player.setCargo(1, quant);
						player.setMoney(player.getMoney()-totalCost);
						curr.setCargo(1, -quant);
						spinners[1].setValue(0);
					}
				}

				//check food spinner
				quant = (Integer) spinners[2].getValue();
				if(quant > curr.getCargo(2)){
					JOptionPane.showMessageDialog(null, "Not enough food!");
				}
				else{
					totalCost = foodCost * quant;
					if(totalCost > player.getMoney()){
						JOptionPane.showMessageDialog(null, "Not enough money!");
					}
					else{
						player.setCargo(2, quant);
						player.setMoney(player.getMoney()-totalCost);
						curr.setCargo(2, -quant);
						spinners[2].setValue(0);
					}
				}
					
				//check drug spinner
				quant = (Integer) spinners[3].getValue();
				if(quant > curr.getCargo(3)){
					JOptionPane.showMessageDialog(null, "Not enough of this item!");
				}
				else{
					totalCost = drugCost * quant;
					if(totalCost > player.getMoney()){
						JOptionPane.showMessageDialog(null, "Not enough money!");
					}
					else{
						player.setCargo(3, quant);
						player.setMoney(player.getMoney()-totalCost);
						curr.setCargo(3, -quant);
						spinners[3].setValue(0);
					}
				}	
				
				//check medicine spinner
				quant = (Integer) spinners[4].getValue();
				if(quant > curr.getCargo(4)){
					JOptionPane.showMessageDialog(null, "Not enough drugs!");
				}
				else{
					totalCost = medCost * quant;
					if(totalCost > player.getMoney()){
						JOptionPane.showMessageDialog(null, "Not enough money!");
					}
					else{
						player.setCargo(4, quant);
						player.setMoney(player.getMoney()-totalCost);
						curr.setCargo(4, -quant);
						spinners[4].setValue(0);
					}
				}
				
				//check weapon spinner
				quant = (Integer) spinners[5].getValue();
				if(quant > curr.getCargo(5)){
					JOptionPane.showMessageDialog(null, "Not enough weapons!");
				}
				else{
					totalCost = weaponCost * quant;
					if(totalCost > player.getMoney()){
						JOptionPane.showMessageDialog(null, "Not enough money!");
					}
					else{
						player.setCargo(5, quant);
						player.setMoney(player.getMoney()-totalCost);
						curr.setCargo(5, -quant);
						spinners[5].setValue(0);
					}
				}

				//check robots spinner
				quant = (Integer) spinners[6].getValue();
				if(quant > curr.getCargo(6)){
					JOptionPane.showMessageDialog(null, "Not enough robots!");
				}
				else{
					totalCost = robotCost * quant;
					if(totalCost > player.getMoney()){
						JOptionPane.showMessageDialog(null, "Not enough money!");
					}
					else{
						player.setCargo(6, quant);
						player.setMoney(player.getMoney()-totalCost);
						curr.setCargo(6, -quant);
						spinners[6].setValue(0);
					}	
				}
			}
			updateValues();
		}
		
		/////////////////
		// SELL BUTTON //
		/////////////////
		
		if(e.getSource().equals(sellBtn)){
			//retrieve amount from all the spinners
			totalQuantity = 0;
			for(int i = 1; i <= NUM_SUPPLY_TYPE; i++) {
				totalQuantity += (Integer) spinners[i].getValue();
			}
			
			//retrieve bays left
			bays = player.getBays();
		
			//check water spinner
			quant = (Integer) spinners[1].getValue();
			if(quant > player.getCargo(1)){
				JOptionPane.showMessageDialog(null, "Not enough water!");
			}
			else{
				totalCost = (waterCost / 2) * quant;
				player.setCargo(1, -quant);
				player.setMoney(player.getMoney()+totalCost);
				curr.setCargo(1, quant);
				spinners[1].setValue(0);
			}
			
			//check food spinner
			quant = (Integer) spinners[2].getValue();
			if(quant > player.getCargo(2)){
				JOptionPane.showMessageDialog(null, "Not enough food!");
			}
			else{
				totalCost = (foodCost / 2) * quant;
				player.setCargo(2, -quant);
				player.setMoney(player.getMoney()+totalCost);
				curr.setCargo(2, quant);
				spinners[2].setValue(0);
			}
			
			//check drug spinner
			quant = (Integer) spinners[3].getValue();
			if(quant > player.getCargo(3)){
				JOptionPane.showMessageDialog(null, "Not enough drugs!");
			}
			else{
				totalCost = (drugCost / 2) * quant;
				player.setCargo(3, -quant);
				player.setMoney(player.getMoney()+totalCost);
				curr.setCargo(3, quant);
				spinners[3].setValue(0);
			}
			
			//check medicine spinner
			quant = (Integer) spinners[4].getValue();
			if(quant > player.getCargo(4)){
				JOptionPane.showMessageDialog(null, "Not enough medicine!");
			}
			else{
				totalCost = (medCost / 2) * quant;
				player.setCargo(4, -quant);
				player.setMoney(player.getMoney()+totalCost);
				curr.setCargo(4, quant);
				spinners[4].setValue(0);
			}
			
			//check weapons spinner
			quant = (Integer) spinners[5].getValue();
			if(quant > player.getCargo(5)){
				JOptionPane.showMessageDialog(null, "Not enough weapons!");
			}
			else{
				totalCost = (weaponCost / 2) * quant;
				player.setCargo(5, -quant);
				player.setMoney(player.getMoney()+totalCost);
				curr.setCargo(5, quant);
				spinners[5].setValue(0);
			}
			
			//check robots spinner
			quant = (Integer) spinners[6].getValue();
			if(quant > player.getCargo(6)){
				JOptionPane.showMessageDialog(null, "Not enough robots!");
			}
			else{
				totalCost = (robotCost / 2) * quant;
				player.setCargo(6, -quant);
				player.setMoney(player.getMoney()+totalCost);
				curr.setCargo(6, quant);
				spinners[6].setValue(0);
			}
			
			updateValues();
		}
	}
	
	/**
	 * Triggers when a spinner is changed.
	 * param e Event for when the state of a spinner is change
	 * @param e ChangeEvent
	 * @see javax.swing.event.ChangeListener#stateChanged(ChangeEvent)
	 */
	public void stateChanged(ChangeEvent e) {
		
	}
	
	/**
	 * Updates the values held by the player and the current StarSystem after transactions.
	 * 
	 */
	public void updateValues()
	{
		plyrWater.setText("" + player.getCargo(1));
		
		plyrFood.setText("" + player.getCargo(2));
		
		plyrDrugs.setText("" + player.getCargo(3));
		
		plyrMeds.setText("" + player.getCargo(4));
		
		plyrWeps.setText("" + player.getCargo(5));
		
		plyrRobots.setText("" + player.getCargo(6));
		
		plWater.setText("" + curr.getCargo(1));
		
		plFood.setText("" + curr.getCargo(2));
		
		plDrugs.setText("" + curr.getCargo(3));
		
		plMeds.setText("" + curr.getCargo(4));
		
		plWeps.setText("" + curr.getCargo(5));
		
		plRobots.setText("" + curr.getCargo(6));
		
		cMoney.setText("" + player.getMoney());
		
		cBays.setText("" + player.getBays());
	}

	/**
	 * Method getBackBtn.
	 * @return JButton
	 */
	public JButton getBackBtn() {
		return backBtn;
	}

	/**
	 * Method setBackBtn.
	 * @param backBtn JButton
	 */
	public void setBackBtn(JButton backBtn) {
		this.backBtn = backBtn;
	}
}