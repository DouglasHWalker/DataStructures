package recursion;

public class Palindrome {

	public static boolean isPalindrome(String string) {
		// terminating case
		if(string.length() == 0 || string.length() == 1) {
			return true;
		}
		// base case
		if(string.charAt(string.length()-1) != string.charAt(0)) {
			return false;
		}
		// modification
		String subString = string.substring(1, string.length() -1);
		// recursive call
		return isPalindrome(subString);
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("Hello"));
		System.out.println(isPalindrome("WhimmihW"));
		System.out.println(isPalindrome("WhimfmihW"));
		System.out.println(isPalindrome("WhimfgmihW"));
		
	}

}
