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
        this.argent = 250000000;

        this.objectifTemperature = 287000;
        this.objectifPression = 100000;
        this.objectifOxygene = 210000;
        this.objectifEau = 600000;
        this.objectifBiomasse = 600000;
        this.objectifPopulation = 171;
        this.planete = new Planete("AA");

        this.initialiseTechnologie();

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

    private ArrayList<ArrayList<Technologie>> technologieTemperature;
    private ArrayList<ArrayList<Technologie>> technologieBiomasse;
    private ArrayList<ArrayList<Technologie>> technologieEau;
    private ArrayList<ArrayList<Technologie>> technologieOxygene;
    private ArrayList<ArrayList<Technologie>> technologiePopulation;
    private ArrayList<ArrayList<Technologie>> technologiePression;
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

        ArrayList<Technologie> a = new ArrayList<>();
        ArrayList<Technologie> b = new ArrayList<>();

        a.add(new Technologie(new Batiment("Usine de refroidissement",30,1,0,0,0,-4,0,0,0,"Température",1000),1000000,250, true));
        a.add(new Technologie(new Batiment("Plateforme aérostat",30,1,0,0,0,-40,0,0,2850,"Température",1000),2000000,500,false));
        a.add(new Technologie(new Batiment("Toile solaire",30,1,0,-30,0,-100,0,0,-4750,"Température",1000),6000000,750,false));

        b.add(new Technologie(new Batiment("Pôle de réchauffement",30,1,0,0,0,4,0,0,0,"Température",1000),1000000,250,true));
        b.add(new Technologie(new Batiment("Puits de forage",30,1,10,0,0,60,0,0,0,"Température",1000),2000000,500,false));
        b.add(new Technologie(new Batiment("Miroir Orbital",30,1,0,-30,-10,120,0,0,0,"Température",1000),6000000,750,false));


        this.technologieTemperature = new ArrayList<ArrayList<Technologie>>(){
            {
                add(a);
                add(b);
            }
        };


        ArrayList<Technologie> c = new ArrayList<>();
        ArrayList<Technologie> d = new ArrayList<>();

        c.add(new Technologie(new Batiment("Usine de séquestration",30,1,-4,0,0,0,0,0,0,"Pression",1000),1000000,250, true));
        c.add(new Technologie(new Batiment("Laboratoire de biodivision",30,1,-40,15,0,0,0,0,0,"Pression",1000),2000000,500, false));
        c.add(new Technologie(new Batiment("Transformateur d'hydrogène",30,1,-100,0,20,10,0,0,10,"Pression",1000),6000000,750, false));

        d.add(new Technologie(new Batiment("Poussière thermique",30,1,4,0,0,0,0,0,0,"Pression",1000),1000000,250, true));
        d.add(new Technologie(new Batiment("Ensemble atmogen",30,1,60,0,0,0,10,0,0,"Pression",1000),2000000,500, false));
        d.add(new Technologie(new Batiment("Exploitation de poches",30,1,100,0,0,0,20,0,1900,"Pression",1000),6000000,750, false));

        this.technologiePression = new ArrayList<ArrayList<Technologie>>(){
            {
               add(c);
               add(d);
            }
        };

        ArrayList<Technologie> e = new ArrayList<>();
        ArrayList<Technologie> f = new ArrayList<>();

        e.add(new Technologie(new Batiment("Filtre O2",30,0,0,0,0,0,-4,0,0,"Oxygene",1000),1000000,250, true));
        e.add(new Technologie(new Batiment("Fixateur de carbone",30,0,10,0,0,0,-40,0,0,"Oxygene",1000),2000000,500, false));
        e.add(new Technologie(new Batiment("Générateur hydro",30,0,0,0,20,0,-80,0,0,"Oxygene",1000),6000000,750, false));

        f.add(new Technologie(new Batiment("Usine d'oxygène",30,0,0,0,0,0,4,0,0,"Oxygene",1000),1000000,250, true));
        f.add(new Technologie(new Batiment("Cyanocuves",30,0,-10,0,0,0,60,0,0,"Oxygene",1000),2000000,500, false));
        f.add(new Technologie(new Batiment("Ferme de kelps",30,0,-10,30,0,0,120,0,0,"Oxygene",1000),6000000,750, false));

        this.technologieOxygene = new ArrayList<ArrayList<Technologie>>(){
            {
                add(e);
                add(f);
            }
        };

        ArrayList<Technologie> g = new ArrayList<>();
        ArrayList<Technologie> h = new ArrayList<>();

        g.add(new Technologie(new Batiment("Géociterne",30,0,0,0,-4,0,0,0,0,"Eau",1000),1000000,250, true));
        g.add(new Technologie(new Batiment("Usine d'électrolyse",30,0,0,0,-40,0,10,0,0,"Eau",1000),2000000,500, false));
        g.add(new Technologie(new Batiment("Lance-glace",30,0,-10,0,-120,0,0,0,2850,"Eau",1000),6000000,750, false));

        h.add(new Technologie(new Batiment("Semeur de nuages",30,0,0,0,4,0,0,0,0,"Eau",1000),1000000,250, true));
        h.add(new Technologie(new Batiment("Réseau aquifère",30,0,10,0,40,0,0,0,0,"Eau",1000),2000000,500, false));
        h.add(new Technologie(new Batiment("Redirection de comètes",30,0,0,-15,120,0,0,0,7600,"Eau",1000),6000000,750, false));


        this.technologieEau = new ArrayList<ArrayList<Technologie>>(){
            {
                add(g);
                add(h);
            }
        };

        ArrayList<Technologie> i = new ArrayList<>();
        ArrayList<Technologie> j = new ArrayList<>();

        i.add(new Technologie(new Batiment("Colonie d'algues",30,0,0,12,-4,0,0,0,0,"Biomasse",1000),1000000,250, true));
        i.add(new Technologie(new Batiment("Forêt de kelps",30,0,0,120,0,0,30,0,0,"Biomasse",1000),2000000,500, false));
        i.add(new Technologie(new Batiment("Récif de corail",30,0,0,0,179,0,0,21,3800,"Biomasse",1000),6000000,750, false));

        j.add(new Technologie(new Batiment("Ferme tellurique",30,0,0,6,0,0,0,0,0,"Biomasse",1000),1000000,250, true));
        j.add(new Technologie(new Batiment("Ferme d'herbacés",30,0,0,60,-10,0,0,0,0,"Biomasse",1000),2000000,500, false));
        j.add(new Technologie(new Batiment("Peuplement forestier",30,0,0,150,-20,0,20,0,0,"Biomasse",1000),6000000,750, false));


        this.technologieBiomasse = new ArrayList<ArrayList<Technologie>>(){
            {
                add(i);
                add(j);
            }
        };

        ArrayList<Technologie> k = new ArrayList<>();
        ArrayList<Technologie> l = new ArrayList<>();

        k.add(new Technologie(new Batiment("Unité d'habitation",30,0,0,0,0,0,0,85,0,"Population",1000),1000000,250, true));
        k.add(new Technologie(new Batiment("Complexe d'habitation",30,0,0,0,0,0,10,2125,0,"Population",1000),2000000,500, false));
        k.add(new Technologie(new Batiment("Dome d'habitation",30,0,0,15,20,0,0,42500,0,"Population",1000),6000000,750, false));

        l.add(new Technologie(new Batiment("Crèche pour enfants",30,0,0,0,0,0,0,11,0,"Population",1000),1000000,250, true));
        l.add(new Technologie(new Batiment("Réseau de transport",30,0,0,-15,0,0,0,84,0,"Population",1000),2000000,500, false));
        l.add(new Technologie(new Batiment("Port spatial",30,0,0,0,0,0,10,126,9500,"Population",1000),6000000,750, false));


        this.technologiePopulation = new ArrayList<ArrayList<Technologie>>(){
            {
                add(k);
                add(l);
            }
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

    public int rechercher(ArrayList<ArrayList<Technologie>>technologies, Technologie technologie){
        for(ArrayList<Technologie> listTech: technologies){
            if(listTech.contains(technologie)){
                return technologies.indexOf(listTech);
            }
        }
        return -1;
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

    public void testConstruBatiment(Ville ville, ArrayList<ArrayList<Technologie>> list, Batiment batiment,int index){
        for(Technologie technologie: list.get(index)){
            if(Objects.equals(technologie.getBatiment(), batiment)){
                 if(technologie.isDebloquer()){
                     this.achatJoeur(batiment.getPrixBatiment());
                     new Construction(this.planete,ville,batiment);
                 }else{
                     System.out.println("Vous devez d'abord débloquer la technologie " + batiment.getNomBatiment());
                 }
            }
        }
    }

    //Température, Pression, Oxygene, Eau, Biomasse
    public void construireBatiment(Ville ville, Batiment batiment, int index){//verif niveau techno

        if(this.argent >= batiment.getPrixBatiment()) {
            if(batiment.getTypeBatiment().equals("Population")){
                this.testConstruBatiment(ville, this.technologiePopulation,batiment,index);
            }
            else if(batiment.getTypeBatiment().equals("Température")){
                this.testConstruBatiment(ville, this.technologieTemperature,batiment,index);
            }
            else if(batiment.getTypeBatiment().equals("Pression")){
                this.testConstruBatiment(ville, this.technologiePression,batiment,index);
            }
            else if(batiment.getTypeBatiment().equals("Oxygene")){
                this.testConstruBatiment(ville, this.technologieOxygene,batiment,index);
            }
            else if(batiment.getTypeBatiment().equals("Eau")){
                this.testConstruBatiment(ville, this.technologieEau,batiment,index);
            }
            else if(batiment.getTypeBatiment().equals("Biomasse")){
                this.testConstruBatiment(ville, this.technologieBiomasse,batiment,index);
            }
        }else{
            System.out.println("Construction de "+ batiment.getNomBatiment() + " impossible!");
        }
    }

    public void supprimerBatiment(Ville ville, Batiment batiment){
        ville.supprimerBatiment(batiment);
    }

    public void construireMinePoste(Poste poste, Mine mine){
        int index = -1;

        for(Technologie technologie: this.technologieMine){
            if(technologie.getMine().equals(mine)){
                index = this.technologieMine.indexOf(technologie);
            }
        }
        
        if(this.argent >= mine.getPrixBatiment() && this.technologieMine.get(index).isDebloquer()){
            this.achatJoeur(mine.getPrixBatiment());
            new Construction(this.planete,poste,mine);
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
            if(technologie.isDebloquer() == true){ // Marche pour le mines! //Prend en compte que le dernier true -> checker les true et false de temp
                indexRecherche = technologies.indexOf(technologie);
            }
        }
        return indexRecherche + 1;
    }



    public void ameliorerTechnologie(Technologie technologie){
        if(technologie.isDebloquer() == false && this.argent >= technologie.getPrixTechnologie()) {

            int indexTech = this.rechercher(this.technologieTemperature,technologie);//TempTechno
            if(estRecherchable(this.technologieTemperature.get(indexTech)) == this.technologieTemperature.get(indexTech).indexOf(technologie)){
                    this.achatJoeur(technologie.getPrixTechnologie());
                    new Construction(this.technologieTemperature.get(indexTech), technologie);
            }else System.out.println("Recherche impossible! ");

            indexTech = this.rechercher(this.technologieBiomasse,technologie);//BiomasseTechno
            if(estRecherchable(this.technologieBiomasse.get(indexTech)) == this.technologieBiomasse.get(indexTech).indexOf(technologie)){
                this.achatJoeur(technologie.getPrixTechnologie());
                new Construction(this.technologieBiomasse.get(indexTech), technologie);
            }else System.out.println("Recherche impossible! ");

            indexTech = this.rechercher(this.technologieEau,technologie);//EauTechno
            if(estRecherchable(this.technologieEau.get(indexTech)) == this.technologieEau.get(indexTech).indexOf(technologie)){
                this.achatJoeur(technologie.getPrixTechnologie());
                new Construction(this.technologieEau.get(indexTech), technologie);
            }else System.out.println("Recherche impossible! ");

            indexTech = this.rechercher(this.technologieOxygene,technologie);//OxygeneTechno
            if(estRecherchable(this.technologieOxygene.get(indexTech)) == this.technologieOxygene.get(indexTech).indexOf(technologie)){
                this.achatJoeur(technologie.getPrixTechnologie());
                new Construction(this.technologieOxygene.get(indexTech), technologie);
            }else System.out.println("Recherche impossible! ");

            indexTech = this.rechercher(this.technologiePopulation,technologie);//PopuTechno
            if(estRecherchable(this.technologiePopulation.get(indexTech)) == this.technologiePopulation.get(indexTech).indexOf(technologie)){
                this.achatJoeur(technologie.getPrixTechnologie());
                new Construction(this.technologiePopulation.get(indexTech), technologie);
            }else System.out.println("Recherche impossible! ");

            indexTech = this.rechercher(this.technologiePression,technologie);//PressionTechno
            if(estRecherchable(this.technologiePression.get(indexTech)) == this.technologiePression.get(indexTech).indexOf(technologie)){
                this.achatJoeur(technologie.getPrixTechnologie());
                new Construction(this.technologiePression.get(indexTech), technologie);
            }else System.out.println("Recherche impossible! ");

            if(this.technologieMine.contains(technologie) && estRecherchable(this.technologieMine) == this.technologieMine.indexOf(technologie)){
                this.achatJoeur(technologie.getPrixTechnologie());
                new Construction(this.technologieMine, technologie);
            }else System.out.println("Recherche impossible! ");

        }else System.out.println("Cette Technologie ne peut être améliorée! ");
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

    public ArrayList<ArrayList<Technologie>> getTechnologieTemperature() {
        return technologieTemperature;
    }

    public void setTechnologieTemperature(ArrayList<ArrayList<Technologie>> technologieTemperature) {
        this.technologieTemperature = technologieTemperature;
    }

    public ArrayList<ArrayList<Technologie>> getTechnologieBiomasse() {
        return technologieBiomasse;
    }

    public void setTechnologieBiomasse(ArrayList<ArrayList<Technologie>> technologieBiomasse) {
        this.technologieBiomasse = technologieBiomasse;
    }

    public ArrayList<ArrayList<Technologie>> getTechnologieEau() {
        return technologieEau;
    }

    public void setTechnologieEau(ArrayList<ArrayList<Technologie>> technologieEau) {
        this.technologieEau = technologieEau;
    }

    public ArrayList<ArrayList<Technologie>> getTechnologieOxygene() {
        return technologieOxygene;
    }

    public void setTechnologieOxygene(ArrayList<ArrayList<Technologie>> technologieOxygene) {
        this.technologieOxygene = technologieOxygene;
    }

    public ArrayList<ArrayList<Technologie>> getTechnologiePopulation() {
        return technologiePopulation;
    }

    public void setTechnologiePopulation(ArrayList<ArrayList<Technologie>> technologiePopulation) {
        this.technologiePopulation = technologiePopulation;
    }

    public ArrayList<ArrayList<Technologie>> getTechnologiePression() {
        return technologiePression;
    }

    public void setTechnologiePression(ArrayList<ArrayList<Technologie>> technologiePression) {
        this.technologiePression = technologiePression;
    }

    public ArrayList<Technologie> getTechnologieMine() {
        return technologieMine;
    }

    public void setTechnologieMine(ArrayList<Technologie> technologieMine) {
        this.technologieMine = technologieMine;
    }
}