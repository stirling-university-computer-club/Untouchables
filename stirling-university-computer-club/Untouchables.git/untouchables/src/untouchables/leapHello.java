package untouchables;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Listener;

public class leapHello extends Listener{

    public static void main(String[] args) {
        // Create a sample listener and controller
       // SampleListener listener = new SampleListener();
        Controller controller = new Controller();
        Frame f = controller.frame();
        System.out.println(f);

        // Have the sample listener receive events from the controller
        //controller.addListener(listener);

        // Keep this process running until Enter is pressed
        System.out.println("Press Enter to quit...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Remove the sample listener when done
        // controller.removeListener(listener);
    }
}