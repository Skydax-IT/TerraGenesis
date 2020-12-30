package planete;

import technologies.Technologie;

import java.util.*;
import java.util.Scanner;

/**
 * 
 */
public class Planete {

    /**
     * Default constructor
     */
    public Planete() {
        this.setNom();
        this.temperature = 0;
        this.pression = 20;
        this.oxygene = 40;
        this.eau = 5;
        this.biomasse = 45;
        this.population = 100;
        this.victoire = false;
        this.villes = new ArrayList<Ville>();
        this.postes = new ArrayList<Poste>();
        this.technologies = new ArrayList<Technologie>();

    }

    /**
     * 
     */
    private int temperature;

    /**
     * 
     */
    private int pression;

    /**
     * 
     */
    private int oxygene;

    /**
     * 
     */
    private int eau;

    /**
     * 
     */
    private int biomasse;

    /**
     * 
     */
    private int population;

    /**
     * 
     */
    private int date[];

    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    private Boolean victoire;

    /**
     * 
     */
    private ArrayList<Ville> villes;

    /**
     * 
     */
    private ArrayList<Poste> postes;

    /**
     * 
     */
    private ArrayList<Technologie> technologies;






    /**
     * 
     */
    public void gererTemperature() {
        // TODO implement here
    }

    /**
     * 
     */
    public void gererEau() {
        // TODO implement here
    }

    /**
     * 
     */
    public void gererOxygene() {
        // TODO implement here
    }

    /**
     * 
     */
    public void gererBiomasse() {
        // TODO implement here
    }

    /**
     * 
     */
    public void gererPopulation() {
        // TODO implement here
    }

    /**
     * 
     */
    public void gererPression() {
        // TODO implement here
    }

    /**
     * 
     */
    public void creerVille() {

        Ville nouvelleVille = new Ville("Paris");
        villes.add(nouvelleVille);
        //actualisation des paramètres de la planete
    }

    /**
     * 
     */
    public void supprimerVille() {
        // TODO implement here
    }

    /**
     * 
     */
    public void creerPoste() {
        // TODO implement here
    }

    /**
     * 
     */
    public void supprimerPoste() {
        // TODO implement here
    }

    public void setNom(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Donner un nom à votre planète"); //fenetre pop-up
        this.nom = myObj.nextLine();
    }

    /**
     * 
     */
    public boolean verifierVictoire() {
        if((this.temperature >= 7 && this.temperature <= 20) && (this.pression >= 95000 && this.pression <= 105000)
        && (this.oxygene >= 200000 && this.oxygene <= 220000) && (this.eau >= 595000 && this.eau <= 605000)
                && (this.biomasse >= 595000 && this.temperature <= 605000) && (this.population >= 500)){
            return true;
        }else{
            return false;
        }
    }

}