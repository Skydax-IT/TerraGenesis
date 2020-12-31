package batiments;

import batiments.Batiment;

/**
 * 
 */
public class Jardin extends Batiment {

    /**
     * Default constructor
     */
    public Jardin() {
        super("Jardin",0,0,0,
                0,0,0,0,0,0,"Jardin");
        nbDeJardin++;
        prixConstruction *= nbDeJardin;
        this.setNomBatiment(nbDeJardin);
    }

    public static int prixConstruction = 10000;
    public static int nbDeJardin = 0;

}