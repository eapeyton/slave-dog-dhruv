import javax.swing.JFrame;


/**
 * The primary JFrame of the game. Contains various panels.
 * @author Eric Peyton
 *
 */
public class STFrame extends JFrame {

	private ConfigPanel config;
	
	/**
	 * Creates the STFrame using the JFrame constructor. Adds the configuration panel.
	 * @param header the text to be displayed on the top of the window
	 */
	public STFrame(String header) {
		super(header);
		config = new ConfigPanel();
		add(config);
	}
	
	
}
