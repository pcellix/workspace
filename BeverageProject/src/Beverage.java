
public abstract class Beverage {
	String description = "Unknown beverage";
	private boolean bigSize = false;
	
	public void setSize(boolean makeSize){
		this.bigSize = makeSize;				
	}
	
	public boolean getSize(){
		return bigSize;
	}
	
	public String getDescription(){
		return description;
	}
	
	public abstract double cost();
}
