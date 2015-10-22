package webservice;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import dao.BookDAO;
import dao.CartDAO;
import entity.Cart;
import entity.Purchase;

@Path("/cart")
@Produces("application/json")

public class CartWebService {
	
	@EJB
	private CartDAO cartDAO;



	@Path("/list/{user}")
	@GET
	@Produces("application/json")
	public String getPurchase(@PathParam("user") String user){
		Cart p = cartDAO.find(user);
		Gson gson = new Gson();
		return gson.toJson(p);
	}
	
	
}
