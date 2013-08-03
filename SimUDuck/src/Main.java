
public class Main {
	
    public static void main(String[] args) {
		
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
		model.display();
		System.out.println("Hello World!"); // Display the string.
    }
	
// public static void Main(String[] args){
//	 

//	 
// };
}
