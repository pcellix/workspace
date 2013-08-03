public class Main {
	public static void main(String[] args) {
		
        char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e',
			    'i', 'n', 'a', 't', 'e', 'd' };
        char[] copyTo = new char[7];

		int[] anArray= {1,2};
		anArray[1]=111;
		
		System.arraycopy(copyFrom, 2,copyTo, 0, 7);
		System.out.println(copyTo);
		
		
	}
}
