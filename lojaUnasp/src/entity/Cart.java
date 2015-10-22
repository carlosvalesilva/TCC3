package entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import dao.BookDAO;

@Entity
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "user_fk")
	private String userEmail;
	
	/*
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable
	 (
	      name="CART_BOOK",
	      joinColumns={ @JoinColumn(name="CART_ID", referencedColumnName="CART_ID") }
	  )
	*/  
	private List<Book> books = new LinkedList<Book>();
	
	public Cart() {}
	
	
	public Cart(String userEmail){
		this.userEmail = userEmail;
	}

	public void addBook(Book b) throws Exception{
		
		this.books.add(b);
	}
	
	public void removeBook(Book b) throws Exception{
		this.books.remove(b);
	}
	
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	

}
