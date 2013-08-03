public class Main {

	  	
	  
	  
	public static void main(String[] args) {

		Beverage latte = new Latte();
		latte.setMilk();
		//latte.setSoy();
		System.out.println(latte.cost());
	}

}
