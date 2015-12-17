
package model;

import java.util.Date;

public class ModelCommande {
    private Integer numCommande;
    private Date dateCommande;
    private Date dateLivraison;
    private ModelClient client;

    public ModelCommande(Date dateCommande, Date dateLivraison, ModelClient client) {
        this.dateCommande = dateCommande;
        this.dateLivraison = dateLivraison;
        this.client = client;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public ModelClient getClient() {
        return client;
    }

    public void setClient(ModelClient client) {
        this.client = client;
    }
    
}
