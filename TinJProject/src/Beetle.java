
public class Beetle extends Insect {
	private int k = printInit("Beetle k jest zainicjowana");
	
	public Beetle() { 
		System.out.println("k" + k + "j = "  +j);
		
	}
	
	private static int x2 = printInit("static x2 Beetle x2 jest zainicjalizowana");
	
	public static void main(String[] args) {
		System.out.println("Konstruktor Beetle");
		Beetle b = new Beetle();
	}
	

}
