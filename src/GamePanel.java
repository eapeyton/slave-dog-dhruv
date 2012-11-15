import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSpinner;

/**
 * The main screen of the game. This is where the user will spend much of their time.
 * The GamePanel first appears after a player is created in the configuration screen.
 * @author Eric Peyton, Rikin Marfatia, Eric Morphis
 *
 */
public class GamePanel extends JPanel 
{
	
	Player player;
	StarSystem location;
	JLabel planetLbl,destinationLbl,fuelMoneyLbl;
    JSpinner fuelSel;
	JButton market,go,save,buyFuel;
	GalacticChart chart;
	ArrayList<StarSystem> universe;
	
	/**
	 * Creates a new GamePanel taking in an ActionListener as a parameter.
	 * @param listener an action listener
	 */
	public GamePanel(ActionListener listener, Player player) {
		// Set the layout and the player
		setLayout(new BorderLayout(0,0));
		this.player = player;
		Random rand = new Random();
		
		
		/**
		 * CENTER Section: Contains a new JPanel with the chart and go button
		 */
		destinationLbl = new JLabel("Destination Location:");
		go = new JButton("Go to new planet!");
		go.setEnabled(false);
		go.addActionListener(listener);
		chart = new GalacticChart(destinationLbl, go);
		
		// Generate the universe and set the player's location
		chart.setPlayer(player);
		universe = chart.generateUniverse();
		player.setLocation(universe.get(rand.nextInt(universe.size())));
		
		
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBorder(BorderFactory.createTitledBorder("Galactic Chart"));
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(chart, BorderLayout.CENTER);
		centerPanel.add(go,BorderLayout.SOUTH);
		add(centerPanel,BorderLayout.CENTER);
		
		/**
		 * SOUTH Section: Various buttons
		 */
		JPanel southPanel = new JPanel();

		save = new JButton("Save Game");
		buyFuel = new JButton("Buy Fuel");
		market = new JButton("Planet Marketplace");
		
		market.addActionListener(listener);
		save.addActionListener(listener);
		buyFuel.addActionListener(listener);
		
		southPanel.add(save);
		southPanel.add(buyFuel);
		southPanel.add(market);
		add(southPanel,BorderLayout.SOUTH);

		/**
		 * North Section: Information about the player, ship and planet
		 */
		JPanel northPanel = new JPanel();
		northPanel.setBorder(BorderFactory.createTitledBorder("Info"));
		northPanel.setLayout(new BoxLayout(northPanel,BoxLayout.Y_AXIS));
		
		planetLbl = new JLabel("Current Location: " + player.getLocation().getName() + "....Tech Level: " + player.getLocation().getTechLevel());
		fuelMoneyLbl = new JLabel("Fuel Remaining: " + player.getFuel() + "....Money Remaining: " + player.getMoney());
		
		northPanel.add(destinationLbl);
		northPanel.add(planetLbl);
		northPanel.add(fuelMoneyLbl);
		add(northPanel,BorderLayout.NORTH);
		
        //fuelSel=new JSpinner();

	}
	
	/**
	 * Creates a new GamePanel from a save file.
	 * @param listener an action listener
	 */
	public GamePanel(ActionListener listener, Player player, GalacticChart chart) {
		/**
		 * Set the layout to border layout.
		 */
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		destinationLbl = new JLabel("Destination:");
		save = new JButton("Save");
		go = chart.getGoBtn();
		go.setEnabled(false);
		buyFuel=new JButton("Buy Fuel");
		go.setEnabled(false);
                fuelSel=new JSpinner();
		
		
		this.chart = chart;
		universe = chart.getUniverse();
		this.chart.setPlayer(player);
		
		this.player = player;
		
		planetLbl = new JLabel("Current Location: " + player.getLocation().getName()
						+ "\n    Tech Level: " + player.getLocation().getTechLevel());
		market = new JButton("Marketplace");
		market.addActionListener(listener);
		go.addActionListener(listener);
		save.addActionListener(listener);
		buyFuel.addActionListener(listener);
		
		add(fuelSel);
                add(buyFuel);
		add(market);
		add(chart);
		add(planetLbl);
		add(destinationLbl);
		add(go);
		add(save);
		add(buyFuel);
	}
	
	/**
	 * updates fields when location changes
	 */
	public void update() {
		StarSystem oldLocation = getPlayer().getLocation();
		StarSystem newLocation = getChart().getSelected();
		getPlayer().setLocation(newLocation);
		getPlayer().setFuel(-oldLocation.distanceToStarSystem(newLocation));
		getChart().setSelected(null);
		getChart().repaint();
		planetLbl.setText("Current Location: " + player.getLocation().getName()
				+ "....Tech Level: " + player.getLocation().getTechLevel());
		
	}
	
	public void updateInfoLabels() {
		fuelMoneyLbl.setText("Fuel Remaining: " + player.getFuel() + "....Money Remaining: " + player.getMoney());
	}
	
	/**
	 * Gets the current location as given from the player
	 * @return the current location
	 */
	public StarSystem getCurrentLocation()
	{
		return player.getLocation();
	}
	
	/**
	 * Gets the "market" button, essentially seeing if it was pressed.
	 * @return
	 */
	public JButton getMarketButton()
	{
		return market;
	}
	
	/**
	 * @return The go button
	 */
	public JButton getGoButton()
	{
		return go;
	}
	
	public JButton getSaveButton()
	{
		return save;
	}
	
	/**
	 * @return The player
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * @return The chart
	 */
	public GalacticChart getChart() {
		return chart;
	}

	/**
	 * Getter for buyFuel JButton
	 * @return buyFuel JButton
	 */
	public Object getBuyFuelButton() {
		
		return buyFuel;
	}
        
        /**
        * Set the go button
        * @param the new go button
        */
        public void setGoBtn(JButton newGoBtn) {
                go = newGoBtn;
        }
        
        /**
        * Get the go button
        * @return the go button
        */
        public JButton getGoBtn() {
                return go;
        }
}
