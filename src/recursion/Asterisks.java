package recursion;

public class Asterisks {

	public static void asterisks(int x) {
		// base case, terminating case
		if(x <= 0) {
			return;
		}
		System.out.print("*");
		// recurse, modification
		asterisks(x - 1);
		System.out.print("!");
	}
	
	public static void main(String[] args) {
		asterisks(10);
	}

}
