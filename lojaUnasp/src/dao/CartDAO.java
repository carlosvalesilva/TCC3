package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import entity.Cart;
import entity.Purchase;


@Stateless
public class CartDAO {

	 @PersistenceContext(unitName = "livraria")
	 private EntityManager entityManager;

	 
	   public Cart find(String user){
		   return null;
	   }
	 
	    public void saveCart(Cart c) throws Exception {
	    	try {
	            //entityManager.getTransaction().begin();
	    		entityManager.persist(c);
	    		//entityManager.getTransaction().commit();
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    }


	    public List<Cart> retrieveCart(String email) throws Exception {
         /*
	        CriteriaQuery<Purchase> cq = entityManager.getCriteriaBuilder().createQuery(Purchase.class);
	        cq.select(cq.from(Purchase.class));
	        return entityManager.createQuery(cq).getResultList();
	      */  
	    	return null;
	    }

   
	
}
