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
        this.argentGenere = getStatPoste();

    }

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
        this.nbMines ++;
    }

    /**
     * 
     */
    public void supprimerMine(Mine mineSuppr){//String nomMine) {
        try {
            this.mines.remove(mineSuppr);
            this.nbMines --;
        }
        catch(IndexOutOfBoundsException exception){
            System.out.println("Suppression impossible");
        }
    }

    public int getStatPoste(){
        int argentGenereParLesMines = 0;
        for(Mine mine: this.mines){
            argentGenereParLesMines += mine.getArgentGenere();
        }
        return argentGenereParLesMines;
    }

}