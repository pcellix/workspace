
public abstract class Beverage {
	private boolean milk = false;
	private boolean whip = false;
	private boolean soy = false;
	
	public void setMilk(){
		this.milk = true;
	}
	
	public void setSoy(){
		this.soy = true;
	}
	
	public void setWhip(){
		this.whip = true;
	}
	
	public boolean getMilk(){
		return this.milk;
	}
	
	public boolean getSoy(){
		return this.soy;
	}
	
	public boolean getWhip(){
		return this.whip;
	}
	
	
	public boolean hasMilk(){
		if(this.getMilk() == true)
			return true;
		else
			return false;
	}
	
	public boolean hasWhip(){
		if(this.getWhip() == true)
			return true;
		else
			return false;
	}
	
	public boolean hasSoy(){
		if(this.getSoy() == true)
			return true;
		else
			return false;
	}
	
	
	public double cost() {
		double condimentsCost = 0;
		
		if(hasMilk()){
			condimentsCost += 0.4;
		}
		
		if(hasWhip()){
			condimentsCost += 0.5;
		}
		
		if(hasSoy()){
			condimentsCost += 0.6;
		}
		
		return condimentsCost;
	}

}
