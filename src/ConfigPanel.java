import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.BorderLayout;

/**
 * The configuration panels that displays when a new game is created.
 * @author Eric Peyton
 *
 */
public class ConfigPanel extends JPanel {
	/**
	 * Creates the configuration panel with its components.
	 */
	public ConfigPanel() {
		//initial border layout, this will probably stay
		setLayout(new BorderLayout(0, 0));
		
		//placeholder header text in the north area, delete if you want
		JTextArea txtrConfigureTheGame = new JTextArea();
		txtrConfigureTheGame.setBackground(SystemColor.control);
		txtrConfigureTheGame.setText("Configure the game!");
		add(txtrConfigureTheGame, BorderLayout.NORTH);
		
		//placeholder area in the center area to make the window a reasonable, will be deleted as real components are added
		Component rigidArea = Box.createRigidArea(new Dimension(500, 500));
		add(rigidArea, BorderLayout.CENTER);
	}

}
