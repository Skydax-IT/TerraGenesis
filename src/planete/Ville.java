package planete;

import batiments.*;

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
        this.nbBatiments = 3;
        this.batiments = new ArrayList<Batiment>();
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

    /**
     * 
     */
    public void ajouterBatiment(int typeBatiment) {

        switch (typeBatiment) {
            case 1 -> {
                Citerne nouvelleCiterne = new Citerne(setNomBatiment());
                batiments.add(nouvelleCiterne);
                this.nbBatiments++;
                this.actuStatVille(nouvelleCiterne);
            }
            case 2 -> {
                Filtre nouveauFiltre = new Filtre(setNomBatiment());
                batiments.add(nouveauFiltre);
                this.nbBatiments++;
                this.actuStatVille(nouveauFiltre);
            }
            case 3 -> {
                Habitation nouvelleHabitation = new Habitation(setNomBatiment());
                batiments.add(nouvelleHabitation);
                this.nbBatiments++;
                this.actuStatVille(nouvelleHabitation);
            }
            case 4 -> {
                Jardin nouveauJardin = new Jardin(setNomBatiment());
                batiments.add(nouveauJardin);
                this.nbBatiments++;
                this.actuStatVille(nouveauJardin);
            }
            case 5 -> {
                Mine nouvelleMine = new Mine(setNomBatiment());
                batiments.add(nouvelleMine);
                this.nbBatiments++;
                this.actuStatVille(nouvelleMine);
            }
            case 6 -> {
                Transformateur nouveauTransformateur = new Transformateur(setNomBatiment());
                batiments.add(nouveauTransformateur);
                this.nbBatiments++;
                this.actuStatVille(nouveauTransformateur);
            }
            case 7 -> {
                Usine nouvelleUsine = new Usine(setNomBatiment());
                batiments.add(nouvelleUsine);
                this.nbBatiments++;
                this.actuStatVille(nouvelleUsine);
            }
            default -> System.out.println("Batiment inexistant!");
        }
    }

    public void actuStatVille(Batiment nouveauBatiment){

        this.nbHabitants += nouveauBatiment.getPopulationGenere();
        this.pressionGenere += nouveauBatiment.getPressionGenere();
        this.biomasseGenere += nouveauBatiment.getBiomasseGenere();
        this.eauGenere += nouveauBatiment.getEauGenere();
        this.temperatureGenere += nouveauBatiment.getTemperatureGenere();
        this.oxygeneGenere += nouveauBatiment.getOxygeneGenere();
        this.populationGenere += nouveauBatiment.getPopulationGenere();
        this.argentGenere += nouveauBatiment.getArgentGenere();
    }

    /**
     * 
     */
    public void supprimerBatiment(String p_nom) {

        for(int i=0; i<batiments.size();i++){
            Batiment batiment = batiments.get(i);
            if(Objects.equals(batiment.getNomBatiment(), p_nom)){
                try {
                    batiments.remove(i);
                }
                catch(IndexOutOfBoundsException exception){
                    System.out.println("Suppression impossible");
                }
            }
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