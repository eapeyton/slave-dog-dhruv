/**
 * File Comment
 */

package edu.gatech.oad.antlab.person;

/**
 * A simple class for person 1 returns their name and a modified string
 * 
 * @author Bob
 * @version 1.1
 */
public class Person1 {
	/** Holds the persons real name */
	private String name;

	/**
	 * The constructor, takes in the persons name
	 * 
	 * @param pname
	 *            the person's real name
	 */
	public Person1(String pname) {
		name = pname;
	}

	/**
	 * This method should take the string input and return its characters
	 * rotated 2 positions. given "gtg123b" it should return "g123bgt".
	 * 
	 * @param input
	 *            the string to be modified
	 * @return the modified string
	 */
	private String calc(String input) {

		char f[] = input.toCharArray();
		char charA, charB;

		charA = f[0];
		charB = f[1];

		for (int i = 0; i < f.length - 2; i++) {
			f[i] = f[i + 2];
		}

		f[f.length - 1] = charB;
		f[f.length - 2] = charA;

		return new String(f);
	}

	/**
	 * Return a string rep of this object that varies with an input string
	 * 
	 * @param input
	 *            the varying string
	 * @return the string representing the object
	 */
	public String toString(String input) {
		return name + calc(input);
	}

}
