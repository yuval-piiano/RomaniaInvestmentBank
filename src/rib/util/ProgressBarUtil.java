package rib.util;

public class ProgressBarUtil {
	public void bar() {
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
