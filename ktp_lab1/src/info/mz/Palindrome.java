package info.mz;

public class Palindrome {

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i] + " " + isPalindrome(args[i]));
		}
	}
	
	public static String reverseString(String s) {
		String a = "";
		for (int i = s.length() - 1; i > -1; i--) {
			a += s.charAt(i);
		}
		return a;
	}
	static boolean isPalindrome(String s) {
		if (s.equals(reverseString(s))) return true;
		return false;
	}
}