import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TeaWithHook extends CaffeineBevaregeWithHook {

	@Override
	public void brew() {
		System.out.println("Steeping teabag");
	}
	
	@Override
	public void addCondiments() {
		System.out.println("Adding lemon");
	}
		
	@Override 
	boolean customerWantsCondiments() {
		String answer = getUserInput();
		
		if(answer.toLowerCase().startsWith("y")) {
		return true;
		} else { 
			return false; 
		}	
	}
    
	private String getUserInput() {
		String answer = null;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			answer = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answer;
		
	}
	
}
