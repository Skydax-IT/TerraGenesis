package batiments;

import batiments.Batiment;

/**
 * 
 */
public class Habitation extends Batiment {

    /**
     * Default constructor
     */
    public Habitation() {
        super("Habitation",0,0,0,
                0,0,0,0,0,0, "Habitation");
        nbDeHabitation++;
        prixConstruction *= nbDeHabitation;
        this.setNomBatiment(nbDeHabitation);
    }

    public static int prixConstruction = 10000;
    public static int nbDeHabitation = 0;

}