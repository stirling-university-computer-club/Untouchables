/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jme3.app.Application;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
 
/*
 Chase camera (aka 3rd person camera) example
 Based on official TestQ3.java
 
 @author Alex Cham aka Jcrypto
 */
public class SceneBodyManager extends AbstractPhysicBodyContext
{
 
    private final ScenePhysicBodyContext spbc;
    private final SceneSpatialBodyContext ssbc;
 
/**
 
    @param stateManager
    @param am
    @param rootNode 
    */
    public SceneBodyManager(AppStateManager stateManager, AssetManager am, Node rootNode)
    {
 
 
        this.ssbc = new SceneSpatialBodyContext(am, rootNode);
        this.spbc = new ScenePhysicBodyContext(ssbc.getScene());
    }
 
    @Override
    public void initialize(AppStateManager stateManager, Application app)
    {
 
        //PhysicsSpace Initialization
        attachBulletAppstate(stateManager);
//
        stateManager.attach(this.ssbc);
        stateManager.attach(this.spbc);
 
    }
}