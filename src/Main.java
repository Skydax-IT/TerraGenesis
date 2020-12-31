import batiments.Batiment;
import batiments.Citerne;
import batiments.Mine;
import javafx.application.Application;
import javafx.stage.Stage;
import jeu.Joueur;
import menu.MenuFrame;
import planete.Ville;

public class Main{ //extends Application {

    public static void main(String[] args) {
        Joueur player1 = new Joueur();
        player1.constuireVille();

    }

   /* public void start(Stage primaryStage){
        MenuFrame mF = new MenuFrame();
        mF.start(primaryStage);
    }*/
}

