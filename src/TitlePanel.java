/**
 * File Comment
 */
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.event.ActionListener;

/**
 * The title screen panel that displays the title of the game and the initial
 * buttons. This screen is the first to open up when the game is run.
 * 
 * @author Eric Peyton
 * 
 * @version $Revision: 1.0 $
 */
public class TitlePanel extends JPanel {

	/**
	 * Field btnNewGame.
	 */
	private JButton btnNewGame;
	/**
	 * Field btnLoadGame.
	 */
	private final JButton btnLoadGame;
	/**
	 * Field btnSettings.
	 */
	private final JButton btnSettings;
	
	/**
	 * Field TITLE_FONT.
	 */
	private static final Font TITLE_FONT = new Font("Ubuntu", Font.BOLD, 38);
	/**
	 * Field MENU_FONT.
	 */
	private static final Font MENU_FONT = new Font("Purisa", Font.BOLD, 20);
	/**
	 * Field TITLE_STRUT.
	 */
	private static final Component TITLE_STRUT = Box.createVerticalStrut(40);
	/**
	 * Field MENU_STRUT.
	 */
	private static final Component MENU_STRUT = Box.createVerticalStrut(15);
	/**
	 * Field MENU_STRUT_2.
	 */
	private static final Component MENU_STRUT_TWO = Box.createVerticalStrut(15);
	/**
	 * Field SIDE_AREA.
	 */
	private static final Component SIDE_AREA =
			Box.createRigidArea(new Dimension(50, 200));
	/**
	 * Field SOUTH_AREA.
	 */
	private static final Component SOUTH_AREA =
			Box.createRigidArea(new Dimension(500, 20));

	/**
	 * Creates the title panel with a border layout. There is a bunch of GUI
	 * stuff in the constructor but you shouldn't have to mess with it much
	 * anyways.
	 * 
	 * @param listener
	 *            ActionListener
	 */
	public TitlePanel(ActionListener listener) {
		setLayout(new BorderLayout(0, 0));

		final JLabel lblSpaceTraderRevamped = new JLabel(
				"Space Trader Revamped");
		lblSpaceTraderRevamped.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpaceTraderRevamped.setFont(TITLE_FONT);
		add(lblSpaceTraderRevamped, BorderLayout.NORTH);

		final JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		panel.add(TITLE_STRUT);

		btnNewGame = new JButton("NEW GAME");
		btnNewGame.setFont(MENU_FONT);
		btnNewGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewGame.addActionListener(listener);
		panel.add(btnNewGame);

		panel.add(MENU_STRUT);

		btnLoadGame = new JButton("LOAD GAME");
		btnLoadGame.setFont(MENU_FONT);
		btnLoadGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnLoadGame.addActionListener(listener);
		panel.add(btnLoadGame);

		panel.add(MENU_STRUT_TWO);

		btnSettings = new JButton("SETTINGS");
		btnSettings.setFont(MENU_FONT);
		btnSettings.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btnSettings);

		add(SIDE_AREA, BorderLayout.WEST);
		add(SIDE_AREA, BorderLayout.EAST);
		add(SOUTH_AREA, BorderLayout.SOUTH);
	}

	/**
	 * 
	
	 * @return the btnNewGame */
	public JButton getBtnNewGame() {
		return btnNewGame;
	}

	/**
	 * @param btnNewGame
	 *            the btnNewGame to set
	 */
	public void setBtnNewGame(JButton btnNewGame) {
		this.btnNewGame = btnNewGame;
	}

	/**
	 * 
	 * 
	
	 * @return the btnLoadGame */
	public JButton getBtnLoadGame() {
		return btnLoadGame;
	}

	/**
	 * 
	 * @param btnNewGame
	 *            the btnLoadGame to set
	 */
	public void setBtnLoadGame(JButton btnNewGame) {
		this.btnNewGame = btnNewGame;
	}

}
