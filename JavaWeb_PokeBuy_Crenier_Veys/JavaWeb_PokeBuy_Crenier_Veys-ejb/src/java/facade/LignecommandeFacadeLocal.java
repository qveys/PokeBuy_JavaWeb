
package facade;

import entity.Lignecommande;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;
import model.ModelLigneCommande;

@Local
public interface LignecommandeFacadeLocal {

    void create(Lignecommande lignecommande);

    void edit(Lignecommande lignecommande);

    void remove(Lignecommande lignecommande);

    Lignecommande find(Object id);

    List<Lignecommande> findAll();

    List<Lignecommande> findRange(int[] range);

    int count();

    void enregistrerLignes(HashMap<Integer, ModelLigneCommande> hashMapPanier);
    
}
