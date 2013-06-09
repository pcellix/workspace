
public class Subway implements PizzaIngredientFactory {
	
	public Dough createDough(){
		return new ThinDough();
	}
	
	public Sauce createSauce(){
		return new KetchupSauce();
	}
}
