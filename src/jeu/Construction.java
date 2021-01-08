package jeu;

import batiments.Batiment;
import batiments.Mine;
import planete.Planete;
import planete.Poste;
import planete.Ville;
import technologies.Technologie;

import java.util.ArrayList;


/**Permet la construction de thread et de gérer le temps de construction
 *
 */
public class Construction extends Thread{

    /**Constructeur pour thread de construction de ville
     *
     */
    public Construction(Planete p_planete,Ville p_ville){
        this.planete = p_planete;
        this.ville = p_ville;
        this.typeConstruction = "Ville";

        this.start();
    }

    /**Constructeur pour thread de construction de poste
     *
     */
    public Construction(Planete p_planete,Poste p_poste){
        this.planete = p_planete;
        this.poste = p_poste;
        this.typeConstruction = "Poste";

        this.start();
    }

    /**Constructeur pour thread de construction de batiment
     *
     */
    public Construction(Planete p_planete,Ville p_ville,Batiment p_batiment){
        this.planete = p_planete;
        this.ville = p_ville;
        this.batiment = p_batiment;
        this.typeConstruction = "Batiment";

        this.start();
    }

    /**Constructeur pour thread de construction de mine
     *
     */
    public Construction(Planete p_planete, Poste p_poste, Mine p_mine){
        this.planete = p_planete;
        this.poste = p_poste;
        this.mine = p_mine;
        this.typeConstruction = "Mine";

        this.start();
    }

    /**Constructeur pour thread de recherche de technologie
     *
     */
    public Construction(ArrayList<Technologie> p_technologies, Technologie p_technologie){
        this.technologies = p_technologies;
        this.technologie = p_technologie;
        this.typeConstruction = "Technologie";

        this.start();
    }

    /**
     *La ville à construire ou dans laquelle construire
     */
    private Ville ville;

    /**
     *La planète sur laquelle on construit
     */
    private Planete planete;

    /**
     *Le poste à constuire ou lequel agir
     */
    private Poste poste;

    /**
     *Batiment à construire
     */
    private Batiment batiment;

    /**
     *Mine à construire
     */
    private Mine mine;

    /**
     *Liste des technolgies à laquelle appartient la technologie
     */
    private ArrayList<Technologie> technologies;

    /**
     *la technologie à rechercher
     */
    private Technologie technologie;

    /**
     *Permet de savoir le constructeur qui a été utilisé.
     */
    private String typeConstruction;

    @Override
    public void run() {
        try {
            if(this.typeConstruction.equals("Ville")){
                System.out.println("Construction de " + this.ville.getNomVille() + " durant " + this.ville.getTempsConstruction()/1000 + " secondes");
                Thread.sleep(this.ville.getTempsConstruction());
                this.planete.ajoutVille(this.ville);
                System.out.println("La ville " + this.ville.getNomVille()+ " vient d'être construite!");
            }
            else if(this.typeConstruction.equals("Poste")){
                System.out.println("Construction de " + this.poste.getNomPoste() + " durant " + this.poste.getTempsConstruction()/1000 + " secondes");
                Thread.sleep(this.poste.getTempsConstruction());
                this.planete.ajoutPoste(this.poste);
                System.out.println("Le poste " + this.poste.getNomPoste()+ " vient d'être construit!");
            }
            else if(this.typeConstruction.equals("Batiment")){
                System.out.println("Construction de " + this.batiment.getNomBatiment() + " dans " + this.ville.getNomVille() + " durant " + this.batiment.getTempsConstruction()/1000 + " secondes");
                Thread.sleep(this.batiment.getTempsConstruction());
                this.planete.ajoutBatimentVille(this.ville,this.batiment);
                System.out.println("Le bâtiment " + this.batiment.getNomBatiment()+ " vient d'être construit à " + this.ville.getNomVille() +  '!');
            }
            else if(this.typeConstruction.equals("Mine")){
                System.out.println("Construction de " + this.mine.getNomBatiment() + " dans " + this.poste.getNomPoste() + " durant " + this.mine.getTempsConstruction()/1000 + " secondes");
                Thread.sleep(this.mine.getTempsConstruction());
                this.planete.ajoutMinePoste(this.poste,this.mine);
                System.out.println("La mine " + this.mine.getNomBatiment()+ " vient d'être construite à " + this.poste.getNomPoste() +  '!');
            }
            else if(this.typeConstruction.equals("Technologie")){
                System.out.println("Recherche de " + this.technologie.getBatiment().getNomBatiment() + " dans " + " durant " + this.technologie.getTempsTechnologie()/1000 + " secondes");
                Thread.sleep(this.technologie.getTempsTechnologie());
                this.technologies.get(this.technologies.indexOf(this.technologie)).setDebloquer(true);
                System.out.println("La recherche de " + this.technologie.getBatiment().getNomBatiment() + " est terminée!");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
