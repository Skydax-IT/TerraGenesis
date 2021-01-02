package jeu;

import batiments.*;
import planete.Planete;
import planete.Poste;
import planete.Ville;

import java.util.*;

/**
 * 
 */
public class Joueur{

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
    private final int objectifTemperature;

    /**
     *
     */
    private final int objectifPression;

    /**
     *
     */
    private final int objectifOxygene;

    /**
     *
     */
    private final int objectifEau;

    /**
     *
     */
    private final int objectifBiomasse;

    /**
     *
     */
    private final int objectifPopulation;

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
            new Construction(this.planete, new Ville(nomVille));
        }else{
            System.out.println("Impossible de construire une ville! Il vous manque " + (Ville.prixConstruction - this.argent));
        }
    }

    public void supprimerVille(Ville ville){
        System.out.println("Ville " + ville.getNomVille() + " Supprimée");
        this.planete.supprimerVille(ville);
    }

    public void construirePoste(){
        if(this.argent >= Poste.prixConstruction){
            String nomPoste = this.askForString("Quel nom voulez-vous donner à votre poste ? ");
            this.achatJoeur(Poste.prixConstruction);
            new Construction(this.planete, new Poste(nomPoste));
        }else{
            System.out.println("Impossible de construire un poste! Il vous manque " + (Poste.prixConstruction - this.argent));
        }

    }

    public void supprimerPoste(Poste poste){
        System.out.println("Poste " + poste.getNomPoste() + " Supprimé");
        this.planete.supprimerPoste(poste);
    }

    public void construireBatiment(Ville ville, Batiment batiment){

        if(batiment.getTypeBatiment().equals("Citerne") && this.argent >= Citerne.prixConstruction) {
            this.achatJoeur(Citerne.prixConstruction);
            new Construction(this.planete,ville,batiment);
        }
        else if(batiment.getTypeBatiment().equals("Filtre") && this.argent >= Filtre.prixConstruction){
            this.achatJoeur(Filtre.prixConstruction);
            new Construction(this.planete,ville,batiment);
        }
        else if(batiment.getTypeBatiment().equals("Habitation") && this.argent >= Habitation.prixConstruction){
            this.achatJoeur(Habitation.prixConstruction);
            new Construction(this.planete,ville,batiment);
        }
        else if(batiment.getTypeBatiment().equals("Jardin") && this.argent >= Jardin.prixConstruction){
            this.achatJoeur(Jardin.prixConstruction);
            new Construction(this.planete,ville,batiment);
        }
        else if(batiment.getTypeBatiment().equals("Mine") && this.argent >= Mine.prixConstruction){
            this.achatJoeur(Mine.prixConstruction);
            new Construction(this.planete,ville,batiment);
        }
        else if(batiment.getTypeBatiment().equals("Transformateur") && this.argent >= Transformateur.prixConstruction){
            this.achatJoeur(Transformateur.prixConstruction);
            new Construction(this.planete,ville,batiment);
        }
        else if(batiment.getTypeBatiment().equals("Usine") && this.argent >= Usine.prixConstruction){
            this.achatJoeur(Usine.prixConstruction);
            new Construction(this.planete,ville,batiment);
        }
        else{
            System.out.println("Construction de bâtiment impossible!");
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