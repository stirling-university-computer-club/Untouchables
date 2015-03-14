	package untouchables;
	import java.io.IOException;
	import com.leapmotion.leap.*;
	public class leapmotion {
    public static void main(){
	        
	   // Keep this process running until Enter is pressed
	
    	System.out.println("Press Enter to quit...");
	        try {
	            System.in.read();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
   }
}