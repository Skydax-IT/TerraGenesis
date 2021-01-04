import batiments.Batiment;
import batiments.Citerne;
import batiments.Mine;
import javafx.application.Application;
import javafx.stage.Stage;
import jeu.Joueur;
import menu.MenuFrame;
import planete.Ville;

import java.util.Date;


public class Main{ //extends Application {

    public static void main(String[] args) {


        Joueur j1 = new Joueur();
        /*j1.construirePoste();
        j1.constuireVille();
        j1.askForString("AAAAA");
        System.out.println(j1.getPlanete().getVilles());
        j1.construireBatiment(j1.getPlanete().getVilles().get(0),new Mine());
        j1.askForString("AAAAA");
        System.out.println(j1.getPlanete().getVilles());*/

        System.out.println(j1.getPlanete());

    }

   /* public void start(Stage primaryStage){
        MenuFrame mF = new MenuFrame();
        mF.start(primaryStage);
    }*/
}

