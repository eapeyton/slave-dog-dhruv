/**
 * File Comment
 */
package edu.gatech.oad.antlab.person;

import java.util.*;

/**
 *  A simple class for person 2
 *  returns their name and a
 *  modified string 
 *
 * @author Bob
 * @version 1.1
 */
public class Person2 {
    /** Holds the persons real name */
    private String name;
	 	/**
	 * The constructor, takes in the persons
	 * name
	 * @param pname the person's real name
	 */
	 public Person2(String pname) {
	   name = pname;
	 }
	/**
	 * This method should take the string
	 * input and return its characters in
	 * random order.
	 * given "gtg123b" it should return
	 * something like "g3tb1g2".
	 *
	 * @param input the string to be modified
	 * @return the modified string
	 */
	private String calc(String input) {
    	String output = "";
		while (input.length() > 0) {
    		Random generator = new Random();
    		int index = generator.nextInt(input.length());
    		output = output + input.charAt(index);
    		if (index < input.length()-1 && index > 0) {
    			input = input.substring(0, index).concat(input.substring(index+1));
    		}
    		else if (index < input.length()-1) {
    			input = input.substring(index + 1);
    		}
    		else if (index > 0) {
    			input = input.substring(0, index);
    		}
    		else {
    			input = "";
    		}
    	}
		return output;
	}
	/**
	 * Return a string rep of this object
	 * that varies with an input string
	 *
	 * @param input the varying string
	 * @return the string representing the 
	 *         object
	 */
	public String toString(String input) {
	  return name + calc(input);
	}
}