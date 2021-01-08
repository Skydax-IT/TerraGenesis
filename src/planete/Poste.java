package planete;

import batiments.Mine;

import java.util.*;

/**Permet la création de poste contenant des mines
 * 
 */
public class Poste{

    /**
     * Default constructor
     */
    public Poste(String nomPoste) {
        this.nomPoste = nomPoste;
        this.mines = new ArrayList<>();
        this.nbMines = this.mines.size();
        this.argentGenere = 0;
        this.tempsConstruction = 15000;

        nbDePoste++;
        prixConstruction *= nbDePoste;

    }
    /**
     *Prix de construction
     */
    public static int prixConstruction = 100000;

    /**
     *le nombre de postes qui ont été construit
     */
    public static int nbDePoste = 0;

    /**
     * le nom du poste
     */
    private final String nomPoste;

    /**
     * Liste de mines
     */
    private ArrayList<Mine> mines;

    /**
     * Le nombre de mines présentes
     */
    private int nbMines;

    /**
     *L'argent généré par le poste
     */
    private int argentGenere;

    /**
     *Le temps de construction du poste
     */
    private int tempsConstruction;

    /**Affichage du poste
     *Le nom du poste
     */
    @Override
    public String toString() {
        return this.nomPoste;
    }

    /**Actualise les stats du poste
     *void
     * La mine qui influe sur les stats, le boolean qui permet de savoir si on ajoute ou prélève
     */
    public void actuStatPoste(Mine mine, boolean add){
        if(add){
            this.argentGenere += mine.getArgentGenere();
            this.nbMines ++;
        }else{
            this.argentGenere -= mine.getArgentGenere();
            this.nbMines --;
        }
    }

    /**Permet d'ajouter une mine au poste
     *void
     * @param mine à ajouter
     */
    public void ajouterMine(Mine mine) {
        this.mines.add(mine);
        this.actuStatPoste(mine,true);
    }

    /**Supprime une mine du poste
     * void
     * Mine à supprimer
     */
    public void supprimerMine(Mine mineSuppr){//String nomMine) {
        try {
            this.mines.remove(mineSuppr);
            this.actuStatPoste(mineSuppr,false);
        }
        catch(IndexOutOfBoundsException exception){
            System.out.println("Suppression impossible");
        }
    }

    /**Getter and setter
     *
     */
    public String getNomPoste() {
        return nomPoste;
    }

    public ArrayList<Mine> getMines() {
        return mines;
    }

    public void setMines(ArrayList<Mine> mines) {
        this.mines = mines;
    }

    public int getNbMines() {
        return nbMines;
    }

    public void setNbMines(int nbMines) {
        this.nbMines = nbMines;
    }

    public int getArgentGenere() {
        return argentGenere;
    }

    public void setArgentGenere(int argentGenere) {
        this.argentGenere = argentGenere;
    }

    public static int getPrixConstruction() {
        return prixConstruction;
    }

    public static void setPrixConstruction(int prixConstruction) {
        Poste.prixConstruction = prixConstruction;
    }

    public static int getNbDePoste() {
        return nbDePoste;
    }

    public static void setNbDePoste(int nbDePoste) {
        Poste.nbDePoste = nbDePoste;
    }

    public int getTempsConstruction() {
        return tempsConstruction;
    }

    public void setTempsConstruction(int tempsConstruction) {
        this.tempsConstruction = tempsConstruction;
    }
}