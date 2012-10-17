import javax.swing.JPanel;
import java.awt.CardLayout;

/**
 * The STPanel class is the single JPanel that always sits inside the STFrame class. This class
 * uses a card layout to display the correct screen (represented by JPanels) as the user interacts 
 * with the game.
 * @author Eric Peyton
 *
 */
public class STPanel extends JPanel {
	
	CardLayout layout;
	
	ConfigPanel config;
	GalacticChart chart;
	
	final static String CONFIGPANEL = "Player Configuration Panel";
	final static String CHARTPANEL = "Galactic Chart Panel";
	
	/**
	 * Creates a STPanel with a card layout and initializes all the JPanels.
	 */
	public STPanel() {
		setLayout(new CardLayout(0, 0));
		layout = (CardLayout)getLayout();
		
		config = new ConfigPanel();
		chart = new GalacticChart();
		
		add(config, CONFIGPANEL);
		add(chart, CHARTPANEL);
		
		layout.show(this,CONFIGPANEL);
		
	}
}
