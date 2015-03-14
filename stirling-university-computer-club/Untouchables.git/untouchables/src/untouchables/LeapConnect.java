package untouchables;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Listener;

public class LeapConnect extends Listener{
	
	Controller controller = new Controller();
	// !!!


	
	public void Controller_addListener(){
		
	}
	
    public void onConnect(Controller controller) {
        System.out.println("Connected");
        controller.enableGesture(Gesture.Type.TYPE_SWIPE);
	}

    public void onFrame(Controller controller) {
        System.out.println("Frame available");
    }
}
