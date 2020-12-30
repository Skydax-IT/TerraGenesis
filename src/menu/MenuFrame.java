package menu;
import javafx.animation.AnimationTimer;
//import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class MenuFrame /*extends Application*/{

    /**
     * Default constructor
     */
    public MenuFrame() {
    }

    /**
     *
     */
    private MenuController menuController;




    /**
     *
     */
    public void MenuFrame() {
        // TODO implement here
    }

    private static final float WIDTH = 1200;
    private static final float HEIGHT = 600;

    private final Sphere sphere = new Sphere(175);

    //@Override
    public void start(Stage primaryStage) {
        Camera camera = new PerspectiveCamera(true);
        camera.setNearClip(1);
        camera.setFarClip(10000);
        camera.translateZProperty().set(-1000);

        Group world = new Group();
        world.getChildren().add(prepareEarth());

        Group root = new Group();
        root.getChildren().add(world);
        root.getChildren().add(prepareImageView());

        Scene scene = new Scene(root, WIDTH, HEIGHT, true);
        scene.setFill(Color.SILVER);
        scene.setCamera(camera);

        primaryStage.setTitle("TerraGenesis");
        primaryStage.setScene(scene);
        primaryStage.show();

        prepareAnimation();
    }

    private void prepareAnimation() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                sphere.rotateProperty().set(sphere.getRotate() + 0.2);
            }
        };
        timer.start();
    }

    private ImageView prepareImageView() {
        Image image = new Image(getClass().getResourceAsStream("/resources/galaxy.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.getTransforms().add(new Translate(-image.getWidth() / 2, -image.getHeight() / 2, 700));
        return imageView;
    }

    private Node prepareEarth() {
        PhongMaterial earthMaterial = new PhongMaterial();
        earthMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("/resources/planet.jpg")));


        sphere.setRotationAxis(Rotate.Y_AXIS);
        sphere.setMaterial(earthMaterial);
        return sphere;
    }

}