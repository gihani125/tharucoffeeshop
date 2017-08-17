package tharucofeeshop;

import java.util.logging.Logger;

public class Barista extends Thread {
	
	private Queue<Order> orderQueue;
	private final long TIME_PERIOD = 1000; 
	private final long PROCESSING_TIME = 1000;	
	private Logger log;
	
	public Barista(Queue<Order> orderQueue){
		this.orderQueue = orderQueue;
		log = Logger.getLogger(Barista.class.toString());
	}
	
	public void run(){
		
		while(true){
			
			try{
				if(orderQueue.getSize() == 0){
					Thread.sleep(TIME_PERIOD);
				}							
			}catch(InterruptedException e){
				log.warning(e.toString());			
			}
			
			if(orderQueue.getSize() != 0){
				
				//States currentState = States.ORDERCHOSEN;				
				Order currentOrder = orderQueue.dequeue();
				currentOrder.setModifiable(false);
				log.info("Processing Order : "+currentOrder.getId());
				try{
					Thread.sleep(PROCESSING_TIME);
				}catch(InterruptedException e){
					log.warning(e.toString());	
				}
				
				//currentState = States.DRINKMADE;
				log.info("Waiting for Payment for "+currentOrder.getId());
				while(!currentOrder.getPaid()){
					try{
						Thread.sleep(TIME_PERIOD);	
					}catch(InterruptedException e){
						log.info(e.toString());
					}
					
				}//Barista waits here until payment is received
				log.info("Payment recived for "+currentOrder.getId());			
				
				
				
			}
			
			
		}
			
		
	}


	

}
