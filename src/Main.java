import javafx.application.Application;
import jeu.Joueur;
import javafx.stage.Stage;
import menu.MenuFrame;


public class Main extends Application {

   public void start(Stage primaryStage){
       Joueur j1 = new Joueur();
       MenuFrame mF = new MenuFrame(j1);
       mF.start(primaryStage);
    }
}


