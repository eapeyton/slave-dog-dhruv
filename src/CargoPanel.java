/* Cargo panel*/
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

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
public class CargoPanel extends JPanel implements ActionListener{
	/**
	 * Field GRID_LAYOUT_WIDTH.
	 * (value is 7)
	 */
	private static final int GRID_LAYOUT_WIDTH = 7;
	/**
	 * Field GRID_LAYOUT_HEIGHT.
	 * (value is 6)
	 */
	private static final int GRID_LAYOUT_HEIGHT = 6;
	/**
	 * Field NUM_SUPPLY_TYPE.
	 * (value is 6)
	 */
	private static final int NUM_SUPPLY_TYPE = 6;
	/**
	 * Field NUM_ARRAY_SUPPLY.
	 * (value is NUM_SUPPLY_TYPE + 1)
	 */
	private static final int NUM_ARRAY_SUPPLY = NUM_SUPPLY_TYPE + 1;
	/**
	 * Field ROBOTS.
	 * (value is 6)
	 */
	/**
	 * Field WEAPONS.
	 * (value is 5)
	 */
	/**
	 * Field MEDS.
	 * (value is 4)
	 */
	/**
	 * Field DRUGS.
	 * (value is 3)
	 */
	/**
	 * Field FOOD.
	 * (value is 2)
	 */
	/**
	 * Field WATER.
	 * (value is 1)
	 */
	private static final int WATER=1, FOOD=2, DRUGS=3, MEDS=4, WEAPONS=5, ROBOTS=6;
	
	/**
	 * Field ROBOTS_COST.
	 * (value is 500)
	 */
	/**
	 * Field WEAPONS_COST.
	 * (value is 200)
	 */
	/**
	 * Field MEDS_COST.
	 * (value is 100)
	 */
	/**
	 * Field DRUGS_COST.
	 * (value is 70)
	 */
	/**
	 * Field FOOD_COST.
	 * (value is 50)
	 */
	/**
	 * Field WATER_COST.
	 * (value is 10)
	 */
	private static final int WATER_COST=10, FOOD_COST=50, DRUGS_COST=70, MEDS_COST=100, WEAPONS_COST=200, ROBOTS_COST=500;

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
	private final JLabel plyrWater, plyrFood, plyrDrugs, plyrMeds, plyrWeps, plyrRobots; 

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
	private final JLabel plWater, plFood, plDrugs;
	
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
	private final JLabel plMeds, plWeps, plRobots, cMoney, cBays;
	
	/**
	 * Field spinners.
	 */
	private final JSpinner[] spinners;

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
	private final int waterCost, foodCost, drugCost, medCost, weaponCost, robotCost;

	/**
	 * Field player.
	 */
	private Player player = null;

	/**
	 * Field curr.
	 */
	private final StarSystem curr;

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
		waterCost = WATER_COST;
		foodCost = FOOD_COST;
		drugCost = DRUGS_COST;
		medCost = MEDS_COST;
		weaponCost = WEAPONS_COST;
		robotCost = ROBOTS_COST;

		/**
		 * NORTH Section:
		 * 	a new JPanel that contains:
		 * 		money label, money count, bays label, bays count
		 */
		
		//create components
		final JLabel lblMoney = new JLabel("Money: ");
		cMoney = new JLabel("" + player.getMoney());
		final JLabel lblBays = new JLabel("Bays: ");
		cBays = new JLabel("" + player.getBays());
		
		//add components to northPanel
		final JPanel northPanel = new JPanel();
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
		final JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(GRID_LAYOUT_WIDTH, GRID_LAYOUT_HEIGHT, 0, 0));
		
		////////////
		// LABELS //
		////////////
		
		//create labels that show various player supply counts
		plyrWater = new JLabel("" + player.getCargo(WATER));
		plyrFood = new JLabel("" + player.getCargo(FOOD));
		plyrDrugs = new JLabel("" + player.getCargo(DRUGS));
		plyrMeds = new JLabel("" + player.getCargo(MEDS));
		plyrWeps = new JLabel("" + player.getCargo(WEAPONS));
		plyrRobots = new JLabel("" + player.getCargo(ROBOTS));
		
		//create labels for planet supply counts
		plWater = new JLabel("" + curr.getCargo(WATER));
		plFood = new JLabel("" + curr.getCargo(FOOD));
		plDrugs = new JLabel("" + curr.getCargo(DRUGS));
		plMeds = new JLabel("" + curr.getCargo(MEDS));
		plWeps = new JLabel("" + curr.getCargo(WEAPONS));
		plRobots = new JLabel("" + curr.getCargo(ROBOTS));
		
		//////////////
		// SPINNERS //
		//////////////
		
		//create array of spinners and add new spinners to it, with minimum value of 0 and no max
		spinners = new JSpinner[NUM_ARRAY_SUPPLY];
		for(int i=1; i <= NUM_SUPPLY_TYPE; i++) {
			spinners[i] = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
			//spinners[i].addChangeListener(this);
		}
		
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
		gridPanel.add(new JLabel("" + (waterCost >> 1)));
		gridPanel.add(plWater);
		gridPanel.add(new JLabel("" + waterCost));
		gridPanel.add(spinners[WATER]);

		//food
		gridPanel.add(new JLabel("Food: "));
		gridPanel.add(plyrFood);
		gridPanel.add(new JLabel("" + (foodCost >> 1)));
		gridPanel.add(plFood);
		gridPanel.add(new JLabel("" + foodCost));
		gridPanel.add(spinners[FOOD]);

		//drugs
		gridPanel.add(new JLabel("Drugs: "));
		gridPanel.add(plyrDrugs);
		gridPanel.add(new JLabel("" + (drugCost >> 1)));
		gridPanel.add(plDrugs);
		gridPanel.add(new JLabel("" + drugCost));
		gridPanel.add(spinners[DRUGS]);
		
		//medicine
		gridPanel.add(new JLabel("Medicine: "));
		gridPanel.add(plyrMeds);
		gridPanel.add(new JLabel("" + (medCost >> 1)));
		gridPanel.add(plMeds);
		gridPanel.add(new JLabel("" + medCost));
		gridPanel.add(spinners[MEDS]);
		
		//weapons
		gridPanel.add(new JLabel("Weapons: "));
		gridPanel.add(plyrWeps);
		gridPanel.add(new JLabel("" + (weaponCost >> 1)));
		gridPanel.add(plWeps);
		gridPanel.add(new JLabel("" + weaponCost));
		gridPanel.add(spinners[WEAPONS]);
		
		//robots
		gridPanel.add(new JLabel("Robots: "));
		gridPanel.add(plyrRobots);
		gridPanel.add(new JLabel("" + (robotCost >> 1)));
		gridPanel.add(plRobots);
		gridPanel.add(new JLabel("" + robotCost));
		gridPanel.add(spinners[ROBOTS]);
		
		//add the gridPanel to the main panel
		add(gridPanel, BorderLayout.CENTER);
		
		/**
		 * SOUTH Section:
		 * 	contains a JPanel with the buy, sell, and back buttons
		 */
		
		//create panel
		final JPanel southPanel = new JPanel();
		
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
	
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent) */
	@Override
	/**
	 * Handles the events. Performs the transactions based on which 
	 * button is pressed and the values
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
				quant = (Integer) spinners[WATER].getValue();
				if(quant > curr.getCargo(WATER)){
					JOptionPane.showMessageDialog(null, "Not enough water!");
				}
				else{
					totalCost = waterCost * quant;
					if(totalCost > player.getMoney()){
						JOptionPane.showMessageDialog(null, "Not enough money!");
					}
					else{
						player.setCargo(WATER, quant);
						player.setMoney(player.getMoney() - totalCost);
						curr.setCargo(WATER, -quant);
						spinners[WATER].setValue(0);
					}
				}
				//check food spinner
				quant = (Integer) spinners[FOOD].getValue();
				if(quant > curr.getCargo(FOOD)){
					JOptionPane.showMessageDialog(null, "Not enough food!");
				}
				else{
					totalCost = foodCost * quant;
					if(totalCost > player.getMoney()){
						JOptionPane.showMessageDialog(null, "Not enough money!");
					}
					else{
						player.setCargo(FOOD, quant);
						player.setMoney(player.getMoney() - totalCost);
						curr.setCargo(FOOD, -quant);
						spinners[FOOD].setValue(0);
					}
				}
				//check drug spinner
				quant = (Integer) spinners[DRUGS].getValue();
				if(quant > curr.getCargo(DRUGS)){
					JOptionPane.showMessageDialog(null, "Not enough of drugs!");
				}
				else{
					totalCost = drugCost * quant;
					if(totalCost > player.getMoney()){
						JOptionPane.showMessageDialog(null, "Not enough money!");
					}
					else{
						player.setCargo(DRUGS, quant);
						player.setMoney(player.getMoney() - totalCost);
						curr.setCargo(DRUGS, -quant);
						spinners[DRUGS].setValue(0);
					}
				}	
				//check medicine spinner
				quant = (Integer) spinners[MEDS].getValue();
				if(quant > curr.getCargo(MEDS)){
					JOptionPane.showMessageDialog(null, "Not enough medicine!");
				}
				else{
					totalCost = medCost * quant;
					if(totalCost > player.getMoney()){
						JOptionPane.showMessageDialog(null, "Not enough money!");
					}
					else{
						player.setCargo(MEDS, quant);
						player.setMoney(player.getMoney() - totalCost);
						curr.setCargo(MEDS, -quant);
						spinners[MEDS].setValue(0);
					}
				}
				
				//check weapon spinner
				quant = (Integer) spinners[WEAPONS].getValue();
				if(quant > curr.getCargo(WEAPONS)){
					JOptionPane.showMessageDialog(null, "Not enough weapons!");
				}
				else{
					totalCost = weaponCost * quant;
					if(totalCost > player.getMoney()){
						JOptionPane.showMessageDialog(null, "Not enough money!");
					}
					else{
						player.setCargo(WEAPONS, quant);
						player.setMoney(player.getMoney() - totalCost);
						curr.setCargo(WEAPONS, -quant);
						spinners[WEAPONS].setValue(0);
					}
				}
				//check robots spinner
				quant = (Integer) spinners[ROBOTS].getValue();
				if(quant > curr.getCargo(ROBOTS)){
					JOptionPane.showMessageDialog(null, "Not enough robots!");
				}
				else{
					totalCost = robotCost * quant;
					if(totalCost > player.getMoney()){
						JOptionPane.showMessageDialog(null, "Not enough money!");
					}
					else{
						player.setCargo(ROBOTS, quant);
						player.setMoney(player.getMoney() - totalCost);
						curr.setCargo(ROBOTS, -quant);
						spinners[ROBOTS].setValue(0);
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
			quant = (Integer) spinners[WATER].getValue();
			if(quant > player.getCargo(WATER)){
				JOptionPane.showMessageDialog(null, "Not enough water!");
			}
			else{
				totalCost = (waterCost >> 1) * quant;
				player.setCargo(WATER, -quant);
				player.setMoney(player.getMoney() + totalCost);
				curr.setCargo(WATER, quant);
				spinners[WATER].setValue(0);
			}
			
			//check food spinner
			quant = (Integer) spinners[FOOD].getValue();
			if(quant > player.getCargo(FOOD)){
				JOptionPane.showMessageDialog(null, "Not enough food!");
			}
			else{
				totalCost = (foodCost >> 1) * quant;
				player.setCargo(FOOD, -quant);
				player.setMoney(player.getMoney() + totalCost);
				curr.setCargo(FOOD, quant);
				spinners[FOOD].setValue(0);
			}
			
			//check drug spinner
			quant = (Integer) spinners[DRUGS].getValue();
			if(quant > player.getCargo(DRUGS)){
				JOptionPane.showMessageDialog(null, "Not enough drugs!");
			}
			else{
				totalCost = (drugCost >> 1) * quant;
				player.setCargo(DRUGS, -quant);
				player.setMoney(player.getMoney() + totalCost);
				curr.setCargo(DRUGS, quant);
				spinners[DRUGS].setValue(0);
			}
			
			//check medicine spinner
			quant = (Integer) spinners[MEDS].getValue();
			if(quant > player.getCargo(MEDS)){
				JOptionPane.showMessageDialog(null, "Not enough medicine!");
			}
			else{
				totalCost = (medCost >> 1) * quant;
				player.setCargo(MEDS, -quant);
				player.setMoney(player.getMoney() + totalCost);
				curr.setCargo(MEDS, quant);
				spinners[MEDS].setValue(0);
			}
			
			//check weapons spinner
			quant = (Integer) spinners[WEAPONS].getValue();
			if(quant > player.getCargo(WEAPONS)){
				JOptionPane.showMessageDialog(null, "Not enough weapons!");
			}
			else{
				totalCost = (weaponCost >> 1) * quant;
				player.setCargo(WEAPONS, -quant);
				player.setMoney(player.getMoney() + totalCost);
				curr.setCargo(WEAPONS, quant);
				spinners[WEAPONS].setValue(0);
			}
			
			//check robots spinner
			quant = (Integer) spinners[ROBOTS].getValue();
			if(quant > player.getCargo(ROBOTS)){
				JOptionPane.showMessageDialog(null, "Not enough robots!");
			}
			else{
				totalCost = (robotCost >> 1) * quant;
				player.setCargo(ROBOTS, -quant);
				player.setMoney(player.getMoney() + totalCost);
				curr.setCargo(ROBOTS, quant);
				spinners[ROBOTS].setValue(0);
			}
			
			updateValues();
		}
	}
	
	/**
	 * Updates the values held by the player 
	 * and the current StarSystem after transactions
	 */
	public void updateValues() {
		plyrWater.setText("" + player.getCargo(WATER));
		
		plyrFood.setText("" + player.getCargo(FOOD));
		
		plyrDrugs.setText("" + player.getCargo(DRUGS));
		
		plyrMeds.setText("" + player.getCargo(MEDS));
		
		plyrWeps.setText("" + player.getCargo(WEAPONS));
		
		plyrRobots.setText("" + player.getCargo(ROBOTS));
		
		plWater.setText("" + curr.getCargo(WATER));
		
		plFood.setText("" + curr.getCargo(FOOD));
		
		plDrugs.setText("" + curr.getCargo(DRUGS));
		
		plMeds.setText("" + curr.getCargo(MEDS));
		
		plWeps.setText("" + curr.getCargo(WEAPONS));
		
		plRobots.setText("" + curr.getCargo(ROBOTS));
		
		cMoney.setText("" + player.getMoney());
		
		cBays.setText("" + player.getBays());
	}

	/**
	 * Method getBackBtn.
	
	 * @return JButton */
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

	/**
	
	 * @return the buyBtn */
	public JButton getBuyBtn() {
		return buyBtn;
	}

	/**
	 * @param buyBtn the buyBtn to set
	 */
	public void setBuyBtn(JButton buyBtn) {
		this.buyBtn = buyBtn;
	}

	/**
	
	 * @return the sellBtn */
	public JButton getSellBtn() {
		return sellBtn;
	}

	/**
	 * @param sellBtn the sellBtn to set
	 */
	public void setSellBtn(JButton sellBtn) {
		this.sellBtn = sellBtn;
	}
}