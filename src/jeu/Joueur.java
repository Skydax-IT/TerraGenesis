package jeu;

import planete.Planete;

import java.util.*;

/**
 * 
 */
public class Joueur {

    /**
     * Default constructor
     */
    public Joueur(String nom) {
        this.argent = 1000;
        this.nom = nom;
        this.niveauTechnologique = 1;
        this.planete = new Planete();
    }

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
        // TODO implement here
    }

    /**
     * 
     */
    public void gererArgent() {
        // TODO implement here
    }

}