package jeu;

import batiments.*;
import planete.Planete;
import planete.Poste;
import planete.Ville;
import technologies.Technologie;

import java.util.*;

/**class Joueur
 * Permet de créer un joueur et ses actions
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
     *solde du joueur
     */
    private int argent;

    /**
     *nom joueur
     */
    private String nom;


    /**
     *La planète du joueur
     */
    private Planete planete;

    /**
     *L'objectif de température à atteindre
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

    /**Permet d'initialiser le nom du joueur et de la planete
     *void
     * nom du joeur, nom de la planete
     */
    public void initialiserJoueur(String nomJoueur, String nomPlanete) {
        this.nom = nomJoueur;
        this.planete = new Planete(nomPlanete);
        System.out.println(this.nom);
        System.out.println(this.planete.getNom());
    }

    /**Inialise les technologies présentent dans le jeu
     *void
     * void
     */
    public void initialiseTechnologie() { //Initialisation des technologies disponibles

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

    /**Permet de changer le solde quand des achats sont effectués
     *void
     * le prix de l'achat
     */
    public void achatJoueur(int prix) {
        this.argent -= prix;
    }

    /**Permet de construire une ville sur la planete
     *void
     * le nom de la ville
     */
    public void constuireVille(String nomVille) {
        if (this.argent >= Ville.prixConstruction) {
            this.achatJoueur(Ville.prixConstruction); // A mettre avant sinon prix change quand classe ville est créée
            new Construction(this.planete, new Ville(nomVille));
        } else {
            System.out.println("Impossible de construire une ville! Il vous manque " + (Ville.prixConstruction - this.argent));
        }
    }

    /**Permet de supprimer une ville
     *void
     * La ville a supprimée
     */
    public void supprimerVille(Ville ville) {
        System.out.println("Ville " + ville.getNomVille() + " Supprimée");
        this.planete.supprimerVille(ville);
    }

    /**Construit un poste sur la planète
     *void
     * Nom du poste
     */
    public void construirePoste(String nomPoste) {
        if (this.argent >= Poste.prixConstruction) {
            this.achatJoueur(Poste.prixConstruction);
            new Construction(this.planete, new Poste(nomPoste));
        } else {
            System.out.println("Impossible de construire un poste! Il vous manque " + (Poste.prixConstruction - this.argent));
        }
    }

    /**Supprime un poste
     *void
     * Le poste a supprimé
     */
    public void supprimerPoste(Poste poste) {
        System.out.println("Poste " + poste.getNomPoste() + " Supprimé");
        this.planete.supprimerPoste(poste);
    }

    /**Construit un batiment dans une ville
     *void
     * La ville dans laquelle construire et le batiment à bâtir
     */
    public void construireBatiment(Ville ville, Batiment batiment) {//verif niveau techno

        if (this.argent >= batiment.getPrixBatiment()) {
            this.achatJoueur(batiment.getPrixBatiment());
            new Construction(this.planete, ville, batiment);
        } else {
            System.out.println("Construction de " + batiment.getNomBatiment() + " impossible!");
        }
    }

    /**Supprime le bâtiment dans la ville choisit
     *void
     * La ville dans laquelle détruire et le bâtiment a supprimé
     */
    public void supprimerBatiment(Ville ville, Batiment batiment) {
        System.out.println("Le bâtiment " + batiment.getNomBatiment() + " a été supprimé");
        this.planete.supprimerBatimentVille(ville, batiment);
    }

    /**Construit une mine dans le poste choisit
     *void
     * Le poste et la mine à construire
     */
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

    /**Supprime une mine dans un poste
     *void
     * Le poste et la mine a supprimée
     */
    public void supprimerMinePoste(Poste poste, Mine mine) {
        System.out.println("La mine " + mine.getNomBatiment() + " a été supprimée");
        this.planete.supprimerMinePoste(poste, mine);
    }

    /**Permet de savoir la premiere technologie pouvant être améliorée
     *l'index de la première technologie pouvant être améliorée
     * Une liste de technologies
     */
    public int estRecherchable(ArrayList<Technologie> technologies) {
        int indexRecherche = -2;
        for (Technologie technologie : technologies) {
            if (technologie.isDebloquer() == true) {
                indexRecherche = technologies.indexOf(technologie);
            }
        }
        return indexRecherche + 1;
    }

    /**Permet d'améliorer une technologie
     *void
     * Une liste de technologie contenant la technologie, la technologie à améliorer
     */
    public void ameliorerTechnologie(ArrayList<Technologie> listeTech, Technologie technologie) {
        if (technologie.isDebloquer() == false && this.argent >= technologie.getPrixTechnologie() && !listeTech.isEmpty()) {
            if (estRecherchable(listeTech) == listeTech.indexOf(technologie)) {
                this.achatJoueur(technologie.getPrixTechnologie());
                new Construction(listeTech, technologie);
            }

            if (this.technologieMine.contains(technologie) && estRecherchable(this.technologieMine) == this.technologieMine.indexOf(technologie)) {
                this.achatJoueur(technologie.getPrixTechnologie());
                new Construction(this.technologieMine, technologie);
            } else System.out.println("Recherche impossible! ");

        }else System.out.println("Cette Technologie ne peut être améliorée! ");
    }

    /**Verifie si les Objectifs sont atteints
     *void
     * void
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

    /**Getter and setter
     *
     */
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