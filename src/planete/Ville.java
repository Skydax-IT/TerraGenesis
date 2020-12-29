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
    public Ville() {
        this.nomVille = "";
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

    public String setNomBatiment(){
        boolean isSame = true;
        String nomBatiment;

        while(isSame){
            Scanner myObj = new Scanner(System.in);
            System.out.println("Donner un nom à votre Batiment"); //fenetre pop-up
            nomBatiment = myObj.nextLine();

            for(int i=0; i<batiments.size();i++) {
                Batiment batiment = batiments.get(i);
                if (nomBatiment == batiment.getNomBatiment()){
                    isSame = true;
                    break;
                }else{
                    isSame = false;
                }
            }
        }

        return nomBatiment;
    }

    /**
     * 
     */
    public void ajouterBatiment(int typeBatiment) {

        switch (typeBatiment) {
            case 1:
                Citerne nouvelleCiterne = new Citerne(setNomBatiment());
                batiments.add(nouvelleCiterne);
                this.nbBatiments ++;
                this.actuStatVille(nouvelleCiterne);
                break;
            case 2:
                Filtre nouveauFiltre = new Filtre(setNomBatiment());
                batiments.add(nouveauFiltre);
                this.nbBatiments ++;
                this.actuStatVille(nouveauFiltre);
                break;
            case 3:
                Habitation nouvelleHabitation = new Habitation(setNomBatiment());
                batiments.add(nouvelleHabitation);
                this.nbBatiments ++;
                this.actuStatVille(nouvelleHabitation);
                break;
            case 4:
                Jardin nouveauJardin = new Jardin(setNomBatiment());
                batiments.add(nouveauJardin);
                this.nbBatiments ++;
                this.actuStatVille(nouveauJardin);
                break;
            case 5:
                Mine nouvelleMine = new Mine(setNomBatiment());
                batiments.add(nouvelleMine);
                this.nbBatiments ++;
                this.actuStatVille(nouvelleMine);
                break;
            case 6:
                Transformateur nouveauTransformateur = new Transformateur(setNomBatiment());
                batiments.add(nouveauTransformateur);
                this.nbBatiments ++;
                this.actuStatVille(nouveauTransformateur);
                break;
            case 7:
                Usine nouvelleUsine = new Usine(setNomBatiment());
                batiments.add(nouvelleUsine);
                this.nbBatiments ++;
                this.actuStatVille(nouvelleUsine);
                break;
            default:
                System.out.println("Batiment inexistant!");
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
            if(batiment.getNomBatiment() == p_nom){
                try {
                    batiments.remove(i);
                }
                catch(IndexOutOfBoundsException exception){
                    System.out.println("Suppression impossible");
                }
            }
        }
    }


}