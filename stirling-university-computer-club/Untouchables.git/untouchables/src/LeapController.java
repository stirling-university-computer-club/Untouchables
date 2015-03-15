import java.io.IOException;

import com.leapmotion.leap.Controller;



public class LeapController {
	
	public static void createLeap(String[] args) {
	
		LeapListener listener = new LeapListener();
		Controller controller = new Controller();
		controller.addListener(listener);
	}
	public static void render(){
		System.out.println("Press enter to quit");
		try {
			System.in.read();
		} catch (IOException e){
		}
	}
}
