import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.factories.FormFactory;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;


/**
 * Handles all of the trading transactions between the Player and the current planet he/she is residing on.
 * 
 * @author Rikin Marfatia
 * @version M7
 *
 */
public class CargoPanel extends JPanel implements ActionListener{
	private JTextField itemField;
	private JTextField qField;
	private JLabel pWater;
	private JLabel pFood;
	private JLabel pDrugs;
	private JLabel pMeds;
	private JLabel pWeps;
	private JLabel pRobots;
	private JLabel plWater;
	private JLabel plFood;
	private JLabel plDrugs;
	private JLabel plMeds;
	private JLabel plWeps;
	private JLabel plRobots;
	private JLabel cMoney;
	private JLabel cBays;
	private JButton buyBtn;
	private JButton sellBtn;
	private JButton backBtn;
	private int waCost, fCost, dCost, mCost, weCost, rCost;
	private Player player;
	private StarSystem curr;

	/**
	 * Create the panel, using WindowBuilder. Sets the default values.
	 */
	public CargoPanel(ActionListener listener, Player player) {
		
		this.player = player;
		curr = player.getLocation();
		
		waCost = 30;
		fCost = 50;
		dCost = 70;
		mCost = 100;
		weCost = 200;
		rCost = 500;
		
		
		JLabel lblPlayer = new JLabel("Player:");
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblPlanet = new JLabel("Planet:");
		lblPlanet.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblWater = new JLabel("Water: ");
		lblWater.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblFood = new JLabel("Food: ");
		lblFood.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblDrugs = new JLabel("Drugs: ");
		lblDrugs.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblMedicine = new JLabel("Medicine: ");
		lblMedicine.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblWeapons = new JLabel("Weapons:");
		lblWeapons.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblRobots = new JLabel("Robots: ");
		lblRobots.setHorizontalAlignment(SwingConstants.CENTER);
		
		pWater = new JLabel("" + player.getCargo("water"));
		pWater.setHorizontalAlignment(SwingConstants.CENTER);
		
		pFood = new JLabel("" + player.getCargo("food"));
		pFood.setHorizontalAlignment(SwingConstants.CENTER);
		
		pDrugs = new JLabel("" + player.getCargo("drugs"));
		pDrugs.setHorizontalAlignment(SwingConstants.CENTER);
		
		pMeds = new JLabel("" + player.getCargo("medicine"));
		pMeds.setHorizontalAlignment(SwingConstants.CENTER);
		
		pWeps = new JLabel("" + player.getCargo("weapons"));
		pWeps.setHorizontalAlignment(SwingConstants.CENTER);
		
		pRobots = new JLabel("" + player.getCargo("robots"));
		pRobots.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel sellPrice = new JLabel("Price:");
		sellPrice.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel buyPrice = new JLabel("Price:");
		buyPrice.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel waPriceSell = new JLabel("" + (waCost / 2));
		waPriceSell.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel fPriceSell = new JLabel("" + (fCost / 2));
		fPriceSell.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel dPriceSell = new JLabel("" + (dCost / 2));
		dPriceSell.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel mPriceSell = new JLabel("" + (mCost / 2));
		mPriceSell.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel wePriceSell = new JLabel("" + (weCost / 2));
		wePriceSell.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel rPriceSell = new JLabel("" + (rCost / 2));
		rPriceSell.setHorizontalAlignment(SwingConstants.CENTER);
		
		plWater = new JLabel("" + curr.getCargo("water"));
		plWater.setHorizontalAlignment(SwingConstants.CENTER);
		
		plFood = new JLabel("" + curr.getCargo("food"));
		plFood.setHorizontalAlignment(SwingConstants.CENTER);
		
		plDrugs = new JLabel("" + curr.getCargo("drugs"));
		plDrugs.setHorizontalAlignment(SwingConstants.CENTER);
		
		plMeds = new JLabel("" + curr.getCargo("medicine"));
		plMeds.setHorizontalAlignment(SwingConstants.CENTER);
		
		plWeps = new JLabel("" + curr.getCargo("weapons"));
		plWeps.setHorizontalAlignment(SwingConstants.CENTER);
		
		plRobots = new JLabel("" + curr.getCargo("robots"));
		plRobots.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel waPriceBuy = new JLabel("" + waCost);
		waPriceBuy.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel fPriceBuy = new JLabel("" + fCost);
		fPriceBuy.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel dPriceBuy = new JLabel("" + dCost);
		dPriceBuy.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel mPriceBuy = new JLabel("" + mCost);
		mPriceBuy.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel wePriceBuy = new JLabel("" + weCost);
		wePriceBuy.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel rPriceBuy = new JLabel("" + rCost);
		rPriceBuy.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel itemNumber = new JLabel("Item #:");
		itemNumber.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel waItem = new JLabel("0");
		waItem.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel fItem = new JLabel("1");
		fItem.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel dItem = new JLabel("2");
		dItem.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel mItem = new JLabel("3");
		mItem.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel weItem = new JLabel("4");
		weItem.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel rItem = new JLabel("5");
		rItem.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel itemSelect = new JLabel("Item (0-5)");
		itemSelect.setHorizontalAlignment(SwingConstants.CENTER);
		
		itemField = new JTextField();
		itemField.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity: ");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		
		qField = new JTextField();
		qField.setColumns(10);
		
		buyBtn = new JButton("Buy");
		buyBtn.addActionListener(this);
		
		sellBtn = new JButton("Sell");
		sellBtn.addActionListener(this);
		
		backBtn = new JButton("Back");
		backBtn.addActionListener(listener);
		
		JLabel lblMoney = new JLabel("Money: ");
		lblMoney.setHorizontalAlignment(SwingConstants.CENTER);
		
		cMoney = new JLabel("" + player.getMoney());
		cMoney.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblBays = new JLabel("Bays: ");
		lblBays.setHorizontalAlignment(SwingConstants.CENTER);
		
		cBays = new JLabel("" + player.getBays());
		cBays.setHorizontalAlignment(SwingConstants.CENTER);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblRobots)
										.addComponent(lblWeapons)
										.addComponent(lblMedicine)
										.addComponent(lblDrugs)
										.addComponent(lblFood)
										.addComponent(lblWater))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(pWater)
										.addComponent(pFood)
										.addComponent(pDrugs)
										.addComponent(pMeds)
										.addComponent(pWeps)
										.addComponent(pRobots))
									.addGap(17))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(66)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(cMoney, GroupLayout.DEFAULT_SIZE, 11, Short.MAX_VALUE)
											.addGap(33))
										.addComponent(lblPlayer))
									.addGap(10)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(23)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(waPriceSell, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
										.addComponent(fPriceSell, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
										.addComponent(dPriceSell, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
										.addComponent(mPriceSell, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
										.addComponent(wePriceSell, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
										.addComponent(rPriceSell, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
									.addGap(69)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(plWater, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
										.addComponent(plFood, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(plDrugs, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(plMeds, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(plWeps, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(plRobots, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(38)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(waPriceBuy, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
										.addComponent(fPriceBuy, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
										.addComponent(dPriceBuy, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
										.addComponent(mPriceBuy, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
										.addComponent(wePriceBuy, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
										.addComponent(rPriceBuy, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblBays)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(cBays, GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE)
											.addGap(129))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(sellPrice)
											.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
											.addComponent(lblPlanet)
											.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
											.addComponent(buyPrice)))))
							.addGap(41)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(waItem, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
										.addComponent(fItem, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
										.addComponent(dItem, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
										.addComponent(mItem, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
										.addComponent(weItem, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
										.addComponent(rItem, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE))
									.addGap(46))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(itemNumber)
									.addGap(29))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(itemSelect)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(itemField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(lblQuantity)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(qField, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buyBtn, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sellBtn, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							))
					.addGap(17))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addComponent(lblMoney)
					.addContainerGap(387, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblMoney)
							.addComponent(cMoney))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblBays)
							.addComponent(cBays)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPlayer)
							.addComponent(lblPlanet)
							.addComponent(buyPrice)
							.addComponent(sellPrice))
						.addComponent(itemNumber))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblWater)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFood))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(pWater)
								.addComponent(waPriceSell)
								.addComponent(plWater)
								.addComponent(waPriceBuy)
								.addComponent(waItem))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(pFood)
								.addComponent(fPriceSell)
								.addComponent(plFood)
								.addComponent(fPriceBuy)
								.addComponent(fItem))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDrugs)
						.addComponent(pDrugs)
						.addComponent(dPriceSell)
						.addComponent(plDrugs)
						.addComponent(dPriceBuy)
						.addComponent(dItem))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMedicine)
						.addComponent(mPriceSell)
						.addComponent(pMeds)
						.addComponent(plMeds)
						.addComponent(mPriceBuy)
						.addComponent(mItem))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(pWeps)
						.addComponent(lblWeapons)
						.addComponent(wePriceSell)
						.addComponent(plWeps)
						.addComponent(wePriceBuy)
						.addComponent(weItem))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRobots)
						.addComponent(pRobots)
						.addComponent(rPriceSell)
						.addComponent(plRobots)
						.addComponent(rPriceBuy)
						.addComponent(rItem))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(itemSelect)
						.addComponent(itemField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQuantity)
						.addComponent(qField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(buyBtn)
						.addComponent(sellBtn)
						.addComponent(backBtn))
					.addGap(22))
		);
		setLayout(groupLayout);

	}

	@Override
	/**
	 * Handles the events. Performs the transactions based on which button is pressed and the values
	 * that are currently set.
	 */
	public void actionPerformed(ActionEvent e) 
	{
		int itemNum;
		int quant;
		int bays;
		int totalCost;
		
		if(e.getSource() == backBtn) {
			
		}
		
		if(e.getSource() == buyBtn)
		{
			itemNum = Integer.parseInt(itemField.getText());
			quant = Integer.parseInt(qField.getText());
			bays = player.getBays();
			
			
			if(bays == 0)
			{
				JOptionPane.showMessageDialog(null, "You are out of bays!");
			}
			else if(quant > bays)
			{
				JOptionPane.showMessageDialog(null, "Not enough bays!");
			}
			else if(itemNum == 0)
			{
				if(quant > curr.getCargo("water"))
				{
					JOptionPane.showMessageDialog(null, "Not enough of this item!");
				}
				else
				{	
					totalCost = waCost * quant;
					if(totalCost > player.getMoney())
					{
						JOptionPane.showMessageDialog(null, "Not enough money!");
					}
					else
					{
						player.setCargo("water", quant);
						player.setMoney(player.getMoney()-totalCost);
						curr.setCargo("water", -quant);
					}
				}
			}
			
			else if(itemNum == 1)
			{
				if(quant > curr.getCargo("food"))
				{
					JOptionPane.showMessageDialog(null, "Not enough of this item!");
				}
				else
				{	
					totalCost = fCost * quant;
					if(totalCost > player.getMoney())
					{
						JOptionPane.showMessageDialog(null, "Not enough money!");
					}
					else
					{
						player.setCargo("food", quant);
						player.setMoney(player.getMoney()-totalCost);
						curr.setCargo("food", -quant);
					}
				}
			}
			
			else if(itemNum == 2)
			{
				if(quant > curr.getCargo("drugs"))
				{
					JOptionPane.showMessageDialog(null, "Not enough of this item!");
				}
				else
				{	
					totalCost = dCost * quant;
					if(totalCost > player.getMoney())
					{
						JOptionPane.showMessageDialog(null, "Not enough money!");
					}
					else
					{	
						player.setCargo("drugs", quant);
						player.setMoney(player.getMoney()-totalCost);
						curr.setCargo("drugs", -quant);
					}
				}
			}
			
			else if(itemNum == 3)
			{
				if(quant > curr.getCargo("medicine"))
				{
					JOptionPane.showMessageDialog(null, "Not enough of this item!");
				}
				else
				{	
					totalCost = mCost * quant;
					if(totalCost > player.getMoney())
					{
						JOptionPane.showMessageDialog(null, "Not enough money!");
					}
					else
					{	
						player.setCargo("medicine", quant);
						player.setMoney(player.getMoney()-totalCost);
						curr.setCargo("medicine", -quant);
					}
				}
			}
			
			else if(itemNum == 4)
			{
				if(quant > curr.getCargo("weapons"))
				{
					JOptionPane.showMessageDialog(null, "Not enough of this item!");
				}
				else
				{	
					totalCost = weCost * quant;
					if(totalCost > player.getMoney())
					{
						JOptionPane.showMessageDialog(null, "Not enough money!");
					}
					else
					{	
						player.setCargo("weapons", quant);
						player.setMoney(player.getMoney()-totalCost);
						curr.setCargo("weapons", -quant);
					}
				}
			}
			
			else if(itemNum == 5)
			{
				if(quant > curr.getCargo("robots"))
				{
					JOptionPane.showMessageDialog(null, "Not enough of this item!");
				}
				else
				{	
					totalCost = rCost * quant;
					if(totalCost > player.getMoney())
					{
						JOptionPane.showMessageDialog(null, "Not enough money!");
					}
					else
					{	
						player.setCargo("robots", quant);
						player.setMoney(player.getMoney()-totalCost);
						curr.setCargo("robots", -quant);
					}	
				}
			}
			
			updateValues();
		}
		
		if(e.getSource() == sellBtn)
		{
			itemNum = Integer.parseInt(itemField.getText());
			quant = Integer.parseInt(qField.getText());
			bays = player.getBays();
		
			if(itemNum == 0)
			{
				if(quant > player.getCargo("water"))
				{
					JOptionPane.showMessageDialog(null, "Not enough of this item!");
				}
				else
				{	
					totalCost = (waCost / 2) * quant;
					player.setCargo("water", -quant);
					player.setMoney(player.getMoney()+totalCost);
					curr.setCargo("water", quant);
				}
			}
			
			else if(itemNum == 1)
			{
				if(quant > player.getCargo("food"))
				{
					JOptionPane.showMessageDialog(null, "Not enough of this item!");
				}
				else
				{	
					totalCost = (fCost / 2) * quant;
					player.setCargo("food", -quant);
					player.setMoney(player.getMoney()+totalCost);
					curr.setCargo("food", quant);
				}
			}
			
			else if(itemNum == 2)
			{
				if(quant > player.getCargo("drugs"))
				{
					JOptionPane.showMessageDialog(null, "Not enough of this item!");
				}
				else
				{	
					totalCost = (dCost / 2) * quant;
					player.setCargo("drugs", -quant);
					player.setMoney(player.getMoney()+totalCost);
					curr.setCargo("drugs", quant);
				}
			}
			
			else if(itemNum == 3)
			{
				if(quant > player.getCargo("medicine"))
				{
					JOptionPane.showMessageDialog(null, "Not enough of this item!");
				}
				else
				{	
					totalCost = (mCost / 2) * quant;
					player.setCargo("medicine", -quant);
					player.setMoney(player.getMoney()+totalCost);
					curr.setCargo("medicine", quant);
				}
			}
			
			else if(itemNum == 4)
			{
				if(quant > player.getCargo("weapons"))
				{
					JOptionPane.showMessageDialog(null, "Not enough of this item!");
				}
				else
				{	
					totalCost = (weCost / 2) * quant;
					player.setCargo("weapons", -quant);
					player.setMoney(player.getMoney()+totalCost);
					curr.setCargo("weapons", quant);
				}
			}
			
			else if(itemNum == 5)
			{
				if(quant > player.getCargo("robots"))
				{
					JOptionPane.showMessageDialog(null, "Not enough of this item!");
				}
				else
				{	
					totalCost = (rCost / 2) * quant;
					player.setCargo("robots", -quant);
					player.setMoney(player.getMoney()+totalCost);
					curr.setCargo("robots", quant);
				}
			}
			
			updateValues();
		}
	}
	
	/**
	 * Updates the values held by the player and the current StarSystem after transactions.
	 * 
	 */
	public void updateValues()
	{

		pWater.setText("" + player.getCargo("water"));
		
		pFood.setText("" + player.getCargo("food"));
		
		pDrugs.setText("" + player.getCargo("drugs"));
		
		pMeds.setText("" + player.getCargo("medicine"));
		
		pWeps.setText("" + player.getCargo("weapons"));
		
		pRobots.setText("" + player.getCargo("robots"));
		
		plWater.setText("" + curr.getCargo("water"));
		
		plFood.setText("" + curr.getCargo("food"));
		
		plDrugs.setText("" + curr.getCargo("drugs"));
		
		plMeds.setText("" + curr.getCargo("medicine"));
		
		plWeps.setText("" + curr.getCargo("weapons"));
		
		plRobots.setText("" + curr.getCargo("robots"));
		
		cMoney.setText("" + player.getMoney());
		
		cBays.setText("" + player.getBays());
	}
	
	public JButton getBackButton() {
		return backBtn;
	}
}
