import javax.swing.BoxLayout;
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
 * @author Eric Peyton, Rikin Marfatia, Eric Morphis
 *
 */
public class GamePanel extends JPanel 
{
	
	Player player;
	StarSystem location;
	JLabel planet;
	JLabel destination;
	JButton market;
	JButton go;
	GalacticChart chart;
	ArrayList<StarSystem> universe;
	
	/**
	 * Creates a new GamePanel taking in an ActionListener as a parameter.
	 * @param listener an action listener
	 */
	public GamePanel(ActionListener listener, Player player) {
		/**
		 * Set the layout to border layout.
		 */
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		destination = new JLabel("Destination:");
		go = new JButton("Go!");
		go.setEnabled(false);
		
		chart = new GalacticChart(destination, go);
		universe = chart.generateUniverse();
		chart.setPlayer(player);
		
		this.player = player;
		Random rand = new Random();
		player.setLocation(universe.get(rand.nextInt(universe.size())));
		
		planet = new JLabel("Current Location: " + player.getLocation().getName()
						+ "\n    Tech Level: " + player.getLocation().getTechLevel());
		market = new JButton("Marketplace");
		market.addActionListener(listener);
		go.addActionListener(listener);
		
		add(market);
		add(chart);
		add(planet);
		add(destination);
		add(go);
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
		planet.setText("Current Location: " + player.getLocation().getName()
				+ "\n    Tech Level: " + player.getLocation().getTechLevel());
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
}
