package controller;

import business.PokemonSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.ModelClient;
import model.ModelLocalite;

@Named(value = "clientController")
@SessionScoped
public class ClientController implements Serializable {

    @EJB
    private PokemonSessionBeanLocal pokemonSessionBean;

    private ModelLocalite localite;
    private Short postCode = 1000;
    private String ville;

    private ModelClient clientActuel = null;
    private ModelClient client = null;
    private boolean isConnected = false;

    private String nomClient;
    private String prenomClient;
    private String adrNomRue;
    private String numTel;
    private String email;
    private String motDePasse;
    private String confirmMDP;
    private boolean publicité;

    public ClientController() {
    }

    public PokemonSessionBeanLocal getPokemonSessionBean() {
        return pokemonSessionBean;
    }

    public void setPokemonSessionBean(PokemonSessionBeanLocal pokemonSessionBean) {
        this.pokemonSessionBean = pokemonSessionBean;
    }

    public ModelLocalite getLocalite() {
        return localite;
    }

    public void setLocalite(ModelLocalite localite) {
        this.localite = localite;
    }

    public Short getPostCode() {
        return postCode;
    }

    public void setPostCode(Short postCode) {
        this.postCode = postCode;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville.toUpperCase();
    }

    public ModelClient getClientActuel() {
        return clientActuel;
    }

    public void setClientActuel(ModelClient clientActuel) {
        this.clientActuel = clientActuel;
    }

    public ModelClient getClient() {
        return client;
    }

    public void setClient(ModelClient client) {
        this.client = client;
    }

    public boolean isIsConnected() {
        return isConnected;
    }

    public void setIsConnected(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient.toUpperCase();
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient.toUpperCase();
    }

    public String getAdrNomRue() {
        return adrNomRue;
    }

    public void setAdrNomRue(String adrNomRue) {
        this.adrNomRue = adrNomRue.toUpperCase();
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toUpperCase();
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getConfirmMDP() {
        return confirmMDP;
    }

    public void setConfirmMDP(String confirmMDP) {
        this.confirmMDP = confirmMDP;
    }

    public boolean isPublicité() {
        return publicité;
    }

    public void setPublicité(boolean publicité) {
        this.publicité = publicité;
    }

    public String cryptPassword(String password) {
        MessageDigest md;
        String message = "password";
        try {
            md = MessageDigest.getInstance("SHA-512");

            md.update(message.getBytes());
            byte[] mb = md.digest();
            String out = "";
            for (int i = 0; i < mb.length; i++) {
                byte temp = mb[i];
                String s = Integer.toHexString(new Byte(temp));
                while (s.length() < 2) {
                    s = "0" + s;
                }
                s = s.substring(s.length() - 2);
                out += s;
            }
            return out;

        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public ArrayList<ModelLocalite> getLocaliteByPostCode() {
        ArrayList<ModelLocalite> newLocalites = getPokemonSessionBean().getLocalitesByPostCode(getPostCode());
        if (newLocalites.size() > 0) {
            return newLocalites;
        } else {
            return new ArrayList<>();
        }
    }

    public String createNewClient() {
        setLocalite(new ModelLocalite(getPostCode(), getVille()));
        setMotDePasse(cryptPassword(getMotDePasse()));
        Long numTel = Long.parseLong(getNumTel());
        String langueCourante = FacesContext.getCurrentInstance().getViewRoot().getLocale().toString();
        ModelClient newClient = new ModelClient(getNomClient(), getPrenomClient(), getAdrNomRue(), getLocalite(), numTel, getEmail(), getMotDePasse(), isPublicité(), langueCourante);
        setClient(newClient);
        getPokemonSessionBean().setNewClient(newClient);
        setClientActuel(newClient);
        connection();
        return "index?faces-redirect=true";
    }

    public String connection() {
        String mdpCrypt = cryptPassword(getMotDePasse());
        client = getPokemonSessionBean().getClientByEmail(getEmail(), mdpCrypt);

        try {
            /*Si Client.getEmail() ne vaut pas null, il y a donc bien possibilité de connection!*/
            if (client.getEmail().equals(getEmail())) {

                try {
                    /*Le Client existe, mais est-ce le bon mot de passe?*/
                    if (client.getMotDePasse().equals(mdpCrypt)) {

                        LangageController langageController = new LangageController();

                        switch (client.getLangueParDefaut()) {
                            case "fr":
                                langageController.setToFrancais();
                                break;
                            case "en":
                                langageController.setToEnglish();
                                break;
                            default:
                                langageController.setToAllemand();
                                break;
                        }
                        
                        isConnected = true;
                        clientActuel = client;
                        return "index?faces-redirect=true";
                    }
                } catch (NullPointerException ex) {
                    /* Le mot de passe ne correspond pas à celui de la base de donnée */
                    ResourceBundle bundle = ResourceBundle.getBundle("languages.lang");
                    FacesMessage fm = new FacesMessage(bundle.getString("mauvaisMDP"));
                    FacesContext.getCurrentInstance().addMessage(null, fm);
                }
            }

        } catch (NullPointerException ex) {
            /* L'adresse Mail n'existe pas dans la base de donnée */
            ResourceBundle bundle = ResourceBundle.getBundle("languages.lang");
            FacesMessage fm = new FacesMessage(bundle.getString("erreurEmail"));
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        return null;

    }

    public String deconnection() {
        isConnected = false;
        client = new ModelClient();
        clientActuel = new ModelClient();
        return "index?faces-redirect=true";
    }

}
