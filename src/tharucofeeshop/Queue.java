package tharucofeeshop;

import java.util.LinkedList;

public class Queue<T>  {

	private LinkedList<T> queue = new LinkedList<T>();
	
	public void enque(T object){
		
		queue.addLast(object);
		
	}
	
	public T dequeue(){		
		
		return queue.removeFirst();
		
	}
	
	public int getSize(){
		return queue.size();
	}
	

}
