
public class StarbuzzCoffee {
	public static void main(String[] args){
		Beverage espresso = new Espresso();
		Beverage condiments = new Mocha(new Soy(new Mocha(new Espresso())));
		System.out.println(condiments.cost());
		
		
	}
}
