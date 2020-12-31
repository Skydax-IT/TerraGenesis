package batiments;

import batiments.Batiment;

/**
 * 
 */
public class Filtre extends Batiment {

    /**
     * Default constructor
     */
    public Filtre(String p_nomBatiment) {
        super(p_nomBatiment,0,0,0,
                0,0,0,0,0,0, "Filtre");
        nbDeFiltre++;
        prixConstruction *= nbDeFiltre;
    }

    public static int prixConstruction = 10000;
    public static int nbDeFiltre = 0;

}