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
        j1.constuireVille();
        j1.constuireVille();

        /*Date date = new Date();
        Date d1 = new Date(2020,06,20,25,06);
        System.out.println(date.getDay());*/
    }

   /* public void start(Stage primaryStage){
        MenuFrame mF = new MenuFrame();
        mF.start(primaryStage);
    }*/
}

