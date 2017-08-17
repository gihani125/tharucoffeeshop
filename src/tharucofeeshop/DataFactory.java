package tharucofeeshop;

import java.util.HashMap;

public class DataFactory {
	
	Queue<Order> orderQueue;
	HashMap<Integer,Order> orderMap;
	
	private DataFactory(){
		orderQueue = new Queue<Order>();
		orderMap = new HashMap<Integer,Order>();
	}
	
	static DataFactory object = new DataFactory();
	
	public static DataFactory getInstance(){
		return object;	
	}
	
	public void addToQeue(Order order){
		orderQueue.enque(order);		
	}
	public Order removeFromQueue(){
		return orderQueue.dequeue();
	}
	
	public void addToMap(Order order){
		orderMap.put(order.getId(), order);
	}
	
	public Order removeFromMap(Integer orderId){
		return orderMap.remove(orderId);
	}
	
	public Order getFromMap(Integer orderId){
		return orderMap.get(orderId);
	}
	public Queue getQueue(){
		return orderQueue;
	}
	public HashMap<Integer,Order> getMap(){
		return orderMap;
	}
	
	
	
	
}
