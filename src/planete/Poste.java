package planete;

import batiments.Mine;

import java.util.*;

/**
 * 
 */
public class Poste {

    /**
     * Default constructor
     */
    public Poste(String nomPoste) {
        this.nomPoste = nomPoste;
        this.mines = new ArrayList<>();
        this.nbMines = this.mines.size();
        this.argentGenere = 0;

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
    public void ajouterMine(Mine mine) {
        this.mines.add(mine);
        this.actuStatPoste();
    }

    /**
     * 
     */
    public void supprimerMine(Mine mineSuppr){//String nomMine) {
        try {
            this.mines.remove(mineSuppr);
            this.actuStatPoste();
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

    public void actuStatPoste(){
        this.argentGenere = 0;
        this.nbMines = 0;

        for(Mine mine: this.mines){
            this.argentGenere += mine.getArgentGenere();
            this.nbMines ++;
        }
    }

}