/**
 * File Comment
 */
import javax.swing.JFrame;


/**
 * The primary JFrame of the game. Contains various panels.
 * @author Eric Peyton,Eric Slep, Eric Morphis, Rikin Marfatia, Dhruv Saksena
 *
 * @version $Revision: 1.0 $
 */
public class STFrame extends JFrame {

	/**
	 * Field panel.
	 */
	private final STPanel panel;
	
	/**
	 * Creates the STFrame using the JFrame constructor. 
	 * Adds the corresponding panel, STPanel.
	 * @param header the text to be displayed on the top of the window
	 */
	public STFrame(String header) {
		super(header);
		panel = new STPanel();
		add(panel);
	}
	
	
}
