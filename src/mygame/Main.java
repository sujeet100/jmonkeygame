package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
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
        firstSceneModel = assetManager.loadModel("Scenes/firstScene.j3o");
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
            assetManager.loadTexture("Textures/skys/stormydays_ft.jpg"),
            assetManager.loadTexture("Textures/skys/stormydays_bk.jpg"),
            assetManager.loadTexture("Textures/skys/stormydays_lf.jpg"),
            assetManager.loadTexture("Textures/skys/stormydays_rt.jpg"),
            assetManager.loadTexture("Textures/skys/stormydays_up.jpg"),
            assetManager.loadTexture("Textures/skys/stormydays_dn.jpg")));
    
    
    }
}
