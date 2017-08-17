package tharucofeeshop;
 
import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="order" ) 
public class Order  {
	
	private int id;
	private CoffeeType type;
	private double cost;
	private boolean paid;
	private boolean modifiable;
	
	public Order(){
		paid = false;
		modifiable  = true;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	@XmlElement
	public int getId(){
		return this.id;
	}
	
	public void setType(CoffeeType type){
		this.type = type;
		this.cost = type.cost();
	}	
	
	@XmlElement
	public CoffeeType getType(){
		return this.type;
	}
		
	@XmlElement
	public double getCost(){
		return this.cost;
	}
	
	public void setPaid(boolean val){
		paid = val;
	}
	public void setModifiable(boolean val){
		modifiable = val;
	}
	public boolean getPaid(){
		return this.paid;
	}
	public boolean getModifiable(){
		return this.modifiable;
	}

}
