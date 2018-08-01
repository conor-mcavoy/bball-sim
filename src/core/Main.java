package core;

/**
 * @author Conor
 *
 */
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	private static List<String> firstNames = new ArrayList<String>();
	private static List<String> lastNames = new ArrayList<String>();
	
	public static void main (String args[]) {
		try {
			loadNames();
		} catch (IOException exception) {
			System.out.println("Failed to load names.");
			System.out.println(exception);
			System.exit(1);
		}
		
		Player p = generatePlayer();
		System.out.println("Player name: " + p.getFullName());
		System.out.println("Player handedness: " + p.getHandedness());
	}
	
	private static Player generatePlayer() {
		Random rand = new Random();
		String randomFirstName = firstNames.get(rand.nextInt(firstNames.size()));
		String randomLastName = lastNames.get(rand.nextInt(lastNames.size()));
		
		return new Player(randomFirstName, randomLastName);
	}

	private static void loadNames () throws IOException {
		
		Path firstNamesPath = Paths.get("src", "data", "firstNames.txt");
		Path lastNamesPath = Paths.get("src", "data", "lastNames.txt");
		
		Scanner firstNamesScanner = new Scanner(firstNamesPath);
		while (firstNamesScanner.hasNextLine()) {
			firstNames.add(firstNamesScanner.nextLine());
		}
		firstNamesScanner.close();
		
		Scanner lastNamesScanner = new Scanner(lastNamesPath);
		while (lastNamesScanner.hasNextLine()) {
			lastNames.add(lastNamesScanner.nextLine());
		}
		lastNamesScanner.close();
	}
}
