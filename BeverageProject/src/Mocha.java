
public class Mocha extends CondimentDecorator {
	Beverage beverage;
	
	public Mocha(Beverage beverage){
		this.beverage = beverage;
	}
	
	public String getDescription(){
		return beverage.getDescription() + "Mocha";
	}
	
	public double cost(){
		if(beverage.getSize() == false)
			return .20 + beverage.cost();
		else
			return 0.40 + beverage.cost();
	}
	
}
