package planete;

import technologies.Technologie;

import java.util.*;


/**
 * 
 */
public class Planete {

    /**
     * Default constructor
     */
    public Planete(String nomPlanete) {
        this.nom = nomPlanete;
        this.temperature = 200000; //mK
        this.pression = 600; //Pa
        this.oxygene = 1700; //ppm
        this.eau = 17; //cm
        this.biomasse = 0; //nécessite 10k pression//Mt
        this.argent = 0;
        this.population = 0;
        this.villes = new ArrayList<Ville>();
        this.postes = new ArrayList<Poste>();
        this.technologies = new ArrayList<Technologie>();

        this.nbVilles = this.villes.size();
        this.nbPostes = this.postes.size();

        this.date = new Date();

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
    private Date date;

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
    public void ajoutVille(Ville nouvelleVille) {
        villes.add(nouvelleVille);
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
        this.nbVilles ++;
    }

    public void actuStatPlaneteNouveauPoste(Poste poste){
        this.nbPostes ++;
        this.argent += poste.getArgentGenere();
    }

    public void actuStatPlanete(){
        for(Ville ville:this.villes){
            this.actuStatPlaneteNouvelleVille(ville);
        }

        for(Poste poste: this.postes){
            this.actuStatPlaneteNouveauPoste(poste);
        }
    }

    /**
     * 
     */
    public void supprimerVille(Ville villeSuppr) {
        try {
            this.villes.remove(villeSuppr);
            this.actuStatPlanete();
        }
        catch(IndexOutOfBoundsException exception){
            System.out.println("Suppression impossible");
        }
    }

    /**
     * 
     */
    public void ajoutPoste(Poste poste) {
        this.postes.add(poste);
        this.actuStatPlaneteNouveauPoste(poste);
    }

    /**
     * 
     */
    public void supprimerPoste(Poste posteSuppr) {
        try {
            this.postes.remove(posteSuppr);
            this.actuStatPlanete();
        }
        catch(IndexOutOfBoundsException exception){
            System.out.println("Suppression impossible");
        }
    }

    public void afficherVilles(){
        for(Ville ville:this.villes){
            System.out.println(ville);
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

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
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