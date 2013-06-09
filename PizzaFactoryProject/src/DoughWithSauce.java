
public class DoughWithSauce extends Product {

 PizzaIngredientFactory ingredientFactory;
 
 	Dough dough;
 	Sauce sauce;
 	
 
 	DoughWithSauce(PizzaIngredientFactory pizzaIngredientFactory){
 		this.ingredientFactory = pizzaIngredientFactory;
 		
 	}
 	
 	public void prepare(){
 		dough = ingredientFactory.createDough();
 		sauce = ingredientFactory.createSauce();
 	}
	
}
