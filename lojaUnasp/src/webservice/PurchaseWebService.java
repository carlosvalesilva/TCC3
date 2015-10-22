package webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;

import dao.BookDAO;
import dao.PurchaseDAO;
import entity.Book;
import entity.Purchase;
import entity.User;

@Path("/purchase")
@Produces("application/json")
public class PurchaseWebService {

	@EJB
	private PurchaseDAO purchaseDAO;
	
	@EJB
	private BookDAO bookDAO;

	@Path("/list")
	@GET 	
	public String getAllPurchases() throws Exception{
		List<Purchase> purchases = purchaseDAO.getPurchases();
		System.out.println(purchases.get(0).getBooks());
		Gson gson = new Gson();
		return gson.toJson(purchases);
	}

	@Path("/list/{id}")
	@GET
	@Produces("application/json")
	public String getPurchase(@PathParam("id") Long id){
		Purchase p = purchaseDAO.find(id);
		Gson gson = new Gson();
		return gson.toJson(p);
	}
	
	@Path("/populate")
	@GET
	@Consumes("application/json")
	public void setBook() throws Exception {
		/*
		Gson gson = new Gson();
		Purchase p =  gson.fromJson(json, Purchase.class);
		*/
		Purchase p = new Purchase();
		p.setUser(new User("plucena@gmail.com", "lalala", "Rua X"));
		p.addBook(new Book("Deitel",  10,  "Alta Vista",  "Java how to program"));
		p.addBook(new Book("Alves",   15,  "Alta Vista",  "PHP how to program"));
		purchaseDAO.addPurchase(p);
	}
	
	@Path("/add")
	@POST
	@Consumes("application/json")
	public void setBook(String json) throws Exception {
		
		Gson gson = new Gson();
		Purchase p =  gson.fromJson(json, Purchase.class);
		//p.setBooks(bookDAO.cloneBooks(p.getBooks()));		
		//debug
		System.out.println(p.getId());
	//	p.getBooks().forEach(book -> System.out.println(book.getAuthor() + ":" + book.getTitle()  ));

		purchaseDAO.addPurchase(p);
	}
	
	/*
	@Path("/createform")
	@GET
	public void createBook(@QueryParam("id") String id,
			@QueryParam("author") String author, 
			@QueryParam("price") Float price,
			@QueryParam("publisher") String publisher,
			@QueryParam("title") String title)
			throws Exception {
		    Purchase p =  new Book(author, id, price, publisher, title); 
            bookDAO.addBook(b);
	}
	*/
	
	}
