
public abstract class  Duck {

	FlyBehavior flyBehavior;
	
	public Duck(){
		
	}
	
	public abstract void display();
	
	public void performFly(){
		
		flyBehavior.fly();
		
	}
	
	public void swim(){
		
		System.out.println("Plywam sobie");
		
	}
	
	public void setFlyBehavior(FlyBehavior fb){
		
		this.flyBehavior = fb;
		
	}
	
	public FlyBehavior getFlyBehavior(){
		
		return this.flyBehavior;
		
	}
	
	
	
}
