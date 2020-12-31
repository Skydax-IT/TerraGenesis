package batiments;

import batiments.Batiment;

/**
 * 
 */
public class Mine extends Batiment {

    /**
     * Default constructor
     */
    public Mine() {
        super("Mine",0,0,0,
                0,0,0,0,0,1600, "Mine");
        nbDeMine++;
        prixConstruction *= nbDeMine;
        this.setNomBatiment(nbDeMine);
    }

    public static int prixConstruction = 10000;
    public static int nbDeMine = 0;

}