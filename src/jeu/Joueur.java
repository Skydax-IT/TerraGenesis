package jeu;

import batiments.*;
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
        this.argent = 2000000;
        this.niveauTechnologique = 1;

        this.objectifTemperature = 287000;
        this.objectifPression = 100000;
        this.objectifOxygene = 210000;
        this.objectifEau = 600000;
        this.objectifBiomasse = 600000;
        this.objectifPopulation = 171;
        this.planete = new Planete("AA");
        //this.initialiserJoueur();

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
    private int objectifTemperature;

    /**
     *
     */
    private int objectifPression;

    /**
     *
     */
    private int objectifOxygene;

    /**
     *
     */
    private int objectifEau;

    /**
     *
     */
    private int objectifBiomasse;

    /**
     *
     */
    private int objectifPopulation;



    /**
     * 
     */
    public void initialiserJoueur() {
        this.nom = askForString("Veuillez choisir votre nom d'aventurier ? ");
        System.out.println("Bien le bonjour " + this.nom + "!\nVous êtes fin prêt à commencer votre aventure.\n" +
                "Il est maintenant temps d'établir votre première colonie\n");
        String nomPlanete = askForString("Quel nom voulez-vous donner à votre planète ?");
        this.planete = new Planete(nomPlanete);
    }

    /**
     * 
     */
    public void achatJoeur(int prix) {
        this.argent -= prix;
    }

    public void constuireVille(){
        if(this.argent >= Ville.prixConstruction) {
            String nomVille = this.askForString("Quel nom voulez-vous donner à votre ville ? ");
            this.achatJoeur(Ville.prixConstruction); // A mettre avant sinon prix change quand classe ville est créée
            this.planete.ajoutVille(new Ville(nomVille));

        }else{
            System.out.println("Impossible de construire une ville! Il vous manque " + (Ville.prixConstruction - this.argent));
        }
    }

    public void supprimerVille(Ville ville){
        this.planete.supprimerVille(ville);
    }

    public void construirePoste(){
        if(this.argent >= Poste.prixConstruction){
            String nomPoste = this.askForString("Quel nom voulez-vous donner à votre poste ? ");
            this.achatJoeur(Poste.prixConstruction);
            this.planete.ajoutPoste(new Poste(nomPoste));
        }else{
            System.out.println("Impossible de construire un poste! Il vous manque " + (Poste.prixConstruction - this.argent));
        }

    }

    public void supprimerPoste(Poste poste){
        this.planete.supprimerPoste(poste);
    }

    public void construireBatiment(Ville ville, String typeBatiment){

        if(typeBatiment.equals("Citerne") && this.argent >= Citerne.prixConstruction) {
            ville.ajoutCiterne(new Citerne());
            this.achatJoeur(Citerne.prixConstruction);
        }
        else if(typeBatiment.equals("Filtre") && this.argent >= Filtre.prixConstruction){
            ville.ajoutFiltre(new Filtre());
            this.achatJoeur(Filtre.prixConstruction);
        }
        else if(typeBatiment.equals("Habitation") && this.argent >= Habitation.prixConstruction){
            ville.ajoutHabitation(new Habitation());
            this.achatJoeur(Habitation.prixConstruction);
        }
        else if(typeBatiment.equals("Jardin") && this.argent >= Jardin.prixConstruction){
            ville.ajoutJardin(new Jardin());
            this.achatJoeur(Jardin.prixConstruction);
        }
        else if(typeBatiment.equals("Mine") && this.argent >= Mine.prixConstruction){
            ville.ajoutMine(new Mine());
            this.achatJoeur(Mine.prixConstruction);
        }
        else if(typeBatiment.equals("Transformateur") && this.argent >= Transformateur.prixConstruction){
            ville.ajoutTransformateur(new Transformateur());
            this.achatJoeur(Transformateur.prixConstruction);
        }
        else if(typeBatiment.equals("Usine") && this.argent >= Usine.prixConstruction){
            ville.ajoutUsine(new Usine());
            this.achatJoeur(Usine.prixConstruction);
        }
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

    /**
     *
     */
    public boolean verifierVictoire() {
        if((this.planete.getTemperature() >= this.objectifTemperature) && (this.planete.getPression() >= this.objectifPression)
                && (this.planete.getOxygene() >= this.objectifOxygene ) && (this.planete.getEau() >= this.objectifEau)
                && (this.planete.getBiomasse() >= this.objectifBiomasse ) && (this.planete.getPopulation() >= this.objectifPopulation)){
            return true;
        }else{
            return false;
        }
    }

    public void afficherResumePlanete(){
        String resume = "Résumé: " + this.planete.getNom() +
                "\nTempérature: " + this.planete.getTemperature() + '/' + this.objectifTemperature + "\n" +
                "Pression: " + this.planete.getPression() + '/' + this.objectifPression + "\n" +
                "Oxygène: " + this.planete.getOxygene() + '/' + this.objectifOxygene + "\n" +
                "Eau: " + this.planete.getEau() + '/' + this.objectifEau + "\n" +
                "Biomasse: " + this.planete.getBiomasse() + '/' + this.objectifBiomasse + "\n" +
                "Population: " + this.planete.getPopulation() + '/' + this.objectifPopulation + "\n"
                ;
        System.out.println(resume);
    }


    public int getArgent() {
        return argent;
    }

    public void setArgent(int argent) {
        this.argent = argent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNiveauTechnologique() {
        return niveauTechnologique;
    }

    public void setNiveauTechnologique(int niveauTechnologique) {
        this.niveauTechnologique = niveauTechnologique;
    }

    public Planete getPlanete() {
        return planete;
    }

    public void setPlanete(Planete planete) {
        this.planete = planete;
    }
}