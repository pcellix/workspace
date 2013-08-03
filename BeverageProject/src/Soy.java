public class Soy extends CondimentDecorator {

	Beverage beverage;

	public Soy(Beverage beverage) {
		this.beverage = beverage;

	}

	public String getDescription() {
		return this.description + "Soy";

	}
	
	public double cost(){
		return .12 + beverage.cost();
		
	}
}
