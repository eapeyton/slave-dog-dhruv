import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The STPanel class is the single JPanel that always sits inside the STFrame class. This class
 * uses a card layout to display the correct screen (represented by JPanels) as the user interacts 
 * with the game.
 * @author Eric Peyton, Rikin Marfatia, Eric Morphis
 * @version M7
 *
 */
public class STPanel extends JPanel implements ActionListener {
	
	//store the layout
	private CardLayout layout;
	
	//store the various screens
	private GamePanel game;
	private ConfigPanel config;
	private GalacticChart chart;
	private TitlePanel title;
	private CargoPanel cargo;
	
	//store the player of the game
	private Player player;
	
	//store the strings to reference screens in the card layout
	final static String GAMEPANEL = "Main Game Panel";
	final static String CONFIGPANEL = "Player Configuration Panel";
	final static String TITLEPANEL = "Title Panel";
	final static String CARGOPANEL = "Cargo Panel";
	
	/**
	 * Creates a STPanel with a card layout and initializes all the JPanels.
	 */
	public STPanel() {
		
		/**
		 * Set the layout to a card layout and store the layout for use later.
		 */
		setLayout(new CardLayout(0, 0));
		layout = (CardLayout)getLayout();
		
		/**
		 * Create the various panels or "screens' and pass in STPanel as an Action Listener.
		 */
		game = null;
		cargo = null;
		config = new ConfigPanel(this);
		title = new TitlePanel(this);
		
		/**
		 * Add the panels to the card layout along with static string variables to reference them. Show the title panel.
		 */
		add(config, CONFIGPANEL);
		add(title, TITLEPANEL);
		
		layout.show(this,TITLEPANEL);
		
	}
	
	/**
	 * The listener for various GUI elements all over the game
	 */
	public void actionPerformed(ActionEvent e) {
		/**
		 * If the source of the action is the Let's Play button in the configuration panel, then tell
		 * the configuration to panel to create a player and assign it to player. Then, create
		 * a game screen and show it.
		 * 
		 * If the source of the action is the Marketplace button on the Game Screen, create a new cargo
		 * display screen and show it.
		 */
		if (e.getSource() == config.getpConfigDone()) {
			//create player
			player = config.createPlayer();
			
			//create game panel and show
			game = new GamePanel(this, player);
			add(game, GAMEPANEL);
			layout.show(this,GAMEPANEL);
		}
		
		
		if(game != null)
		{	
			/**
			 * If the source is the market button on the game screen, go to the market panel
			 */
			if(e.getSource() == game.getMarketButton())
			{
				cargo = new CargoPanel(this, player);
				add(cargo, CARGOPANEL);
				layout.show(this, CARGOPANEL);
			}
			
			/**
			 * If the source is the go button, update location information
			 */
			if (e.getSource() == game.getGoButton()) {
				game.update();
			}
		}
		
		/**
		 * If the source is the back button on the cargo screen, go back to the game panel
		 */
		if (cargo != null && e.getSource() == cargo.getBackButton()) {
			layout.show(this, GAMEPANEL);
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
