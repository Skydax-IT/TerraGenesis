package planete;

import batiments.*;

import java.util.*;


/**
 * 
 */
public class Ville{

    /**
     * Default constructor
     */

    public Ville(String p_nomVille) {
        this.nomVille = p_nomVille;
        this.nbHabitants = 10;
        this.batiments = new ArrayList<Batiment>();
        this.nbBatiments = this.batiments.size();
        //Ajouter des batiments de base ?

        this.pressionGenere = 0;
        this.biomasseGenere = 0;
        this.eauGenere = 0;
        this.temperatureGenere = 0;
        this.oxygeneGenere = 0;
        this.populationGenere = 0;
        this.argentGenere = 0;
        this.tempsConstruction = 5000;

        nbDeVille++;
        prixConstruction *= nbDeVille;

    }

    public static int prixConstruction = 500000;
    public static int nbDeVille = 0;
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
    protected int biomasseGenere;

    /**
     *
     */
    protected int pressionGenere;

    /**
     *
     */
    protected int eauGenere;

    /**
     *
     */
    protected int temperatureGenere;

    /**
     *
     */
    protected int oxygeneGenere;

    /**
     *
     */
    protected int populationGenere;

    /**
     *
     */
    protected int argentGenere;

    /**
     *
     */
    private int tempsConstruction;

    public int getTempsConstruction() {
        return tempsConstruction;
    }

    public void setTempsConstruction(int tempsConstruction) {
        this.tempsConstruction = tempsConstruction;
    }

    public ArrayList<Batiment> getBatiments() {
        return batiments;
    }

    public void setBatiments(ArrayList<Batiment> batiments) {
        this.batiments = batiments;
    }

    public void afficherBatiments(){
        for (Batiment batiment : this.batiments){
            System.out.println(batiment);
        }
    }

    @Override
    public String toString() {
        return "\nVille{" +
                "nbBatiments=" + nbBatiments +
                ", nbHabitants=" + nbHabitants +
                ", nomVille='" + nomVille + '\'' +
                ", biomasseGenere=" + biomasseGenere +
                ", pressionGenere=" + pressionGenere +
                ", eauGenere=" + eauGenere +
                ", temperatureGenere=" + temperatureGenere +
                ", oxygeneGenere=" + oxygeneGenere +
                ", populationGenere=" + populationGenere +
                ", argentGenere=" + argentGenere +
                ", batiments=" + batiments +
                "}\n";
    }

    public void ajoutBatiment(Batiment batiment){

        this.batiments.add(batiment);
        this.actuStatVilleBatiment(batiment,true);
    }

    public void actuStatVilleBatiment(Batiment batiment, boolean add){
        if(add){
            this.nbHabitants += batiment.getPopulationGenere();
            this.pressionGenere += batiment.getPressionGenere();
            this.biomasseGenere += batiment.getBiomasseGenere();
            this.eauGenere += batiment.getEauGenere();
            this.temperatureGenere += batiment.getTemperatureGenere();
            this.oxygeneGenere += batiment.getOxygeneGenere();
            this.populationGenere += batiment.getPopulationGenere();
            this.argentGenere += batiment.getArgentGenere();
            this.nbBatiments ++;
        }else{
            this.nbHabitants -= batiment.getPopulationGenere();
            this.pressionGenere -= batiment.getPressionGenere();
            this.biomasseGenere -= batiment.getBiomasseGenere();
            this.eauGenere -= batiment.getEauGenere();
            this.temperatureGenere -= batiment.getTemperatureGenere();
            this.oxygeneGenere -= batiment.getOxygeneGenere();
            this.populationGenere -= batiment.getPopulationGenere();
            this.argentGenere -= batiment.getArgentGenere();
            this.nbBatiments --;
        }

    }

    public void actuStatVille(){

        this.nbHabitants = 0;
        this.pressionGenere = 0;
        this.biomasseGenere = 0;
        this.eauGenere = 0;
        this.temperatureGenere = 0;
        this.oxygeneGenere = 0;
        this.populationGenere = 0;
        this.argentGenere = 0;
        this.nbBatiments = 0;

        for(Batiment batiment: this.batiments){
            actuStatVilleBatiment(batiment,true);
        }
    }

    /**
     * 
     */
    public void supprimerBatiment(Batiment batSuppr) {
        try {
            this.actuStatVilleBatiment(batSuppr,false);
            this.batiments.remove(batSuppr);
        }
        catch(IndexOutOfBoundsException exception){
            System.out.println("Suppression impossible");
        }
    }

    public int getNbBatiments() {
        return nbBatiments;
    }

    public void setNbBatiments(int nbBatiments) {
        this.nbBatiments = nbBatiments;
    }

    public int getNbHabitants() {
        return nbHabitants;
    }

    public void setNbHabitants(int nbHabitants) {
        this.nbHabitants = nbHabitants;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public int getBiomasseGenere() {
        return biomasseGenere;
    }

    public void setBiomasseGenere(int biomasseGenere) {
        this.biomasseGenere = biomasseGenere;
    }

    public int getPressionGenere() {
        return pressionGenere;
    }

    public void setPressionGenere(int pressionGenere) {
        this.pressionGenere = pressionGenere;
    }

    public int getEauGenere() {
        return eauGenere;
    }

    public void setEauGenere(int eauGenere) {
        this.eauGenere = eauGenere;
    }

    public int getTemperatureGenere() {
        return temperatureGenere;
    }

    public void setTemperatureGenere(int temperatureGenere) {
        this.temperatureGenere = temperatureGenere;
    }

    public int getOxygeneGenere() {
        return oxygeneGenere;
    }

    public void setOxygeneGenere(int oxygeneGenere) {
        this.oxygeneGenere = oxygeneGenere;
    }

    public int getPopulationGenere() {
        return populationGenere;
    }

    public void setPopulationGenere(int populationGenere) {
        this.populationGenere = populationGenere;
    }

    public int getArgentGenere() {
        return argentGenere;
    }

    public void setArgentGenere(int argentGenere) {
        this.argentGenere = argentGenere;
    }
}