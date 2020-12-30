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
        this.argent = 2500;
        this.population = 100;
        this.villes = new ArrayList<Ville>();
        this.postes = new ArrayList<Poste>();
        this.technologies = new ArrayList<Technologie>();

        this.nbVilles = this.villes.size();
        this.nbPostes = this.postes.size();

    }

    /**
     *
     */
    private int nbVilles;

    /**
     *
     */
    private int nbPostes;

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
    private int argent;

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
    public void ajouterVille(Ville nouvelleVille) {

        villes.add(nouvelleVille);
        this.nbVilles++;
        actuStatPlaneteNouvelleVille(nouvelleVille);
    }

    /**
     *
     */
    public void actuStatPlaneteNouvelleVille(Ville nouvelleVille) {

        this.temperature += nouvelleVille.getTemperatureGenere();
        this.pression += nouvelleVille.getPressionGenere();
        this.oxygene += nouvelleVille.getOxygeneGenere();
        this.eau += nouvelleVille.getEauGenere();
        this.biomasse += nouvelleVille.getBiomasseGenere();
        this.argent += nouvelleVille.getArgentGenere();
        this.population += nouvelleVille.getPopulationGenere();
    }

    public void actuStatPlaneteNouveauPoste(Poste poste){

    }

    public void actuStatPlanete(Poste poste){
        //Tout actualiser
    }

    /**
     * 
     */
    public void supprimerVille(Ville villeSuppr) {
        try {
            this.villes.remove(villeSuppr);
            this.nbVilles --;
        }
        catch(IndexOutOfBoundsException exception){
            System.out.println("Suppression impossible");
        }
    }

    /**
     * 
     */
    public void ajouterPoste(Poste poste) {

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

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getPression() {
        return pression;
    }

    public void setPression(int pression) {
        this.pression = pression;
    }

    public int getOxygene() {
        return oxygene;
    }

    public void setOxygene(int oxygene) {
        this.oxygene = oxygene;
    }

    public int getEau() {
        return eau;
    }

    public void setEau(int eau) {
        this.eau = eau;
    }

    public int getArgent() {
        return argent;
    }

    public void setArgent(int argent) {
        this.argent = argent;
    }

    public int getBiomasse() {
        return biomasse;
    }

    public void setBiomasse(int biomasse) {
        this.biomasse = biomasse;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int[] getDate() {
        return date;
    }

    public void setDate(int[] date) {
        this.date = date;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Ville> getVilles() {
        return villes;
    }

    public void setVilles(ArrayList<Ville> villes) {
        this.villes = villes;
    }

    public ArrayList<Poste> getPostes() {
        return postes;
    }

    public void setPostes(ArrayList<Poste> postes) {
        this.postes = postes;
    }

    public ArrayList<Technologie> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(ArrayList<Technologie> technologies) {
        this.technologies = technologies;
    }
}