package planete;

import batiments.Batiment;
import batiments.Mine;
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
    public void actuStatPlaneteNouvelleVille(Ville nouvelleVille, boolean add) {
        if(add){
            this.temperature += nouvelleVille.getTemperatureGenere();
            this.pression += nouvelleVille.getPressionGenere();
            this.oxygene += nouvelleVille.getOxygeneGenere();
            this.eau += nouvelleVille.getEauGenere();
            this.biomasse += nouvelleVille.getBiomasseGenere();
            this.argent += nouvelleVille.getArgentGenere();
            this.population += nouvelleVille.getPopulationGenere();
            this.nbVilles ++;
        }else{
            this.temperature -= nouvelleVille.getTemperatureGenere();
            this.pression -= nouvelleVille.getPressionGenere();
            this.oxygene -= nouvelleVille.getOxygeneGenere();
            this.eau -= nouvelleVille.getEauGenere();
            this.biomasse -= nouvelleVille.getBiomasseGenere();
            this.argent -= nouvelleVille.getArgentGenere();
            this.population -= nouvelleVille.getPopulationGenere();
            this.nbVilles --;
        }
    }

    public void actuStatPlaneteNouveauPoste(Poste poste, boolean add){
        if(add){
            this.nbPostes ++;
            this.argent += poste.getArgentGenere();
        }else{
            this.nbPostes --;
            this.argent -= poste.getArgentGenere();
        }
    }

    public void actuStatPlanete(){

        this.temperature =0;
        this.pression =0;
        this.oxygene =0;
        this.eau =0;
        this.biomasse =0;
        this.argent =0;
        this.population =0;
        this.nbVilles =0;
        this.nbPostes = 0;

        for(Ville ville:this.villes){
            this.actuStatPlaneteNouvelleVille(ville,true);
        }

        for(Poste poste: this.postes){
            this.actuStatPlaneteNouveauPoste(poste,true);
        }
    }

    /**
     *
     */
    public void ajoutVille(Ville nouvelleVille) {
        villes.add(nouvelleVille);
        actuStatPlaneteNouvelleVille(nouvelleVille,true);
    }

    /**
     * 
     */
    public void supprimerVille(Ville villeSuppr) {
        try {
            this.villes.remove(villeSuppr);
            this.actuStatPlaneteNouvelleVille(villeSuppr,false);
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
        this.actuStatPlaneteNouveauPoste(poste,true);
    }

    /**
     * 
     */
    public void supprimerPoste(Poste posteSuppr) {
        try {
            this.postes.remove(posteSuppr);
            this.actuStatPlaneteNouveauPoste(posteSuppr,false);
        }
        catch(IndexOutOfBoundsException exception){
            System.out.println("Suppression impossible");
        }
    }

    public void ajoutMinePoste(Poste poste, Mine mine){
        this.actuStatPlaneteNouveauPoste(poste,false);
        poste.ajouterMine(mine);
        this.actuStatPlaneteNouveauPoste(poste,true);
    }

    public void supprimerMinePoste(Poste poste, Mine mine){
        this.actuStatPlaneteNouveauPoste(poste,false);
        poste.supprimerMine(mine);
    }

    public void ajoutBatimentVille(Ville ville, Batiment batiment){
        this.actuStatPlaneteNouvelleVille(ville,false);
        ville.ajoutBatiment(batiment);
        this.actuStatPlaneteNouvelleVille(ville,true);
    }

    public void supprimerBatimentVille(Ville ville, Batiment batiment){
        this.actuStatPlaneteNouvelleVille(ville,false);
        ville.supprimerBatiment(batiment);
        this.actuStatPlaneteNouvelleVille(ville,true);
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

    @Override
    public String toString() {
        return "Planete{" +
                ", nom='" + nom + '\'' +
                ", temperature=" + temperature +
                ", pression=" + pression +
                ", oxygene=" + oxygene +
                ", eau=" + eau +
                ", argent=" + argent +
                ", biomasse=" + biomasse +
                ", population=" + population +
                ", date=" + date +
                "nbVilles=" + nbVilles +
                ", nbPostes=" + nbPostes +
                ", villes=" + villes +
                ", postes=" + postes +
                ", technologies=" + technologies +
                '}';
    }
}