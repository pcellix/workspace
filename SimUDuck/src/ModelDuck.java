
public class ModelDuck  extends Duck{

	public ModelDuck(){
		
		flyBehavior = new FlyNoWay();
	}
	
	public void display(){
		
		System.out.println("Jestem model duck ");
	}
	
}
