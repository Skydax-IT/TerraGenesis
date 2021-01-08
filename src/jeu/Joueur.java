package jeu;

import batiments.*;
import planete.Planete;
import planete.Poste;
import planete.Ville;
import technologies.Technologie;

import java.util.*;

/**
 * 
 */
public class Joueur {

    /**
     * Default constructor
     */
    public Joueur() {
        this.argent = 2500000;

        this.objectifTemperature = 200000;
        this.objectifPression = 600;
        this.objectifOxygene = 1704;
        this.objectifEau = 21;
        this.objectifBiomasse = 0;
        this.objectifPopulation = 0;
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
    public void initialiserJoueur(String nomJoueur, String nomPlanete) {
        this.nom = nomJoueur;
        this.planete = new Planete(nomPlanete);
        System.out.println(this.nom);
        System.out.println(this.planete.getNom());
    }

    public void initialiseTechnologie() {

        ArrayList<Technologie> a = new ArrayList<>();
        ArrayList<Technologie> b = new ArrayList<>();

        a.add(new Technologie(new Batiment("Usine de refroidissement", 30, 0, 0, 0, -4, 0, 0, 0, "Température", 1000), 1000000, 250, true));
        a.add(new Technologie(new Batiment("Plateforme aérostat", 30, 0, 0, 0, -40, 0, 0, 2850, "Température", 1000), 2000000, 500, false));
        a.add(new Technologie(new Batiment("Toile solaire", 30, 0, -30, 0, -100, 0, 0, -4750, "Température", 1000), 6000000, 750, false));

        b.add(new Technologie(new Batiment("Pôle de réchauffement", 30, 0, 0, 0, 4, 0, 0, 0, "Température", 1000), 1000000, 250, true));
        b.add(new Technologie(new Batiment("Puits de forage", 30, 10, 0, 0, 60, 0, 0, 0, "Température", 1000), 2000000, 500, false));
        b.add(new Technologie(new Batiment("Miroir Orbital", 30, 0, -30, -10, 120, 0, 0, 0, "Température", 1000), 6000000, 750, false));


        this.technologieTemperature = new ArrayList<ArrayList<Technologie>>() {
            {
                add(a);
                add(b);
            }
        };


        ArrayList<Technologie> c = new ArrayList<>();
        ArrayList<Technologie> d = new ArrayList<>();

        c.add(new Technologie(new Batiment("Usine de séquestration", 30, -4, 0, 0, 0, 0, 0, 0, "Pression", 1000), 1000000, 250, true));
        c.add(new Technologie(new Batiment("Laboratoire de biodivision", 30, -40, 15, 0, 0, 0, 0, 0, "Pression", 1000), 2000000, 500, false));
        c.add(new Technologie(new Batiment("Transformateur d'hydrogène", 30, -100, 0, 20, 10, 0, 0, 10, "Pression", 1000), 6000000, 750, false));

        d.add(new Technologie(new Batiment("Poussière thermique", 30, 4, 0, 0, 0, 0, 0, 0, "Pression", 1000), 1000000, 250, true));
        d.add(new Technologie(new Batiment("Ensemble atmogen", 30, 60, 0, 0, 0, 10, 0, 0, "Pression", 1000), 2000000, 500, false));
        d.add(new Technologie(new Batiment("Exploitation de poches", 30, 100, 0, 0, 0, 20, 0, 1900, "Pression", 1000), 6000000, 750, false));

        this.technologiePression = new ArrayList<ArrayList<Technologie>>() {
            {
                add(c);
                add(d);
            }
        };

        ArrayList<Technologie> e = new ArrayList<>();
        ArrayList<Technologie> f = new ArrayList<>();

        e.add(new Technologie(new Batiment("Filtre O2", 30, 0, 0, 0, 0, -4, 0, 0, "Oxygene", 1000), 1000000, 250, true));
        e.add(new Technologie(new Batiment("Fixateur de carbone", 30, 10, 0, 0, 0, -40, 0, 0, "Oxygene", 1000), 2000000, 500, false));
        e.add(new Technologie(new Batiment("Générateur hydro", 30, 0, 0, 20, 0, -80, 0, 0, "Oxygene", 1000), 6000000, 750, false));

        f.add(new Technologie(new Batiment("Usine d'oxygène", 30, 0, 0, 0, 0, 4, 0, 0, "Oxygene", 1000), 1000000, 250, true));
        f.add(new Technologie(new Batiment("Cyanocuves", 30, -10, 0, 0, 0, 60, 0, 0, "Oxygene", 1000), 2000000, 500, false));
        f.add(new Technologie(new Batiment("Ferme de kelps", 30, -10, 30, 0, 0, 120, 0, 0, "Oxygene", 1000), 6000000, 750, false));

        this.technologieOxygene = new ArrayList<ArrayList<Technologie>>() {
            {
                add(e);
                add(f);
            }
        };

        ArrayList<Technologie> g = new ArrayList<>();
        ArrayList<Technologie> h = new ArrayList<>();

        g.add(new Technologie(new Batiment("Géociterne", 30, 0, 0, -4, 0, 0, 0, 0, "Eau", 1000), 1000000, 250, true));
        g.add(new Technologie(new Batiment("Usine d'électrolyse", 30, 0, 0, -40, 0, 10, 0, 0, "Eau", 1000), 2000000, 500, false));
        g.add(new Technologie(new Batiment("Lance-glace", 30, -10, 0, -120, 0, 0, 0, 2850, "Eau", 1000), 6000000, 750, false));

        h.add(new Technologie(new Batiment("Semeur de nuages", 30, 0, 0, 4, 0, 0, 0, 0, "Eau", 1000), 1000000, 250, true));
        h.add(new Technologie(new Batiment("Réseau aquifère", 30, 10, 0, 40, 0, 0, 0, 0, "Eau", 1000), 2000000, 500, false));
        h.add(new Technologie(new Batiment("Redirection de comètes", 30, 0, -15, 120, 0, 0, 0, 7600, "Eau", 1000), 6000000, 750, false));


        this.technologieEau = new ArrayList<ArrayList<Technologie>>() {
            {
                add(g);
                add(h);
            }
        };

        ArrayList<Technologie> i = new ArrayList<>();
        ArrayList<Technologie> j = new ArrayList<>();

        i.add(new Technologie(new Batiment("Colonie d'algues", 30, 0, 12, -4, 0, 0, 0, 0, "Biomasse", 1000), 1000000, 250, true));
        i.add(new Technologie(new Batiment("Forêt de kelps", 30, 0, 120, 0, 0, 30, 0, 0, "Biomasse", 1000), 2000000, 500, false));
        i.add(new Technologie(new Batiment("Récif de corail", 30, 0, 179, 0, 0, 0, 21, 3800, "Biomasse", 1000), 6000000, 750, false));

        j.add(new Technologie(new Batiment("Ferme tellurique", 30, 0, 6, 0, 0, 0, 0, 0, "Biomasse", 1000), 1000000, 250, true));
        j.add(new Technologie(new Batiment("Ferme d'herbacés", 30, 0, 60, -10, 0, 0, 0, 0, "Biomasse", 1000), 2000000, 500, false));
        j.add(new Technologie(new Batiment("Peuplement forestier", 30, 0, 150, -20, 0, 20, 0, 0, "Biomasse", 1000), 6000000, 750, false));


        this.technologieBiomasse = new ArrayList<ArrayList<Technologie>>() {
            {
                add(i);
                add(j);
            }
        };

        ArrayList<Technologie> k = new ArrayList<>();
        ArrayList<Technologie> l = new ArrayList<>();

        k.add(new Technologie(new Batiment("Unité d'habitation", 30, 0, 0, 0, 0, 0, 85, 0, "Population", 1000), 1000000, 250, true));
        k.add(new Technologie(new Batiment("Complexe d'habitation", 30, 0, 0, 0, 0, 10, 2125, 0, "Population", 1000), 2000000, 500, false));
        k.add(new Technologie(new Batiment("Dome d'habitation", 30, 0, 15, 20, 0, 0, 42500, 0, "Population", 1000), 6000000, 750, false));

        l.add(new Technologie(new Batiment("Crèche pour enfants", 30, 0, 0, 0, 0, 0, 11, 0, "Population", 1000), 1000000, 250, true));
        l.add(new Technologie(new Batiment("Réseau de transport", 30, 0, -15, 0, 0, 0, 84, 0, "Population", 1000), 2000000, 500, false));
        l.add(new Technologie(new Batiment("Port spatial", 30, 0, 0, 0, 0, 10, 126, 9500, "Population", 1000), 6000000, 750, false));


        this.technologiePopulation = new ArrayList<ArrayList<Technologie>>() {
            {
                add(k);
                add(l);
            }
        };

        this.technologieMine = new ArrayList<Technologie>() {
            {
                add(new Technologie(new Mine("Carbone", 30, 0, 0, 0, 0, 0, 0, 100000, "Ressources minières", 1000), 1000000, 250, true));
                add(new Technologie(new Mine("Fer", 30, 0, 0, 0, 0, 0, 0, 250000, "Ressources minières", 1000), 2000000, 500, false));
                add(new Technologie(new Mine("Argent", 30, 0, 0, 0, 0, 0, 0, 1000000, "Ressources minières", 1000), 6000000, 750, false));
                add(new Technologie(new Mine("Palladium", 30, 0, 0, 0, 0, 0, 0, 2500000, "Ressources minières", 1000), 10000000, 1000, false));
                add(new Technologie(new Mine("Rhodium", 30, 0, 0, 0, 0, 0, 0, 7500000, "Ressources minières", 1000), 12500000, 1250, false));
            }
        };
    }

    /**
     *
     */
    public void achatJoueur(int prix) {
        this.argent -= prix;
    }

    public int rechercher(ArrayList<ArrayList<Technologie>> technologies, Technologie technologie) {
        for (ArrayList<Technologie> listTech : technologies) {
            if (listTech.contains(technologie)) {
                return technologies.indexOf(listTech);
            }
        }
        return -1;
    }

    public void constuireVille(String nomVille) {
        if (this.argent >= Ville.prixConstruction) {
            this.achatJoueur(Ville.prixConstruction); // A mettre avant sinon prix change quand classe ville est créée
            new Construction(this.planete, new Ville(nomVille));
        } else {
            System.out.println("Impossible de construire une ville! Il vous manque " + (Ville.prixConstruction - this.argent));
        }
    }

    public void supprimerVille(Ville ville) {
        System.out.println("Ville " + ville.getNomVille() + " Supprimée");
        this.planete.supprimerVille(ville);
    }

    public void construirePoste(String nomPoste) {
        if (this.argent >= Poste.prixConstruction) {
            this.achatJoueur(Poste.prixConstruction);
            new Construction(this.planete, new Poste(nomPoste));
        } else {
            System.out.println("Impossible de construire un poste! Il vous manque " + (Poste.prixConstruction - this.argent));
        }
    }

    public void supprimerPoste(Poste poste) {
        System.out.println("Poste " + poste.getNomPoste() + " Supprimé");
        this.planete.supprimerPoste(poste);
    }


    public void construireBatiment(Ville ville, Batiment batiment) {//verif niveau techno

        if (this.argent >= batiment.getPrixBatiment()) {
            this.achatJoueur(batiment.getPrixBatiment());
            new Construction(this.planete, ville, batiment);
        } else {
            System.out.println("Construction de " + batiment.getNomBatiment() + " impossible!");
        }
    }

    public void supprimerBatiment(Ville ville, Batiment batiment) {
        System.out.println("Le bâtiment " + batiment.getNomBatiment() + " a été supprimé");
        this.planete.supprimerBatimentVille(ville, batiment);
    }

    public void construireMinePoste(Poste poste, Mine mine) {
        int index = -1;

        for (Technologie technologie : this.technologieMine) {
            if (technologie.getMine().equals(mine)) {
                index = this.technologieMine.indexOf(technologie);
            }
        }

        if (this.argent >= mine.getPrixBatiment() && this.technologieMine.get(index).isDebloquer()) {
            this.achatJoueur(mine.getPrixBatiment());
            new Construction(this.planete, poste, mine);
        } else {
            System.out.println("Construction de " + mine.getNomBatiment() + " impossible!");
        }
    }

    public void supprimerMinePoste(Poste poste, Mine mine) {
        System.out.println("La mine " + mine.getNomBatiment() + " a été supprimée");
        this.planete.supprimerMinePoste(poste, mine);
    }

    public int estRecherchable(ArrayList<Technologie> technologies) { // Pb avec les technologies négative et positive
        int indexRecherche = -2;
        for (Technologie technologie : technologies) {
            if (technologie.isDebloquer() == true) { // Marche pour le mines! //Prend en compte que le dernier true -> checker les true et false de temp
                indexRecherche = technologies.indexOf(technologie);
            }
        }
        return indexRecherche + 1;
    }


    public void ameliorerTechnologie(ArrayList<Technologie> listeTech, Technologie technologie) {
        if (technologie.isDebloquer() == false && this.argent >= technologie.getPrixTechnologie() && !listeTech.isEmpty()) {
            if (estRecherchable(listeTech) == listeTech.indexOf(technologie)) {
                this.achatJoueur(technologie.getPrixTechnologie());
                new Construction(listeTech, technologie);
            }

            /*
            int indexTech = this.rechercher(this.technologieTemperature,technologie);//TempTechno
            if(indexTech >= 0){
                if(estRecherchable(this.technologieTemperature.get(indexTech)) == this.technologieTemperature.get(indexTech).indexOf(technologie)){
                    this.achatJoueur(technologie.getPrixTechnologie());
                    new Construction(this.technologieTemperature.get(indexTech), technologie);
                }else System.out.println("Recherche impossible! ");
            }

            indexTech = this.rechercher(this.technologieBiomasse,technologie);//BiomasseTechno
            if(indexTech >= 0){
                if(estRecherchable(this.technologieBiomasse.get(indexTech)) == this.technologieBiomasse.get(indexTech).indexOf(technologie)){
                    this.achatJoueur(technologie.getPrixTechnologie());
                    new Construction(this.technologieBiomasse.get(indexTech), technologie);
                }else System.out.println("Recherche impossible! ");
            }

            indexTech = this.rechercher(this.technologieEau,technologie);//EauTechno
            if(indexTech >= 0){
                if(estRecherchable(this.technologieEau.get(indexTech)) == this.technologieEau.get(indexTech).indexOf(technologie)){
                    this.achatJoueur(technologie.getPrixTechnologie());
                    new Construction(this.technologieEau.get(indexTech), technologie);
                }else System.out.println("Recherche impossible! ");
            }


            indexTech = this.rechercher(this.technologieOxygene,technologie);//OxygeneTechno
            if(indexTech >= 0){
                if(estRecherchable(this.technologieOxygene.get(indexTech)) == this.technologieOxygene.get(indexTech).indexOf(technologie)){
                    this.achatJoueur(technologie.getPrixTechnologie());
                    new Construction(this.technologieOxygene.get(indexTech), technologie);
                }else System.out.println("Recherche impossible! ");
            }

            indexTech = this.rechercher(this.technologiePopulation,technologie);//PopuTechno
            if(indexTech >= 0){
                if(estRecherchable(this.technologiePopulation.get(indexTech)) == this.technologiePopulation.get(indexTech).indexOf(technologie)){
                    this.achatJoueur(technologie.getPrixTechnologie());
                    new Construction(this.technologiePopulation.get(indexTech), technologie);
                }else System.out.println("Recherche impossible! ");
            }


            indexTech = this.rechercher(this.technologiePression,technologie);//PressionTechno
            if(indexTech >= 0){
                if(estRecherchable(this.technologiePression.get(indexTech)) == this.technologiePression.get(indexTech).indexOf(technologie)){
                    this.achatJoueur(technologie.getPrixTechnologie());
                    new Construction(this.technologiePression.get(indexTech), technologie);
                }else System.out.println("Recherche impossible! ");
            }
            */
            if (this.technologieMine.contains(technologie) && estRecherchable(this.technologieMine) == this.technologieMine.indexOf(technologie)) {
                this.achatJoueur(technologie.getPrixTechnologie());
                new Construction(this.technologieMine, technologie);
            } else System.out.println("Recherche impossible! ");

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

    public int getObjectifTemperature() {
        return objectifTemperature;
    }

    public int getObjectifPression() {
        return objectifPression;
    }

    public int getObjectifOxygene() {
        return objectifOxygene;
    }

    public int getObjectifEau() {
        return objectifEau;
    }

    public int getObjectifBiomasse() {
        return objectifBiomasse;
    }

    public int getObjectifPopulation() {
        return objectifPopulation;
    }
}