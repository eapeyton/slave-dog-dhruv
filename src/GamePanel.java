import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The main screen of the game. This is where the user will spend much of their time.
 * The GamePanel first appears after a player is created in the configuration screen.
 * @author Eric Peyton
 *
 */
public class GamePanel extends JPanel {
	
	/**
	 * Creates a new GamePanel taking in an ActionListener as a parameter.
	 * @param listener an action listener
	 */
	public GamePanel(ActionListener listener) {
		/**
		 * Set the layout to border layout.
		 */
		setLayout(new BorderLayout(0,0));
		
		/**
		 * TEST:
		 * Add a button to the CENTER section to see if the panel is working...
		 */
		add(new JLabel("Game Screen"),BorderLayout.CENTER);
		
		/**
		 * TEST:
		 * Generate and print out the universe for demoing purposes
		 */
		GalacticChart chart = new GalacticChart();
		System.out.println(chart.generateUniverse());
	}
}
