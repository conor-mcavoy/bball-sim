package core;

import java.util.Random;

/**
 * @author Conor
 *
 */
public class Player {
	private final String firstName;
	private final String lastName;
	
	enum Handedness { LEFT, BOTH, RIGHT; }
	// immutable stats
	private Handedness handedness;
	
	public Player (String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		initializeStats();
	}
	
	private void initializeStats() {
		double[] handednessDistribution = { 0.09, 0.01, 0.90 }; // assumes 90% of people are righty, 9% are lefty
		Random rand = new Random();
		double randomNum = rand.nextFloat();
		
		double total = 0.0;
		int index = 0;
		for (Handedness h: Handedness.values()) {
			double weight = handednessDistribution[index];
			total += weight;
			if (randomNum < total) {
				this.handedness = h;
				break;
			}
			index++;
		}
	}

	public String getFullName () {
		return firstName + " " + lastName;
	}
	
	public Handedness getHandedness () {
		return handedness;
	}
}
