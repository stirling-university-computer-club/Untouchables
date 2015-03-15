

import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    private ApplicationContext applicationContext;
 
 
    //
    public static void main(String[] args)
    {
    	LeapController.createLeap(null);
        Main game = new Main();
        game.setShowSettings(false);
        game.start();
        LeapController.render();
    }
 
    @Override
    public void simpleInitApp()
    {
        this.applicationContext = new ApplicationContext(stateManager, assetManager, settings, inputManager, rootNode, cam, flyCam);
        //
        stateManager.attach(applicationContext);
    }
    
    public static void gettCamera(){
        
    }
    
}
