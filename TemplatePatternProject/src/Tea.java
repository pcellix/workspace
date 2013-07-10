
public class Tea extends CaffeineBevarage {

	@Override
	public void brew() {
		System.out.println("Steeping teabag");
	}
	
	@Override
	public void addCondiments() {
		System.out.println("Adding lemon");
	}


}
