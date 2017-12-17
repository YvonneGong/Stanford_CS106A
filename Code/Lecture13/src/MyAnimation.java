import acm.program.*;
import acm.graphics.*;
import java.awt.*;

// A sample animation program
public class MyAnimation extends GraphicsProgram {
	public void run() {
		setBackground(Color.YELLOW);
		
		GRect rect = new GRect(100, 50, 100, 100);
		rect.setFilled(true);
		rect.setColor(Color.BLUE);
		add(rect);
		
		// animate to the right
		while (rect.getX() + rect.getWidth() <= getWidth()) {
			rect.move(5, 0);
			pause(15);
		}
		
		// animate back to the left
		while (rect.getX() > 0) {
			rect.move(-5, 0);
			pause(15);
		}
	}
}
