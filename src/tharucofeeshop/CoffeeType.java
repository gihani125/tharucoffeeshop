package tharucofeeshop;

public enum CoffeeType {
	
	HOTMILK(5.0),
	CHOCOMILK(5.5),
	VANILAFLAVOURED(4.3),
	COCOAFLAVOURED(4.7);	
	
	private double cost ;		
	
	private CoffeeType(double cost){
		this.cost = cost;
	}
	public double cost(){
		return this.cost;
	}

}
