package planete;

import batiments.Batiment;
import batiments.Mine;
import technologies.Technologie;

import java.util.*;


/**
 * Permet de créer une planète et de gérer ses statistiques
 */
public class Planete {

    /**
     * Default constructor
     */
    public Planete(String nomPlanete) {
        this.nom = nomPlanete;
        this.temperature = 200000; //mK
        this.pression = 600; //Pa
        this.oxygene = 1700; //ppm
        this.eau = 17; //cm
        this.biomasse = 0; //nécessite 10k pression//Mt
        this.argent = 0;
        this.population = 0;
        this.villes = new ArrayList<Ville>();
        this.postes = new ArrayList<Poste>();

        this.nbVilles = 0;
        this.nbPostes = 0;

        this.date = new Date();

    }

    /**
     *Le nombre de ville sur la planète
     */
    private int nbVilles;

    /**
     *Le nombre de postes sur la planète
     */
    private int nbPostes;

    /**
     * La température de la planète en Mk
     */
    private int temperature;

    /**
     * La pression sur la planèete en Pa
     */
    private int pression;

    /**
     * L'oxygène présent sur la planète en ppm
     */
    private int oxygene;

    /**
     * L'eau présente sur la planete en cm
     */
    private int eau;

    /**
     * L'argent généré par la planète
     */
    private int argent;

    /**
     * La bioamsse présente sur al planète en Mt
     */
    private int biomasse;

    /**
     * La population de la planète
     */
    private int population;

    /**
     * La date
     */
    private Date date;

    /**
     * Le nom de la planète
     */
    private String nom;

    /**
     * la liste des villes sur la planète
     */
    private ArrayList<Ville> villes;

    /**
     * La liste des postes
     */
    private ArrayList<Poste> postes;



    /**Actualise les stats de la planète en fonction d'une ville
     *void
     * La ville qui fait varier les stats de la planète, le boolean qui permet de savoir si on ajoute ou supprime
     */
    public void actuStatPlaneteNouvelleVille(Ville nouvelleVille, boolean add) {
        if(add){
            this.temperature += nouvelleVille.getTemperatureGenere();
            this.pression += nouvelleVille.getPressionGenere();
            this.oxygene += nouvelleVille.getOxygeneGenere();
            this.eau += nouvelleVille.getEauGenere();
            this.biomasse += nouvelleVille.getBiomasseGenere();
            this.argent += nouvelleVille.getArgentGenere();
            this.population += nouvelleVille.getPopulationGenere();
            this.nbVilles ++;
        }else{
            this.temperature -= nouvelleVille.getTemperatureGenere();
            this.pression -= nouvelleVille.getPressionGenere();
            this.oxygene -= nouvelleVille.getOxygeneGenere();
            this.eau -= nouvelleVille.getEauGenere();
            this.biomasse -= nouvelleVille.getBiomasseGenere();
            this.argent -= nouvelleVille.getArgentGenere();
            this.population -= nouvelleVille.getPopulationGenere();
            this.nbVilles --;
        }
    }

    /**Permet d'actualiser la planète en fonction d'un poste
     *void
     *Le poste qui influe sur les constantes, le boolean qui détermine si on ajoute on supprime à la planète
     */
    public void actuStatPlaneteNouveauPoste(Poste poste, boolean add){
        if(add){
            this.nbPostes ++;
            this.argent += poste.getArgentGenere();
        }else{
            this.nbPostes --;
            this.argent -= poste.getArgentGenere();
        }
    }


    /**Permet d'ajouter une ville à la planète
     *void
     * La ville à ajouter
     */
    public void ajoutVille(Ville nouvelleVille) {
        villes.add(nouvelleVille);
        actuStatPlaneteNouvelleVille(nouvelleVille,true);
    }

    /**Supprime une ville
     * La ville à supprimer
     */
    public void supprimerVille(Ville villeSuppr) {
        try {
            this.villes.remove(villeSuppr);
            this.actuStatPlaneteNouvelleVille(villeSuppr,false);
        }
        catch(IndexOutOfBoundsException exception){
            System.out.println("Suppression impossible");
        }
    }

    /**Ajoute un poste sur la planète
     * void
     * poste à ajouter
     */
    public void ajoutPoste(Poste poste) {
        this.postes.add(poste);
        this.actuStatPlaneteNouveauPoste(poste,true);
    }

    /**Supprime un poste
     * void
     * poste à supprimer
     */
    public void supprimerPoste(Poste posteSuppr) {
        try {
            this.postes.remove(posteSuppr);
            this.actuStatPlaneteNouveauPoste(posteSuppr,false);
        }
        catch(IndexOutOfBoundsException exception){
            System.out.println("Suppression impossible");
        }
    }

    /**Ajoute une mine à un poste
     * void
     * Le poste sur lequel on fait les changements, la mine à ajouter
     */
    public void ajoutMinePoste(Poste poste, Mine mine){
        this.actuStatPlaneteNouveauPoste(poste,false);
        poste.ajouterMine(mine);
        this.actuStatPlaneteNouveauPoste(poste,true);
    }

    /**Supprimer une mine sur un poste
     *Le poste, la mine à supprimée
     */
    public void supprimerMinePoste(Poste poste, Mine mine){
        this.actuStatPlaneteNouveauPoste(poste,false);
        poste.supprimerMine(mine);
    }

    /**Permet d'ajouter un batiment à une ville
     *void
     * La ville qui va recevoir les changements, le nouveau batiment
     */
    public void ajoutBatimentVille(Ville ville, Batiment batiment){
        this.actuStatPlaneteNouvelleVille(ville,false);
        ville.ajoutBatiment(batiment);
        this.actuStatPlaneteNouvelleVille(ville,true);
    }

    /**Supprime un batiment d'une ville
     *void
     * La ville et le batiment à supprimer
     */
    public void supprimerBatimentVille(Ville ville, Batiment batiment){
        this.actuStatPlaneteNouvelleVille(ville,false);
        ville.supprimerBatiment(batiment);
        this.actuStatPlaneteNouvelleVille(ville,true);
    }

    /**Getter and setter
     *
     */
    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getPression() {
        return pression;
    }

    public void setPression(int pression) {
        this.pression = pression;
    }

    public int getOxygene() {
        return oxygene;
    }

    public void setOxygene(int oxygene) {
        this.oxygene = oxygene;
    }

    public int getEau() {
        return eau;
    }

    public void setEau(int eau) {
        this.eau = eau;
    }

    public int getArgent() {
        return argent;
    }

    public void setArgent(int argent) {
        this.argent = argent;
    }

    public int getBiomasse() {
        return biomasse;
    }

    public void setBiomasse(int biomasse) {
        this.biomasse = biomasse;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Ville> getVilles() {
        return villes;
    }

    public void setVilles(ArrayList<Ville> villes) {
        this.villes = villes;
    }

    public ArrayList<Poste> getPostes() {
        return postes;
    }

    public void setPostes(ArrayList<Poste> postes) {
        this.postes = postes;
    }

    /**Affichage de la planète
     *String
     */
    @Override
    public String toString() {
        return "Planete{" +
                ", nom='" + nom + '\'' +
                ", temperature=" + temperature +
                ", pression=" + pression +
                ", oxygene=" + oxygene +
                ", eau=" + eau +
                ", argent=" + argent +
                ", biomasse=" + biomasse +
                ", population=" + population +
                ", date=" + date +
                "nbVilles=" + nbVilles +
                ", nbPostes=" + nbPostes +
                ", villes=" + villes +
                ", postes=" + postes +
                '}';
    }
}