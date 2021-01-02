package jeu;

import batiments.Batiment;
import planete.Planete;
import planete.Poste;
import planete.Ville;

public class Construction extends Thread{

    public Construction(Planete p_planete,Ville p_ville){
        this.planete = p_planete;
        this.ville = p_ville;
        this.typeConstruction = "Ville";

        this.start();
    }

    public Construction(Planete p_planete,Poste p_poste){
        this.planete = p_planete;
        this.poste = p_poste;
        this.typeConstruction = "Poste";

        this.start();
    }

    public Construction(Planete p_planete,Ville p_ville,Batiment p_batiment){
        this.planete = p_planete;
        this.ville = p_ville;
        this.batiment = p_batiment;
        this.typeConstruction = "Batiment";

        this.start();
    }


    private Ville ville;
    private Planete planete;
    private Poste poste;
    private Batiment batiment;

    private String typeConstruction;

    @Override
    public void run() {
        try {
            if(this.typeConstruction.equals("Ville")){
                System.out.println("Construction de " + this.ville.getNomVille() + " durant " + this.ville.getTempsConstruction()/1000 + " secondes");
                Thread.sleep(this.ville.getTempsConstruction());
                this.planete.ajoutVille(this.ville);
                System.out.println("La ville " + this.ville.getNomVille()+ " vient d'être construite!");
            }
            else if(this.typeConstruction.equals("Poste")){
                System.out.println("Construction de " + this.poste.getNomPoste() + " durant " + this.poste.getTempsConstruction()/1000 + " secondes");
                Thread.sleep(this.poste.getTempsConstruction());
                this.planete.ajoutPoste(this.poste);
                System.out.println("Le poste " + this.poste.getNomPoste()+ " vient d'être construit!");
            }
            else if(this.typeConstruction.equals("Batiment")){
                System.out.println("Construction de " + this.batiment.getNomBatiment() + " dans " + this.ville.getNomVille() + " durant " + this.batiment.getTempsConstruction()/1000 + " secondes");
                Thread.sleep(this.batiment.getTempsConstruction());
                this.planete.ajoutBatimentVille(this.ville,this.batiment);
                System.out.println("Le bâtiment " + this.batiment.getNomBatiment()+ " vient d'être construit à " + this.ville.getNomVille() +  '!');
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
