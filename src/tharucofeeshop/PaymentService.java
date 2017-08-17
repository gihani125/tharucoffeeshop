package tharucofeeshop;

import java.util.HashMap;
import java.util.logging.Logger;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Singleton
@Path("/PaymentService")
public class PaymentService {

	DataFactory factory = DataFactory.getInstance();
	Queue<Order> orderQueue = factory.getQueue();
	HashMap<Integer,Order> orderMap = factory.getMap();
	Logger log = Logger.getAnonymousLogger();
	
	@GET
	@Path("/order/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Order pay(@PathParam("id") String id){
		log.warning(id);
		Order order ;
		try{
			order = factory.getFromMap(Integer.parseInt(id));
			log.info("Payment Service : factory : "+factory);
			log.info("Payment Service : "+order.toString());
			order.setPaid(true);
			return order;
		}catch(NullPointerException e){
			log.info(e.toString());
		}
		return null;		
		
	}
	
	
	@GET
	@Path("{id}")
	public Response getOrderId(@PathParam("id") String id){
		return Response.status(200).entity("Order id : "+id).build();
	}
	

}
