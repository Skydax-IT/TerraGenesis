import batiments.Batiment;
import jeu.Joueur;
import technologies.Technologie;


public class Main{ //extends Application {

    public static void main(String[] args) {


        Joueur j1 = new Joueur();
        System.out.println(j1.getTechnologieTemperature());
        j1.ameliorerTechnologie(j1.getTechnologieTemperature().get(1));
        j1.askForString("AAAA");
        System.out.println(j1.getTechnologieTemperature());
        /*j1.construirePoste();
        j1.constuireVille();
        j1.askForString("AAAAA");
        System.out.println(j1.getPlanete().getVilles());
        j1.construireBatiment(j1.getPlanete().getVilles().get(0),new Mine());
        j1.askForString("AAAAA");
        System.out.println(j1.getPlanete().getVilles());*/


    }

   /* public void start(Stage primaryStage){
        MenuFrame mF = new MenuFrame();
        mF.start(primaryStage);
    }*/
}

