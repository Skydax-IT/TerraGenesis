package jeu;

import batiments.Batiment;
import planete.Planete;
import planete.Poste;
import planete.Ville;

import java.util.*;

/**
 * 
 */
public class Joueur {

    /**
     * Default constructor
     */
    public Joueur() {
        this.argent = 1000;
        this.niveauTechnologique = 1;
        this.victoire = false;
        this.initialiserJoueur();
    }

    /**
     *
     */
    private boolean victoire;

    /**
     * 
     */
    private int argent;

    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    private int niveauTechnologique;

    /**
     *
     */
    private Planete planete;


    /**
     * 
     */
    public void initialiserJoueur() {
        this.nom = askForString("Quel est votre nom aventurier ? ");
        String nomPlanete = askForString("Quel nom voulez-vous donner à votre planète ?");
        this.planete = new Planete(nomPlanete);
    }

    /**
     * 
     */
    public void gererArgent() {
        // TODO implement here
    }


    public void constuireVille(){
        String nomVille = this.askForString("Quel nom voulez-vous donner à votre ville ? ");
        this.planete.ajoutVille(new Ville(nomVille));
    }

    public void supprimerVille(Ville ville){
        this.planete.supprimerVille(ville);
    }

    public void construirePoste(){
        String nomPoste = this.askForString("Quel nom voulez-vous donner à votre poste ? ");
        this.planete.ajoutPoste(new Poste(nomPoste));
    }

    public void supprimerPoste(Poste poste){
        this.planete.supprimerPoste(poste);
    }

    public void construireBatiment(Ville ville, Batiment batiment){
        
    }

    public void supprimerBatiment(Ville ville, Batiment batiment){
        ville.supprimerBatiment(batiment);
    }

    //AméliorationTechnologique

    public String askForString(String phrase){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println(phrase); //fenetre pop-up
        return myObj.nextLine();
    }
}