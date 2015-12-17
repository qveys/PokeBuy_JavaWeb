
package controller;

import business.PokemonSessionBeanLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import model.ModelClient;
import model.ModelCommande;
import model.ModelLigneCommande;
import model.ModelPokemon;

@Named(value = "panierController")
@SessionScoped
public class PanierController implements Serializable {
    @EJB
    private PokemonSessionBeanLocal pokemonSessionBean;
    
    private ModelCommande commande;
    private HashMap<Integer, ModelLigneCommande> hashMapPanier;
    private int iLigneCommande;
    private double totalCommande;
    
    public PanierController() {
    }
    
    @PostConstruct
    public void init() {
        commande = new ModelCommande(new Date(), new Date(), null);
        hashMapPanier = new HashMap<>();
        iLigneCommande = 1;
    }

    public PokemonSessionBeanLocal getPokemonSessionBean() {
        return pokemonSessionBean;
    }

    public void setPokemonSessionBean(PokemonSessionBeanLocal pokemonSessionBean) {
        this.pokemonSessionBean = pokemonSessionBean;
    }

    public ModelCommande getCommande() {
        return commande;
    }

    public void setCommande(ModelCommande commande) {
        this.commande = commande;
    }

    public HashMap<Integer, ModelLigneCommande> getHashMapPanier() {
        return hashMapPanier;
    }

    public void setHashMapPanier(HashMap<Integer, ModelLigneCommande> hashMapPanier) {
        this.hashMapPanier = hashMapPanier;
    }

    public int getiLigneCommande() {
        return iLigneCommande;
    }

    public void setiLigneCommande(int iLigneCommande) {
        this.iLigneCommande = iLigneCommande;
    }

    public double getTotalCommande() {
        setTotalCommande(calculTotalPanier());
        return totalCommande;
    }

    public void setTotalCommande(double totalCommande) {
        this.totalCommande = totalCommande;
    }
    
    public double calculTotalArticle(ModelLigneCommande ligne) {
        return (ligne.getPrixUnitaire() * ligne.getQuantite());
    }
    
    public double calculTotalPanier() {
        double total = 0;
        for(Integer key : hashMapPanier.keySet()) {
            total += calculTotalArticle(hashMapPanier.get(key));
        }
        return total;
    }
    
    public double dixPourCentTotal() {
        return ((calculTotalPanier()/100.0) * 10);
    }
    
    public ArrayList<ModelLigneCommande> getPanier() {
        ArrayList<ModelLigneCommande> panier = new ArrayList<>(hashMapPanier.values());

        Collections.sort(panier, (ModelLigneCommande o1, ModelLigneCommande o2) -> o1.getNumLigne() - o2.getNumLigne());

        return panier;
    }
    
    public boolean isEmptyListPanier() {
        return hashMapPanier.isEmpty();
    }
    
    public void getAjoutPanier(ModelPokemon currentPokemon, int quantite) {
        if (!hashMapPanier.isEmpty() && hashMapPanier.containsKey(currentPokemon.getIdPokemon())) {
            int nouvelleQuantite = hashMapPanier.get(currentPokemon.getIdPokemon()).getQuantite() + quantite;
            hashMapPanier.get(currentPokemon.getIdPokemon()).setQuantite(nouvelleQuantite);
        } else {
            ModelLigneCommande newLigne = new ModelLigneCommande(commande, iLigneCommande, currentPokemon, quantite, currentPokemon.getPrix().doubleValue());
            hashMapPanier.put(currentPokemon.getIdPokemon(), newLigne);
            iLigneCommande++;
        }
    }
    
    public void articleEnPlus(ModelLigneCommande ligne) {
        ligne.setQuantite(ligne.getQuantite() + 1);
    }

    public void articleEnMoins(ModelLigneCommande ligne) {
        if (ligne.getQuantite() == 1) {
            hashMapPanier.remove(ligne.getPokemon().getIdPokemon());
            iLigneCommande = 1;
            for (Integer key : hashMapPanier.keySet()) {
                hashMapPanier.get(key).setNumLigne(iLigneCommande);
                iLigneCommande++;
            }
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("panier.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ligne.setQuantite(ligne.getQuantite() - 1);
        }
    }

     public String enregistrerCommande(ModelClient client) {
        
        Calendar dateDuJour = Calendar.getInstance();
        Date dateCommande = dateDuJour.getTime();
        dateDuJour.add(Calendar.DAY_OF_MONTH, 7);
        Date dateLivraison = dateDuJour.getTime();
        
        ModelCommande newCommande = new ModelCommande(dateCommande, dateLivraison, client);
        
        double coutTotal = calculTotalPanier();
        
        for(ModelLigneCommande ligne : hashMapPanier.values()) {
            if (coutTotal > 1000)
                ligne.setPrixUnitaire(ligne.getPrixUnitaire()*0.90);
            
            ligne.setCommande(newCommande);
        }
        
        getPokemonSessionBean().enregistrerCommande(newCommande);
        getPokemonSessionBean().enregistrerLignes(hashMapPanier);
        
        hashMapPanier = new HashMap<>();
        
        return "confirmation?faces-redirect=true";
    }

}
