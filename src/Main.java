import javafx.application.Application;
import javafx.stage.Stage;
import menu.MenuFrame;

public class Main extends Application {

    public void start(Stage primaryStage){
        MenuFrame mF = new MenuFrame();
        mF.start(primaryStage);
    }
}