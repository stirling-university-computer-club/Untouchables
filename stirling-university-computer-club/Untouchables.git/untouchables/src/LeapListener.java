import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;
import com.leapmotion.leap.Gesture.Type;

import java.io.IOException;




import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Listener;
public class LeapListener extends Listener{
	public void onInit(Controller controller){
		System.out.println("Initialised");
}
public void onConnect(Controller controller){
	System.out.println("Connected to motion sensor");
	controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
	controller.enableGesture(Gesture.Type.TYPE_SWIPE);
	controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
	controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
}
public void onDisconnect(Controller controller) {
	System.out.println("Motion sensor disconnected");
}
public void onExit(Controller controller){ 
	System.out.println("Exitited");
	
}
public void onFrame (Controller controller){
	Frame frame = controller.frame();
	/*System.out.println("Frame id " + frame.id() 
			+ " , Timestamp: " + frame.timestamp()
			+ " , Hands: " + frame.hands().count()
		    + ", Fingers: " + frame.fingers().count() // Hands will always have five/ten fingers. 
			+ ", Tools: " + frame.tools().count()

		    + ", Gestures: " + frame.gestures().count());*/
	String handType = new String();
	/*for (Hand hand : frame.hands()){
		handType = hand.isLeft() ? "Left Hand" : "Right Hand";
		System.out.println(handType + " " + ", id " + hand.id()
				+", Palm position: " + hand.palmPosition());

		Vector normal = hand.palmNormal();
		Vector direction = hand.direction();

		System.out.println("Pitch: " + Math.toDegrees(direction.pitch())
				+ "Roll: " + Math.toDegrees(normal.roll())
				+ "Yaw: " + Math.toDegrees(direction.yaw()));
		}*/
	//Gesture gesture = new Gesture();
	//System.out.println(" GESTUREZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ.COUNTZ: " + gestures.count());
	for(Gesture gesture : frame.gestures()){
		if(gesture.isValid()){
			switch (gesture.type()) {
			case TYPE_CIRCLE:
				CircleGesture circle = new CircleGesture(gesture);

				String clockwiseness;
				if (circle.pointable().direction().angleTo(circle.normal()) <= Math.PI/4){
					clockwiseness = "clockwise";
					Robot.turnRight();
				} else{
					clockwiseness = "counter-clockwise";
					Robot.turnLeft();
				}
				double sweptAngle = 0;
				if (circle.state() != State.STATE_START) {
					CircleGesture previous = new CircleGesture(controller.frame(1).gesture(circle.id()));
					sweptAngle = (circle.progress() - previous.progress() * 2 * Math.PI);
				}
				System.out.println("Circle ID: " + circle.id()
						+ "State: " + circle.state()
						+ "Progress: " + circle.progress()
						+ "Radius: " + circle.radius()
						+ "Angle: " + Math.toDegrees(sweptAngle)
						+ " " + clockwiseness);
				break;

			case TYPE_SWIPE:
				SwipeGesture swipe = new SwipeGesture(gesture);
				System.out.println(" Swipe ID: " + swipe.id()
						+ " State: " + swipe.state()
						+ " Swipe Position: " + swipe.position()
						+ " Direction: " + swipe.direction()
						+ " Speed: " + swipe.speed());
						Robot.moveForward();
				break;
			case TYPE_SCREEN_TAP:
				ScreenTapGesture screenTap = new ScreenTapGesture(gesture);
				System.out.println("Tap ID: " + screenTap.id()
						+ " State: " + screenTap.state()
						+ " Position: " + screenTap.position()
						+ " Direction: " + screenTap.direction());
						Robot.jump();
				break;

			case TYPE_KEY_TAP:
				KeyTapGesture keyTap = new KeyTapGesture(gesture);
				System.out.println("Id: " + keyTap.id()
						+ " State: " + keyTap.state()
						+ " Position: " + keyTap.position()
						+ " Direction: " + keyTap.direction());
						Robot.turnAround();
				break;
			default:
				System.out.println("Unknown gesture!!!");
				break;
			}
		}
	}
}
	

public static class LeapController {
	
	public static void main(String[] args) {
	
		LeapListener listener = new LeapListener();
		Controller controller = new Controller();
	controller.addListener(listener);
	System.out.println("Press enter to quit");
	try
	{
		System.in.read();
	} catch (IOException e){
	}
	}
}
}
		
		
	






