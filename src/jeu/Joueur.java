package jeu;

import batiments.*;
import javafx.geometry.Pos;
import planete.Planete;
import planete.Poste;
import planete.Ville;
import technologies.Technologie;

import java.util.*;

/**
 * 
 */
public class Joueur{

    /**
     * Default constructor
     */
    public Joueur() {
        this.argent = 2000000;

        this.objectifTemperature = 287000;
        this.objectifPression = 100000;
        this.objectifOxygene = 210000;
        this.objectifEau = 600000;
        this.objectifBiomasse = 600000;
        this.objectifPopulation = 171;
        this.planete = new Planete("AA");


        //this.initialiserJoueur();

    }


    /**
     * 
     */
    private int argent;

    /**
     * 
     */
    private String nom;


    /**
     *
     */
    private Planete planete;

    /**
     *
     */
    private final int objectifTemperature;

    /**
     *
     */
    private final int objectifPression;

    /**
     *
     */
    private final int objectifOxygene;

    /**
     *
     */
    private final int objectifEau;

    /**
     *
     */
    private final int objectifBiomasse;

    /**
     *
     */
    private final int objectifPopulation;

    private ArrayList<Technologie> technologieTemperature;
    private ArrayList<Technologie> technologieBiomasse;
    private ArrayList<Technologie> technologieEau;
    private ArrayList<Technologie> technologieOxygene;
    private ArrayList<Technologie> technologiePopulation;
    private ArrayList<Technologie> technologiePression;
    private ArrayList<Technologie> technologieMine;

    /**
     * 
     */
    public void initialiserJoueur() {
        this.nom = askForString("Veuillez choisir votre nom d'aventurier ? ");
        System.out.println("Bien le bonjour " + this.nom + "!\nVous êtes fin prêt à commencer votre aventure.\n" +
                "Il est maintenant temps d'établir votre première colonie\n");
        String nomPlanete = askForString("Quel nom voulez-vous donner à votre planète ?");
        this.planete = new Planete(nomPlanete);
    }

    public void initialiseTechnologie(){
        this.technologieTemperature = new ArrayList<Technologie>(){
            {
                add(new Technologie(new Batiment("Usine de refroidissement",30,1,0,0,0,-4,0,0,0,"Température",1000),1000000,250, true));
                add(new Technologie(new Batiment("Plateforme aérostat",30,1,0,0,0,-40,0,0,2850,"Température",1000),2000000,500,false));
                add(new Technologie(new Batiment("Toile solaire",30,1,0,-30,0,-100,0,0,-4750,"Température",1000),6000000,750,false));
                add(new Technologie(new Batiment("Pôle de réchauffement",30,1,0,0,0,4,0,0,0,"Température",1000),1000000,250,true));
                add(new Technologie(new Batiment("Puits de forage",30,1,10,0,0,60,0,0,0,"Température",1000),2000000,500,false));
                add(new Technologie(new Batiment("Miroir Orbital",30,1,0,-30,-10,120,0,0,0,"Température",1000),6000000,750,false));
            }
        };

        this.technologiePression = new ArrayList<Technologie>(){
            {
                add(new Technologie(new Batiment("Usine de séquestration",30,1,-4,0,0,0,0,0,0,"Pression",1000),1000000,250, true));
                add(new Technologie(new Batiment("Laboratoire de biodivision",30,1,-40,15,0,0,0,0,0,"Pression",1000),2000000,500, false));
                add(new Technologie(new Batiment("Transformateur d'hydrogène",30,1,-100,0,20,10,0,0,10,"Pression",1000),6000000,750, false));
                add(new Technologie(new Batiment("Poussière thermique",30,1,4,0,0,0,0,0,0,"Pression",1000),1000000,250, true));
                add(new Technologie(new Batiment("Ensemble atmogen",30,1,60,0,0,0,10,0,0,"Pression",1000),2000000,500, false));
                add(new Technologie(new Batiment("Exploitation de poches",30,1,100,0,0,0,20,0,1900,"Pression",1000),6000000,750, false));
            }
        };

        this.technologieOxygene = new ArrayList<Technologie>(){
            {
                add(new Technologie(new Batiment("Filtre O2",30,0,0,0,0,0,-4,0,0,"Oxygene",1000),1000000,250, true));
                add(new Technologie(new Batiment("Fixateur de carbone",30,0,10,0,0,0,-40,0,0,"Oxygene",1000),2000000,500, false));
                add(new Technologie(new Batiment("Générateur hydro",30,0,0,0,20,0,-80,0,0,"Oxygene",1000),6000000,750, false));
                add(new Technologie(new Batiment("Usine d'oxygène",30,0,0,0,0,0,4,0,0,"Oxygene",1000),1000000,250, true));
                add(new Technologie(new Batiment("Cyanocuves",30,0,-10,0,0,0,60,0,0,"Oxygene",1000),2000000,500, false));
                add(new Technologie(new Batiment("Ferme de kelps",30,0,-10,30,0,0,120,0,0,"Oxygene",1000),6000000,750, false));

            }
        };

        this.technologieEau = new ArrayList<Technologie>(){
            {
                add(new Technologie(new Batiment("Géociterne",30,0,0,0,-4,0,0,0,0,"Eau",1000),1000000,250, true));
                add(new Technologie(new Batiment("Usine d'électrolyse",30,0,0,0,-40,0,10,0,0,"Eau",1000),2000000,500, false));
                add(new Technologie(new Batiment("Lance-glace",30,0,-10,0,-120,0,0,0,2850,"Eau",1000),6000000,750, false));
                add(new Technologie(new Batiment("Semeur de nuages",30,0,0,0,4,0,0,0,0,"Eau",1000),1000000,250, true));
                add(new Technologie(new Batiment("Réseau aquifère",30,0,10,0,40,0,0,0,0,"Eau",1000),2000000,500, false));
                add(new Technologie(new Batiment("Redirection de comètes",30,0,0,-15,120,0,0,0,7600,"Eau",1000),6000000,750, false));

            }
        };

        this.technologieBiomasse = new ArrayList<Technologie>(){
            {
                add(new Technologie(new Batiment("Colonie d'algues",30,0,0,12,-4,0,0,0,0,"Biomasse",1000),1000000,250, true));
                add(new Technologie(new Batiment("Forêt de kelps",30,0,0,120,0,0,30,0,0,"Biomasse",1000),2000000,500, false));
                add(new Technologie(new Batiment("Récif de corail",30,0,0,0,179,0,0,21,3800,"Biomasse",1000),6000000,750, false));
                add(new Technologie(new Batiment("Ferme tellurique",30,0,0,6,0,0,0,0,0,"Biomasse",1000),1000000,250, true));
                add(new Technologie(new Batiment("Ferme d'herbacés",30,0,0,60,-10,0,0,0,0,"Biomasse",1000),2000000,500, false));
                add(new Technologie(new Batiment("Peuplement forestier",30,0,0,150,-20,0,20,0,0,"Biomasse",1000),6000000,750, false));
            }
        };

        this.technologiePopulation = new ArrayList<Technologie>(){
            {
                add(new Technologie(new Batiment("Unité d'habitation",30,0,0,0,0,0,0,85,0,"Population",1000),1000000,250, true));
                add(new Technologie(new Batiment("Complexe d'habitation",30,0,0,0,0,0,10,2125,0,"Population",1000),2000000,500, false));
                add(new Technologie(new Batiment("Dome d'habitation",30,0,0,15,20,0,0,42500,0,"Population",1000),6000000,750, false));
                add(new Technologie(new Batiment("Crèche pour enfants",30,0,0,0,0,0,0,11,0,"Population",1000),1000000,250, true));
                add(new Technologie(new Batiment("Réseau de transport",30,0,0,-15,0,0,0,84,0,"Population",1000),2000000,500, false));
                add(new Technologie(new Batiment("Port spatial",30,0,0,0,0,0,10,126,9500,"Population",1000),6000000,750, false));            }
        };

        this.technologieMine = new ArrayList<Technologie>(){
            {
                add(new Technologie(new Mine("Carbone",30,0,0,0,0,0,0,0,100000,"Ressources minières",1000),1000000,250, true));
                add(new Technologie(new Mine("Fer",30,0,0,0,0,0,0,0,250000,"Ressources minières",1000),2000000,500, false));
                add(new Technologie(new Mine("Argent",30,0,0,0,0,0,0,0,1000000,"Ressources minières",1000),6000000,750, false));
                add(new Technologie(new Mine("Palladium",30,0,0,0,0,0,0,0,2500000,"Ressources minières",1000),10000000,1000, false));
                add(new Technologie(new Mine("Rhodium",30,0,0,0,0,0,0,0,7500000,"Ressources minières",1000),12500000,1250, false));
            }
        };
    }

    /**
     * 
     */
    public void achatJoeur(int prix) {
        this.argent -= prix;
    }

    public void constuireVille(){
        if(this.argent >= Ville.prixConstruction) {
            String nomVille = this.askForString("Quel nom voulez-vous donner à votre ville ? ");
            this.achatJoeur(Ville.prixConstruction); // A mettre avant sinon prix change quand classe ville est créée
            new Construction(this.planete, new Ville(nomVille));
        }else{
            System.out.println("Impossible de construire une ville! Il vous manque " + (Ville.prixConstruction - this.argent));
        }
    }

    public void supprimerVille(Ville ville){
        System.out.println("Ville " + ville.getNomVille() + " Supprimée");
        this.planete.supprimerVille(ville);
    }

    public void construirePoste(){
        if(this.argent >= Poste.prixConstruction){
            String nomPoste = this.askForString("Quel nom voulez-vous donner à votre poste ? ");
            this.achatJoeur(Poste.prixConstruction);
            new Construction(this.planete, new Poste(nomPoste));
        }else{
            System.out.println("Impossible de construire un poste! Il vous manque " + (Poste.prixConstruction - this.argent));
        }

    }

    public void supprimerPoste(Poste poste){
        System.out.println("Poste " + poste.getNomPoste() + " Supprimé");
        this.planete.supprimerPoste(poste);
    }

    public void construireBatiment(Ville ville, Batiment batiment){ // Verif niveau technologique

        if(this.argent >= batiment.getPrixBatiment()) {
            this.achatJoeur(batiment.getPrixBatiment());
            new Construction(this.planete,ville,batiment);
        }else{
            System.out.println("Construction de "+ batiment.getNomBatiment() + " impossible!");
        }
    }

    public void supprimerBatiment(Ville ville, Batiment batiment){
        ville.supprimerBatiment(batiment);
    }

    public void construireMinePoste(Poste poste, Mine mine){//Verif niveau technologique
        if(this.argent >= mine.getPrixBatiment()){
            this.achatJoeur(mine.getPrixBatiment());
            new Construction(poste,mine);
        }
        else{
            System.out.println("Construction de "+ mine.getNomBatiment() + " impossible!");
        }
    }

    public void supprimerMinePoste(Poste poste, Mine mine){
        this.planete.supprimerMinePoste(poste,mine);
    }

    public int estRecherchable(ArrayList<Technologie> technologies){ // Pb avec les technologies négative et positive
        int indexRecherche = 0;
        for(Technologie technologie : technologies){
            if(technologie.isDebloquer() == true){ // Marche pour le mines!
                indexRecherche += 1;
            }
        }
        return indexRecherche;
    }

    public int estRecherchablePosNeg(ArrayList<Technologie> technologies, Technologie technologie){
        if(technologies.indexOf(technologie) < 3){
            "".toString();
        }
        return 1;
    }


    public void ameliorerTechnologie(Technologie technologie){
        if(technologie.isDebloquer() == false && technologie.getPrixTechnologie() >= this.argent)
            if(this.technologieTemperature.contains(technologie) && estRecherchable(this.technologieTemperature) == this.technologieTemperature.indexOf(technologie)){
                //Condition à revoir pour bat neg et pos
                this.achatJoeur(technologie.getPrixTechnologie());
                new Construction(this.technologieTemperature,technologie);
            }
    }

    public String askForString(String phrase){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println(phrase); //fenetre pop-up
        return myObj.nextLine();
    }

    /**
     *
     */
    public boolean verifierVictoire() {
        if((this.planete.getTemperature() >= this.objectifTemperature) && (this.planete.getPression() >= this.objectifPression)
                && (this.planete.getOxygene() >= this.objectifOxygene ) && (this.planete.getEau() >= this.objectifEau)
                && (this.planete.getBiomasse() >= this.objectifBiomasse ) && (this.planete.getPopulation() >= this.objectifPopulation)){
            return true;
        }else{
            return false;
        }
    }

    public void afficherResumePlanete(){
        String resume = "Résumé: " + this.planete.getNom() +
                "\nTempérature: " + this.planete.getTemperature() + '/' + this.objectifTemperature + "\n" +
                "Pression: " + this.planete.getPression() + '/' + this.objectifPression + "\n" +
                "Oxygène: " + this.planete.getOxygene() + '/' + this.objectifOxygene + "\n" +
                "Eau: " + this.planete.getEau() + '/' + this.objectifEau + "\n" +
                "Biomasse: " + this.planete.getBiomasse() + '/' + this.objectifBiomasse + "\n" +
                "Population: " + this.planete.getPopulation() + '/' + this.objectifPopulation + "\n"
                ;
        System.out.println(resume);
    }



    public int getArgent() {
        return argent;
    }

    public void setArgent(int argent) {
        this.argent = argent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Planete getPlanete() {
        return planete;
    }

    public void setPlanete(Planete planete) {
        this.planete = planete;
    }
}