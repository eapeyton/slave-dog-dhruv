import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The configuration panel that displays when a new game is created.
 * @author Eric Peyton,Eric Slep, Eric Morphis, Rikin Marfatia, Dhruv Saksena
 *
 */
public class ConfigPanel extends JPanel implements ChangeListener,KeyListener {
	
	
	//player attributes
	private int pilotSkill,fighterSkill,traderSkill, engineerSkill;
	private int remainingPoints;
	
	//GUI components
	private JTextField nameInput;
	private JSpinner pilotSpinner,fighterSpinner,traderSpinner,engineerSpinner;
	private JLabel remaining;
	private JComboBox difficulty;
	private JButton pConfigDone;
	private boolean pConfigOption;
	
	//player class to be created
	private Player player;
	
	/**
	 * Creates the configuration panel with its components and passes an action listener.
	 * @param listener an action listener
	 */
	public ConfigPanel(ActionListener listener) {
		/**
		 * Set the layout to a border layout.
		 */
		setLayout(new BorderLayout(0, 0));
		
		/**
		 * Initialize the skills of the player to 0.
		 */
		pilotSkill = 0;
		fighterSkill = 0;
		traderSkill = 0;
		engineerSkill = 0;
		remainingPoints = 16;
		
		/**
		 * Create the north panel to hold both title and player name field.
		 */
		//creating north panel
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout(0, 0));
		
		//creating and adding title
		JLabel title = new JLabel("Player Configuration");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Rockwell", Font.BOLD, 30));
		northPanel.add(title, BorderLayout.CENTER);
		
		//adding a little space between the title and top of window
		northPanel.add(Box.createRigidArea(new Dimension(300, 10)),BorderLayout.NORTH);
		
		//Coded by E. Slep
		JPanel namePanel = new JPanel();
		nameInput = new JTextField();
		nameInput.setPreferredSize(new Dimension(100, 20));
		//nameInput.addActionListener(this);
		nameInput.addKeyListener(this);
		namePanel.add(new JLabel("Name: "));
		namePanel.add(nameInput);
		northPanel.add(namePanel, BorderLayout.NORTH);
		String[] diffs = {"Easy","Medium","Hard"};
		difficulty = new JComboBox(diffs);
		northPanel.add(difficulty, BorderLayout.SOUTH);
		
		//adding north panel to config panel
		add(northPanel, BorderLayout.NORTH);
		
		/**
		 * Create skills panel that holds the spinner to select skill points and 
		 * that sits in the CENTER section of the layout.
		 */
		//Coded by E. Slep
		JPanel skillsPanel = new JPanel();
		skillsPanel.setLayout(new GridLayout(5,2));
		skillsPanel.setPreferredSize(new Dimension(200,100));
		
		//set up Spinners and JLabel to show remaining skill points
		pilotSpinner = new JSpinner(new SpinnerNumberModel());
		fighterSpinner = new JSpinner();
		traderSpinner = new JSpinner();
		engineerSpinner = new JSpinner();
		pilotSpinner.addChangeListener(this);
		fighterSpinner.addChangeListener(this);
		traderSpinner.addChangeListener(this);
		engineerSpinner.addChangeListener(this);
		remaining = new JLabel(((Integer)remainingPoints).toString());
		
		//adds all the components to the skillsPanel
		skillsPanel.add(new JLabel("Remaining skill points: "));
		skillsPanel.add(remaining);
		skillsPanel.add(new JLabel("Pilot: "));
		skillsPanel.add(pilotSpinner);
		skillsPanel.add(new JLabel("Fighter: "));
		skillsPanel.add(fighterSpinner);
		skillsPanel.add(new JLabel("Trader: "));
		skillsPanel.add(traderSpinner);
		skillsPanel.add(new JLabel("Engineer: "));
		skillsPanel.add(engineerSpinner);
		add(skillsPanel, BorderLayout.CENTER);
		
		/**
		 * Create GUI struts to control the width and height of the window.
		 */
		//a rigid area in the south panel that can be adjusted to control the width of the entire window
		Component southWidth = Box.createRigidArea(new Dimension(500, 50));
		pConfigDone= new JButton("Let's Play!");
		pConfigDone.setEnabled(false);
		//adding STPanel as action listener
		pConfigDone.addActionListener(listener);
		add(pConfigDone, BorderLayout.SOUTH);
		
		//adding empty space to both sides of the window that can be adjusted to control the height of the entire window
		add(Box.createRigidArea(new Dimension(20, 200)),BorderLayout.WEST);
		add(Box.createRigidArea(new Dimension(20, 200)),BorderLayout.EAST);
		
		
	}
	

	/**
	 * When activated, this method creates the player from the input fields. The STPanel
	 * activates this method so that only one listener is listening to the pConfigDone button
	 * instead of two.
	 * @return the created player
	 */
	public Player createPlayer() {
		player= new Player(nameInput.getText(),(Integer)pilotSpinner.getValue(),(Integer)fighterSpinner.getValue(),(Integer)traderSpinner.getValue(),(Integer)engineerSpinner.getValue(),(String)difficulty.getSelectedItem());
		return player;
	}
	
	/**
	 * @param e Event for when the state of a spinner is changed
	 * @author Eric Slep
	 */
	public void stateChanged(ChangeEvent e){
		/*
		 * If a spinner is the source of the event, re-calculate the remaining skill points and reset
		 * the maximum bounds on the spinner values.
		 */
		if(e.getSource().equals(pilotSpinner)||e.getSource().equals(fighterSpinner)||e.getSource().equals(traderSpinner)||e.getSource().equals(engineerSpinner)){
			remainingPoints = 16-(Integer)pilotSpinner.getValue()-(Integer)fighterSpinner.getValue()-(Integer)traderSpinner.getValue()-(Integer)engineerSpinner.getValue();
			pilotSpinner.setModel(new SpinnerNumberModel((Number)pilotSpinner.getValue(),(Integer)0,remainingPoints+(Integer)pilotSpinner.getValue(),(Number)1));
			fighterSpinner.setModel(new SpinnerNumberModel((Number)fighterSpinner.getValue(),(Integer)0,remainingPoints+(Integer)fighterSpinner.getValue(),(Number)1));
			traderSpinner.setModel(new SpinnerNumberModel((Number)traderSpinner.getValue(),(Integer)0,remainingPoints+(Integer)traderSpinner.getValue(),(Number)1));
			engineerSpinner.setModel(new SpinnerNumberModel((Number)engineerSpinner.getValue(),(Integer)0,remainingPoints+(Integer)engineerSpinner.getValue(),(Number)1));
			remaining.setText(new Integer(remainingPoints).toString());
		
		}
		
		if(remainingPoints==0&&!nameInput.getText().isEmpty()&&(e.getSource().equals(pilotSpinner)||e.getSource().equals(fighterSpinner)||e.getSource().equals(traderSpinner)||e.getSource().equals(engineerSpinner))){
			pConfigDone.setEnabled(true);
		}
		if(remainingPoints!=0&&(e.getSource().equals(pilotSpinner)||e.getSource().equals(fighterSpinner)||e.getSource().equals(traderSpinner)||e.getSource().equals(engineerSpinner))){
			pConfigDone.setEnabled(false);
		}
		
	}
	
	
	public void keyPressed(KeyEvent e)
	{
		if(e.getSource().equals(nameInput)&&!nameInput.getText().isEmpty()&&remainingPoints==0)
		{
			pConfigDone.setEnabled(true);
		}
		if(e.getSource().equals(nameInput)&&nameInput.getText().isEmpty())
		{
			pConfigDone.setEnabled(false);
		}
	}
	
	public void keyReleased(KeyEvent e){
		if(e.getSource()==nameInput&&!nameInput.getText().isEmpty()&&remainingPoints==0){
			pConfigDone.setEnabled(true);
		}
		if(e.getSource()==nameInput&&nameInput.getText().isEmpty()){
			pConfigDone.setEnabled(false);
		}
	}
	
	public void keyTyped(KeyEvent e){
		if(e.getSource()==nameInput&&!nameInput.getText().isEmpty()&&remainingPoints==0){
			pConfigDone.setEnabled(true);
		}
		if(e.getSource()==nameInput&&nameInput.getText().isEmpty()){
			pConfigDone.setEnabled(false);
		}
	}
	
	public Player getPlayer() {
		return player;
	}
	public JButton getpConfigDone() {
		return pConfigDone;
	}
	public void setpConfigDone(JButton pConfigDone) {
		this.pConfigDone = pConfigDone;
	}
	
	
}
