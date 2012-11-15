import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.awt.Point;
import java.util.ArrayList;


/**
 * The STPanel class is the single JPanel that always sits inside the STFrame class. This class
 * uses a card layout to display the correct screen (represented by JPanels) as the user interacts 
 * with the game.
 * @author Eric Peyton, Rikin Marfatia, Eric Morphis, Eric Slep
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
	private FilePanel files;
	private RandomEvent random;
	
	//store the player of the game
	private Player player;
	
	//store the strings to reference screens in the card layout
	final static String GAMEPANEL = "Main Game Panel";
	final static String CONFIGPANEL = "Player Configuration Panel";
	final static String TITLEPANEL = "Title Panel";
	final static String CARGOPANEL = "Cargo Panel";
	final static String FILEPANEL = "File Select Panel";
	final static String RANDOMPANEL = "Random Event Panel";
	
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
		random = null;
		config = new ConfigPanel(this);
		title = new TitlePanel(this);
		files = new FilePanel(this);
		
		
		/**
		 * Add the panels to the card layout along with static string variables to reference them. Show the title panel.
		 */
		add(config, CONFIGPANEL);
		add(title, TITLEPANEL);
		add(files, FILEPANEL);
		
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
			 * If the source of the action is the Marketplace button on the Game Screen, create a new cargo
			 * display screen and show it.
			*/
			if(e.getSource() == game.getMarketButton())
			{
				cargo = new CargoPanel(player,this);
				add(cargo, CARGOPANEL);
				layout.show(this, CARGOPANEL);
			}
			
			/**
			 * If the source is the go button, update location information
			 */
			if (e.getSource() == game.getGoButton()) {
			        /* Chance of a random event is 50/50 */
			        double chance = Math.random();
			        /* Create a random event, else update the game */
			        if(chance < .5) {
			                random = new RandomEvent(0,player,this);
			                add(random, RANDOMPANEL);
			                layout.show(this,RANDOMPANEL);
			        }
			        else {
			                game.update();
			        }
			}
			/**
			 * If a random event has just been processed, update the game
			 */
			if(random != null && e.getSource() == random.getFunc1Button()) {
			        if(random.getFunc1Button().getText() == "Continue") {
			                layout.show(this,GAMEPANEL);
			                game.update();
			        }
			}
			/**
			 * If the source is the save button, Opens JFileChooser to save the game
			 */
			if(e.getSource() == game.getSaveButton())
			{
				files.setModeSave();
				layout.show(this,FILEPANEL);
				
			}
			/**
			 * If the source is the buy fuel button, open a dialog button to buy fuel
			 */
			if(e.getSource() == game.getBuyFuelButton())
                        {
								// Create a new spinner and show it in a dialog box
								JSpinner fuelSpinner = new JSpinner(new SpinnerNumberModel(0, 0, player.getMoney() / 10, 1));
								int option = JOptionPane.showOptionDialog(this, fuelSpinner, "How much fuel?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
								if (option == JOptionPane.OK_OPTION) // User hit OK button
								{
										// Get the fuel amount and change the player's fuel and money
										int amount = (Integer)fuelSpinner.getValue();
										if(amount > 0) {
	                                        if(player.getMoney()>=amount*10){
	                                                player.setMoney(player.getMoney()-amount*10);
	                                                player.setFuel(player.getFuel() + amount);
	                                        }
										}
										// Repaint and upate the galactic chart
										game.getChart().repaint();
										game.updateInfoLabels();
								} 
								
		         }
		}
		
		/**
		 * If the cargo panel is created and source of the action is the back button 
		 * in the marketplace, then show the game screen again.
		 */
		if(cargo!=null&&e.getSource() == cargo.getBackBtn()) {
			layout.show(this, GAMEPANEL);
		}
		
		
		/**
		 * If the source is the New Game button on the title screen, move on the to the
		 * configuration panel.
		 */
		if (e.getSource() == title.getBtnNewGame()) {
			layout.show(this,CONFIGPANEL);
		}
		
		/**
		 * 
		 */
		if(e.getSource() == title.getBtnLoadGame())
		{
			files.setModeOpen();
			layout.show(this,FILEPANEL);
			
			
		}
		
		if(e.getSource() == files.getFileChooser())
		{
			if(e.getActionCommand().equals("ApproveSelection"))
			{
				if(files.getFileChooser().getDialogType()==JFileChooser.OPEN_DIALOG)
				{
					File savefile = files.getFileChooser().getSelectedFile();
					FileInputStream FIStream = null;
					ObjectInputStream OIStream = null;
					try
					{
						FIStream = new FileInputStream(savefile);
					}
					catch (FileNotFoundException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try
					{
						OIStream = new ObjectInputStream(FIStream);
					}
					catch (IOException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try
					{
						Player player = (Player)OIStream.readObject();
						ArrayList<StarSystem> universe = (ArrayList<StarSystem>)OIStream.readObject();
						HashMap<Point, StarSystem> usedLocations = (HashMap<Point, StarSystem>)OIStream.readObject();
						StarSystem.setUsedLocations(usedLocations);
						StarSystem selected = (StarSystem)OIStream.readObject();
						JLabel destination = new JLabel("Destination:");
						JButton newGo = new JButton("Go!");
						GalacticChart chart = new GalacticChart(destination,newGo,universe);
						chart.setPlayer(player);
						chart.setSelected(selected);
						game = new GamePanel(this, player, chart);
						newGo.setEnabled(true);
						this.player = player;
					}
					catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					catch (IOException e1) {
						e1.printStackTrace();
					}
					if(game!=null)
					{
						add(game, GAMEPANEL);
						layout.show(this, GAMEPANEL);
					}
					else
					{
						layout.show(this, TITLEPANEL);
					}
				}
				else if(files.getFileChooser().getDialogType()==JFileChooser.SAVE_DIALOG)
				{
					File savefile = files.getFileChooser().getSelectedFile();
					FileOutputStream FOStream = null;
					ObjectOutputStream OOStream = null;
					try
					{
						FOStream = new FileOutputStream(savefile);
					}
					catch (FileNotFoundException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try
					{
						OOStream = new ObjectOutputStream(FOStream);
					}
					catch (IOException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try
					{
						OOStream.writeObject(game.getPlayer());
						OOStream.writeObject(game.getChart().getUniverse());
						OOStream.writeObject(StarSystem.getUsedLocations());
						OOStream.writeObject(game.getChart().getSelected());
					}
					catch (IOException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					layout.show(this, GAMEPANEL);
				}
			}
			else if(e.getActionCommand().equals("CancelSelection"))
			{
				if(files.getFileChooser().getDialogType()==JFileChooser.OPEN_DIALOG)
					layout.show(this, TITLEPANEL);
				else if(files.getFileChooser().getDialogType()==JFileChooser.SAVE_DIALOG)
					layout.show(this, GAMEPANEL);
			}
		}
	}
}
