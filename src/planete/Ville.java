package planete;

import batiments.*;

import java.util.*;


/**Permet la création d'une ville sur la planète
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

        this.pressionGenere = 0;
        this.biomasseGenere = 0;
        this.eauGenere = 0;
        this.temperatureGenere = 0;
        this.oxygeneGenere = 0;
        this.populationGenere = 0;
        this.argentGenere = 0;
        this.tempsConstruction = 15000;

        nbDeVille++;
        prixConstruction *= nbDeVille;

    }

    /**Le prix de construction de la ville
     *
     */
    public static int prixConstruction = 500000;

    /**
     *Le nombre de ville construite
     */
    public static int nbDeVille = 0;

    /**Le nombre de batiment dans la ville
     * 
     */
    private int nbBatiments;

    /**Liste des batiments
     * 
     */
    private ArrayList<Batiment> batiments;

    /**Nombre d'habitants de la ville
     * 
     */
    private int nbHabitants;

    /**Le nom de la ville
     * 
     */
    private String nomVille;

    /**La biomasse générée par la ville
     *
     */
    protected int biomasseGenere;

    /**La pression générée
     *
     */
    protected int pressionGenere;

    /**L'eau générée par la ville
     *
     */
    protected int eauGenere;

    /**La température générée
     *
     */
    protected int temperatureGenere;

    /**l'oxygene générée
     *
     */
    protected int oxygeneGenere;

    /**La population générée
     *
     */
    protected int populationGenere;

    /**L'argent générée
     *
     */
    protected int argentGenere;

    /**Le temps de construction de la ville
     *
     */
    private int tempsConstruction;


    /**Affichage de la ville
     *le nom de la ville
     */
    @Override
    public String toString() {
        return this.nomVille;
    }

    /**Ajoute un batiment à la ville
     *void
     * le batiment à ajouter
     */
    public void ajoutBatiment(Batiment batiment){

        this.batiments.add(batiment);
        this.actuStatVilleBatiment(batiment,true);
    }

    /**Actualise les stats de la ville
     *void
     * Le batiment qui influe sur les stats et le boolean qui permet de savoir si on soustrait ou ajoute
     */
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


    /**Supprime un batiment de la ville
     * void
     * Batiment à supprimer
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

    /**Getter and setter
     *
     */
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

}