package entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name="Purchase.findAll", query="SELECT p FROM Purchase p")

public class Purchase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PURCHASE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	 
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_fk")
    User user;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable
	 (
	      name="PURCHASE_BOOK",
	      joinColumns={ @JoinColumn(name="PURCHASE_ID", referencedColumnName="PURCHASE_ID") }
	  )
	List<Book> books = new LinkedList<Book>();
    
    
    public void addBook(Book b) {
    	this.books.add(b);
    }
    
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Purchase(){
		
	}
	
	
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
