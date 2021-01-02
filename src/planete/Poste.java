package planete;

import batiments.Mine;

import java.util.*;

/**
 * 
 */
public class Poste extends Thread{

    /**
     * Default constructor
     */
    public Poste(String nomPoste) {
        this.nomPoste = nomPoste;
        this.mines = new ArrayList<>();
        this.nbMines = this.mines.size();
        this.argentGenere = 0;
        this.tempsConstruction = 8000;

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
        return "Poste{" +
                "nomPoste='" + nomPoste + '\'' +
                ", mines=" + mines +
                ", nbMines=" + nbMines +
                ", argentGenere=" + argentGenere +
                ", tempsConstruction=" + tempsConstruction +
                '}';
    }

    @Override
    public void run() {
        try {
            System.out.println("Construction de " + this.nomPoste + " durant " + this.tempsConstruction/1000 + " secondes");
            Thread.sleep(this.tempsConstruction);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Le poste " + this.nomPoste + " vient d'être construit!");
    }

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