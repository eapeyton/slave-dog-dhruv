import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * The main screen of the game. This is where the user will spend much of their time.
 * The GamePanel first appears after a player is created in the configuration screen.
 * @author Eric Peyton, Rikin Marfatia
 *
 */
public class GamePanel extends JPanel 
{
	
	Player player;
	StarSystem location;
	JLabel planet;
	JButton market;
	
	/**
	 * Creates a new GamePanel taking in an ActionListener as a parameter.
	 * @param listener an action listener
	 */
	public GamePanel(ActionListener listener, Player player) {
		/**
		 * Set the layout to border layout.
		 */
		setLayout(new BorderLayout(0,0));
		
		/**
		 * TEST:
		 * Generate and print out the universe for demoing purposes
		 */
		GalacticChart chart = new GalacticChart();
		ArrayList<StarSystem> universe = chart.generateUniverse();
		System.out.println(universe);
		
		this.player = player;
		Random rand = new Random();
		player.setLocation(universe.get(rand.nextInt(universe.size())));
		
		planet = new JLabel("Current Location: " + player.getLocation().getName()
						+ "\n    Tech Level: " + player.getLocation().getTechLevel());
		market = new JButton("Marketplace");
		market.addActionListener(listener);
		
		/**
		 * TEST:
		 * Add a label to the CENTER section to see if the panel is working...
		 */
		add(new JLabel("Game Screen"),BorderLayout.CENTER);
		add(planet, BorderLayout.SOUTH);
		add(market, BorderLayout.NORTH);
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
	
	public void setMarketButton(JButton market)
	{
		this.market = market;
	}
	
	/**
	 *  Updates the current location on the Game Screen.
	 */
	public void update()
	{
		planet.setText("Current Location: " + player.getLocation().getName()
						+ "\n    Tech Level: " + player.getLocation().getTechLevel());
	}
}
