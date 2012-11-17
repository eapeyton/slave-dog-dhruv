import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.Point;
import java.util.HashMap;
import javax.swing.*;

/**
 * Creates and draws a universe
 * @author Dhruv Saksena, Eric Morphis
 * @version $Revision: 1.0 $
 */
public class GalacticChart extends JPanel{
	
	/**
	 * Field universe.
	 */
	private ArrayList<StarSystem> universe;
	/**
	 * Field player.
	 */
	private Player player;
	/**
	 * Field selected.
	 */
	private StarSystem selected;
	/**
	 * Field destination.
	 */
	private JLabel destination;
	/**
	 * Field go.
	 */
	private JButton go;
	/**
	 * Field adapter.
	 */
	private Adapter adapter;
	
	/**
	 * Constructor for GalacticChart.
	 * @param destination JLabel
	 * @param go JButton
	 */
	public GalacticChart(JLabel destination, JButton go)
	{
		this.destination = destination;
		this.go = go;
	}
	
	/**
	 * Constructor for GalacticChart.
	 * @param destination JLabel
	 * @param go JButton
	 * @param universe ArrayList<StarSystem>
	 */
	public GalacticChart(JLabel destination, JButton go, ArrayList<StarSystem> universe)
	{
		this.destination = destination;
		this.go = go;
		this.universe = universe;
	}
	
	/**
	 * Generates and returns a universe with star systems named according to a pre-allocated library of names
	
	 * @return Newly generated universe */
	public ArrayList<StarSystem> generateUniverse(){
		
		
		String[] SolarSystemName=
			{
			    "Acamar",
			    "Adahn",		// The alternate personality for The Nameless One in "Planescape: Torment"
			    "Aldea",
			    "Andevian",
			    "Antedi",
			    "Balosnee",
			    "Baratas",
			    "Brax",			// One of the heroes in Master of Magic
			    "Bretel",		// This is a Dutch device for keeping your pants up.
			    "Calondia",
			    "Campor",
			    "Capelle",		// The city I lived in while programming this game
			    "Carzon",
			    "Castor",		// A Greek demi-god
			    "Cestus",
			    "Cheron",		
			    "Courteney",	// After Courteney Cox…
			    "Daled",
			    "Damast",
			    "Davlos",
			    "Deneb",
			    "Deneva",
			    "Devidia",
			    "Draylon",
			    "Drema",
			    "Endor",
			    "Esmee",		// One of the witches in Pratchett's Discworld
			    "Exo",
			    "Ferris",		// Iron
			    "Festen",		// A great Scandinavian movie
			    "Fourmi",		// An ant, in French
			    "Frolix",		// A solar system in one of Philip K. Dick's novels
			    "Gemulon",
			    "Guinifer",		// One way of writing the name of king Arthur's wife
			    "Hades",		// The underworld
			    "Hamlet",		// From Shakespeare
			    "Helena",		// Of Troy
			    "Hulst",		// A Dutch plant
			    "Iodine",		// An element
			    "Iralius",
			    "Janus",		// A seldom encountered Dutch boy's name
			    "Japori",
			    "Jarada",
			    "Jason",		// A Greek hero
			    "Kaylon",
			    "Khefka",
			    "Kira",			// My dog's name
			    "Klaatu",		// From a classic SF movie
			    "Klaestron",
			    "Korma",		// An Indian sauce
			    "Kravat",		// Interesting spelling of the French word for "tie"
			    "Krios",
			    "Laertes",		// A king in a Greek tragedy
			    "Largo",
			    "Lave",			// The starting system in Elite
			    "Ligon",
			    "Lowry",		// The name of the "hero" in Terry Gilliam's "Brazil"
			    "Magrat",		// The second of the witches in Pratchett's Discworld
			    "Malcoria",
			    "Melina",
			    "Mentar",		// The Psilon home system in Master of Orion
			    "Merik",
			    "Mintaka",
			    "Montor",		// A city in Ultima III and Ultima VII part 2
			    "Mordan",
			    "Myrthe",		// The name of my daughter
			    "Nelvana",
			    "Nix",			// An interesting spelling of a word meaning "nothing" in Dutch
			    "Nyle",			// An interesting spelling of the great river
			    "Odet",
			    "Og",			// The last of the witches in Pratchett's Discworld
			    "Omega",		// The end of it all
			    "Omphalos",		// Greek for navel
			    "Orias",
			    "Othello",		// From Shakespeare
			    "Parade",		// This word means the same in Dutch and in English
			    "Penthara",
			    "Picard",		// The enigmatic captain from ST:TNG
			    "Pollux",		// Brother of Castor
			    "Quator",
			    "Rakhar",
			    "Ran",			// A film by Akira Kurosawa
			    "Regulas",
			    "Relva",
			    "Rhymus",
			    "Rochani",
			    "Rubicum",		// The river Ceasar crossed to get into Rome
			    "Rutia",
			    "Sarpeidon",
			    "Sefalla",
			    "Seltrice",
			    "Sigma",
			    "Sol",			// That's our own solar system
			    "Somari",
			    "Stakoron",
			    "Styris",
			    "Talani",
			    "Tamus",
			    "Tantalos",		// A king from a Greek tragedy
			    "Tanuga",
			    "Tarchannen",
			    "Terosa",
			    "Thera",		// A seldom encountered Dutch girl's name
			    "Titan",		// The largest moon of Jupiter
			    "Torin",		// A hero from Master of Magic
			    "Triacus",
			    "Turkana",
			    "Tyrus",
			    "Umberlee",		// A god from AD&D, which has a prominent role in Baldur's Gate
			    "Utopia",		// The ultimate goal
			    "Vadera",
			    "Vagra",
			    "Vandor",
			    "Ventax",
			    "Xenon",
			    "Xerxes",		// A Greek hero
			    "Yew",			// A city which is in almost all of the Ultima games
			    "Yojimbo",		// A film by Akira Kurosawa
			    "Zalkon",
			    "Zuul"			// From the first Ghostbusters movie
			};
		
		ArrayList<StarSystem> universe=new ArrayList<StarSystem>();
		
		for(int i=0;i<SolarSystemName.length;i++){
			universe.add(new StarSystem(SolarSystemName[i]));
		}
		//TODO Add check so that Star Systems dont get generated on top of each other
		
		this.universe = universe;
		
		return universe;
	}
	
	/**
	
	 * @param player Player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	/**
	 * Draws universe using the designated graphics object
	 * @param universe The universe to be drawn
	
	 * @param player Player
	 * @param graphicPanel Graphics
	 */
	public void drawUniverse(ArrayList<StarSystem> universe, Player player, Graphics graphicPanel){
		
		int planetSize=8;//Planet Circle Size
		graphicPanel.setColor(Color.GREEN);
		for(int i=0;i<universe.size();i++){
			graphicPanel.fillRect((int) universe.get(i).getLocation().getX() - planetSize/2 ,(int) universe.get(i).getLocation().getY() - planetSize/ 2,planetSize,planetSize);
		}
		graphicPanel.setColor(Color.BLUE);
		graphicPanel.fillRect((int) player.location.getLocation().getX() - planetSize/2, (int) player.location.getLocation().getY() - planetSize/2, planetSize, planetSize);
		graphicPanel.drawOval((int) player.location.getLocation().getX() - player.getFuel(), (int) player.location.getLocation().getY() - player.getFuel(), 2*player.getFuel(), 2*player.getFuel());
		if (selected != null) {
			graphicPanel.setColor(Color.RED);
			graphicPanel.fillRect((int) selected.getLocation().getX() - planetSize/2, (int) selected.getLocation().getY() - planetSize/2, planetSize, planetSize);
			destination.setText("Destination: " + selected.getName());
			go.setEnabled(true);
		}
		else
		{
			destination.setText("Destination:");
			go.setEnabled(false);
		}
		removeMouseListener(adapter);
		adapter = new Adapter(planetSize);
		addMouseListener(adapter);
	}
	
	/**
	 * Draws a newly generated universe using the designated graphics object
	
	 * @param graphicPanel Graphics
	 */
	public void paintComponent(Graphics graphicPanel){
		setOpaque(false);
		drawUniverse(universe, player, graphicPanel);
	}
	
	/**
	
	 * @return The currently selected star system */
	public StarSystem getSelected() {
		return selected;
	}
	
	/**
	 * param selected The currently selected star system
	 * @param selected StarSystem
	 */
	public void setSelected(StarSystem selected) {
		this.selected = selected;
	}
	
	/**
	 * Get the universe
	
	 * @return universe */
	public ArrayList<StarSystem> getUniverse()
	{
		return universe;
	}
	
	/**
	 * 
	 * @author Eric Morphis
	 * Attached to a galactic chart to update the selected planet based on where the user clicks
	 */
	private class Adapter extends MouseAdapter {
		/**
		 * Field mapPlanetSize.
		 */
		public int mapPlanetSize;
		/**
		 * Field clickMap.
		 */
		public HashMap<Point, StarSystem> clickMap;
		/**
		 * Field graphicPanel.
		 */
		public Graphics graphicPanel;
		
		/**
		 * Constructor gets a map of valid click locations
		 * @param mapPlanetSize The size of the planets on the map
		 */
		public Adapter(int mapPlanetSize) {
			this.mapPlanetSize = mapPlanetSize;
			clickMap = player.location.getClickMap(mapPlanetSize, player.getFuel());
			graphicPanel = getGraphics();
		}
		
		/**
		 * Determines whether or not a valid selection was made, and if so, selects new planet
		
		 * @param me MouseEvent
		
		 * @see java.awt.event.MouseListener#mouseReleased(MouseEvent) */
		public void mouseReleased(MouseEvent me) {
			if (clickMap.containsKey(me.getPoint())) {
				selected = clickMap.get(me.getPoint());
				paintComponent(getGraphics());
			}
		}
	}
	
	/**
        * Set the go button
       
        * @param newGoBtn JButton
	 */
        public void setGoBtn(JButton newGoBtn) {
                go = newGoBtn;
        }
        
        /**
        * Get the go button
       
        * @return the go button */
        public JButton getGoBtn() {
                return go;
        }
        
        /**
         * Method toString.
         * @return String
         */
        public String toString(){
        	return "GalacticChart";
        }
}
