package rib.util;

import java.util.Calendar;

public class HelloUtil {
	public void hello() {
		Calendar calendar = Calendar.getInstance();
		int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		if (timeOfDay >= 0 && timeOfDay < 12) {
			System.out.println("Good morning!\n");
		} else if (timeOfDay >= 12 && timeOfDay < 16) {
			System.out.println("Good afternoon!\n");
		} else if (timeOfDay >= 16 && timeOfDay < 24) {
			System.out.println("Good evening!\n");
		}
	}
}
