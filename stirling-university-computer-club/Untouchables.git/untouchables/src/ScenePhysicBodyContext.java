/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jme3.app.Application;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.scene.Node;
 
/*
 Chase camera (aka 3rd person camera) example
 Based on official TestQ3.java
 
 @author Alex Cham aka Jcrypto
 */
public class ScenePhysicBodyContext extends AbstractPhysicBodyContext
{
    private final RigidBodyControl rigidBodyControl;
    private final Node scene;
 
/**
 
    @param scene 
    */
    public ScenePhysicBodyContext(Node scene)
    {
        this.scene = scene;
        this.rigidBodyControl = new RigidBodyControl(.0f);       
    }
 
 
    @Override
    public void initialize(AppStateManager stateManager, Application app)
    {
        //
        //Add scene to PhysicsSpace
        System.out.println(this.getClass().getName() + ".getBulletAppState().hashCode() = " + getBulletAppState().hashCode());
        scene.addControl(rigidBodyControl);
        getBulletAppState().getPhysicsSpace().addAll(scene);
    }
 
}