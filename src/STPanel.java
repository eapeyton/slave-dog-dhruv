/**
 * File Comment
 */
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.io.File;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * The STPanel class is the single JPanel that always sits inside the STFrame
 * class. This class uses a card layout to display the correct screen
 * (represented by JPanels) as the user interacts with the game.
 * 
 * @author Eric Peyton, Rikin Marfatia, Eric Morphis, Eric Slep
 * @version M7
 * 
 */
public class STPanel extends JPanel implements ActionListener {

	// store the layout
	/**
	 * Field layout.
	 */
	private final CardLayout layout;

	// store the various screens
	/**
	 * Field game.
	 */
	private GamePanel game;
	/**
	 * Field config.
	 */
	private final ConfigPanel config;

	/**
	 * Field title.
	 */
	private final TitlePanel title;
	/**
	 * Field cargo.
	 */
	private CargoPanel cargo;
	/**
	 * Field files.
	 */
	private final FilePanel files;
	/**
	 * Field random.
	 */
	private RandomEvent random;

	// store the player of the game
	/**
	 * Field player.
	 */
	private Player player;

	// store the strings to reference screens in the card layout
	/**
	 * Field GAMEPANEL. (value is ""Main Game Panel"")
	 */
	private static final String GAMEPANEL = "Main Game Panel";
	/**
	 * Field CONFIGPANEL. (value is ""Player Configuration Panel"")
	 */
	private static final String CONFIGPANEL = "Player Configuration Panel";
	/**
	 * Field TITLEPANEL. (value is ""Title Panel"")
	 */
	private static final String TITLEPANEL = "Title Panel";
	/**
	 * Field CARGOPANEL. (value is ""Cargo Panel"")
	 */
	private static final String CARGOPANEL = "Cargo Panel";
	/**
	 * Field FILEPANEL. (value is ""File Select Panel"")
	 */
	private static final String FILEPANEL = "File Select Panel";
	/**
	 * Field RANDOMPANEL. (value is ""Random Event Panel"")
	 */
	private static final String RANDOMPANEL = "Random Event Panel";
	/**
	 * Field RANDOM_EVENT_CHANCE.
	 * (value is 0.5)
	 */
	private static final double RANDOM_EVENT_CHANCE = .5;
	/**
	 * Field FUEL_COST.
	 * (value is 10)
	 */
	/**
	 * Field NUM_NONPLAYERS.
	 * (value is 3)
	 */
	private static final int NUM_NONPLAYERS = 3, FUEL_COST = 10;

	/**
	 * Creates a STPanel with a card layout and initializes all the JPanels.
	 */
	public STPanel() {
		/**
		 * Set the layout to a card layout and store the layout for use later.
		 */
		setLayout(new CardLayout(0, 0));
		layout = (CardLayout) getLayout();

		/**
		 * Create the various panels or "screens' and pass in STPanel as an
		 * Action Listener.
		 */
		game = null;
		cargo = null;
		random = null;
		config = new ConfigPanel(this);
		title = new TitlePanel(this);
		files = new FilePanel(this);

		/**
		 * Add the panels to the card layout along with static string variables
		 * to reference them. Show the title panel.
		 */
		add(config, CONFIGPANEL);
		add(title, TITLEPANEL);
		add(files, FILEPANEL);

		layout.show(this, TITLEPANEL);

	}

	/**
	 * The listener for various GUI elements all over the game
	 * 
	 * @param e
	 *            ActionEvent
	
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent) */
	public void actionPerformed(ActionEvent e) {
		/**
		 * If the source of the action is the Let's Play button in the
		 * configuration panel, then tell the configuration to panel to create a
		 * player and assign it to player. Then, create a game screen and show
		 * it.
		 */
		if (e.getSource().equals(config.getpConfigDone())) {
			// create player
			player = config.createPlayer();

			// create game panel and show
			game = new GamePanel(this, player);
			add(game, GAMEPANEL);
			layout.show(this, GAMEPANEL);
		}
		if (game != null) {
			/**
			 * If the source of the action is the Marketplace button on the Game
			 * Screen, create a new cargo display screen and show it.
			 */
			if (e.getSource().equals(game.getMarketButton())) {
				cargo = new CargoPanel(player, this);
				add(cargo, CARGOPANEL);
				layout.show(this, CARGOPANEL);
			}

			/**
			 * If the source is the go button, update location information
			 */
			if (e.getSource().equals(game.getGoButton())) {
				/* Chance of a random event is 50/50 */
				double chance = Math.random();
				/* Create a random event, else update the game */
				if (chance < RANDOM_EVENT_CHANCE) {
					chance *= NUM_NONPLAYERS;	//chance is in the range of [0,3)
					random = new RandomEvent(chance, player, this);
					add(random, RANDOMPANEL);
					layout.show(this, RANDOMPANEL);
				} else {
					game.update();
				}
			}
			/**
			 * If a random event has just been processed, update the game
			 */
			if (random != null && e.getSource().equals(random.getFunc1Button())) {
				if (random.getFunc1Button().getText().equals("Continue")) {
					layout.show(this, GAMEPANEL);
					game.update();
				}
			}
			/**
			 * If the source is the save button, Opens JFileChooser to save the
			 * game
			 */
			if (e.getSource().equals(game.getSaveButton())) {
				files.saveMode();
				layout.show(this, FILEPANEL);

			}
			/**
			 * If the source is the buy fuel button, open a dialog button to buy
			 * fuel
			 */
			if (e.getSource().equals(game.getBuyFuelButton())) {
				// Create a new spinner and show it in a dialog box
				final JSpinner fuelSpinner = new JSpinner(
						new SpinnerNumberModel(0, 0, player.getMoney() / FUEL_COST, 1));
				final int option = JOptionPane.showOptionDialog(this,
						fuelSpinner, "How much fuel?",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (option == JOptionPane.OK_OPTION){ // User hit OK button
					// Get the fuel amount and change the player's fuel and
					// money
					final int amount = (Integer) fuelSpinner.getValue();
					if (amount > 0) {
						if (player.getMoney() >= amount * FUEL_COST) {
							player.setMoney(player.getMoney() - amount * FUEL_COST);
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
		 * If the cargo panel is created and source of the action is the back
		 * button in the marketplace, then show the game screen again.
		 */
		if (cargo != null && e.getSource().equals(cargo.getBackBtn())) {
			layout.show(this, GAMEPANEL);
		}

		/**
		 * If the source is the New Game button on the title screen, move on the
		 * to the configuration panel.
		 */
		if (e.getSource().equals(title.getBtnNewGame())) {
			layout.show(this, CONFIGPANEL);
		}

		/**
		 * 
		 */
		if (e.getSource().equals(title.getBtnLoadGame())) {
			files.openMode();
			layout.show(this, FILEPANEL);

		}

		if (e.getSource().equals(files.getFileChooser())) {
			if (e.getActionCommand().equals("ApproveSelection")) {
				if (files.getFileChooser().getDialogType() == JFileChooser.OPEN_DIALOG) {
					final File savefile = files.getFileChooser()
							.getSelectedFile();
					FileInputStream fIStream = null;
					ObjectInputStream oIStream = null;
					try {
						fIStream = new FileInputStream(savefile);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						oIStream = new ObjectInputStream(fIStream);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						final Player player = (Player) oIStream.readObject();
						final ArrayList<StarSystem> universe =
								(ArrayList<StarSystem>) oIStream
								.readObject();
						final HashMap<Point, StarSystem> usedLocations =
								(HashMap<Point, StarSystem>) oIStream
								.readObject();
						StarSystem.setUsedLocations(usedLocations);
						final StarSystem selected = (StarSystem) oIStream
								.readObject();
						final JLabel destination = new JLabel("Destination:");
						final JButton newGo = new JButton("Go!");
						final GalacticChart chart = new GalacticChart(
								destination, newGo, universe);
						chart.setPlayer(player);
						chart.setSelected(selected);
						game = new GamePanel(this, player, chart);
						newGo.setEnabled(true);
						this.player = player;
						fIStream.close();

					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					if (game != null) {
						add(game, GAMEPANEL);
						layout.show(this, GAMEPANEL);
					} else {
						layout.show(this, TITLEPANEL);
					}
				} else if (files.getFileChooser().getDialogType() ==
						JFileChooser.SAVE_DIALOG) {
					final File savefile = files.getFileChooser()
							.getSelectedFile();
					FileOutputStream fOStream = null;
					ObjectOutputStream oOStream = null;
					try {
						fOStream = new FileOutputStream(savefile);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						oOStream = new ObjectOutputStream(fOStream);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						oOStream.writeObject(game.getPlayer());
						oOStream.writeObject(game.getChart().getUniverse());
						oOStream.writeObject(StarSystem.getUsedLocations());
						oOStream.writeObject(game.getChart().getSelected());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					layout.show(this, GAMEPANEL);
				}
			} else if (e.getActionCommand().equals("CancelSelection")) {
				if (files.getFileChooser().getDialogType() == JFileChooser.OPEN_DIALOG) {
					layout.show(this, TITLEPANEL);
				} else if (files.getFileChooser().getDialogType() ==
						JFileChooser.SAVE_DIALOG) {
					layout.show(this, GAMEPANEL);
				}
			}
		}
	}
}
