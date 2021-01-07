import batiments.Batiment;
import batiments.Mine;
import jeu.Joueur;
import technologies.Technologie;


public class Main{ //extends Application {

    public static void main(String[] args) throws InterruptedException {


        Joueur j1 = new Joueur();
        j1.constuireVille();
        Thread.sleep(6000);
        j1.construireBatiment(j1.getPlanete().getVilles().get(0),j1.getTechnologieBiomasse().get(1).get(1).getBatiment(),1);
        Thread.sleep(6000);
        System.out.println(j1.getPlanete());
        j1.construirePoste();
        Thread.sleep(9000);
        j1.construireMinePoste(j1.getPlanete().getPostes().get(0), j1.getTechnologieMine().get(0).getMine());
        Thread.sleep(4000);
        System.out.println(j1.getPlanete());
    }

   /* public void start(Stage primaryStage){
        MenuFrame mF = new MenuFrame();
        mF.start(primaryStage);
    }*/
}

