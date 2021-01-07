package planete;

import batiments.Batiment;
import batiments.Mine;

import java.util.*;

/**
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
        this.tempsConstruction = 1000;

        nbDePoste++;
        prixConstruction *= nbDePoste;

    }

    public static int prixConstruction = 100000;
    public static int nbDePoste = 0;

    /**
     * 
     */
    private final String nomPoste;

    /**
     * 
     */
    private ArrayList<Mine> mines;

    /**
     * 
     */
    private int nbMines;

    /**
     *
     */
    private int argentGenere;

    /**
     *
     */
    private int tempsConstruction;

    @Override
    public String toString() {
        return this.nomPoste;
    }

    public void actuStatPoste(Mine mine, boolean add){
        if(add){
            this.argentGenere += mine.getArgentGenere();
            this.nbMines ++;
        }else{
            this.argentGenere -= mine.getArgentGenere();
            this.nbMines --;
        }
    }

    /**
     *
     * @param mine
     */
    public void ajouterMine(Mine mine) {
        this.mines.add(mine);
        this.actuStatPoste(mine,true);
    }

    /**
     * 
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