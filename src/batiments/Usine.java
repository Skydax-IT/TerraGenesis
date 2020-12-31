package batiments;

import batiments.Batiment;

/**
 * 
 */
public class Usine extends Batiment {

    /**
     * Default constructor
     */
    public Usine(String p_nomBatiment) {
        super(p_nomBatiment,0,0,0,
                0,0,0,0,0,0,"Usine");
        nbDeUsine++;
        prixConstruction *= nbDeUsine;
    }

    public static int prixConstruction = 10000;
    public static int nbDeUsine = 0;

}