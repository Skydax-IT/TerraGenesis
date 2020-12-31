package batiments;

import batiments.Batiment;

/**
 * 
 */
public class Citerne extends Batiment {

    /**
     * Default constructor
     */
    public Citerne(String p_nomBatiment) {
        super(p_nomBatiment,0,0,0,
                0,0,0,0,0,0,"Citerne");
        nbDeCiterne++;
        prixConstruction *= nbDeCiterne;
    }

    public static int prixConstruction = 10000;
    public static int nbDeCiterne = 0;


}