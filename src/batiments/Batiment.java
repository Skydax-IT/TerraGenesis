package batiments;

import java.util.*;

/**
 * 
 */
public class Batiment {

    /**
     * Default constructor
     */
    public Batiment(String p_nomBatiment, int p_prixBatiment, int p_tempsBatiment, int p_niveauBatiment, int p_pressionGenere,
                    int p_biomasseGenere, int p_eauGenere, int p_temperatureGenere, int p_oxygeneGenere, int p_populationGenere,
                    int p_argentGenere) {

        this.nomBatiment = p_nomBatiment;
        this.prixBatiment = p_prixBatiment;
        this.tempsBatiment = p_tempsBatiment;
        this.niveauBatiment = p_niveauBatiment;

        this.pressionGenere = p_pressionGenere;
        this.biomasseGenere = p_biomasseGenere;
        this.eauGenere = p_eauGenere;
        this.temperatureGenere = p_temperatureGenere;
        this.oxygeneGenere = p_oxygeneGenere;
        this.populationGenere = p_populationGenere;
        this.argentGenere = p_argentGenere;
    }

    /**
     * 
     */
    protected String nomBatiment;

    /**
     * 
     */
    protected int prixBatiment;

    /**
     * 
     */
    protected int tempsBatiment;

    /**
     * 
     */
    protected int niveauBatiment;

    /**
     * 
     */
    protected int pressionGenere;

    /**
     * 
     */
    protected int biomasseGenere;

    /**
     * 
     */
    protected int eauGenere;

    /**
     * 
     */
    protected int temperatureGenere;

    /**
     * 
     */
    protected int oxygeneGenere;

    /**
     * 
     */
    protected int populationGenere;

    /**
     * 
     */
    protected int argentGenere;

    @Override
    public String toString() {
        return "Batiment{" +
                "nomBatiment='" + nomBatiment + '\'' +
                ", prixBatiment=" + prixBatiment +
                ", tempsBatiment=" + tempsBatiment +
                ", niveauBatiment=" + niveauBatiment +
                ", pressionGenere=" + pressionGenere +
                ", biomasseGenere=" + biomasseGenere +
                ", eauGenere=" + eauGenere +
                ", temperatureGenere=" + temperatureGenere +
                ", oxygeneGenere=" + oxygeneGenere +
                ", populationGenere=" + populationGenere +
                ", argentGenere=" + argentGenere +
                '}';
    }

    public void ameliorationBatiment(){
        this.niveauBatiment++;

        this.tempsBatiment -= 0.8 * this.niveauBatiment;
        this.argentGenere += 0.8 * this.niveauBatiment;
        this.populationGenere += 1.2 * this.niveauBatiment;

        this.pressionGenere += this.niveauBatiment * 0.6;
        this.biomasseGenere += this.niveauBatiment * 0.6;
        this.eauGenere += this.niveauBatiment * 0.6;
        this.temperatureGenere += this.niveauBatiment * 0.6;
        this.oxygeneGenere += this.niveauBatiment * 0.6;
        this.populationGenere += this.niveauBatiment * 0.6;
        this.argentGenere += this.niveauBatiment * 0.6;
    }

    public String getNomBatiment() {
        return nomBatiment;
    }

    public void setNomBatiment(String nomBatiment) {
        this.nomBatiment = nomBatiment;
    }

    public int getPrixBatiment() {
        return prixBatiment;
    }

    public void setPrixBatiment(int prixBatiment) {
        this.prixBatiment = prixBatiment;
    }

    public int getTempsBatiment() {
        return tempsBatiment;
    }

    public void setTempsBatiment(int tempsBatiment) {
        this.tempsBatiment = tempsBatiment;
    }

    public int getNiveauBatiment() {
        return niveauBatiment;
    }

    public void setNiveauBatiment(int niveauBatiment) {
        this.niveauBatiment = niveauBatiment;
    }

    public int getPressionGenere() {
        return pressionGenere;
    }

    public void setPressionGenere(int pressionGenere) {
        this.pressionGenere = pressionGenere;
    }

    public int getBiomasseGenere() {
        return biomasseGenere;
    }

    public void setBiomasseGenere(int biomasseGenere) {
        this.biomasseGenere = biomasseGenere;
    }

    public int getEauGenere() {
        return eauGenere;
    }

    public void setEauGenere(int eauGenere) {
        this.eauGenere = eauGenere;
    }

    public int getTemperatureGenere() {
        return temperatureGenere;
    }

    public void setTemperatureGenere(int temperatureGenere) {
        this.temperatureGenere = temperatureGenere;
    }

    public int getOxygeneGenere() {
        return oxygeneGenere;
    }

    public void setOxygeneGenere(int oxygeneGenere) {
        this.oxygeneGenere = oxygeneGenere;
    }

    public int getPopulationGenere() {
        return populationGenere;
    }

    public void setPopulationGenere(int populationGenere) {
        this.populationGenere = populationGenere;
    }

    public int getArgentGenere() {
        return argentGenere;
    }

    public void setArgentGenere(int argentGenere) {
        this.argentGenere = argentGenere;
    }
}