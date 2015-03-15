/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jme3.animation.AnimControl;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.debug.Arrow;
import com.jme3.scene.debug.Grid;
import com.jme3.scene.debug.SkeletonDebugger;
import com.jme3.scene.shape.Line;
 
/*
 Chase camera (aka 3rd person camera) example
 Based on official TestQ3.java
 
 @author Alex Cham aka Jcrypto
 */
public class Debug
{
 
    public static void showNodeAxes(AssetManager am, Node n, float axisLen)
    {
        Vector3f v = new Vector3f(axisLen, 0, 0);
        Arrow a = new Arrow(v);
        Material mat = new Material(am, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Red);
        Geometry geom = new Geometry(n.getName() + "XAxis", a);
        geom.setMaterial(mat);
        n.attachChild(geom);
 
 
        //
        v = new Vector3f(0, axisLen, 0);
        a = new Arrow(v);
        mat = new Material(am, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Green);
        geom = new Geometry(n.getName() + "YAxis", a);
        geom.setMaterial(mat);
        n.attachChild(geom);
 
 
        //
        v = new Vector3f(0, 0, axisLen);
        a = new Arrow(v);
        mat = new Material(am, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom = new Geometry(n.getName() + "ZAxis", a);
        geom.setMaterial(mat);
        n.attachChild(geom);
    }
 
    //
    public static void showVector3fArrow(AssetManager am, Node n, Vector3f v, ColorRGBA color, String name)
    {
        Arrow a = new Arrow(v);
        Material mat = MaterialUtils.makeMaterial(am, "Common/MatDefs/Misc/Unshaded.j3md", color);
        Geometry geom = SpatialUtils.makeGeometry(a, mat, name);
        n.attachChild(geom);
    }
 
    public static void showVector3fLine(AssetManager am, Node n, Vector3f v, ColorRGBA color, String name)
    {
        Line l = new Line(v.subtract(v), v);
        Material mat = MaterialUtils.makeMaterial(am, "Common/MatDefs/Misc/Unshaded.j3md", color);
        Geometry geom = SpatialUtils.makeGeometry(l, mat, name);
        n.attachChild(geom);
    }
 
//Skeleton Debugger
    public static void attachSkeleton(AssetManager am, Node player, AnimControl control)
    {
        SkeletonDebugger skeletonDebug = new SkeletonDebugger("skeleton", control.getSkeleton());
        Material mat2 = new Material(am, "Common/MatDefs/Misc/Unshaded.j3md");
        mat2.setColor("Color", ColorRGBA.Yellow);
        mat2.getAdditionalRenderState().setDepthTest(false);
        skeletonDebug.setMaterial(mat2);
        player.attachChild(skeletonDebug);
    }
 
    ///
    public static void attachWireFrameDebugGrid(AssetManager assetManager, Node n, Vector3f pos, Integer size, ColorRGBA color)
    {
        Geometry g = new Geometry("wireFrameDebugGrid", new Grid(size, size, 1.0f));//1WU
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.getAdditionalRenderState().setWireframe(true);
        mat.setColor("Color", color);
        g.setMaterial(mat);
        g.center().move(pos);
        n.attachChild(g);
    }
}