package batiments;

import batiments.Batiment;

/**
 * 
 */
public class Jardin extends Batiment {

    /**
     * Default constructor
     */
    public Jardin(String p_nomBatiment) {
        super(p_nomBatiment,0,0,0,
                0,0,0,0,0,0,"Jardin");
        nbDeJardin++;
        prixConstruction *= nbDeJardin;
    }

    public static int prixConstruction = 10000;
    public static int nbDeJardin = 0;

}