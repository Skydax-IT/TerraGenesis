package batiments;

import batiments.Batiment;

/**
 * 
 */
public class Transformateur extends Batiment {

    /**
     * Default constructor
     */
    public Transformateur() {
        super("Transformateur",0,0,0,
                0,0,0,0,0,0, "Transformateur");
        nbDeTransformateur++;
        prixConstruction *= nbDeTransformateur;
        this.setNomBatiment(nbDeTransformateur);
    }

    public static int prixConstruction = 10000;
    public static int nbDeTransformateur = 0;

}