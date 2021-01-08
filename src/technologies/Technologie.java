package technologies;

import batiments.Batiment;
import batiments.Mine;

import java.util.*;

/**
 * 
 */
public class Technologie {

    /**
     * Default constructor
     */
    public Technologie(Batiment batiment, int prixTechnologie, int tempsTechnologie, boolean debloquer) {
        this.batiment = batiment;
        this.prixTechnologie = prixTechnologie;
        this.tempsTechnologie = tempsTechnologie;
        this.debloquer = debloquer;

    }

    public Technologie(Mine mine, int prixTechnologie, int tempsTechnologie, boolean debloquer) {
        this.mine = mine;
        this.prixTechnologie = prixTechnologie;
        this.tempsTechnologie = tempsTechnologie;
        this.debloquer = debloquer;

    }

    /**
     * 
     */
    private Batiment batiment;

    private Mine mine;

    /**
     * 
     */
    private int prixTechnologie;

    /**
     * 
     */
    private int tempsTechnologie;

    /**
     *
     */
    private boolean debloquer;

    @Override
    public String toString() {
        return  batiment +
                " , Prix : " + prixTechnologie +
                " , Temps de construction : " + tempsTechnologie
                ;
    }

    public Batiment getBatiment() {
        return this.batiment;
    }

    public Mine getMine(){
        return this.mine;
    }

    public void setNom(Batiment batiment) {
        this.batiment = batiment;
    }

    public int getPrixTechnologie() {
        return prixTechnologie;
    }

    public void setPrixTechnologie(int prixTechnologie) {
        this.prixTechnologie = prixTechnologie;
    }

    public int getTempsTechnologie() {
        return tempsTechnologie;
    }

    public void setTempsTechnologie(int tempsTechnologie) {
        this.tempsTechnologie = tempsTechnologie;
    }

    public boolean isDebloquer() {
        return debloquer;
    }

    public void setDebloquer(boolean debloquer) {
        this.debloquer = debloquer;
    }
}