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
        this.argent = 650000;
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

    public void construireBatiment(Ville ville, String typeBatiment, String nom){

        if(typeBatiment.equals("Citerne") && this.argent >= Citerne.prixConstruction) ville.ajoutCiterne(new Citerne());
        else if(typeBatiment.equals("Filtre") && this.argent >= Filtre.prixConstruction) ville.ajoutFiltre(new Filtre());
        else if(typeBatiment.equals("Habitation") && this.argent >= Habitation.prixConstruction) ville.ajoutHabitation(new Habitation());
        else if(typeBatiment.equals("Jardin") && this.argent >= Jardin.prixConstruction) ville.ajoutJardin(new Jardin());
        else if(typeBatiment.equals("Mine") && this.argent >= Mine.prixConstruction) ville.ajoutMine(new Mine());
        else if(typeBatiment.equals("Transformateur") && this.argent >= Transformateur.prixConstruction) ville.ajoutTransformateur(new Transformateur());
        else if(typeBatiment.equals("Usine") && this.argent >= Usine.prixConstruction) ville.ajoutUsine(new Usine());
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

    public boolean isVictoire() {
        return victoire;
    }

    public void setVictoire(boolean victoire) {
        this.victoire = victoire;
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