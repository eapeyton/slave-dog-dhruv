import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The configuration panels that displays when a new game is created.
 * @author Eric Peyton,Eric Slep, Eric Morphis, Rikin Marfatia
 *
 */
public class ConfigPanel extends JPanel implements ActionListener,ChangeListener {
	/**
	 * Creates the configuration panel with its components.
	 */
	
	//player attributes
	private String playerName;
	private int pilotSkill,fighterSkill,traderSkill, engineerSkill;
	private int remainingPoints;
	
	//GUI components
	private JTextField nameInput;
	private JSpinner pilotSpinner,fighterSpinner,traderSpinner,engineerSpinner;
	private JLabel remaining;
	
	public ConfigPanel() {
		//initial border layout, this will probably stay
		setLayout(new BorderLayout(0, 0));
		
		pilotSkill = fighterSkill = traderSkill = engineerSkill = 0;
		remainingPoints = 16;
		
		//placeholder header text in the north area, delete if you want
		JTextArea txtrConfigureTheGame = new JTextArea();
		txtrConfigureTheGame.setBackground(SystemColor.control);
		txtrConfigureTheGame.setText("Configure the game!");
		//add(txtrConfigureTheGame, BorderLayout.NORTH);
		
		//Coded by E. Slep
		nameInput = new JTextField();
		JPanel namePanel = new JPanel();
		nameInput.setPreferredSize(new Dimension(100, 20));
		namePanel.add(new JLabel("Name: "));
		namePanel.add(nameInput);
		add(namePanel, BorderLayout.NORTH);
		
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
		
		//placeholder area in the center area to make the window a reasonable, will be deleted as real components are added
		Component rigidArea = Box.createRigidArea(new Dimension(300, 100));
		add(rigidArea, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
	}
	
	/**
	 * @param e Event for when the state of a spinner is changed
	 * @author Eric Slep
	 */
	public void stateChanged(ChangeEvent e)
	{
		/*
		 * If a spinner is the source of the event, re-calculate the remaining skill points and reset
		 * the maximum bounds on the spinner values.
		 */
		if(e.getSource()==pilotSpinner||e.getSource()==fighterSpinner||e.getSource()==traderSpinner||e.getSource()==engineerSpinner)
		{
			remainingPoints = 16-(Integer)pilotSpinner.getValue()-(Integer)fighterSpinner.getValue()-(Integer)traderSpinner.getValue()-(Integer)engineerSpinner.getValue();
			pilotSpinner.setModel(new SpinnerNumberModel((Number)pilotSpinner.getValue(),(Integer)0,remainingPoints+(Integer)pilotSpinner.getValue(),(Number)1));
			fighterSpinner.setModel(new SpinnerNumberModel((Number)fighterSpinner.getValue(),(Integer)0,remainingPoints+(Integer)fighterSpinner.getValue(),(Number)1));
			traderSpinner.setModel(new SpinnerNumberModel((Number)traderSpinner.getValue(),(Integer)0,remainingPoints+(Integer)traderSpinner.getValue(),(Number)1));
			engineerSpinner.setModel(new SpinnerNumberModel((Number)engineerSpinner.getValue(),(Integer)0,remainingPoints+(Integer)engineerSpinner.getValue(),(Number)1));
			remaining.setText(new Integer(remainingPoints).toString());
		}
	}

	public String getPlayerName()
	{
		return playerName;
	}
	
	public int getPilotSkill()
	{
		return pilotSkill;
	}
	
	public int getFighterSkill()
	{
		return fighterSkill;
	}
	
	public int getTraderSkill()
	{
		return traderSkill;
	}
	
	public int getEngineerSkill()
	{
		return engineerSkill;
	}
	
}
