package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.util.SkyFactory;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    private Spatial firstSceneModel;
            
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {

        initBox();
        initScene();
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }

    private void initBox() {
        Box b = new Box(1, 1, 1);
        Geometry geom = new Geometry("Box", b);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);

        flyCam.setMoveSpeed(20f);
        rootNode.attachChild(geom);
    }

    private void initScene() {
        firstSceneModel = assetManager.loadModel("Scenes/myScene.j3o");
        rootNode.attachChild(firstSceneModel);
    
        /** A white ambient light source. */ 
    AmbientLight ambient = new AmbientLight();
    ambient.setColor(ColorRGBA.White);
    rootNode.addLight(ambient); 
        /** A white, directional light source */ 
   
    DirectionalLight sun = new DirectionalLight();
    sun.setDirection((new Vector3f(-0.5f, -0.5f, -0.5f)).normalizeLocal());
    sun.setColor(ColorRGBA.White);
    rootNode.addLight(sun); 
    
    rootNode.attachChild(SkyFactory.createSky(assetManager,
            assetManager.loadTexture("Textures/skys/miramar_ft.jpg"),
            assetManager.loadTexture("Textures/skys/miramar_bk.jpg"),
            assetManager.loadTexture("Textures/skys/miramar_lf.jpg"),
            assetManager.loadTexture("Textures/skys/miramar_rt.jpg"),
            assetManager.loadTexture("Textures/skys/miramar_up.jpg"),
            assetManager.loadTexture("Textures/skys/miramar_dn.jpg")));
    
    /* Load a tree model */
    Spatial treeGeo = assetManager.loadModel("Models/Tree/Tree.mesh.j3o");
    treeGeo.scale(5); // make tree bigger
    treeGeo.setQueueBucket(RenderQueue.Bucket.Transparent); // leaves are transparent
    rootNode.attachChild(treeGeo);
    /* Place the tree at (0,?,-30) on the terrain. What is the y value? */
    Vector3f treeLoc = new Vector3f(0,0,-30);
    /* Don't use terrain.getLocalTranslation() to determine y! */
    //treeLoc.setY( terrain.getLocalTranslation().getY() ); // tree stuck in hill!
    /* Use terrain.getHeight() to determine y! */
    treeGeo.setLocalTranslation(treeLoc);
    
    }
}
