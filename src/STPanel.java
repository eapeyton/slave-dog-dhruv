import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The STPanel class is the single JPanel that always sits inside the STFrame class. This class
 * uses a card layout to display the correct screen (represented by JPanels) as the user interacts 
 * with the game.
 * @author Eric Peyton
 *
 */
public class STPanel extends JPanel implements ActionListener {
	
	private CardLayout layout;
	
	private ConfigPanel config;
	private GalacticChart chart;
	private TitlePanel title;
	
	private Player player;
	
	final static String CONFIGPANEL = "Player Configuration Panel";
	final static String CHARTPANEL = "Galactic Chart Panel";
	final static String TITLEPANEL = "Title Panel";
	
	/**
	 * Creates a STPanel with a card layout and initializes all the JPanels.
	 */
	public STPanel() {
		setLayout(new CardLayout(0, 0));
		layout = (CardLayout)getLayout();
		
		config = new ConfigPanel(this);
		chart = new GalacticChart();
		title = new TitlePanel(this);
		
		add(config, CONFIGPANEL);
		add(chart, CHARTPANEL);
		add(title, TITLEPANEL);
		
		layout.show(this,TITLEPANEL);
		
	}
	
	/**
	 * The listener for various GUI elements all over the game
	 */
	public void actionPerformed(ActionEvent e) {
		/**
		 * If the source of the action is the Let's Play button in the configuration panel, then tell
		 * the configuration to panel to create a player and assign it to player.
		 */
		if (e.getSource() == config.getpConfigDone()) {
			player = config.createPlayer();
			System.out.println(player);
		}
		/**
		 * If the source is the New Game button on the title screen, move on the to the
		 * configuration panel.
		 */
		if (e.getSource() == title.getBtnNewGame()) {
			layout.show(this,CONFIGPANEL);
		}
	}
}
