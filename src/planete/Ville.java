package planete;

import batiments.*;

import javax.xml.crypto.dsig.Transform;
import java.util.*;


/**
 * 
 */
public class Ville {

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
    }

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
        return "Ville{" +
                "nbBatiments=" + nbBatiments +
                ", batiments=" + batiments +
                ", nbHabitants=" + nbHabitants +
                ", nomVille='" + nomVille + '\'' +
                ", biomasseGenere=" + biomasseGenere +
                ", pressionGenere=" + pressionGenere +
                ", eauGenere=" + eauGenere +
                ", temperatureGenere=" + temperatureGenere +
                ", oxygeneGenere=" + oxygeneGenere +
                ", populationGenere=" + populationGenere +
                ", argentGenere=" + argentGenere +
                '}';
    }

    public String setNomBatiment(){
        boolean isSame = true;
        String nomBatiment = "";

        while(isSame){
            Scanner myObj = new Scanner(System.in);
            System.out.println("Donner un nom à votre Batiment"); //fenetre pop-up
            nomBatiment = myObj.nextLine();

            if(!this.batiments.isEmpty()) {
                for (Batiment batiment : batiments) {
                    if (Objects.equals(nomBatiment, batiment.getNomBatiment())) {
                        isSame = true;
                        System.out.println("Ce nom est déjà pris par un autre bâtiment au sein de cette ville");
                        break;
                    }else{
                        isSame = false;
                    }
                }
            }else{
                isSame = false;
            }
        }
        return nomBatiment;
    }

    public void ajoutCiterne(Citerne citerne){
        this.batiments.add(citerne);
        this.nbBatiments++;
        this.actuStatVilleBatiment(citerne);
    }

    public void ajoutFiltre(Filtre filtre){
        this.batiments.add(filtre);
        this.nbBatiments++;
        this.actuStatVilleBatiment(filtre);
    }

    public void ajoutHabitation(Habitation habitation){
        this.batiments.add(habitation);
        this.nbBatiments++;
        this.actuStatVilleBatiment(habitation);
    }

    public void ajoutJardin(Jardin jardin){
        this.batiments.add(jardin);
        this.nbBatiments++;
        this.actuStatVilleBatiment(jardin);
    }

    public void ajoutMine(Mine mine){
        this.batiments.add(mine);
        this.nbBatiments++;
        this.actuStatVilleBatiment(mine);
    }

    public void ajoutTransformateur(Transformateur transformateur){
        this.batiments.add(transformateur);
        this.nbBatiments++;
        this.actuStatVilleBatiment(transformateur);
    }

    public void ajoutUsine(Usine usine){
        this.batiments.add(usine);
        this.nbBatiments++;
        this.actuStatVilleBatiment(usine);
    }

    public void actuStatVilleBatiment(Batiment batiment){

        this.nbHabitants += batiment.getPopulationGenere();
        this.pressionGenere += batiment.getPressionGenere();
        this.biomasseGenere += batiment.getBiomasseGenere();
        this.eauGenere += batiment.getEauGenere();
        this.temperatureGenere += batiment.getTemperatureGenere();
        this.oxygeneGenere += batiment.getOxygeneGenere();
        this.populationGenere += batiment.getPopulationGenere();
        this.argentGenere += batiment.getArgentGenere();
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

        for(Batiment batiment: this.batiments){
            actuStatVilleBatiment(batiment);
        }
    }

    /**
     * 
     */
    public void supprimerBatiment(Batiment batSuppr) {
        try {
            System.out.println("Suppression");
            this.batiments.remove(batSuppr);
            this.nbBatiments --;
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