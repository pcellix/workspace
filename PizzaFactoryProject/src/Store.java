
public abstract class Store {
	
	Product product;
	
	public abstract Product createPizza(String productType);
	
	public void  orderPizza(String productType){
		createPizza(productType);
		
	}
	
}
