package batiments;

import batiments.Batiment;

/**
 * 
 */
public class Citerne extends Batiment {

    /**
     * Default constructor
     */
    public Citerne() {
        super("Citerne",0,0,0,
                0,45,0,0,0,0,"Citerne");
        nbDeCiterne++;
        prixConstruction *= nbDeCiterne;
        this.setNomBatiment(nbDeCiterne);
    }

    public static int prixConstruction = 10000;
    public static int nbDeCiterne = 0;


}