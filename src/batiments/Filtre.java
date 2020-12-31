package batiments;

import batiments.Batiment;

/**
 * 
 */
public class Filtre extends Batiment {

    /**
     * Default constructor
     */
    public Filtre() {
        super("Filtre",0,0,0,
                0,0,0,0,0,0, "Filtre");
        nbDeFiltre++;
        prixConstruction *= nbDeFiltre;
        this.setNomBatiment(nbDeFiltre);
    }

    public static int prixConstruction = 10000;
    public static int nbDeFiltre = 0;

}