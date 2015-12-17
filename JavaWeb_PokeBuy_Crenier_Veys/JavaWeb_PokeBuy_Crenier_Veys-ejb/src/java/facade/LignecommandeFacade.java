/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Lignecommande;
import entity.LignecommandePK;
import entity.Pokemon;
import java.math.BigDecimal;
import java.util.HashMap;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.ModelLigneCommande;

/**
 *
 * @author quentinveys
 */
@Stateless
public class LignecommandeFacade extends AbstractFacade<Lignecommande> implements LignecommandeFacadeLocal {
    @PersistenceContext(unitName = "JavaWeb_PokeBuy_Crenier_Veys-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LignecommandeFacade() {
        super(Lignecommande.class);
    }

    @Override
    public void enregistrerLignes(HashMap <Integer, ModelLigneCommande> hashMapPanier) {
        Query query;
        query = getEntityManager().createNamedQuery("Commande.lastNumCommande");
        
        Integer numCommande = (Integer) query.getSingleResult();
        for(ModelLigneCommande l : hashMapPanier.values()) {
            
            Short qte =  Integer.valueOf(l.getQuantite()).shortValue();
            
            BigDecimal prixUnit = BigDecimal.valueOf(l.getPrixUnitaire());
            
            LignecommandePK newPK = new LignecommandePK(numCommande, l.getNumLigne());
            Lignecommande newLigne = new Lignecommande();
            
            Pokemon pokemon = new Pokemon(l.getPokemon().getIdPokemon(), l.getPokemon().getCheminImg(), l.getPokemon().getTaille(), l.getPokemon().getPoids(), l.getPokemon().getPointsVie(), l.getPokemon().getPointsAttaque(), l.getPokemon().getPointsDefense(), l.getPokemon().getPointsAttaqueSpeciale(), l.getPokemon().getPointsDefenseSpeciale(), l.getPokemon().getPointsVitesse(), l.getPokemon().getPrix());
            newLigne.setLignecommandePK(newPK);
            newLigne.setIdpokemon(pokemon);
            newLigne.setPrixunitaire(prixUnit);
            newLigne.setQuantite(qte);
            getEntityManager().persist(newLigne);
        }
    }
    
}
