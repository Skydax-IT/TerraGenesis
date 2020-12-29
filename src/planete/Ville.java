package planete;

import batiments.Batiment;

import java.util.*;

/**
 * 
 */
public class Ville {

    /**
     * Default constructor
     */
    public Ville(String p_nomVille) {
        this.nomVille = p_nomVille;
        this.nbHabitants = 10;
        this.batiments = new ArrayList<Batiment>();
        //Ajouter des batiments de base ?
        // nb Habitants min;
    }

    /**
     * 
     */
    private int nbBatiments;

    /**
     * 
     */
    private ArrayList<Batiment> batiments;

    /**
     * 
     */
    private int nbHabitants;

    /**
     * 
     */
    private String nomVille;



    /**
     * 
     */
    public void ajouterBatiment(Batiment nouveauBatiment) {
        batiments.add(nouveauBatiment);
        nbHabitants++;

    }

    /**
     * 
     */
    public void supprimerBatiment() {
        // TODO implement here
    }

}