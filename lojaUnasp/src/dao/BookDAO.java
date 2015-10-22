package dao;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import entity.Book;

@Stateful
public class BookDAO {

	 @PersistenceContext(unitName = "livraria")
	 EntityManager entityManager;

	 public BookDAO(){
	 }
	 
	 public Book findBook(Long id) throws Exception {
	           return entityManager.find(Book.class, id);
	  }
	 
	 public List<Book> cloneBooks(List<Book> books) throws Exception {
		 List<Book> temp = new LinkedList<Book>();
		 
		 for(Book b: books) {
			 Book b1 = this.findBook(b.getId());
			temp.add(b1);
		 }
		 return temp;
	 }
	 
	    public void addBook(Book book) throws Exception {
	        entityManager.merge(book);
	    }

	    public void deleteBook(Book book) throws Exception {
	        entityManager.remove(book);
	    }

	    
	    public List<Book> getBooks() throws Exception {
	    	System.out.print(entityManager == null);
            CriteriaQuery<Book> cq = entityManager.getCriteriaBuilder().createQuery(Book.class);
            cq.select(cq.from(Book.class));
            return entityManager.createQuery(cq).getResultList();
	    }
	    
	    
	    

}	
