import javax.swing.JFrame;

/**
 * The driver class for the SpaceTrader game. This contains the main method that creates
 * and runs the SpaceTrader game.
 * @author Eric Peyton,Eric Slep, Eric Morphis, Rikin Marfatia, Dhruv Saksena
 *
 */
public class SpaceTrader {
	/**
	 * The main method for SpaceTrader. Creates the primary JFrame of the game, packs it,
	 * and displays it.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		STFrame frame = new STFrame("Space Trader Revamped");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
}
