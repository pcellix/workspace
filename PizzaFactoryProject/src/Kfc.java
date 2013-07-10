
public class Kfc implements PizzaIngredientFactory {
	
	public Dough createDough(){
		return new ThickDough();			
	}
	
	public Sauce createSauce(){
		return new KetchupSauce();
	}
}
