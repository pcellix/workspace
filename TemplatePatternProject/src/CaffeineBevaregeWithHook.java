
public abstract class CaffeineBevaregeWithHook {
	
	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		if(customerWantsCondiments()) {
		addCondiments();
		}
	}
	
	abstract void brew();
	
	abstract void addCondiments();
    
	void boilWater() {
		System.out.println("Boiling water");
	}
	
	void pourInCup() {
		System.out.println("Pouring in a cup");
	}
	
	boolean customerWantsCondiments() {
		return true;
	}

}
