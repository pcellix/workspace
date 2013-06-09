
public class SubwayStore extends Store {

	Product product;
		
	public Product createPizza(String name){
		PizzaIngredientFactory ingredientFactory = new Subway();
		Product product = null;
		
		if (name.equals("doughwithsauce")){
			product = new DoughWithSauce(ingredientFactory);
		}
		
		product.prepare();
		
		return product;
	}


}
