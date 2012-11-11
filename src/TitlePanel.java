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
 * The title screen panel that displays the title of the game and the initial buttons.
 * This screen is the first to open up when the game is run.
 * @author Eric Peyton
 *
 */
public class TitlePanel extends JPanel {
	
	private JButton btnNewGame;
	private JButton btnLoadGame;
	private JButton btnSettings;
	
	/**
	 * Creates the title panel with a border layout. There is a bunch of GUI crap 
	 * in the constructor but you shouldn't have to mess with it much anyways.
	 */
	public TitlePanel(ActionListener listener) {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblSpaceTraderRevamped = new JLabel("Space Trader Revamped");
		lblSpaceTraderRevamped.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpaceTraderRevamped.setFont(new Font("Ubuntu", Font.BOLD, 38));
		add(lblSpaceTraderRevamped, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		Component verticalStrut_2 = Box.createVerticalStrut(40);
		panel.add(verticalStrut_2);
		
		btnNewGame = new JButton("NEW GAME");
		btnNewGame.setFont(new Font("Purisa", Font.BOLD, 20));
		btnNewGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewGame.addActionListener(listener);
		panel.add(btnNewGame);
		
		Component verticalStrut = Box.createVerticalStrut(15);
		panel.add(verticalStrut);
		
		btnLoadGame = new JButton("LOAD GAME");
		btnLoadGame.setFont(new Font("Purisa", Font.BOLD, 20));
		btnLoadGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnLoadGame.addActionListener(listener);
		panel.add(btnLoadGame);
		
		Component verticalStrut_1 = Box.createVerticalStrut(15);
		panel.add(verticalStrut_1);
		
		btnSettings = new JButton("SETTINGS");
		btnSettings.setFont(new Font("Purisa", Font.BOLD, 20));
		btnSettings.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btnSettings);
		
		Component rigidArea = Box.createRigidArea(new Dimension(50, 200));
		add(rigidArea, BorderLayout.WEST);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(50, 200));
		add(rigidArea_1, BorderLayout.EAST);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(500, 20));
		add(rigidArea_2, BorderLayout.SOUTH);
	}

	/**
	 * @return the btnNewGame
	 */
	public JButton getBtnNewGame() {
		return btnNewGame;
	}

	/**
	 * @param btnNewGame the btnNewGame to set
	 */
	public void setBtnNewGame(JButton btnNewGame) {
		this.btnNewGame = btnNewGame;
	}
	
	/**
	 * 
	 * @return the btnLoadGame
	 */
	public JButton getBtnLoadGame()
	{
		return btnLoadGame;
	}
	
	/**
	 * 
	 * @param btnNewGame the btnLoadGame to set
	 */
	public void setBtnLoadGame(JButton btnNewGame)
	{
		this.btnNewGame = btnNewGame;
	}

}
