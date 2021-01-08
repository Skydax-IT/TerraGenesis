package batiments;



/**Permet de créer un batiment et de gérer leurs constantes
 * 
 */
public class Batiment {

    /**
     * Default constructor
     */
    public Batiment(String p_nomBatiment, int p_tempsConstruction, int p_pressionGenere,
                    int p_biomasseGenere, int p_eauGenere, int p_temperatureGenere, int p_oxygeneGenere, int p_populationGenere,
                    int p_argentGenere, String p_typeBatiment, int p_prixBatiment) {

        this.nomBatiment = p_nomBatiment;
        this.tempsConstruction = p_tempsConstruction;

        this.pressionGenere = p_pressionGenere;
        this.biomasseGenere = p_biomasseGenere;
        this.eauGenere = p_eauGenere;
        this.temperatureGenere = p_temperatureGenere;
        this.oxygeneGenere = p_oxygeneGenere;
        this.populationGenere = p_populationGenere;
        this.argentGenere = p_argentGenere;
        this.typeBatiment = p_typeBatiment;
        this.prixBatiment = p_prixBatiment;

    }

    /**
     * nom du batiment
     */
    protected String nomBatiment;


    /**
     * temps de construction du batiment
     */
    protected int tempsConstruction;

    /**
     * La pression qu'il génére
     */
    protected int pressionGenere;

    /**
     * la biomasse générée
     */
    protected int biomasseGenere;

    /**
     * l'eau généré
     */
    protected int eauGenere;

    /**
     * la température générée
     */
    protected int temperatureGenere;

    /**
     * l'oxygène générée
     */
    protected int oxygeneGenere;

    /**
     * la population générée
     */
    protected int populationGenere;

    /**
     * l'argent généré
     */
    protected int argentGenere;

    /**
     *le type de bâtiment
     */
    protected String typeBatiment;

    /**
     *le coût de construction du batiment
     */
    private int prixBatiment;

    /**Affichage du bâtiment
     *String
     */
    @Override
    public String toString() {
        String string = nomBatiment;
        if (pressionGenere != 0){
            string += " , Pression " + pressionGenere;
        }
        if (eauGenere != 0){
            string += " , Eau " + eauGenere;
        }
        if (temperatureGenere != 0){
            string += " , Température " + temperatureGenere;
        }
        if (biomasseGenere != 0){
            string += " , Biomasse " + biomasseGenere;
        }
        if (populationGenere != 0){
            string += " , Population " + populationGenere;
        }
        if (oxygeneGenere != 0){
            string += " , Oxygène " + oxygeneGenere;
        }
        if (argentGenere != 0){
            string += " , Argent " + argentGenere;
        }
        return  string;
    }

    /**
     *Getter and setter
     */
    public String getNomBatiment() {
        return nomBatiment;
    }

    public int getTempsConstruction() {
        return tempsConstruction;
    }

    public void setTempsConstruction(int tempsConstruction) {
        this.tempsConstruction = tempsConstruction;
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

    public String getTypeBatiment() {
        return typeBatiment;
    }

    public void setTypeBatiment(String typeBatiment) {
        this.typeBatiment = typeBatiment;
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
}