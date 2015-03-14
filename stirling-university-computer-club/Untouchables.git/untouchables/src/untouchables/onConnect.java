package untouchables;

import com.leapmotion.leap.Controller;

public class onConnect {
	public void onconnect(Controller controller) {
	    System.out.println("Connected");
	    controller.enableGesture(Gesture.Type.TYPE_SWIPE);
	}
}
