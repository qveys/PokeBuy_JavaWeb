
package model;

public class ModelClient {
    private Integer numClient;
    private String nomClient;
    private String prenomClient;
    private String adrNomRue;
    private ModelLocalite localite;
    private Long numTel;
    private String email;
    private String motDePasse;
    private boolean publicite;
    private String langueParDefaut;

    public ModelClient() {
    }

    public ModelClient(String email) {
        this.email = email;
    }

    public ModelClient(String nomClient, String prenomClient, String adrNomRue, ModelLocalite localite, Long numTel, String email, String motDePasse, boolean publicite, String langueParDefaut) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.adrNomRue = adrNomRue;
        this.localite = localite;
        this.numTel = numTel;
        this.email = email;
        this.motDePasse = motDePasse;
        this.publicite = publicite;
        this.langueParDefaut = langueParDefaut;
    }

    public ModelClient(Integer numClient, String nomClient, String prenomClient, String adrNomRue, ModelLocalite localite, Long numTel, String email, String motDePasse, boolean publicite, String langueParDefaut) {
        this.numClient = numClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.adrNomRue = adrNomRue;
        this.localite = localite;
        this.numTel = numTel;
        this.email = email;
        this.motDePasse = motDePasse;
        this.publicite = publicite;
        this.langueParDefaut = langueParDefaut;
    }

    public Integer getNumClient() {
        return numClient;
    }

    public void setNumClient(Integer numClient) {
        this.numClient = numClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }
    
    public String getAdrNomRue() {
        return adrNomRue;
    }

    public void setAdrNomRue(String adrNomRue) {
        this.adrNomRue = adrNomRue;
    }

    public ModelLocalite getLocalite() {
        return localite;
    }

    public void setLocalite(ModelLocalite localite) {
        this.localite = localite;
    }

    public Long getNumTel() {
        return numTel;
    }

    public void setNumTel(Long numTel) {
        this.numTel = numTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean isPublicite() {
        return publicite;
    }

    public void setPublicite(boolean publicite) {
        this.publicite = publicite;
    }

    public String getLangueParDefaut() {
        return langueParDefaut;
    }

    public void setLangueParDefaut(String langueParDefaut) {
        this.langueParDefaut = langueParDefaut;
    }
    
}
