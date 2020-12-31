package batiments;

import batiments.Batiment;

/**
 * 
 */
public class Usine extends Batiment {

    /**
     * Default constructor
     */
    public Usine() {
        super("Usine",0,0,0,
                0,0,0,0,0,0,"Usine");
        nbDeUsine++;
        prixConstruction *= nbDeUsine;
        this.setNomBatiment(nbDeUsine);
    }

    public static int prixConstruction = 10000;
    public static int nbDeUsine = 0;

}