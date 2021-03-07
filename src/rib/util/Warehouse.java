package rib.util;

import java.util.Calendar;
import java.util.Scanner;

public class Warehouse {
	Scanner scanner = new Scanner(System.in);

	public void exit() {
		String answer;
		do {
			System.out.println("Sunteti sigur ca doriti sa parasiti contul?");
			System.out.print("Answer (yes or no): ");
			answer = scanner.next();
			switch (answer.toLowerCase()) {
			case "yes": {
				System.err.println("La revedere!");
				System.exit(0);
				break;
			}
			case "no": {
				break;
			}
			default: {
				System.err.println("Optiunea introdusa este inexistenta!");
			}
			}
		} while (!answer.toLowerCase().equals("no"));
	}

	public void hello() {
		Calendar calendar = Calendar.getInstance();
		int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		if (timeOfDay >= 0 && timeOfDay < 12) {
			System.out.println("\nGood morning!\n");
		} else if (timeOfDay >= 12 && timeOfDay < 16) {
			System.out.println("\nGood afternoon!\n");
		} else if (timeOfDay >= 16 && timeOfDay < 24) {
			System.out.println("\nGood evening!\n");
		}
	}

	public void progressBar() {
		char[] animationChars = new char[] { '|', '/', '-', '\\' };
		for (int i = 0; i <= 100; i++) {
			System.out.print("Processing: " + i + "% " + animationChars[i % 4] + "\r");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print("Processing: ");
	}
}
