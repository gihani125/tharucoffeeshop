package tharucofeeshop;

import java.util.HashMap;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;



@Singleton
@Path("/OrderService")
public class OrderService {
	
	Logger logger = Logger.getLogger(OrderService.class.toString());	
	DataFactory factory = DataFactory.getInstance();
	Queue<Order> orderQueue = factory.getQueue();
	HashMap<Integer,Order> orderMap = factory.getMap();
	Barista barista = new Barista(orderQueue);
	
	
	
	@GET
	@Path("/orders")
	@Produces(MediaType.APPLICATION_XML)
	public Order makeOrder(@Context HttpServletResponse response){
		Order order = new Order();
		order.setId(1000);
		order.setType(CoffeeType.CHOCOMILK);
		logger.info("OrderService : factory : "+factory);
		logger.info("OrderService : "+order);
		orderQueue.enque(order);
		orderMap.put(order.getId(), order);
		response.setHeader("Owner", "Tharuka");
		return order;
	}
	
	
	@PostConstruct
	public void init(){
		barista.start();	
		logger.info("Barista Thread Started");
	}
		
	
	
}
