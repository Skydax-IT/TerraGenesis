package technologies;

import batiments.Batiment;
import batiments.Mine;



/**Permet de créer une technologie
 * 
 */
public class Technologie {

    /**Créer une technologie pour tous les batiments
     * Default constructor
     */
    public Technologie(Batiment batiment, int prixTechnologie, int tempsTechnologie, boolean debloquer) {
        this.batiment = batiment;
        this.prixTechnologie = prixTechnologie;
        this.tempsTechnologie = tempsTechnologie;
        this.debloquer = debloquer;

    }

    /**Constructeur d'une technologie de type mine
     *
     */
    public Technologie(Mine mine, int prixTechnologie, int tempsTechnologie, boolean debloquer) {
        this.mine = mine;
        this.prixTechnologie = prixTechnologie;
        this.tempsTechnologie = tempsTechnologie;
        this.debloquer = debloquer;

    }

    /**Le batiment présent dans le technologie
     * 
     */
    private Batiment batiment;

    /**
     *La mine présente dans la technologie
     */
    private Mine mine;

    /**
     * Le coût de la technologie
     */
    private int prixTechnologie;

    /**
     * Le temps de construction de la techno
     */
    private int tempsTechnologie;

    /**
     *Si la technologie a été recherchée
     */
    private boolean debloquer;

    /**L'affichage de la classe technologie
     *String
     * void
     */
    @Override
    public String toString() {
        return  batiment +
                " , Prix : " + prixTechnologie +
                " , Temps de construction : " + tempsTechnologie
                ;
    }

    /**Getter and setter
     *
     */

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