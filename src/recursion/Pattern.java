package recursion;

public class Pattern {

		// Precondition: n > 0;

		// Postcondition: The output consists of lines of integers. The first line

		// is the number n. The next line is the number 2n. The next line is

		// the number 4n, and so on until you reach a number that is larger than

		// 4242. This list of numbers is then repeated backward until you get back

		// to n.

		/*
		 * Example output with n = 840:
		 * 
		 * 840
		 * 
		 * 1680
		 * 
		 * 3360
		 * 
		 * 6720
		 * 
		 * 6720
		 * 
		 * 3360
		 * 
		 * 1680
		 * 
		 * 840
		 */

	public static void pattern(int n) {
		// base case
		System.out.println(n);
		// terminating case
		if(n > 4242) {
			System.out.println(n);
			return;
		}
		// modify recurse
		pattern(n*2);
		System.out.println(n);
		
	}
	
	public static void main(String[] args) {
		pattern(666);
	}

}
