package zzusable;

import org.testng.annotations.Test;
import java.awt.event.KeyEvent;


public class Robot {
	@Test
	public static void test() {
		Robot robot = new Robot();
		for(int i =0;i<3;i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);

	}

}
    // Not Important //
	public void keyPress(int vkSubtract) {
		// TODO Auto-generated method stub
		
	}

	public void keyRelease(int vkControl) {
		// TODO Auto-generated method stub
		
	}
	@Test
	public static void test2() {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
	}


}
