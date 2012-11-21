/**
 * Various JUnit tests
 * 
 * @author Eric Peyton, Eric Slep, Eric Morphis, Rikin Marfatia, Dhruv Saksena
 * 
 * @version $Revision: 1.0 $
 */

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import javax.swing.JSpinner;
import javax.swing.JTextField;

import org.junit.Test;

@SuppressWarnings("unchecked")
public class JUnits {
	
	/**
	 * Test for NonPlayer.canNpTakeDamage
	 **/
	@Test
	public void testCanNpTakeDamage1() {
		NonPlayer np = new NonPlayer(0);
		np.health = 5;
		assertFalse(np.canNpTakeDamage(4));
		assertTrue(np.health == 1);
	}
	
	/**
	 * Test for NonPlayer.canNpTakeDamage
	 **/
	@Test
	public void testCanNpTakeDamage2() {
		NonPlayer np = new NonPlayer(0);
		np.health = 5;
		assertTrue(np.canNpTakeDamage(6));
		assertTrue(np.health == 0);
	}
	
	/**
	 * Test for MapPoint.equals
	 **/
	@Test
	public void testEquals1() {
		MapPoint mp1 = new MapPoint(1,1);
		MapPoint mp2 = mp1;
		assertTrue(mp2.equals(mp1));
	}
	
	/**
	 * Test for MapPoint.equals
	 **/
	@Test
	public void testEquals2() {
		MapPoint mp1 = new MapPoint(1,1);
		MapPoint mp2 = new MapPoint(1,1);
		assertTrue(mp2.equals(mp1));
	}
	
	/**
	 * Test for MapPoint.equals
	 **/
	@Test
	public void testEquals3() {
		MapPoint mp1 = new MapPoint(1,2);
		MapPoint mp2 = new MapPoint(2,1);
		assertFalse(mp2.equals(mp1));
	}
	
	/**
	 * Test for StarSystem.distanceToStarSystem
	 **/
	@Test
	public void testDistanceToStarSystem1() {
		StarSystem ss1 = new StarSystem("Earth");
		ss1.setLocation(new MapPoint(0,3));
		StarSystem ss2 = new StarSystem("Mars");
		ss2.setLocation(new MapPoint(4,0));
		assertTrue(ss1.distanceToStarSystem(ss2) == 5);
	}
	
	/**
	 * Test for StarSystem.distanceToStarSystem
	 */
	@Test
	public void testDistanceToStarSystem2() {
		StarSystem ss1 = new StarSystem("Earth");
		ss1.setLocation(new MapPoint(0,3));
		StarSystem ss2 = new StarSystem("Mars");
		ss2.setLocation(new MapPoint(0,3));
		assertTrue(ss1.distanceToStarSystem(ss2) == 0);
	}
	
	private static final int WATER_GENER = 31, DRUGS_GENER = 26,
			MEDS_GENER = 21, WEPS_GENER = 16, ROBOT_GENER = 11;
	
	/**
	 * Test for StarSystem.generateCargo with techLevel = 0
	 **/
	@Test
	public void generateCargo1() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		StarSystem ss = new StarSystem("Earth");
		Field cargo = StarSystem.class.getDeclaredField("cargo");
		cargo.setAccessible(true);
		Field techLevel = StarSystem.class.getDeclaredField("techLevel");
		techLevel.setAccessible(true);
		techLevel.set(ss, 0);
		cargo.set(ss, new int[CargoPanel.NUM_ARRAY_SUPPLY]);
		ss.generateCargo();
		int[] cargoValue = (int[]) cargo.get(ss);
		assertTrue(cargoValue[CargoPanel.WATER] < WATER_GENER);
		assertTrue(cargoValue[CargoPanel.FOOD] == 0);
		assertTrue(cargoValue[CargoPanel.DRUGS] == 0);
		assertTrue(cargoValue[CargoPanel.WEAPONS] == 0);
		assertTrue(cargoValue[CargoPanel.MEDS] == 0);
		assertTrue(cargoValue[CargoPanel.ROBOTS] == 0);
	}
	
	/**
	 * Test for StarSystem.generateCargo with techLevel = 1
	 **/
	@Test
	public void generateCargo2() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		StarSystem ss = new StarSystem("Earth");
		Field cargo = StarSystem.class.getDeclaredField("cargo");
		cargo.setAccessible(true);
		Field techLevel = StarSystem.class.getDeclaredField("techLevel");
		techLevel.setAccessible(true);
		techLevel.set(ss, 1);
		cargo.set(ss, new int[CargoPanel.NUM_ARRAY_SUPPLY]);
		ss.generateCargo();
		int[] cargoValue = (int[]) cargo.get(ss);
		assertTrue(cargoValue[CargoPanel.WATER] < WATER_GENER);
		assertTrue(cargoValue[CargoPanel.FOOD] < WATER_GENER);
		assertTrue(cargoValue[CargoPanel.DRUGS] == 0);
		assertTrue(cargoValue[CargoPanel.WEAPONS] == 0);
		assertTrue(cargoValue[CargoPanel.MEDS] == 0);
		assertTrue(cargoValue[CargoPanel.ROBOTS] == 0);
	}
	
	/**
	 * Test for StarSystem.generateCargo with techLevel = 3
	 **/
	@Test
	public void generateCargo3() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		StarSystem ss = new StarSystem("Earth");
		Field cargo = StarSystem.class.getDeclaredField("cargo");
		cargo.setAccessible(true);
		Field techLevel = StarSystem.class.getDeclaredField("techLevel");
		techLevel.setAccessible(true);
		techLevel.set(ss, 3);
		cargo.set(ss, new int[CargoPanel.NUM_ARRAY_SUPPLY]);
		ss.generateCargo();
		int[] cargoValue = (int[]) cargo.get(ss);
		assertTrue(cargoValue[CargoPanel.WATER] < WATER_GENER);
		assertTrue(cargoValue[CargoPanel.FOOD] < WATER_GENER);
		assertTrue(cargoValue[CargoPanel.DRUGS] < DRUGS_GENER);
		assertTrue(cargoValue[CargoPanel.WEAPONS] == 0);
		assertTrue(cargoValue[CargoPanel.MEDS] == 0);
		assertTrue(cargoValue[CargoPanel.ROBOTS] == 0);
	}
	/**
	 * Test for StarSystem.generateCargo with techLevel = 4
	 **/
	@Test
	public void generateCargo4() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		StarSystem ss = new StarSystem("Earth");
		Field cargo = StarSystem.class.getDeclaredField("cargo");
		cargo.setAccessible(true);
		Field techLevel = StarSystem.class.getDeclaredField("techLevel");
		techLevel.setAccessible(true);
		techLevel.set(ss, 4);
		cargo.set(ss, new int[CargoPanel.NUM_ARRAY_SUPPLY]);
		ss.generateCargo();
		int[] cargoValue = (int[]) cargo.get(ss);
		assertTrue(cargoValue[CargoPanel.WATER] < WATER_GENER);
		assertTrue(cargoValue[CargoPanel.FOOD] < WATER_GENER);
		assertTrue(cargoValue[CargoPanel.DRUGS] < DRUGS_GENER);
		assertTrue(cargoValue[CargoPanel.WEAPONS] < WEPS_GENER);
		assertTrue(cargoValue[CargoPanel.MEDS] < MEDS_GENER);
		assertTrue(cargoValue[CargoPanel.ROBOTS] == 0);
	}
	/**
	 * 	Test for StarSystem.generateCargo with techLevel = 6
	 **/
	@Test
	public void generateCargo5() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		StarSystem ss = new StarSystem("Earth");
		Field cargo = StarSystem.class.getDeclaredField("cargo");
		cargo.setAccessible(true);
		Field techLevel = StarSystem.class.getDeclaredField("techLevel");
		techLevel.setAccessible(true);
		techLevel.set(ss, 6);
		cargo.set(ss, new int[CargoPanel.NUM_ARRAY_SUPPLY]);
		ss.generateCargo();
		int[] cargoValue = (int[]) cargo.get(ss);
		assertTrue(cargoValue[CargoPanel.WATER] < WATER_GENER);
		assertTrue(cargoValue[CargoPanel.FOOD] < WATER_GENER);
		assertTrue(cargoValue[CargoPanel.DRUGS] < DRUGS_GENER);
		assertTrue(cargoValue[CargoPanel.WEAPONS] < WEPS_GENER);
		assertTrue(cargoValue[CargoPanel.MEDS] < MEDS_GENER);
		assertTrue(cargoValue[CargoPanel.ROBOTS] < ROBOT_GENER);
	}
	
	/**
	 * Test for ConfigPanel.createPlayer
	 **/
	@Test
	public void testCreatePlayer() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		ConfigPanel cp = new ConfigPanel(null);
		Field pilotSpinner = ConfigPanel.class.getDeclaredField("pilotSpinner");
		pilotSpinner.setAccessible(true);
		Field fighterSpinner = ConfigPanel.class.getDeclaredField("fighterSpinner");
		fighterSpinner.setAccessible(true);
		Field traderSpinner = ConfigPanel.class.getDeclaredField("traderSpinner");
		traderSpinner.setAccessible(true);
		Field engineerSpinner = ConfigPanel.class.getDeclaredField("engineerSpinner");
		engineerSpinner.setAccessible(true);
		Field nameInput = ConfigPanel.class.getDeclaredField("nameInput");
		nameInput.setAccessible(true);
		JSpinner pilotSpinnerValue = new JSpinner();
		pilotSpinnerValue.setValue(12);
		JSpinner fighterSpinnerValue = new JSpinner();
		fighterSpinnerValue.setValue(13);
		JSpinner traderSpinnerValue = new JSpinner();
		traderSpinnerValue.setValue(14);
		JSpinner engineerSpinnerValue = new JSpinner();
		engineerSpinnerValue.setValue(15);
		JTextField nameInputValue = new JTextField();
		nameInputValue.setText("Eric");
		pilotSpinner.set(cp, pilotSpinnerValue);
		fighterSpinner.set(cp, fighterSpinnerValue);
		traderSpinner.set(cp, traderSpinnerValue);
		engineerSpinner.set(cp, engineerSpinnerValue);
		nameInput.set(cp, nameInputValue);
		Player p = cp.createPlayer();
		assertEquals(p.pilotp, 12);
		assertEquals(p.fighterp, 13);
		assertEquals(p.traderp, 14);
		assertEquals(p.enggp, 15);
		assertEquals(p.name, "Eric");
	}
}