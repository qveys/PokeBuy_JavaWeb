/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Promotion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author quentinveys
 */
@Stateless
public class PromotionFacade extends AbstractFacade<Promotion> implements PromotionFacadeLocal {
    @PersistenceContext(unitName = "JavaWeb_PokeBuy_Crenier_Veys-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PromotionFacade() {
        super(Promotion.class);
    }
    
}
