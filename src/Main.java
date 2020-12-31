import batiments.Batiment;
import batiments.Citerne;
import batiments.Mine;
import javafx.application.Application;
import javafx.stage.Stage;
import menu.MenuFrame;
import planete.Ville;

import java.util.ArrayList;

public class Main{ //extends Application {

  public static void main(String[] args) {
        Ville a = new Ville("Paris");
        Mine alpha = new Mine("Alpha");
        Mine beta = new Mine("beta");
        Citerne cite = new Citerne("cite");

        a.ajoutMine(alpha);
        a.ajoutMine(beta);
        a.ajoutCiterne(cite);
        System.out.println(a);
        a.supprimerBatiment(cite);
        System.out.println(a);
    }

   /* public void start(Stage primaryStage){
        MenuFrame mF = new MenuFrame();
        mF.start(primaryStage);
    }*/
}