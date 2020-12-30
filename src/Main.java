import javafx.application.Application;
import javafx.stage.Stage;
import menu.MenuFrame;
import planete.Ville;

public class Main{ //extends Application {

    public static void main(String[] args) {
        Ville a = new Ville();
        a.ajouterBatiment(1);
        a.ajouterBatiment(1);
        a.ajouterBatiment(1);

        a.afficherBatiments();
        a.supprimerBatiment("a");
        a.afficherBatiments();
    }
/*
    public void start(Stage primaryStage){
        MenuFrame mF = new MenuFrame();
        mF.start(primaryStage);
    }*/
}