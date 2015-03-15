import com.leapmotion.leap.Controller;
import com.leapmotion.leap.FingerList;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.HandList;
import com.leapmotion.leap.Image;
import com.leapmotion.leap.ImageList;
import com.leapmotion.leap.InteractionBox;
import com.leapmotion.leap.Listener;
import com.leapmotion.leap.PointableList;
import com.leapmotion.leap.ToolList;

public class Leap extends Listener{

    public static void main(String[] args) {
        // Create a sample listener and controller
    	Controller controller = new Controller();
        Frame f = controller.frame();
        float instantaneousFrameRate = f.currentFramesPerSecond();
        InteractionBox box = f.interactionBox();
        Gesture newGesture = new Gesture();
        
        controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
        controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
        controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
        controller.enableGesture(Gesture.Type.TYPE_SWIPE);
       
        HandList hands =f.hands();
        PointableList pointables = f.pointables();
        FingerList fingers = f.fingers();
        
        ToolList tools = f.tools();
        System.out.println(f);
        long lastFrameID = 0;
        if( f.id() != lastFrameID )
            //...
            lastFrameID = f.id();
       
    
       
        
        	switch (newGesture.type())
        {
        case TYPE_CIRCLE:
        	System.out.println("Hello");
        	
        	break;
        case TYPE_KEY_TAP:
        	System.out.print("Key Tap");
        	
        	break;
        case TYPE_SCREEN_TAP:
        	System.out.print("Screen Tap");
        	
        	break;
        case TYPE_SWIPE:
        	System.out.print("Swipe");
        	
        break;
        default:
        break;
        }
       
        
        
        if(controller.isConnected()){
        	System.out.println("Leap is connected");
        }
        
    
     
            
        
        
   
        // Have the sample listener receive events from the controller
        //controller.addListener(listener);

        // Keep this process running until Enter is pressed
    //    System.out.println("Press Enter to quit...");
      //  try {
      //      System.in.read();
     //   } catch (Exception e) {
        //    e.printStackTrace();
     //   }

        // Remove the sample listener when done
     
        // controller.removeListener(listener);
        System.out.println("End");
    }
 
    
    
}