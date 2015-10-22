package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import entity.Purchase;

@Stateless
public class PurchaseDAO {

	@PersistenceContext(unitName = "livraria")
    private EntityManager entityManager;

    public void addPurchase(Purchase buy) throws Exception {
    	try {
    		entityManager.merge(buy);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }

    public void deletePurchase(Purchase buy) throws Exception {
        entityManager.remove(buy);
    }

    public List<Purchase> getPurchases() throws Exception {

        CriteriaQuery<Purchase> cq = entityManager.getCriteriaBuilder().createQuery(Purchase.class);
        cq.select(cq.from(Purchase.class));
        return entityManager.createQuery(cq).getResultList();
    }

    public Purchase find(Long id) {
    	return entityManager.find(Purchase.class, id);
    }
	
	
}
