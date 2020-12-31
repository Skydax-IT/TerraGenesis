package batiments;

import batiments.Batiment;

/**
 * 
 */
public class Habitation extends Batiment {

    /**
     * Default constructor
     */
    public Habitation(String p_nomBatiment) {
        super(p_nomBatiment,0,0,0,
                0,0,0,0,0,0, "Habitation");
        nbDeHabitation++;
        prixConstruction *= nbDeHabitation;
    }

    public static int prixConstruction = 10000;
    public static int nbDeHabitation = 0;

}